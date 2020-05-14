package models;

import java.util.Random;

import classes.Animals;

final public class Cat extends Animals {
	public Cat (int animal_id, String name, int age, String medicalCondition) {
		super(animal_id, name, age, medicalCondition);
	}

	public Random rd = new Random();
	
	@Override
	public void animalAge() {
		
		int age = rd.nextInt(16);
		System.out.println(age);
	}

}
