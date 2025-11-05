package lab;

/**
 * @author Dylan Lam
 *         CIS 36B
 */

public class Showtime {
    private static final int SIZE = 9;
    private int ticketsSold;
    private String startingTime;
    private String[][] seats = new String[SIZE][SIZE];

    // Constructors
    /**
     * Constructor that takes in no parameters and sets the parameters to defualt
     * values
     */
    public Showtime() {
        ticketsSold = 0;
        startingTime = "No assigned starting time";
        initializeSeats();
    }

    /**
     * Constructor that takes in one parameters and sets the parameters to the
     * parameter values
     * 
     * @param newTime the starting time of the show
     */
    public Showtime(String newTime) {
        ticketsSold = 0;
        startingTime = newTime;
        initializeSeats();
    }

    /**
     * Assigns "X" to each seat in the seats array
     */
    private void initializeSeats() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                seats[row][col] = "X";
            }
        }
    }

    // GETTERS
    /**
     * Method name: getStartingTime
     * Returns the startingTime field
     * 
     * @return the startingTime field
     */
    public String getStartingTime() {
        return startingTime;
    }

    /**
     * Method name: getTicketsSold
     * Returns the ticketsSold field
     * 
     * @return the ticketsSold field
     */
    public int getTicketsSold() {
        return ticketsSold;
    }

    /**
     * Method name: getSeat
     * Returns the availability of the seat in that row and column
     * 
     * @param row the row of the seat
     * @param col the column of the seat
     * @return the availability of the seat
     */
    public String getSeat(int row, int col) {
        return seats[row][col];
    }
    // END OF GETTERS

    // SETTERS
    /**
     * Method name: setStartingTime
     * Modifies the startingTime field
     * 
     * @param newTime sets the startingTime to newTime
     */
    public void setStartingTime(String newTime) {
        startingTime = newTime;
    }

    /**
     * Method name: setSeat
     * Modifies the seats[][] field at the specified row and column
     * 
     * @param row the row of the seat
     * @param col the column of the seat
     * @param symbol the state of the seat
     */
    public void setSeat(int row, int col, String symbol) {
        seats[row][col] = symbol;
        ticketsSold++;
    }
    // END OF SETTERS

    /**
     * Method name: seatingChartToString
     * Creates a String of the seats array for console display with
     * row and column numbers
     * 
     * @param name the name of the movie
     * @return the updated seating chart with seat availability
     */
    public String seatingChartToString(String name) {
        String chart = "";

        // Header line
        // MIGHT HAVE TO CHANGE BUT ADDED TO chart String
        chart += "\nHere are the available seats for " + name + " at " + startingTime + ":\n\n";

        // Column header
        chart += "  ";
        for (int col = 1; col <= SIZE; col++) {
            chart += col;
            if (col < SIZE) {
                chart += " ";
            }
        }
        chart += "\n";

        // Rows
        for (int row = 0; row < SIZE; row++) {
            chart += (row + 1) + " ";
            // Printing seat availability
            for (int col = 0; col < SIZE; col++) {
                chart += seats[row][col];
                if (col < SIZE - 1) {
                    chart += " ";
                } else {
                    chart += " "; // two spaces at end of row
                }
            }
            chart += "\n";

        }

        // Screen line
        chart += "*******SCREEN******";
        return chart;
    }

    /**
     * Method name: toString
     * 
     * @return returns the starting time of the movie
     */
    @Override
    public String toString() {
        return "Showtime: " + startingTime;
    }
}
