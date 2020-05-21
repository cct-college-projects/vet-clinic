package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import classes.Animals;
import conf.*;
import utils.ToScreen;
import models.*;
import classes.*;

public class Menu {
	
	private SingletonLoadAnimals animals;

	public int getUserOption () {
		
		BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
		
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
	
//	public fileWithMenu() {
		
//		int choice = 0;
//		
//		
//		do {
//			
//			choice = getUserOption();
//			
//			if (choice == 1) {
////				 this.staffs = SingletonLoadStaff.getInstance();
////			        this.vetList     = this.staffs.getVetList();
////			        this.surgeonList = this.staffs.getSurgeonList();
////			        this.nurseList   = this.staffs.getNurseList();
//
//			        ToScreen.showStaffAll();
//			}
//			
//			else if (choice == 4) {
//			
//			this.animals = SingletonLoadAnimals.getInstance();
//		        
//		        ToScreen.showAnimalAll();
//				
//			}
//			
//		}while (choice != 9);
//		
//	}
//
}
