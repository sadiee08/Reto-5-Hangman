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

    public static Level[] myLevels = {
        new Level ("Facil", 4),
        new Level ("Normal", 8),
        new Level ("Dificil", 12)
    };

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

    public static char[] levelWord(int numLevel){
        Word hiddenWord = getRandom(numLevel);
        return hiddenWord.transformToX();
    }

    public static boolean gameOver(char[]word){
        for (int i= 0; i <= word.length-1; i++){
            if (word[i] == 'X'){
                return false;
            }
        }
        return true;
    }

    public static void play(int numLevel){
        Scanner sc = new Scanner(System.in);
        char[] xWord = levelWord(numLevel);
        Word word= getRandom(numLevel);  
        char letter;
        char[] successfulWord;
        System.out.println(xWord);     
        do{  
            System.out.print("Introduce una letra: ");
            letter = sc.next().charAt(0);
            if (letter == '0'){
                break;
            }
            successfulWord = word.compareLetter(xWord, letter);           
            System.out.println(successfulWord);
            
        } while(!gameOver(successfulWord)); 
        System.out.println("\n¡Ganaste!");
    }

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
