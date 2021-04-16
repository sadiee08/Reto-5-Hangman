/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto.pkg5.hangman;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author abbys
 */
public class Reto5Hangman {
    public static Player myPlayer;

    /**
     * Declaracion de niveles tipo Level.
     */
    public static Level[] myLevels = {
        new Level ("Facil", 4),
        new Level ("Normal", 8),
        new Level ("Dificil", 12)
    };

    /**
     * Se encarga de seleccionar una palabra Random dependiendo del nivel elegido.
     * @param numLevel Número del nivel.
     * @return Palabra random del nivel que se especificó.
     */
    public static Word getRandom(int numLevel){
        Random ran = new Random();
        Word[][] myWords ={
            {
                new Word ("gato", myLevels[0]),
                new Word ("casa", myLevels[0])
            },
            {
                new Word ("caballos", myLevels[1]),
                new Word ("nacional", myLevels[1])
            },
            {
                new Word ("nacionalidad", myLevels[2]),
                new Word ("ulrasonidos", myLevels[2])
            }
        };
        return myWords[numLevel-1][ran.nextInt(myWords[numLevel-1].length)];
    }

    /**
     * Transforma la pablabra de getRandom en "X"
     * @param numLevel nivel del juego elegido.
     * @return regresa un char[] de "X".
     */
    public static char[] levelWord(int numLevel){
        Word hiddenWord = getRandom(numLevel);
        return hiddenWord.transformToX();
    }
    
    public static char approveLetter(char checkLetter){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una letra: ");
            checkLetter = sc.next().charAt(0);
            if (checkLetter == '0') {
                System.out.println("~~~Cerraste el juego~~~");
            }
        return checkLetter;
    }

    /**
     * Método que junta todas los demás métodos para poder jugar.
     * @param numLevel número del nivel.
     */
    public static void play(int numLevel){
        char[] xWord = levelWord(numLevel);
        Word word= getRandom(numLevel);  
        char letter = 0;
        char[] successfulWord = null;
        boolean winCondition = false;
        System.out.println(xWord);     
        do{
            letter= Letter.approveLetter(letter);
            if (letter == '0'){
                break;
            }
            try {
                if (!Character.isLetter(letter)) {
                    throw new Exception();
                }
                successfulWord = word.compareLetter(xWord, letter);          
                System.out.println(successfulWord);
                winCondition = word.checkWinCondition(successfulWord);
            } catch(Exception e) {
                System.out.println("\n¡No es una letra, intentalo de nuevo!");
            }   
        } while (!winCondition); 
    }

    /**
     * Muestra los niveles del myLevels.
     */
    public static void showLevels(){
        System.out.println("Selecciona un nivel: ");
        for (int i = 0; i < myLevels.length; i++) {
            System.out.println(myLevels[i]);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        showLevels();
        int numLevel= sc.nextInt();
        if (numLevel!=0 && numLevel<=3){
           play(numLevel);     
        }
    }
}
