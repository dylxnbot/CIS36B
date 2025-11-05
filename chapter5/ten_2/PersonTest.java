package ten_2;

/**
* PersonTest.java
* @author Your name
* CIS 36B
*/

import java.util.Scanner;

public class PersonTest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String name, nationality, street;
        int age, number;
        Person person1;

        System.out.println("Hello");
        System.out.print("Welcome!\n\nEnter your name: ");
        name = input.nextLine();

        System.out.print("Enter your age: ");
        age = input.nextInt();

        System.out.print("Enter your nationality: ");
        input.nextLine();
        nationality = input.nextLine();

        System.out.print("Enter the street number of your address: ");
        number = input.nextInt();

        System.out.print("Enter the name of your street: ");
        input.nextLine();
        street = input.nextLine();

        Address address = new Address(number, street);//See instructions for this line

        person1 = new Person(name, age, nationality, address);//See instructions for this line

        System.out.println("\nYour Summary:\n" + person1);

        input.close();
    }
}

