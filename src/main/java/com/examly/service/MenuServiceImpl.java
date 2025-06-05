package com.examly.service;
import java.util.*;
import com.examly.entity.*;
import com.examly.exception.*;
import java.sql.*;
import com.examly.util.*;

public class MenuServiceImpl implements MenuService{

    @Override

   public boolean createMenuItem(MenuItem menu) throws RestaurantNotFoundException{

        try{

            String checksql="select count(*) from restaurant where restaurantId=?";
            String expectedQuery = "INSERT INTO menuItem (restaurantId, name, price, description, availableQuantity) VALUES (?, ?, ?, ?, ?)";


            Connection con=DBConnectionUtil.getConnection();
            PreparedStatement pst1=con.prepareStatement(checksql);
            pst1.setInt(1,menu.getresId());
            ResultSet rs=pst1.executeQuery();
            if(rs.next() && rs.getInt(1)==0){
                throw new RestaurantNotFoundException("Restaurant with id "+ menu.getresId()+" not found");
            }
         
           PreparedStatement pst2=con.prepareStatement(expectedQuery);

           pst2.setInt(1,menu.getresId());
           pst2.setString(2,menu.getname());
           pst2.setDouble(3,menu.getPrice());
           pst2.setString(4,menu.getdescription());
           pst2.setInt(5,menu.getAvailable());

           return pst2.executeUpdate() >0;

        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override

    public List<MenuItem> getMenuItemsByRestaurant(int restaurantId){
       List<MenuItem> menuItem=new ArrayList<>();
        try{
            String sql="select * from menuItem where restaurantId=?;";
            Connection con = DBConnectionUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,restaurantId);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                MenuItem item = new MenuItem(
                    rs.getInt("itemId"),
                    rs.getInt("restaurantId"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getString("description"),
                    rs.getInt("availableQuantity")
                );
                menuItem.add(item);
            }
         
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return menuItem;
    }

    //public boolean updateMenuItemQuantity(int itemId,int newQuantity){

    //     try{
    //     String sql="update MenuItem set quantity =? where itemId=?;";

    //     Connection con = DbConnectionUtil.getConnection();
    //     PreparedStatement pst = con.prepareStatement(sql);
    //     pst.setInt(1,itemId);
    //     pst.setInt(2,newQuantity);

    //     int rows=pst.executeUpdate();
    //     return rows>0;
    //     }
    //     catch(SQLException e){
    //         e.printStackTrace();
    //         return false;
    //     }
    // }
    
}
