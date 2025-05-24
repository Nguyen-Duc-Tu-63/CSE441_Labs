package com.example.lab06;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtten, edtCMND, edtBoSung;
    CheckBox chkDocBao, chkDocSach, chkDocCode;
    Button btnGui;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtten = findViewById(R.id.editHoten);
        edtCMND = findViewById(R.id.editCMND);
        edtBoSung = findViewById(R.id.editBosung);
        chkDocBao = findViewById(R.id.chkdocbao);
        chkDocSach = findViewById(R.id.chkdocsach);
        chkDocCode = findViewById(R.id.chkdoccoding);
        btnGui = findViewById(R.id.btnGuiTT);

        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doShowInformation();
            }
        });
    }
    public  void  doShowInformation(){
        String ten = edtten.getText().toString();
        ten = ten.trim();
        if(ten.length()<3){
            edtten.requestFocus();
            edtten.selectAll();
            Toast.makeText(this, "Tên phải >= 3 ký tự", Toast.LENGTH_SHORT).show();
            return;
        }
        String cmmd = edtCMND.getText().toString();
        cmmd = cmmd.trim();
        if(cmmd.length()!=9){
            edtCMND.requestFocus();
            edtCMND.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_SHORT).show();
            return;
        }
        String bang="";
        group = findViewById(R.id.radioGroup1);
        int id = group.getCheckedRadioButtonId();
        if(id==1){
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton rad = findViewById(id);
        bang = rad.getText()+"";
        String sothich="";
        if(chkDocBao.isChecked()){
            sothich+=chkDocBao.getText()+"\n";
        }
        if(chkDocSach.isChecked()){
            sothich+=chkDocSach.getText()+"\n";
        }
        if(chkDocCode.isChecked()){
            sothich+=chkDocCode.getText()+"\n";
        }

        String bosung = edtBoSung.getText()+"";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        String msg = ten+"\n";
        msg+=cmmd+"\n";
        msg+=bang+"\n";
        msg+=sothich+"\n";
        msg+="—————————–\n";
        msg+="Thông tin bổ sung:\n";
        msg+=bosung+ "\n";
        msg+="—————————–";
        builder.setMessage(msg);
        builder.create().show();
    }
}