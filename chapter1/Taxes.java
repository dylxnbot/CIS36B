/**
 * The program calculates US income tax owed depending on the paramater the user inputs
 * 
 * CIS 36B
 * @author Dylan Lam
 */

import java.util.Scanner;

public class Taxes {
    /**
     * Calcualtes AGI given wages, interest, and unemployment
     * 
     * @param wages the wages earned as an integer number
     * @param interest the interest earned as an integer
     * @param unemployment the unemployment compensation earned as an integer
     * @return the positive sum of the parameters
     */
    public static int calcAGI(int wages, int interest, int unemployment) {
        int agi;

        agi = wages + interest + unemployment;
        return Math.abs(agi);
    }

    /**
     * Return the deduction amount based on status
     * 
     * @param status an integer representing (0) dependent, (1) single, or (2) married
     * @return the correct deduction amount based on status
     */
    public static int getDeduction(int status) {
        final int DEDUCTION1 = 6000;
        final int DEDUCTION2 = 12000;
        final int DEDUCTION3 = 24000;

        int deduction;
        if(status == 0) {
            deduction = DEDUCTION1;
        } else if(status == 1) {
            deduction = DEDUCTION2;
        } else if(status == 2) {
            deduction = DEDUCTION3;
        } else {
            deduction = DEDUCTION1;
        }

        return deduction;
    }

    /**
     * Calculate the taxable amount
     * 
     * @param agi an integer representing the sum of the wages, interest, and unemployment
     * @param deduction an integer representing the deduction based on status
     * @return the taxable income
     */
    public static int calcTaxable(int agi, int deduction) { 
        int taxable;

        taxable = agi - deduction;
        if(taxable < 0) {
            taxable = 0;
        }

        return taxable;
    }

    /**
     * Calculates tax amount based on status and taxable income
     * 
     * @param status an integer representing (0) dependent, (1) single, or (2) married
     * @param taxable the integer value of the user's taxable incom
     * @return the tax rounded to a whole number
     */
    public static int calcTax(int status, int taxable) {
        final int LOWTAX1 = 10000;
        final int MIDTAX1 = 40000;
        final int HIGHTAX1 = 85000;
        final int THOUSAND = 1000;
        final double ONE = 0.1;
        final double ONETWO = 0.12;
        final double TWOTWO = 0.22;
        final double FOURTHOUSIX = 4600;
        final double TWOFOUR = 0.24;
        final int FOURTEENTHOU5 = 14500;
        final int LOWTAX2 = 20000;
        final int MIDTAX2 = 80000;
        final int TWOTHOU = 2000;
        final int NINETHOUTWO = 9200;
        
        double tax = 0.0;
        if(status == 1 || status == 0) {
            if(taxable <= LOWTAX1) {
                tax = ONE * taxable;
            } else if(taxable <= MIDTAX1) {
                tax = (taxable - LOWTAX1) * ONETWO + THOUSAND;
            } else if(taxable <= HIGHTAX1) {
                tax = (taxable - MIDTAX1) * TWOTWO + FOURTHOUSIX;
            } else {
                tax = (taxable - HIGHTAX1) * TWOFOUR + FOURTEENTHOU5;
            }
        } else {
            if(taxable <= LOWTAX2) {
                tax = taxable * ONE;
            } else if(taxable <= MIDTAX2) {
                tax = (taxable - LOWTAX2) * ONETWO + TWOTHOU;
            } else {
                tax = (taxable - MIDTAX2) * TWOTWO + NINETHOUTWO;
            }
        }

        return (int)Math.round(tax);
    }

    /**
     * Calculates and return the amount of tax due
     * 
     * @param tax the integer value for the calculated tax
     * @param withheld the integer value of the the amount that has been withheld
     * @return the tax rounded to a whole number
     */
    public static int calcTaxDue(int tax, int withheld) {
        int due;
        
        due = tax - withheld;
        return due;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wages = 0;
        int interest = 0;
        int unemployment = 0;
        int status = -1;
        int withheld = 0;
        int agi;
        int deduction;
        int taxable;
        int tax;
        int due;

        // Step #1: Input information
        wages = scan.nextInt();
        interest = scan.nextInt();
        unemployment = scan.nextInt();
        status = scan.nextInt();
        withheld = scan.nextInt();

        // Step #2: Calculate AGI
        agi = calcAGI(wages, interest, unemployment);
        System.out.printf("AGI: $%,d\n", agi);

        // Step #3: Get deduction
        deduction = getDeduction(status);
        System.out.printf("Deduction: $%,d\n", deduction);

        // Step #4: Calculate taxable income
        taxable = calcTaxable(agi, deduction);
        System.out.printf("Taxable income: $%,d\n", taxable);

        // Step #5: Calculate tax amount based on status and taxable income
        tax = calcTax(status, taxable);
        System.out.printf("Federal tax: $%,d\n", tax);

        // Step #6: Calculate the amount of tax due
        due = calcTaxDue(tax, withheld);
        System.out.printf("Tax due: $%,d\n", due);

        scan.close();
    }

}
