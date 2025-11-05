package lab;

/**
 * @author Dylan Lam
 *         CIS 36B
 */

import java.text.DecimalFormat;

public class Movie {
   private String name;
   private double price;
   private Showtime showtime;

   // Constructors
   /**
    * Constructor that takes in no parameters and sets the parameters to defualt
    * values
    */
   public Movie() {
      name = "No name yet";
      price = 0.0;
      showtime = new Showtime();
   }

   /**
    * Constructor that takes in three parameters and sets the parameters to
    * the parameter values
    * 
    * @param newName     the name of the movie
    * @param newPrice    the price of the ticket
    * @param newShowtime starting time of the movie
    */
   public Movie(String newName, double newPrice, Showtime newShowtime) {
      name = newName;
      price = newPrice;
      showtime = newShowtime;
   }

   // GETTERS
   /**
    * Method name: getName
    * Returns the name field
    * 
    * @return the name field
    */
   public String getName() {
      return name;
   }

   /**
    * Method name: getPrice
    * Returns the price field
    * 
    * @return the price field
    */
   public double getPrice() {
      return price;
   }

   /**
    * Method name: getShowtime
    * Returns the showtime field
    * 
    * @return the showtime field
    */
   public Showtime getShowtime() {
      return showtime;
   }
   // END OF GETTERS

   // SETTERS
   /**
    * Method name: setName
    * Modifies the original name field
    * 
    * @param name sets the the original name to the new name
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * Method name: setPrice
    * Modifies the original price field
    * 
    * @param price sets the the original price to the new price
    */
   public void setPrice(double price) {
      this.price = price;
   }

   /**
    * Method name: setShowtime
    * Modifies the newShowtime field
    * 
    * @param newShowtime sets the the showtime to newShowtime
    */
   public void setShowtime(Showtime newShowtime) {
      showtime = newShowtime;
   }

   /**
     * Method name: toString
     * 
     * @return returns a string of the movie
     */
   @Override
   public String toString() {
      return name + "\n"
      + "Ticket price: $" + String.format("%.2f", price) + "\n"
      + showtime;
   }
}
