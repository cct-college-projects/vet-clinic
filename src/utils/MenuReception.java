package utils;

import classes.Employee;
import classes.QueueManager;
import conf.SingletonLoadStaff;
import helpers.HelperStrings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static helpers.HelperStrings.nChar;
import static utils.ToScreen.showMessage;

public class MenuReception {

    private static QueueManager queueManager = QueueManager.getInstance();
    private static ArrayList<Employee> vets = SingletonLoadStaff.getInstance().getVetList();

    public static void main(){
        int option = getUserOption();
        /** switch case option start below */
        switch (option){
            case 1 : queueManager.listAnimalsAssignedToVets(); main();
                break;
            case 2 : queueManager.listAnimalsOrderInTheQueue(); main();
                break;
            case 3 : chooseVetToCallNextPet();
                break;
            case 0 : Menu.main();
                break;
            default:
                main();
        }
    }

    public static void chooseVetToCallNextPet(){
        int choice = 0, callNextPet = 0;
        showMessage(nChar('-', 103));
        showMessage("Type the Veterinary ID which you would like to call the next pet.");
        showMessage(nChar('-', 103));
        for (Integer id : queueManager.getQueuesHolder().keySet()){
            showMessage("ID\t"+id+"\t"+ HelperStrings.addTabToString(BinarySearch.vetyById(vets, id).getName())+"\t\t"+queueManager.getQueuesHolder().get(id).toString());
        }
        showMessage("Choice: ");
        choice = getUserOptionNextPet();
        queueManager.getQueuesHolder().get(choice).dequeue();
        for (Integer id : queueManager.getQueuesHolder().keySet()){
            showMessage("ID\t"+id+"\t"+ HelperStrings.addTabToString(BinarySearch.vetyById(vets, id).getName())+"\t\t"+queueManager.getQueuesHolder().get(id).toString());
        }
        showMessage(nChar('-', 103));
        callNextPet = askForNextPet("Would you like to choose another Veterinary to call the next Pet in the queue?");
        showMessage(nChar('-', 103));

        if(callNextPet == 1){
            chooseVetToCallNextPet();
        } else {
            main();
        }
    }
    private static int getUserOption () {

        BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));

        int input;

        do {
            showMessage(nChar('-', 103));
            showMessage("Choose a number: ");
            showMessage("\t1 - List all the animals assigned to a member of medical staff");
            showMessage("\t2 - List the order in which pets will be looked after by a particular member of the medical staff");
            showMessage("\t3 - Choose a Veterinary to pass to the next pet.");
            showMessage("\t0 - Back to the main menu.");
            try {
                input = Integer.parseInt(myReader.readLine());

                if ((input < 0) || (input>3)) {
                    System.out.println("Please type in a number from 0 to 3 according to your choice");
                }

            }catch (Exception e) {
                System.out.println("Character invalid.");
                input = -1;
            }


        }
        while ((input < 0) || (input>3));

        return input;

    }

    private static int getUserOptionNextPet () {

        BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));

        int input;

        do {
            try {
                input = Integer.parseInt(myReader.readLine());

                if ((input < 1) || (input>1000)) {
                    System.out.println("Please choose a valid number.");
                }

            }catch (Exception e) {
                System.out.println("Character invalid.");
                input = -1;
            }


        }
        while (!queueManager.isVeterinaryWorking(input));

        return input;

    }

    public static int askForNextPet(String message){
        showMessage(message);
        BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
        int input;

        do {
            showMessage("Type 1 for 'Yes' or '0' for no");
            showMessage(nChar('-', 80));
            showMessage("Choice:");
            try {
                input = Integer.parseInt(myReader.readLine());

                if ((input < 0) || (input>1)) {
                    System.out.println("Please type 1 or 2.\n");
                }

            }catch (Exception e) {
                System.out.println("Character invalid. Choose 1 or 2.\n");
                input = 0;
            }


        }
        while ((input < 0) || (input>1));

        return input;

    }
}
