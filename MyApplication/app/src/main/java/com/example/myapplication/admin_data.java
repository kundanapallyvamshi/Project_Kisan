package com.example.myapplication;

public class admin_data {

    String admin_id,password,mobile_number;
    public admin_data()
    {

    }
    public admin_data(String admin_id,String password,String mobile_number)
    {
        this.admin_id=admin_id;
        this.password=password;
        this.mobile_number=mobile_number;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile_number() {
        return mobile_number;
    }
}
