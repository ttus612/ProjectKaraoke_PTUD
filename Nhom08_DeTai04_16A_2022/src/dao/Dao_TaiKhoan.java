package dao;

import connectDB.ConnectDB;
import entity.NhanVien;
import gui.model.ModelLogin;
import entity.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Dao_TaiKhoan {
    public TaiKhoan login(ModelLogin login) throws SQLException {
      
        connectDB.ConnectDB.getIntance().connect();
        Connection con = connectDB.ConnectDB.getConnection();
        TaiKhoan data = null;
        PreparedStatement p = con.prepareStatement("Select maTaiKhoan, maNhanvien, userName from TaiKhoan where maNhanvien=? and passWord=?");
        p.setString(1, login.getMaNV());
        p.setString(2, login.getPassword());
        ResultSet r = p.executeQuery();
        if(r.next()) {
            String maTaiKhoan  = r.getString(1);
            String maNhanvien = r.getString(2);
            String userName = r.getString(3);
           
            data = new TaiKhoan(maTaiKhoan, maNhanvien, userName, "");
        }
        r.close();
        p.close();
      
        return data;
    }

     public TaiKhoan GetTenUserLoginForThongKe(String login) throws SQLException {
        connectDB.ConnectDB.getIntance().connect();
        Connection con = connectDB.ConnectDB.getConnection();
        TaiKhoan data = null;
        PreparedStatement p = con.prepareStatement("Select maTaiKhoan, tk.maNhanvien, userName,tenNhanVien from TaiKhoan as tk  join NhanVien as nv on tk.maNhanvien=nv.maNhanVien  where tk.maNhanvien='"+login+"'");
        ResultSet r = p.executeQuery();
        if(r.next()) {
            String maTaiKhoan  = r.getString(1);
            String maNhanvien = r.getString(2);
            String userName = r.getString(4);
            data = new TaiKhoan(maTaiKhoan, maNhanvien, userName, "");
        }
        
        r.close();
        p.close();
      
        return data;
    }

        //Tìm theo mã
    public TaiKhoan timTKTheoMaNV(String maNV) {
        TaiKhoan tk = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM  TaiKhoan TK  WHERE maNhanVien = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maTaiKhoan= rs.getString("maTaiKhoan");
                String maNhanVien = rs.getString("maNhanvien");
                String userName = rs.getString("userName");
                String passWord = rs.getString("passWord");
                tk = new TaiKhoan(maTaiKhoan, maNhanVien, userName, passWord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tk;
    }
    
    public boolean forgotPassword(String email, String password) {
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            int n = -1;
            String sql = "UPDATE [dbo].[TaiKhoan]\n"
                + "   SET [passWord] = ? \n"
                + " WHERE email= ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, password);
            stmt.setString(2, email);
            n = stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}