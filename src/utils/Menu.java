package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import classes.Animals;
import conf.*;
import utils.ToScreen;
import models.*;
import classes.*;

public class Menu {

	public static void main(){
		int option = getUserOptionMainMenu();
		/** switch case option start below */
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

	public static int getUserOptionMainMenu () {
		
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
}
