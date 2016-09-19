/*
 * ISEN 2014~2015
 */

package fr.isen.cir58.group6.minesweeper.controller.console;

/**
 *
 * @author Thomas Fossati / Guillame Catto
 */
public enum ConsoleInput {

    /**
     * an input that does nothing
     */
    BLANK,

    /**
     * input needed to reveal a square
     */
    REVEAL,

    /**
     * input needed to tag a square as a mine
     */
    MINE_TAG,

    /**
     * input needed to tag a square as unknown
     */
    UNKNOWN_TAG,

    /**
     * input needed to delete a tag on a square
     */
    DELETE_TAG,

    /**
     * input needed to quit the game
     */
    QUIT;
}