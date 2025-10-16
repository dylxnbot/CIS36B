/**
 * The purpose of this program is to assist an English-speaking user to 
 * build their vocabulary in Spanish
 * 
 * CIS 36B
 * @author Dylan Lam
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Translator {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the Spanish Vocabulary Builder!");
        Scanner input = new Scanner(System.in);
        final int SIZE = 1000;
        int numWords = 0;

        String[] arrayEnglish = new String[SIZE];
        String[] arraySpanish = new String[SIZE];

        // Assigning strings from english.txt into arrayEnglish
        Scanner englishFile = new Scanner(new File("english.txt"));
        Scanner spanishFile = new Scanner(new File("spanish.txt"));
        while (numWords < SIZE && englishFile.hasNextLine() && spanishFile.hasNextLine()) {
            arrayEnglish[numWords] = englishFile.nextLine();
            arraySpanish[numWords] = spanishFile.nextLine();
            numWords++;
        }
        englishFile.close();
        spanishFile.close();

        // Looking for valid user input
        boolean execute = true;
        int index, linearFind;
        String engWord, spanWord, outFile, userInput, wordSearch;

        while (execute) {
            // Creating GUI
            System.out.println("\nBelow are the words in English:\n");
            printArrayConsole(arrayEnglish, numWords); // Outputting english array

            System.out.println("\nPlease select a menu option below (1-4):");
            System.out.println("\n1. Add a new word");
            System.out.println("2. Remove a word");
            System.out.println("3. View a word's translation");
            System.out.println("4. Quit");

            System.out.println("\nEnter your choice: ");
            userInput = input.nextLine();

            // Insert a word
            if ("1".equals(userInput)) {
                System.out.println("\nEnter the word to add in English: ");
                engWord = input.nextLine();

                System.out.println("Enter " + engWord + "'s Spanish translation: ");
                spanWord = input.nextLine();

                System.out.println(
                        "Enter the alphabetical position in the list for" + engWord + "(0 - " + numWords + "): ");
                index = input.nextInt();
                input.nextLine();

                boolean insertEng = insert(arrayEnglish, numWords, index, engWord);
                boolean insertSpan = insert(arraySpanish, numWords, index, spanWord);

                if (insertEng && insertSpan) {
                    numWords++; // only after both succeed
                } else {
                    System.out.println("\nInvalid position! Please enter a location to insert between 0 and 20");
                }

                // Remove a word
            } else if ("2".equals(userInput)) {
                System.out.println("Enter the word to remove: ");
                wordSearch = input.nextLine();

                // Searching for the index of the word
                linearFind = linearSearch(arrayEnglish, wordSearch, numWords);

                boolean removeEng = remove(arrayEnglish, numWords, linearFind);
                boolean removeSpan = remove(arraySpanish, numWords, linearFind);

                if (removeEng && removeSpan) {
                    numWords--; // only after both succeed
                } else {
                    System.out.println("\nSorry! That word does not exist in this dictionary.");
                }

                // Search for a word
            } else if ("3".equals(userInput)) {
                System.out.println("Enter the word in English: ");
                wordSearch = input.nextLine();
                
                // Looking for the index the word is located in the english array
                linearFind = linearSearch(arrayEnglish, wordSearch, numWords);
                System.out.println(wordSearch + " = " + arraySpanish[linearFind]);

                // Output to a text file
            } else if ("4".equals(userInput)) {
                System.out.println("\nEnter the name of the output file: ");
                outFile = input.next();
                printArraysFile(arrayEnglish, arraySpanish, numWords, outFile);

                System.out.println("\nYou may now open " + outFile + " to view the translations.");

                System.out.println("\nGoodbye!");
                execute = false;

                // When user enters an invalid input
            } else {
                System.out.println("\nThat menu option is invalid. Please try again.");
            }
        }
    }

    /**
     * Inserts a String element into an array at a specified index, with the following parameters
     * 
     * @param array the list of String values
     * @param numElements the current number of elements stored
     * @param indexToInsert the location in the array to insert the new element
     * @param newValue the new String value to insert in the array
     * @returns true if the array element was successfully inserted at the location
     */
    public static boolean insert(String array[], int numElements, int indexToInsert, String newValue) {
        int i;

        if (array.length == numElements) {
            System.out.println("Array is full. No room to insert.");
            return false;
        } else if (indexToInsert < 0 || indexToInsert > numElements) {
            return false;
        } else {
            for (i = numElements; i > indexToInsert; i--) {
                array[i] = array[i - 1];
            }
            array[indexToInsert] = newValue;
            return true;
        }
    }

    /**
     * Removes a String element from an array at a specified index, with the following parameters
     * 
     * @param array the list of String values
     * @param numElements the current number of elements stored
     * @param indexToInsert the location in the array to remove the new element
     * @returns true if the array element was successfully removed at the location
     */
    public static boolean remove(String array[], int numElements, int indexToRemove) {
        int i;
        
        if (indexToRemove < 0 || indexToRemove >= numElements) {
            return false;
        } else {
            for (i = indexToRemove; i < numElements - 1; i++) {
                array[i] = array[i + 1];
            }
            return true;
        }
    }

    /**
     * Prints an array of Strings ot the console in the format #. word, returning nothing, 
     * with the following parameters
     * 
     * @param words the list of words in English
     * @param numElements the current number of elements stored
     */
    public static void printArrayConsole(String[] words, int numElements) {
        int i;

        for (i = 0; i < numElements; ++i) {
            System.out.println(i + ". " + words[i]);
        }
    }

    /**
     * Prints two arrays of Strings to a file in the format #. english word: spanish word, returning
     * nothing, with the following parameters
     * 
     * @param english the list of words in English
     * @param spanish the list of corresponding translations in Spanish
     * @param numElements the current number of elements stored
     * @param fileName the file name
     */
    public static void printArraysFile(String[] english, String[] spanish,
            int numElements, String fileName) throws IOException {
        int i;

        // Creating a file and printwriter to output the english word and its
        // translation to a file
        PrintWriter printOut = new PrintWriter(fileName);
        for (i = 0; i < numElements; i++) {
            printOut.println(i + ". " + english[i] + ": " + spanish[i]);
        }
        printOut.close();
    }

    /**
     * Searches for a specified String in a list, with parameters in the order below
     * 
     * @param array the list of String values
     * @param value the String to search for
     * @param numElements the number of elements in the list
     * @returns the index where value is located in the array
     */
    public static int linearSearch(String array[], String value, int numElements) {
        int i, index = -1;

        for (i = 0; i < numElements; i++) {
            if(array[i].equals(value)) {
                index = i;
            }
        }
        return index;
    }
}