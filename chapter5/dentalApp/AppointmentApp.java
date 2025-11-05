package dentalApp;

/**
 * @author Dylan Lam
 * CIS 36B
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class AppointmentApp {
    public static void main(String[] args) throws IOException {
        String[] hygienists = { "Dan Felipe", "Jasmine Brown", "Jin Yong" };

        ArrayList<Patient> patients = new ArrayList<Patient>();
        Patient patient = null;
        String firstName = "", lastName = "", choice;
        int id;
        final String FILE_NAME = "patient_records.txt";
        File file = new File(FILE_NAME);
        readFile(patients, hygienists, file); // Added read-file line
        Scanner input = new Scanner(System.in);
        boolean repeat = true;
        boolean known = false;
        System.out.println("Welcome to the Dental Appointment and Record App!\n");
        while (repeat) {
            System.out.println("Please select from one of the following options:\n");
            System.out.println("1. Search for patient by id.");
            System.out.println("2. Search for patient by first and last name.");
            System.out.print("\nEnter the number of your choice: ");
            choice = input.next();
            if (choice.equals("1")) {
                bubbleSortById(patients); // Sort by id to then search for the patient by id
                System.out.print("Enter the patient id: ");
                int patientId = input.nextInt();
                int index = binarySearchById(patients, patientId);

                if (index >= 0) {
                    patient = patients.get(index);
                } else {
                    System.out.println("The patient is not on file.");
                    System.out.println("Please create a new account");
                    System.out.println();
                    patient = createAccount(patients, known, firstName, lastName, input);
                }
                repeat = false;

            } else if (choice.equals("2")) {
                // fill in missing lines here
                repeat = false;
            } else {
                System.out.println("Invalid option. Please try again\n");
            }
        }
        System.out.println("\nHere is the information we have on file: ");
        System.out.println(patient); // Added this line to print patient info

        repeat = true;
        while (repeat) {
            System.out.println("\nPlease select from one of the following options:\n");
            System.out.println("A. Assign new hygienist");
            System.out.println("S. Schedule a patient appointment");
            System.out.println("V. View and update patient dental chart");
            System.out.println("Q. Quit");
            System.out.print("\nEnter your choice: ");
            choice = input.next();
            if (choice.equalsIgnoreCase("A")) {
                System.out.println();
                System.out.println("Please select from one of the following hygienists:");
                System.out.println();
                for (int i = 0; i < hygienists.length; ++i) {
                    System.out.println(i + ". " + hygienists[i]);
                }
                System.out.println();
                System.out.print("Enter the number of your choice: ");
                int hygienistChoice = input.nextInt();
                patient.setAssignedHygienist(hygienists[hygienistChoice]);
                System.out.println("Here is the updated patient information:");
                System.out.println();
                System.out.println(patient);
                System.out.println();

            } else if (choice.equalsIgnoreCase("S")) {
                System.out.println("Currently scheduled appointment: " + patient.getNextAppointment());
                System.out.println();
                System.out.println("Reschedule this appointment?");
                System.out.print("Enter 1 for yes or any other key + enter to return to main menu: ");
                String appointmentChoice = input.next();

                if (appointmentChoice.equalsIgnoreCase("1")) {
                    input.nextLine();
                    System.out.println();
                    System.out.print("Enter the new appointment date: ");
                    String appointmentDate = input.nextLine();
                    patient.setNextAppointment(appointmentDate);
                    System.out.println("\n" + patient.getFirstName() + " " + patient.getLastName()
                            + "'s next appointment is now scheduled for " + appointmentDate);
                    System.out.println();
                }
            } else if (choice.equalsIgnoreCase("V")) {
                // fill in missing lines here
            } else if (choice.equalsIgnoreCase("Q")) {
                repeat = false;

            } else {
                System.out.println("Invalid menu option. Enter A, S, V, or Q only");
            }
        }
        // fill in missing line here to close Scanner
        input.close();
        System.out.println("\nGoodbye!");
    }

    // Add other methods here
    /**
     * Reads data from the given file and populates the ArrayList of patients
     * 
     * @param patients   the ArrayList of patients
     * @param hygienists the array of hygienist options
     * @param file       a file object connected to a String file name
     * @throws IOExcetption when file cannot be found
     */
    public static void readFile(ArrayList<Patient> patients, String[] hygienists, File file) throws IOException {
        Scanner openFile = new Scanner(file);
        while (openFile.hasNextLine()) {
            // Find id
            String idLine = openFile.nextLine();
            int id = Integer.parseInt(idLine); // Change id from String to int

            // Full name (first + last)
            String fullName = openFile.nextLine().trim();

            // Separate first and last using indexOf instead of split
            int spaceIndex = fullName.indexOf(" ");
            String firstName = fullName.substring(0, spaceIndex);
            String lastName = fullName.substring(spaceIndex + 1);

            // Appointment
            String appointment = openFile.nextLine();

            // Hygienist name
            // Finding the index of the hygienist by first changing the next line from a
            // String to an integer
            int index = Integer.parseInt(openFile.nextLine());
            String hygienist = hygienists[index];

            // Add to arrayList
            patients.add(new Patient(id, firstName, lastName, hygienist, appointment));
        }
        openFile.close();
    }

    /**
     * Sorts the give ArrayList of patients in ascending order by id
     * 
     * @param patients the ArrayList of patients
     */
    public static void bubbleSortById(ArrayList<Patient> patients) {
        for (int i = 0; i < patients.size(); ++i) {
            for (int j = 0; j < patients.size() - i - 1; ++j) {
                // Compare IDs using accessors
                if (patients.get(j).getId() > patients.get(j + 1).getId()) {
                    // Swap the two Patient objects
                    Patient temp = patients.get(j);
                    patients.set(j, patients.get(j + 1));
                    patients.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Sorts the give ArrayList of patients in ascending order by last name and then
     * by first name
     * 
     * @param patients the ArrayList of patients
     */
    public static void bubbleSortByName(ArrayList<Patient> patients) {
        for (int i = 0; i < patients.size() - 1; i++) {
            for (int j = 0; j < patients.size() - i - 1; j++) {
                Patient patientA = patients.get(j);
                Patient patienB = patients.get(j + 1);

                // Compare last names
                int cmp = patientA.getLastName().compareToIgnoreCase(patienB.getLastName());
                if (cmp == 0) {
                    // Tie: compare first names
                    cmp = patientA.getFirstName().compareToIgnoreCase(patienB.getFirstName());
                }

                if (cmp > 0) {
                    // swap a and b
                    patients.set(j, patienB);
                    patients.set(j + 1, patientA);
                }
            }
        }
    }

    /**
     * Searches for a patient with a matching id within the patients ArrayList
     * 
     * @param patients the ArrayList of patients
     * @param id       the id to search for
     * @return the location in the patients ArrayList where the matching Patient
     *         with the give id is stored or -1 if not found
     */
    public static int binarySearchById(ArrayList<Patient> patients, int id) {
        int lo = 0;
        int hi = patients.size() - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int midId = patients.get(mid).getId();

            if (midId == id) {
                return mid; // found
            } else if (midId < id) {
                lo = mid + 1; // search right half
            } else {
                hi = mid - 1; // search left half
            }
        }
        return -1; // not found
    }

    /**
     * Searches for a patient with a matching first and last name within the
     * patients ArrayList
     * 
     * @param patients the ArrayList of patients
     * @param first    the patient first name to search for
     * @param last     the patient last name to search for
     * @return the location in the patients ArrayList where the matching Patient
     *         with the give id is stored or -1 if not found
     */
    public static int binarySearchByName(ArrayList<Patient> patients, String first, String last) {
        int lo = 0, hi = patients.size() - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            Patient midPatient = patients.get(mid);

            // compare by last, then first (case-insensitive)
            int compare = midPatient.getLastName().compareToIgnoreCase(last);
            if (compare == 0) {
                compare = midPatient.getFirstName().compareToIgnoreCase(first);
            }

            if (compare == 0) {
                return mid; // found exact match
            } else if (compare < 0) {
                lo = mid + 1; // target is after mid
            } else {
                hi = mid - 1; // target is before mid
            }
        }
        return -1; // not found
    }

    /**
     * Prompts for new patient information and then
     * Creates a new Patient and insert it into ArrayList
     * The patient should be assigned a first and last name
     * and the dentalChart should be initialized
     * The assignedHygienist and nextAppointments
     * for this patient are to be assigned default values of
     * "No hygienist assigned"
     * and "No appointment scheduled"
     * The id should be the next available ArrayList index + 1000
     * 
     * @param patients  the ArrayList of patients
     * @param nameKnown whether the Patient name is known
     * @param first     the patient first name, if known, an empty
     *                  String otherwise
     * @param last      the patient first name, if known, an empty
     *                  String otherwise
     * @param input     a Scanner connected to System.in
     * @return the patient that was created
     */
    public static Patient createAccount(ArrayList<Patient> patients, boolean nameKnown,
            String first, String last, Scanner input) {
        final int THOUSAND = 1000;
        if (!nameKnown) {
            System.out.print("Enter the patient first name: ");
            first = input.next();
            System.out.print("Enter the patient last name: ");
            last = input.next();
        }

        // fill in missing lines here
        int id = THOUSAND + patients.size();
        Patient patient = new Patient(id, first, last);
        patients.add(patient);
        return patient;
    }
}
