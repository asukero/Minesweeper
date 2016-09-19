/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.isen.cir58.group6.minesweeper.model;

/**
 * Observable model, give for each frame or for the program some boolean to describe their state
 * When a frame state is changed all the observers are notified and updates themselves 
 * @author Thomas Fossati / Guillame Catto
 */
public class GameModel extends Model {

    private boolean shutDown = false;
    private boolean customGameFrameVisible = false;
    private boolean newGameFrameClosed = false;
    private boolean currentGameFrameClosed = false;
    private boolean customGameRadioButtonSelected = false;
    private boolean scoresFrameVisible = false;
    private boolean scoresFrameClosed = false;

    public GameModel() {

    }

    public boolean getShutDown() {
        return shutDown;
    }

    public void setShutDown(boolean shutDown) {
        this.shutDown = shutDown;
        this.setChanged();
        this.notifyObservers(this);
    }

    public boolean isCustomGameFrameVisible() {
        return customGameFrameVisible;
    }

    public void setCustomGameFrameVisible(boolean customGameFrameVisible) {
        this.customGameFrameVisible = customGameFrameVisible;
        this.setChanged();
        this.notifyObservers(this);
    }

    public boolean isNewGameFrameClosed() {
        return newGameFrameClosed;
    }

    public void setNewGameFrameClosed(boolean newGameFrameClosed) {
        this.newGameFrameClosed = newGameFrameClosed;
        this.setChanged();
        this.notifyObservers(this);
    }

    public boolean isCurrentGameFrameClosed() {
        return currentGameFrameClosed;
    }

    public void setCurrentGameFrameClosed(boolean currentGameFrameClosed) {
        this.currentGameFrameClosed = currentGameFrameClosed;
        this.setChanged();
        this.notifyObservers(this);
    }

    public boolean isCustomGameRadioButtonSelected() {
        return customGameRadioButtonSelected;
    }

    public void setCustomGameRadioButtonSelected(boolean customGameRadioButtonSelected) {
        this.customGameRadioButtonSelected = customGameRadioButtonSelected;
        this.setChanged();
        this.notifyObservers(this);
    }

    public boolean isScoresFrameVisible() {
        return scoresFrameVisible;
    }

    public void setScoresFrameVisible(boolean scoresFrameVisible) {
        this.scoresFrameVisible = scoresFrameVisible;
        this.setChanged();
        this.notifyObservers(this);
    }

    public boolean isScoresFrameClosed() {
        return scoresFrameClosed;
    }

    public void setScoresFrameClosed(boolean scoresFrameClosed) {
        this.scoresFrameClosed = scoresFrameClosed;
        this.setChanged();
        this.notifyObservers(this);
    }
    
    

}
