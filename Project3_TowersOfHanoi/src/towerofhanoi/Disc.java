package towerofhanoi;

import java.awt.Color;
import CS2114.Shape;
import student.TestableRandom;

/**
 * Creates a Disc object that is a shape
 * @author Dilan Prasad
 * @version 10/22/2018
 */
public class Disc extends Shape implements Comparable<Disc> {

    /**
     * Disc constructor
     * 
     * @param width of the disc being created
     */
    public Disc(int width) {
        super(0, 0, width, GameWindow.getDiscHeight());
        TestableRandom randomNum = new TestableRandom();
        int red = randomNum.nextInt(255);
        int green = randomNum.nextInt(255);
        int blue = randomNum.nextInt(255);
        this.setBackgroundColor(new Color(red, green, blue));
    }


    /**
     * Test if two discs are of equal width
     * @param obj Disc being compared with local disc
     * @return boolean regarding whether or not the two discs 
     * are of equal width
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (this.getClass() == obj.getClass()) {
            Disc tempDisc = (Disc)obj;

            return this.getWidth() == tempDisc.getWidth();
        }
        else {
            return false;
        }
    }


    /**
     * Returns the width of the Disc as a string
     * @return String representation of Disc
     */
    public String toString() {
        return this.getWidth() + "";
    }


    /**
     * Used for comparing the width of two discs
     * @param otherDisc Disc that is being compares to local one
     * @return difference of the discs widths
     */
    public int compareTo(Disc otherDisc) {
        if (otherDisc == null) {
            throw new IllegalArgumentException();
        }
        return this.getWidth() - otherDisc.getWidth();
    }

}
