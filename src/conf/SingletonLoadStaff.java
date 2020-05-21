package conf;

import classes.*;
import helpers.HelperMedStaff;
import models.Accountant;
import models.Itsupport;
import models.Nurse;
import models.Secretary;
import models.Surgeon;
import models.Veterinary;

import java.util.ArrayList;
import java.util.Random;

public class SingletonLoadStaff {

	private int maxMedicEmployees = 30;
	private int maxStaffEmployees = 10;
	private int idEmp = 0;
	private int salaryLevel = 0;
	private String nameRand, surnameRand, itTaskRand, accountantTaskRand, secretaryTaskRand ;
	private ArrayList<Employee> vetList = new ArrayList<>();
	private ArrayList<Employee> surgeonList = new ArrayList<>();
	private ArrayList<Employee> nurseList = new ArrayList<>();
	private ArrayList<Employee> secretaryList = new ArrayList<>();
	private ArrayList<Employee> itSupportList = new ArrayList<>();
	private ArrayList<Employee> accountantList = new ArrayList<>();
	private ArrayList<String> givennameList;
	private ArrayList<String> surnameList;
	private ArrayList<String> itTaskList;
	private ArrayList<String> accountantTaskList;
	private ArrayList<String> secretaryTaskList;
	
	private Random random = new Random();
	private int idNameRand, idSurnameRand, givennameListSize, surnameListSize;
	private int idItTaskRand, idAccountantTaskRand, idSecretaryTaskRand, itTaskListSize, accountantTaskListSize, secretaryTaskListSize;
	private static SingletonLoadStaff instance = null;

	private SingletonLoadStaff() {
		//Load names
		this.givennameList = HelperMedStaff.loadGivennames();
		this.surnameList = HelperMedStaff.loadSurnames();
		//Load tasks
		this.itTaskList = HelperMedStaff.loadItTask();
		this.accountantTaskList = HelperMedStaff.loadAccountantTask();
		this.secretaryTaskList = HelperMedStaff.loadSecretaryTask();
		// create staffs
		if(!this.givennameList.isEmpty() && !this.surnameList.isEmpty() ){

			this.givennameListSize = this.givennameList.size();
			this.surnameListSize = this.surnameList.size();

			this.itTaskListSize = this.itTaskList.size();
			this.accountantTaskListSize = this.accountantTaskList.size();
			this.secretaryTaskListSize = this.secretaryTaskList.size();

			this.createMedicList();
			this.createStaffList();
		}
	}

	public static SingletonLoadStaff getInstance(){
		
		if (instance == null) {
			
			instance = new SingletonLoadStaff();
		}
		
		return (instance);
	}

	private void createMedicList(){
		int randomMedicType;
		System.out.println("Creating medics list.");
		for (int i = 0; i < this.maxMedicEmployees; i++) {
			randomMedicType = random.nextInt(3);
			idNameRand = random.nextInt(this.givennameListSize);
			idSurnameRand = random.nextInt(this.surnameListSize);
			nameRand = givennameList.get(idNameRand);
			surnameRand = surnameList.get(idSurnameRand);
			switch (randomMedicType){
				case 0 : vetList.add(new Veterinary(this.incrementIdEmp(), nameRand, surnameRand, salaryLevel));
					break;
				case 1 : surgeonList.add(new Surgeon(this.incrementIdEmp(), nameRand, surnameRand, salaryLevel));
					break;

				default : nurseList.add(new Nurse(this.incrementIdEmp(), nameRand, surnameRand, salaryLevel));
			}
		}
	}

	private void createStaffList(){
		int randomStaffType;
		System.out.println("Creating staff list.");
		do {
			if(!accountantList.isEmpty() || !itSupportList.isEmpty() || !secretaryList.isEmpty()){
				this.idEmp -= this.maxStaffEmployees;
			}
			accountantList.clear();
			itSupportList.clear();
			secretaryList.clear();
			for (int i = 0; i < this.maxStaffEmployees; i++) {
				randomStaffType = random.nextInt(3);
				idNameRand = random.nextInt(this.givennameListSize);
				idSurnameRand = random.nextInt(this.surnameListSize);

				nameRand = givennameList.get(idNameRand);
				surnameRand = surnameList.get(idSurnameRand);

				idItTaskRand = random.nextInt(this.itTaskListSize);
				idAccountantTaskRand = random.nextInt(this.accountantTaskListSize);
				idSecretaryTaskRand = random.nextInt(this.secretaryTaskListSize);

				itTaskRand 		   = itTaskList.get(idItTaskRand);
				accountantTaskRand = accountantTaskList.get(idAccountantTaskRand);
				secretaryTaskRand  = secretaryTaskList.get(idSecretaryTaskRand);
				
				
				
				switch (randomStaffType){
					case 0 : accountantList.add(new Accountant(this.incrementIdEmp(), nameRand, surnameRand, salaryLevel, accountantTaskRand ));
						break;
					case 1 : itSupportList.add(new Itsupport(this.incrementIdEmp(), nameRand, surnameRand, salaryLevel,  itTaskRand));
						break;

					default : secretaryList.add(new Secretary(this.incrementIdEmp(), nameRand, surnameRand, salaryLevel,  secretaryTaskRand));
				}
			}
		} while (accountantList.size() < 2 || itSupportList.size() < 2 || secretaryList.size() < 2);

	}

	private int incrementIdEmp(){
		this.idEmp++;
		return this.idEmp;
	}

	public ArrayList<Employee> getVetList() {
		return vetList;
	}

	public ArrayList<Employee> getSurgeonList() {
		return surgeonList;
	}

	public ArrayList<Employee> getNurseList() {
		return nurseList;
	}

	public ArrayList<Employee> getSecretaryList() {
		return secretaryList;
	}

	public ArrayList<Employee> getItSupportList() {
		return itSupportList;
	}

	public ArrayList<Employee> getAccountantList() {
		return accountantList;
	}

	public ArrayList<Employee> getAllEmployee(){
		ArrayList<Employee> allEmployee = new ArrayList<>();
		allEmployee.addAll(this.getNurseList());
		allEmployee.addAll(this.getSurgeonList());
		allEmployee.addAll(this.getVetList());
		allEmployee.addAll(this.getAccountantList());
		allEmployee.addAll(this.getItSupportList());
		allEmployee.addAll(this.getSecretaryList());

		return allEmployee;
	}

	public void close() {
		
		this.instance = null;
	}

}
