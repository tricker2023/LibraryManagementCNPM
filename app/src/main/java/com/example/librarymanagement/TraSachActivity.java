package com.example.librarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.librarymanagement.Datamanagement.SachTra;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TraSachActivity extends AppCompatActivity {
    // khai báo các id
    private TextView datemuonSach,datetraSach;
    private ImageButton btnback;
    private TextInputEditText edtidtrasach,edthotents,edtlopts,edtsdtts,edtgmailts,edtngaymuonts,edtngaytra,edtthanhtoants;
    private Button btnnhapts;

    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy"); // hiển thị dữ liệu ngày tháng dưới dạng tháng , ngày ,năm
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tra_sach);
        Init();
        onClickChangePage();
        setClickDateTimeMS();
        setClickDateTimeTS();


        // xu ly click back
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // trở lại giao diện trước
                finish();
            }
        });
    }
    private void setClickDateTimeTS() {

        datemuonSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedDateTS(calendar,simpleDateFormat);
            }
        });
    }
    private void selectedDateTS(Calendar calendar,SimpleDateFormat simpleDateFormat){
        int day = calendar.get(Calendar.DATE); // gắn biến day là biến được lấy dữ liệu từ date trong lịch
        int month = calendar.get(Calendar.MONTH); // gắn biến month là biến được lấy dữ liệu từ month trong lịch
        int year = calendar.get(Calendar.YEAR); // gắn biến year là biến được lấy dữ liệu từ year trong lịch
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);

                datemuonSach.setText(simpleDateFormat.format(calendar.getTime())); // hiển thị các dữ liệu lên 1 dialog
            }
        }, year,month,day);
        datePickerDialog.show();
    }
    private void setClickDateTimeMS() {

        datetraSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedDateMS(calendar,simpleDateFormat);
            }
        });
    }
    private void selectedDateMS(Calendar calendar,SimpleDateFormat simpleDateFormat){
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);

                datetraSach.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, year,month,day);
        datePickerDialog.show();
    }
    private void onClickChangePage() {
        //xử lý click button nhập trả sách
        btnnhapts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String masach = edtidtrasach.getText().toString();
                String hoten = edthotents.getText().toString();
                if(hoten.length()< 5){
                    Toast.makeText(getApplicationContext(),"Họ và tên phải lớn hơn 5 ký tự",Toast.LENGTH_LONG).show();
                    edthotents.requestFocus(); // tự động quay trở về dòng điền tên
                    edthotents.selectAll(); // bôi đen các chữ trong họ tên
                }
                String lopHC = edtlopts.getText().toString();
                String sdt = edtsdtts.getText().toString();
                if(sdt.length() != 10){
                    Toast.makeText(getApplicationContext(),"Số điện thoại phải đủ 10 chữ số",Toast.LENGTH_LONG).show();
                    edtsdtts.requestFocus(); // tự động quay trở về dòng số điện thoại
                    edtsdtts.selectAll(); // bôi đen các số điện thoại
                }
                String gmailMS = edtgmailts.getText().toString();
                double thanhToan = Double.parseDouble(edtthanhtoants.getText().toString());
                String dateTS = datetraSach.getText().toString();
                String dateMS = datemuonSach.getText().toString();
                int check = dateMS.compareTo(dateTS);
                if(check>0){
                    Toast.makeText(TraSachActivity.this, "Ngày mượn sách > Ngày trả sách ", Toast.LENGTH_SHORT).show();
                }
                // gọi tới hàm insertTraSach bên sách trả của datamanagment
                try {
                    SachTra.insertTraSach(masach,hoten,lopHC,sdt,gmailMS,dateMS,dateTS,thanhToan);
                }catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if(hoten.length()>5 && masach.length()!=0 && lopHC.length()!=0 && sdt.length() == 10 && gmailMS.length() !=0 && thanhToan > 0 && check < 0){
                    Toast.makeText(TraSachActivity.this, "Nhập trả sách thành công", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(TraSachActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Init() {
        // anh xa id
        btnback = findViewById(R.id.btnback); // anh xa id cho nút back
        edthotents = findViewById(R.id.edthotents); // anh xa id cho form ho ten
        edtlopts = findViewById(R.id.edtlopts); // anh xạ id cho form lớp
        edtsdtts = findViewById(R.id.edtsdtts); // ánh xạ id cho form nhập sdt
        edtgmailts = findViewById(R.id.edtgmailts); // ánh xạ id cho form nhập gmail
        datemuonSach = findViewById(R.id.edtngaymuonts); // ánh xạ id cho form ngày mượn sách
        datetraSach = findViewById(R.id.edtngaytra); // ánh xạ id cho form ngày trả sách
        edtthanhtoants = findViewById(R.id.edtthanhtoants); // ánh xạ id cho form thanh toán
        edtidtrasach = findViewById(R.id.edtidtrasach); // ánh xạ id cho form trả sách
        btnnhapts = findViewById(R.id.btnnhapts); // ánh xạ id cho button nhập trả sách
    }
}
