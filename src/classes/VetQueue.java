package classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VetQueue implements ArrayQueue{

    private Animals[] data;
    private int size;
    private int front;
    private int rear;
    private int capacity;

    public VetQueue(int capacity){
        this.capacity = capacity;
        this.data = new Animals[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    @Override
    public boolean enqueue(Animals element) {
        if(rear >= capacity - 1){
            return false;
        }
        if(front == -1){
            front++;
        }
        rear++;
        this.data[rear] = element;
        size++;
        return false;
    }

    @Override
    public Animals dequeue() {
        if(size == 0){
            return null;
        }
        Animals element = data[front];
        data[front] = null;
        front++;
        size--;
        return element;
    }

    @Override
    public Animals first() {
        if(size == 0){
            return null;
        }
        return data[front];
    }

    @Override
    public Animals last() {
        if(size == 0){
            return null;
        }
        return data[rear];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    public boolean has(Animals animal){
        List<Animals> queue = Arrays.asList(data);
        return queue.contains(animal);
    }

    public ArrayList<Animals> asArrayList(){

        List<Animals> arrayTolist = Arrays.asList(data);

        ArrayList<Animals> noNullelements = new ArrayList<>();

        for (int i = 0; i < arrayTolist.size(); i++) {
            if(arrayTolist.get(i) != null){
                noNullelements.add(arrayTolist.get(i));
            }
        }
        return noNullelements;
    }

    public List<Animals> asList(){
        return Arrays.asList(data);
    }

    @Override
    public String toString(){
        String result = "[ ";

        for(int i = front; i <= rear; i++){
            result += data[i].getName()+" ("+data[i].getClass().getSimpleName()+"), ";
        }

        result += "]";

        return result;
    }
}
