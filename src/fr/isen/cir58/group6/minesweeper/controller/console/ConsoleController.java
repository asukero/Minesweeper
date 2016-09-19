/*
 * ISEN 2014~2015
 */

package fr.isen.cir58.group6.minesweeper.controller.console;

import fr.isen.cir58.group6.minesweeper.view.console.ConsoleView;
import fr.isen.cir58.group6.minesweeper.model.Grid;
import fr.isen.cir58.group6.minesweeper.model.Status;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * the console controller object
 * @author Thomas Fossati / Guillame Catto
 */
public class ConsoleController {
    private Grid grid;
    private ConsoleView consoleView;

    /**
     * the console controller constructor
     * @param grid the grid needed to initialize the controller
     * @param consoleView the view needed to initialize the controller
     */
    public ConsoleController(Grid grid, ConsoleView consoleView) {
        this.grid = grid;
        this.consoleView = consoleView;
    }

    /**
     * the grid getter
     * @return will return the controller's grid
     */
    public Grid getGrid() {
        return this.grid;
    }

    /**
     * the grid setter
     * @param grid the controller's grid to set
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    /**
     * the consoleView getter
     * @return will return the controller's view
     */
    public ConsoleView getConsoleView() {
        return this.consoleView;
    }

    /**
     * the consoleView setter
     * @param consoleView the controller's view to set
     */
    public void setConsoleView(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }
    
    /**
     * will get a move from the player's input
     * @param str the String which will be considered as a move
     * @return will return a ConsoleMove object
     */
    public ConsoleMove getConsoleMove(String str) {
        ConsoleMove move = new ConsoleMove();
        
        String[] tmpStr = str.split(" "); // gives an array of strings
        int sizeTmpStr = tmpStr.length;
        
        if (sizeTmpStr <= 0) { // will return a BLANK move
            return move;
        }
        
        if (tmpStr[0].equals("q") && sizeTmpStr == 1) { // to stop the game
            move.setInput(ConsoleInput.QUIT);
        }
        
        if (tmpStr[0].equals("d") && sizeTmpStr == 3) { // to reveal the game
           move.setInput(ConsoleInput.REVEAL);
           move.setX(Integer.parseInt(tmpStr[1]));
           move.setY(Integer.parseInt(tmpStr[2]));
        }
        
        if (tmpStr[0].equals("m") && sizeTmpStr == 4) { // to tag or delete tag
            switch (tmpStr[3]) {
                case "x":
                    move.setInput(ConsoleInput.MINE_TAG);
                    break;
                case "?":
                    move.setInput(ConsoleInput.UNKNOWN_TAG);
                    break;
                case "#":
                    move.setInput(ConsoleInput.DELETE_TAG);
                    break;
                default:
                    return move; // invalid command, will return a BLANK move
            }
           
           move.setX(Integer.parseInt(tmpStr[1]));
           move.setY(Integer.parseInt(tmpStr[2]));
        }
        
        return move;
    }
    
    /**
     * will make a move with the ConsoleMove object given
     * @param move a ConsoleMove object needed to call the right method of the model
     */
    public void move(ConsoleMove move) {
        ConsoleInput input = move.getInput();
        
        if (input == ConsoleInput.REVEAL) {
            this.grid.revealSquare(move.getX(), move.getY());
        }
        
        if (input == ConsoleInput.MINE_TAG) {
            this.grid.tagSquare(move.getX(), move.getY(), Status.MINE_TAG);   
        }
        
        if (input == ConsoleInput.UNKNOWN_TAG) {
            this.grid.tagSquare(move.getX(), move.getY(), Status.UNKNOWN_TAG);
        }
        
        if (input == ConsoleInput.DELETE_TAG) {
            this.grid.deleteTag(move.getX(), move.getY());
        }
        
        if (input == ConsoleInput.QUIT) {
            this.grid.setIsFinished(true);
        }
    }
    
    /**
     * will get the next move of the player
     * @return will return the move done by the player
     */
    public String getNextMove() {
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            str = br.readLine();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        
        return str;
    }

    /**
     * main loop of the controller
     */
    public void loop() {
        ConsoleMove move;
        String moveStr;
        
        while (!this.grid.getIsFinished()) {
            moveStr = this.getNextMove();
            move = this.getConsoleMove(moveStr);
            
            this.move(move);
        }
    }
}