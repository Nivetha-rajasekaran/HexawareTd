package com.examly.service;
import com.examly.entity.Restaurant;
import com.examly.exception.*;
import java.sql.*;
import com.examly.util.*;
import java.util.*;

public class RestaurantServiceImpl implements RestaurantService {
    


public boolean createRestaurant(Restaurant restaurant){
    String expectedQuery = "INSERT INTO restaurant (name, address, cuisineType, contactNumber) VALUES (?, ?, ?, ?)";
 
    try{
    Connection con = DBConnectionUtil.getConnection();
    PreparedStatement pst = con.prepareStatement(expectedQuery,Statement.RETURN_GENERATED_KEYS);
   
    pst.setString(1,restaurant.getName());
    pst.setString(2,restaurant.getAddress());
    pst.setString(3,restaurant.getcuisineType());
    pst.setString(4,restaurant.getcontactNumber());
    
    int r=pst.executeUpdate();
    if(r>0){
      ResultSet rs = pst.getGeneratedKeys();
      if(rs.next()){
        int gid=rs.getInt(1);
        restaurant.setresId(gid);
      }
      return true ;
    }
   
    }
    catch(SQLException e){
        e.printStackTrace();
       

    }
    return false;
    
}

@Override
public List<Restaurant> getAllrestaurants(){

    List<Restaurant> restaurants = new ArrayList<>();
    try{
        String sql="select * from restaurant;";
        Connection con = DBConnectionUtil.getConnection();
        Statement st = con.createStatement();
        ResultSet rs= st.executeQuery(sql);

        while(rs.next()){
            Restaurant restaurant=new Restaurant(
            rs.getInt("restaurantId"),
            rs.getString("name"),
            rs.getString("address"),
            rs.getString("cuisineType"),
            rs.getString("contactNumber")
            );

            restaurants.add(restaurant);
        }
    }
        catch(SQLException e ){
            e.printStackTrace();
        }
        return restaurants;


    
}
}
