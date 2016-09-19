/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Manages the scores by reading/writing them, use serializable process to
 * read/write ".ser" file or ".xml" file
 * @author Thomas Fossati / Guillame Catto
 */
public class FileManager implements Serializable {

    private Scores scores;
    public static String DEFAULTFILEPATH = "scores.ser";
    public static String DEFAULTFILEPATHXML = "scoresXML.xml";
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private FileOutputStream fos;
    private FileInputStream fis;
    private FileOutputStream fosXML;
    private FileInputStream fisXML;
    private BufferedOutputStream bos;
    private BufferedInputStream bis;
    private XMLEncoder xmlEncoder;
    private XMLDecoder xmlDecoder;
    private String filePath;

    /**
     * the constructor reads either the xml or the ser file depends of the
     * filepath
     *
     * @param isXMLFile to determine which read/write methods we have to use for
     * the file
     * @throws IOException
     */
    public FileManager(String filePath, boolean isXMLFile) throws IOException {
        this.filePath = filePath;
        if (isXMLFile) {

            this.readXMLScores(filePath);

        } else {
            this.readScores(filePath);
        }

    }

    public Scores getScores() {
        return scores;
    }

    public void setScores(Scores scores) throws IOException {
        this.scores = scores;
        this.writeScores(this.scores);
    }

    public void writeScores(Scores scores) {
        try {
            this.fos = new FileOutputStream(this.filePath);
            this.oos = new ObjectOutputStream(fos);

            this.oos.writeObject(scores);
        } catch (IOException e) {
            System.err.print(e.toString());
        } finally {
            try {

                this.fos.close();
                this.oos.close();

            } catch (IOException e) {
                System.err.println(e.toString());
            }
        }

    }

    public void writeXMLScores(Scores scores) {

        try {
            this.fosXML = new FileOutputStream(this.filePath);
            this.bos = new BufferedOutputStream(this.fosXML);
            this.xmlEncoder = new XMLEncoder(this.bos);
            this.xmlEncoder.writeObject(scores);
        } catch (IOException e) {
            System.err.print(e.toString());
        } finally {
            try {
                this.xmlEncoder.close();
                this.fosXML.close();
                this.bos.close();

            } catch (IOException e) {
                System.err.println("onche");
                System.err.println(e.toString());
            }
        }
    }

    public void readScores(String filePath) throws IOException {
        try {
            this.fis = new FileInputStream(filePath);
            this.ois = new ObjectInputStream(this.fis);

            this.scores = (Scores) ois.readObject();
        } catch (IOException e) {
            System.err.println(e.toString());
            throw e;

        } catch (ClassNotFoundException e) {
            e.toString();
            System.err.print("error: scores not found in " + filePath + ", write default scores in file");
            writeScores(new Scores());

        } finally {

            try {
                this.fis.close();
                this.ois.close();
            } catch (NullPointerException e) {
                System.err.println(e.toString());

            }

        }
    }

    public void readXMLScores(String filePath) throws IOException {
        try {
            this.fisXML = new FileInputStream(filePath);
            this.bis = new BufferedInputStream(this.fisXML);
            this.xmlDecoder = new XMLDecoder(this.bis);
            this.scores = (Scores) this.xmlDecoder.readObject();
        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
            System.err.println("error: scores not found in " + filePath + ", write default scores in file");
            writeXMLScores(new Scores());
            readXMLScores(this.filePath);
            throw e;

        } finally {

            try {
                this.xmlDecoder.close();
                this.fisXML.close();
                this.bis.close();

            } catch (NullPointerException e) {
                System.err.println(e.toString());
            }

        }
    }

    public String getFilePath() {
        return filePath;
    }
    
}
