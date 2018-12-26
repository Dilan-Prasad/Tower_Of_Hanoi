package towerofhanoi;

/**
 * @author Dilan Prasad
 * @version 10/22/2018
 */
public class ProjectRunner {

    public static void main(String[] args) {

        int discs =  7;

        if (args.length == 1) {
            discs = Integer.parseInt(args[0]);
        }

        new GameWindow(new HanoiSolver(discs));

    }
}
