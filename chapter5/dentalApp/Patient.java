package dentalApp;

/**
 * @author Dylan Lam
 *         CIS 36B
 */

public class Patient {

    /** Variable Declarations */
    private int id;
    private String firstName;
    private String lastName;
    private String assignedHygienist;
    private String nextAppointment;
    private String[][] dentalChart;

    /** Constructors */
    /**
     * Constructor for the Patient class
     * 
     * @param theId the patient id
     * @param fName the patient first name
     * @param lName the patient last name
     */
    public Patient(int theId, String fName, String lName) {
        id = theId;
        firstName = fName;
        lastName = lName;
        assignedHygienist = "No hygienist assigned";
        nextAppointment = "No appointment scheduled";
        initializeDentalChart();
    }

    /**
     * Constructor for the Patient class
     * 
     * @param theId       the patient id
     * @param fName       the patient first name
     * @param lName       the patient last name
     * @param hygienist   the hygienist assigned to the patient
     * @param appointment the next appointment
     */
    public Patient(int theId, String fName, String lName, String hygienist, String appointment) {
        id = theId;
        firstName = fName;
        lastName = lName;
        assignedHygienist = hygienist;
        nextAppointment = appointment;
        initializeDentalChart();
    }

    /*** ACCESSORS ***/
    /**
     * Method name: getId
     * Returns the id field
     * 
     * @return the id field
     */
    public int getId() {
        return id;
    }

    /**
     * Method name: getFirstName
     * Returns the firstName field
     * 
     * @return the firstName field
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method name: getLastName
     * Returns the lastName field
     * 
     * @return the lastName field
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method name: getAssignedHygienist
     * Returns the assignedHygienist field
     * 
     * @return the assignedHygienist field
     */
    public String getAssignedHygienist() {
        return assignedHygienist;
    }

    /**
     * Method name: getNextAppointment
     * Returns the nextAppointment field
     * 
     * @return the nextAppointment field
     */
    public String getNextAppointment() {
        return nextAppointment;
    }

    /**
     * Method name: getDentalChart
     * Returns the dentalChart field
     * 
     * @return the dentalChart field
     */
    public String[][] getDentalChart() {
        return dentalChart;
    }

    /*** MUTATORS ***/
    /**
     * Assigns a new id to the patient
     * 
     * @param theId id of the patient
     */
    public void setId(int theId) {
        id = theId;
    }

    /**
     * Assigns a first name to the patient
     * 
     * @param fName first name of the patient
     */
    public void setFirstName(String fName) {
        firstName = fName;
    }

    /**
     * Assigns a last name to the patient
     * 
     * @param lName last name of the patient
     */
    public void setLastName(String lName) {
        lastName = lName;
    }

    /**
     * Assigns a hygienist to the patient
     * 
     * @param hygienist the name of the hygienist
     */
    public void setAssignedHygienist(String hygienist) {
        assignedHygienist = hygienist;
    }

    /**
     * Assigns an appointment to the patient
     * 
     * @param appointment the next appointment
     */
    public void setNextAppointment(String appointment) {
        nextAppointment = appointment;
    }

    /*** ADDITONAL OPERATIONS ***/
    /**
     * Updates a specific tooth in the dental chart to be a crown (represented as
     * "C")
     * 
     * @param row the row where the tooth is located
     * @param col the column where the tooth is located
     */
    public void updateCrown(int row, int col) {
        int r = row, c = col;
        // Normalize: if it looks 1-based, convert; else assume 0-based
        if (row >= 1 && row <= dentalChart.length && col >= 1 && col <= dentalChart[0].length) {
            r = row - 1;
            c = col - 1;
        }

        if (r < 0 || r >= dentalChart.length || c < 0 || c >= dentalChart[r].length)
            return;

        // Write unconditionally (no "space" guard)
        dentalChart[r][c] = "C";
    }

    /**
     * Updates a specific tooth in the dental chart to be a filling (represented as
     * "F")
     * 
     * @param row the row where the tooth is located
     * @param col the column where the tooth is located
     */
    public void updateFilling(int row, int col) {
        row -= 1;
        col -= 1;
        if (row < 0 || row >= dentalChart.length || col < 0 || col >= dentalChart[row].length) {
            return;
        }

        dentalChart[row][col] = "F";
    }

    /**
     * Updates a specific tooth in the dental chart to be a cavity (represented as
     * "X")
     * 
     * @param row the row where the tooth is located
     * @param col the column where the tooth is located
     */
    public void updateCavity(int row, int col) {
        row -= 1;
        col -= 1;
        if (row < 0 || row >= dentalChart.length || col < 0 || col >= dentalChart[row].length) {
            return;
        }

        dentalChart[row][col] = "X";
    }

    /**
     * Returns a String containing the patient id, first name,
     * last name, hygienist and next appointment
     * 
     * @return a String in the format:
     *         Patient ID: <id>
     *         Patient Name: <firstName> <lastName>
     *         Hygienist: <assignedHygienist>
     *         Upcoming appointment: <nextAppointment>
     *         Note that there are no <> around the information.
     *         The <> mean fill in the blank
     */
    @Override
    public String toString() {
        return "Patient ID: " + id +
            "\nPatient Name: " + firstName + " " + lastName +
            "\nHygienist: " + assignedHygienist +
            "\nUpcoming appointment: " + nextAppointment;
    }

    /**
     * Creates a String of the dental chart, including the
     * name of the patient for printing to the console
     * 
     * @return a String in the format:
     *         \n + firstName + " " + lastName + ":\n"
     *         Column numbers, aligned to chart
     *         Followed by patient teeth with row numbers (1-7)
     */
    public String dentalChartToString() {
        String name = "\n" + firstName + " " + lastName + ":\n";
        name += "  12345678\n"; // two leading spaces

        for (int r = 0; r < dentalChart.length; r++) {
            name += (r + 1) + " ";
            for (int c = 0; c < dentalChart[r].length; c++) {
                String cell = dentalChart[r][c];
                if (cell == null || cell.isEmpty()) {
                    name += " ";
                } else {
                    name += cell;
                }
            }
            name += "\n";
        }
        return name; // ends with newline
    }

    /**
     * Initializes the dental chart, including the
     * name of the patient.
     * This method only called by the constructor
     */
    private void initializeDentalChart() {
        final int SIZE = 8; // avoiding magic numbers
        final int SUBTRACTOR = 2;
        dentalChart = new String[SIZE - 1][SIZE];

        for (int i = 0; i < dentalChart.length; i++) {
            for (int j = 0; j < dentalChart[i].length; j++) {
                if (i == 0 && (j >= SUBTRACTOR && j < SIZE - SUBTRACTOR)) { // front teeth
                    dentalChart[i][j] = "O";
                } else if ((i == 1 && j == 1) || (i == 1 && j == SIZE - SUBTRACTOR)) { // side teeth
                    dentalChart[i][j] = "O";
                } else if ((j == 0 || j == SIZE - 1) && (SUBTRACTOR <= i && i <= SIZE - SUBTRACTOR)) { // back teeth
                    dentalChart[i][j] = "O";
                } else if ((j == SIZE - 1) && (SUBTRACTOR <= i && i <= SIZE - SUBTRACTOR)) {
                    dentalChart[i][j] = "O";
                } else {
                    dentalChart[i][j] = " ";
                }
            }
        }
    }
}
