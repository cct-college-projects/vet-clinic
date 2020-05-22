package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


import classes.Animals;
import conf.*;
import utils.ToScreen;
import models.*;
import classes.*;

import static utils.ToScreen.listAnimal;
import static utils.ToScreen.showMessage;

public class Menu {

	private static SingletonLoadAnimals animals = SingletonLoadAnimals.getInstance();
	private static SingletonLoadStaff employee  = SingletonLoadStaff.getInstance();

	public static void main(){
		int option = getUserOption();
		/** switch case option start below */
		switch (option){
			case 1 : ToScreen.listEmployee(employee.getAllEmployee(), true); main();
				break;
			case 2 : //listStaffByCategory();
				break;
			case 3 : //listAllAdminStaffTask();
				break;
			case 4 : searchStaffByName();
				break;
			case 5 : listAnimal(animals.getAllAnimals(), true); main();
				break;
			case 6 : //listAnimalsByType();
				break;
			case 7 : //searchAnimalByName(animals);
				break;
			default:
				showMessage("whatrever");
		}
	}

	public static void listMainMenuOptions(){
		System.out.println("\nWelcome to Vet Clinic Program. Please choose an option from the list below.\n");

		System.out.println("1: List all staff.");
		System.out.println("2: List staff by category.");
		System.out.println("3: List admin Staff performing a task.");
		System.out.println("4: Search for a specific member of staff by name.");
		System.out.println("5: List all animals.");
		System.out.println("6: List animals per type.");
		System.out.println("7: Search for a specific animal by name.");
		System.out.println("8: Exit");
	}

	//Option 7

	public void searchAnimal(String name){
		ArrayList<Animals> searchResult = AnimalSearch.byName(name);
		listAnimal(searchResult, true);
	}

	public void searchAnimalByType(String type, String name){
		ArrayList<Animals> searchResult = AnimalSearch.byName(type, name);
		listAnimal(searchResult, true);
	}

	private static void searchStaffByName(){
		showMessage("type the name you are looking for: \n");
		String name = getUserTextTyped();
		ToScreen.listEmployee(EmployeeSearch.employee(employee.getAllEmployee(),name), true);
		int tryAgain = askForGoMainMenu("Would you like to search for another name or go back to main menu?\n Type 1 to search someone else \n Type 0 to go to menu. \n Choice: ");
		if(tryAgain == 1){
			searchStaffByName();
		} else {
			main();
		}
	}

	private static int askForGoMainMenu(String message){
		showMessage(message);
		BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
		int input;

		do {
			try {
				input = Integer.parseInt(myReader.readLine());

				if ((input < 0) || (input>1)) {
					System.out.println("Please type 1 or 2.\n");
				}

			}catch (Exception e) {
				System.out.println("Character invalid. Choose 1 or 2.\n");
				input = 0;
			}


		}
		while ((input < 0) || (input>1));

		return input;

	}

	private static int getUserOption () {

		BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));

		int input;

		do {
			listMainMenuOptions();

			try {
				input = Integer.parseInt(myReader.readLine());

				if ((input < 1) || (input>7)) {
					System.out.println("Please type in a number between 1-7 according to your choice");
				}

			}catch (Exception e) {
				System.out.println("Character invalid. Please enter a number from 1-7 according to your choice");
				input = 0;
			}


		}
		while ((input < 1) || (input>7));

		return input;

	}

	private static String getUserTextTyped () {

		BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
		Boolean loop = true;
		String text = "";
		do {
			try {
				text = myReader.readLine();

				if ((text.length() < 3)) {
					showMessage("Please type a minimum of 3 characters: \n");
				} else {
					return text;
				}

			}catch (Exception e) {
				System.out.println("Character invalid.");
			}
		} while (loop);


		return text;

	}
}