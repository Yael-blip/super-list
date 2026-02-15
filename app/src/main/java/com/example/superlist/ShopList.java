package com.example.superlist;

import java.util.ArrayList;

public class ShopList {

    private String list_id;
    private String list_name;
    private int list_len;
    private int total_price;
    private String last_edit;
    private String create_date;
    private String icon;

    public ShopList(String list_name, int list_len, int total_price, String last_edit, String icon) {
        this.list_name = list_name;
        this.list_len = list_len;
        this.total_price = total_price;
        this.last_edit = last_edit;
        this.icon = icon;
    }

    public ShopList(){

    }

    public String getList_name() {
        return list_name;
    }
    public int getList_len() {
        return list_len;
    }
    public int getTotal_price() {
        return total_price;
    }
    public String getLast_edit() {
        return last_edit;
    }
    public String getIcon(){
        return icon;
    }
    public String getList_id() {
        return list_id;
    }
    public String getCreate_date() {
        return create_date;
    }


    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
    public void setList_name(String list_name) {
        this.list_name = list_name;
    }
    public void setList_id(String list_id) {
        this.list_id = list_id;
    }
    public void setList_len(int list_len) {
        this.list_len = list_len;
    }
    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }
    public void setLast_edit(String last_edit) {
        this.last_edit = last_edit;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
}

