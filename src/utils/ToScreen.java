package utils;

import classes.Animals;
import conf.SingletonLoadStaff;
import conf.SingletonLoadAnimals;
import helpers.HelperStrings;

import java.util.ArrayList;

public class ToScreen {

    public static void showMessage(String msg){
        System.out.println(msg);
    }

    public static void showStaffAll(){
        SingletonLoadStaff staffs = SingletonLoadStaff.getInstance();
        showMessage("### Employees ###");
        for (int i = 0; i < staffs.getAllEmployee().size(); i++) {
            showMessage(staffs.getAllEmployee().get(i).getEmp_id()+" - "+staffs.getAllEmployee().get(i).getClass().getSimpleName()+" - "+staffs.getAllEmployee().get(i).getFullName());
        }

    }
    
    public static void showAnimalAll(){
        SingletonLoadAnimals animals = SingletonLoadAnimals.getInstance();
        
        showMessage("### List of all animals ###");
        for (int i = 0; i < animals.getAllAnimals().size(); i++) {
            showMessage(animals.getAllAnimals().get(i).getAnimal_id()+" - "+ animals.getAllAnimals().get(i).getFullInformation());
        }
    }

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
    

}
