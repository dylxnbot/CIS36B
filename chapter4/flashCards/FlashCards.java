package flashCards;

/**
 * @author Dylan Lam
 * CIS 36B
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class FlashCards {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String english, spanish, choice = "";
        boolean execute = true;
        int i, correct = 0;

        // Add every line from words.txt into ArrayList
        ArrayList<Card> cards = new ArrayList<Card>();
        File wordsFile = new File("words.txt");
        Scanner inputFile = new Scanner(wordsFile);
        while (inputFile.hasNextLine()) {
            english = inputFile.nextLine();
            spanish = inputFile.nextLine();

            Card newCard = new Card();
            newCard.english = english;
            newCard.spanish = spanish;
            cards.add(newCard);
        }
        /**
         * TestTestTestTestTestTestTestTestTestTestTestTest
         */
        // System.out.println(cards.size());

        System.out.println("***Spanish Flash Cards!***");
        while (execute) {
            System.out.println("\nPlease select from the menu options below:");

            System.out.println("\n1. Practice English to Spanish");
            System.out.println("2. Practice Spanish to English");
            System.out.println("3. Add a Word");
            System.out.println("4. Remove a Word");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");
            choice = input.nextLine();

            if (choice.equals("1")) { // Practice English to Spanish
                englishSort(cards); // First sort the array by the english words

                // Print out the sorted array and ask the user for their translation
                for (i = 0; i < cards.size(); ++i) {
                    System.out.println("\n" + i + ". " + cards.get(i).english);
                    System.out.print("Enter the translation = ");
                    choice = input.nextLine();
                    if (choice.equals(cards.get(i).spanish)) {
                        System.out.println("Correct!");
                        ++correct;
                    } else {
                        System.out.println("The correct translation is " + cards.get(i).spanish);
                    }
                }
                System.out.println("Total correct: " + correct + "/20");

            } else if (choice.equals("2")) { // Practice Spanish to English
                spanishSort(cards); // First sort the array by the spanish words

                // Print out the sorted array and ask the user for their translation
                for (i = 0; i < cards.size(); ++i) {
                    System.out.println("\n" + i + ". " + cards.get(i).spanish);
                    System.out.print("Enter the translation = ");
                    choice = input.nextLine();
                    if (choice.equals(cards.get(i).english)) {
                        System.out.println("Correct!");
                        ++correct;
                    } else {
                        System.out.println("The correct translation is " + cards.get(i).english);
                    }
                }
                System.out.println("Total correct: " + correct + "/20");

            } else if (choice.equals("3")) { // Add a word
                System.out.println("\nBelow is the alphabetical list of cards:\n");
                englishSort(cards); // Sort the cards alphabetically by the english word

                // Print the list of cards
                for(i = 0; i < cards.size(); ++i) {
                    System.out.print(i + ". ");
                    cards.get(i).printCard();
                }

                // Adding a new card
                System.out.print("\nEnter the word to add in English: ");
                english = input.nextLine();
                System.out.print("Enter " + english + "'s Spanish translation: ");
                spanish = input.nextLine();

                Card newCard = new Card();
                newCard.english = english;
                newCard.spanish = spanish;
                cards.add(newCard);

            } else if (choice.equals("4")) { // Remove a word
                System.out.println("\nBelow is the alphabetical list of cards:\n");
                englishSort(cards); // Sort the cards alphabetically by the english word

                // Print the list of cards
                for(i = 0; i < cards.size(); ++i) {
                    System.out.print(i + ". ");
                    cards.get(i).printCard();
                }

                // Choose the card to remove
                System.out.print("\nEnter the number of the word to remove: ");
                int remove = input.nextInt();
                input.nextLine();
                if (remove > cards.size() || remove < 0) {
                    System.out.println("Invalid choice. Please try again!");
                } else {
                    System.out.print("Removing: ");
                    cards.get(remove).printCard();
                    cards.remove(remove);
                }



            } else if (choice.equals("5")) { // Exit program
                System.out.println("\nGoodbye!");
                execute = false;
            } else { // Invalid input
                System.out.println("\nInvalid choice. Please try again!");
            }
        }
    }

    /**
     * Method name: englishSort
     * Uses the bubble sort algorithm to sort and return the deck in alphabetical order by the English words
     * 
     * @param cards the ArrayList of cards
     */
    public static void englishSort(ArrayList<Card> cards) {
        int i, j;

        for (i = 0; i < cards.size() - 1; ++i) {
            for (j = 0; j < cards.size() - i - 1; ++j) {
                Card cardA = cards.get(j);
                Card cardB = cards.get(j + 1);
                String stringA = cards.get(j).english;
                String stringB = cards.get(j + 1).english;

                if (stringA.compareToIgnoreCase(stringB) > 0) {
                    cards.set(j, cardB);
                    cards.set(j + 1, cardA);
                }
            }
        }
    }

    /**
     * Method name: spanishSort
     * Uses the bubble sort algorithm to sort and return the deck in alphabetical order by the Spanish words
     * 
     * @param cards the ArrayList of cards
     */
    public static void spanishSort(ArrayList<Card> cards) {
        int i, j;

        for (i = 0; i < cards.size() - 1; ++i) {
            for (j = 0; j < cards.size() - i - 1; ++j) {
                Card cardA = cards.get(j);
                Card cardB = cards.get(j + 1);
                String stringA = cards.get(j).spanish;
                String stringB = cards.get(j + 1).spanish;

                if (stringA.compareToIgnoreCase(stringB) > 0) {
                    cards.set(j, cardB);
                    cards.set(j + 1, cardA);
                }
            }
        }
    }
}
