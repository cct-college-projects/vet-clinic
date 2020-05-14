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

        System.out.println("Readin file given names...");
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
        System.out.println("Readin file surnames...");
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

}
