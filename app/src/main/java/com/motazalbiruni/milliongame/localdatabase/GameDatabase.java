package com.motazalbiruni.milliongame.localdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = GameEntity.class ,exportSchema = false ,version = 1)
@TypeConverters(DataConverter.class)
public abstract class GameDatabase extends RoomDatabase {
    private static GameDatabase instance;
    public static synchronized GameDatabase getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext()
                    ,GameDatabase.class,"gameQuestion")
                    .fallbackToDestructiveMigration()
                    .build();
        }//end if
        return instance;
    }//end getInstance()

    public abstract GameDAO getDAO();

}//end class GameDatabase
