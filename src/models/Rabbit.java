package models;

import java.util.Random;

import classes.Animals;

final public class Rabbit extends Animals {
	public Rabbit (int animal_id, String name, int age, String medicalCondition) {
		super(animal_id, name, age, medicalCondition);
		this.setAge();
	}

	public Random rd = new Random();
	
	@Override
	//Method to set age for cat randomly
	public void setAge () {
		// defining the random range for age between 1 up to 10 
		int age = 1 + (int)(Math.random()*(10));
	this.age = age;
	}
	

}