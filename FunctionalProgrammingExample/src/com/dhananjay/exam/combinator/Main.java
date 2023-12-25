package com.dhananjay.exam.combinator;
import java.time.LocalDate;
import com.dhananjay.exam.combinator.*;


public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "dhananjya",
                "dhananjay@gmail.com",
                "+0898787879878",
                LocalDate.of(2015, 1,1)
        );

//        System.out.println(new CustomerValidatorService().isValid(customer));

        // if valid we can store customer in db

        // Using combinator pattern
        ValidationResult result = CustomerRegistrationValidator.isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAnAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }

    }
}