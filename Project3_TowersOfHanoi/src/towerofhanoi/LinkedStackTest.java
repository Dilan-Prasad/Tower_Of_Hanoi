package towerofhanoi;

/**
 * @author Dilan Prasad
 * @version 10/22/2018
 */
public class LinkedStackTest extends student.TestCase {

    private LinkedStack<String> testerStack;


    /**
     * Initializes the testerStack variable for testing
     */
    public void setUp() {
        testerStack = new LinkedStack<String>();
    }


    /**
     * Makes sure size() returns correct value
     */
    public void testSize() {
        assertEquals(testerStack.size(), 0);
    }


    /**
     * tests toString() method
     */
    public void testToString() {

        assertEquals(testerStack.toString(), "[0]");

        testerStack.push("First push");
        testerStack.push("Second push");

        assertEquals("[Second push, First push]", testerStack.toString());
    }


    /**
     * tests clear() method for clearing a stack
     */
    public void testClear() {
        testerStack.push("test string");
        testerStack.clear();
        assertEquals(0, testerStack.size());
    }


    /**
     * Tests when stack is either empty or not
     */
    public void testIsEmpty() {
        assertTrue(testerStack.isEmpty());
        testerStack.push("test string");
        assertFalse(testerStack.isEmpty());
    }


    /**
     * tests peek() and makes sure exception is thrown appropriately
     */
    public void testPeek() {
        testerStack.push("test string");
        assertEquals("test string", testerStack.peek());

        testerStack.clear();
        
        boolean success = false;
        try {
            testerStack.peek();
        }
        catch (Exception e) {
            success = true;
        }
        assertTrue(success);
    }


    /**
     * tests pop() and makes sure exception is thrown appropriately
     */
    public void testPop() {
        testerStack.push("testString");
        assertEquals(testerStack.size(), 1);
        assertEquals("testString", testerStack.pop());
        assertEquals(testerStack.size(), 0);
        
        boolean success = false;
        try {
            testerStack.pop();
        }
        catch (Exception e) {
            success = true;
        }
        assertTrue(success);
    }


    /**
     * tests push() method
     */
    public void testPush() {
        testerStack.push("test string");
        assertEquals(testerStack.size(), 1);
    }

}
