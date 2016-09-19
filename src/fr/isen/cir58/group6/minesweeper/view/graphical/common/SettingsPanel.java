/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.common;

import fr.isen.cir58.group6.minesweeper.model.GameSettings;
import fr.isen.cir58.group6.minesweeper.model.Slider;
import java.awt.LayoutManager;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 * Panel with a JLabel, a Jslider and a JTextfield, allows the player to choose a value for the rows, colmuns or mines
 * @author Thomas Fossati / Guillaume Catto
 */
public class SettingsPanel extends JPanel implements Observer {

    private final GameSettings gameSetting;
    private SliderTextField textfield;
    private SettingsSlider settingsSlider;

    public SettingsPanel(LayoutManager layout, GameSettings gameSetting, int min, int max, int defaultVal) {
        super(layout);
        this.gameSetting = gameSetting;
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(new JLabel(this.gameSetting.toString()));
        this.settingsSlider = new SettingsSlider(min, max, defaultVal);
        this.add(this.settingsSlider);
        this.textfield = new SliderTextField(Integer.toString(defaultVal), 5, gameSetting);
        this.add(this.textfield);
        

    }

    public SliderTextField getTextfield() {
        return textfield;
    }

    public GameSettings getGameSetting() {
        return this.gameSetting;
    }
/**
 * Observes the slidermodel to update the slider or the textfield when the textfield or the slider is modified
 */
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Slider) {
            Slider slider = (Slider) arg;
            switch (this.gameSetting) {
                case Rows:
                    this.textfield.setText(Integer.toString(slider.getCurrentRowsVal()));
                    this.settingsSlider.setValue(slider.getCurrentRowsVal());
                    break;
                case Columns:
                    this.textfield.setText(Integer.toString(slider.getCurrentColsVal()));
                    this.settingsSlider.setValue(slider.getCurrentColsVal());
                    break;
                case Mines:
                    this.textfield.setText(Integer.toString(slider.getCurrentMinesVal()));
                    this.settingsSlider.setValue(slider.getCurrentMinesVal());
                    this.settingsSlider.setMaximum(slider.getCurrentMinesLength());
                    this.settingsSlider.setMajorTickSpacing(slider.getCurrentMinesLength()/6);
                    break;

            }
        }
    }

}
