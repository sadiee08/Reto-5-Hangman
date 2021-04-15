/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto.pkg5.hangman;

/**
 *
 * @author abbys
 */
class Level {
    private int id;
    private String nameLevel;
    private int numLetter;
    public static int numLevel =0;

    
    public Level() {
        numLevel++;
        id=numLevel;
    }

    public Level(String nameLevel, int numLetter) {
        this();
        this.nameLevel = nameLevel;
        this.numLetter = numLetter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameLevel() {
        return nameLevel;
    }

    public void setNameLevel(String nameLevel) {
        this.nameLevel = nameLevel;
    }

    public int getNumLetter() {
        return numLetter;
    }

    public void setNumLetter(int numLetter) {
        this.numLetter = numLetter;
    }
    
    @Override
    public String toString() {
        return id+ ") " + nameLevel + " (" + numLetter + " letras)";
    }   
}