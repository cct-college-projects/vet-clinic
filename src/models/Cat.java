package models;

import java.util.Random;

import classes.Animals;

final public class Cat extends Animals {
	public Cat (int animal_id, String name, int age, String medicalCondition) {
		super(animal_id, name, age, medicalCondition);
		this.setAge();
	}

public Random rd = new Random();
	
	@Override
	//Method to set age for cat randomly
	public void setAge () {
	int age = rd.nextInt(15);
	this.age = age;
	}
	

}
