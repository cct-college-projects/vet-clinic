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
/**
 * This project is part of an assignment to demonstrate knowledge acquired in the classroom on Java Language. Concepts
 * such as Interface, binary research, Enum, Heranca, polymorphism, among others are addressed in this project.
 *
 * This project consists of a veterinary control application where it is possible to view the staff and animals that
 * will be placed in a queue to be attended by the veterinarians. All interaction is done through simple menus shown on the console.
 *
 * Programme Title/Year: HDIP in Computing (Sept 2019 cohort)
 * Module Title(s): Software Development Fundamentals - Algorithms & Constructs
 * Lecturer Name(s): Ken Healy and Amilcar Aponte
 *
 * Assessment Title: Vet Clinic
 *
 * This is the main class of the application.
 *
 * @author Leandro <a href="https://github.com/Leandro806">GitHub</a>
 * @author Rafael Ricardo <a href="https://github.com/rafaelricardo-rj">GitHub</a>
 *
 * */
public class VetClinic {

    public static void main(String[] args) {
        new VetClinic();
    }

    /**
     * As soon as the application start, the constructor call 4 methods.
     * */
    public VetClinic(){

        /** This method is responsible for create a all the staff of the clinic. It read the files with names and creates
         * the workers. It has been choose to be a singleton due the facility to access the same data from any part of the application */
        SingletonLoadStaff.getInstance();

        /** Similar with the class above but create Animals instead of Employee */
        SingletonLoadAnimals.getInstance();

        /** After employee and animals were creted, it is time to match some animals with some doctors put them in a queue.
         * This class also manage everu iteraction with queue */
        QueueManager.getInstance();

        /** this is host some method to be used showing information in the console.   */
        ToScreen.showMainMenu();
    }
}