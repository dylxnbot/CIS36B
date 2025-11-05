package ten_2;

/**
 * @author Dylan Lam
 *         CIS 36B
 */

public class Address {
    private int number;
    private String street;

    /**
     * Default constructor for the Address class
     * Initializes number to -1 and street to "Street unknown"
     */
    public Address() {
        number = -1;
        street = "Street unknown";
    }

    /**
     * Constructor for the Address class
     * 
     * @param number the street number
     * @param street the name of the street
     */
    public Address(int theNumber, String theStreet) {
        number = theNumber;
        street = theStreet;
    }

    /**
     * Returns the street number portion
     * of the address
     * 
     * @return the street number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns the name portion of the
     * address
     * 
     * @return the name of the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the number portion of the
     * address
     * 
     * @param theNumber name of the street
     */
    public void setNumber(int theNumber) {
        number = theNumber;
    }

    /**
     * Sets the street portion of the
     * address
     * 
     * @param theStreet name of the street
     */
    public void setStreet(String theStreet) {
        street = theStreet;
    }

    /**
     * Creates a String of the address in the format
     * See instructions and replace this line
     * 
     * @return a String containing the address
     */
    @Override
    public String toString() {
        return number + " " + street;
    }

}
