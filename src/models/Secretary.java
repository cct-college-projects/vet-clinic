package models;



import classes.AdminStaff;

final public class Secretary extends AdminStaff {
	public Secretary (int id, String name, String surname, double currentSalary, int salaryLevel, String task) {
		super(id, name, surname, currentSalary, salaryLevel, task);
		this.setCurrentSalary();
	}
	
	@Override
	//Method to set a randomly salary for the employees that belongs to this class
	public void setCurrentSalary() {
	 	// defining the random range for salary between 1100 up to 2000
		double currentSalary = 1100.00 + (int)(Math.random()*(2000.00));
		this.currentSalary = currentSalary;
	}
	@Override
	//Setting the level salary to the category
	public void setSalaryLevel() {
		this.salaryLevel = 1;
	 		
	}

}
