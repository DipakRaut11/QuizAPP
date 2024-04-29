package com.example.quizoffline;

import static com.example.quizoffline.MainActivity.arrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Dashboard extends AppCompatActivity {
ProgressBar progressBar;
CountDownTimer countDownTimer;
int timer = 20;

List<Model> questionlist;
Model model;


CardView  cardA, cardB, cardD, cardC, next_btn, Exit, Back;
TextView optA, optB, optC, optD, questions;
    int index = 0;

    int correctcount = 0;
    int wrongcount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        ID();

        questionlist = arrayList;
        Collections.shuffle(questionlist);
        model = arrayList.get(index);



        setAllData();

        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer = timer -1;
                progressBar.setProgress(timer);


            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(Dashboard.this);
               dialog.setContentView(R.layout.time_out);
               dialog.findViewById(R.id.time_out).setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent = new Intent(Dashboard.this,MainActivity.class);
                       startActivity(intent);
                   }
               });
               dialog.show();

            }
        }.start();
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });


Exit();

    }


    public void Exit(){
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }
    private void setAllData() {
        questions.setText(model.getQuestions());
        optA.setText(model.getOptA());
        optB.setText(model.getOptB());
        optC.setText(model.getOptC());
        optD.setText(model.getOptD());
    }

    private void ID() {

        progressBar = findViewById(R.id.pbProcessing);

        cardA = findViewById(R.id.cardoptA);
        cardB = findViewById(R.id.cardoptB);
        cardC = findViewById(R.id.cardoptC);
        cardD = findViewById(R.id.cardoptD);

        optA = findViewById(R.id.optA);
        optB = findViewById(R.id.optB);
        optC = findViewById(R.id.optC);
        optD = findViewById(R.id.optD);
        questions = findViewById(R.id.question);

        next_btn = findViewById(R.id.cardNext);

Exit = findViewById(R.id.exit);
Back = findViewById(R.id.back);


    }


    public void correct(CardView cardView){
cardView.setCardBackgroundColor(getResources().getColor(R.color.green));
        next_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                correctcount++;
                index++;
                model = arrayList.get(index);
                setAllData();
                enableButton();
                resetColor();



            }
        });

    }
    public void wrong(CardView cardView){
        cardView.setCardBackgroundColor(getResources().getColor(R.color.red));
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongcount++;
                if(index<arrayList.size()-1){
                    index++;
                    model = arrayList.get(index);
                    setAllData();
                    resetColor();
                    enableButton();

                }
                else {
                    gamewon();
                }
            }
        });



    }

    private void gamewon() {
        Intent intent = new Intent(Dashboard.this,gamewon.class);
        intent.putExtra("correct",correctcount);
        intent.putExtra("wrong",wrongcount);
        startActivity(intent);
    }

    public void enableButton(){
cardA.setClickable(true);
cardB.setClickable(true);
cardC.setClickable(true);
cardD.setClickable(true);

    }
    public void disableButton(){
        cardA.setClickable(false);
        cardB.setClickable(false);
        cardC.setClickable(false);
        cardD.setClickable(false);

    }

    public void optAclick(View view) {
        disableButton();
        next_btn.setClickable(true);
        if (model.getOptA().equals(model.getAns())){
            cardA.setCardBackgroundColor(getResources().getColor(R.color.green));
            if (index<arrayList.size()-1){
            correct(cardA);
            }
            else {
                gamewon();
            }
        }
        else {
            wrong(cardA);
        }


    }

    public void optBclick(View view) {
        disableButton();
        next_btn.setClickable(true);
        if(model.getOptB().equals(model.getAns())){
            cardB.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index<arrayList.size()-1){
                correct(cardB);

            }
            else {
                gamewon();
            }
        }
        else {
            wrong(cardB);
        }

    }
    public void optCclick(View view) {
        disableButton();
        next_btn.setClickable(true);
        if (model.getOptC().equals(model.getAns())){
            cardC.setCardBackgroundColor(getResources().getColor(R.color.green));
            if (index<arrayList.size()-1) {
                correct(cardC);
            }
            else {
                gamewon();
            }
        }
        else {
            wrong(cardC);
        }

    }
    public void optDclick(View view) {

        disableButton();
        next_btn.setClickable(true);
        if (model.getOptD().equals(model.getAns())){
            cardD.setCardBackgroundColor(getResources().getColor(R.color.green));
            if (index<arrayList.size()-1){
                correct(cardD);
            }
            else {
                gamewon();
            }
        }
        else {
            wrong(cardD);
        }

    }

    public void resetColor(){
        cardA.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardB.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardC.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardD.setCardBackgroundColor(getResources().getColor(R.color.white));
    }




    private void goBack() {
        if (index > 0) {
            index--;
            model = arrayList.get(index);
            setAllData();
            resetColor();
            enableButton();
        }
    }
}