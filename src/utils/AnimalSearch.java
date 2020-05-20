package utils;

import classes.Animals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AnimalSearch {

    // solucao adaptada de duas fontes.
    // primeiro eu encontrei um link sobre como fazer binary search sobre uma string, no exemplo que encontrei, a solucao
    // era bem parecida com a do professor. O problema e que no exemplo encontrado no site 2(vide abaixo) era feito
    // com array de string(String[]), onde voce facilmente pode fazer um Arrays.sort(array) para ordenar o array de strings
    // antes de fazer a pesquisa binaria, entretanto, nos estamos usando um ArrayList de Objetos de animais, nao sendo
    // possivel usar o Arrays.sort(array) para ordenar antes da pesquisa. Para resolver isso, procurei saber como ordenar
    // ArrayList de objetos e cheguei ao site 1(vide abaixo). Unindo a informacao do site 1 com o 2, conseguir adaptar para
    // o nosso cenario, ordenando um ArrayList de objetos antes de fazer a pesquisa binaria nele.

    // Site 1 - sort() de ArrayList de objetos: https://www.guj.com.br/t/ordenar-um-arraylist/27792 author: marceloFX
    // Site 2 - binary search de uma string: https://www.geeksforgeeks.org/binary-search-a-string/ author: SamuelAntwi

    // O metodo getAdjacentSimilarNames() foi criado por mim para poder retornar tambem outros animais que tenham o mesmo nome.
    // Sem esse metodo, a pesquisa sempre retornava apenas um animal mesmo se houvessem mais animais com o mesmo nome.
    // Basicamente esse metodo verifica os nomes adjacentes a posicao do nome encontrada dentro do ArrayList, se o nome
     // for igual, ele retorna ele tambem.
    public static ArrayList<Animals> binary(ArrayList<Animals> arraylist, String target){

        Collections.sort (arraylist, new Comparator() {
            public int compare(Object o1, Object o2) {
                Animals c1 = (Animals) o1;
                Animals c2 = (Animals) o2;
                return c1.getName().compareToIgnoreCase(c2.getName());
            }
        });
        // this block must be commented or deleted before submit to the moodle. It is only for tests -------------------
        System.out.println("----------------------------------------");
        for (int i = 0; i < arraylist.size(); i++) {
            System.out.println(i+" - "+arraylist.get(i).getName());
        }
        // end of the block---------------------------------------------------------------------------------------------
        int low = 0;
        int high = arraylist.size() -1;
        int mid = 0;

        while(low <= high) {

            mid = (high + low) / 2;
            // this block must be commented or deleted before submit to the moodle. It is only for tests -------------------
            //System.out.println("low: " + low + " high: " + high + " mid: " + mid + " value: " + arraylist.get(mid).getName());
            // end of the block---------------------------------------------------------------------------------------------
            int result = target.toLowerCase().compareTo(arraylist.get(mid).getName().toLowerCase());

            if (result == 0) { //if result is found, return it
                ArrayList adjNames = new ArrayList<>();
                adjNames = getAdjacentNames(arraylist, mid);
                adjNames.add(arraylist.get(mid));
                return adjNames;
            } else if (result > 0) {// if result is greater then ignore left half
                low = mid + 1;
            } else { // if result is smaller then ignore right half
                high = mid - 1;
            }
        }
        return new ArrayList<>();
    }

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

    /*
    Essa foi uma solucao usando apenas um array de String[]. nao serve para o nosso cenario
    public static String binary(String[] array, String target){
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(i+" - "+array[i]);
        }
        int low = 0;
        int high = array.length -1;
        int mid = 0;

        // THis is the condition to stop the search
        while(low <= high) {

            mid = (high + low) / 2;
            System.out.println("low: " + low + " high: " + high + " mid: " + mid + " value: " + array[mid]);

            int result = target.toLowerCase().compareTo(array[mid].toLowerCase());

            if (result == 0) { //if result is found, return it
                return "Position "+mid+" -> "+array[mid];
            } else if (result > 0) {// if result is greater then ignore left half
                low = mid + 1;
            } else { // if result is smaller then ignore right half
                high = mid - 1;
            }
        }
        return "Not found";

    }*/
}
