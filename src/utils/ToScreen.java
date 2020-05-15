package utils;

import conf.SingletonLoadStaff;
import conf.SingletonLoadAnimals;
public class ToScreen {

    public static void showMessage(String msg){
        System.out.println(msg);
    }

    public static void showStaffAll(){
        SingletonLoadStaff staffs = SingletonLoadStaff.getInstance();
        showMessage("### VETS ###");
        for (int i = 0; i < staffs.getVetList().size(); i++) {
            showMessage(staffs.getVetList().get(i).getEmp_id()+" - "+staffs.getVetList().get(i).getFullName());
        }
        showMessage("### SURGEONS ###");
        for (int i = 0; i < staffs.getSurgeonList().size(); i++) {
            showMessage(staffs.getSurgeonList().get(i).getEmp_id()+" - "+staffs.getSurgeonList().get(i).getFullName());
        }
        showMessage("### NURSES ###");
        for (int i = 0; i < staffs.getNurseList().size(); i++) {
            showMessage(staffs.getNurseList().get(i).getEmp_id()+" - "+staffs.getNurseList().get(i).getFullName());
        }
        showMessage("### SECRETARY ###");
        for (int i = 0; i < staffs.getSecretaryList().size(); i++) {
            showMessage(staffs.getSecretaryList().get(i).getEmp_id()+" - "+staffs.getSecretaryList().get(i).getFullName());
        }
        showMessage("### IT SUPPORT ###");
        for (int i = 0; i < staffs.getItSupportList().size(); i++) {
            showMessage(staffs.getItSupportList().get(i).getEmp_id()+" - "+staffs.getItSupportList().get(i).getFullName());
        }
        showMessage("### ACCOUNTANT ###");
        for (int i = 0; i < staffs.getAccountantList().size(); i++) {
            showMessage(staffs.getAccountantList().get(i).getEmp_id()+" - "+staffs.getAccountantList().get(i).getFullName());
        }

    }
    
    public static void showAnimalAll(){
        SingletonLoadAnimals animals = SingletonLoadAnimals.getInstance();
        
        showMessage("### DOG ###");
        for (int i = 0; i < animals.getDogList().size(); i++) {
            showMessage(animals.getDogList().get(i).getAnimal_id()+" - "+animals.getDogList().get(i).getFullInformation());
        }
        
        showMessage("### CAT ###");
        for (int i = 0; i < animals.getCatList().size(); i++) {
            showMessage(animals.getCatList().get(i).getAnimal_id()+" - "+animals.getCatList().get(i).getFullInformation());
        }
        
        showMessage("### BIRD ###");
        for (int i = 0; i < animals.getBirdList().size(); i++) {
            showMessage(animals.getBirdList().get(i).getAnimal_id()+" - "+animals.getBirdList().get(i).getFullInformation());
        }
    }

}
