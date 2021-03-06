import java.util.ArrayDeque;
import java.util.Deque;
import java.util.*;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    // fill in the definitions for enqueue() and dequeue()
        // fill in the definitions for enqueue() and dequeue()
    

    public static class QueueTwoStacks {

        private Deque<Integer> inStack = new ArrayDeque<>();
        private Deque<Integer> outStack = new ArrayDeque<>();

        public void enqueue(int item) {
            inStack.push(item);
            if(outStack.isEmpty()){
                outStack.push(item);
            }
        }

        public int dequeue() {
            /*if(outStack.isEmpty()){
                throw new NoSuchElementException("Can't dequeue from empty queue!");
            } else {
                int elementToReturn = outStack.pop();
                Iterator<Integer> iterator = inStack.iterator();
                while(!inStack.isEmpty()){
                    int newElement = inStack.pop();
                    if(newElement != elementToReturn){
                        outStack.push(newElement);
                    }
                }
                return elementToReturn;
            }*/
            
            
            try {
                int elementToReturn = outStack.pop();
                Iterator<Integer> iterator = inStack.iterator();
                while(!inStack.isEmpty()){
                    int newElement = inStack.pop();
                    if(newElement != elementToReturn){
                        outStack.push(newElement);
                    }
                }
                return elementToReturn;
            } catch(NoSuchElementException e) {
                throw new NoSuchElementException("Can't dequeue from empty queue!");
            }
        }
    }

    // tests

    @Test
    public void basicQueueOperationsTest() {
        final QueueTwoStacks q = new QueueTwoStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals("dequeue #1", 1, q.dequeue());
        assertEquals("dequeue #2", 2, q.dequeue());
        q.enqueue(4);
        assertEquals("dequeue #3", 3, q.dequeue());
        assertEquals("dequeue #4", 4, q.dequeue());
    }

    @Test(expected = Exception.class)
    public void exceptionWhenDequeueFromNewQueueTest() {
        final QueueTwoStacks q = new QueueTwoStacks();
        q.dequeue();
    }

    @Test(expected = Exception.class)
    public void exceptionWhenDequeueFromEmptyQueueTest() {
        final QueueTwoStacks q = new QueueTwoStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.dequeue();
        q.dequeue();
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