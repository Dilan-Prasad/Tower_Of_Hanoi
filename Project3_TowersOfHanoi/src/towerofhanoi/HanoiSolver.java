package towerofhanoi;

import java.util.Observable;

/**
 * @author Dilan Prasad
 * @version 10/22/2018
 */

public class HanoiSolver extends Observable {

    private Tower leftTower;
    private Tower middleTower;
    private Tower rightTower;

    private int numDiscs;


    /**
     * creates a HanoiSolver object with a specified amount of discs
     * 
     * @param discs
     *            the number playable discs
     */
    public HanoiSolver(int discs) {
        numDiscs = discs;
        leftTower = new Tower(Position.LEFT);
        middleTower = new Tower(Position.MIDDLE);
        rightTower = new Tower(Position.RIGHT);
    }


    /**
     * @return the number of discs in the game
     */
    public int discs() {
        return numDiscs;
    }


    /**
     * gets the tower from the parameterized position 
     * 
     * @param pos 
     *            the position of the specific tower
     * @return the tower in the specific position
     */
    public Tower getTower(Position pos) {
        switch (pos) {
            case LEFT:
                return leftTower;

            case MIDDLE:
                return middleTower;

            case RIGHT:
                return rightTower;

            default:
                return leftTower;
        }
    }


    /**
     * returns a string representing the HanoiSolver
     * 
     * @return the string representation
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(leftTower.toString());
        stringBuilder.append(middleTower.toString());
        stringBuilder.append(rightTower.toString());

        return stringBuilder.toString();
    }


    /**
     * moves a disc from the one tower to another
     * 
     * @param source
     *            initial tower the disc is on
     * @param destination
     *            final tower the disc will be on
     */
    private void move(Tower source, Tower destination) {
        destination.push(source.pop());
        setChanged();
        notifyObservers(destination.position());
    }


    /**
     * This method solves the puzzle recursively
     * 
     * @param currentDiscs
     *            the number of discs in play
     * @param startPole
     *            starting pole
     * @param tempPole
     *            temporary pole to store discs short term
     * @param endPole
     *            the pole all the discs will end on
     */
    private void solveTowers(
        int currentDiscs,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        if (currentDiscs == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDiscs - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDiscs - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * Calls the previous method using the specific parameters
     */
    public void solve() {
        solveTowers(numDiscs, leftTower, middleTower, rightTower);
    }
}
