package classes;

abstract public class MedicalStaff extends Employee {
	//Implements employee of the category MedicalStaff  with ID, name and salary

    private String medicRegister;
    
    public MedicalStaff(int id, String name, String surname, double currentSalary, int salaryLevel) {
    		   	super(id, name, surname, currentSalary, salaryLevel);
    		 	
   }

   
    @Override
    public double anualBonus() {

        double bonusPercentTotal;

        bonusPercentTotal = this.getYearsWorking() >= 10 ? 1 : this.getYearsWorking() * 0.10; // bonus of 100% or 15% depending on how many years working for the company

        return (this.currentSalary * bonusPercentTotal) + this.currentSalary;
    }

    @Override
    //method to get name and surname from each employee and print a full name when requested
	public String getFullName() {
				 
		if(this.name != null && this.surname != null){
            return this.name +' '+ this.surname;
        } else if(this.name != null){
            return this.name;
        } else if(this.surname != null){
            return this.surname;
        } else {
            return "This employee doesn't have a name.";
        }
		
	}
    
    public String getMedicRegister() {
        return medicRegister;
    }

    public void setMedicRegister(String medicRegister) {
        this.medicRegister = medicRegister;
    }

    //Each child class will have its own salaryLevel body, as the salary level is different according to the category
    // salary level range is defined in each child class
    public abstract void setSalaryLevel();
    	
    //The abstract method was created to allow each child class hold a different method body
  	// Each child class will have its own body method to calculate the salary randomly
    public abstract void setCurrentSalary();
}
