package com.example.myapplication.service;

import com.example.myapplication.model.Product;

import java.util.List;

public class Stock {
    private List<Product> products;

    public Stock(List<Product> products) {
        this.products = products;
    }

    public boolean addProduct(Product product) {

        boolean has = !products.contains(product);

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(product.getName())) {
                has = false;
                break;
            }
        }
        if (has) {
            products.add(product.Copy());
        }
        return has;
    }

    public String getProduct(String productName) {
        String ans = "ERROR404";

        for (Product product : products){
            if (product.getName().equals(productName)){
                ans = product.toString();
            }
        }

        return ans;
    }
}
