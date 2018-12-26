package towerofhanoi;

import student.TestCase;

/**
 * Tests the methods in the Tower class
 * @author Dilan Prasad
 * @version 10/22/2018
 */
public class TowerTest extends TestCase {

    private Tower tower;


    /**
     * sets up tower object for testing
     */
    public void setUp() {
        tower = new Tower(Position.LEFT);
    }


    /**
     * tests position()
     */
    public void testPosition() {
        assertEquals(tower.position(), Position.LEFT);
    }


    /**
     * tests push() catching both exceptions it throws
     */
    public void testPush() {

        try {
            tower.push(null);
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }

        tower.push(new Disc(5));
        tower.push(new Disc(3));

        try {
            tower.push(new Disc(4));
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalStateException);
        }

    }
}
