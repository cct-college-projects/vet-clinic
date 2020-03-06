import classes.MedicalStaff;

public class VetClinic {
    public static void main(String[] args) {
        new VetClinic();
    }

    public VetClinic(){
        test();
    }

    private void test(){

        MedicalStaff medstaff = new MedicalStaff();
        medstaff.setName("Rafael");
        medstaff.setDateOfHire("02/10/2012");
        medstaff.setCurrentSalary(5000.00);

        System.out.println(
                medstaff.getName()
                        .concat(" is working at this company for ")
                        .concat(String.valueOf(medstaff.getYearsWorking()))
                        .concat(" years."));
        System.out.println("Current salary: " + medstaff.getCurrentSalary());
        System.out.println("Anual bonus: €" + medstaff.anualBonus());
    }
}
