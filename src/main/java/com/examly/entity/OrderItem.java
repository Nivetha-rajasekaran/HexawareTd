package com.examly.entity;

public class OrderItem {


 private int orderId;
 private int itemId;
 private int quantity;
 
 public OrderItem(int orderId,int itemId,int quantity){
 this.orderId=orderId;
 this.itemId=itemId;
 this.quantity=quantity;
 }
//orderId
public int getorderId(){
    return orderId;
}
public void getorderId(int orderId){
    this.orderId=orderId;
}
//itemid
public int getitemId(){
    return itemId;
}
public void getitemId(int itemId){
    this.itemId=itemId;
}
//quantity
public int getquantity(){
    return quantity;
}
public void getquantity(int quantity){
    this.quantity=quantity;
}

 
}
