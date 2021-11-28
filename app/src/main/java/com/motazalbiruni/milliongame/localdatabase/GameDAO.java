package com.motazalbiruni.milliongame.localdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface GameDAO {
    @Insert
    Completable insert(GameEntity entity);

    @Query("select * from question_game_table")
    Single<List<GameEntity>> getAllQuestions();

    @Query("select * from question_game_table where level = :level")
    Single<List<GameEntity>> getLevelQuestions(int level);

    @Query("select * from question_game_table where level = :level")
    Observable<List<GameEntity>> getLevelList(int level);

    @Update
    Completable update(GameEntity entity);

    @Query("delete from question_game_table where idQuest= :id")
    Completable deleteById(int id);

}//end DAO