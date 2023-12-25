package com.dhananjay.exam.combinator;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterUsingPredicate {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("a", "ab", "bb", "bcd", "bcde", "bcdef", "abc");

		Predicate<String> startsWithb = str -> str.startsWith("b");
		Predicate<String> hasLengthGreaterThan2 = str -> str.length() > 2;

		List<String> filteredStrings = strings
                    .stream()
                    .filter(startsWithb.and(hasLengthGreaterThan2))
                    .collect(Collectors.toList());
		System.out.println(filteredStrings);
	}
}
