/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper;

/**
 *
 * @author Thomas Fossati / Guillame Catto
 */

public class Minesweeper{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean graphicMode = true;
        boolean debugMode = false;
        
        if (args.length >= 2) {
            graphicMode = Boolean.parseBoolean(args[0]);
            debugMode = Boolean.parseBoolean(args[1]);
        }
        
        MainController m = new MainController(graphicMode, debugMode);
    }

    
}
