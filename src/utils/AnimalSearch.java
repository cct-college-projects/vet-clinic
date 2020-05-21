package utils;

import classes.Animals;
import conf.SingletonLoadAnimals;

import java.util.ArrayList;


public class AnimalSearch {

		private static SingletonLoadAnimals animals = SingletonLoadAnimals.getInstance();
    
	public static ArrayList<Animals> byName(String target){
			
			return BinarySearch.animals(animals.getAllAnimals(), target);
	}


	public static ArrayList<Animals> byName(String type, String target){
			
			switch (type.trim().toLowerCase()){
            case "dog"     : return BinarySearch.animals(animals.getDogList(), target);
            case  "bird"   : return BinarySearch.animals(animals.getBirdList(), target);
            case "cat"     : return BinarySearch.animals(animals.getCatList(), target);
            case "hamster" : return BinarySearch.animals(animals.getHamsterList(), target);
            case "rabbit"  : return BinarySearch.animals(animals.getRabbitList(), target);
            default        : System.out.println("Type not exist. The options are: dog, bird, cat, hamster and rabbit.");
                break;
			}
        return new ArrayList<>();
    }
	
	public static ArrayList<Animals> listAnimals(String type){
        switch (type.trim().toLowerCase()){
            case ""        : return animals.getAllAnimals();
            case "all"     : return animals.getAllAnimals();
            case "dog"     : return animals.getDogList();
            case "bird"    : return animals.getBirdList();
            case "cat"     : return animals.getCatList();
            case "hamster" : return animals.getHamsterList();
            case "rabbit"  : return animals.getRabbitList();
            default        : System.out.println("Type not exist. The options are: 'dog', 'bird', 'cat', 'hamster', 'rabbit' and 'all'.");
                break;
        }
        return new ArrayList<>();
    }
		





}