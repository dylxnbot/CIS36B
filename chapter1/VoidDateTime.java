
/**
 * A program that uses void methods to print dates and times in both the American and European formats
 * 
 * CIS 36B
 * @author Dylan Lam
 */

import java.util.Scanner;

public class VoidDateTime {
    // minutes, hours, months, days less than 10 to put 0 before the number
    final static int LIMIT = 10;
    final static int PM = 12;

    /**
     * Prints the date in the US format
     * 
     * @param day the day of the month
     * @param month the month of the year
     * @param year the year
     */
    public static void printUSDate(int day, int month, int year) {
        System.out.print("U.S. date format: ");

        // Checking if the day or month is less than 10 to put a zero in front of the
        // integer
        if (month < LIMIT) {
            System.out.print("0" + month + "-");
        } else {
            System.out.print(month + "-");
        }

        if (day < LIMIT) {
            System.out.print("0" + day + "-");
        } else {
            System.out.print(day + "-");
        }
        System.out.println(year);
    }

    /**
     * Prints the date in the European format
     * 
     * @param day the day of the month
     * @param month the month of the year
     * @param year the year
     */
    public static void printEuropeanDate(int day, int month, int year) {
        System.out.print("European date format: ");

        if (day < LIMIT) {
            System.out.print("0" + day + ".");
        } else {
            System.out.print(day + ".");
        }

        if (month < LIMIT) {
            System.out.print("0" + month + ".");
        } else {
            System.out.print(month + ".");
        }

        System.out.println(year);
    }

    /**
     * Prints the time in the US format
     * 
     * @param hour the hour
     * @param minutes the minutes
     * @param isAM if true it is am and if false it is pm
     */
    public static void printUSTime(int hour, int minutes, boolean isAM) {
        System.out.print("U.S. time: ");

        if (isAM) {
            if (minutes < LIMIT) {
                System.out.println(hour + ":0" + minutes + "am");
            } else {
                System.out.println(hour + ":" + minutes + "am");
            }
        } else {
            if (minutes < LIMIT) {
                System.out.println(hour + ":0" + minutes + "pm");
            } else {
                System.out.println(hour + ":" + minutes + "pm");
            }
        }
    }

    /**
     * Prints the time in the European format
     * 
     * @param hour the hour
     * @param minutes the minutes
     * @param isAM if true it is am and if false it is pm
     */
    public static void printEuropeanTime(int hour, int minutes, boolean isAM) {
        System.out.print("European time: ");

        if (isAM) {
            if (hour < LIMIT) {
                System.out.print("0" + hour + ":");
            } else {
                System.out.print(hour + ":");
            }

            if (minutes < LIMIT) {
                System.out.println("0" + minutes);
            } else {
                System.out.println(minutes);
            }
        } else {
            if(minutes < LIMIT) {
                System.out.println((hour + PM) + ":0" + minutes);
            } else {
                System.out.println((hour + PM) + ":" + minutes);
            }
        }
    }

    public static void main(String[] args) {
        int year;
        int day;
        int month;
        int hour;
        int minutes;
        boolean isAM;

        Scanner input = new Scanner(System.in);
        year = input.nextInt();
        month = input.nextInt();
        day = input.nextInt();
        hour = input.nextInt();
        minutes = input.nextInt();
        isAM = input.nextBoolean();

        // call your methods here to print (1) US date, (2) European date
        // (3) US time, (4) European time
        printUSDate(day, month, year);
        printUSTime(hour, minutes, isAM);
        printEuropeanDate(day, month, year);
        printEuropeanTime(hour, minutes, isAM);

        input.close();
    }
}
