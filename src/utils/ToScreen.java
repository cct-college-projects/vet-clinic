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
  //Option 1
    public static void showStaffAll(){
        SingletonLoadStaff staffs = SingletonLoadStaff.getInstance();
        showMessage("### Employees ###");
        for (int i = 0; i < staffs.getAllEmployee().size(); i++) {
            showMessage("ID: " + staffs.getAllEmployee().get(i).getEmp_id()+" - Type: "+staffs.getAllEmployee().get(i).getClass().getSimpleName()+" - Name: "+staffs.getAllEmployee().get(i).getName() +" " + staffs.getAllEmployee().get(i).getSurname() +" - Salary: " + staffs.getAllEmployee().get(i).getSalaryLevel());
        }
        
        //Option 2 print by category

    }
    //Option 3 
    public static void showAdminStaffTask() {
    	SingletonLoadStaff staffs = SingletonLoadStaff.getInstance();
        showMessage("### Admin Staff Task ###");
        for (int i = 0; i < staffs.getItSupportList().size(); i++) {
            showMessage(staffs.getItSupportList().get(i).getEmp_id() +" - "+staffs.getItSupportList().get(i).getClass().getSimpleName()+" - "+staffs.getItSupportList().get(i).getFullName());
        }
        for (int i = 0; i < staffs.getAccountantList().size(); i++) {
            showMessage(staffs.getAccountantList().get(i).getEmp_id() +" - "+staffs.getAccountantList().get(i).getClass().getSimpleName()+" - "+staffs.getAccountantList().get(i).getFullName());
        }
        for (int i = 0; i < staffs.getSecretaryList().size(); i++) {
            showMessage(staffs.getSecretaryList().get(i).getEmp_id() +" - "+staffs.getSecretaryList().get(i).getClass().getSimpleName()+" - "+staffs.getSecretaryList().get(i).getFullName());
        }
    }
      //Option 5
    public static void showAnimalAll(){
        SingletonLoadAnimals animals = SingletonLoadAnimals.getInstance();
        
        showMessage("### List of all animals ###");
        for (int i = 0; i < animals.getAllAnimals().size(); i++) {
            showMessage(animals.getAllAnimals().get(i).getAnimal_id()+" - "+ animals.getAllAnimals().get(i).getFullInformation());
        }
    }

    //Option 6
    
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


