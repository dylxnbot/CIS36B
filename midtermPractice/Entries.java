/**
 * 
 * 
 * @author Dylan Lam
 * 
 * CIS 36B
 */

//Write your import statements here
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Entries {
    final static int FIVE = 5;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String fileName, search, outFile;
        int index;

        // Prompt user to enter name of the file
        System.out.println("Enter the name of a file: ");
        fileName = input.next();

        // Process user entry
        System.out.println("Reading " + fileName + ".");
        String[] arrayEntries = readFile(fileName);

        // Searching for the entry
        System.out.println("Enter the first 5 characters of the entry to search for: ");
        search = input.next();

        // Searching for entry through formatted entries
        String[] arrayFormatEntries = formatEntries(arrayEntries);
        index = binarySearch(arrayFormatEntries, search);
        if (index == -1) {
            System.out.println("Sorry that entry cannot be found.");
        } else {
            System.out.println("Corresponding entry: ");
            System.out.println(arrayEntries[index]);
        }

        // Print card to file
        System.out.println("Enter the name of a file in which to print: ");
        outFile = input.next();
        PrintWriter output = new PrintWriter(outFile);
        printEntries(arrayFormatEntries, output);
        System.out.println("Open" + outFile + " to view first 5 characters of each entry");
        output.close();

    }

    /**
     * Method name readFile - reads the contents of the file into an array
     * 
     * @param fileName the String name of the file to read
     * @return an array of Strings containing the contents of the file
     */
    public static String[] readFile(String fileName) throws IOException {
        int i = 0, length = 0;
        String entry;

        // Processing file
        File userFile = new File(fileName);
        Scanner count = new Scanner(userFile);
        if(count.hasNextLine()) count.nextLine();
        while (count.hasNext()) { // Counting the number of entries in the file
            count.nextLine();
            length++;
        }
        count.close();

        // Inserting entries into an array
        String[] array = new String[length];
        Scanner entries = new Scanner(userFile);
        // Skip first line
        if(entries.hasNextLine()) entries.nextLine();
        while (entries.hasNext()) { // Adding card numbers to an array
            entry = entries.nextLine();
            array[i] = entry; // Adding entire card to array creditCard
            i++;
        }
        entries.close();

        return array;
    }

    /**
     * Method name: formatEntries - Creates a new array which contains only the first 5 characters
     * of the given array
     * 
     * @param entries an array of Strings
     * @return a Strin array containing the first 5 characters of each entry
     */
    public static String[] formatEntries(String[] array) {
        int i, length = array.length;
        String entry, first;
        String[] newArray = new String[length];

        for (i = 0; i < array.length; i++) {
            entry = array[i];
            first = entry.substring(0, Math.min(FIVE, entry.length()));
            newArray[i] = first;
        }

        return newArray;
    }

    /**
     * Method name: binarySearch - Uses the binary search algorith to locate an element inside
     * an array
     * 
     * @param array the list of elements
     * @param value the value to search for in the list
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
     * Method name: printEntries - Prints the shortned entries inside a text file
     * 
     * @param abbrevs the array of abbreviated entries
     * @param out a PrintWriter that has already been connected to an output file
     */
    public static void printEntries(String[] array, PrintWriter out) throws IOException {
        for (String s : array) {
            out.println(s);
        }
        //out.flush();
    }

} // end class
