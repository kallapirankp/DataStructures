import static org.junit.Assert.*;
import org.junit.Test;

/* This class is a test class for StudentArrayDeque class*/
public class TestArrayDeque1B{

    @Test
    public void testStudentArray(){
        int i =0 ,j = 0;
        FailureSequence fs = new FailureSequence();
        StudentArrayDeque<Integer> s = new StudentArrayDeque<Integer>();
       // while ( i < 1){
            s.addLast(15);
            s.removeLast();
            s.removeFirst();
            s.addFirst(10);
            s.addLast(23);
            s.removeLast();
            s.addFirst(11);
            s.removeFirst();
            s.addLast(45);
            s.addFirst(12);
         //   i++;
        //}
        ArrayDequeSolution<Integer> a = new ArrayDequeSolution<Integer>();
            a.addLast(15);
            a.removeLast();
            a.removeFirst();
            a.addFirst(10);
            a.addLast(23);
            a.removeLast();
            a.addFirst(11);
            a.removeFirst();
            a.addLast(45);
            a.addFirst(12);
          
        /*for(int k=0; k < 50; k++){
            assertEquals(a.get(k),s.get(k));
        }*/
        assertEquals(a.isEmpty(),s.isEmpty());
        //assertEquals(a.get(50),s.get(50));
    }


    public static void main(String[] args){
        jh61b.junit.TestRunner.runTests("all",TestArrayDeque1B.class);
    }

}