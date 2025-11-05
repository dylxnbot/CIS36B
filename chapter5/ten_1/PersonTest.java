package ten_1;

/**
* PersonTest.java
* @author Your name
* CIS 36B
*/

import java.util.Scanner;

public class PersonTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name, nationality;
        int age;
        Person person;

        System.out.print("Welcome!\n\nEnter your name: ");
        name = input.nextLine();

        System.out.print("Enter your age: ");
        age = input.nextInt();

        System.out.print("Enter your nationality: ");
        nationality = input.next();

        //See instructions for this line
        person = new Person(name, age, nationality);

        System.out.println("\nYour Summary:\n" + person);
    }
}

