package com.motazalbiruni.milliongame.firebase;

import android.content.Context;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.motazalbiruni.milliongame.localdatabase.GameDatabase;
import com.motazalbiruni.milliongame.localdatabase.GameEntity;
import com.motazalbiruni.milliongame.viewmodel.Answer;
import com.motazalbiruni.milliongame.viewmodel.Level;
import com.motazalbiruni.milliongame.viewmodel.Question;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RealTimeDatabase {
    private Context context;
    private String tv;

    public RealTimeDatabase(Context context){
        this.context = context;
    }

    private String[] levels = new String[]{"level_1", "level_2", "level_3",
            "level_4", "level_5", "level_6", "level_7", "level_8", "level_9",
            "level_10", "level_11", "level_12", "level_13", "level_14", "level_15"};

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    // Write a message to the firebase
    public void writeToFirebase(int level, List<Question> questions){

        Level questionsLevel = new Level(level , questions);

        myRef.child("game_play").child(levels[level-1]).child("questions").setValue(questionsLevel);

    }//end writeToFirebase()

    // Read from the firebase
    public void readFromFirebase(){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Level myLevel = dataSnapshot.child("level_1").getValue(Level.class);
                String phrase = myLevel.getQuestions().get(0).getPhrase();
                setTv(phrase);
                GameDatabase gameDatabase = GameDatabase.getInstance(context);

                for (Question question : myLevel.getQuestions()) {
//                    gameDatabase.getDAO().insert(new GameEntity(myLevel.getNumberLevel(),question.getPhrase()
//                            ,question.getAnswer(0), question.getAnswer(1)
//                            ,question.getAnswer(2), question.getAnswer(3)))
//                            .subscribeOn(Schedulers.computation())
//                            .subscribe(new CompletableObserver() {
//                                @Override
//                                public void onSubscribe(@NonNull Disposable d) {
//
//                                }
//
//                                @Override
//                                public void onComplete() {
//
//                                }
//
//                                @Override
//                                public void onError(@NonNull Throwable e) {
//
//                                }
//                            });
                }

            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }//end readFromFirebase()

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }
}//end class
