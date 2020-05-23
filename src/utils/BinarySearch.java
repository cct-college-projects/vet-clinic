package utils;

import classes.Animals;
import classes.Employee;
import models.Veterinary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BinarySearch {

    @SuppressWarnings("unchecked")
	public static ArrayList<Animals> animals(ArrayList<Animals> arraylist, String target){

    	
        Collections.sort (arraylist, new Comparator() {
            public int compare(Object o1, Object o2) {
                Animals c1 = (Animals) o1;
                Animals c2 = (Animals) o2;
                return c1.getName().compareToIgnoreCase(c2.getName());
            }
        });

        int low = 0;
        int high = arraylist.size() -1;
        int mid = 0;

        while(low <= high) {

            mid = (high + low) / 2;

            int result = target.toLowerCase().compareTo(arraylist.get(mid).getName().toLowerCase());

            if (result == 0) {
                ArrayList adjNames = new ArrayList<>();
                adjNames = getAdjacentNamesAnimal(arraylist, mid);
                adjNames.add(arraylist.get(mid));
                return adjNames;
            } else if (result > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new ArrayList<>();
    }

    private static ArrayList<Animals> getAdjacentNamesAnimal(ArrayList<Animals> arrayList, int position){
        ArrayList<Animals> adjacentNames = new ArrayList<>();
        Boolean left = false, right = false;
        int positionToTheLeft = position, positionToTheRight = position;
        String target = arrayList.get(position).getName().toLowerCase();
        while (!left){
            positionToTheLeft--;
            if(arrayList.get(positionToTheLeft).getName().toLowerCase().equals(target)){
                adjacentNames.add(arrayList.get(positionToTheLeft));
            } else {
                left = true;
            }
        }

        while (!right){
            positionToTheRight++;
            if(arrayList.get(positionToTheRight).getName().toLowerCase().equals(target)){
                adjacentNames.add(arrayList.get(positionToTheRight));
            } else {
                right = true;
            }
        }

        return adjacentNames;
    }

    public static Employee vetyById(ArrayList<Employee> arraylist, int target){


        Collections.sort (arraylist, new Comparator() {
            public int compare(Object o1, Object o2) {
                Employee c1 = (Employee) o1;
                Employee c2 = (Employee) o2;
                return String.valueOf(c1.getEmp_id()).compareToIgnoreCase(String.valueOf(c2.getEmp_id()));
            }
        });

        int low = 0;
        int high = arraylist.size() -1;
        int mid = 0;

        while(low <= high) {

            mid = (high + low) / 2;

            int result = String.valueOf(target).compareTo(String.valueOf(arraylist.get(mid).getEmp_id()));

            if (result == 0) {
                return arraylist.get(mid);
            } else if (result > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
