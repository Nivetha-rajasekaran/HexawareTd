package com.examly.service;
import com.examly.entity.*;
import com.examly.exception.*;
import java.util.*;

public interface MenuService {
    
    boolean createMenuItem(MenuItem menu) throws RestaurantNotFoundException;
    List<MenuItem> getMenuItemsByRestaurant(int restaurantId);
    // boolean updateMenuItemQuantity(int itemId,int quantity);
}
