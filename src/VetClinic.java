import classes.*;
import conf.SingletonLoadStaff;
import models.Nurse;
import models.Surgeon;
import models.Veterinary;
import conf.SingletonLoadAnimals;
import utils.*;

import java.util.ArrayList;

public class VetClinic {

    public static void main(String[] args) {
        new VetClinic();
    }

    public VetClinic(){

        SingletonLoadStaff.getInstance();
        SingletonLoadAnimals.getInstance();

        ToScreen.showMainMenu();

    }
    

}
