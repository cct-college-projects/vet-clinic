package utils;

import classes.Animals;
import conf.SingletonLoadStaff;
import conf.SingletonLoadAnimals;
import helpers.HelperStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ToScreen {
	
	BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
	
	public ToScreen() {

		int choice = 0;
		String name;
	
		do {
		
			choice = getUserOption();
			
			if (choice ==1 ) {
				
				showStaffAll();		
			}
			else if (choice == 2) {
							
			}
			else if (choice == 3) {
				
				showAdminStaffTask();
			}
			else if (choice == 5) {
				
				showAnimalAll();
			}
			else if (choice == 6) {
				
			}
			
			else if (choice == 7) {
				
				System.out.println("Type in the name:");
				try {
					name = myReader.readLine();
				
				}catch (IOException e) {
					
					
				}
				
				//searchAnimal();
			}
		}while(choice != 8);
			System.out.println("Exit.");
	}
	
    public static void showMessage(String msg){
        System.out.println(msg);
    }
  //Option 1
    public static void showStaffAll(){
        SingletonLoadStaff staffs = SingletonLoadStaff.getInstance();
        showMessage("### Employees ###");
        for (int i = 0; i < staffs.getAllEmployee().size(); i++) {
            showMessage("ID: " + staffs.getAllEmployee().get(i).getEmp_id()+" - Type: "+staffs.getAllEmployee().get(i).getClass().getSimpleName()+" - Name: "+staffs.getAllEmployee().get(i).getName() +" " + staffs.getAllEmployee().get(i).getSurname() +" - Salary: " + staffs.getAllEmployee().get(i).getSalaryLevel());
        }
        
        //Option 2 print by category

    }
    //Option 3 
    public static void showAdminStaffTask() {
    	SingletonLoadStaff staffs = SingletonLoadStaff.getInstance();
        showMessage("### Admin Staff Task ###");
        for (int i = 0; i < staffs.getItSupportList().size(); i++) {
            showMessage(staffs.getItSupportList().get(i).getEmp_id() +" - "+staffs.getItSupportList().get(i).getClass().getSimpleName()+" - "+staffs.getItSupportList().get(i).getFullName());
        }
        for (int i = 0; i < staffs.getAccountantList().size(); i++) {
            showMessage(staffs.getAccountantList().get(i).getEmp_id() +" - "+staffs.getAccountantList().get(i).getClass().getSimpleName()+" - "+staffs.getAccountantList().get(i).getFullName());
        }
        for (int i = 0; i < staffs.getSecretaryList().size(); i++) {
            showMessage(staffs.getSecretaryList().get(i).getEmp_id() +" - "+staffs.getSecretaryList().get(i).getClass().getSimpleName()+" - "+staffs.getSecretaryList().get(i).getFullName());
        }
    }
      //Option 5
    public static void showAnimalAll(){
        SingletonLoadAnimals animals = SingletonLoadAnimals.getInstance();
        
        showMessage("### List of all animals ###");
        for (int i = 0; i < animals.getAllAnimals().size(); i++) {
            showMessage(animals.getAllAnimals().get(i).getAnimal_id()+" - "+ animals.getAllAnimals().get(i).getFullInformation());
        }
    }

    //Option 6
    
    //List animals by various types (e.g. list all dogs) -> ToScreen.listAnimal(this.animals.getDogList());
    public static void listAnimal(ArrayList<Animals> animals, Boolean table){
        if(table){
            showMessage("----------- ----------- --- -------------------");
            showMessage("TYPE\t\tNAME\t\tAGE\tMEDICAL CONDITIONAL");
            showMessage("----------- ----------- --- -------------------");
            for (Animals animal: animals) {
                String name = "", typeAnimal = "";

                name = HelperStrings.addTabToString(animal.getName());
                typeAnimal = HelperStrings.addTabToString(animal.getClass().getSimpleName());

                showMessage(typeAnimal +"\t" + name + "\t" + animal.getAge() + "\t" + animal.getMedicalCondition());
            }
        } else {
            for ( Animals animal: animals) {
                showMessage(animal.getFullInformation());
            }
        }
    }
    
    //Option 7
    
    public void searchAnimal(ArrayList<Animals> arrayList, String name){

    	
		
        ArrayList<Animals> searchResult = AnimalSearch.binary(arrayList, name);
        System.out.println("-------------------------------------------------------");
        System.out.println("Result: ");
        for (int i = 0; i < searchResult.size(); i++) {
            System.out.println("ID: "+searchResult.get(i).getAnimal_id()+" - Animal: "+searchResult.get(i).getClass().getSimpleName()+" - "+searchResult.get(i).getFullInformation());
        }
    }
    
    
    
    public int getUserOption () {
		
//		BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
		
		int input;
		
		do {
			System.out.println("\nWelcome to Vet Clinic Program. Please choose an option from the list below.\n");
			
			System.out.println("1: List all staff.");
			System.out.println("2: List staff by category.");
			System.out.println("3: List admin Staff performing a task.");
			System.out.println("4: Search for a specific member of staff by name.");
			System.out.println("5: List all animals.");
			System.out.println("6: List animals per type.");
			System.out.println("7: Search for a specific animal by name.");
			System.out.println("8: Exit");
			
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
    
}   


