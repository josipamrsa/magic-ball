package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Prediction {
    //----FIELDS----//
    private String question;
    private String answer;
    private int answerIntent;
    private Map<Integer, String[]> listOfPredictions;

    //----GETTERS/SETTERS----//
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getAnswerIntent() {
        return answerIntent;
    }

    public void setAnswerIntent(int answerIntent) {
        this.answerIntent = answerIntent;
    }

    public Map<Integer, String[]> getListOfPredictions() {
        return listOfPredictions;
    }

    public void setListOfPredictions(Map<Integer, String[]> listOfPredictions) {
        this.listOfPredictions = listOfPredictions;
    }

    Prediction(HashMap<Integer, String[]> predictions, String question) {
        this.listOfPredictions = predictions;
        this.question = question;
        this.answer = getRandomAnswer(predictions);
    }

    // Gets a random string from a provided HashMap
    // and returns it as Magic Ball answer
    String getRandomAnswer(HashMap<Integer, String[]> predictions) {
        Random outcomeIndex = new Random(); // Random index of possible outcomes
        Random answerIndex = new Random();  // Random answer from list connected to chosen outcome

        int randomOutcome = outcomeIndex
                .ints(-1, 2)  // Get a range of random ints between a range (inclusive min, exclusive max)
                .findFirst()                                    // Only pick the first one
                .getAsInt();                                    // Convert chosen int from IntStream to int primitive

        // Set intent for User outcome calculation (positive, negative, indifferent)
        setAnswerIntent(randomOutcome);
        // Get the list of answers connected to chosen outcome and the length
        String[] answerList = predictions.get(randomOutcome);
        int listLength = answerList.length;

        // Pick a random string from the list and return it as the random answer
        String randomAnswer = answerList[answerIndex.nextInt(listLength)];
        return randomAnswer;
    }
}
