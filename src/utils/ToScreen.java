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
	//Method called by the Main class Vet CLinic. It will call the main menu on the Menu Class.
    public static void showMainMenu(){
        Menu.main();
    }
    //Method to create a shortcut for System.out.println()
    public static void showMessage(String msg){
        System.out.println(msg);
    }

    //List animals by various types (e.g. list all dogs) -> ToScreen.listAnimal(this.animals.getDogList());
    //Method to list all animals when it is called by option number 5 on the main menu
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

    //Method to list all employees when it is called by option number 1 on the main menu
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

                showMessage(emp.getEmp_id() + "\t\t" + category + "\t\t" + fullName + "\t\t"+ salary + "\t\t" + salaryLevel);
            }
        } else {
            for ( Employee emp: employee) {
                showMessage(emp.toString());
            }
        }
    }
    //Method to list employees from AdminStaff performing a task only.
    //It is called by option number 4 on the main menu
    public static void listAdminStaffTask(ArrayList<Employee> admin, Boolean table) {
    	
    	showMessage(nChar('-', 50));
    	showMessage("Result: "+ admin.size()+" records.");
    	 if(table){
    		 int[] colsHeader = {7,26,60,50};
    		 showMessage(nCharIntervals('-', ' ', colsHeader));
    		 showMessage("ID\t\tCATEGORY\t\tFULL NAME\t\t\t\tTASK\t\t");
    		 showMessage(nCharIntervals('-', ' ', colsHeader));
    		 for (Employee emp: admin) {
    			 		 
    			 String fullName = "", category = "", task = "";
    			 fullName = HelperStrings.addTabToString(emp.getFullName());
    			 category = HelperStrings.addTabToString(emp.getClass().getSimpleName());
    			 task = HelperStrings.addTabToString(emp.getTask());
    			 showMessage(emp.getEmp_id() + "\t\t" + category + "\t\t" + fullName + "\t\t" + task);
    		 }
    	 }else {
    		 for(Employee emp: admin) {
    			 showMessage(emp.toString());
    		 }
    		 
    	 }
    }

}
