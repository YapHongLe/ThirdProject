package com.example.thirdapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuestionsActivity4 extends AppCompatActivity {

    private TextView countLabel;
    private TextView questionLabel;
    private Button answerBtn1, answerBtn2, answerBtn3, answerBtn4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData4[][] = {
            // {"Question", "Right Answer". "Answer1", "Answer2", "Answer3"}
            {"Station Between HabourFront and Labrador Park", "Telok Blangah", "Pasir Panjang", "Kent Ridge", "one-north"},
            {"Station Between Pasir Panjang and Kent Ridge", "Haw Par Villa", "one-north", "Telok Blangah", "Labrador Park"},
            {"Station Between one-north and Holland Village", "Buana Vista", "Kent Ridge", "Bishan", "Caldecott"},
            {"Station Between Farrer Road and Caldecott", "Botanic Gardens", "Yishun", "Holland Village", "Marymount"},
            {"Station Between Marymount and Lorong Chuan", "Bishan", "Bartley", "Serangoon", "Dakota"},
            {"Station Between Paya Lebar and Mountbatten", "Dakota", "Nicoll Highway", "stadium", "Promenade"},
            {"Lorong Chuan > Serangoon > Bartley > ?\n What is the ?", "Tai Seng", "MacPherson", "Dakota", "Paya Lebar"},
            {"Telok Blangah > Labrador Park > Pasir Panjang > ?\n What is the ?", "Haw Par Villa", "Kent Ridge", "one-north", "Farrer Road"},
            {"Marymount > Bishan > Lorong Chuan > ?\n What is the ?", "Serangoon", "Bartley", "Tai Seng", "Paya Lebar"},
            {"Caldecott > Botanic Gardens > Farrer Road > ?\n What is the ?", "Halland Village", "Buana Vista", "one-north", "Lorong Chuan"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        countLabel = (TextView) findViewById(R.id.countLabel);
        questionLabel = (TextView) findViewById(R.id.questionLabel);
        answerBtn1 = (Button) findViewById(R.id.answerBtn1);
        answerBtn2 = (Button) findViewById(R.id.answerBtn2);
        answerBtn3 = (Button) findViewById(R.id.answerBtn3);
        answerBtn4 = (Button) findViewById(R.id.answerBtn4);

        // Create quizArray from quizData
        for (int i = 0; i < quizData4.length; i++) {

            // Prepare array
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData4[i][0]); // Q
            tmpArray.add(quizData4[i][1]); // R
            tmpArray.add(quizData4[i][2]); // 1
            tmpArray.add(quizData4[i][3]); // 2
            tmpArray.add(quizData4[i][4]); // 3

            // Add tmpArray to quizArray
            quizArray.add(tmpArray);

        }

        showNextQuiz();
    }

    public void showNextQuiz() {

        // Update quizCountLabel
        countLabel.setText("Q" + quizCount);

        // Generate random number between 0 and 5 (quizArray's size - 1)
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        // Pick one quiz set

        ArrayList<String> quiz = quizArray.get(randomNum);

        // Set question and right Answer
        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        // Remove "Q" from quiz and shuffle choices
        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set choices
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        // Remove this quiz from quizArray
        quizArray.remove(randomNum);

    }

    public void checkAnswer(View view) {

        // Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if (btnText.equals(rightAnswer)) {
            alertTitle = "Correct!";
            rightAnswerCount++;

        } else {
            alertTitle = "Wrong. . .";
        }

        // Create Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer : " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizCount == QUIZ_COUNT) {
                    // Show Result
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);

                } else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();

    }
}

