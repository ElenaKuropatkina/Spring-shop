package com.elenakuropatkina.controllers;

import com.elenakuropatkina.models.Brand;
import com.elenakuropatkina.models.Category;
import com.elenakuropatkina.models.Product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


public class ProductRepresent implements Serializable {

    private Long id;

    private String title;

    private BigDecimal price;

    private Category category;

    private Brand brand;

    public ProductRepresent() {
    }

    public ProductRepresent(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.brand = product.getBrand();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepresent that = (ProductRepresent) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
