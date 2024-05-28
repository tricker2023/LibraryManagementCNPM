package com.example.librarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.librarymanagement.Datamanagement.DangKyMuonSach;
import com.example.librarymanagement.SQLmangemrnt.SQLmanagement;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NhapMuonSachActivity extends AppCompatActivity {
    private TextView date_timeTextInputEditText;
    //Khai bao cac id
    private ImageButton btnback;
    private TextInputEditText edtidmasach,edthotenms,edtlopms,edtsdtms,edtgmailms,edttensach,edtthoigianmuonms;
    private Button btnnhapms;

    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_muon_sach);
        Init();
        onClickChangePage();
        setClickDateTime();
        // xu ly click back
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // trở lại giao diện trước
                finish();
            }
        });

    }

    private void setClickDateTime() {

        date_timeTextInputEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedDate(calendar,simpleDateFormat);
            }
        });
    }
    private void selectedDate(Calendar calendar,SimpleDateFormat simpleDateFormat){
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);

                date_timeTextInputEditText.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, year,month,day);
        datePickerDialog.show();
    }
    private void onClickChangePage() {
        btnnhapms.setOnClickListener(new View.OnClickListener() { // xử lý click nhập mượn sách
            @Override
            public void onClick(View v) {
                date_timeTextInputEditText.setText(simpleDateFormat.format(calendar.getTime()));
                String masach = edtidmasach.getText().toString();
                String name = edthotenms.getText().toString();
                if(name.length()< 5){
                    Toast.makeText(getApplicationContext(),"Họ và tên phải lớn hơn 5 ký tự",Toast.LENGTH_LONG).show();
                    edthotenms.requestFocus(); // tự động quay trở về dòng điền tên
                    edthotenms.selectAll(); // bôi đen các chữ trong họ tên
                }
                String lopHC = edtlopms.getText().toString();
                String phoneMS = edtsdtms.getText().toString();
                if(phoneMS.length() != 10){
                    Toast.makeText(getApplicationContext(),"Số điện thoại phải đủ 10 chữ số",Toast.LENGTH_LONG).show();
                    edtsdtms.requestFocus(); // tự động quay trở về dòng số điện thoại
                    edtsdtms.selectAll(); // bôi đen các số điện thoại
                }
                String gmailMS = edtgmailms.getText().toString();
                String tenSach = edttensach.getText().toString();
                int thoiGian = Integer.parseInt(edtthoigianmuonms.getText().toString());
                try {
                    DangKyMuonSach.insertDangKy(masach,name,lopHC,phoneMS,gmailMS, date_timeTextInputEditText.getText().toString(),tenSach,thoiGian);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if(name.length()>5 &&masach.length()!=0 && lopHC.length()!=0 && gmailMS.length() !=0 && thoiGian > 0 && phoneMS.length() == 10){
                    Toast.makeText(NhapMuonSachActivity.this, "Nhập đăng ký mượn sách thành công", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(NhapMuonSachActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void Init() {
        // anh xa id
        btnback = findViewById(R.id.btnback); // anh xa id cho nút back
        edthotenms = findViewById(R.id.edthotenms); // anh xa id cho form ho ten
        edtlopms = findViewById(R.id.edtlopms); // anh xạ id cho form lớp
        edtsdtms = findViewById(R.id.edtsdtms); // ánh xạ id cho form nhập sdt
        edtgmailms = findViewById(R.id.edtgmailms); // ánh xạ id cho form nhập gmail
        date_timeTextInputEditText = findViewById(R.id.edtngaydangkyMS); // ánh xạ id cho form ngày mượn sách
        edtthoigianmuonms = findViewById(R.id.edtthoigianmuonms); // ánh xạ id cho form thời gian mượn sách
        edttensach = findViewById(R.id.edttensach);// ánh xạ id cho form tên sách
        edtidmasach = findViewById(R.id.edtidmasach); // anh xa id cho ma sach
        btnnhapms = findViewById(R.id.btnnhapms); // ánh xạ id cho button mượn sách

    }
}