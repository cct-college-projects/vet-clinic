package classes;

public class AdminStaff extends Employee {
	
	  public double anualBonus() {

	        double bonusPercentTotal;

	        bonusPercentTotal = this.getYearsWorking() >= 10 ? 1 : this.getYearsWorking() * 0.10; // bonus of 100% or 15% depending on how many years working for the company

	        return (this.currentSalary * bonusPercentTotal) + this.currentSalary;
	    }
	

}
