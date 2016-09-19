/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.model;

import java.util.ArrayList;

/**
 * define a square in a grid
 * @author Thomas Fossati / Guillame Catto
 */
public class Square extends Model {

    private boolean isMine = false;
    private Status status = Status.NUMBER;
    private int adjacentMines = 0;
    private ArrayList<Square> neighborhood;
    private int x = -1, y = -1; // coordinates
    private Grid grid;

    /**
     * will call the main constructor with default parameters if needed
     * @param grid needed to know whose grid the square belongs to
     */
    public Square(Grid grid) {
        this(false, Status.HIDDEN, 0, new ArrayList<Square>(), -1, -1, grid);
    }

    /**
     * will call the main constructor with default parameters if needed
     * @param x x position on the grid
     * @param y y position on the grid
     * @param grid needed to know whose grid the square belongs to
     */
    public Square(int x, int y, Grid grid) {
        this(false, Status.HIDDEN, 0, new ArrayList<Square>(), x, y, grid);
    }

    /**
     * main constructor
     * @param isMine in order to know if it is a mine or not
     * @param status what the player knows. If he didn't reveal it,  it appears hidden. Except if he tagged it
     * @param adjacentMines number of mines on the neighborhood
     * @param neighborhood an ArrayList of squares which defines the neighborhood of the square
     * @param x x position on the grid
     * @param y y position on the grid
     * @param grid needed to know whose grid the square belongs to
     */
    public Square(boolean isMine, Status status, int adjacentMines, ArrayList<Square> neighborhood, int x, int y, Grid grid) {
        this.isMine = isMine;
        this.status = status;
        this.adjacentMines = adjacentMines;
        this.neighborhood = neighborhood;
        this.x = x;
        this.y = y;
        this.grid = grid;
        this.setChanged();
        this.notifyObservers(this);
    }

    /**
     * isMine getter
     * @return will return a boolean in order to know if it is a mine or not
     */
    public boolean getIsMine() {
        return this.isMine;
    }

    /**
     * isMine setter
     * @param isMine in order to know if it is a mine or not
     */
    public void setIsMine(boolean isMine) {
        this.isMine = isMine;
        this.setChanged();
        this.notifyObservers(this);
    }

    /**
     * status getter
     * @return will return the current status of the square (what the player knows of it)
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * status setter
     * @param status the status to set to the square (what the player knows of it)
     */
    public void setStatus(Status status) {
        this.status = status;

        if (status == Status.MINE) { // to prevent errors when debugging
            this.setIsMine(true);
        }

        this.setChanged();
        this.notifyObservers(this);
    }

    /**
     * adjacentMines getter
     * @return the number of mines in the neighborhood of the square
     */
    public int getAdjacentMines() {
        return this.adjacentMines;
    }

    /**
     * adjacentMines setter
     * @param adjacentMines the number of mines in the neighborhood of the square
     */
    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    /**
     * neighbor setter
     * @param square add this square to the neighborhood of the current Square object
     */
    public void setNeighbors(Square square) {
        this.neighborhood.add(square);
    }

    /**
     * neighborhood getter
     * @return will return an ArrayList of Square objects which defines the neighborhood of the current Square object
     */
    public ArrayList<Square> getNeighborhood() {
        return this.neighborhood;
    }

    /**
     * x getter
     * @return will return the x position of the square on the game grid
     */
    public int getX() {
        return this.x;
    }

    /**
     * x setter
     * @param x the x position of the square on the game grid
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * y getter
     * @return will return the y position of the square on the game grid
     */
    public int getY() {
        return this.y;
    }

    /**
     * y setter
     * @param y the y position of the square on the game grid
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * grid getter
     * @return will return the grid where the Square object is located
     */
    public Grid getGrid() {
        return grid;
    }
    
}
