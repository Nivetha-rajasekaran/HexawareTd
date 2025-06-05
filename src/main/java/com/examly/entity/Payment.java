package com.examly.entity;
import java.util.Date;
public class Payment {

     private int paymentId;
     private int orderId;
     private Date paymentDate;
     private String PaymentStatus;
     private double amountPaid;
     
     public Payment(int paymentId,int orderId,Date paymentDate,String PaymentStatus,double amountPaid){
        this.paymentId=paymentId;
        this.orderId=orderId;
        this.paymentDate=paymentDate;
        this.PaymentStatus=PaymentStatus;
        this.amountPaid=amountPaid;
     }

    //payment id
     public int getpaymentId(){
        return paymentId;
     }
     public void setpaymentId(int paymentId){
        this.paymentId=paymentId;
     }
   //orderId   
   public int getorderId(){
    return orderId;
 }
 public void setOrderId(int orderId){
    this.orderId=orderId;
 }
 //paymentDate
 public Date getpaymentDate(){
    return paymentDate;
 }
 public void setpaymentDate(Date paymentDate){
    this.paymentDate=paymentDate;
 }
 //Paymentstatus
 public String getPaymentStatus(){
    return PaymentStatus;
 }
 public void getPaymentStatus(String PaymentStatus){
    this.PaymentStatus=PaymentStatus;
 }
 // amountPaid
 public double getamount(){
    return amountPaid;
 }
 public void setamount(double amountPaid){
    this.amountPaid=amountPaid;
 }

}
