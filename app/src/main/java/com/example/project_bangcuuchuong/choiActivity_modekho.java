package com.example.project_bangcuuchuong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class choiActivity_modekho extends AppCompatActivity {
    Button Back_mode3;
    Button Btndapan1_mode3;
    Button Btndapan2_mode3;
    Button Btndapan3_mode3;
    Button Btndapan4_mode3;
    TextView Hienthisocau_mode3;
    TextView Demsocau_mode3;
    TextView Cauhoi_mode3;
    TextView Ketqua1_mode3;
    TextView Ketqua2_mode3;
    TextView Ketqua3_mode3;
    int countmode3 = 0;
    int caudungmode3;
    int causaimode3;
    int correctAnswer_mode3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choi_modetrungbinh);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Back_mode3 = findViewById(R.id.btn_back_mode2);
        Btndapan1_mode3 = findViewById(R.id.btndapan1_mode2);
        Btndapan2_mode3 = findViewById(R.id.btndapan2_mode2);
        Btndapan3_mode3 = findViewById(R.id.btndapan3_mode2);
        Btndapan4_mode3 = findViewById(R.id.btndapan4_mode2);
        Hienthisocau_mode3 = findViewById(R.id.hienthisocau_mode2);
        Demsocau_mode3 = findViewById(R.id.demsocausaivadung_mode2);
        Cauhoi_mode3 = findViewById(R.id.cauhoi_mode2);
        Ketqua1_mode3 = findViewById(R.id.ketqua1_mode2);
        Ketqua2_mode3 = findViewById(R.id.ketqua2_mode2);
        Ketqua3_mode3 = findViewById(R.id.ketqua3_mode2);

        loadNewQuestion_mode3();

        Back_mode3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        View.OnClickListener answerClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button clickedButton = (Button) view;
                int selectedAnswer = Integer.parseInt(clickedButton.getText().toString());
                if (selectedAnswer == correctAnswer_mode3) {
                    caudungmode3++;
                    loadNewQuestion_mode3();
                } else {
                    causaimode3++;
                    clickedButton.setText("Sai");
                    clickedButton.setEnabled(false);
                }

                Demsocau_mode3.setText(caudungmode3 + ":" + causaimode3);
                if (caudungmode3 == 10) {
                    Ketqua1_mode3.setVisibility(view.VISIBLE);
                    Ketqua2_mode3.setVisibility(view.VISIBLE);
                    Ketqua3_mode3.setVisibility(view.VISIBLE);
                    Ketqua3_mode3.setText(caudungmode3 + ":" + causaimode3);
                }
            }
        };

        Btndapan1_mode3.setOnClickListener(answerClickListener);
        Btndapan2_mode3.setOnClickListener(answerClickListener);
        Btndapan3_mode3.setOnClickListener(answerClickListener);
        Btndapan4_mode3.setOnClickListener(answerClickListener);
    }

    void Hamdemsocaumode3() {
        countmode3++;
        Hienthisocau_mode3.setText(countmode3 + "/10");
    }

    void loadNewQuestion_mode3() {
        Random random = new Random();
        int a = random.nextInt(10) + 10;
        int b = random.nextInt(10) + 10;
        correctAnswer_mode3 = a * b;

        Cauhoi_mode3.setText(a + " * " + b + " = ?");
        Hamdemsocaumode3();

        int[] answers = new int[4];
        int correctPosition = random.nextInt(4);
        answers[correctPosition] = correctAnswer_mode3;

        for (int i = 0; i < 4; i++) {
            if (i != correctPosition) {
                int wrongAnswer;
                do {
                    wrongAnswer = correctAnswer_mode3 + random.nextInt(10) - 5;
                } while (wrongAnswer == correctAnswer_mode3 || wrongAnswer <= 0);
                answers[i] = wrongAnswer;
            }
        }

        Btndapan1_mode3.setText(String.valueOf(answers[0]));
        Btndapan2_mode3.setText(String.valueOf(answers[1]));
        Btndapan3_mode3.setText(String.valueOf(answers[2]));
        Btndapan4_mode3.setText(String.valueOf(answers[3]));

        Btndapan1_mode3.setEnabled(true);
        Btndapan2_mode3.setEnabled(true);
        Btndapan3_mode3.setEnabled(true);
        Btndapan4_mode3.setEnabled(true);
    }
}
