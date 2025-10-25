package flashCards;

/**
 * @author Jennifer Parrish
 * CIS 36B
 */
 
public class Card {
    public String english;
    public String spanish;
    
    /**
     * Prints the Card in the format
     * english: spanish
     */
    public void printCard() {
        System.out.println(english + ": " + spanish);
    }
}
