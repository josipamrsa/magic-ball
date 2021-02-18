package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MagicBall {

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

    public static void main(String[] args) {
        HashMap<Integer, String[]> possiblePredictions = generatePossibleAnswers();
        Scanner scanner = new Scanner(System.in);
        String userQuestion = "";

        User user = new User("A01", "Josipa");

        System.out.println("Hello " + user.getUserName() + "!");
        System.out.println();

        while (!userQuestion.equals("Q") && !userQuestion.equals("q")) {
            System.out.println("Please enter a YES/NO question (press Q to exit): ");
            userQuestion = scanner.nextLine();
            Prediction prediction = new Prediction(possiblePredictions, userQuestion);

            if (userQuestion.equals("Q") || userQuestion.equals("q")) {
                System.out.println("Magic ball says: Thank you for playing!");
                break;
            }

            else {
                System.out.println("Your question is: " + userQuestion);
                System.out.println("The magic ball says: " + prediction.getAnswer());
            }
        }
    }
}
