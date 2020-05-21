package classes;



abstract public class AdminStaff extends Employee {
	
	public AdminStaff (int id, String name, String surname,double currentSalary, int salaryLevel, String task) {
		super(id, name, surname, currentSalary, salaryLevel, task);
		this.setCurrentSalary();
		this.setSalaryLevel();
		
	}
		
	//Bonus applied for adminStaff will be an amount of 12% per year over the current wages (currentSalaray)
	@Override
	public double anualBonus() {
			if (this.getYearsWorking() >= 1)
			return this.currentSalary + this.currentSalary * 0.12;
		else
			return 0.00;															
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

    //Each child class will have its own salaryLevel body, as the salary level is different according to the category
    // salary level range is defined in each child class
	
	public abstract void setSalaryLevel();
	
	public abstract void setCurrentSalary();
		
	
}
