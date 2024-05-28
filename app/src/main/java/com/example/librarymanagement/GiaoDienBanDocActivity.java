package com.example.librarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GiaoDienBanDocActivity extends AppCompatActivity {
    // Khai bao cac ten id
    private Button btnxemThongtin,btndangkyms,btntrasach,btnthanhtoan,btnlogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_dien_ban_doc);
        Init();


        // xu ly click button xem thong tin sach
        btnxemThongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent xemttintent = new Intent(GiaoDienBanDocActivity.this, XemThongTinBookActivity.class); // khoi tao Intent xem thong tin
                startActivity(xemttintent); // bat dau intent
            }
        });
        // xu ly click button dang ky muon sach
        btndangkyms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dangkymsintent = new Intent(GiaoDienBanDocActivity.this, NhapMuonSachActivity.class); // khoi tao Intent dang ky muon sach
                startActivity(dangkymsintent); // bat dau Intent
            }
        });
        // xu ly click button tra sach
        btntrasach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trasachintent = new Intent(GiaoDienBanDocActivity.this, TraSachActivity.class);  // khoi tao Intent tra sach
                startActivity(trasachintent);
            }
        });
        // xu ly click button thanh toan
        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thanhtoanintent = new Intent(GiaoDienBanDocActivity.this, ThanhToanActivity.class); // khoi tao Intent thanh toan
                startActivity(thanhtoanintent);
            }
        });

        // xử lý click button đăng xuất
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Init() {
        // anh xa id cho tung button
        btnxemThongtin = findViewById(R.id.btnxemThongtin);
        btndangkyms = findViewById(R.id.btndangkyms);
        btntrasach = findViewById(R.id.btntrasach);
        btnthanhtoan = findViewById(R.id.btnthanhtoan);
        btnlogout = findViewById(R.id.btnlogout);
    }
}