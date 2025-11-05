package part1;
/**
* @author Dylan Lam
* CIS 36B
*/

public class Person {
    // Member variables
    public String name;
    public int age;
    public String nationality;

    /**
     * Method name: greeting
     * Prints out a greeting followed by a new line
     */
    public void greeting() { // Prints name and rating on one line
        System.out.println("Hi, my name is " + name + "!");
    }

    /**
     * Method name: addYear
     * Adds 1 year to the objects age
     */
    public void addYear() {
        age += 1;
    }
}
