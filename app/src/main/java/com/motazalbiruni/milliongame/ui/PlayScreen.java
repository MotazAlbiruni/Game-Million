package com.motazalbiruni.milliongame.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.motazalbiruni.milliongame.R;
import com.motazalbiruni.milliongame.localdatabase.GameDatabase;
import com.motazalbiruni.milliongame.localdatabase.GameEntity;
import com.motazalbiruni.milliongame.playroom.UserTools;
import com.motazalbiruni.milliongame.viewmodel.Answer;
import com.motazalbiruni.milliongame.viewmodel.Question;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PlayScreen extends AppCompatActivity {

    TextView txtQuestPlay, txtAnswerA, txtAnswerB, txtAnswerC, txtAnswerD,
            txt_level1, txt_level2, txt_level3, txt_level4, txt_level5, txt_level6,
            txt_level7, txt_level8, txt_level9, txt_level10, txt_level11, txt_level12,
            txt_level13, txt_level14, txt_level15, txt_result, txt_timer;
    Button btn_next_level;
    GameDatabase gameDatabase;
    UserTools tools;
    Observable<Long> observable;
    //Declare timer
    CountDownTimer cTimer = null;
    CountDownTimer cTimerB = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);

        txtQuestPlay = findViewById(R.id.txt_quest_play);
        txtAnswerA = findViewById(R.id.txt_ans_a);
        txtAnswerB = findViewById(R.id.txt_ans_b);
        txtAnswerC = findViewById(R.id.txt_ans_c);
        txtAnswerD = findViewById(R.id.txt_ans_d);
        txt_result = findViewById(R.id.txt_result);
        txt_timer = findViewById(R.id.txt_timer_display);

        txt_level1 = findViewById(R.id.txtLevel_1);
        txt_level2 = findViewById(R.id.txtLevel_2);
        txt_level3 = findViewById(R.id.txtLevel_3);
        txt_level4 = findViewById(R.id.txtLevel_4);
        txt_level5 = findViewById(R.id.txtLevel_5);
        txt_level6 = findViewById(R.id.txtLevel_6);
        txt_level7 = findViewById(R.id.txtLevel_7);
        txt_level8 = findViewById(R.id.txtLevel_8);
        txt_level9 = findViewById(R.id.txtLevel_9);
        txt_level10 = findViewById(R.id.txtLevel_10);
        txt_level11 = findViewById(R.id.txtLevel_11);
        txt_level12 = findViewById(R.id.txtLevel_12);
        txt_level13 = findViewById(R.id.txtLevel_13);
        txt_level14 = findViewById(R.id.txtLevel_14);
        txt_level15 = findViewById(R.id.txtLevel_15);




        btn_next_level = findViewById(R.id.btn_next_level);
        tools = new UserTools();
        gameDatabase = GameDatabase.getInstance(this);
        initialStartValue();
        for (int l = 1; l <= 15; l++) {
            getLevelQuestFormRoom(l);
        }//end for

        observable = Observable.interval(1, TimeUnit.SECONDS);

        txtAnswerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UserTools.isBtnClicked()) {
                    txtAnswerA.setBackground(getResources().getDrawable(R.drawable.answer_check_background));
                    cancelTimer();
                    observable.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<Long>() {
                                @Override
                                public void onSubscribe(@NonNull Disposable d) {

                                }

                                @Override
                                public void onNext(@NonNull Long aLong) {
                                    if (aLong == 3) {
                                        checkAnswer(0);
                                    }
                                }

                                @Override
                                public void onError(@NonNull Throwable e) {

                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                }
            }
        });
        txtAnswerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UserTools.isBtnClicked()) {
                    txtAnswerB.setBackground(getResources().getDrawable(R.drawable.answer_check_background));
                    cancelTimer();
                    observable.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<Long>() {
                                @Override
                                public void onSubscribe(@NonNull Disposable d) {

                                }

                                @Override
                                public void onNext(@NonNull Long aLong) {
                                    if (aLong == 3) {
                                        checkAnswer(1);
                                    }
                                }

                                @Override
                                public void onError(@NonNull Throwable e) {

                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                }
            }
        });
        txtAnswerC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UserTools.isBtnClicked()) {
                    txtAnswerC.setBackground(getResources().getDrawable(R.drawable.answer_check_background));
                    cancelTimer();
                    observable.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<Long>() {
                                @Override
                                public void onSubscribe(@NonNull Disposable d) {

                                }

                                @Override
                                public void onNext(@NonNull Long aLong) {
                                    if (aLong == 3) {
                                        checkAnswer(2);
                                    }
                                }

                                @Override
                                public void onError(@NonNull Throwable e) {

                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                }
            }
        });
        txtAnswerD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UserTools.isBtnClicked()) {
                    txtAnswerD.setBackground(getResources().getDrawable(R.drawable.answer_check_background));
                    cancelTimer();
                    observable.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<Long>() {
                                @Override
                                public void onSubscribe(@NonNull Disposable d) {

                                }

                                @Override
                                public void onNext(@NonNull Long aLong) {
                                    if (aLong == 3) {
                                        checkAnswer(3);
                                    }
                                }

                                @Override
                                public void onError(@NonNull Throwable e) {

                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                }
            }
        });

        btn_next_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameEntity gameEntity = tools.getQuestFromLevel(UserTools.getAnswerCount());
                Answer[] answers = {gameEntity.getAnswer_a(), gameEntity.getAnswer_b()
                        , gameEntity.getAnswer_c(), gameEntity.getAnswer_d()};
                playQuest(new Question(gameEntity.getQuestion(), answers));
                btn_next_level.setVisibility(View.INVISIBLE);
                startTimer(60);
            }
        });
        
    }//end onCreate()

    private void playQuest(Question question) {
        if (question != null) {
            txtQuestPlay.setText(question.getPhrase());
            List<Answer> list = new ArrayList<>();
            list.add(question.getAnswers().get(0));
            list.add(question.getAnswers().get(1));
            list.add(question.getAnswers().get(2));
            list.add(question.getAnswers().get(3));
            Collections.shuffle(list);
            txtAnswerA.setBackgroundResource(R.drawable.answer_background);
            txtAnswerB.setBackgroundResource(R.drawable.answer_background);
            txtAnswerC.setBackgroundResource(R.drawable.answer_background);
            txtAnswerD.setBackgroundResource(R.drawable.answer_background);
            txtAnswerA.setText(list.get(0).getAnswer());
            txtAnswerB.setText(list.get(1).getAnswer());
            txtAnswerC.setText(list.get(2).getAnswer());
            txtAnswerD.setText(list.get(3).getAnswer());
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).isCorrect()) {
                    UserTools.setAnswerCorrect(i);//set the index of correct answer
                }//end if
            }//end for
        }
        UserTools.setIsBtnClicked(true);
    }//end playQuest()

    @SuppressLint("UseCompatLoadingForDrawables")
    private void checkAnswer(int i) {
        UserTools.setIsBtnClicked(false);
        if (i != UserTools.getAnswerCorrect()) {

            TextView[] textViewsInCorrect = new TextView[]{txtAnswerA, txtAnswerB, txtAnswerC, txtAnswerD};
            textViewsInCorrect[i].setBackground(getResources().getDrawable(R.drawable.answer_incorrect_background));

            TextView[] textViewsCorrect = new TextView[]{txtAnswerA, txtAnswerB, txtAnswerC, txtAnswerD};
            textViewsCorrect[UserTools.getAnswerCorrect()].setBackground(getResources().getDrawable(R.drawable.answer_correct_background));

            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Long>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull Long aLong) {
                            if (aLong == 3) {
                                endPlayGame();
                            }
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });

        }//end if

        if (i == UserTools.getAnswerCorrect()) {
            UserTools.setAnswerCount(true);
            TextView[] textViewsAnswers = new TextView[]{txtAnswerA, txtAnswerB, txtAnswerC, txtAnswerD};
            textViewsAnswers[i].setBackground(getResources().getDrawable(R.drawable.answer_correct_background));
            int count = UserTools.getAnswerCount();
            upLevel(count);
            if (count == 14) {
                UserTools.setIsGameOver(true);
                startTimer(10);
                endPlayGame();
            } else {
                btn_next_level.setVisibility(View.VISIBLE);
                btn_next_level.setText("السؤال القادم");
            }//end if

        }//end if
    }//end checkAnswer()

    //move level at list of money
    @SuppressLint("UseCompatLoadingForDrawables")
    private void upLevel(int i) {
        TextView[] textViewsAnswers = new TextView[]{txt_level1, txt_level2, txt_level3, txt_level4, txt_level5,
                txt_level6, txt_level7, txt_level8, txt_level9, txt_level10, txt_level11, txt_level12,
                txt_level13, txt_level14, txt_level15};
        for (int y = 0; y < i; y++) {
            if (y == 1 | y == 4 | y == 8 | y == 11 | y == 14) {
                int[] index = new int[]{1, 4, 8, 11, 14};
                for (int x : index) {
                    textViewsAnswers[x].setBackgroundResource(R.drawable.money_list_default_background);
                    textViewsAnswers[x].setTextColor(getResources().getColor(R.color.orange));
                }//end for
            } else {
                textViewsAnswers[y].setBackgroundResource(R.drawable.money_list_default_background);
                textViewsAnswers[y].setTextColor(getResources().getColor(R.color.white));
            }
        }//end for
        textViewsAnswers[i].setBackgroundResource(R.drawable.money_list_background);
        textViewsAnswers[i].setTextColor(getResources().getColor(R.color.white));
    }//end upLevel()

    //get level questions from database
    private void getLevelQuestFormRoom(int level) {
        gameDatabase.getDAO().getLevelList(level)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<GameEntity>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<GameEntity> gameEntities) {
                        if (!gameEntities.isEmpty())
                            tools.setQuestLevel(level - 1, gameEntities);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }//end getLevelQuest()

    //initial the values
    private void initialStartValue() {
        UserTools.setAnswerCount(false);
        UserTools.setIsGameOver(false);
        UserTools.setIsBtnClicked(true);
        UserTools.setIsBtnNext(false);
        upLevel(0);
        btn_next_level.setVisibility(View.VISIBLE);
        txtQuestPlay.setVisibility(View.VISIBLE);
        txtAnswerA.setVisibility(View.VISIBLE);
        txtAnswerB.setVisibility(View.VISIBLE);
        txtAnswerC.setVisibility(View.VISIBLE);
        txtAnswerD.setVisibility(View.VISIBLE);
        txt_timer.setVisibility(View.VISIBLE);
    }//end initialStartValue()

    @SuppressLint("SetTextI18n")
    private void endPlayGame() {
        int count = UserTools.getAnswerCount();
        btn_next_level.setVisibility(View.INVISIBLE);
        txtQuestPlay.setVisibility(View.INVISIBLE);
        txtAnswerA.setVisibility(View.INVISIBLE);
        txtAnswerB.setVisibility(View.INVISIBLE);
        txtAnswerC.setVisibility(View.INVISIBLE);
        txtAnswerD.setVisibility(View.INVISIBLE);
        txt_timer.setVisibility(View.INVISIBLE);
        txt_result.setVisibility(View.VISIBLE);
        int money = 0;
        if (UserTools.isIsGameOver()) {
            money = 1000000;
        } else {
            if (count > 1 & count <= 4) {
                money = 1000;
            } else if (count > 4 & count <= 8) {
                money = 5000;
            } else if (count > 8 & count <= 11) {
                money = 15000;
            } else if (count > 11 & count <= 14) {
                money = 100000;
            }
        }//end if game over
        txt_result.setText("انتهت العبة وقد حصلت على عدد نقاط : " + money);

    }//end endPlayGame()

    //start timer function
    private void startTimer(int mf){
        if (mf>20){
            cTimer = new CountDownTimer(mf*1000, 1000) {
                public void onTick(long millisUntilFinished) {

                    txt_timer.setText(millisUntilFinished/1000+ "");
                }
                public void onFinish() {
                    endPlayGame();
                }
            };
            cTimer.start();
        }else {
            cTimerB = new CountDownTimer(mf*1000, 1000) {
                public void onTick(long millisUntilFinished) {
                }
                public void onFinish() {
                }
            };
            cTimerB.start();
        }

    }//end startTimer()


    //cancel timer
    private void cancelTimer() {

        if (cTimer != null)
            cTimer.cancel();

        if (cTimerB != null)
            cTimerB.cancel();

    }//end cancelTimer()

}//end class