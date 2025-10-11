/**
 * Prompts user with a GUI to either sort an array of integers or an
 * array of strings
 * 
 * CIS 36B
 * @author Dylan Lam
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Sort {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("nums.txt"));
        final int STARTING_SIZE = 10;
        int size = STARTING_SIZE;
        int topScores[] = new int[STARTING_SIZE + 1];
        for (int i = 0; i < STARTING_SIZE; i++) {
            topScores[i] = input.nextInt();
        }
        input.close();
        input = new Scanner(System.in);
        String classNames[] = { "Fidel", "Mohammed", "Yu Chen", "Zihan", "Ayanna", "Nayoung", "Shristi", "Haruto",
                "Maria", "Haley", "", "", "", "", "" };

        System.out.println("Welcome!\n");
        System.out.println("1. Print exam scores");
        System.out.println("2. Print student names");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.println("\nTop 10 Exam Scores, Unsorted:");
            printArray(topScores, size);
            bubbleSort(topScores, size);
            System.out.println("\nAfter Sorting:");
            printArray(topScores, size);
        } else if (choice == 2) {
            System.out.println("\nStudent Names, Unsorted:");
            printArray(classNames, size);
            bubbleSort(classNames, size);
            System.out.println("\nAfter Sorting:");
            printArray(classNames, size);
        } else {
            System.out.println("Invalid choice. Please re-run to try again.");
        } // end else
    }// end of main

    /**
     * Sorts an array of integers from smallest to largest
     * using the bubble sort algorithm
     * 
     * @param array the list of integer values
     * @param size  the current array size
     */
    public static void bubbleSort(int array[], int size) {
        int i, j;
        int temp = 0;

        for (i = 0; i <= size - 2; i++) {
            for (j = 0; j <= size - 2; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Sorts an array of strings from smallest to largest
     * using the bubble sort algorithm
     * 
     * @param classNames the list of integer values
     * @param size  the current array size
     */
    public static void bubbleSort(String classNames[], int size) {
        int i, j;
        String temp = "";

        for (i = 0; i <= size - 2; i++) {
            for (j = 0; j <= size - 2; j++) {
                if (classNames[j].compareTo(classNames[j + 1]) > 0) {
                    temp = classNames[j];
                    classNames[j] = classNames[j + 1];
                    classNames[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Print an array of integers to the console
     * 
     * @param array the list of integer values
     * @param size  the current array size
     */
    public static void printArray(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + array[i]);
        }
    }

    /**
     * Print an array of strings to the console
     * 
     * @param classNames the list of string values
     * @param size       the current array size
     */
    public static void printArray(String[] classNames, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + classNames[i]);
        }
    }

}
