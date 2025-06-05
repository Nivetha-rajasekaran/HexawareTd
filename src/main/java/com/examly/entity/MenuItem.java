package com.examly.entity;

public class MenuItem {
  private int itemId;
  private int restaurantId;
  private String name;
  private double price;
  private String description;
  private int availableQuantity;
  
  public MenuItem(int restaurantId,String name,double price,String description,int availableQuantity){
 
    this.restaurantId=restaurantId;
    this.name=name;
    this.price=price;
    this.description=description;
    this.availableQuantity=availableQuantity;
  }
  public MenuItem(int itemId,int restaurantId,String name,double price,String description,int availableQuantity){
    this.itemId=itemId;
    this.restaurantId=restaurantId;
    this.name=name;
    this.price=price;
    this.description=description;
    this.availableQuantity=availableQuantity;
  }
  //itemid
  public int getitemId(){
    return itemId;
  }
  public void setItemId(int itemId){
    this.itemId=itemId;
  }
   //resid
   public int getresId(){
    return restaurantId;
  }
  public void setresId(int restaurantId){
    this.restaurantId=restaurantId;
  }
  //name
  public String getname(){
    return name;
  }
  public void setName(String name){
    this.name=name;
  }
  //price
  public double getPrice(){
    return price;
  }
  public void setPrice(double price){
    this.price=price;
  }
  //description
  public String getdescription(){
    return description;
  }
  public void setdescription(String description){
    this.description=description;
  }
  //availability
  public int getAvailable(){
    return availableQuantity;
  }
  public void setAvailable(int availableQuantity){
    this.availableQuantity=availableQuantity;
  }
}
