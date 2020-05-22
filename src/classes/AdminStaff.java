package classes;



abstract public class AdminStaff extends Employee {
	
	public AdminStaff (int id, String name, String surname,double currentSalary, int salaryLevel, String task) {
		super(id, name, surname, currentSalary, salaryLevel, task);
		this.setCurrentSalary();
		this.setSalaryLevel();
		this.getTask();
		
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
	//This method will create randomly task for adminStaff 
	public String getTask() {
		
		if(this.task != null) {
			return this.task;
		}
		return "Employees are not engaged in any task";
		
	}

    //Each child class will have its own salaryLevel body, as the salary level is different according to the category
    // salary level range is defined in each child class	
	public abstract void setSalaryLevel();
	//The abstract method was created to allow each child class hold a different method body
	// Each child class will have its own body method to calculate the salary randomly
	public abstract void setCurrentSalary();		
	
}
