package com.example.project_bangcuuchuong;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button button_hoc;
Button button_choi;
View Outside_view;
Button button_danhgia;
Button button_thidau;
Button Button_about;
Button Button_policy;
Button Button_term;
Button Btnmain_setting;
TextView Click_setting_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        button_hoc=findViewById(R.id.btnmain_hoc);
        button_choi=findViewById(R.id.btnmain_choi);
        button_danhgia=findViewById(R.id.btnmain_danhgia);
        button_thidau=findViewById(R.id.btnmain_thidau);
        Button_about=findViewById(R.id.btn_about);
        Button_policy=findViewById(R.id.btn_policy);
        Button_term=findViewById(R.id.btn_term);
        Btnmain_setting=findViewById(R.id.btnmain_setting);
        Click_setting_main=findViewById(R.id.click_setting_main);
        Outside_view=findViewById(R.id.outside_view);

        button_hoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,HocActivity1.class);
                startActivity(intent);

            }

        });
        Button_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,PolicyActivity.class);
                startActivity(intent);
            }
        });
        Button_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,About_Activity.class);
                startActivity(intent);
            }
        });
        Button_term.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,term_Activity.class);
                startActivity(intent);
            }
        });
        Outside_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click_setting_main.setVisibility(View.GONE);
                Button_policy.setVisibility(View.GONE);
                Button_about.setVisibility(View.GONE);
                Button_term.setVisibility(View.GONE);
                Outside_view.setVisibility(View.GONE);
            }
        });
        Btnmain_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click_setting_main.setVisibility(v.VISIBLE);
                Button_policy.setVisibility(v.VISIBLE);
                Button_about.setVisibility(v.VISIBLE);
                Button_term.setVisibility(v.VISIBLE);
                Outside_view.setVisibility(View.VISIBLE);

            }
        });

    }

}