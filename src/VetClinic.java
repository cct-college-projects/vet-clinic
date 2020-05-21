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
    	
    	    	
        this.staffs = SingletonLoadStaff.getInstance();
        this.vetList     = this.staffs.getVetList();
        this.surgeonList = this.staffs.getSurgeonList();
        this.nurseList   = this.staffs.getNurseList();
        
        this.animals = SingletonLoadAnimals.getInstance();

        ToScreen.showMainMenu();

    }
    

}
