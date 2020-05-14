package models;

import java.util.Random;

import classes.Animals;

final public class Bird extends Animals {
	public Bird (int animal_id, String name, int age, String medicalCondition) {
		super(animal_id, name, age, medicalCondition);
		this.setAge();
	}
		
	public Random rd = new Random();
	
	//Method to set age for bird randomly 
	@Override
	public void setAge () {
	int age = rd.nextInt(50);
	this.age = age;
	}
	
}
