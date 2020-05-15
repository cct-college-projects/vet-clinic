package conf;

import classes.Animals;
import helpers.HelperAnimals;
import models.Bird;
import models.Cat;
import models.Dog;

import java.util.ArrayList;
import java.util.Random;

 public class SingletonLoadAnimals {

	private int maxAnimal = 1000;
	private int animal_id = 0;
	private int age = 0;
	private String nameRandom, illnessRandom;
	private ArrayList<Dog> dogList = new ArrayList<Dog>();
	private ArrayList<Cat> catList = new ArrayList<Cat>();
	private ArrayList<Bird> birdList = new ArrayList<Bird>();
	private ArrayList<String> animalnameList;
	private ArrayList<String> animalillnessList;
	private Random rd = new Random();
	private int idnameRandom, idillnessRandom, animalnameListSize, animalillnessListSize;
	
	private static SingletonLoadAnimals instance = null;
	
	private SingletonLoadAnimals () {
		this.animalnameList = HelperAnimals.loadAnimalname();
		this.animalillnessList = HelperAnimals.loadAnimalillness();
		if(!this.animalnameList.isEmpty() && !this.animalillnessList.isEmpty()) {
			this.animalnameListSize = this.animalnameList.size();
			this.animalillnessListSize = this.animalillnessList.size();
			this.createAnimalList();
			
			
		}
		
	}
	
	public static SingletonLoadAnimals getInstance() {
		
		if (instance == null) {
			
			instance = new SingletonLoadAnimals();
		}
		return instance;
	}
	
	
	private void createAnimalList(){
		int randomAnimalType;
			System.out.println("Creating Animal list.");
		for (int i = 0; i < this.maxAnimal; i++) {
			randomAnimalType = rd.nextInt(3);
			idnameRandom = rd.nextInt(this.animalnameListSize);
			idillnessRandom = rd.nextInt(this.animalillnessListSize);
			nameRandom = animalnameList.get(idnameRandom);
			illnessRandom = animalillnessList.get(idillnessRandom);
			
			switch (randomAnimalType){
				case 0 : dogList.add(new Dog (this.incrementAnimal_id(), nameRandom, age,  illnessRandom));
					break;
				case 1 : catList.add(new Cat(this.incrementAnimal_id(), nameRandom, age,  illnessRandom));
					break;

				default : birdList.add(new Bird(this.incrementAnimal_id(), nameRandom, age,  illnessRandom));
			}
		}
			
	}
			
	private int incrementAnimal_id() {
		
		this.animal_id++;
		return this.animal_id;
	}
	

	public ArrayList<Dog> getDogList() {
		return dogList;
	}

	public ArrayList<Cat> getCatList() {
		return catList;
	}

	public ArrayList<Bird> getBirdList() {
		return birdList;
	}
	
	public void close() {
		
		this.instance = null;
	}
	
	
}
