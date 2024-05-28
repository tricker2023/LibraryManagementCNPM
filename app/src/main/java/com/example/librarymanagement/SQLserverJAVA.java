package com.example.librarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQLserverJAVA extends AppCompatActivity {
    Button btnconnect = findViewById(R.id.btnconnect);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlserver_java);

        btnconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              getData(); // gọi hàm truy vấn dữ liệu
            }
        });
    }
    // ham ket noi csdl
    public Connection connectionSQLServer() {
        Connection connection = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); // Lấy tất cả quyền kết nối
            StrictMode.setThreadPolicy(policy);// thiết lập chính sách kết nối bao gồm tất cả các quyền
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            String connectString = "jdbc:jtds:sqlserver://192.168.1.17:1433;databasename=BanDoc;user=sinhvienFBU;password=123"; // địa chỉ kết nối
            connection = DriverManager.getConnection(connectString);
            Log.i("THONGBAO", "Kết nối thành công với SQL Server sử dụng net.sourceforge.jtds.jdbc.Driver");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    // hàm truy vấn dữ liệu
    public void getData(){
        String prod ="",des="";
        try {
            Connection connection = connectionSQLServer();
            if(connection!= null){
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM SACH"); // lấy dữ liệu từ bảng Sách
                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    prod = rs.getString(1);
                    des = rs.getString(2);
                    Log.i("DU_LIEU",prod+" - "+des);
                }
                ps.close();
                Toast.makeText(getApplicationContext(),"Đã thực thi Query",Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),prod+" --- "+des,Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}