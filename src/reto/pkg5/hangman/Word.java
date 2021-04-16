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

    /**
     * Crea un arreglo de "X" con la cantidad de la palabra 
     *  que se eligio random. 
     * @return arreglo con la cantidad de "X".
     */
    public char[] transformToX(){   
        int numLetterWord = this.word.length();
        char [] numX = new char [numLetterWord];
        for (int i = 0; i < numX.length; i++) {
            numX[i]= 'X';
        }
        return numX;
    }

    /**
     * Compara la letra que se ha ingresado con la palabra que se eligio random,
     *  sustituye la "X" en la posicion de una letra acertada.
     * @param xWord arreglo de las "X".
     * @param letter letra ingresada.
     * @return regresa el arreglo xWord modificado.
     */
    public char[] compareLetter(char[] xWord, char letter){
        boolean correctLetter = false;
        for(int i = 0; i<this.word.length(); i++){
            if (this.word.charAt(i) == letter){
                xWord[i] = letter;
                correctLetter = true;
            }
        }
        if (correctLetter == false){
            
            System.out.println("¡Esa letra no está!\n");
        }
        return xWord;
    }

    /**
     * revisa que haya alguna "X" en la palabra para poder acabar el juego.
     * @param word contiene las "X" y las demás letras ya acertadas.
     * @return Regresa true si ya no hay "X", si lo hay regresa false.
     */ 
    public boolean checkWinCondition(char[] word){
        for (int i= 0; i <= word.length-1; i++){
            if (word[i] == 'X'){
                return false;
            }
        }
        System.out.println("\n¡Ganaste!");
        return true;
    }
    
    @Override
    public String toString() {
        return "palabra: " + this.word + ", el nivel: " + this.myLevel ;
    }
     
    
}
