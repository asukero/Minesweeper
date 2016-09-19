/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.model;

/**
 *
 * @author Thomas Fossati / Guillame Catto
 */
public class BadMinePercentageException extends Exception {

    /**
     * the max percentage authorized before throwing an exception
     */
    public static final double MAX_PERCENTAGE = 85;

    /**
     * the message which will be printed if getMessage() is called
     */
    public static final String MESSAGE = "Please give a percentage lower than "
            + MAX_PERCENTAGE + ". Percentage given is ";
    private double percentage = 0;
    
    BadMinePercentageException(double percentage) {
        this.percentage = percentage;
    }
    
    @Override
    public String toString() {
        return BadMinePercentageException.MESSAGE + this.percentage;
    }
}