
/**
 * Counts how many times a character appears in a string
 * 
 * CIS 36B
 * @author Dylan Lam
 */

import java.util.Scanner;

public class CharCount {
    /**
     * Counts how many times a character appears in a string
     * 
     * @param character the character to count
     * @param sentence the string to search
     * @return the number of matching characters in the string
     */
    public static int calcTotalChars(String sentence, char character) {
        int i;
        int count = 0;

        for(i = 0; i < sentence.length(); i++) {
            if(character == sentence.charAt(i)){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        char userChar = scnr.next().charAt(0);        // read a character
        String userString = scnr.next();    // read a string

        int count = calcTotalChars(userString, userChar);
        
        System.out.println(count + " " + userChar);

        scnr.close();
    }
}
