package utils;

import classes.Animals;
import conf.SingletonLoadAnimals;

import java.util.ArrayList;


//Implements a search method for animals's name
public class AnimalSearch {
		
		private static SingletonLoadAnimals animals = SingletonLoadAnimals.getInstance();
    //Method to store all animals sorted on the class BinarySearch
	public static ArrayList<Animals> byName(String target){
			
			return BinarySearch.animals(animals.getAllAnimals(), target);
	}

	//Method to search an animal by name
	public static ArrayList<Animals> byName(String type, String target){
			
			switch (type.trim().toLowerCase()){
            case "dog"     : return BinarySearch.animals(animals.getDogList(), target);
            case  "bird"   : return BinarySearch.animals(animals.getBirdList(), target);
            case "cat"     : return BinarySearch.animals(animals.getCatList(), target);
            case "hamster" : return BinarySearch.animals(animals.getHamsterList(), target);
            case "rabbit"  : return BinarySearch.animals(animals.getRabbitList(), target);
            case "all" 	   : return BinarySearch.animals(animals.getAllAnimals(), target);
            default        : System.out.println("Type does not exist. The options are: dog, bird, cat, hamster and rabbit.");
                break;
			}
        return new ArrayList<>();
    }
		
}