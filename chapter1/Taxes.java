/**
 * The program calculates US income tax owed depending on the paramater the user inputs
 * 
 * CIS 36B
 * @author Dylan Lam
 */

import java.util.Scanner;

public class Taxes {

    // Write your methods and their Javadocs here
    public static int calcAGI(int wages, int interest, int unemployment) {
        int AGI;
        AGI = wages + interest + unemployment;
        return AGI;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wages = 0;
        int interest = 0;
        int unemployment = 0;
        int status = -1;
        int withheld = 0;
        int agi;

        // Step #1: Input information
        wages = scan.nextInt();
        interest = scan.nextInt();
        unemployment = scan.nextInt();
        status = scan.nextInt();
        withheld = scan.nextInt();

        // Step #2: Calculate AGI
        agi = calcAGI(wages, interest, unemployment);
        System.out.printf("AGI: $%,d\n", agi);

        scan.close();
    }

}
