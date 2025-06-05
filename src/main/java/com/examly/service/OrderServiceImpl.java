package com.examly.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.examly.entity.Order;
import com.examly.entity.OrderItem;
import com.examly.util.DBConnectionUtil;

public class OrderServiceImpl implements OrderService {
    
    @Override

    public boolean createOrder(Order order,List<OrderItem> orderedItems){
       
        try{
            String sql1="insert into `order` (customerId,restaurantId,orderStatus,totalPrice,deliveryAddress)values(?,?,?,?,?);";
            String expectedQuery = "INSERT INTO orderItem (orderId, itemId, quantity) VALUES (?, ?, ?)";


            Connection con=DBConnectionUtil.getConnection();
            con.setAutoCommit(false);
            PreparedStatement pst1=con.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
    
            pst1.setInt(1,order.getcustId());
            pst1.setInt(2,order.getrestId());
            pst1.setString(3,order.getorderStatus());
            pst1.setDouble(4,order.gettotalPrice());
            pst1.setString(5,order.getdeliveryAddress());

            int row1=pst1.executeUpdate();
            int orderId=-1;
                ResultSet gk=pst1.getGeneratedKeys();
                if(gk.next()){
                    orderId=gk.getInt(1);
                }
    
           
            PreparedStatement pst2=con.prepareStatement(expectedQuery);
            for(OrderItem ord:orderedItems){
                pst2.setInt(1,orderId);
                pst2.setInt(2,ord.getitemId());
                pst2.setInt(3,ord.getquantity());
                pst2.addBatch();
            }
           int[] row2 = pst2.executeBatch();
        
    
   

           con.commit();
           return row1 > 0 && row2.length == orderedItems.size();


        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override

    public List<Order> getOrdersByCustomer(int customerId){
    
        List<Order> item = new ArrayList<>();

        try{
            String sql="select * from `order` where customerId=?;";
            Connection con = DBConnectionUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,customerId);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                Order ord = new Order(
                    rs.getInt("orderId"),
                rs.getInt("customerId"),
                rs.getInt("restaurantId"),
                rs.getString("orderStatus"),
                rs.getDouble("totalprice"),
                rs.getString("deliveryAddress")


                );
                item.add(ord);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return item;
    }

    public Order getOrdersById(int orderId){
    
      Order order = null;

        try{
            String sql="select * from `order` where orderId=?;";
            Connection con = DBConnectionUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,orderId);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                order= new Order(
                rs.getInt("orderId"),
                rs.getInt("customerId"),
                rs.getInt("restaurantId"),
                rs.getString("orderStatus"),
                rs.getDouble("totalprice"),
                rs.getString("deliveryAddress")


                );
            //    order.add(ord);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return order;
    }
    
}
