package models;

import java.util.Random;

import classes.Animals;

final public class Hamster extends Animals {
	public Hamster (int animal_id, String name, int age, String medicalCondition) {
		super(animal_id, name, age, medicalCondition);
		this.setAge();
	}
		
	
	
	//Method to set age for bird randomly 
	@Override
	public void setAge () {
		// defining the random range for age between 1 up to 50
		int age = 1 + (int)(Math.random()*(3));
		this.age = age;
	}
	
}