package com.hibernate.one_to_many.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "company_name")
    private String name;

    @Column(name = "company_detail")
    private CompanyDetail companyDetail;

    @Column(name = "company_product")
    private List<Product> productList;

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
