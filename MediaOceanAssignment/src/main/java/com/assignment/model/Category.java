package com.assignment.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORY", uniqueConstraints = {
        @UniqueConstraint(columnNames = "CATEGORY_ID"),
        @UniqueConstraint(columnNames = "CATEGORY_NAME")})
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private int categoryId;
    @Column(name = "TAX")
    private int taxPercent;
    @Column(name = "CATEGORY_NAME")
    private String categoryName;
    @OneToMany(mappedBy="category")
    private Set<Product> products;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(int taxPercent) {
        this.taxPercent = taxPercent;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
