/** This class implements double listed queue 
* with array implementation*/
public class ArrayDeque<Blorp>{
    private Blorp[] items;
    private int size;
    private int front = 1;
    private int back = 0;
    private int capacity = 8;

    public ArrayDeque(){
        items = (Blorp[]) new Object[capacity];
        size = 0;
    }

    public void resize(int cap){
        Blorp[] a = (Blorp[]) new Object[cap];
        int i=0;
        if(back > front){
            for(int k=0; k<items.length;k++){
                a[k] = items[k];
            }
            front = 0;
            back = size-1;
            items = a;
        }
        if(front > back){
            for(int j=front; j<items.length;j++){
                a[i] = items[j];
                i++;
            }
            for(int j=0; j<front;j++){
                a[i] = items[j];
                i++;
            }
            front = 0;
            back = size-1;
            items = a;
        }

    }

    public void addFirst(Blorp item){
        if(size == capacity){
            capacity = capacity*2;
            resize(capacity);
        }
        front = (front-1)%capacity;
        if(front < 0){
            front = capacity - 1;
        }
        items[front] = item;
        size++;
    }

    public void addLast(Blorp item){
         if(size == capacity){
            capacity = capacity*2;
            resize(capacity);
        }
        back = (back+1)%capacity;
        items[back] = item;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        if(isEmpty()){
             System.out.println("the array is empty");
        }
        else if(back > front && front == 1){
            for(int i=1; i<= back;i++){
                System.out.println(items[i]);
            }
        }else if(back > front && front == 0){
            for (int i=0; i<= back;i++){
                System.out.println(items[i]);
            }
        }else if(front > back){
            for(int i=front; i<items.length; i++){
                System.out.println(items[i]);
            }
            for (int i=0; i<=back; i++) {
                System.out.println(items[i]);
            }
        }else if(front == back){
            System.out.println(items[back]);
        }

    }

    public Blorp removeFirst(){
        if(size == 0){
            return null;
        }
        Blorp removedItem = items[front];
        items[front] = null;
        front = (front+1)%capacity;
        size--;
        return removedItem;
    }

    public Blorp removeLast(){
        if(size == 0){
            return null;
        }
        Blorp removedItem = items[back];
        items[back] = null;
        back = (back-1)%capacity;
        if(back < 0){
            back = capacity - 1;
        }
        size --;
        return removedItem;
    }

    public Blorp get(int index){
        int count = 0;
        int i = front;
        if(index > capacity){
            return null;
        }
        while(count != index){
            i = (i+1)%capacity;
            count++;
        }
        return items[i];
    }

}