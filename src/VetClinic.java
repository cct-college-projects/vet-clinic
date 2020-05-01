import classes.*;
import conf.SingletonLoadStaff;
import conf.SingletonLoadAnimals;
import utils.ToScreen;

import java.util.ArrayList;

public class VetClinic {

    private ArrayList<Veterinary> vetList;
    private ArrayList<Surgeon> surgeonList;
    private ArrayList<Nurse> nurseList;
    private SingletonLoadStaff staffs;
    private SingletonLoadAnimals animals;

    public static void main(String[] args) {
        new VetClinic();
    }

    public VetClinic(){
        this.staffs = SingletonLoadStaff.getInstance();
        this.vetList     = this.staffs.getVetList();
        this.surgeonList = this.staffs.getSurgeonList();
        this.nurseList   = this.staffs.getNurseList();

        ToScreen.showStaffAll();
        
        this.animals = SingletonLoadAnimals.getInstance();
        
        ToScreen.showAnimalAll();
    }

}
