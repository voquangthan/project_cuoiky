package com.example.project_bangcuuchuong;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button button_hoc;
Button button_choi;
Button button_danhgia;
Button button_thidau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        button_hoc=findViewById(R.id.btnmain_hoc);
        button_choi=findViewById(R.id.btnmain_choi);
        button_danhgia=findViewById(R.id.btnmain_danhgia);
        button_thidau=findViewById(R.id.btnmain_thidau);

        button_hoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,HocActivity1.class);
                startActivity(intent);

            }

        });

    }

}