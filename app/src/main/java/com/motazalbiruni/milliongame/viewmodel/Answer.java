package com.motazalbiruni.milliongame.viewmodel;

public class Answer {
    private String answer;// write answer of question
    private boolean isCorrect;// true =correct answer $ false = not correct answer

    public Answer() {
    }

    public Answer(String answer, boolean isCorrect) {
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public Answer(String answer) {
        this.answer = answer;
        this.isCorrect = false;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}//end class
