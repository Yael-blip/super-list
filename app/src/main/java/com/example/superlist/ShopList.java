package com.example.superlist;

public class ShopList {

    private String list_name;
    private int list_len;
    private String total_price;
    private int last_edit;

    private String icon;
    public ShopList(String list_name, int list_len, String total_price, int last_edit, String icon) {
        this.list_name = list_name;
        this.list_len = list_len;
        this.total_price = total_price;
        this.last_edit = last_edit;
        this.icon = icon;
    }
    public String getList_name() {
        return list_name;
    }
    public int getList_len() {
        return list_len;
    }
    public String getTotal_price() {
        return total_price;
    }
    public int getLast_edit() {
        return last_edit;
    }
    public String getIcon(){
        return icon;
    }
}