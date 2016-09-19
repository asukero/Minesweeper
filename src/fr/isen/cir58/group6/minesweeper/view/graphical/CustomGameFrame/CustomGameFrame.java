/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.CustomGameFrame;

import fr.isen.cir58.group6.minesweeper.model.GameModel;
import fr.isen.cir58.group6.minesweeper.model.Slider;
import fr.isen.cir58.group6.minesweeper.view.graphical.common.GameFrame;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

/**
 * display the custom game where you can launch a new game with specific values
 * inherits GameFrame to add the settingsPanel
 * @author Thomas Fossati / Guillaume Catto
 */
public class CustomGameFrame extends GameFrame implements Observer {

    public static final String TITLE = "Custom game";

    public CustomGameFrame(Slider slider,GameModel gameModel){
        super(CustomGameFrame.TITLE);

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(500, 300);
        this.setLayout(new GridLayout(4, 1, 0, 0));
        this.addSettingsPanel(true,slider, gameModel);
        this.setVisible(false);
        

    }
    /**
     * observes the GameModel too see if it has to be visible or not
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof GameModel) {
            GameModel gameModel = (GameModel) arg;
            if (gameModel.isCustomGameFrameVisible()) {
                this.setVisible(true);
            } else {
                this.setVisible(false);
            }

        }
    }

}
