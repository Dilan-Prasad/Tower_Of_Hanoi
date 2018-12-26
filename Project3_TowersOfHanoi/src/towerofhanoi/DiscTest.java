package towerofhanoi;

/**
 * Tests methods of the Disc class
 * @author dilanprasad
 * @version 10/22/2018
 */
public class DiscTest extends student.TestCase {

    private Disc testDisc;


    /**
     * Initializes disc used for testing
     */
    public void setUp() {
        testDisc = new Disc(3);
    }


    /**
     * Tests the compareTo() method when comparing two discs
     */
    public void testCompareTo() {

        boolean compareToTest = false;

        Disc tempDisc = new Disc(4);

        try {
            tempDisc.compareTo(null);
        }
        catch (Exception e) {
            compareToTest = true;
        }
        assertTrue(compareToTest);
        assertTrue(testDisc.compareTo(tempDisc) < 0);
    }


    /**
     * Test toString()
     * Supposed to return the width of the disc
     */
    public void testToString() {
        assertEquals("3", testDisc.toString());
    }


    /**
     * Test the equals() method when comparing two discs
     * Returns true if their widths are the same
     */
    public void testEquals() {
        Disc tester = new Disc(15);
        Disc otherTester = new Disc(10);
        Disc nullDisc = null;
        Disc equalTester = new Disc(3);

        assertTrue(otherTester.equals(otherTester));
        assertFalse(otherTester.equals("10"));
        assertFalse(tester.equals(15));
        assertFalse(tester.equals(nullDisc));
        assertTrue(testDisc.equals(equalTester));
        assertFalse(tester.equals(otherTester));
    }
}
