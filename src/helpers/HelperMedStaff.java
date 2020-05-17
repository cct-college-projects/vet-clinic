package helpers;

import enums.FilesImport;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HelperMedStaff {

    private static BufferedReader reader = null;

    public static ArrayList<String> loadGivennames() {
        ArrayList<String> givenname;
        givenname = new ArrayList<String>();
        String line;

        System.out.println("Reading file given names...");
        try {
            reader = new BufferedReader( new FileReader(FilesImport.GIVENNAME.getDirectory()));
            while ((line = reader.readLine()) != null) {
                givenname.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Error: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("File import has failed. Error: "+e.getMessage());
        }
        System.out.println("Done!");
        return givenname;
    }

    public static ArrayList<String> loadSurnames() {
        ArrayList<String> surname;
        surname = new ArrayList<String>();
        String line;
        System.out.println("Reading file surnames...");
        try {
            reader = new BufferedReader( new FileReader(FilesImport.SURNAME.getDirectory()));
            while ((line = reader.readLine()) != null) {
                surname.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Error: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("File import has failed. Error: "+e.getMessage());
        }
        System.out.println("Done!");
        return surname;
    }
    
    public static ArrayList<String> loadItTask(){
    	ArrayList<String> itTask;
    	itTask = new ArrayList<String>();
    	String line;
        System.out.println("Reading file task_it...");
        try {
            reader = new BufferedReader( new FileReader(FilesImport.TASKIT.getDirectory()));
            while ((line = reader.readLine()) != null) {
                itTask.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Error: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("File import has failed. Error: "+e.getMessage());
        }
        System.out.println("Done!");
        return itTask;
    }
    
    public static ArrayList<String> loadAccountantTask(){
    	ArrayList<String> accountantTask;
    	accountantTask = new ArrayList<String>();
    	String line;
        System.out.println("Reading file task_accountant...");
        try {
            reader = new BufferedReader( new FileReader(FilesImport.TASKACCOUNTANT.getDirectory()));
            while ((line = reader.readLine()) != null) {
            	accountantTask.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Error: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("File import has failed. Error: "+e.getMessage());
        }
        System.out.println("Done!");
        return accountantTask;
    }
    
    public static ArrayList<String> loadSecretaryTask(){
    	ArrayList<String> secretaryTask;
    	secretaryTask = new ArrayList<String>();
    	String line;
        System.out.println("Reading file task_secretary...");
        try {
            reader = new BufferedReader( new FileReader(FilesImport.TASKSECRETARY.getDirectory()));
            while ((line = reader.readLine()) != null) {
            	secretaryTask.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Error: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("File import has failed. Error: "+e.getMessage());
        }
        System.out.println("Done!");
        return secretaryTask;
    }
    
    
}
