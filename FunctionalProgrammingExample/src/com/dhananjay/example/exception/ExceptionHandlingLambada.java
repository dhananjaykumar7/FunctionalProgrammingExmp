package com.dhananjay.example.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExceptionHandlingLambada {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("44","373","xyx");
		list.forEach(handleException(s->System.out.println(Integer.parseInt(s))));
	}
	
	static Consumer<String> handleException(Consumer<String> payload){
		return obj ->{
			try {
			payload.accept(obj);
			}catch(Exception e) {
				System.out.println("exception :"+e.getMessage());
			}
		};
		
	}

}
