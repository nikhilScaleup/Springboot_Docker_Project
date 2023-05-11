package com.customerOperations.custProject.models;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Component
public class Database {
    private List<Customer> customers;

    @PostConstruct
    public void loadData() throws IOException {

    		
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource("data.json").getInputStream();
        String json = new String(inputStream.readAllBytes());
        TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>() {};
        customers = mapper.readValue(json, typeReference);
        System.out.println("Nik "+customers.size());
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
