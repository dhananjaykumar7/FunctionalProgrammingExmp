package com.dhananjay.exam.combinator;

import java.util.function.Predicate;

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {

		// checks if it is the same object reference
		if (this == obj) {
			return true;
		}

		// checks if obj is instance of Person
		if (!(obj instanceof Person)) {
			return false;
		}

		// type casting in order to compare data members
		Person otherPersonObj = (Person) obj;

		return this.name.equals(otherPersonObj.getName())
				&& Integer.compare(this.age, otherPersonObj.getAge()) == 0;
	}
}

public class CustomObjIsEqualPredicate {
	public static void main(String[] args) {
		Person p1 = new Person("Aniket", 20);
		Person p2 = new Person("Johny", 21);

		Predicate<Person> isSamePerson = Predicate.isEqual(new Person("Aniket", 20));

		System.out.println(isSamePerson.test(p1));
		System.out.println(isSamePerson.test(p2));
	}

}