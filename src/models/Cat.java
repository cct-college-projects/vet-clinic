package models;



import classes.Animals;

final public class Cat extends Animals {
	public Cat (int animal_id, String name, int age, String medicalCondition) {
		super(animal_id, name, age, medicalCondition);
		this.setAge();
	}

	
	
	@Override
	//Method to set age for cat randomly
	public void setAge () {
		// defining the random range for age between 1 up to 15
	int age = 1 + (int)(Math.random()*(15));
	this.age = age;
	}
	

}
