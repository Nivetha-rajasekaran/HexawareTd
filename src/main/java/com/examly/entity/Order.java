package com.examly.entity;

public class Order {
   private int orderId;
   private int customerId;
   private int restaurantId;
   private String orderStatus;
   private double totalPrice;
   private String deliveryAddress;

    public Order(int customerId,int restaurantId,String orderStatus,double totalPrice,String deliveryAddress){
     
       this.customerId=customerId;
       this.restaurantId=restaurantId;
       this.orderStatus=orderStatus;
       this.totalPrice=totalPrice;
       this.deliveryAddress=deliveryAddress;
    }
    public Order(int orderId,int customerId,int restaurantId,String orderStatus,double totalPrice,String deliveryAddress){
      this.orderId=orderId;
      this.customerId=customerId;
      this.restaurantId=restaurantId;
      this.orderStatus=orderStatus;
      this.totalPrice=totalPrice;
      this.deliveryAddress=deliveryAddress;
   }
  //orderId
  public int getorderId(){
    return orderId;
  }
  public void setorderId(int orderId){
    this.orderId=orderId;
  }
  //customerid
  public int getcustId(){
    return customerId;
  }
  public void setcustId(int customerId){
    this.customerId=customerId;
  }
  //resId
  public int getrestId(){
    return restaurantId;
  }
  public void setrestId(int restaurantId){
    this.restaurantId=restaurantId;
  }
  //orderstatus
  public String getorderStatus(){
    return orderStatus;
  }
  public void setorderStatus(String orderStatus){
    this.orderStatus=orderStatus;
  }
  //totalPrice
  public double gettotalPrice(){
    return totalPrice;
  }
  public void settotalPrice(int totalPrice){
    this.totalPrice=totalPrice;
  }
//address
public String getdeliveryAddress(){
    return deliveryAddress;
  }
  public void getdeliveryAddress(String deliveryAddress){
    this.deliveryAddress=deliveryAddress;
  }
}
