/*
 * ISEN 2014~2015
 */

package fr.isen.cir58.group6.minesweeper.model;

import java.util.Observable;

/**
 * Parent class Model
 * @author Thomas Fossati / Guillame Catto
 */
public class Model extends Observable{
    private boolean isExist;

    void setIsExist(boolean isExist) {
	this.isExist = isExist;
	setChanged();
	notifyObservers();
    } 

    boolean getIsExist() {
	return isExist;
    }  
}