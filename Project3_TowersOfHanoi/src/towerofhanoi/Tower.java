package towerofhanoi;

/**
 * Tower class 
 * @author Dilan Prasad
 * @version 10/22/2018
 */
public class Tower extends LinkedStack<Disc> {

    private Position position;


    /**
     * Creates the tower objects
     * 
     * @param position
     *            position of the tower defined by 
     *            the position of the enumerator
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }


    /**
     * @return the position of the tower
     */
    public Position position() {
        return position;
    }


    /**
     * Pushes the parametrized disc onto the tower
     * Checks if disc is smaller than that which is already atop the tower
     * If the above is true or the tower is empty, the disc is added
     * Under failure, an IllegalStateException will be thrown
     */
    @Override
    public void push(Disc disc) {

        if (disc == null) {
            throw new IllegalArgumentException();
        }

        if (this.isEmpty() || disc.compareTo(this.peek()) < 0) {
            super.push(disc);
            return;
        }

        throw new IllegalStateException();
    }
}
