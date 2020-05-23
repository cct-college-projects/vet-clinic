package utils;

import classes.Employee;

import java.util.ArrayList;
////Method to search an employee by name using linear search approach
public class EmployeeSearch {
    public static ArrayList<Employee> employee(ArrayList<Employee> arraylist, String target){
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee: arraylist ) {
            if(employee.getFullName().toLowerCase().contains(target.toLowerCase())){
                result.add(employee);
            }
        }
        return result;
    }
}
