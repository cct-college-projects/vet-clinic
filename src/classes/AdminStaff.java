package classes;

public class AdminStaff extends Employee {

	
	//Bonus applied for adminstaff will be an amount of 12% per year over the current wages (currentSalaray)
	@Override
	public double anualBonus() {
		
		if (this.getYearsWorking() >= 1)
			return this.currentSalary + this.currentSalary * 0.12;
		
		else

			return 0.00;															
												
	}

}
