package com.example.quizoffline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   // public static ArrayList<Model> arrayList;
    public static ArrayList<Model> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(intent);
            }
        },1000);


        arrayList = new ArrayList<>();arrayList.add(new Model("ROLLBACK in a database is ________ statement ?","TCL ","DCL ","DML","DDL","TCL"));
//       arrayList.add(new Model("Unlike filters queries can be saved as in a database ?","objects ","filters ","database ","Any of the above " ,"objects"));
//       arrayList.add(new Model("Dr. E.F. Codd represented ______ rules that a database must obey if it has to be considered truly relational ?","10","8","12","6","12"));
//       arrayList.add(new Model("Periodically adding, changing and deleting file records is called file ?","updating ","upgrading ","restructiring ","renewing ","updating"));
//

       arrayList.add(new Model("question1","a","b","c","d","a"));
       arrayList.add(new Model("question2","a","b","c","d","c"));
       arrayList.add(new Model("question3","a","b","c","d","d"));




    }
}