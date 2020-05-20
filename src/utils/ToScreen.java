package utils;

import conf.SingletonLoadStaff;
import conf.SingletonLoadAnimals;
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
    

}
