package com.dhananjay.example;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalProgrmBasic {
	
	public static void main(String[] args) {
		
		Integer incrementedValue = incrementByOne.apply(1);
		System.out.println(incrementedValue);
		
		Integer multipliedValue = incrementByOne.apply(1);
		System.out.println(multipliedValue);
		
		Function<Integer, Integer> incremntBy1AndMultipliedValue = incrementByOne.andThen(multiplyBy10);
		System.out.println(incremntBy1AndMultipliedValue.apply(2));
		
		System.out.println(incrementAndMultiBiFunc.apply(2,400));
		
	}
	
	static Function<Integer, Integer> incrementByOne = number -> number +1;
	
	static Function<Integer, Integer> multiplyBy10 = number -> number * 10;
	
	// BiFunction takes 2 arguments and produce 1 result
	static BiFunction<Integer, Integer, Integer> incrementAndMultiBiFunc=(numberToInc,NumberToMult) 
			-> (numberToInc +1) * NumberToMult;

}
