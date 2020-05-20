package classes;



public class AdminStaff extends Employee {
	
	public AdminStaff (int id, String name, String surname, String task) {
		super(id, name, surname, task);
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
		
		 
		if(this.name != null && this.surname != null){
            return this.name +' '+ this.surname +" is currently: " + this.getTask();
        } else if(this.name != null){
            return this.name;
        } else if(this.surname != null){
            return this.surname;
        } else {
            return "This employee doesn't have a name.";
        }
		
	}
	
}
