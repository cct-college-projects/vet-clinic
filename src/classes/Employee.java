package classes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DecimalFormat;


abstract public class Employee {
	//implements employees of categories Admin and Medical Staff
    protected int emp_id;
    protected String name;
    protected String surname;
    protected String dob;
    protected String gender;
    protected String email;
    protected int phone;
    protected String ppsn;
    protected int salaryLevel;
    protected double currentSalary;
    protected String title;
    protected String dateOfHire;
    protected String task;

    //Constructor to be called from MedicalStaff class. AdminStaff will use another constructor as it needs to have a different varible 
    public Employee(int id, String name, String surname, double currentSalary, int salaryLevel){

        this.setEmp_id(id);
        this.setName(name);
        this.setSurname(surname);
        this.setCurrentSalary();
        this.setSalaryLevel();
    }
    // Constructor to be called from AdminStaff class as the adminStaff class will have a different attribute than MedicalStaff class.
    public Employee(int id, String name, String surname,double currentSalary, int salaryLevel, String task){

        this.setEmp_id(id);
        this.setName(name);
        this.setSurname(surname);
        this.setCurrentSalary();
        this.setSalaryLevel();
        this.setTask(task);
    }
    
    public abstract double anualBonus();

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPpsn() {
        return ppsn;
    }

    public void setPpsn(String ppsn) {
        this.ppsn = ppsn;
    }

    public int getSalaryLevel() {
        return salaryLevel;
    }

    //Method to set the salary for the employees. Each type will hold its own body method with it is respect range of salary level
    //This method will be inherited by AdminStaff and MedicalStaff and each class will pass the method to each child class too.
    public abstract void setSalaryLevel();

    //Method to generate a randomly salary for all employees. Each child class will have its own method to generate the salary according to the category
    public double getCurrentSalary() {
    	// to convert a double salary in two decimal value
        DecimalFormat fmt = new DecimalFormat("#.##");

        return Double.parseDouble(fmt.format(currentSalary));

    }

    public abstract void setCurrentSalary();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateOfHire() {
        return dateOfHire;
    }

    public void setDateOfHire(String dateOfHire) {
        this.dateOfHire = dateOfHire;
    }



    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
  //method to get name and surname from each employee and print a full name when requested
    public abstract String getFullName();

    public int getYearsWorking() {
        if(this.dateOfHire == null){
            return 0;
        } else {
            // current date
            GregorianCalendar currentDate = new GregorianCalendar();
            int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);
            int currentMonth = currentDate.get(Calendar.MONTH) + 1;
            int currentYear = currentDate.get(Calendar.YEAR);

            // Date of hire
            int dayHired   = Integer.valueOf(this.dateOfHire.substring(0,2));
            int monthHired = Integer.valueOf(this.dateOfHire.substring(3,5));
            int yearHired  = Integer.valueOf(this.dateOfHire.substring(6,10));

            int yearsWorking;

            if (monthHired < currentMonth || (monthHired == currentMonth && dayHired <= currentDay))
                yearsWorking = currentYear - yearHired;
            else {
                yearsWorking = (currentYear - yearHired)-1;
            }

            return yearsWorking;
        }
    }

    public String toString(){
        return "ID: " + this.emp_id +" - Full name: "+ this.getFullName() + " - Category: " + this.getClass().getSimpleName();
    }
}
