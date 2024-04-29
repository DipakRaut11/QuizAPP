package com.example.quizoffline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class gamewon extends AppCompatActivity {
    CircularProgressBar circularProgressBar;
    TextView result;
    int correct;
    int wrong;
    RelativeLayout btn_share;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamewon);
        correct = getIntent().getIntExtra("correct", 0);
        wrong = getIntent().getIntExtra("wrong", 0);



//

        circularProgressBar = findViewById(R.id.circularProgressBar);
        result = findViewById(R.id.result);
        btn_share = findViewById(R.id.btn_share);
        CardView Exit = findViewById(R.id.exit);

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        circularProgressBar.setProgress(correct);
        result.setText(correct+"/20");

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                String shareMessage= "\ngot" + correct +"otut of 20 \n\n";
                share.putExtra(Intent.EXTRA_TEXT,shareMessage);
                share.setType("text/plain");
                startActivity(Intent.createChooser(share,"Choose one"));
            }
        });

    }
}