package com.example.project_bangcuuchuong;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import android.graphics.drawable.Drawable;

import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class HocActivity1 extends AppCompatActivity {



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);  // Đây là việc thiết lập hiển thị giao diện toàn màn hình
        setContentView(R.layout.activity_hoc1);

        // Thêm các Fragment vào layout
        FragmentManager fragment = getSupportFragmentManager();
        fragment.beginTransaction()
                .add(R.id.frameheader1, new HeaderFragment())  // Thêm HeaderFragment vào layout
                .add(R.id.framefooter1, new FooterFragment())  // Thêm FooterFragment vào layout
                .commit();


    }
}
