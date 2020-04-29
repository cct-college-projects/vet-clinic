package classes;

abstract public class Animals {
	protected String name;
	protected int age;
	protected String medicalCondition;
	
	
	
	
	public Animals(String name, int age, String medicalCondition) {
		this.setName (name);
		this.setAge (age);
		this.setMedicalCondition (medicalCondition);
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
	
	

}
