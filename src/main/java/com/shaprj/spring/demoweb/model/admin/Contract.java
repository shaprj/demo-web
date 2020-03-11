/*
    Created by O.Shalaevsky on 01.03.2020
*/

package com.shaprj.spring.demoweb.model.admin;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "t_contracts")
public class Contract {

    public Contract() {
    }

    public Contract(LocalDate startDate, LocalDate endDate, User user, Product product) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.product = product;
    }

    public Contract(long id, LocalDate startDate, LocalDate endDate, User user, Product product) {
        this(startDate, endDate, user, product);
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_contracts_sequence")
    @SequenceGenerator(name = "s_contracts_sequence", sequenceName = "s_contracts_sequence", allocationSize = 1)
    private long id;

    @Column(name = "start_date_time")
    private LocalDate startDate;

    @Column(name = "end_date_time")
    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Product.class)
    @JoinColumn(name = "product_id")
    private Product product;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDateTime) {
        this.startDate = startDateTime;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDateTime) {
        this.endDate = endDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
