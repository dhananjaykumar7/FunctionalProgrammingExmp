package com.dhananjay.exam.combinator;
import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;


public interface CustomerRegistrationValidator
        extends Function<Customer, ValidationResult> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> {
            System.out.println("running email validation");
            return customer.getEmail().contains("@") ?
            		ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
        };
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("+0") ?
        		ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAnAdult() {
        return customer ->
                Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                		ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = (ValidationResult) this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
        };
    }

    
}