package com.example.lab05;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editNamDuongLich;
    TextView textNamAmLich;
    Button btnChuyenDoi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNamDuongLich = findViewById(R.id.editnamduonglich);
        textNamAmLich = findViewById(R.id.textView5);
        btnChuyenDoi = findViewById(R.id.button1);

        btnChuyenDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editNamDuongLich.getText().toString();

                if (!input.isEmpty()) {
                    int namDuong = Integer.parseInt(input);

                    String[] canList = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
                    String[] chilist = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mẹo", "Thìn", "Tỵ", "Ngọ", "Mùi"};

                    String can = canList[namDuong % 10];
                    String chi = chilist[namDuong % 12];

                    String namAm = can + " " + chi;
                    textNamAmLich.setText(namAm);
                } else {
                    textNamAmLich.setText("Vui lòng nhập năm dương lịch.");
                }
            }
        });
    }
}