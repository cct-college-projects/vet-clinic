package models;

import classes.MedicalStaff;

final public class Veterinary extends MedicalStaff {

    public Veterinary(int id, String name, String surname, int salaryLevel) {
        super(id, name, surname, salaryLevel);
        this.salaryLevel();
    }

	@Override
	public void salaryLevel() {
		// defining the random range for salary between 2500 up to 4500
		int salaryLevel = 2500 + (int)(Math.random()*(4500));
		this.salaryLevel = salaryLevel;
		
	}
}
