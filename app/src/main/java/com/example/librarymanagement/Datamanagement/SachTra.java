package com.example.librarymanagement.Datamanagement;

import com.example.librarymanagement.SQLmangemrnt.SQLmanagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class SachTra {
    private Integer IDtraSach;
    private String name;
    private String lopHC;
    private String phoneTS;
    private String gmailTS;
    private Date ngaydangkyMS;
    private Date ngayTraSach;
    private Double thanhToan;

    public static void insertTraSach(String IDtraSach, String name, String lopHC, String phoneTS, String gmailTS, String ngaydangkyMS, String ngayTraSach, Double thanhToan) throws SQLException {
        Connection connection = SQLmanagement.connectionSQLSever(); // Kết nối với SQL server
        Statement statement = connection.createStatement(); // tạo đối tượng statement
        // Tạo câu lệnh thêm dữ liệu vào SQL Server
        String sql ="insert into traSach(IDtraSach,hoTen,lopHanhChinh,SÐT,Gmail,NgayDangKy,NgayTra,ThanhToan) " +
                "values ('"+IDtraSach+"','"+name+"','"+lopHC+"','"+phoneTS+"','"+gmailTS+"','"+ngaydangkyMS+"','"+ngayTraSach+"','"+thanhToan+"')"; // tạo câu lệnh
        statement.execute(sql); // khởi chạy câu lệnh sql
        statement.close(); // đóng statement
        connection.close();// đóng kết nói sql
    }
    public Integer getIDtraSach() {
        return IDtraSach;
    }

    public void setIDtraSach(Integer IDtraSach) {
        this.IDtraSach = IDtraSach;
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

    public String getPhoneTS() {
        return phoneTS;
    }

    public void setPhoneTS(String phoneTS) {
        this.phoneTS = phoneTS;
    }

    public String getGmailTS() {
        return gmailTS;
    }

    public void setGmailTS(String gmailTS) {
        this.gmailTS = gmailTS;
    }

    public Date getNgaydangkyMS() {
        return ngaydangkyMS;
    }

    public void setNgaydangkyMS(Date ngaydangkyMS) {
        this.ngaydangkyMS = ngaydangkyMS;
    }

    public Date getNgayTraSach() {
        return ngayTraSach;
    }

    public void setNgayTraSach(Date ngayTraSach) {
        this.ngayTraSach = ngayTraSach;
    }

    public Double getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(Double thanhToan) {
        this.thanhToan = thanhToan;
    }


    public SachTra(Integer IDtraSach, String name, String lopHC, String phoneTS, String gmailTS, Date ngaydangkyMS, Date ngayTraSach, Double thanhToan) {
        this.IDtraSach = IDtraSach;
        this.name = name;
        this.lopHC = lopHC;
        this.phoneTS = phoneTS;
        this.gmailTS = gmailTS;
        this.ngaydangkyMS = ngaydangkyMS;
        this.ngayTraSach = ngayTraSach;
        this.thanhToan = thanhToan;
    }
}
















