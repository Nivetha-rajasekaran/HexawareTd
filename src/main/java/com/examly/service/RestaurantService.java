package com.examly.service;
import com.examly.entity.*;
import java.util.*;

public interface RestaurantService  {
  
    boolean createRestaurant(Restaurant restaurant);
    List<Restaurant> getAllrestaurants(); 
    
}
