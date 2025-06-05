package com.examly;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.examly.entity.Customer;
import com.examly.entity.MenuItem;
import com.examly.entity.Order;
import com.examly.entity.OrderItem;
import com.examly.entity.Payment;
import com.examly.entity.Restaurant;
import com.examly.exception.EmailAlreadyRegisteredException;
import com.examly.exception.RestaurantNotFoundException;
import com.examly.service.CustomerService;
import com.examly.service.CustomerServiceImpl;
import com.examly.service.MenuService;
import com.examly.service.MenuServiceImpl;
import com.examly.service.OrderService;
import com.examly.service.OrderServiceImpl;
import com.examly.service.PaymentService;
import com.examly.service.PaymentServiceImpl;
import com.examly.service.RestaurantService;
import com.examly.service.RestaurantServiceImpl;

public class MainModule {
   private static final CustomerService customerService = new CustomerServiceImpl();
   private static final RestaurantService restaurantService=new RestaurantServiceImpl();
   private static final MenuService menuservice = new MenuServiceImpl();
   private static final OrderService orderservice = new OrderServiceImpl();
   private static final PaymentService paymentservice = new PaymentServiceImpl();
   private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
               
      while(true){
            displayMenu();
            System.out.println("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
               case 1:registerCustomer(); break; 
               case 2: createRestaurant(); break;
               case 3: createMenuItem(); break;
               case 4: ViewRestaurant(); break;
               case 5: placeOrder(); break;
               case 6: viewOrders(); break;
               case 7: makePayment(); break;
               case 8: System.out.println("Exiting...");System.exit(0);
               default: System.out.println("Invalid option");
            }
         }

}
private static void displayMenu(){
   System.out.println("=== Welcome to the Online Food Delivery System ===");
   System.out.println("1. Register Customer");
   System.out.println("2. Create Restaurant");
   System.out.println("3. Create MenuItem");
   System.out.println("4. View Restaurants");
   System.out.println("5. Place Order");
   System.out.println("6. View Orders");
   System.out.println("7. Make Payment");
   System.out.println("8. Exit");

}
    
private static void registerCustomer(){
   System.out.println("Enter customer name: ");
   String name= sc.nextLine();
   System.out.println("Enter customer email: ");
   String email= sc.nextLine();
   System.out.println("Enter customer phone number: ");
   String phoneNumber= sc.nextLine();
   System.out.println("Enter customer password: ");
   String password= sc.nextLine();


   Customer customer =new Customer(0,name,email,phoneNumber,password);
   try{
      boolean success=customerService.createCustomer(customer);
      System.out.println("Customer registered successfully!");

   }
   catch(EmailAlreadyRegisteredException e){
      System.out.println("Error: "+e.getMessage());
   }
}

private static void createRestaurant(){
   System.out.println("Enter restaurant name: ");
   String name=sc.nextLine();

   System.out.println("Enter restaurant address: ");
   String address=sc.nextLine();

   System.out.println("Enter restaurant cuisineType: ");
   String cuisineType=sc.nextLine();

   System.out.println("Enter restaurant contactNumber: ");
   String contactNumber=sc.nextLine();


   Restaurant restaurant=new Restaurant(name,address,cuisineType,contactNumber);
   boolean success= restaurantService.createRestaurant(restaurant);
   System.out.println("Restaurant created successfully");

}

private static void ViewRestaurant(){
   List<Restaurant> res = restaurantService.getAllrestaurants();
   if(res.isEmpty()){
      System.out.println("No restaurants available");
   }
   else{
      System.out.println("\nList of Restaurants ===");
      for(Restaurant r:res){
      System.out.println("Restaurant ID: "+r.getresId());
      System.out.println("Restaurant Name: "+r.getName());
      System.out.println("Restaurant Address: "+r.getAddress());
      System.out.println("Restaurant cuisineType: "+r.getcuisineType());
      System.out.println("Restaurant contactNumber: "+r.getcontactNumber());

      }
      

   }
}
private static void createMenuItem(){
   System.out.println("Enter restaurant Id: ");
   int restaurantId=sc.nextInt();
    sc.nextLine();
   System.out.println("Enter item name: ");
   String name=sc.nextLine();

   System.out.println("Enter item price: ");
   double price=sc.nextDouble();
   sc.nextLine();

   System.out.println("Enter item description: ");
   String description=sc.nextLine();

   System.out.println("Enter AvailableQuantity: ");
   int availableQuantity=sc.nextInt();

   

   try{
   MenuItem m = new MenuItem(restaurantId,name,price,description,availableQuantity);
   boolean success = menuservice.createMenuItem(m);
   System.out.println("Menu Item successfully created!");
   }
   catch(RestaurantNotFoundException e){
      System.out.println("Error: Restaurant Id "+restaurantId+" not found");
   }

   
}

private static void placeOrder(){
   System.out.println("Enter customer Id: ");
   int customerId=sc.nextInt();
   
   System.out.println("Enter Restaurant Id: ");
   int restaurantId=sc.nextInt();
   
   sc.nextLine();
   
  List<MenuItem> menuItems= menuservice.getMenuItemsByRestaurant(restaurantId);

  if(menuItems.isEmpty()){
   System.out.println("No menu items available for this restaurant. ");
   return ;
  }

  for(MenuItem m:menuItems){
   System.out.println("Item ID: "+m.getitemId());
   System.out.println("Name: "+m.getname());
   System.out.println("Price: "+m.getPrice());
   System.out.println("Description: "+m.getdescription());
   System.out.println("Available Quantity: "+m.getAvailable());

  }

  System.out.println("Enter menu item ID to order: ");
  int ItemId=sc.nextInt();

  System.out.println("Enter quantity: ");
  int availableQuantity=sc.nextInt();

  sc.nextLine();

  System.out.println("Enter Delivery address");
  String deliveryAddress=sc.nextLine();

  MenuItem selectedItem = menuItems.stream()
  .filter(item-> item.getitemId()==ItemId)
  .findFirst()
  .orElse(null);

  if(selectedItem == null || selectedItem.getAvailable()>availableQuantity)
  {
   System.out.println("Invalid item ID or insufficient quantity");
   return ;
  }

int orderId = (int)( Math.random() *1000)+1;
double totalPrice = selectedItem.getPrice()*availableQuantity;
Order order = new Order(customerId, restaurantId, "Pending", totalPrice, deliveryAddress);
List<OrderItem> orderedItem = new ArrayList<>();
orderedItem.add(new OrderItem(orderId,ItemId,availableQuantity));
boolean success = orderservice.createOrder(order,orderedItem);
System.out.println("Order Placed successfully!");

// if(success){
//    int newQuantity = selectedItem.getAvailable()-quantity;
//    selectedItem.setAvailable(newQuantity);

//    menuservice.updateMenuItemQuantity(itemId,newQuantity);

// }

}
private static void viewOrders(){
   System.out.println("Enter Customer ID to view Orders: ");
   int customerId=sc.nextInt();
   List<Order> orders=orderservice.getOrdersByCustomer(customerId);
   if(orders.isEmpty()){
      System.out.println("No orders found for this customer");
   }

   else{
      System.out.println("\n===List of Orders ===");
   for(Order ord:orders){
    System.out.println("Order Id: "+ord.getorderId());
    System.out.println("Restaurant Id: "+ord.getrestId());
    System.out.println("Total Price: "+ord.gettotalPrice());
    System.out.println("Order Status: "+ord.getorderStatus());
    System.out.println("Delivery Address: "+ord.getdeliveryAddress());

   }
}
}

private static void makePayment(){

   System.out.println("Enter order Id: ");
   int orderId=sc.nextInt();

   System.out.println("Enter amount to pay: ");
   double amountPaid = sc.nextDouble();
  

   Order order= orderservice.getOrdersById(orderId);

   // Order order = ord.stream()
   //              .filter(o->o.getorderId()==orderId)
   //              .findFirst()
   //              .orElse(null);
   if(order==null){
      System.out.println("Order not found");
      return ;
   }
   if(order.gettotalPrice() !=amountPaid){
      System.out.println("Invalid amount.Expected: "+order.gettotalPrice());
      return ;
   }
   int paymentId = (int)(Math.random()*1000)+1;
   Payment payment = new Payment(paymentId,orderId,new Date(),"Completed",amountPaid);
   boolean success = paymentservice.processPayment(payment);
   if(success){
      System.out.println("Payment successful! Order is now confirmed.");
      order.setorderStatus("Confirmed");
   }
   else{
      System.out.println("Payment failed");
   }

}
}




