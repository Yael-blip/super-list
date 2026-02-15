package com.example.superlist;

public class supermarket {
    private String name;
    private String address;
    private String distance;
    private boolean is_favourite;
    private String icon;


    public supermarket(String name, String address, String distance, boolean is_favourite, String icon) {
        this.name = name;
        this.address = address;
        this.distance = distance;
        this.is_favourite = is_favourite;
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean getIs_favourite() {
        return is_favourite;
    }

    public void setIs_favourite(boolean is_favourite) {
        this.is_favourite = is_favourite;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
