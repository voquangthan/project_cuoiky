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

public class ChoiActivity_modetrungbinh extends AppCompatActivity {

    Button Back_mode2, Btndapan1_mode2, Btndapan2_mode2, Btndapan3_mode2, Btndapan4_mode2;
    TextView Hienthisocau_mode2, Demsocau_mode2, Cauhoi_mode2, Ketqua1_mode2, Ketqua2_mode2, Ketqua3_mode2;

    int countmode2 = 0;
    int caudungmode2 = 0;
    int causaimode2 = 0;
    int correctAnswer_mode2;

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

        // Ánh xạ view
        Back_mode2 = findViewById(R.id.btn_back_mode2);
        Btndapan1_mode2 = findViewById(R.id.btndapan1_mode2);
        Btndapan2_mode2 = findViewById(R.id.btndapan2_mode2);
        Btndapan3_mode2 = findViewById(R.id.btndapan3_mode2);
        Btndapan4_mode2 = findViewById(R.id.btndapan4_mode2);
        Hienthisocau_mode2 = findViewById(R.id.hienthisocau_mode2);
        Demsocau_mode2 = findViewById(R.id.demsocausaivadung_mode2);
        Cauhoi_mode2 = findViewById(R.id.cauhoi_mode2);
        Ketqua1_mode2 = findViewById(R.id.ketqua1_mode2);
        Ketqua2_mode2 = findViewById(R.id.ketqua2_mode2);
        Ketqua3_mode2 = findViewById(R.id.ketqua3_mode2);

        // Ẩn các TextView kết quả lúc đầu
        Ketqua1_mode2.setVisibility(View.GONE);
        Ketqua2_mode2.setVisibility(View.GONE);
        Ketqua3_mode2.setVisibility(View.GONE);

        // Gán sự kiện click cho nút back
        Back_mode2.setOnClickListener(v -> finish());

        // Gán sự kiện click cho các đáp án
        View.OnClickListener answerClickListener = view -> {
            Button clickedButton = (Button) view;
            int selectedAnswer = Integer.parseInt(clickedButton.getText().toString());

            if (selectedAnswer == correctAnswer_mode2) {
                caudungmode2++;
                loadNewQuestion_mode2();
            } else {
                causaimode2++;
                clickedButton.setText("Sai");
                clickedButton.setEnabled(false);
            }

            Demsocau_mode2.setText(caudungmode2 + " : " + causaimode2);

            if (caudungmode2 == 10) {
                Ketqua1_mode2.setVisibility(View.VISIBLE);
                Ketqua2_mode2.setVisibility(View.VISIBLE);
                Ketqua3_mode2.setVisibility(View.VISIBLE);
                Ketqua3_mode2.setText("Đúng: " + caudungmode2 + " | Sai: " + causaimode2);

                // Tắt các nút sau khi hoàn thành
                Btndapan1_mode2.setEnabled(false);
                Btndapan2_mode2.setEnabled(false);
                Btndapan3_mode2.setEnabled(false);
                Btndapan4_mode2.setEnabled(false);
            }
        };

        Btndapan1_mode2.setOnClickListener(answerClickListener);
        Btndapan2_mode2.setOnClickListener(answerClickListener);
        Btndapan3_mode2.setOnClickListener(answerClickListener);
        Btndapan4_mode2.setOnClickListener(answerClickListener);

        // Bắt đầu câu hỏi đầu tiên
        loadNewQuestion_mode2();
    }

    void Hamdemsocaumode2() {
        countmode2++;
        Hienthisocau_mode2.setText(countmode2 + " / 10");
    }

    void loadNewQuestion_mode2() {
        Random random = new Random();
        int a = random.nextInt(8) + 3;
        int b = random.nextInt(8) + 3;
        correctAnswer_mode2 = a * b;

        Cauhoi_mode2.setText(a + " * " + b + " = ?");
        Hamdemsocaumode2();

        int[] answers = new int[4];
        int correctPosition = random.nextInt(4);
        answers[correctPosition] = correctAnswer_mode2;

        for (int i = 0; i < 4; i++) {
            if (i != correctPosition) {
                int wrongAnswer;
                do {
                    wrongAnswer = correctAnswer_mode2 + random.nextInt(10) - 5;
                } while (wrongAnswer == correctAnswer_mode2 || wrongAnswer <= 0);
                answers[i] = wrongAnswer;
            }
        }

        Btndapan1_mode2.setText(String.valueOf(answers[0]));
        Btndapan2_mode2.setText(String.valueOf(answers[1]));
        Btndapan3_mode2.setText(String.valueOf(answers[2]));
        Btndapan4_mode2.setText(String.valueOf(answers[3]));

        Btndapan1_mode2.setEnabled(true);
        Btndapan2_mode2.setEnabled(true);
        Btndapan3_mode2.setEnabled(true);
        Btndapan4_mode2.setEnabled(true);
    }
}
