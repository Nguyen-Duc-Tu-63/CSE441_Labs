package com.example.myapplication;

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

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edita, editb, editc;
    Button btnTiepTuc, btnGiaiPT, btnThoat;
    TextView txtkq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTiepTuc = findViewById(R.id.btntieptuc);
        btnGiaiPT = findViewById(R.id.btngiaipt);
        btnThoat = findViewById(R.id.btnthoat);
        edita = findViewById(R.id.edita);
        editb = findViewById(R.id.editb);
        editc = findViewById(R.id.editc);
        txtkq = findViewById(R.id.txtkq);
        btnGiaiPT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sa = edita.getText()+"";
                String sb = editb.getText()+"";
                String sc = editc.getText()+"";

                int a = Integer.parseInt(sa);
                int b = Integer.parseInt(sb);
                int c = Integer.parseInt(sc);
                String kq = "";
                DecimalFormat dcf = new DecimalFormat("0.00");
                if(a==0){
                    if(b==0){
                        if(c==0){
                            kq = "PT vô số nghiệm";
                        }else{
                            kq = "PT vô nghiệm";
                        }
                    }else{
                        kq = "PT có 1 nghiệm, x="+dcf.format(-c/b);
                    }
                }else{
                    double delta = b*b-4*a*c;
                    if(delta<0){
                        kq = "PT vô nghiệm";
                    } else if (delta==0) {
                        kq = "PT có No kép  x1=x2="+dcf.format(-b/(2*a));
                    }
                    else {
                        kq = "PT có 2 No :x1="+dcf.format((-b+Math.sqrt(delta))/(2*a))+";x2="+dcf.format((-b-Math.sqrt(delta))/(2*a));

                    }
                }
                txtkq.setText(kq);

            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edita.setText("");
                editb.setText("");
                editc.setText("");
                txtkq.setText(""); // Nếu bạn muốn xóa luôn kết quả
                edita.requestFocus(); // Đưa con trỏ về ô nhập a
            }
        });

    }
}