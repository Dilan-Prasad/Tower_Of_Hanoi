package towerofhanoi;

import java.awt.Color;
import java.io.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import CS2114.*;

/**
 * @author Dilan Prasad
 * @version 10/22/2018
 */
public class GameWindow implements Observer {

    private HanoiSolver game;
    private Shape leftTower;
    private Shape middleTower;
    private Shape rightTower;
    public static final int DISC_HEIGHT = 10;
    public final int DISC_GAP = 5;
    private Window window;

    private int leftPosition;
    private int middlePosition;
    private int rightPosition;
    private int yPos;
    private int yHeight;


    public GameWindow(HanoiSolver solver) {
        this.game = solver;
        this.game.addObserver(this);
        window = new Window();
        window.setTitle("Tower of Hanoi");

        int windowHeight = window.getGraphPanelHeight();
        int windowWidth = window.getGraphPanelWidth();
        yPos = windowHeight - 300;
        yHeight = windowHeight / 2;

        leftPosition = (windowWidth / 4) - 5;
        middlePosition = (windowWidth * 2 / 4) - 5;
        rightPosition = (windowWidth * 3 / 4) - 5;

        leftTower = new Shape(leftPosition, yPos, 10, yHeight);
        middleTower = new Shape(middlePosition, yPos, 10, yHeight);
        rightTower = new Shape(rightPosition, yPos, 10, yHeight);

        for (int j = game.discs(); j > 0; j--) {
            Disc playableDisc = new Disc(j * 15);
            window.addShape(playableDisc);
            game.getTower(Position.LEFT).push(playableDisc);
            moveDisc(Position.LEFT);
        }

        window.addShape(leftTower);
        window.addShape(middleTower);
        window.addShape(rightTower);

        Shape bottomBar = new Shape(20, yPos + yHeight, windowWidth - 40, 20);
        bottomBar.setBackgroundColor(Color.BLACK);
        window.addShape(bottomBar);

        Button solveButton = new Button("Solve");
        solveButton.onClick(this, "clickedSolve");
        window.addButton(solveButton, WindowSide.SOUTH);

        Button otherButton = new Button("Quit");
        otherButton.onClick(this, "clickedQuit");
        window.addButton(otherButton, WindowSide.SOUTH);
    }


    private void moveDisc(Position position) {
        Disc currentDisc = game.getTower(position).peek();
        Shape currentPole;

        switch (position) {
            case LEFT:
                currentPole = leftTower;
                break;

            case MIDDLE:
                currentPole = middleTower;
                break;

            case RIGHT:
                currentPole = rightTower;
                break;

            default:
                currentPole = middleTower;
                break;

        }

        int discX = currentPole.getX() - (currentDisc.getWidth() / 2)
            + (currentPole.getWidth() / 2);
        int discY = yPos - game.getTower(position).size() * DISC_HEIGHT
            + yHeight;

        currentDisc.moveTo(discX, discY);
    }


    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    public void clickedQuit(Button quitButton) {
        quitButton.disable();
        System.exit(0);
    }


    @Override
    public void update(Observable o, Object arg) {
        Position position = null;
        if (arg.getClass() == Position.class) {
            position = (Position)arg;
        }
        moveDisc(position);
        sleep();
    }


    public static int getDiscHeight() {
        return DISC_HEIGHT;

    }

}
