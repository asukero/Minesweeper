/*
 * ISEN 2014~2015
 */

package fr.isen.cir58.group6.minesweeper.controller.console;

/**
 *
 * @author Thomas Fossati / Guillame Catto
 */
public class ConsoleMove {
    private ConsoleInput input = ConsoleInput.BLANK;
    private int i = -1, j = -1;
    
    /**
     * an object that is needed in order to make a move
     */
    public ConsoleMove() {
        this(ConsoleInput.BLANK);
    }

    /**
     *
     * @param input needed to create a ConsoleMove object with a different input than a BLANK one
     */
    public ConsoleMove(ConsoleInput input) {
        this.input = input;
    }
    
    /**
     *
     * @param input
     * @param i the x value of the game's grid
     * @param j the y value of the game's grid
     */
    public ConsoleMove(ConsoleInput input, int i, int j) {
        this.input = input;
        this.i = i;
        this.j = j;
    }

    /**
     *
     * @return will return the input of the move
     */
    public ConsoleInput getInput() {
        return this.input;
    }

    /**
     *
     * @param input needed to set the input of the move
     */
    public void setInput(ConsoleInput input) {
        this.input = input;
    }

    /**
     *
     * @return will return the x value of the move for the game's grid
     */
    public int getX() {
        return this.i;
    }

    /**
     *
     * @param i needed to set the x value of the move for the game's grid
     */
    public void setX(int i) {
        this.i = i;
    }

    /**
     *
     * @return will return the y value of the move for the game's grid
     */
    public int getY() {
        return this.j;
    }

    /**
     *
     * @param j needed to set the y value of the move for the game's grid
     */
    public void setY(int j) {
        this.j = j;
    } 
}