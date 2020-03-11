/*
    Created by O.Shalaevsky on 29.02.2020
*/

package com.shaprj.spring.demoweb.model.admin;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_products_sequence")
    @SequenceGenerator(name = "s_products_sequence", sequenceName = "s_products_sequence", allocationSize = 1)
    private long id;

    private String name;

    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = ProductType.class)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    private BigDecimal price;

    public Product() {
    }

    public Product(long id, String name, String description, ProductType productType, BigDecimal price) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.productType = productType;
        this.price = price;
    }

    public Product(String name, String description, ProductType productType, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.productType = productType;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }
}
