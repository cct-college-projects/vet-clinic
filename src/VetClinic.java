import classes.*;
import conf.SingletonLoadStaff;
import models.Nurse;
import models.Surgeon;
import models.Veterinary;
import conf.SingletonLoadAnimals;
import utils.*;

import java.util.ArrayList;

public class VetClinic {

    private ArrayList<Employee> vetList;
    private ArrayList<Employee> surgeonList;
    private ArrayList<Employee> nurseList;
    private SingletonLoadStaff staffs;
    private SingletonLoadAnimals animals;

    public static void main(String[] args) {
        new VetClinic();
    }

    public VetClinic(){
    	
    	ToScreen menu = new ToScreen();
    	System.out.println(menu.getUserOption()); 
    	    	
//        this.staffs = SingletonLoadStaff.getInstance();
//        this.vetList     = this.staffs.getVetList();
//        this.surgeonList = this.staffs.getSurgeonList();
//        this.nurseList   = this.staffs.getNurseList();
//
//        ToScreen.showStaffAll();
//        
//        this.animals = SingletonLoadAnimals.getInstance();
//;
//
//       ToScreen.showAnimalAll();
//
//        // Search for a desired name in a list of one type of animal
//      searchAnimal(this.animals.getDogList(), "Jax");
//
//        
//        //Search for a specific name on the Animal list. It will bring all type of animals with the desired name.
//        //searchAnimal(this.animals.getAllAnimals(), "toto");
//    }
////    Method to show all the animals with their attributes in a list
//    public void searchAnimal(ArrayList<Animals> arrayList, String name){
//        ArrayList<Animals> searchResult = AnimalSearch.binary(arrayList, name);
//        System.out.println("-------------------------------------------------------");
//        System.out.println("Result: ");
//        for (int i = 0; i < searchResult.size(); i++) {
//            System.out.println("ID: "+searchResult.get(i).getAnimal_id()+" - Animal: "+searchResult.get(i).getClass().getSimpleName()+" - "+searchResult.get(i).getFullInformation());
//        }
    }
    

}
