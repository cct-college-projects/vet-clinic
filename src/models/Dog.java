package models;



import classes.Animals;

final public class Dog extends Animals{
	public Dog(int animal_id, String name, int age, String medicalCondition) {
		super(animal_id, name, age, medicalCondition);
		this.setAge();
	}


	
	@Override
	//Method to set age for dog randomly
	public void setAge () {
		// defining the random range for age between 1 up to 17
		int age = 1 + (int)(Math.random()*(17));
	this.age = age;
	}
	
	
}
