package com.example.project_bangcuuchuong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Quiz_Activity extends AppCompatActivity {

    Button Btn_dapan1, Btn_dapan2, Btn_dapan3, Btn_dapan4, Btn_quiz_back;
    TextView Cauhoi;
    TextView Hienthisocau;
    TextView Demsocausaivadung;
    TextView Ketqua1;
    TextView Ketqua2;
    TextView Ketqua3;
    int count=0;

    int causai=0;
    int caudung=0;
    int correctAnswer; // Đáp án đúng hiện tại
    Random random = new Random(); // Đối tượng để tạo số ngẫu nhiên

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Btn_dapan1 = findViewById(R.id.btndapan1);
        Btn_dapan2 = findViewById(R.id.btndapan2);
        Btn_dapan3 = findViewById(R.id.btndapan3);
        Btn_dapan4 = findViewById(R.id.btndapan4);
        Ketqua1=findViewById(R.id.ketqua1);
        Ketqua2=findViewById(R.id.ketqua2);
        Ketqua3=findViewById(R.id.ketqua3);
        Btn_quiz_back = findViewById(R.id.btn_quiz_back);
        Cauhoi = findViewById(R.id.cauhoi);
        Hienthisocau=findViewById(R.id.hienthisocau);
        Demsocausaivadung=findViewById(R.id.demsocausaivadung);

        loadNewQuestion();

        Btn_quiz_back.setOnClickListener(v -> finish());

        View.OnClickListener answerClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button clickedButton = (Button) view;
                int selectedAnswer = Integer.parseInt(clickedButton.getText().toString());
                if (selectedAnswer == correctAnswer) {
                    caudung++;
                    loadNewQuestion(); // Nếu đúng thì nạp câu hỏi mới
                } else {
                     causai++;
                    clickedButton.setText("Sai");
                    clickedButton.setEnabled(false);
                }

                Demsocausaivadung.setText(caudung +":" + causai);
                if(caudung==10){
                    Ketqua1.setVisibility(view.VISIBLE);
                    Ketqua2.setVisibility(view.VISIBLE);
                    Ketqua3.setVisibility(view.VISIBLE);
                    Ketqua3.setText(caudung+":"+causai);

                }
            }
        };

        Btn_dapan1.setOnClickListener(answerClickListener);
        Btn_dapan2.setOnClickListener(answerClickListener);
        Btn_dapan3.setOnClickListener(answerClickListener);
        Btn_dapan4.setOnClickListener(answerClickListener);
    }
    void demsocau(){
        count++;
        Hienthisocau.setText("Số 1  "+count+"/10");

    }
    void loadNewQuestion() {
        // Tạo 2 số ngẫu nhiên trong khoảng 1–10
        int a = random.nextInt(9) + 1;
        int b = random.nextInt(9) + 1;
        correctAnswer = a * b;

        Cauhoi.setText(a + " * " + b + " = ?");
        demsocau();

        // Tạo một mảng 4 đáp án
        int[] answers = new int[4];
        int correctPosition = random.nextInt(4);
        answers[correctPosition] = correctAnswer;

        for (int i = 0; i < 4; i++) {
            if (i != correctPosition) {
                // Đáp án sai gần đúng (tạo sự gây nhiễu)
                int wrongAnswer;
                do {
                    wrongAnswer = correctAnswer + random.nextInt(10) - 5;
                } while (wrongAnswer == correctAnswer || wrongAnswer <= 0);
                answers[i] = wrongAnswer;
            }
        }
        // Hiển thị đáp án lên các nút
        Btn_dapan1.setText(String.valueOf(answers[0]));
        Btn_dapan2.setText(String.valueOf(answers[1]));
        Btn_dapan3.setText(String.valueOf(answers[2]));
        Btn_dapan4.setText(String.valueOf(answers[3]));

        // Kích hoạt lại tất cả nút
        Btn_dapan1.setEnabled(true);
        Btn_dapan2.setEnabled(true);
        Btn_dapan3.setEnabled(true);
        Btn_dapan4.setEnabled(true);
    }
}
