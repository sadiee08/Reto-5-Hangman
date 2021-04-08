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
class Word {
    private String word;
    private Level myLevel;

    public Word() {
    }

    public Word(String word, Level myLevel) {
        this.word = word;
        this.myLevel = myLevel;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Level getMyLevel() {
        return myLevel;
    }

    public void setMyLevel(Level myLevel) {
        this.myLevel = myLevel;
    }

    public char[] transformToX(){   
        int numLetterWord = this.word.length();
        char [] numX = new char [numLetterWord];
        for (int i = 0; i < numX.length; i++) {
            numX[i]= 'X';
        }
        return numX;
    }

    public char[] compareLetter(char[] xWord, char letter){
        boolean correctLetter = false;
        for(int i = 0; i<this.word.length(); i++){
            if (this.word.charAt(i) == letter){
                xWord[i] = letter;
                correctLetter = true;
            }
        }
        if (correctLetter == false){
            
            System.out.println("¡Intentalo de nuevo!\n");
        }
        return xWord;
    }

    @Override
    public String toString() {
        return "palabra: " + this.word + ", el nivel: " + this.myLevel ;
    }
     
    
}
