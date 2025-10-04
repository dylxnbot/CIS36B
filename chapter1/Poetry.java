/**
 * Counts the number of words and the number of lines in a file containing a poem
 * 
 * CIS 36B
 * @author Dylan Lam
 */

import java.io.*;
import java.util.Scanner;

public class Poetry {

	public static void main(String[] args) throws IOException{ //update this line
		Scanner input = new Scanner(System.in);
		String word, line, title;
		int count = 0;
		
        // Asking for user input
        System.out.print("Enter the name of an input file: ");
        String userFile = input.next();
        File inFile = new File(userFile);
        PrintWriter outFile = new PrintWriter("statistics.txt");
        input.close();

        input = new Scanner(inFile);    // scanning file that user input
        title = input.nextLine();       // saving first line of file into title variable

        while(input.hasNext()) {
            input.next();
            count++;
        }
        input.close();
        
        outFile.println("Statistics for " + title + ":");
        outFile.println("Word count: " + count);

        // Console output
        System.out.println("Statistics for " + title + ":");
        System.out.println("Word count: " + count);
        
        input = new Scanner(inFile);
        title = input.nextLine();       // Skipping title line
        input.nextLine();               // Skipping blank line after title line

        count = 0;
        while(input.hasNext()) {
            input.nextLine();
            count++;
        }
        input.close();

        outFile.println("Line count: " + count);
        outFile.close();

        // Console output
        System.out.println("Line count: " + count);
	}
	
}