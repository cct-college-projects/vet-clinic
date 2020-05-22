package classes;

public interface ArrayQueue {

    public boolean enqueue(Animals element);

    public Animals dequeue();

    public Animals first();

    public Animals last();

    public int size();

    public boolean isEmpty();

}
