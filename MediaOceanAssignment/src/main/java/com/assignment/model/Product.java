package com.assignment.model;

import javax.persistence.*;


@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID", unique = true, nullable = false)
    private int productId;
    @ManyToOne
    @JoinColumn (name="CATEGORY_ID",referencedColumnName="CATEGORY_ID",nullable=false,unique=true)
    private Category category;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRODUCT_COST")
    private int productCost;
    @Transient
    private int quantityOfProduct;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductCost() {
        return productCost;
    }

    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }

    public int getQuantityOfProduct() {
        return quantityOfProduct;
    }

    public void setQuantityOfProduct(int quantityOfProduct) {
        this.quantityOfProduct = quantityOfProduct;
    }
}
