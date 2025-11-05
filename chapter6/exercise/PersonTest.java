package exercise;
/**
 * PersonTest.java
 * @author Dylan
 * CIS 36B
 */

import java.util.Scanner;

public class PersonTest {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String name, nationality, street;
      int age, number;
      final int STREET_NUM = 42;
      final String STREET_NAME = "South 3rd St";
      Person person1;

      System.out.print("Welcome!\n\nEnter your name: ");
      name = input.nextLine();

      System.out.print("Enter your age: ");
      age = input.nextInt();

      System.out.print("Enter your nationality: ");
      nationality = input.next();

      System.out.print("Enter the street number of your address: ");
      number = input.nextInt();

      System.out.print("Enter the name of your street: ");
      input.nextLine();
      street = input.nextLine();

      Address address = new Address(number, street);

      person1 = new Person(name, age, nationality, address);
      // call updateNumPersons() here
      Person.increaseNumPersons();
      System.out.println("\nYour Summary:\n" + person1);

      Person person2 = new Person(person1);
      person2.setName("C.J. Nguyen");
      Address add = new Address(STREET_NUM, STREET_NAME);
      person2.setAddress(add);
      // call increaseNumPersons() here
      Person.increaseNumPersons();

      System.out.println("\nAnother student with your "
          + "same age and nationality: \n" + person2);

        System.out.println("\nTotal num persons: " + Person.getNumPersons());
        input.close();
   }
}
