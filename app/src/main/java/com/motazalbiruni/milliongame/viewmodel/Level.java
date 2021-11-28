package com.motazalbiruni.milliongame.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int numberLevel;
    private List<Question> questions = new ArrayList<>();

    public Level() {
    }

    public Level(int numberLevel, List<Question> questions) {
        this.numberLevel = numberLevel;
        this.questions = questions;
    }

    public int getNumberLevel() {
        return numberLevel;
    }

    public void setNumberLevel(int numberLevel) {
        this.numberLevel = numberLevel;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}//end class
