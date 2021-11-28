package com.motazalbiruni.milliongame.localdatabase;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.motazalbiruni.milliongame.viewmodel.Answer;
import com.motazalbiruni.milliongame.viewmodel.Level;
import com.motazalbiruni.milliongame.viewmodel.Question;

public class DataConverter {

    @TypeConverter
    public static String fromAnswer(Answer answer){
        return new Gson().toJson(answer);
    }

    @TypeConverter
    public static Answer getAnswerFormJson(String data){
        return new Gson().fromJson(data ,Answer.class);
    }

    @TypeConverter
    public static String fromQuestion(Question question){
        return new Gson().toJson(question);
    }

    @TypeConverter
    public static Question getQuestionFromJson(String data){
        return new Gson().fromJson(data,Question.class);
    }

    @TypeConverter
    public static String fromLevel(Level level){
        return new Gson().toJson(level);
    }

    @TypeConverter
    public static Level getLevelFromJson(String data){
        return new Gson().fromJson(data,Level.class);
    }

}//end class DataConverter
