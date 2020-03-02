/*
    Created by O.Shalaevsky on 29.02.2020
*/

package com.shaprj.spring.demoweb.model.admin;

import javax.persistence.*;

@Entity
@Table(name = "h_product_types")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="s_products_sequence")
    @SequenceGenerator(name="s_products_sequence", sequenceName="s_products_sequence", allocationSize=1)
    private long id;

    private String name;

    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString(){
        return name;
    }
}
