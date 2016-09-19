/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.view.console;

import fr.isen.cir58.group6.minesweeper.model.TimerModel;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Thomas Fossati / Guillame Catto
 */
public class ConsoleTimerView implements Observer{

    public ConsoleTimerView(TimerModel timer) {
        timer.addObserver(this);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof TimerModel) {
            TimerModel timer = (TimerModel) o;
            System.out.println("Time : " + timer.getTimerValue());

        }
}
    
}
