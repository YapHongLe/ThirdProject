package com.example.thirdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity {

    Button btnEast_west, btnSouth, btnNorth_east, btnCircle, btnDowntown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        btnEast_west = findViewById(R.id.btnEast_west);
        btnSouth = findViewById(R.id.btnSouth);
        btnNorth_east = findViewById(R.id.btnNorth_east);
        btnCircle = findViewById(R.id.btnCircle);
        btnDowntown = findViewById(R.id.btnDowntown);

        btnEast_west.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChooseActivity.this, QuestionsActivity2.class);
                startActivity(i);
            }
        });

        btnSouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChooseActivity.this, QuestionsActivity.class);
                startActivity(i);
            }
        });

        btnNorth_east.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChooseActivity.this, QuestionsActivity3.class);
                startActivity(i);
            }
        });

        btnCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChooseActivity.this, QuestionsActivity4.class);
                startActivity(i);
            }
        });

        btnDowntown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChooseActivity.this, QuestionsActivity5.class);
                startActivity(i);
            }
        });

    }
}
