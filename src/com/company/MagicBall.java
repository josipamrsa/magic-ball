package com.company;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class MagicBall {

    //----HELPER FUNCTIONS----//

    // Creates a HashMap of possible outcomes and the list of possible answers
    public static HashMap<Integer, String[]> generatePossibleAnswers() {
        HashMap<Integer, String[]> possiblePredictions = new HashMap<Integer, String[]>();

        // Positive outcomes
        String[] positives = {"As I see it, yes.", "You may rely on it.", "Outlook good."};
        possiblePredictions.put(1, positives);

        // Negative outcomes
        String[] negatives = {"Don't count on it.", "My reply is no.", "Very doubtful."};
        possiblePredictions.put(-1, negatives);

        // Indifferent outcomes
        String[] indifferent = {"Reply hazy, try again.", "Ask again later.", "Cannot predict now."};
        possiblePredictions.put(0, indifferent);

        return possiblePredictions;
    }

    // Just prints all possible user options
    public static void userShowOptions() {
        System.out.println("=================================");
        System.out.println("Your options: ");
        System.out.println("=================================");
        System.out.println("A. Ask a YES/NO question");
        System.out.println("H. View your question history");
        System.out.println("Q. Quit app");
        System.out.println("=================================");
        System.out.println();
    }

    // Prints results when user asks a question
    public static void printResults(String q, String a, int k) {
        System.out.println("Your question is: " + q);
        System.out.println("The magic ball says: " + a);
        System.out.println("You currently have " + k + " karma!");
        System.out.println();
    }

    //----OPTIONS----//

    public static void askAQuestion(User user, HashMap<Integer, String[]> possiblePredictions) {
        System.out.println("Please ask a YES/NO question: ");

        // Scan what the user said
        Scanner scanner = new Scanner(System.in);
        String userQuestion = scanner.nextLine();

        // Make a new prediction
        Prediction prediction = new Prediction(possiblePredictions, userQuestion);

        System.out.println();

        // Update user stats and print results
        user.updateUserQuestionHistory(userQuestion);
        user.updateUserKarma(prediction.getAnswerIntent());
        printResults(userQuestion, prediction.getAnswer(), user.getKarma());
    }

    public static void showUserHistory(ArrayList history) {
        // Create a new Iterator over ArrayList<String> of type String
        Iterator<String> it = history.iterator();
        System.out.println("History of user questions: ");

        // If there are no questions asked yet
        if (!it.hasNext()) {
            System.out.println("No questions asked yet!");
        }

        // If there is at least one asked question, write them out
        else {
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }

        System.out.println();
    }

    //----MAIN----//
    public static void main(String[] args) {
        HashMap<Integer, String[]> possiblePredictions = generatePossibleAnswers();

        Scanner scanner = new Scanner(System.in);
        Character userOption = '\0';

        User user = new User("A01", "Josipa");

        System.out.println("Hello " + user.getUserName() + "!");
        System.out.println();
        userShowOptions();

        do {
            System.out.println("A - ask, H - history, Q - quit");
            System.out.print("Please pick an option: ");
            System.out.println();

            userOption = Character.toUpperCase(scanner.next().charAt(0));

            switch (userOption) {
                case 'A':
                    askAQuestion(user, possiblePredictions);
                    break;
                case 'H':
                    showUserHistory(user.getQuestionHistory());
                    break;
                case 'Q':
                    System.out.println("Magic ball says: Thank you for playing!");
                    break;
                default:
                    System.out.println("Magic ball says: I do not understand. Please pick a correct option!");
                    break;
            }
        } while (userOption != 'Q');
    }
}
