/**
 * Checks to see if a number the user inputs is a primary or composite number
 * 
 * CIS 36B
 * @author Dylan Lam
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PrimeNums {
    public static void main(String[] args) throws IOException {
        Scanner userInput = new Scanner(System.in);
        String number;
        int i, searchReturn;
        int count = 0;

        // Setting a scanner to read from the file prime_nums.txt
        String fileName = "prime_nums.txt";
        File inFile = new File(fileName);
        Scanner input = new Scanner(inFile);

        // Counting the number of prime numbers in the text file
        while (input.hasNext()) {
            input.next();
            count++;
        }
        input.close();

        // Making a loop to put numbers from text file into array as strings
        String[] primes = new String[count];
        input = new Scanner(inFile);
        for (i = 0; i < primes.length; i++) {
            primes[i] = input.next().replace(",", "");
        }
        input.close();

        // Searching for the number the user entered in the array using binarySearch
        // method
        number = "";

        System.out.println("Welcome!\n");
        while (true) {
            System.out.println("Enter a number from 1 to 10,000 or 'x' to exit:");
            number = userInput.next();

            // Checks to see if the user wants to exit the program
            if (number.equals("x")) {
                break;
            } else {
                searchReturn = binarySearch(primes, number);
                if(searchReturn != -1) { 
                    System.out.println(number + " is prime.\n");
                } else {
                    System.out.println(number + " is composite.\n");
                }

            }
        }
        System.out.println("Goodbye!");
    }

    /**
     * Searches an array using binary search for a particular value
     * 
     * @param array the String array to search
     * @param value the String value to search for
     * @return the index of the item in the array
     *         if it exists in the array or -1 if it doesn't
     */
    public static int binarySearch(String[] primes, String number) {
        int mid, compare, target;
        int low = 0;
        int high = primes.length - 1;

        while (low <= high) {
            mid = (low + high) / 2;
            compare = Integer.parseInt(primes[mid]);
            target = Integer.parseInt(number);

            if (compare < target) {
                low = mid + 1;
            } else if (compare > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}