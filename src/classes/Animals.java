package classes;

abstract public class Animals {
	protected int animal_id;
	protected String name;
	protected int age;
	protected String medicalCondition;
	
	
	
	
	public Animals(int animal_id, String name, String medicalCondition) {
		this.setAnimal_id(animal_id);
		this.setName (name);
		
		this.setMedicalCondition (medicalCondition);
	}
	
	public int getAnimal_id() {
		return animal_id;
	}

	public void setAnimal_id(int animal_id) {
		this.animal_id = animal_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMedicalCondition() {
		return medicalCondition;
	}
	public void setMedicalCondition(String medicalCondition) {
		this.medicalCondition = medicalCondition;
	}
	
	public String getFullInformation(){
        if(this.name != null && this.medicalCondition != null){
            return this.name + "- age: " + " - Illness: " + medicalCondition;
        } else if(this.name != null){
            return this.name;
        } else if(this.medicalCondition != null){
            return this.medicalCondition;
        } else {
            return "This animal doesn't have a name.";
        }
    }
	

}
