/**
 * @author Dylan Lam
 * 
 * CIS 36B
 */

// Write your imports and main method here
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Credit {
    final static int TWELVE = 12;
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String fileName, card, search, outFile;
        int numCards, index, i = 0;

        // Asking user for the name of the file
        System.out.println("Enter the name of a file with credit card data: ");
        fileName = input.next();

        // Process file that user searched for
        File userFile = new File(fileName);
        Scanner openFile = new Scanner(userFile);

        numCards = openFile.nextInt(); // Taking the integer in the first line of the file
        openFile.nextLine(); // Skipping blank line after the first line has been stored
        System.out.println("Reading " + fileName + " and processing " + numCards + " credit cards.");

        String[] creditCard = new String[numCards];
        while (openFile.hasNext()) { // Adding card numbers to an array
            card = openFile.nextLine();
            creditCard[i] = card; // Adding entire card to array creditCard
            i++;
        }
        openFile.close();

        // Using redactCards method to store the last 4 digits of a card # into a new
        // array
        String[] cardSearch = new String[numCards];
        cardSearch = redactCards(creditCard);

        // Searching for card using the last 4 digits of the card that the user enters
        System.out.println("Enter the last 4 digits of the card to search for: ");
        search = input.next();
        index = binarySearch(cardSearch, search);
        if (index == -1) {
            System.out.println("Sorry. That card number is not in our system.");
        } else {
            System.out.println("Corresponding card number: ");
            System.out.println(creditCard[index]);
        }

        // Prints cards into a file
        System.out.println("Enter the name of a file in which to print: ");
        outFile = input.next();
        PrintWriter output = new PrintWriter(outFile);
        printCards(cardSearch, output);
        System.out.println("Open " + outFile + " for redacted credit card information.");
    }

    /**
     * Method name: redactCards
     * Redacts an array of credit cards numbers by removing first 12 digits and
     * retaining only the last 4 digits to insert into another array
     * 
     * @param cards a String array of credit card numbers
     * @return an array containing only the last 4 digits of the credit card
     */
    public static String[] redactCards(String[] cards) {
        String card, lastDigits;
        int i, length;

        length = cards.length;
        String[] newArray = new String[length];

        for (i = 0; i < cards.length; ++i) {
            card = cards[i];
            lastDigits = card.substring(TWELVE);
            newArray[i] = lastDigits;
        }

        return newArray;
    }

    /**
     * Method name: binarySearch
     * Uses the binary search algorithm to locate an element inside an array
     * 
     * @param array the list of elements
     * @param value the element to search for in the list
     * @return the location of value in the array or -1 if not found
     */
    public static int binarySearch(String[] array, String value) {
        int mid, compare;
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            mid = (low + high) / 2;
            compare = array[mid].compareTo(value);

            if (compare < 0) {
                low = mid + 1;
            } else if (compare > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * Method name: printCards
     * Prints the redacted credit card numbers inside a text file with 12 *s in
     * front of the 4 digits
     * 
     * @param numbers the array of credit card numbers
     * @param writer  the PrintWriter that has been connected to a text file
     */
    public static void printCards(String[] numbers, PrintWriter writer) {
        int i;

        for (i = 0; i < numbers.length; ++i) {
            // System.out.println("************" + array.get(i));
            writer.println("************" + numbers[i]);
        }
        writer.close();
    }
}
