package com.example.project_bangcuuchuong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import java.util.Scanner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChoiActivity_modede extends AppCompatActivity {
    Button Back_mode1;
    Button Btndapan1_mode1;
    Button Btndapan2_mode1;
    Button Btndapan3_mode1;
    Button Btndapan4_mode1;
    TextView Hienthisocau_mode1;
    TextView Demsocau_mode1;
    TextView Cauhoi_mode1;
    TextView Ketqua1_mode1;
    TextView Ketqua2_mode1;
    TextView Ketqua3_mode1;
    int countmode1=0;
    int caudungmode1;
    int causaimode1;
    int correctAnswer_mode1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choi_modede);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Back_mode1=findViewById(R.id.btn_back_mode1);
        Btndapan1_mode1=findViewById(R.id.btndapan1_mode1);
        Btndapan2_mode1=findViewById(R.id.btndapan2_mode1);
        Btndapan3_mode1=findViewById(R.id.btndapan3_mode1);
        Btndapan4_mode1=findViewById(R.id.btndapan4_mode1);
        Hienthisocau_mode1=findViewById(R.id.hienthisocau_mode1);
        Demsocau_mode1=findViewById(R.id.demsocausaivadung_mode1);
        Cauhoi_mode1=findViewById(R.id.cauhoi_mode1);
        Ketqua1_mode1=findViewById(R.id.ketqua1_mode1);
        Ketqua2_mode1=findViewById(R.id.ketqua2_mode1);
        Ketqua3_mode1=findViewById(R.id.ketqua3_mode1);
        loadNewQuestion_mode1();
        Back_mode1.setOnClickListener(new View.OnClickListener() {
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
                if (selectedAnswer == correctAnswer_mode1) {
                    caudungmode1++;
                    loadNewQuestion_mode1();
                } else {
                    causaimode1++;
                    clickedButton.setText("Sai");
                    clickedButton.setEnabled(false);
                }

                Demsocau_mode1.setText(caudungmode1 +":" + causaimode1);
                if(caudungmode1==10){
                    Ketqua1_mode1.setVisibility(view.VISIBLE);
                    Ketqua2_mode1.setVisibility(view.VISIBLE);
                    Ketqua3_mode1.setVisibility(view.VISIBLE);
                    Ketqua3_mode1.setText(caudungmode1+":"+causaimode1);

                }
            }
        };

        Btndapan1_mode1.setOnClickListener(answerClickListener);
        Btndapan2_mode1.setOnClickListener(answerClickListener);
        Btndapan3_mode1.setOnClickListener(answerClickListener);
        Btndapan4_mode1.setOnClickListener(answerClickListener);
    }

    void Hamdemsocaumode1(){
        countmode1++;
        Hienthisocau_mode1.setText(countmode1+"/10");
    }
    void loadNewQuestion_mode1() {
        // Tạo 2 số ngẫu nhiên trong khoảng 1–10
        Random random=new Random();
        int a = random.nextInt(5) + 1;
        int b = random.nextInt(5) + 1;
        correctAnswer_mode1 = a * b;

        Cauhoi_mode1.setText(a + " * " + b + " = ?");
        Hamdemsocaumode1();

        // Tạo một mảng 4 đáp án
        int[] answers = new int[4];
        int correctPosition = random.nextInt(4);
        answers[correctPosition] = correctAnswer_mode1;

        for (int i = 0; i < 4; i++) {
            if (i != correctPosition) {
                // Đáp án sai gần đúng (tạo sự gây nhiễu)
                int wrongAnswer;
                do {
                    wrongAnswer = correctAnswer_mode1 + random.nextInt(10) - 5;
                } while (wrongAnswer == correctAnswer_mode1 || wrongAnswer <= 0);
                answers[i] = wrongAnswer;
            }
        }
        // Hiển thị đáp án lên các nút
        Btndapan1_mode1.setText(String.valueOf(answers[0]));
        Btndapan2_mode1.setText(String.valueOf(answers[1]));
        Btndapan3_mode1.setText(String.valueOf(answers[2]));
        Btndapan4_mode1.setText(String.valueOf(answers[3]));

        // Kích hoạt lại tất cả nút
        Btndapan1_mode1.setEnabled(true);
        Btndapan2_mode1.setEnabled(true);
        Btndapan3_mode1.setEnabled(true);
        Btndapan4_mode1.setEnabled(true);
    }
}