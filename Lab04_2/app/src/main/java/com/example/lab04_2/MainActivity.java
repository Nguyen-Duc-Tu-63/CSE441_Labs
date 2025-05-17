package com.example.lab04_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btnChuandoan;
    EditText editTen, editChieucao, editCannang, editChandoan, editBMI;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChuandoan = findViewById(R.id.btnBMI);
        editTen = findViewById(R.id.edtten);
        editChieucao = findViewById(R.id.edtchieucao);
        editCannang = findViewById(R.id.edtcannang);
        editBMI = findViewById(R.id.edtBMI);
        editChandoan = findViewById(R.id.edtChuanDoan);
        
        btnChuandoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double H = Double.parseDouble(editChieucao.getText()+"");
                double W = Double.parseDouble(editCannang.getText()+"");
                double BMI = W/Math.pow(H,2);
                String chuandoan="";
                if(BMI<18){
                    chuandoan="Bạn gầy";
                } else if (BMI<24.9) {
                    chuandoan="Bạn bình thường";
                } else if (BMI<=29.9) {
                    chuandoan="Bạn béo phì độ 1";
                } else if (BMI<=34.9) {
                    chuandoan="Bạn béo phì độ 2";
                }else {
                    chuandoan="Bạn béo phì độ 3";
                }
                DecimalFormat dcf = new DecimalFormat("#.0");
                editBMI.setText(dcf.format(BMI));
                editChandoan.setText(chuandoan);
            }
        });
    }
}