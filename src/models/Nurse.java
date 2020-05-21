package models;

import classes.MedicalStaff;

final public class Nurse extends MedicalStaff {

    public Nurse(int id, String name, String surname, int salaryLevel) {
        super(id, name, surname, salaryLevel);
        this.salaryLevel();
    }

	@Override
	public void salaryLevel() {
		// defining the random range for salary between 2100 up to 3500
		int salaryLevel = 2100 + (int)(Math.random()*(3500));
		this.salaryLevel = salaryLevel;
		
		
	}
}
