/**
 * @author Dylan Lam
 * CIS 36B
 */

import java.util.Scanner;
import java.io.*;

public class PersonTest {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        File file = new File("person.txt");
        PrintWriter out = new PrintWriter(file);

        String name, nationality;
        int age;
        Person person = new Person();

        System.out.print("Welcome!\n\nEnter your name: ");
        name = input.nextLine();
        person.setName(name);
        System.out.println("You entered: " + person.getName() + "\n");

        System.out.print("Enter your age: ");
        age = input.nextInt();
        person.setAge(age);

        System.out.println("You entered: " + person.getAge() + "\n");

        System.out.print("Enter your nationality: ");
        input.nextLine();
        nationality = input.nextLine();
        person.setNationality(nationality);
        System.out.println("You entered: " + person.getNationality() + "\n");

        // See instructions for these lines
        System.out.println("Your Summary:\n" + person.toString());
        out.println("Your Summary: ");
        out.println(person.toString());
        out.close();

    }
}
