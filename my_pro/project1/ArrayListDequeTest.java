import static org.junit.Assert.*;
import org.junit.Test;
/* This is a JUnit test class for ArrayDeque.java */

public class ArrayListDequeTest{

    @Test
    public void insertTest(){
        int[] a = new int[]{1,2,3,4,5,6};
        int size = 13;
        ArrayDeque<Integer> b = new ArrayDeque<Integer>();
        b.addFirst(1);
        b.addFirst(2);
        b.addFirst(3);
        b.addFirst(4);
        b.addFirst(5);
        b.addFirst(5);
        b.addFirst(5);
        b.addFirst(5);
        b.addFirst(5);
        b.addFirst(5);
        b.addFirst(5);
        b.addFirst(5);
        b.addLast(6);
        

        assertEquals(a[5],(int)b.removeLast());
        assertEquals(size,(int)b.size());
    }

    public static void main(String[] args){
        jh61b.junit.TestRunner.runTests("all", ArrayListDequeTest.class);
    }
}
