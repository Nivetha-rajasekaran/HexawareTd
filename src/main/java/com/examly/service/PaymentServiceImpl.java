package com.examly.service;
import java.util.*;
import java.sql.*;
import com.examly.entity.*;
import com.examly.util.*;
public class PaymentServiceImpl implements PaymentService {
    
    @Override
    public boolean processPayment(Payment payment){
    try{
      String sql="insert into Payment(paymentId,orderId,paymentDate,paymentStatus,amountPaid)values(?,?,?,?,?);";
      Connection con = DBConnectionUtil.getConnection();
      PreparedStatement pst = con.prepareStatement(sql);

      pst.setInt(1,payment.getpaymentId());
      pst.setInt(2,payment.getorderId());
      pst.setTimestamp(3,new Timestamp(payment.getpaymentDate().getTime()));
      pst.setString(4,payment.getPaymentStatus());
      pst.setDouble(5,payment.getamount());

      return pst.executeUpdate()>0;

    }
    catch(SQLException e){
        e.printStackTrace();
        return false;
    }
    }

}
