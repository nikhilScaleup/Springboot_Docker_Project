package com.customerOperations.custProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.customerOperations.custProject.models.Customer;
import com.customerOperations.custProject.models.Order;
import com.customerOperations.custProject.services.CustomerService;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/customers/{customerId}/orders")
    public List<Order> getCustomerOrders(@PathVariable int customerId) {
        List<Order> customerOrders = new ArrayList<>();
        
        customerOrders = customerService.getOrdersForCustomer(customerId);
//        for (Order order : orders) {
//            if (order.getId() == customerId) {
//                customerOrders.add(order);
//            }
//        }
        return customerOrders;
    }

    @GetMapping("/customers/{customerId}/orders/{orderId}")
    public Order getCustomerOrder(@PathVariable int customerId, @PathVariable int orderId) {
       
    	Order order = customerService.getOrderForCustomerById(customerId, orderId);
//    	for (Order order : orders) {
//            if (order.getCustomerId() == customerId && order.getId() == orderId) {
//                return order;
//            }
//        }
        return order;
    }

}