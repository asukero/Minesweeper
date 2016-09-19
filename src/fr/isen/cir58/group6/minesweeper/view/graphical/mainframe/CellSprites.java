/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.mainframe;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * an object which will load all the sprites used in the game
 * @author Thomas Fossati / Guillaume Catto
 */
public class CellSprites {
    private String directory = "elements/";
    private String mineDir = directory + "mine.png";
    private String hiddenDir = directory + "hidden.gif";
    private String mineTagDir = directory + "mineTag.png";
    private String unknownTagDir = directory + "unknownTag.png";
    
    private Image mine;
    private Image hidden;
    private Image mineTag;
    private Image unknownTag;

    /**
     * CellSprites default constructor
     */
    public CellSprites() {
        try {
            this.mine = ImageIO.read(getClass().getResource(this.mineDir));
            this.hidden = ImageIO.read(getClass().getResource(this.hiddenDir));
            this.mineTag = ImageIO.read(getClass().getResource(this.mineTagDir));
            this.unknownTag = ImageIO.read(getClass().getResource(this.unknownTagDir));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * mine sprite getter
     * @return
     */
    public Image getMine() {
        return this.mine;
    }

    /**
     * hidden sprite getter
     * @return
     */
    public Image getHidden() {
        return this.hidden;
    }

    /**
     * mine tag sprite getter
     * @return
     */
    public Image getMineTag() {
        return this.mineTag;
    }

    /**
     * unknown tag sprite getter
     * @return
     */
    public Image getUnknownTag() {
        return this.unknownTag;
    }
}