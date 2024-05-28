package com.example.librarymanagement.Datamanagement;

import android.util.Log;

import com.example.librarymanagement.SQLmangemrnt.SQLmanagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DangKyMuonSach {
    private Integer IDmuonsach;
    private String name;
    private String lopHC;
    private String phoneMS;
    private String gmailMS;
    private String tenSach;
    private Date ngaydangkyMS;
    private Integer thoiGian;

    public DangKyMuonSach(Integer IDmuonsach,String name, String lopHC, String phoneMS, String gmailMS, String tenSach, Date ngaydangkyMS, Integer thoiGian) {
        this.IDmuonsach = IDmuonsach;
        this.name = name;
        this.lopHC = lopHC;
        this.phoneMS = phoneMS;
        this.gmailMS = gmailMS;
        this.tenSach = tenSach;
        this.ngaydangkyMS = ngaydangkyMS;
        this.thoiGian = thoiGian;
    }
    // tạo kết nối với csdl vào bảng dangkymuonsach
    public static void insertDangKy(String idMuonSach,String hoTen,String lopHanhChinh,String SÐT,String Gmail,String NgayDangKy,String tenSach,int ThoiGianMuon) throws SQLException {
        Connection connection = SQLmanagement.connectionSQLSever(); //Kết nối với SQL server
        Statement statement = connection.createStatement(); // Tạo đối tượng Statement
        // câu lệnh thêm dữ liệu vào sql server
        String sql = "INSERT INTO dangKyMuonSach (idMuonSach,hoTen,lopHanhChinh,SÐT,Gmail,NgayDangKy,tenSach,ThoiGianMuon) VALUES ('" +
                idMuonSach + "','" + hoTen + "','" + lopHanhChinh + "','" + SÐT + "','" + Gmail + "','" + NgayDangKy + "','" + tenSach + "'," + ThoiGianMuon + ")";

        Log.e("DATA",sql);
        statement.execute(sql); // thuc thi cau lenh
        statement.close(); // Dong doi tuong Statement
        connection.close(); // Dong ket noi
    }
    public Integer getIDmuonsach() {
        return IDmuonsach;
    }

    public void setIDmuonsach(Integer IDmuonsach) {
        this.IDmuonsach = IDmuonsach;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLopHC() {
        return lopHC;
    }

    public void setLopHC(String lopHC) {
        this.lopHC = lopHC;
    }

    public String getPhoneMS() {
        return phoneMS;
    }

    public void setPhoneMS(String phoneMS) {
        this.phoneMS = phoneMS;
    }

    public String getGmailMS() {
        return gmailMS;
    }

    public void setGmailMS(String gmailMS) {
        this.gmailMS = gmailMS;
    }

    public String getMaSach() {
        return tenSach;
    }

    public void setMaSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public Date getNgaydangkyMS() {
        return ngaydangkyMS;
    }

    public void setNgaydangkyMS(Date ngaydangkyMS) {
        this.ngaydangkyMS = ngaydangkyMS;
    }

    public Integer getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Integer thoiGian) {
        this.thoiGian = thoiGian;
    }
}


