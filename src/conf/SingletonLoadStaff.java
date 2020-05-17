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
	private String nameRand, surnameRand, itTaskRand, accountantTaskRand, secretaryTaskRand ;
	private ArrayList<Veterinary> vetList = new ArrayList<Veterinary>();
	private ArrayList<Surgeon> surgeonList = new ArrayList<Surgeon>();
	private ArrayList<Nurse> nurseList = new ArrayList<Nurse>();
	private ArrayList<Secretary> secretaryList = new ArrayList<Secretary>();
	private ArrayList<Itsupport> itSupportList = new ArrayList<Itsupport>();
	private ArrayList<Accountant> accountantList = new ArrayList<Accountant>();
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
		this.givennameList = HelperMedStaff.loadGivennames();
		this.surnameList = HelperMedStaff.loadSurnames();
		this.itTaskList = HelperMedStaff.loadItTask();
		this.accountantTaskList = HelperMedStaff.loadAccountantTask();
		this.secretaryTaskList = HelperMedStaff.loadSecretaryTask();
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
				case 0 : vetList.add(new Veterinary(this.incrementIdEmp(), nameRand, surnameRand));
					break;
				case 1 : surgeonList.add(new Surgeon(this.incrementIdEmp(), nameRand, surnameRand));
					break;

				default : nurseList.add(new Nurse(this.incrementIdEmp(), nameRand, surnameRand));
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
				idItTaskRand = random.nextInt(this.itTaskListSize);
				idAccountantTaskRand = random.nextInt(this.accountantTaskListSize);
				idSecretaryTaskRand = random.nextInt(this.secretaryTaskListSize);
				nameRand = givennameList.get(idNameRand);
				surnameRand = surnameList.get(idSurnameRand);
				itTaskRand = itTaskList.get(idItTaskRand);
				accountantTaskRand = accountantTaskList.get(idAccountantTaskRand);
				secretaryTaskRand = secretaryTaskList.get(idSecretaryTaskRand);
				
				
				
				switch (randomStaffType){
					case 0 : accountantList.add(new Accountant(this.incrementIdEmp(), nameRand, surnameRand, accountantTaskRand ));
						break;
					case 1 : itSupportList.add(new Itsupport(this.incrementIdEmp(), nameRand, surnameRand, itTaskRand));
						break;

					default : secretaryList.add(new Secretary(this.incrementIdEmp(), nameRand, surnameRand, secretaryTaskRand));
				}
			}
		} while (accountantList.size() < 2 || itSupportList.size() < 2 || secretaryList.size() < 2);

	}

	private int incrementIdEmp(){
		this.idEmp++;
		return this.idEmp;
	}

	public ArrayList<Veterinary> getVetList() {
		return vetList;
	}

	public ArrayList<Surgeon> getSurgeonList() {
		return surgeonList;
	}

	public ArrayList<Nurse> getNurseList() {
		return nurseList;
	}

	public ArrayList<Secretary> getSecretaryList() {
		return secretaryList;
	}

	public ArrayList<Itsupport> getItSupportList() {
		return itSupportList;
	}

	public ArrayList<Accountant> getAccountantList() {
		return accountantList;
	}
	
	

	public void close() {
		
		this.instance = null;
	}

}
