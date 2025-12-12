package com.example.superlist;

public class Product {
    private String name;
    private boolean in_basket;


    public Product(String name, boolean in_basket) {
        this.name = name;
        this.in_basket = in_basket;
    }

    public String getName() {
        return name;
    }

    public boolean isIn_basket() {
        return in_basket;
    }
}
