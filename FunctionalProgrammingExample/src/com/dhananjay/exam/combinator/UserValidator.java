package com.dhananjay.exam.combinator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class UserValidator {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    // Validation functions
    private static final Predicate<String> isNotNullOrEmpty = str -> str != null && !str.isEmpty();
    private static final Predicate<String> isEmailValid = email -> email.matches(EMAIL_REGEX);
    private static final Predicate<Integer> isAgeValid = age -> age > 0 && age < 150;

    // Combining functions
    public static final Function<User, Stream<String>> validateUsername = user -> {
        if (isNotNullOrEmpty.test(user.getUsername())) {
            return Stream.empty();
        } else {
            return Stream.of("Username cannot be null or empty.");
        }
    };

    public static final Function<User, Stream<String>> validateEmail = user -> {
        if (isEmailValid.test(user.getEmail())) {
            return Stream.empty();
        } else {
            return Stream.of("Invalid email address.");
        }
    };

    public static final Function<User, Stream<String>> validateAge = user -> {
        if (isAgeValid.test(user.getAge())) {
            return Stream.empty();
        } else {
            return Stream.of("Age must be between 1 and 149.");
        }
    };

    // Combining multiple validation functions
    public static final Function<User, Stream<String>> validateUser = user ->
            Stream.of(validateUsername, validateEmail, validateAge)
                    .flatMap(validation -> validation.apply(user));

    public static void main(String[] args) {
        User validUser = new User();
        validUser.setUsername("john_doe");
        validUser.setEmail("john.doe@example.com");
        validUser.setAge(25);

        User invalidUser = new User();
        invalidUser.setUsername(null);
        invalidUser.setEmail("invalid_email");
        invalidUser.setAge(200);

        // Validate a valid user
        Stream<String> validationResultValid = validateUser.apply(validUser);
        validationResultValid.forEach(System.out::println);

        // Validate an invalid user
        Stream<String> validationResultInvalid = validateUser.apply(invalidUser);
        validationResultInvalid.forEach(System.out::println);
    }
}
