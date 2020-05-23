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
	//Reference of the singleton classes
	private static SingletonLoadAnimals animals = SingletonLoadAnimals.getInstance();
	private static SingletonLoadStaff employee  = SingletonLoadStaff.getInstance();
	
	
	//Main menu that will be called by the ToScreen Class
	public static void main(){
		int option = getUserOption();
		/** switch case option start below */
		switch (option){
			case 1 : ToScreen.listEmployee(employee.getAllEmployee(), true); main();
				break;
			case 2 : listStaffByCategory();
				break;
			case 3 : ToScreen.listAdminStaffTask(employee.getAllAdminStaff(), true);main();
				break;
			case 4 : searchStaffByName();
				break;
			case 5 : ToScreen.listAnimal(animals.getAllAnimals(), true); main();
				break;
			case 6 : ListAnimalByType();
				break;
			case 7 : searchAnimalByName();
				break;
			case 8 : MenuReception.main();
				break;
			case 9 : System.exit(0);
				break;
			default:
				main();
		}
	}
	//Main menu options that will appear to the user.
	
	public static void listMainMenuOptions(){
		System.out.println("\nWelcome to Vet Clinic Program. Please choose an option from the list below.\n");
		System.out.println("1: List all staff.");
		System.out.println("2: List staff by category.");
		System.out.println("3: List admin Staff performing a task.");
		System.out.println("4: Search for a specific member of staff by name.");
		System.out.println("5: List all animals.");
		System.out.println("6: List animals by type.");
		System.out.println("7: Search for a specific animal by name.");
		System.out.println("8: See the Queue to the Veterinary");
		System.out.println("9: Exit");
	}

	//Option 2 of the main Menu. Method to print a list of Staff by category.
	private static void listStaffByCategory(){
		
		showMessage("Choose one category to list:\n");
		showMessage("1 - Surgeon");
        showMessage("2 - Nurse");
        showMessage("3 - Vet");
        showMessage("4 - Accountant");
        showMessage("5 - ItSupport");
        showMessage("6 - Secretary");
        showMessage("7 - Back to previous menu.");
                
        int option = getUserStaffByCategory();
        /** switch case option start below */
        switch (option){
        	case 1 : ToScreen.listEmployee(employee.getSurgeonList(), true); listStaffByCategory();
                break;
            case 2 : ToScreen.listEmployee(employee.getNurseList(), true); listStaffByCategory();
                break;
            case 3 : ToScreen.listEmployee(employee.getVetList(), true); listStaffByCategory();
            	break;
            case 4 : ToScreen.listEmployee(employee.getAccountantList(), true); listStaffByCategory();
            	break;
            case 5 : ToScreen.listEmployee(employee.getItSupportList(), true); listStaffByCategory();
            	break;
            case 6 : ToScreen.listEmployee(employee.getSecretaryList(), true); listStaffByCategory();
            	break;
            case 7 : main();
            break;
           
            default: listStaffByCategory();
            
        }

	}

	//Option 4 of the Main menu. Method to List a specific searched name of the Staff list.
	//The user will type in the name he would like to search for and if it's matches a list with all staff with the name typed will appear
	//otherwise no records will be showed
	private static void searchStaffByName(){
		showMessage("type the name you are looking for: \n");
		String name = getUserTextTyped();
		ToScreen.listEmployee(EmployeeSearch.employee(employee.getAllEmployee(),name), true);
		
		//condition to do another search by name or go back to the main menu
        //if the user decide for doing another search the method is called again, otherwise it will go back to the main menu
		int tryAgain = askForGoMainMenu("Would you like to search for another name or go back to main menu?\n Type 1 to search someone else \n Type 0 to go to menu. \n Choice: ");
		if(tryAgain == 1){
			searchStaffByName();
		} else {
			main();
		}
	}
	//Option 6 of the Main menu. Method to List animal by type
	private static void ListAnimalByType() {
		
		showMessage("Choose one type to list:\n");
        showMessage("1 - Dog");
        showMessage("2 - Cat");
        showMessage("3 - Bird");
        showMessage("4 - Hamster");
        showMessage("5 - Rabbit");
        showMessage("6 - Back to previous menu.");
        
        int option = getUserAnimalByType();
        /** switch case option start below */
		switch (option){

        case 1 : ToScreen.listAnimal(animals.getDogList(), true); ListAnimalByType();
            break;
        case 2 : ToScreen.listAnimal(animals.getCatList(), true); ListAnimalByType();
            break;
        case 3 : ToScreen.listAnimal(animals.getBirdList(), true); ListAnimalByType();
        	break;
        case 4 : ToScreen.listAnimal(animals.getHamsterList(), true); ListAnimalByType();
        	break;
        case 5 : ToScreen.listAnimal(animals.getRabbitList(), true); ListAnimalByType();
        	break;
        case 6 : main();
        	break;
             
        default: ListAnimalByType();

		}
		
	}
	//Option 7 of the Main menu. Method to print a specific name of the animal list.
	//The user will type in the name he would like to search for and if it's matches a list with all animals with the name typed will appear
	//otherwise no records will be showed 
	private static void searchAnimalByName() {
		showMessage("type in the animal's name: \n");
		
		String name = getUserTextTyped();
		ToScreen.listAnimal(AnimalSearch.byName(name), true);
		
		//condition to do another search by name or go back to the main menu
		//if the user decide for doing another search the method is called again, otherwise it will go back to the main menu
		int tryAgain = askForGoMainMenu("Would you like to search for another name or go back to main menu?\n Type 1 to search someone else \n Type 0 to go to menu. \n Choice: ");
		if(tryAgain == 1){
			searchAnimalByName();
		} else {
			main();
		}
		
	}
	
	//Method to get the input from the user on the methods searchAnimalByName and searchStaffByName.
	//It will give the option to do a new search by name or go back to the main menu.
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
	
	//Method to get the user input for Main menu
	private static int getUserOption () {
		BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));

		int input;
		
		do {
			listMainMenuOptions();

			try {
				input = Integer.parseInt(myReader.readLine());

				if ((input < 1) || (input>9)) {
					System.out.println("Please type in a number between 1-9 according to your choice");
				}

			}catch (Exception e) {
				System.out.println("Character invalid. Please enter a number from 1-9 according to your choice");
				input = 0;
			}
			
		}while ((input < 1) || (input>9));

		return input;
		
	}
	//Method to get the user input in the method ListStaffByCategory
	private static int getUserStaffByCategory () {
		BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
		
		int input;
		
		do {
			try {
				input = Integer.parseInt(myReader.readLine());
				
				if ((input < 1) || (input > 7)) {
					System.out.println("please type in a number between 1-7.");
				}
			
			}catch (Exception e) {
				System.out.println("Character invalid. Please enter a number between 1-7.");
				input = 0;
			}	
		}while((input < 1) || (input > 7));
		
		return input;
		
	}
	
	//Method to get the user input in the method ListAnimalByType
	private static int getUserAnimalByType() {
		BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
		
		int input;
		
		do {

			try {
				input = Integer.parseInt(myReader.readLine());
				
				if ((input < 1) || (input > 6)) {
					System.out.println("please type in a number between 1-6.");
				}
			
			}catch (Exception e) {
				System.out.println("Character invalid. Please enter a number between 1-6.");
				input = 0;
			}	
		}while((input < 1) || (input > 6));
		
		return input;
		
	}
	//Method to get the name typed by the user on the methods to search a specific staff or animal by name.
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