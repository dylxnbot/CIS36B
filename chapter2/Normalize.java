/**
 * Adjust the values by subtracting each value from the maximum
 * 
 * CIS 36B
 * @author Dylan Lam
 */

import java.util.Scanner;

public class Normalize {

    /**
     * Prints the normalized array after subtracting the max value from the array element
     * 
     * @param array the user filled double array
     * @param value the max value to subtract the array elements
     * @return none
     */
    public static void printNormalizedArray(double[] array, double maxVal) {
        int i;

        for(i = 0; i < array.length; ++i) {
            array[i] = maxVal - array[i];
            System.out.printf("%.1f ", array[i]);
        }
    }

    /**
     * Fills an empty array with doubles that the user inputs
     * 
     * @param array an empty double array
     * @param input Scanner to read inputs into the array
     * @return none
     */
    public static void readInput(double[] array, Scanner input) {
        int i;
        
        for(i = 0; i < array.length; ++i) {
            array[i] = input.nextDouble();
        }
    }

    /**
     * Searches an array for its biggest value
     * 
     * @param array the double array to search
     * @return the biggest element in the array
     */
    public static double getMax(double[] array) {
        double maxVal;
        int i;

        maxVal = 0;
        for(i = 0; i < array.length; ++i) {
            if(array[i] > maxVal) {
                maxVal = array[i];
            }
        }
        
        return maxVal;
    }

    public static void main(String[] args) {
        int value;
        double maxVal;
        double[] array;
        Scanner input = new Scanner(System.in);

        value = input.nextInt();
        array = new double[value];

        // Initializing array
        readInput(array, input);

        // Finding the greatest value
        maxVal = getMax(array);
        System.out.println("Max Value: " + maxVal);

        // Printing the normalized values
        System.out.print("Normalized Values: ");
        printNormalizedArray(array, maxVal);
    }
}
