package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T>{

    /*Instance variables*/
    protected int fillCount;
    protected int capacity;

    //concrete methods
    public int capacity(){
        return this.capacity;
    }

    public int fillCount(){
        return this.fillCount;
    }

    public boolean isEmpty(){
        return (fillCount() == 0);
    }

    public boolean isFull(){
        return fillCount() == capacity();
    }

    public abstract T peek();
    public abstract T dequeue();
    public abstract void enqueue(T x);


}