package models;

import classes.MedicalStaff;

final public class Surgeon extends MedicalStaff {

    public Surgeon(int id, String name, String surname, int salaryLevel) {
        super(id, name, surname, salaryLevel);
        this.salaryLevel();
    }

	@Override
	public void salaryLevel() {
	// defining the random range for salary between 6000 up to 10000
		int salaryLevel = 6000 + (int)(Math.random()*(10000));
		this.salaryLevel = salaryLevel;
		
	}
}
