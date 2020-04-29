package classes;

import java.util.Calendar;
import java.util.GregorianCalendar;

abstract public class Employee {
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

    public Employee(int id, String name, String surname){
    	this.setEmp_id(id);
        this.setName(name);
        this.setSurname(surname);
    }

    public abstract double anualBonus();

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
    
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public void setSalaryLevel(int salaryLevel) {
        this.salaryLevel = salaryLevel;
    }

    public double getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(double currentSalary) {
        this.currentSalary = currentSalary;
    }

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
}
