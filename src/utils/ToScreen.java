package utils;

import classes.Animals;
import classes.Employee;
import conf.SingletonLoadStaff;
import conf.SingletonLoadAnimals;
import helpers.HelperStrings;

import java.util.ArrayList;

import static helpers.HelperStrings.nChar;
import static helpers.HelperStrings.nCharIntervals;

public class ToScreen {

    public static void showMainMenu(){
        Menu.main();
    }

    public static void showMessage(String msg){
        System.out.println(msg);
    }

    //List animals by various types (e.g. list all dogs) -> ToScreen.listAnimal(this.animals.getDogList());
    public static void listAnimal(ArrayList<Animals> animals, Boolean table){

        showMessage("Result: "+ animals.size()+" records.");
        if(animals.size() > 0){
            if(table){
                int[] colsHeader = {11, 23, 27, 60};
                showMessage(nCharIntervals('-', ' ', colsHeader));
                showMessage("TYPE\t\tNAME\t\tAGE\tMEDICAL CONDITIONAL");
                showMessage(nCharIntervals('-', ' ', colsHeader));
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


    public static void listEmployee(ArrayList<Employee> employee, Boolean table){

        showMessage(nChar('-', 50));
        showMessage("Result: "+employee.size()+" records.");

        if(table){
            int[] colsHeader = {7,25,50,50,50};
            showMessage(nCharIntervals('-', ' ', colsHeader));
            showMessage("ID\t\tCATEGORY\t\tFULL NAME\t\tSALARY\t\t\tSALARY LEVEL\t\t");
            showMessage(nCharIntervals('-', ' ', colsHeader));
            for (Employee emp: employee) {
                String fullName = "", category = "";
                double salary = emp.getCurrentSalary();
                int salaryLevel = emp.getSalaryLevel();
                fullName = HelperStrings.addTabToString(emp.getFullName());
                category = HelperStrings.addTabToString(emp.getClass().getSimpleName());
//                SingletonLoadStaff staffs = SingletonLoadStaff.getInstance();
                showMessage(emp.getEmp_id() + "\t\t" + category + "\t\t" + fullName + "\t"+ salary + "\t\t" + salaryLevel);
            }
        } else {
            for ( Employee emp: employee) {
                showMessage(emp.toString());
            }
        }
    }

}