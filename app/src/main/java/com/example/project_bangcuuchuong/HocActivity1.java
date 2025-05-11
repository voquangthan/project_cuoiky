package com.example.project_bangcuuchuong;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class HocActivity1 extends AppCompatActivity {
    Button Btn1;
    Button Btn2;
    Button Btn3;
    Button Btn4;
    Button Btn5;
    Button Btn6;
    Button Btn7;
    Button Btn8;
    Button Btn9;
    Button Btn10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hoc1);
        FragmentManager fragment=getSupportFragmentManager();
        fragment.beginTransaction()
                .add(R.id.frameheader1,new HeaderFragment())
                .add(R.id.framefooter1,new FooterFragment())
                .commit();

    }
}