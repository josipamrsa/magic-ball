package com.company;

import java.util.*;

public class User {
    //----FIELDS----//
    private String userID;
    private String userName;
    private ArrayList<String> questionHistory;
    private int karma;

    //----GETTERS/SETTERS----//
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

    public int getKarma() { return karma; }
    public void setKarma(int karma) { this.karma = karma; }

    User(String uid, String uname) {
        this.userID = uid;
        this.userName = uname;
        this.questionHistory = new ArrayList<String>();
        this.karma = 0;
    }

    void updateUserQuestionHistory(String question) {
        ArrayList<String> history = this.getQuestionHistory();
        history.add(question);
        this.setQuestionHistory(history);
    }

    void updateUserKarma(int points) {
        this.setKarma(this.getKarma() + points);
    }
}
