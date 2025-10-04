/**
 * Takes a list of unknown size from a file, and then outputs the average of these numbers
 * 
 * CIS 36B
 * @author Dylan Lam
 */

import java.io.*;
import java.util.Scanner;

public class Averages {

	public static void main(String[] args) throws IOException{ //update this line
        double sum = 0.0;
        int count = 0;
        double num;

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the name of an input file: ");
		// Add your code here
        String userFile = input.next();
        File inFile = new File(userFile);
        input.close();

        input = new Scanner(inFile);
        while(input.hasNextDouble()) {
            num = input.nextDouble();
            sum += num;
            count++;
        }

        File outFile = new File("average.txt");
        PrintWriter out = new PrintWriter(outFile);
        out.printf("The average is: %.1f", sum / count);

        input.close();
        out.close();
	}
	
}