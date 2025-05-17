package com.example.project_bangcuuchuong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Choi_Activity extends AppCompatActivity {
    Button De;
    Button Trungbinh;
    Button Kho;
    Button Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        De=findViewById(R.id.btn_de_choiactivity);
        Trungbinh=findViewById(R.id.btn_trungbinh_choiacivity);
        Kho=findViewById(R.id.btn_kho_choiactivity);
        Back=findViewById(R.id.btn_quizback_choiactivity);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    finish();
            }
        });
        De.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Choi_Activity.this, De_choi_Activity.class);
                startActivity(intent);
            }
        });
        Trungbinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Choi_Activity.this, Trungbinh_choi_Activity.class);
                startActivity(intent);
            }
        });
        Kho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Choi_Activity.this, Kho_choi_Activity.class);
                startActivity(intent);
            }
        });
    }
}