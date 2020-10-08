import java.util.*;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    // fill in the definitions for push(), pop(), and getMax()
    

    public static class MaxStack {

        private Deque<Integer> originalStack = new ArrayDeque<>();
        private Deque<Integer> largestStack = new ArrayDeque<>();
        
        public void push(int item) {
            originalStack.push(item);    
        }

        public int pop() {
            largestStack.pop();
            return originalStack.pop();
        }

        public int getMax() {
            Iterator<Integer> stackIterator = originalStack.iterator();
            
            while(stackIterator.hasNext()){
                if(largestStack.size() > 0){
                    if(largestStack.peek() < originalStack.peek()){
                        largestStack.push(originalStack.peek());
                        System.out.println(originalStack.element());
                    }
                } else {
                    largestStack.push(originalStack.peek());
                }
                stackIterator.next();
            }
            System.out.println(largestStack.peek());
            return largestStack.peek();
        }
    }


    // tests

    @Test
    public void maxStackTest() {
        final MaxStack s = new MaxStack();
        s.push(5);
        assertEquals("check max after 1st push", 5, s.getMax());
        s.push(4);
        s.push(7);
        s.push(7);
        s.push(8);
        assertEquals("check before 1st pop", 8, s.getMax());
        assertEquals("check pop #1", 8, s.pop());
        assertEquals("check max after 1st pop", 7, s.getMax());
        assertEquals("check pop #2", 7, s.pop());
        assertEquals("check max after 2nd pop", 7, s.getMax());
        assertEquals("check pop #3", 7, s.pop());
        assertEquals("check max after 3rd pop", 5, s.getMax());
        assertEquals("check pop #4", 4, s.pop());
        assertEquals("check max after 4th pop", 5, s.getMax());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}