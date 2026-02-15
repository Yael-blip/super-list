package com.example.superlist;

import java.util.HashMap;

public class User {
    private String name;
    private String email;
    private String uId;

    public User(String uId) {
        this.uId = uId;
//        getUser(uId, new FB_control.UserCallback() {
//            @Override
//            public void onUserLoaded(HashMap<String, Object> userMap) {
//                name = String.valueOf(userMap.get("name"));
//                email =  String.valueOf(userMap.get("email"));
//            }
//            @Override
//            public void onError(Exception e) {
//                //Toast.makeText(this, "Error: " + e.getMessage(),
//                //        Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getuId() {
        return uId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }
}
