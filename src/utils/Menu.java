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
	private static SingletonLoadStaff adminStaff = SingletonLoadStaff.getInstance();
	
	//Main menu that will be called by the ToScreen Class
	public static void main(){
		int option = getUserOption();
		/** switch case option start below */
		switch (option){
			case 1 : ToScreen.listEmployee(employee.getAllEmployee(), true); main();//ok
				break;
			case 2 : listStaffByCategory();
				break;
			case 3 : ToScreen.listAdminStaffTask(adminStaff.getAllAdminStaff(), true);main();//ok
				break;
			case 4 : searchStaffByName();//ok
				break;
			case 5 : ToScreen.listAnimal(animals.getAllAnimals(), true); main();//ok
				break;
			case 6 : ListAnimalByType();
				break;
			case 7 : searchAnimalByName();//ok
				break;
			case 8 : System.exit(0);
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
		System.out.println("8: Exit");
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
        
        switch (option){

            case 1 : ToScreen.listEmployee(employee.getSurgeonList(), true); 
                break;
            case 2 : ToScreen.listEmployee(employee.getNurseList(), true);
                break;
            case 3 : ToScreen.listEmployee(employee.getVetList(), true);
            	break;
            case 4 : ToScreen.listEmployee(employee.getAccountantList(), true);
            	break;
            case 5 : ToScreen.listEmployee(employee.getItSupportList(), true);
            	break;
            case 6 : ToScreen.listEmployee(employee.getSecretaryList(), true);
            	break;
            case 7 : main();
            break;
           
            default: listStaffByCategory();
            
            int tryAgain = askForGoMainMenu("Would you like to search for another category or go back to main menu?\n Type 1 to search someone else \n Type 0 to go to menu. \n Choice: ");
    		if(tryAgain == 1){
    			listStaffByCategory();
    		} else {
    			main();
    		  }
        }

	}
	//Option 4 of the Main menu. Method to List a specific searched name of the Staff list.
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
		
		switch (option){

        case 1 : ToScreen.listAnimal(animals.getDogList(), true);
            break;
        case 2 : ToScreen.listAnimal(animals.getCatList(), true);
            break;
        case 3 : ToScreen.listAnimal(animals.getBirdList(), true);
        	break;
        case 4 : ToScreen.listAnimal(animals.getHamsterList(), true);
        	break;
        case 5 : ToScreen.listAnimal(animals.getRabbitList(), true);
        	break;
        case 6 : main();
        	break;
             
        default: ListAnimalByType();
        
        int tryAgain = askForGoMainMenu("Would you like to search for another category or go back to main menu?\n Type 1 to search someone else \n Type 0 to go to menu. \n Choice: ");
		if(tryAgain == 1){
			ListAnimalByType();
		} else {
			main();
		  }
		}
		
	}

	private static void searchAnimalByName() {
		showMessage("type in the animal's name: \n");
		
		String name = getUserTextTyped();
		ToScreen.listAnimal(AnimalSearch.byName(name), true);
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
	
	//Method to get the user input for Main menu
	private static int getUserOption () {
		BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));

		int input;
		
		do {
			listMainMenuOptions();

			try {
				input = Integer.parseInt(myReader.readLine());

				if ((input < 1) || (input>8)) {
					System.out.println("Please type in a number between 1-7 according to your choice");
				}

			}catch (Exception e) {
				System.out.println("Character invalid. Please enter a number from 1-7 according to your choice");
				input = 0;
			}
			
		}while ((input < 1) || (input>8));

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