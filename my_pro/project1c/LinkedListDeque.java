/** This class implements doubly listed queue 
* using linkedlist implementation*/
public class LinkedListDeque<Blorp> implements Deque<Blorp>{
    
    public class Node{
        public Blorp item;
        public Node next;
        public Node previous;

        public Node(Node p, Blorp i, Node n){
            previous = p;
            item = i;
            next = n;

        }       
    } 

    // Instance variables
    private Node sentinel;
    public int size;
    //Creates an empty DequeList
    public LinkedListDeque(){
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.previous = sentinel;
        sentinel.next = sentinel.previous;
        

    }

    @Override
    public void addFirst(Blorp item){
        if(size == 0){
            sentinel.next  = new Node(sentinel, item, sentinel.next);
            sentinel.previous = sentinel.next;
            size++;

        }
        else{
            Node a  = new Node(sentinel, item, sentinel.next);
            sentinel.next = a;
            sentinel.next.next.previous = sentinel.next;
            //sentinel.previous.previous = a;
            size++;
        }

    }

    @Override
    public void addLast(Blorp item){
        if(size == 0){
            sentinel.next = new Node(sentinel, item, sentinel.next);
            sentinel.previous = sentinel.next;
            size++;
        }
        else{
            Node newNode = new Node(sentinel.previous, item, sentinel);
            sentinel.previous.next = newNode;
            sentinel.previous = newNode;
            size++;
        }
    }

    @Override
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else{
            return false;
        } 
            

    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        int num = size;
        Node p = sentinel;

        p = p.next;
        while(num > 0){
            System.out.print(" "+p.item );
            p=p.next;
            num--;
        }
    }
    @Override
    public Blorp removeFirst(){
        Node a = sentinel.next;
        sentinel.next = a.next;
        a.next.previous = sentinel;
        a.next = null;
        a.previous = null;
        size--;
        return a.item;
        
    }
    @Override
    public Blorp removeLast(){
        Node a = sentinel.previous;
        sentinel.previous = a.previous.next;
        a.previous.next = sentinel;
        a.next = null;
        a.previous = null;
        size--;
        return a.item; 
        
    }

    @Override
    public Blorp get(int index){
        Node p = sentinel.next;
        int count = 0;
        if(index == count){
            return p.item;
        }
        else{
            while(count < index){
                p = p.next;
                count++;
            }
            return p.item;
         }
    }

    public Blorp getRecursive(int index){
        int count = 0;
        Node p = sentinel.next;
        Blorp item = recursiveHelper(index, count, p);
        return item;
    }

    public Blorp recursiveHelper(int index, int count, Node p){
        if(index == count){
            return p.item;
        }
        return recursiveHelper(index, ++count, p.next);


    }

}