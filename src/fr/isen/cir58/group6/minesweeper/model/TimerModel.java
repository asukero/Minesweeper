/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.model;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

/**
 * Timer for the game, is stopped when instantiate and starts when the firstmove
 * is done
 * Uses Swing Timer class
 * @author Thomas Fossati / Guillame Catto
 */
public class TimerModel extends Observable {

    private long time;
    private Timer timer;

    public TimerModel() {

        this.time = 0;
        this.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                time++;
                setChanged();
                notifyObservers();
            }
        });

        this.timer.start();
    }

    public void startTimer() {

        if (!this.timer.isRunning()) {
            this.timer.start();
        }

    }

    public void stopTimer() {

        if (this.timer.isRunning()) {
            this.timer.stop();
        }

    }

    public void resetTimer() {
        this.stopTimer();
        this.time = 0;
    }

    public String getTimerValue() {

        return convertTime(this.time);

    }

    public long getTime() {
        return time;
    }

    public static String convertTime(Long time) {
        return String.format("%dmin%ds", TimeUnit.SECONDS.toMinutes(time), time - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(time)));
    }

}
