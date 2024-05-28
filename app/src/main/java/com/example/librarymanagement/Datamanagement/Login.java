package com.example.librarymanagement.Datamanagement;

import com.example.librarymanagement.SQLmangemrnt.SQLmanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Login {
    String User;
    String pass;
    public Login(){
        User = "";
        pass = "";
    };
    public Login(String user, String pass) {
        User = user;
        this.pass = pass;
    }
    public static Login getuserlist(String user,String pass) throws SQLException{
        Connection connection = SQLmanagement.connectionSQLSever();
        Login login = new Login();
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        // lấy ra iduser có giá trị là user vừa nhập vào và passuser có giá trị là pass vừa nhập
        String sql = "SELECT*FROM LOGINS WHERE IDUSER ='" + user +"' AND PASSUSER ='" + pass +"'";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            login = new Login(
                    rs.getString(1).trim(),
                    rs.getString(2).trim());// Đọc dữ liệu từ ResultSet

        }
        statement.close(); // tắt đối tượng statement
        connection.close();// Đóng kết nối
        return login;
    }
    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
