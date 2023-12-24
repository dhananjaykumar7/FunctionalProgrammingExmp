package com.dhananjay.example;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerFuncExample {

public static void main(String[] args) {
	 Customer customer = new Customer("Dhananjay", "99999");
     greetCustomer(customer);
     
     greetCustomer.accept(customer);
     greetCustomerBiFun.accept(customer, false);
     
}
// Consumer functional

static Consumer<Customer> greetCustomer = customer 
-> System.out.println("Hello " + customer.customerName +
        ", thanks for registering phone number "
        + customer.customerPhoneNumber);

static BiConsumer<Customer,Boolean> greetCustomerBiFun = (customer,showNumber)
-> System.out.println("Hello " + customer.customerName +
        ", thanks for registering phone number "
        + (showNumber ? customer.customerPhoneNumber :"*********"));

//Imperative 
static void greetCustomer(Customer customer) {
    System.out.println("Hello " + customer.customerName +
            ", thanks for registering phone number "
            + customer.customerPhoneNumber);
}
static class Customer {
    private final String customerName;
    private final String customerPhoneNumber;

    Customer(String customerName, String customerPhoneNumber) {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
}