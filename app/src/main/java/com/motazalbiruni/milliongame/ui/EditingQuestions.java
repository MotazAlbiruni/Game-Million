package com.motazalbiruni.milliongame.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.motazalbiruni.milliongame.R;
import com.motazalbiruni.milliongame.firebase.RealTimeDatabase;
import com.motazalbiruni.milliongame.localdatabase.GameDatabase;
import com.motazalbiruni.milliongame.localdatabase.GameEntity;
import com.motazalbiruni.milliongame.viewmodel.Answer;
import com.motazalbiruni.milliongame.viewmodel.Question;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@SuppressLint("UseSwitchCompatOrMaterialCode")
public class EditingQuestions extends AppCompatActivity {

    EditText etQuest, etAns1, etAns2, etAns3, etAns4;
    Switch aSwitch1, aSwitch2, aSwitch3, aSwitch4;
    TextView txtAllNum;
    Spinner sp_level;
    int count = 0;

    private List<GameEntity> gameQuestList = new ArrayList<>();

    public List<GameEntity> getGameQuestList() {
        return gameQuestList;
    }

    public void setGameQuestList(List<GameEntity> gameEntities) {
        this.gameQuestList = gameEntities;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing_questions);

        txtAllNum = findViewById(R.id.txt_allNum);
        TextView txtCurrentNum = findViewById(R.id.txt_currentNum);

        sp_level = findViewById(R.id.sp_level);
        etQuest = findViewById(R.id.et_quest);
        etAns1 = findViewById(R.id.et_ans1);
        etAns2 = findViewById(R.id.et_ans2);
        etAns3 = findViewById(R.id.et_ans3);
        etAns4 = findViewById(R.id.et_ans4);

        Button btnGet = findViewById(R.id.btn_get);
        Button btnUpload = findViewById(R.id.btn_upload);
        Button btnPrevious = findViewById(R.id.btn_previous);
        Button btnNext = findViewById(R.id.btn_next);
        Button btnUpdate = findViewById(R.id.btn_update);
        Button btnInsert = findViewById(R.id.btn_insert);
        Button btnDelete = findViewById(R.id.btn_delete);
        Button btnEdit = findViewById(R.id.btn_edit);


        aSwitch1 = findViewById(R.id.switch1);
        aSwitch2 = findViewById(R.id.switch2);
        aSwitch3 = findViewById(R.id.switch3);
        aSwitch4 = findViewById(R.id.switch4);

        sp_level.setSelection(0);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id_level = sp_level.getSelectedItemPosition() + 1;
                GameDatabase.getInstance(getApplicationContext()).getDAO().getLevelQuestions(id_level)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<List<GameEntity>>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onSuccess(@NonNull List<GameEntity> gameEntities) {
                                getGameQuestList().clear();
                                txtAllNum.setText("" + gameEntities.size());
                                txtCurrentNum.setText("0");
                                clearScreenQuest();
                                if (!gameEntities.isEmpty()) {
                                    setGameQuestList(gameEntities);
                                    setScreenQuest(gameEntities.get(0));
                                    txtCurrentNum.setText("1");
                                    count = 0;
                                    txtAllNum.setText("" + gameEntities.size());
                                }
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }
                        });
            }

        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!getScreenQuest().equals(null)) {
                    GameDatabase.getInstance(getApplicationContext()).getDAO().insert(getScreenQuest())
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new CompletableObserver() {
                                @Override
                                public void onSubscribe(@NonNull Disposable d) {

                                }

                                @Override
                                public void onComplete() {
                                    Toast.makeText(EditingQuestions.this, "insert good", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onError(@NonNull Throwable e) {

                                }
                            });
                }
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id_level = sp_level.getSelectedItemPosition() + 1;
                GameDatabase.getInstance(getApplicationContext()).getDAO().getLevelQuestions(id_level)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<List<GameEntity>>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onSuccess(@NonNull List<GameEntity> gameEntities) {
                                List<Question> questions = new ArrayList<>();
                                for (GameEntity entity :
                                        gameEntities) {
                                    Answer[] answers = new Answer[4];
                                    answers[0] = entity.getAnswer_a();
                                    answers[1] = entity.getAnswer_b();
                                    answers[2] = entity.getAnswer_c();
                                    answers[3] = entity.getAnswer_d();
                                    questions.add(new Question(entity.getQuestion(), answers));
                                }
                                new RealTimeDatabase(getApplicationContext()).writeToFirebase(id_level, questions);
                            }


                            @Override
                            public void onError(@NonNull Throwable e) {

                            }
                        });
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size = getGameQuestList().size();
                if (count < size - 1) {
                    count++;
                    setScreenQuest(getGameQuestList().get(count));
                    txtCurrentNum.setText(count + 1 + "");
                }
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size = getGameQuestList().size();
                if (count > 0) {
                    count--;
                    setScreenQuest(getGameQuestList().get(count));
                    txtCurrentNum.setText(count + 1 + "");
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameDatabase.getInstance(getApplicationContext()).getDAO()
                        .deleteById(getGameQuestList().get(count).getIdQuest())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onComplete() {
                                if (count == 0) {
                                    getGameQuestList().remove(0);
                                    setScreenQuest(getGameQuestList().get(0));
                                    if (getGameQuestList().size() == 0) {
                                        txtCurrentNum.setText(count + "");
                                    } else {
                                        txtCurrentNum.setText(count + 1 + "");
                                    }

                                } else {
                                    getGameQuestList().remove(count);
                                    setScreenQuest(getGameQuestList().get(count - 1));
                                    txtCurrentNum.setText(count + "");
                                    count--;
                                }

                                txtAllNum.setText("" + getGameQuestList().size());
                                Toast.makeText(EditingQuestions.this, "Delete", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }
                        });
            }
        });

    }//end onCreate()

    private void setScreenQuest(GameEntity quest) {
        sp_level.setSelection(quest.getLevel() - 1);
        etQuest.setText(quest.getQuestion());
        etAns1.setText(quest.getAnswer_a().getAnswer());
        etAns2.setText(quest.getAnswer_b().getAnswer());
        etAns3.setText(quest.getAnswer_c().getAnswer());
        etAns4.setText(quest.getAnswer_d().getAnswer());
        aSwitch1.setChecked(quest.getAnswer_a().isCorrect());
        aSwitch2.setChecked(quest.getAnswer_b().isCorrect());
        aSwitch3.setChecked(quest.getAnswer_c().isCorrect());
        aSwitch4.setChecked(quest.getAnswer_d().isCorrect());

        aSwitch1.setText(quest.getAnswer_a().isCorrect() + "");
        aSwitch2.setText(quest.getAnswer_b().isCorrect() + "");
        aSwitch3.setText(quest.getAnswer_c().isCorrect() + "");
        aSwitch4.setText(quest.getAnswer_d().isCorrect() + "");
    }//end setScreenQuest()

    private GameEntity getScreenQuest() {
        int level = sp_level.getSelectedItemPosition() + 1;
        String quest = etQuest.getText().toString();
        String ans1 = etAns1.getText().toString();
        String ans2 = etAns2.getText().toString();
        String ans3 = etAns3.getText().toString();
        String ans4 = etAns4.getText().toString();
        boolean b_ans1 = aSwitch1.isChecked();
        boolean b_ans2 = aSwitch2.isChecked();
        boolean b_ans3 = aSwitch3.isChecked();
        boolean b_ans4 = aSwitch4.isChecked();

        return new GameEntity(level, quest, new Answer(ans1, b_ans1), new Answer(ans2, b_ans2)
                , new Answer(ans3, b_ans3), new Answer(ans4, b_ans4));
    }//end getScreenQuest()

    private void clearScreenQuest() {

        etQuest.setText("");
        etAns1.setText("");
        etAns2.setText("");
        etAns3.setText("");
        etAns4.setText("");
        aSwitch1.setChecked(false);
        aSwitch2.setChecked(false);
        aSwitch3.setChecked(false);
        aSwitch4.setChecked(false);
        aSwitch1.setText("false");
        aSwitch2.setText("false");
        aSwitch3.setText("false");
        aSwitch4.setText("false");
    }//end clearScreenQuest()

}//end class