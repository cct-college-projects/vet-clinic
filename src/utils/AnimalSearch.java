package utils;

import classes.Animals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AnimalSearch {
	
	public static ArrayList<Animals> binary(ArrayList<Animals> arraylist, String target){

        Collections.sort (arraylist, new Comparator() {
            public int compare(Object o1, Object o2) {
                Animals c1 = (Animals) o1;
                Animals c2 = (Animals) o2;
                return c1.getName().compareToIgnoreCase(c2.getName());
            }
        });
        
        System.out.println("----------------------------------------");
        for (int i = 0; i < arraylist.size(); i++) {
            System.out.println(i+" - "+arraylist.get(i).getName());
        }
       
        int low = 0;
        int high = arraylist.size() -1;
        int mid = 0;

        while(low <= high) {

            mid = (high + low) / 2;
            
            int result = target.toLowerCase().compareTo(arraylist.get(mid).getName().toLowerCase());

            if (result == 0) { 
                ArrayList adjNames = new ArrayList<>();
                adjNames = getAdjacentNames(arraylist, mid);
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
	//Method to compare adjacent names and return the desired type of animal with the same name
	private static ArrayList<Animals> getAdjacentNames(ArrayList<Animals> arrayList, int position){
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
}
