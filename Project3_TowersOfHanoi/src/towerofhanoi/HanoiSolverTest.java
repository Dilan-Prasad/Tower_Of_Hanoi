package towerofhanoi;

/**
 * Tests the methods in the HanoiSolver class
 * @author dilanprasad
 * @version 10/22/2018
 */
public class HanoiSolverTest extends student.TestCase {

    private HanoiSolver hanoiSolver;


    /**
     * Set up the HanoiSolver used for testing
     */
    public void setUp() {
        hanoiSolver = new HanoiSolver(6);
        for (int j = 6; j > 0; j--) {
            hanoiSolver.getTower(Position.LEFT).push(new Disc(j));
        }
    }


    /**
     * Test discs() method
     * returns width of the disc at hand
     */
    public void testDiscs() {
        assertEquals(6, hanoiSolver.discs());
    }


    /**
     * Tests getTower() method
     */
    public void testGetTower() {
        assertEquals(Position.LEFT, hanoiSolver.getTower(Position.LEFT)
            .position());
        assertEquals(Position.MIDDLE, hanoiSolver.getTower(Position.MIDDLE)
            .position());
        assertEquals(Position.RIGHT, hanoiSolver.getTower(Position.RIGHT)
            .position());
        assertEquals(Position.LEFT, hanoiSolver.getTower(Position.OTHER)
            .position());
    }

    /**
     * Tests the toString() method on a HanoiSolver object
     */
    public void testToString() {
        assertEquals("[1, 2, 3, 4, 5, 6][0][0]", hanoiSolver.toString());
    }
    
    /**
     * Tests the solve() method and all the private methods it invokes
     */
    public void testSolve() {
        hanoiSolver.solve();
        assertEquals(6, hanoiSolver.getTower(Position.RIGHT).size());
        assertEquals(0, hanoiSolver.getTower(Position.MIDDLE).size());
        assertEquals(0, hanoiSolver.getTower(Position.LEFT).size());
    }
}
