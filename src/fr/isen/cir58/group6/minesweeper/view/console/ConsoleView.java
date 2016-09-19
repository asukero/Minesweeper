/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.view.console;

import fr.isen.cir58.group6.minesweeper.model.Grid;
import fr.isen.cir58.group6.minesweeper.model.Square;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Arrays;

/**
 * object that will display the Minesweeper on a terminal
 * @author Thomas Fossati / Guillame Catto
 */
public class ConsoleView implements Observer {

    /**
     * the welcome message given when starting the game
     */
    public static final String WELCOME_MESSAGE = ".x?!MINESWEEPER!?x.";

    /**
     * the message displayed when the player wins
     */
    public static final String WINNER_MESSAGE
            = "Well played. 3: I'm not happy though. 3:";

    /**
     * the message displayed when the player looses
     */
    public static final String LOOSER_MESSAGE
            = "Oh no! Gotta play better next time. >:3";

    /**
     * the hidden square visual
     */
    public static final String HIDDEN = "#";

    /**
     * the mine tag visual
     */
    public static final String MINE_TAG = "!";

    /**
     * the unknown tag visual
     */
    public static final String UNKNOWN_TAG = "?";

    /**
     * the empty tag visual
     */
    public static final String EMPTY = ".";

    /**
     * the mine visual
     */
    public static final String MINE = "x";
    
    
    /**
     * the grid's top border
     */
    private String longSeparator = "~~~";
    
    
    /**
     * the grid's bottom border (shorter, in order to display the number of turns)
     */
    private String shortSeparator = "~";

    /**
     * this constructor will not display the grid after initialization
     * @param grid
     */
    public ConsoleView(Grid grid) {
        this(grid, false);
    }

    /**
     * this constructor will let the user chooses if he wants the grid displayed or not after initialization
     * @param grid the grid to be viewed
     * @param isDisplay if it is displayed or not after initialization
     */
    public ConsoleView(Grid grid, boolean isDisplay) {
        
        grid.addObserver(this);

        ArrayList<ArrayList<Square>> tmpGrid = grid.getGrid();

        if (tmpGrid.size() > 0) {
            /* in order to give "borders" to the grid */
            this.getSeparators(tmpGrid.get(0).size());
        }

        System.out.println(ConsoleView.WELCOME_MESSAGE);

        if (isDisplay) {
            this.displayGrid(grid);
        }
    }

    private void getSeparators(int size) {
        if (size > 0) {
            char[] tmpArray = new char[size * 2 - 1];
            Arrays.fill(tmpArray, '~');
            this.longSeparator = new String(tmpArray);
            tmpArray = new char[size - 1];
            Arrays.fill(tmpArray, '~');
            this.shortSeparator = new String(tmpArray);
        }
    }

    /**
     * in order to get a visual of a given square
     * @param square the square needed to return a visual
     * @return will return a String-type visual
     */
    public String getVisual(Square square) {
        /* displays a MINE visual if the debug mode is triggered or if the gane
         if finished (in order to give the positions of the mines) */
        if (square.getIsMine() && (square.getGrid().getIsDebug())) {
            return ConsoleView.MINE;
        }

        switch (square.getStatus()) {
            case HIDDEN:
                return ConsoleView.HIDDEN;
            case MINE_TAG:
                return ConsoleView.MINE_TAG;
            case UNKNOWN_TAG:
                return ConsoleView.UNKNOWN_TAG;
            case NUMBER:
                if (square.getAdjacentMines() == 0 || square.getGrid().getIsFinished()) {
                    return ConsoleView.EMPTY;
                } else { // will give the adjacent mines if not EMPTY
                    return Integer.toString(square.getAdjacentMines());
                }
            case MINE:
                return ConsoleView.MINE;
            default:
                return "";
        }
    }

    /**
     * displays the grid
     * @param grid the grid to be displayed
     */
    public void displayGrid(Grid grid) {
        ArrayList<ArrayList<Square>> gridView = grid.getGrid();

        if (grid.getIsFinished()) {
            this.displayEnd(grid);
        }

        System.out.println(this.longSeparator);

        for (ArrayList<Square> line : gridView) {
            for (Square square : line) {
                System.out.print(getVisual(square) + " ");
            }

            System.out.println("");
        }

        System.out.println(this.shortSeparator + grid.getTurn() + this.shortSeparator);
    }

    /**
     * will display the end of the game
     * @param grid
     */
    public void displayEnd(Grid grid) {
        if (grid.getIsWinner()) {
            System.out.println(ConsoleView.WINNER_MESSAGE);
        } else {
            System.out.println(ConsoleView.LOOSER_MESSAGE);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Grid) {
            Grid grid = (Grid)arg;
            displayGrid(grid);
        }
        
    }
}
