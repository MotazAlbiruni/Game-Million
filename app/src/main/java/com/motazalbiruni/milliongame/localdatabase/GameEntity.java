package com.motazalbiruni.milliongame.localdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.motazalbiruni.milliongame.viewmodel.Answer;

@Entity(tableName = "question_game_table")
public class GameEntity {
    @PrimaryKey(autoGenerate = true)
    private int idQuest;
    @ColumnInfo(name = "level")
    private int level;
    @ColumnInfo(name = "question")
    private String question;
    @ColumnInfo(name = "answer_a")
    private Answer answer_a;
    @ColumnInfo(name = "answer_b")
    private Answer answer_b;
    @ColumnInfo(name = "answer_c")
    private Answer answer_c;
    @ColumnInfo(name = "answer_d")
    private Answer answer_d;

    //constructor
    public GameEntity(int level,String question, Answer answer_a, Answer answer_b, Answer answer_c, Answer answer_d) {
        this.level = level;
        this.question = question;
        this.answer_a = answer_a;
        this.answer_b = answer_b;
        this.answer_c = answer_c;
        this.answer_d = answer_d;
    }

    public GameEntity() {

    }

    public int getIdQuest() {
        return idQuest;
    }

    public void setIdQuest(int id) {
        this.idQuest = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer_a() {
        return answer_a;
    }

    public void setAnswer_a(Answer answer_a) {
        this.answer_a = answer_a;
    }

    public Answer getAnswer_b() {
        return answer_b;
    }

    public void setAnswer_b(Answer answer_b) {
        this.answer_b = answer_b;
    }

    public Answer getAnswer_c() {
        return answer_c;
    }

    public void setAnswer_c(Answer answer_c) {
        this.answer_c = answer_c;
    }

    public Answer getAnswer_d() {
        return answer_d;
    }

    public void setAnswer_d(Answer answer_d) {
        this.answer_d = answer_d;
    }
}//end class
