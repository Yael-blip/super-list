package com.example.superlist;

public class Product {
    private String name;
    private boolean in_basket;
    private int last_best_price;
    private String description;
    private String category;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIn_basket() {
        return in_basket;
    }

    public void setIn_basket(boolean in_basket) {
        this.in_basket = in_basket;
    }


    public int getLast_best_price() {
        return last_best_price;
    }

    public void setLast_best_price(int last_best_price) {
        this.last_best_price = last_best_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}




