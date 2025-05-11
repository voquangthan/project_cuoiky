package com.example.project_bangcuuchuong;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class FooterFragment extends Fragment {

    Button Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8, Btn9, Btn10;
    ImageView Hinhanh;

    public FooterFragment() {
        // Constructor rỗng là bắt buộc
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Nạp layout cho Fragment
        View view = inflater.inflate(R.layout.fragment_footer, container, false);

        // Ánh xạ các nút sau khi đã có view
        Btn1 = view.findViewById(R.id.btn1);
        Btn2 = view.findViewById(R.id.btn2);
        Btn3 = view.findViewById(R.id.btn3);
        Btn4 = view.findViewById(R.id.btn4);
        Btn5 = view.findViewById(R.id.btn5);
        Btn6 = view.findViewById(R.id.btn6);
        Btn7 = view.findViewById(R.id.btn7);
        Btn8 = view.findViewById(R.id.btn8);
        Btn9 = view.findViewById(R.id.btn9);
        Btn10 = view.findViewById(R.id.btn10);
        Hinhanh = view.findViewById(R.id.image_content); // Ánh xạ ImageView để hiển thị ảnh

        // Xử lý sự kiện click của Btn1
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hinhanh.setImageResource(R.drawable.anh1);
            }
        });
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hinhanh.setImageResource(R.drawable.anh2);
            }
        });
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hinhanh.setImageResource(R.drawable.anh3);
            }
        });
        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hinhanh.setImageResource(R.drawable.anh4);
            }
        });
        Btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hinhanh.setImageResource(R.drawable.anh5);
            }
        });
        Btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hinhanh.setImageResource(R.drawable.anh6);
            }
        });
        Btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hinhanh.setImageResource(R.drawable.anh7);
            }
        });
        Btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hinhanh.setImageResource(R.drawable.anh8);
            }
        });
        Btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hinhanh.setImageResource(R.drawable.anh9);
            }
        });
        Btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hinhanh.setImageResource(R.drawable.anh10);
            }
        });

        return view;
    }
}
