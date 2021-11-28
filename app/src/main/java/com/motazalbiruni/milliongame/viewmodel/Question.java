package com.motazalbiruni.milliongame.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String phrase;// write phrase of question
    private List<Answer> answers = new ArrayList<>();//write list of answer

    public Question() {
    }

    public Question(String phrase, Answer[] answers) {
        this.phrase = phrase;
        this.answers.add(answers[0]);
        this.answers.add(answers[1]);
        this.answers.add(answers[2]);
        this.answers.add(answers[3]);
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Answer getAnswer(int index) {
        return answers.get(index);
    }

}//end class
