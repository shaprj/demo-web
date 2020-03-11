package com.shaprj.spring.demoweb.controller.admin;
/*
 * Created by O.Shalaevsky on 04.03.2020
 */

import com.shaprj.spring.demoweb.model.admin.Contract;
import com.shaprj.spring.demoweb.model.admin.Product;
import com.shaprj.spring.demoweb.model.admin.User;
import com.shaprj.spring.demoweb.service.ContractJPAService;
import com.shaprj.spring.demoweb.service.ContractService;
import com.shaprj.spring.demoweb.service.ProductService;
import com.shaprj.spring.demoweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    private static final int DEFAULT_START_PAGE = 1;
    private static final int DEFAULT_PAGE_SIZE = 15;

    private String currentFilter = "";

    @Autowired
    private ContractService contractService;

    @Autowired
    private ContractJPAService contractJPAService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    private ModelAndView getAll(Model model) {

        setContractsModel(model);

        return new ModelAndView("contracts", model.asMap());
    }

    @RequestMapping(value = "/all/paginated", method = RequestMethod.GET)
    private ModelAndView getAllPaginated(Model model,
                                         @RequestParam("page") Optional<Integer> page,
                                         @RequestParam("size") Optional<Integer> size) {

        setContractsPaginatedWithFilterModel(model, page, size);

        setContractsModelBase(model);

        return new ModelAndView("pcontracts", model.asMap());
    }

    @RequestMapping(value = "/all/filtered", method = RequestMethod.POST)
    private ModelAndView getAllFilteredPost(Model model,
                                            @ModelAttribute("filter") String filter) {

        currentFilter = filter;

        setContractsPaginatedWithFilterModel(model, Optional.of(DEFAULT_START_PAGE), Optional.of(DEFAULT_PAGE_SIZE));

        setContractsModelBase(model);

        return new ModelAndView("pcontracts", model.asMap());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    private void createContract(@ModelAttribute("start_date") String startDateTime,
                                @ModelAttribute("end_date") String endDateTime,
                                @ModelAttribute("user") Long userId,
                                @ModelAttribute("product") Long productId) {

        User user = userService.findById(userId).orElseThrow();
        Product product = productService.findById(productId).orElseThrow();

        LocalDate localDateStart = LocalDate.parse(startDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate localDateEnd = LocalDate.parse(endDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Contract contract = new Contract(localDateStart, localDateEnd, user, product);
        contractService.save(contract);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    private void updateContract(@ModelAttribute("id") Long id,
                                @ModelAttribute("start_date") String startDateTime,
                                @ModelAttribute("end_date") String endDateTime,
                                @ModelAttribute("user") Long userId,
                                @ModelAttribute("product") Long productId) {

        User user = userService.findById(userId).orElseThrow();
        Product product = productService.findById(productId).orElseThrow();

        LocalDate localDateStart = LocalDate.parse(startDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate localDateEnd = LocalDate.parse(endDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Contract contract = new Contract(id, localDateStart, localDateEnd, user, product);
        contractService.save(contract);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    private void deleteContract(@ModelAttribute("id") Long id) {
        contractService.deleteById(id);
    }

    private void setContractsModelBase(Model model) {

        List<User> userList = userService.findAll();
        List<Product> productList = productService.findAll();

        model.addAttribute("navMenuItems", MainController.navMenuItems);
        model.addAttribute("userList", userList);
        model.addAttribute("productList", productList);
    }

    private void setContractsModel(Model model) {

        setContractsModelBase(model);

        List<Contract> contractList = contractService.findAll();

        model.addAttribute("contractList", contractList);

    }

    private void setContractsPaginatedModel(Model model, Optional<Integer> page, Optional<Integer> size, List<Contract> contracts) {
        int currentPage = page.orElse(DEFAULT_START_PAGE);
        int pageSize = size.orElse(DEFAULT_PAGE_SIZE);

        Page<Contract> contractPage = contractService.
                findPaginated(PageRequest.of(currentPage - 1, pageSize), contracts);

        model.addAttribute("contractPage", contractPage);

        int totalPages = contractPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(calcLowerBound(currentPage, 3), calcUpperBound(currentPage, 3, totalPages))
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
    }

    private void setContractsPaginatedWithFilterModel(Model model, Optional<Integer> page, Optional<Integer> size) {

        setContractsPaginatedModel(model,
                page,
                size,
                currentFilter.isEmpty() ? contractService.findAll() : contractJPAService.findAll(contractSpecification));
    }

    private Specification<Contract> contractSpecification = ((root, query, cb) -> {
        if (currentFilter.matches("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")) {
            LocalDate localDate = LocalDate.parse(currentFilter, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return cb.or(cb.equal(root.get("startDate"), localDate), cb.equal(root.get("endDate"), localDate));
        } else if (currentFilter.matches("\\d{1,64}")) {
            return cb.equal(root.get("id"), Long.parseLong(currentFilter));
        } else {
            return cb.or(
                    cb.in(root.get("user")).value(getUserSubquery(query, cb)),
                    cb.in(root.get("product")).value(getProductSubquery(query, cb)));
        }

    });

    private Subquery<User> getUserSubquery(CriteriaQuery<?> query, CriteriaBuilder cb) {
        Subquery<User> userSubquery = query.subquery(User.class);
        Root<User> user = userSubquery.from(User.class);
        userSubquery.select(user)
                .distinct(true)
                .where(cb.like(user.get("name"), "%" + currentFilter + ""));
        return userSubquery;
    }

    private Subquery<Product> getProductSubquery(CriteriaQuery<?> query, CriteriaBuilder cb) {
        Subquery<Product> productSubquery = query.subquery(Product.class);
        Root<Product> product = productSubquery.from(Product.class);
        productSubquery.select(product)
                .distinct(true)
                .where(cb.like(product.get("name"), "%" + currentFilter + ""));
        return productSubquery;
    }

    private int calcLowerBound(int current, int delta) {
        return current - delta > 0 ? current - delta : DEFAULT_START_PAGE;
    }

    private int calcUpperBound(int current, int delta, int max) {
        return current + delta < max ? current + delta : max;
    }
}
