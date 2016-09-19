/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.model;

/**
 * Model to implement the MVC conception for the sliders/textfield
 * @author Thomas Fossati / Guillame Catto
 */
public class Slider extends Model{
    public static final int rowsDefVal = 9;
    public static final int colsDefVal = 19;
    public static final int minesDefVal = 76;
    private int currentRowsVal = rowsDefVal;
    private int currentColsVal = colsDefVal;
    private int currentMinesVal = minesDefVal;
    private int currentMinesLength = (int) (rowsDefVal*colsDefVal*0.85);
    
    public Slider() {
    }

    public int getCurrentRowsVal() {
        return currentRowsVal;
    }

    public void setCurrentRowsVal(int currentRowsVal) {
        this.currentRowsVal = currentRowsVal;
        this.currentMinesLength = (int) (currentRowsVal*this.currentColsVal*0.85);
        this.setChanged();
        this.notifyObservers(this);
    }

    public int getCurrentColsVal() {
        return currentColsVal;
    }

    public void setCurrentColsVal(int currentColsVal) {
        this.currentColsVal = currentColsVal;
        this.currentMinesLength = (int) (this.currentRowsVal*currentColsVal*0.85);
        this.setChanged();
        this.notifyObservers(this);
    }

    public int getCurrentMinesVal() {
        return currentMinesVal;
    }

    public void setCurrentMinesVal(int currentMinesVal) {
        this.currentMinesVal = currentMinesVal;
        this.setChanged();
        this.notifyObservers(this);
    }

    public int getCurrentMinesLength() {
        return currentMinesLength;
    }

    public void setCurrentMinesLength(int currentMinesLength) {
        this.currentMinesLength = currentMinesLength;
        this.setChanged();
        this.notifyObservers(this);
    }
    
    
    
}
