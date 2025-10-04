/**
 * This program uses the linear search method to allow a user to search for a programming language
 * to see if is one of the 15 most popular languages currently used today
 * 
 * CIS 36B
 * @author Dylan Lam
 */

import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        int location;
        String[] mostPopular = { "Java", "Python", "C++", "Javascript", "C#",
                "SQL", "C", "PHP", "Go", "Swift", "Kotlin", "Ruby", "Typescript",
                "Scala", "R" };

        String[] mostInDemand = { "C", "C#", "C++", "Java", "Javascript", "Perl",
                "PHP", "Python", "Ruby", "Visual Basic" };

        System.out.print("Welcome!\n\nEnter the name of a programming language: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        // add your call linear search method here from the prior assignment
        location = linearSearch(mostPopular, name);
        System.out.print("According to HackerRank ");

        if (location == -1) {
            System.out.println(name + " is not one of the top 15 most popular programming languages.");
        } else {
            System.out.println(name + " is language #" + (location + 1)
            + " in the list of 15 most popular programming languages.");
        }

        location = binarySearch(mostInDemand, name);
        System.out.print("\nAccording to Information Week ");
        if (location == -1) {
            System.out.println(name + " is not one of the 10 programming languages"
            + " that will future-proof your portfolio.");
        } else {
            System.out.println(name + " is one of the 10 programming languages"
            + " that will future-proof your portfolio.");
        }
    }

    /**
     * Searches an array sequentially for a particular value
     * 
     * @param array the String array to search
     * @param value the String value to search for
     * @return the index of the item in the array
     *         if it exists in the array or -1 if it doesn't
     */
    public static int linearSearch(String[] array, String name) {
        int i;
        int index = -1;

        for (i = 0; i < array.length; ++i) {
            if (array[i].equals(name)) {
                index = i;
            }
        }

        return index;
    }

    /**
     * Searches an array using binary search for a particular value
     * 
     * @param array the String array to search
     * @param value the String value to search for
     * @return the index of the item in the array
     *         if it exists in the array or -1 if it doesn't
     */
    public static int binarySearch(String[] array, String name) {
        int mid, compare;
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            mid = (low + high) / 2;
            compare = array[mid].compareTo(name);

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

}