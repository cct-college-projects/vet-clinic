package conf;

import classes.Animals;
import helpers.HelperAnimals;
import models.Bird;
import models.Cat;
import models.Dog;
import models.Rabbit;
import models.Hamster;

import java.util.ArrayList;
import java.util.Random;

 public class SingletonLoadAnimals {

	private int maxAnimal = 1000;
	private int animal_id = 0;
	private int age = 0;
	private String nameRandom, illnessRandom;
	//ArrayLists where each type of animal will be stored after the program generate randomly animals with age and medical
	//condition status
	private ArrayList<Animals> dogList = new ArrayList<>();
	private ArrayList<Animals> catList = new ArrayList<>();
	private ArrayList<Animals> birdList = new ArrayList<>();
	private ArrayList<Animals> rabbitList = new ArrayList<>();
	private ArrayList<Animals> hamsterList = new ArrayList<>();
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
			randomAnimalType = rd.nextInt(5);
			idnameRandom = rd.nextInt(this.animalnameListSize);
			idillnessRandom = rd.nextInt(this.animalillnessListSize);
			nameRandom = animalnameList.get(idnameRandom);
			illnessRandom = animalillnessList.get(idillnessRandom);
			
			switch (randomAnimalType){
				case 0 : dogList.add(new Dog (this.incrementAnimal_id(), nameRandom, age,  illnessRandom));
					break;
				case 1 : catList.add(new Cat(this.incrementAnimal_id(), nameRandom, age,  illnessRandom));
					break;
				case 2 : birdList.add(new Bird(this.incrementAnimal_id(), nameRandom, age,  illnessRandom));
					break;
				case 3 : hamsterList.add(new Hamster(this.incrementAnimal_id(), nameRandom, age, illnessRandom));
					break;
				default : rabbitList.add(new Rabbit(this.incrementAnimal_id(), nameRandom, age, illnessRandom));	
			}
		}
			
	}
			
	private int incrementAnimal_id() {
		
		this.animal_id++;
		return this.animal_id;
	}
	

	public ArrayList<Animals> getDogList() {
		return dogList;
	}

	public ArrayList<Animals> getCatList() {
		return catList;
	}

	public ArrayList<Animals> getBirdList() {
		return birdList;
	}
	
	public ArrayList<Animals> getHamsterList() {
		return hamsterList;
	}
	
	public ArrayList<Animals> getRabbitList() {
		return rabbitList;
	}
	//Method to get all the lists by each animal type and return in an unique Array to be sorted for search by name later on
	public ArrayList<Animals> getAllAnimals(){
		ArrayList<Animals> allAnimals = new ArrayList<Animals>();
		allAnimals.addAll(this.getDogList());
		allAnimals.addAll(this.getCatList());
		allAnimals.addAll(this.getBirdList());
		allAnimals.addAll(this.getHamsterList());
		allAnimals.addAll(this.getRabbitList());
		
		return allAnimals;
	}
	
	public void close() {
		
		this.instance = null;
	}
	
	
}
