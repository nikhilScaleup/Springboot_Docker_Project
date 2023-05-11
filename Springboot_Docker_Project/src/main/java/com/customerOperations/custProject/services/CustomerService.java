package com.customerOperations.custProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerOperations.custProject.models.Customer;
import com.customerOperations.custProject.models.Database;
import com.customerOperations.custProject.models.Order;

@Service
public class CustomerService {
 
    private Database database;
    
    @Autowired
    public CustomerService(Database database) {
        this.database = database;
    }

    public List<Customer> getAllCustomers() {
        return database.getCustomers();
    }

    public Customer getCustomerById(int id) {
        return database.getCustomers().stream()
            .filter(c -> c.getId() == id)
            .findFirst()
            .orElse(null);
    }

    public List<Order> getOrdersForCustomer(int id) {
        Customer customer = getCustomerById(id);

        if (customer != null) {
            return customer.getOrders();
        } else {
            return null;
        }
    }

    public Order getOrderForCustomerById(int id, int orderId) {
        Customer customer = getCustomerById(id);

        if (customer != null) {
            return customer.getOrders().stream()
                .filter(o -> o.getId() == orderId)
                .findFirst()
                .orElse(null);
        } else {
            return null;
        }
    }
}

