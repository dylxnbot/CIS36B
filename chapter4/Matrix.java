/**
 * Reads a scalar and an NxN matrix from an input and outputs the NxN matrix 
 * which is the result of scalar multiplication
 * 
 * CIS 36B
 * @author Dylan Lam
 */

import java.util.Scanner;

public class Matrix {

    /**
     * Performs scalar multiplication on a matrix, with the following parameters
     * 
     * @param sclar the integer number by which to multiply the matrix
     * @param array the 2D array of integers representing the matrix
     * @returns a new array
     */
    public static int[][] scalarMult(int scalar, int[][] array) {
        int i, j;
        
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
                array[i][j] *= scalar;
            }
        }

        return array;
    }

    /**
     * Prints the following matrix
     * @param array the 2D array of integers representing the matrix
     * @returns none
     */
    public static void printMatrix(int[][] array) {
        int i, j;

        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int len = scnr.nextInt();
        int scalar = scnr.nextInt();
        int i, j;

        // declare your two 2D arrays here
        int[][] array = new int[len][len];
        int[][] newArray = new int[len][len];

        // read in the values to the first 2D array
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
                array[i][j] = scnr.nextInt();
            }
        }

        // call your methods here
        newArray = scalarMult(scalar, array);
        printMatrix(newArray);
    }
}
