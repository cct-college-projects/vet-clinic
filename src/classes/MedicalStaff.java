package classes;

public class MedicalStaff extends Employee {
    private String medicRegister;

    @Override
    public double anualBonus() {

        double bonusPercentTotal;

        bonusPercentTotal = this.getYearsWorking() >= 10 ? 1 : this.getYearsWorking() * 0.10; // bonus of 100% or 15% depending on how many years working for the company

        return (this.currentSalary * bonusPercentTotal) + this.currentSalary;
    }

    public String getMedicRegister() {
        return medicRegister;
    }

    public void setMedicRegister(String medicRegister) {
        this.medicRegister = medicRegister;
    }
}
