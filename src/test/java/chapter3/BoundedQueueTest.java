package chapter3;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BoundedQueueTest extends TestCase {
    BoundedQueue testQueue, newQueue;

    @BeforeEach
    public void testConstructor() {
        try {
            newQueue = new BoundedQueue(0);
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        } finally {
            testQueue = new BoundedQueue(3);
        }
    }

    @Test
    public void enQueueWhenFull() {
        try {
            String p1 = "person1";
            String p2 = "person2";
            String p3 = "person3";
            String p4 = "person4";
            testQueue.enQueue(p1);
            testQueue.enQueue(p2);
            testQueue.enQueue(p3);
            testQueue.enQueue(p4);
            fail();
        } catch (IllegalStateException e) {
            assertTrue(e instanceof IllegalStateException);
        }
    }

    @Test
    public void enQueueNull() {
        try {
            String p1 = null;
            testQueue.enQueue(p1);
        } catch (NullPointerException e) {
            assertTrue(e instanceof NullPointerException);
        }
    }

    @Test
    public void enQueue() {
        String p1 = "person1";
        testQueue.enQueue(p1);
        assertFalse(testQueue.isEmpty());
    }

    @Test
    public void deQueueWhenEmpty() {
        try {
            testQueue.deQueue();
            fail();
        } catch (IllegalStateException e) {
            assertTrue(e instanceof IllegalStateException);
        }
    }

    @Test
    public void deQueue() {
        String p1 = "person1";
        testQueue.enQueue(p1);
        assertEquals(p1, testQueue.deQueue());
    }

    @Test
    public void isEmptyTrue() { assertTrue(testQueue.isEmpty());}

    @Test
    public void isEmptyFalse() {
        String p1 = "person1";
        testQueue.enQueue(p1);
        assertFalse(testQueue.isEmpty());
    }

    @Test
    public void isFullTrue() {
        String p1 = "person1";
        String p2 = "person2";
        String p3 = "person3";
        testQueue.enQueue(p1);
        testQueue.enQueue(p2);
        testQueue.enQueue(p3);
        assertTrue(testQueue.isFull());
    }

    @Test
    public void isFullFalse() {
        String p1 = "person1";
        String p2 = "person2";
        testQueue.enQueue(p1);
        testQueue.enQueue(p2);
        assertFalse(testQueue.isFull());
    }

    @Test
    public void testToString() {

        String p1 = "person1";
        String p2 = "person2";
        String p3 = "person3";
        this.testQueue.enQueue(p1);
        this.testQueue.enQueue(p2);
        this.testQueue.enQueue(p3);
        String expected = testQueue.toString();
        assertEquals(expected, "[person1, person2, person3]");
    }
}