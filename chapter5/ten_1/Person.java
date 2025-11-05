package ten_1;

/**
 * @author Dylan Lam
 * CIS 36B
 */

public class Person {
    // Member variables
    private String name;
    private int age;
    private String nationality;

    // Constructors
    /**
     * Constructor that takes in no parameters and sets the parameters to defualt values
     */
    public Person() {
        name = "name unknown";
        age = 0;
        nationality = "nationality unknown";
    }

    /**
     * Constructor that takes in three parameters and sets the parameters to the
     * parameter values
     * 
     * @param personName the name the user input
     * @param personAge the age the user input
     * @param personNationality the nationality the user input
     */
    public Person(String personName, int personAge, String personNationality) {
        name = personName;
        age = personAge;
        nationality = personNationality;
    }
     

    // Setters
    /**
     * Method name: setName
     * Modifies the name field
     * 
     * @param name sets this.name to name
     */
    public void setName(String personName) {
        name = personName;
    }

    /**
     * Method name: setAge
     * Modifies the age field
     * 
     * @param age sets this.age to age
     */
    public void setAge(int personAge) {
        age = personAge;
    }

    /**
     * Method name: setNationality
     * Modifies the nationality field
     * 
     * @param nationality sets this.nationality to nationality
     */
    public void setNationality(String personNationality) {
        nationality = personNationality;
    }

    // Getters
    /**
     * Method name: getNationality
     * Returns the name field
     * 
     * @return the name field
     */
    public String getName() {
        return name;
    }

    /**
     * Method name: getAge
     * Returns the age field
     * 
     * @return the age field
     */
    public int getAge() {
        return age;
    }

    /**
     * Method name: getNationality
     * Returns the nationality field
     * 
     * @return the nationality field
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Method name: greeting
     * Prints out a greeting followed by a new line
     */
    public void greeting() {
        System.out.println("Hi, my name is " + name + "!");
    }

    /**
     * Method name: otherName
     * Prints out a greeting followed by a new line
     * 
     * @param otherName the string parameter for the other person's name
     */
    public void greeting(String otherName) {
        System.out.println("Hi, " + name + "!");
    }

    /**
     * Method name: addYear
     * Adds 1 year to the objects age
     */
    public void addYear() {
        age += 1;
    }

    /**
     * Method name: toString
     * @return returns the information of a Student object
     */
    @Override
    public String toString() {
        return "Name: " + name +
        "\nAge: " + age +
        "\nNationality: " + nationality;
    }
}

