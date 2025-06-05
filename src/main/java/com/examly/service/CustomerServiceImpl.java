package com.examly.service;
import com.examly.entity.*;
import com.examly.exception.*;
import com.examly.util.*;
import java.sql.*;

public class CustomerServiceImpl implements CustomerService {
    
    @Override
   public  boolean createCustomer(Customer customer) throws EmailAlreadyRegisteredException{

        String email="SELECT count(*) from customer where email=?";
        String expectedQuery = "INSERT INTO customer (name, email, phoneNumber, password) VALUES (?, ?, ?, ?)";
        try{
            Connection con = DBConnectionUtil.getConnection();
            PreparedStatement pst =con.prepareStatement(email);
            pst.setString(1,customer.getemail());
            ResultSet rs = pst.executeQuery();
            
            if(rs.next() &&rs.getInt(1)>0){
              throw new EmailAlreadyRegisteredException("Email "+customer.getemail()+" is already registered");
            }
            PreparedStatement pist =con.prepareStatement(expectedQuery);
            // pist.setInt(1,customer.getCustomerID());
            pist.setString(1,customer.getname());
            pist.setString(2,customer.getemail());
            pist.setString(3,customer.getphNo());
            pist.setString(4,customer.getpass());

            return pist.executeUpdate() > 0;
    
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        
    }
}
