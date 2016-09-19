/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Serializable class which is stored in a ".ser" or a ".xml" contains
 * ArrayList of long which contains time vales in seconds
 *
 * @author Thomas Fossati / Guillame Catto
 */
public class Scores implements Serializable {

    private ArrayList<Long> beginnerScores;
    private ArrayList<Long> intermediateScores;
    private ArrayList<Long> expertScores;
    public static Long DEFAULTSCORE = (long) 59999; // = 999min59s
    public static int DEFAULTSIZE = 5;

    public Scores() {
        this.beginnerScores = new ArrayList<>(DEFAULTSIZE);
        this.intermediateScores = new ArrayList<>(DEFAULTSIZE);
        this.expertScores = new ArrayList<>(DEFAULTSIZE);

        for (int i = 0; i < DEFAULTSIZE; i++) {
            this.beginnerScores.add(i, DEFAULTSCORE);
            this.intermediateScores.add(i, DEFAULTSCORE);
            this.expertScores.add(i, DEFAULTSCORE);

        }

    }

    public ArrayList<Long> getBeginnerScores() {
        return beginnerScores;
    }

    public void setBeginnerScores(ArrayList<Long> beginnerScores) {
        this.beginnerScores = beginnerScores;
    }

    public ArrayList<Long> getIntermediateScores() {
        return intermediateScores;
    }

    public void setIntermediateScores(ArrayList<Long> intermediateScores) {
        this.intermediateScores = intermediateScores;
    }

    public ArrayList<Long> getExpertScores() {
        return expertScores;
    }

    public void setExpertScores(ArrayList<Long> expertScores) {
        this.expertScores = expertScores;
    }

    public static Long getDEFAULTSCORE() {
        return DEFAULTSCORE;
    }

    public static void setDEFAULTSCORE(Long DEFAULTSCORE) {
        Scores.DEFAULTSCORE = DEFAULTSCORE;
    }

    public static int getDEFAULTSIZE() {
        return DEFAULTSIZE;
    }

    public static void setDEFAULTSIZE(int DEFAULTSIZE) {
        Scores.DEFAULTSIZE = DEFAULTSIZE;
    }

}
