package com.hibernate.one_to_one_uni.models;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Orders {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="product")
    private String product;

    @Column(name = "cost")
    private String cost;

    public Orders() {
    }

    public Orders(String product, String cost) {
        this.product = product;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}
