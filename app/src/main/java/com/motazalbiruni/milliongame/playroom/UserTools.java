package com.motazalbiruni.milliongame.playroom;

import com.motazalbiruni.milliongame.localdatabase.GameEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTools {
    private static boolean isGameOver;
    private static int answerCorrect;
    private static int answerCount;
    private static boolean isBtnClicked;
    private static boolean isBtnNext;
    private Map<String,List<GameEntity>> levels = new HashMap<>();
    private final List<List<GameEntity>> gameQuestLevel = new ArrayList<>();


    public GameEntity getQuestFromLevel(int index) {
//        List<GameEntity> listLevel = this.gameQuestLevel.get(index);
        List<GameEntity> listLevel = levels.get(index+"");
        Collections.shuffle(listLevel);
        return listLevel.get(0);
    }//list

    public void setQuestLevel(int index ,List<GameEntity> listGameEntities) {
//        arrayLevels[index] = listGameEntities;
        this.levels.put(index+"",listGameEntities);
//        this.gameQuestLevel.add(listGameEntities);
    }//list

    public void reverseLevelsList() {
        Collections.reverse(this.gameQuestLevel);
    }//list

    public static boolean isBtnNext() {
        return isBtnNext;
    }//btn next

    public static void setIsBtnNext(boolean isBtnNext) {
        UserTools.isBtnNext = isBtnNext;
    }//btn next

    public static boolean isBtnClicked() {
        return isBtnClicked;
    }//btn clicked

    public static void setIsBtnClicked(boolean isBtnClicked) {
        UserTools.isBtnClicked = isBtnClicked;
    }//btn clicked

    public static boolean isIsGameOver() {
        return isGameOver;
    }//game over

    public static void setIsGameOver(boolean isGameOver) {
        UserTools.isGameOver = isGameOver;
    }//game over

    public static int getAnswerCorrect() {
        return answerCorrect;
    }//answerCorrect

    public static void setAnswerCorrect(int answerCorrect) {
        UserTools.answerCorrect = answerCorrect;
    }//answerCorrect

    public static int getAnswerCount() {
        return answerCount;
    }//answerCount

    public static void setAnswerCount(boolean count) {
        if (count) {
            UserTools.answerCount = answerCount + 1;
        } else {
            UserTools.answerCount = 0;
        }

    }//answerCount

}//end class
