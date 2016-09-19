/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * the grid of the Minesweeper game
 * @author Thomas Fossati / Guillame Catto
 */
public class Grid extends Model {

    private ArrayList<ArrayList<Square>> grid;
    private GameLevel level;
    private boolean isDebug = false;
    private boolean isFinished = false;
    private boolean isWinner = false;
    private boolean isFirstMove = true;
    private int squaresLeft = 0;
    private int turn = 0;
    private int minesNumber = 0;
    private int sizeX = 0;
    private int sizeY = 0;
    private int minesTagged = 0;

    /**
     * will create a game grid with a grid given
     * @param grid the grid object of the Minesweeper game
     */
    public Grid(ArrayList<ArrayList<Square>> grid) {
        this.grid = grid;
        this.setChanged();
        this.notifyObservers(this);
    }

    /**
     * will initialize a grid with the parameters given
     * @param sizeY the Y size to create the grid
     * @param sizeX the X size to create the grid
     * @param minePercentage must be given in order to know how many mines you want
     * @param isDebug if you want to cheat or test the game :3
     * @param level needed in order to specify the level of difficulty for the game
     */
    public Grid(int sizeY, int sizeX, double minePercentage, boolean isDebug, GameLevel level) throws BadMinePercentageException {
            this(sizeY, sizeX, minePercentage, isDebug, true, level);
    }

    /**
     * will initialize a grid with the parameters given
     * @param sizeY the Y size to create the grid
     * @param sizeX the X size to create the grid
     * @param minePercentage must be given in order to know how many mines you want
     * @param isDebug if you want to cheat or test the game :3
     * @param isPercentage in order to know if you want to give a percentage or a number of mines
     * @param level needed in order to specify the level of difficulty for the game
     */
    public Grid(int sizeY, int sizeX, double minePercentage, boolean isDebug, boolean isPercentage, GameLevel level) throws BadMinePercentageException {
        this.isDebug = isDebug;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.level = level;
        
        if (minePercentage > BadMinePercentageException.MAX_PERCENTAGE && isPercentage) {
            throw new BadMinePercentageException(minePercentage);
        }
        
        if (isPercentage) {
            this.minesNumber = (int) (sizeX * sizeY * minePercentage) / 100;
        } else {
            this.minesNumber = (int) minePercentage;
        }

        ArrayList<ArrayList<Square>> newGrid = new ArrayList<>(sizeY);

        for (int y = 0; y < sizeY; y++) {
            ArrayList<Square> line = new ArrayList<>(sizeX);

            for (int x = 0; x < sizeX; x++) {
                line.add(new Square(x, y, this));
            }

            newGrid.add(line);
        }

        this.setNeighbors(newGrid);
        this.grid = newGrid;
        this.setChanged();
        this.notifyObservers(this);
    }

    private void setAdjacentMines() {
        for (ArrayList<Square> line : this.grid) {
            for (Square square : line) {
                int adjacentMines = 0;

                for (Square neighbor : square.getNeighborhood()) {
                    if (neighbor.getIsMine()) {
                        adjacentMines++;
                    }
                }

                square.setAdjacentMines(adjacentMines);
            }
        }
    }

    /**
     * grid getter
     * @return will return the grid of the game.
     */
    public ArrayList<ArrayList<Square>> getGrid() {
        return this.grid;
    }

    /**
     * grid setter
     * @param grid if you want to change the grid of the game
     */
    public void setGrid(ArrayList<ArrayList<Square>> grid) {
        this.grid = grid;
    }

    /**
     * isDebug getter
     * @return will return the boolean specifying if the game is in debug mode or not.
     */
    public boolean getIsDebug() {
        return this.isDebug;
    }

    /**
     * isDebug setter
     * @param isDebug in order to specify if the debug mode is activated or not
     */
    public void setIsDebug(boolean isDebug) {
        this.isDebug = isDebug;
    }

    /**
     * isFinished getter
     * @return will return the boolean specifying if the game is finished or not.
     */
    public boolean getIsFinished() {
        return this.isFinished;
    }

    /**
     * isFinished setter
     * @param isFinished in order to specify if the game is finished or not
     */
    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
        this.revealGrid();
    }

    /**
     * isWinner getter
     * @return will return the boolean specifying if the player has won or not
     */
    public boolean getIsWinner() {
        return this.isWinner;
    }

    /**
     * turn getter
     * @return will return the current turn of the game
     */
    public int getTurn() {
        return this.turn;
    }

    /**
     * minesNumber - minesTagged getter
     * @return will return the number of mines left, from the player's point of view
     */
    public int getMinesLeft() {
        return this.minesNumber - this.minesTagged;
    }
    
    /**
     * minesNumber getter
     * @return will return the total number of mines in the game
     */
    public int getMinesNumber() {
        return this.minesNumber;
    }

    /**
     * sizeX getter
     * @return will return the X size of the grid
     */
    public int getSizeX() {
        return this.sizeX;
    }

    /**
     * sizeY getter
     * @return will return the Y size of the grid
     */
    public int getSizeY() {
        return this.sizeY;
    }

    /**
     * minesTagged getter
     * @return will return the number of mines tagged on the grid
     */
    public int getMinesTagged() {
        return this.minesTagged;
    }

    /**
     * level getter
     * @return will return the current level of difficulty selected in the game
     */
    public GameLevel getLevel() {
        return level;
    }

    /**
     * isFirstMove getter
     * @return will return a boolean specifying if it is the first move or not
     */
    public boolean getIsFirstMove() {
        return this.isFirstMove;
    }

    /**
     * isFirstMove setter
     * @param firstMove in order to specify if it is the first move or not
     */
    public void setIsFirstMove(boolean firstMove) {
        this.isFirstMove = firstMove;
    }

    /**
     * will fill the grid with mines according to the mines number/percentage, avoiding creating a mine where the player just made a move
     * @param i the x value of the player move. Needed to avoid setting a mine where the player just made a move!
     * @param j the y value of the player move. Needed to avoid setting a mine where the player just made a move!
     */
    public void firstMove(int i, int j) {
        this.grid = this.setMines(this.grid, i, j);
        this.setAdjacentMines();
        this.revealSquare(i, j);
    }

    private void revealSquareRec(int i, int j, boolean firstCall) {
        Square currentSquare = grid.get(j).get(i);
        Status s = currentSquare.getStatus();

        if (s == Status.MINE_TAG) {
            this.minesTagged--;
        }

        if (currentSquare.getIsMine() && firstCall) {
            this.setChanged();
            this.isFinished = true;
            this.squaresLeft--;
            currentSquare.setStatus(Status.MINE);
        } else if (s == Status.HIDDEN || s == Status.MINE_TAG
                || s == Status.UNKNOWN_TAG) {
            currentSquare.setStatus(Status.NUMBER);

            if (currentSquare.getAdjacentMines() == 0) {
                for (Square neighbor : currentSquare.getNeighborhood()) {
                    revealSquareRec(neighbor.getX(), neighbor.getY(), false);
                }
            }

            this.squaresLeft--;
        }

        if (this.squaresLeft <= 0) {
            this.isWinner = true;
            this.setIsFinished(true);
        }
    }

    /**
     * will reveal a square
     * @param i the x value where the player wants to reveal a square
     * @param j the y value where the player wants to reveal a square
     */
    public void revealSquare(int i, int j) {
        if (this.grid.get(j).get(i).getIsMine()) {
            this.setIsFinished(true);
        }

        if (this.isFirstMove) {
            this.isFirstMove = false;
            this.firstMove(i, j);
        } else {
            this.revealSquareRec(i, j, true);
            this.turn++;
            if (!this.getIsFinished()) {
                this.setChanged();
                this.notifyObservers(this);
            }
        }
    }

    /**
     * will tag a square
     * @param i the x value where the player wants to tag a square
     * @param j the y value where the player wants to tag a square
     * @param status the status the player wants the square to be tagged
     */
    public void tagSquare(int i, int j, Status status) {
        Square currentSquare = grid.get(j).get(i);
        Status currentStatus = currentSquare.getStatus();

        if (currentStatus != status && currentStatus == Status.MINE_TAG) {
            this.minesTagged--;
            this.setChanged();
        }
        if (currentStatus != Status.MINE && currentStatus != Status.NUMBER) {
            if (status == Status.MINE_TAG) {
                this.minesTagged++;
                this.setChanged();
            }
            
            currentSquare.setStatus(status);
            this.setChanged();
        }

        this.notifyObservers(this);
    }

    /**
     * will delete a tag on a square
     * @param i the x value where the player wants to delete tag
     * @param j the y value where the player wants to delete tag
     */
    public void deleteTag(int i, int j) {
        Square currentSquare = grid.get(j).get(i);
        Status currentStatus = currentSquare.getStatus();

        if (currentStatus == Status.MINE_TAG) {
            this.minesTagged--;
            this.setChanged();
        }

        if (currentStatus != Status.MINE && currentStatus != Status.NUMBER) {
            currentSquare.setStatus(Status.HIDDEN);
            this.setChanged();
        }

        this.notifyObservers(this);
    }

    private void revealGrid() {
        for (int y = 0; y < this.sizeY; y++) {
            for (int x = 0; x < this.sizeX; x++) {
                Square square = this.getGrid().get(y).get(x);
                if (square.getIsMine()) {
                    square.setStatus(Status.MINE);
                } else {
                    square.setStatus(Status.NUMBER);
                }
            }
        }

        this.setChanged();
        this.notifyObservers(this);
    }

    /**
     * will set the mines on the grid, avoiding setting the mines of the (xToAvoid, yToAvoid) position
     * @param newGrid the new grid which has been created to set the game
     * @param xToAvoid the x value needed to avoid setting a mine just where the player first moved
     * @param yToAvoid the y value needed to avoid setting a mine just where the player first moved
     * @return will return the new grid set with mines
     */
    public ArrayList<ArrayList<Square>> setMines(
            ArrayList<ArrayList<Square>> newGrid, int xToAvoid, int yToAvoid) {

        this.squaresLeft = (this.sizeX * this.sizeY) - this.minesNumber;

        int minesNb = this.minesNumber;

        Random r = new Random();

        while (minesNb > 0) {

            int i = r.nextInt(this.sizeX);
            int j = r.nextInt(this.sizeY);

            Square square = newGrid.get(j).get(i);

            if (!square.getIsMine() && (i != xToAvoid || j != yToAvoid)) {
                square.setIsMine(true);
                minesNb--;
            }
        }

        return newGrid;
    }

    /**
     * will get the neighbors of each square in the grid given
     * @param grid the grid needed to set the neighbors of each square
     */
    public void setNeighbors(ArrayList<ArrayList<Square>> grid) {
        int sizeY = grid.size();

        for (int i = 0; i < sizeY; i++) {
            int sizeX = grid.get(i).size();

            for (int j = 0; j < sizeX; j++) {
                Square neighbor = grid.get(i).get(j);

                if (i > 0) {
                    neighbor.setNeighbors(grid.get(i - 1).get(j));

                    if (j > 0) {
                        neighbor.setNeighbors(grid.get(i - 1).get(j - 1));
                    }

                    if (j < sizeX - 1) {
                        neighbor.setNeighbors(grid.get(i - 1).get(j + 1));
                    }
                }

                if (i < sizeY - 1) {
                    neighbor.setNeighbors(grid.get(i + 1).get(j));

                    if (j > 0) {
                        neighbor.setNeighbors(grid.get(i + 1).get(j - 1));
                    }

                    if (j < sizeX - 1) {
                        neighbor.setNeighbors(grid.get(i + 1).get(j + 1));
                    }
                }

                if (j > 0) {
                    neighbor.setNeighbors(grid.get(i).get(j - 1));
                }

                if (j < sizeX - 1) {
                    neighbor.setNeighbors(grid.get(i).get(j + 1));
                }
            }
        }
    }
}
