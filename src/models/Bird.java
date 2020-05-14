package models;

import java.util.Random;

import classes.Animals;

final public class Bird extends Animals {
	public Bird (int animal_id, String name, int age, String medicalCondition) {
		super(animal_id, name, age, medicalCondition);
		animalAge();
	}
	public Random rd = new Random();
	@Override
	public void animalAge() {
		
		int age = rd.nextInt(50);
		System.out.println(age);
	}	

	
}
