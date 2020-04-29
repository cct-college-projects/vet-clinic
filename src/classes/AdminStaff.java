package classes;

public class AdminStaff extends Employee {

	public AdminStaff (int id, String name, String surname) {
		super(id, name, surname);
		
	}
		
	//Bonus applied for adminStaff will be an amount of 12% per year over the current wages (currentSalaray)
	@Override
	public double anualBonus() {
		
		if (this.getYearsWorking() >= 1)
			return this.currentSalary + this.currentSalary * 0.12;
		else
			return 0.00;															
	}

	
	
}
