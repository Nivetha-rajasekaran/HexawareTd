package com.examly.entity;

public class Restaurant {
    private int restaurantId;
    private String name;
    private String address;
    private String cuisineType;
    private String contactNumber;

    public Restaurant(int restaurantId,String name,String address,String cuisineType,String contactNumber){
        this.restaurantId= restaurantId;
        this.name=name;
        this.address=address;
        this.cuisineType=cuisineType;
        this.contactNumber=contactNumber;

    }
    public Restaurant(String name,String address,String cuisineType,String contactNumber){
        // this.restaurantId= restaurantId;
        this.name=name;
        this.address=address;
        this.cuisineType=cuisineType;
        this.contactNumber=contactNumber;

    }
    //resid
    public  int getresId(){
          return restaurantId;
    }
    public void setresId(int restaurantId){
        this.restaurantId= restaurantId;
    }
    //name
    public String getName(){
        return name;
  }
  public void setName(String name){
    this.name=name;
  }
  //address
  public String getAddress(){
    return address;
}
public void setAddress(String address){
     this.address=address;
}
//cuisineType

public String getcuisineType(){
    return cuisineType;
}
public void setcuisineType(String cuisineType){
     this.cuisineType=cuisineType;
}
//contactNumber
public String getcontactNumber(){
    return contactNumber;
}
public void setcontactNumber(String contactNumber){
     this.contactNumber=contactNumber;
}

}
