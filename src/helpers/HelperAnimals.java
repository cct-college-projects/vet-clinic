package helpers;

import enums.FilesImport;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HelperAnimals {

	private static BufferedReader br = null;
	
	public static ArrayList<String> loadAnimalname (){
		ArrayList<String> animalName;
		animalName = new ArrayList<String>();
		String line;
		
		
		try {
			br = new BufferedReader(new FileReader (FilesImport.ANIMALNAME.getDirectory()));
			while ((line = br.readLine()) !=null) {
				animalName.add(line);
			}
			br.close();
		} catch(FileNotFoundException e) {
			System.out.println("File not found. Eror: " +e.getMessage());
		}
			catch (IOException e) {
				System.out.println("File import has failed. Error: " + e.getMessage());
		}
		//System.out.println("Done.");
		return animalName;
	}
		
	public static ArrayList<String> loadAnimalillness (){
		ArrayList<String> animalIllness;
		animalIllness = new ArrayList<String>();
		String line;
		
		//System.out.println("Reading animal illness file");
		try {
			br = new BufferedReader(new FileReader (FilesImport.ANIMALILLNESS.getDirectory()));
			while ((line = br.readLine()) !=null) {
				animalIllness.add(line);
			}
			br.close();
		} catch(FileNotFoundException e) {
			System.out.println("File not found. Error: " +e.getMessage());
		}
			catch (IOException e) {
				System.out.println("File import has failed. Error: " + e.getMessage());
		}
		//System.out.println("Done.");
		return animalIllness;
	}
	
		
		
		
}


