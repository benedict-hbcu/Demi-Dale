package org.example;

import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.example.Util.Result.*;


public class Main {

    private static final String randomWord = Util.getRandomWord();

    private static int numberOfGuess = 0;
    private static int totalNumberOfGuess = 6;


    public static void main(String[] args) {

        System.out.println(RED + "WELCOME" + BLUE + " TO A GAME " + CYAN + " OF WORDLE" + RESET);
        while (numberOfGuess < totalNumberOfGuess) {
            numberOfGuess++;
            Scanner scanner = new Scanner(System.in);
            System.out.println("enter any five letter word");
            String word = scanner.nextLine();
            boolean notTooLong;
            notTooLong = word.length() == 5;
            System.out.println(" Attempt " + numberOfGuess + " out of " + totalNumberOfGuess);

            while (!notTooLong) {
                System.out.println(RED + "Your guess has to be five letters" + RESET);
                System.out.println("enter any five letter word");
                word = scanner.nextLine();
                notTooLong = word.length() == 5;

            }
            if (randomWord.equalsIgnoreCase(word)) {
                System.out.println(PURPLE + "you Have guessed the word and won the game!" + RESET);
                System.exit(0);
            } else if (numberOfGuess == totalNumberOfGuess) {
                System.out.println(getWord(word));
                System.out.println("you couldn't quited figure it out " + " the word was " + CYAN + randomWord);
            } else {
                System.out.println(getWord(word));
            }


        }
    }


    public static Util.Result getResult(int i, char c) {
        if (randomWord.charAt(i) == c) {
            return Util.Result.HIT;
        } else if (randomWord.indexOf(c) != -1) {
            return Util.Result.SEMI_HIT;
        }
        return Util.Result.MISS;

    }


    public static String getWord(String word) {
        StringBuilder liveWord = new StringBuilder(5);
        for (int i = 0; i < word.length(); i++) {
            char wordCharacter = word.charAt(i);
            Util.Result result = getResult(i, wordCharacter);
            liveWord.append(Util.getFormattedLetter(wordCharacter, result));
        }
        return liveWord.append("\n").toString();
    }

    public static final String RED;

    static {
        RED = "\033[1;91m";
    }


    public static final String BLUE;

    static {
        BLUE = "\033[1;94m";
    }

    public static final String CYAN;

    static {
        CYAN = "\033[1;96m";
    }

    public static final String RESET;

    static {
        RESET = "\033[0m";
    }

    public static final String PURPLE;

    static {
        PURPLE = "\033[1;35m";
    }


}