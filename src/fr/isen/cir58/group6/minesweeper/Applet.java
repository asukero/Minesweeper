/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper;

import javax.swing.JApplet;
import javax.swing.JLabel;

/**
 * Applet class for the minesweeper Applet.html file is located in
 * Minesweeper/Applet.html same location as scores.ser or scoresXML.xml
 *
 * @author Thomas Fossati / Guillaume Catto
 */
public class Applet extends JApplet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    @Override
    public void init() {

    }

    /**
     * Add a Jlabel in the applet and runs the mainController in graphic mode
     * but the program is displayed outside the Applet and you have to disable
     * the method initScoresFrame() from mainController, the Applet can't read
     * an file;
     * the method setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
     * from NewGameFrame and MainFrame, an exception is thrown when
     * EXIT_ON_CLOSE is an argument
     */
    @Override
    public void start() {

        this.add(new JLabel("The minesweeper applet is not working"));
        MainController m = new MainController(true, false);

    }

}
