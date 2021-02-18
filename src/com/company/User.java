package com.company;

import java.util.*;

public class User {
    //----FIELDS----//
    private String userID;
    private String userName;
    private ArrayList<String> questionHistory;

    private int positiveOutcomes;
    private int negativeOutcomes;
    private int indifferentOutcomes;

    //----GETTERS/SETTERS----//

    //----User info----//
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<String> getQuestionHistory() {
        return questionHistory;
    }

    public void setQuestionHistory(ArrayList<String> questionHistory) {
        this.questionHistory = questionHistory;
    }

    //----Outcomes----//
    public int getPositiveOutcomes() {
        return positiveOutcomes;
    }

    public void setPositiveOutcomes(int positiveOutcomes) {
        this.positiveOutcomes = positiveOutcomes;
    }

    public int getNegativeOutcomes() {
        return negativeOutcomes;
    }

    public void setNegativeOutcomes(int negativeOutcomes) {
        this.negativeOutcomes = negativeOutcomes;
    }

    public int getIndifferentOutcomes() {
        return indifferentOutcomes;
    }

    public void setIndifferentOutcomes(int indifferentOutcomes) {
        this.indifferentOutcomes = indifferentOutcomes;
    }

    User(String uid, String uname) {
        this.userID = uid;
        this.userName = uname;
        this.questionHistory = new ArrayList<String>();

        this.positiveOutcomes = 0;
        this.negativeOutcomes = 0;
        this.indifferentOutcomes = 0;
    }
}
