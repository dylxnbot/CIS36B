package lab;

/**
 * @author Dylan Lam
 *         CIS 36B
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class Theater {
   public static void main(String[] args) throws IOException {
      DecimalFormat money = new DecimalFormat("#0.00");
      final int SIZE = 9;
      final int TEN = 10;
      final int ONE = 1;
      int row, col, rowCol, seats, total = 0;
      String name, startingTime;
      double price;
      ArrayList<Movie> movies = new ArrayList<Movie>(); // fill in the rest of the line here

      // Reading from file oscars2022.txt
      File file = new File("oscars2022.txt");
      Scanner fileIn = new Scanner(file);

      while (fileIn.hasNextLine()) {
         name = fileIn.nextLine(); // Reading in first line into title line

         price = fileIn.nextDouble(); // Parsing the next line into a double
         fileIn.nextLine();

         startingTime = fileIn.nextLine();

         seats = fileIn.nextInt();
         fileIn.nextLine();

         Showtime showtime = new Showtime(startingTime);
         for (int i = 0; i < seats; i++) {
            rowCol = Integer.parseInt(fileIn.nextLine());
            row = (rowCol / TEN) - 1;
            col = (rowCol % TEN) - 1;

            if (row >= 0 && row < SIZE && col >= 0 && col < SIZE) {
               showtime.setSeat(row, col, "T");
            }
         }

         movies.add(new Movie(name, price, showtime));
      }
      fileIn.close();

      // UI for purchasing tickets
      Scanner input = new Scanner(System.in);

      System.out.println("Welcome to the CineBucks Movie Theater!");
      System.out.println();
      System.out.println("Below are the showtimes for 2022 Oscar Best Picture Vintage Film Festival:");
      System.out.println();

      // List movies for the user
      for (int i = 0; i < movies.size(); i++) {
         System.out.println("Option " + (i + 1) + ":");
         System.out.println(movies.get(i));
         System.out.println();
      }

      // Prompt user for movie selection
      System.out.print("Enter the option number of the movie: ");
      int choice = input.nextInt();
      while (choice > TEN || choice < ONE) {
         System.out.println("Invalid option. Please try again!");
         System.out.print("Enter the option number of the movie: ");
         choice = input.nextInt();
         System.out.println();
      }
      System.out.println();

      Movie userMovie = movies.get(choice - 1);
      Showtime showtime = userMovie.getShowtime();
      System.out.println("You selected " + userMovie.getName() + "!");

      // Seat loop for purchasing tickets of the movie
      boolean purchasing = true;
      while (purchasing) {
         System.out.println(showtime.seatingChartToString(userMovie.getName()));
         System.out.println();
         System.out.print("Enter the rowcol of the seat to purchase: ");
         rowCol = input.nextInt();
         row = (rowCol / TEN) - 1;
         col = (rowCol % TEN) - 1;

         // Checking to see if current seat is taken
         String currentSeat = showtime.getSeat(row, col);
         if ("T".equalsIgnoreCase(currentSeat)) {
            System.out.println("Sorry! That seat is already taken!");
            System.out.println("Please try again.");
            continue;
         }

         // Set seat to taken if available
         System.out.print("Your ticket is confirmed!");
         total++;
         showtime.setSeat(row, col, "O");
         System.out.println(showtime.seatingChartToString(userMovie.getName()));

         // Prompt user to buy another seat
         System.out.println();
         System.out.print("Another seat (y/n)?: ");
         String anotherSeat = input.next();

         // If user says no
         if (anotherSeat.equalsIgnoreCase(("n"))) {
            System.out.println("You ordered " + total + " tickets for " + userMovie.getName() + " at "
                  + showtime.getStartingTime() + ".");
            double totalPrice = userMovie.getPrice() * total;
            System.out.println("Your total today is: $" + money.format(totalPrice) + ".");

            // Writen to receipt.txt
            PrintWriter outFile = new PrintWriter("receipt.txt");
            outFile.println("****Receipt****");
            outFile.println();
            outFile.println("You ordered " + total + " tickets for " + userMovie.getName() + " at "
                  + showtime.getStartingTime() + ".");
            outFile.println("Total: $" + money.format(totalPrice) + ".");
            outFile.println();
            outFile.print("Enjoy the show!");
            outFile.close();

            // User is done purchasing tickets
            purchasing = false;
         }
      }
      System.out.println();
      System.out.println("Please open receipt.txt to view your receipt.");
      System.out.println();
      System.out.print("Thank you! Please come again.");
   }
}
