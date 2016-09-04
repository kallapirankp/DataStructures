package synthesizer;

import java.util.Iterator;
/* This is an interface*/
public interface BoundedQueue<T>{

    public int capacity();
    public int fillCount();
    public void enqueue(T x);
    public T dequeue();
    public T peek();
    public Iterator<T> iterator();

    /* Default methods*/
    public default boolean isEmpty(){
        return (fillCount() == 0);
    }

    public default boolean isFull(){
        return capacity() == fillCount();
    }

}