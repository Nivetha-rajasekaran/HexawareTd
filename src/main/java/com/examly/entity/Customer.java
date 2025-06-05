package com.examly.entity;

public class Customer {
    private int customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    
    public Customer(String name,String email,String phoneNumber,String password){
      
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.password=password;
    }
    public Customer(int customerId,String name,String email,String phoneNumber,String password){
        this.customerId=customerId;
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.password=password;
    }
    public int getCustomerID(){
        return customerId;
    }
    public String getname(){
        return name;
    }
    public String getemail(){
        return email;
    }
    public String getphNo(){
        return phoneNumber;
    }
    public String getpass(){
        return password;
    }
    public void setId(int id){
        this.customerId=id;
    }
    public void setname(String name){
        this.name=name;
    }
    public void setemail(String email){
        this.email=email;
    }
    public void setPh(String phNo){
        this.phoneNumber=phNo;
    }
    public void setpass(String password){
        this.password=password;
    }
}
