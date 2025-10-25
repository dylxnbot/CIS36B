/**
 * @author Dylan Lam
 * CIS 36B
 */

package part2;

import java.util.Scanner;
import java.util.ArrayList;

public class PersonTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int AGE = 19;
        Person wen = new Person();
        wen.name = "Wen";
        wen.age = AGE;
        wen.nationality = "Chinese";
        wen.greeting();
       
        System.out.print("\nWhat's your name: ");
        String name = input.nextLine();
        //call greeting method passing in name parameter to allow Wen to greet
        //the other person
        wen.greeting(name);
        
        System.out.print("\nHow old are you: ");
        int age = input.nextInt();
        System.out.print("What is your nationality: ");
        input.nextLine();
        String nationality = input.nextLine(); 
        
        //make a new Person here called "second" and assign that Person the name, age and nationality read from console
        Person second = new Person();
        second.name = name;
        second.age = age;
        second.nationality = nationality;
             
        ArrayList<Person> pair = new ArrayList<Person>(2);
        pair.add(wen);
        //add second person to ArrayList here
        pair.add(second);
        
        System.out.println("\nPair Programming Partners: ");
        for (int i = 0; i < pair.size(); i++) {
            //add a line of code to call printPerson on each person in ArrayList
            pair.get(i).printPerson();
            System.out.println();
        }  
    }
}
