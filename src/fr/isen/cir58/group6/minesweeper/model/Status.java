/*
 * ISEN 2014~2015
 */

package fr.isen.cir58.group6.minesweeper.model;

/**
 *
 * @author Thomas Fossati / Guillame Catto
 */
public enum Status {

    /**
     * when the player didn't reveal of tag the Square object
     */
    HIDDEN,

    /**
     *  when the player tagged the Square object as a mine
     */
    MINE_TAG,

    /**
     * when the player tagged the Square object as unknown
     */
    UNKNOWN_TAG,

    /**
     * when the player revealed the Square object being not a mine
     */
    NUMBER,

    /**
     * when the player revealed the Square object being a mine
     */
    MINE;
}