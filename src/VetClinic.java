import classes.*;
import conf.SingletonLoadStaff;
import models.Nurse;
import models.Surgeon;
import models.Veterinary;
import conf.SingletonLoadAnimals;
import utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static helpers.HelperStrings.nChar;
import static utils.ToScreen.showMessage;

public class VetClinic {

    public static void main(String[] args) {
        new VetClinic();
    }

    public VetClinic(){

        SingletonLoadStaff.getInstance();
        SingletonLoadAnimals.getInstance();
        QueueManager.getInstance();
        ToScreen.showMainMenu();
    }
}