package part1;
/**
* @author Dylan Lam
* CIS 36B
*/

public class PersonTest {
    public static void main(String[] args) {
        final int AGE = 19;
        Person wen = new Person();
        wen.name = "Wen";
        wen.age = AGE;
        wen.nationality = "Chinese";
        wen.greeting();
        wen.addYear();
        System.out.println("I just turned " + wen.age + " years old.");
    }
}