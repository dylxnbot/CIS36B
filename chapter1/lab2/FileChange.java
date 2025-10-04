/**
 * Counts the number of words and the number of lines in a file containing a poem
 * 
 * CIS 36B
 * @author Dylan Lam
 */

package lab2;

import java.io.*;
import java.util.Scanner;

public class FileChange {
    public static void main(String[] args) throws IOException { // update main signature here
        Scanner scnr = new Scanner(System.in);
        String word;
        String modded;

        String userFile = scnr.next(); // Reading filename that user inputs
        File inFile = new File(userFile); // Opens file using filename that the user inputs
        scnr.close();

        PrintWriter outFile = new PrintWriter("photos.txt");    // Printing to photos.txt
        scnr = new Scanner(inFile);
        while(scnr.hasNext()) {
            word = scnr.next();
            modded = word.replace("_photo.jpg", "_info.txt");
            outFile.println(modded);
        }
        scnr.close();
        outFile.close();
    }
}
