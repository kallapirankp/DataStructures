import static org.junit.Assert.*;
import org.junit.Test;

/* This class is a test class for StudentLinkedListDeque class*/
public class TestLinkedListDeque1B{

    @Test
    public void testStudentLinkedList(){
        int i =0 ,j = 0;
        FailureSequence fs = new FailureSequence();
        StudentLinkedListDeque<Integer> s = new StudentLinkedListDeque<Integer>();
            s.addLast(15);
            fs.addOperation(new DequeOperation("addLast", 15));
            s.removeLast();
            fs.addOperation(new DequeOperation("removeLast"));
            
        LinkedListDequeSolution<Integer> a = new LinkedListDequeSolution<Integer>();
            a.addLast(15);
            a.removeLast();
            
        assertEquals(fs.toString(), a.removeLast(),s.removeLast());
        
    }


    public static void main(String[] args){
        jh61b.junit.TestRunner.runTests("all",TestLinkedListDeque1B.class);
    }

}