package com.example.lab01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

	public class MainActivity extends AppCompatActivity {
        // Khai báo các biến giao diện tại đây
        private EditText edtA, edtB, edtKQ;
        private Button btncong;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            edtA = findViewById(R.id.edtA);
            edtB = findViewById(R.id.edtB);
            edtKQ = findViewById(R.id.edtKQ);
            btncong = findViewById(R.id.btntong);

            btncong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int a = Integer.parseInt(edtA.getText().toString());
                    int b = Integer.parseInt(edtB.getText().toString());
                    int c = a+b;
                    edtKQ.setText(c+"");
                }
            });
        }
    }
