package classes;

abstract public class MedicalStaff extends Employee {


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
	public String getFullName() {
				 
		if(this.name != null && this.surname != null && this.salaryLevel != 0){
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
	
	public abstract void setCurrentSalary();
}
