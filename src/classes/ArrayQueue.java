package classes;
/**
 * This interface has the methods signatures to be implemented by the personalized queue to queue up animals to be
 * attended by the veterinary
 * */
public interface ArrayQueue {

    public boolean enqueue(Animals element);

    public Animals dequeue();

    public Animals first();

    public Animals last();

    public int size();

    public boolean isEmpty();

}
