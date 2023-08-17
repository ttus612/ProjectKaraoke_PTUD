/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp
 */
public class Dao_PhieuDat {
    public KhachHang getKhachHangTheoPhong(String maP){
        KhachHang kh = new KhachHang();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT maKhachHang from PhieuDatPhong where maPhong=?";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
               
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, maP);
               
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {                   
                return new KhachHang(rs.getString("maKhachHang"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_PhieuDat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public PhieuDatPhong getPhieuTheoMa(String maP){
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * from PhieuDatPhong where maPhieuDatPhong=?";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
               
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, maP);
               
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {     
                Phong phong = new Phong(rs.getString("maPhong"));
                NhanVien nv = new NhanVien(rs.getString("maNhanVien"));
                KhachHang kh = new KhachHang(rs.getString("maKhachHang"));
                Timestamp tgDat = rs.getTimestamp("thoiGianDat");
                Timestamp tgNhan = rs.getTimestamp("thoiGianNhanPhong");
                int sl = rs.getInt("soLuongNguoi");
                String ghiChu = rs.getString("ghiChu");
                return new PhieuDatPhong(ghiChu, phong, nv, kh, ghiChu, tgDat, tgNhan, sl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_PhieuDat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean taoPhieuDatPhong(PhieuDatPhong phieuDat){
        PreparedStatement preparedStatement = null;
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            String sql = "insert into PhieuDatPhong values(?,?,?,?,?,?,?,?)";
            preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1, phieuDat.getMaPhieuDatPhong());
            preparedStatement.setString(2, phieuDat.getPhong().getMaPhong());
            preparedStatement.setString(3, phieuDat.getNhanVien().getMaNhanVien());
            preparedStatement.setString(4, phieuDat.getKhachHang().getMaKhachHang());
            preparedStatement.setTimestamp(5, phieuDat.getThoiGianDat());
            preparedStatement.setTimestamp(6, phieuDat.getThoiGianNhanPhong());
            preparedStatement.setInt(7, phieuDat.getSoLuongNguoi());
            preparedStatement.setString(8, phieuDat.getGhiChu());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
		preparedStatement.close();
	} catch (Exception e2) {
		e2.printStackTrace();
		// TODO: handle exception
            }
	}
	return false;
    }
       
    public String getMaPhieuDatPhong() {
        String maPDP="";
        ConnectDB.getIntance();
        Connection con = ConnectDB.getConnection();
	String sql = "select CONCAT('PDP', RIGHT(CONCAT('000',ISNULL(right(max(maPhieuDatPhong),3),0) + 1),3)) from PhieuDatPhong where maPhieuDatPhong like  'PDP%'";
	try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                maPDP = rs.getString(1);
            }
	} catch (SQLException e) {
            e.printStackTrace();
	}
	return maPDP;
    }
    
    public PhieuDatPhong timPhieuDatPhongTheoMaPhong(String maP) {
        PhieuDatPhong phieuDatPhong = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM PhieuDatPhong WHERE maPhong = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maPhieuDatPhong = rs.getString("maPhieuDatPhong");
                Phong phong = new Phong(rs.getString("maPhong"));        
                NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
                KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
                Timestamp thoiGianDat = rs.getTimestamp("thoiGianDat");
                 Timestamp thoiGianNhanPhong = rs.getTimestamp("thoiGianNhanPhong");
                Integer soLuongNguoi = rs.getInt("soLuongNguoi");
                String ghiChu = rs.getString("ghiChu");
                phieuDatPhong = new PhieuDatPhong(maPhieuDatPhong, phong, nhanVien, khachHang, ghiChu, thoiGianDat, thoiGianNhanPhong, soLuongNguoi);
           }
	} catch (Exception e) {
            e.printStackTrace();
        }
        return phieuDatPhong;
    }
    
    
    public PhieuDatPhong getPhieuDatPhongTheoNgayVaTheoMa(String maPhong, Timestamp gioMoCua){
        PhieuDatPhong phieuDatPhong = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT TOP(1) * FROM PhieuDatPhong WHERE maPhong = ? and thoiGianDat >=? ORDER BY thoiGianDat DESC";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maPhong);
            ps.setTimestamp(2, gioMoCua);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maPhieuDatPhong = rs.getString("maPhieuDatPhong");
                Phong phong = new Phong(rs.getString("maPhong"));        
                NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
                KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
                Timestamp thoiGianDat = rs.getTimestamp("thoiGianDat");
                 Timestamp thoiGianNhanPhong = rs.getTimestamp("thoiGianNhanPhong");
                Integer soLuongNguoi = rs.getInt("soLuongNguoi");
                String ghiChu = rs.getString("ghiChu");
                phieuDatPhong = new PhieuDatPhong(maPhieuDatPhong, phong, nhanVien, khachHang, ghiChu, thoiGianDat, thoiGianNhanPhong, soLuongNguoi);
                
            }
	} catch (Exception e) {
            e.printStackTrace();
        }
        return phieuDatPhong ;
    }
    
    public Timestamp cachHienTai30Phut(Timestamp gioHienTai){
        Timestamp time = null;
        PreparedStatement ps = null;
        ConnectDB.getIntance();
        Connection con = ConnectDB.getConnection();
        String sql ="SELECT DATEADD(MINUTE, 30, '"+gioHienTai+"')";
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                time = rs.getTimestamp(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }	

    //Xóa  phiếu khi hủy phòng chờ
    public void xoaPhieuDatPhongKhiHuyPhong(String maPDP) {
	PreparedStatement preparedStatement = null;
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "DELETE FROM PhieuDatPhong WHERE  maPhieuDatPhong = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, maPDP);         
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
	}
    }
    
    
    public boolean capNhatTrangThaiPhongKhiNhanChuyenPhong(String maPhong,String maPDP){
        PreparedStatement ps = null;
        String sql="UPDATE PhieuDatPhong \n" +
                    "SET maPhong = ? \n" +
                    "WHERE maPhieuDatPhong =? ";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            ps = con.prepareStatement(sql);
            ps.setString(1, maPhong);
            ps.setString(2, maPDP);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public PhieuDatPhong getPhieuDatPhongTheoNgayNhanVaTheoMa(String maP, Timestamp gioMoCua){
        PhieuDatPhong phieuDatPhong = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM PhieuDatPhong WHERE datepart(yy, thoiGianNhanPhong) = ? and datepart(mm,thoiGianNhanPhong) = ? and datepart(dd,thoiGianNhanPhong)=? and maPhong = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 1900+gioMoCua.getYear());
            ps.setInt(2, gioMoCua.getMonth()+1);
            ps.setInt(3, gioMoCua.getDate());
            ps.setString(4, maP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maPhieuDatPhong = rs.getString("maPhieuDatPhong");
                Phong phong = new Phong(rs.getString("maPhong"));        
                NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
                KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
                Timestamp thoiGianDat = rs.getTimestamp("thoiGianDat");
                 Timestamp thoiGianNhanPhong = rs.getTimestamp("thoiGianNhanPhong");
                Integer soLuongNguoi = rs.getInt("soLuongNguoi");
                String ghiChu = rs.getString("ghiChu");
                phieuDatPhong = new PhieuDatPhong(maPhieuDatPhong, phong, nhanVien, khachHang, ghiChu, thoiGianDat, thoiGianNhanPhong, soLuongNguoi);
                //lst.add(phieuDatPhong);
            }
	} catch (Exception e) {
            e.printStackTrace();
        }
        return phieuDatPhong ;
    }
    
    public PhieuDatPhong getPhieuDatPhongTheoNgayNhanVaTheoMaPhongVaKhachHang(String maP,String maKH ,Timestamp gioMoCua){
        PhieuDatPhong phieuDatPhong = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM PhieuDatPhong WHERE datepart(yy, thoiGianNhanPhong) = ? and datepart(mm,thoiGianNhanPhong) = ? and datepart(dd,thoiGianNhanPhong)=? and maPhong = ? and maKhachHang=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 1900+gioMoCua.getYear());
            ps.setInt(2, gioMoCua.getMonth()+1);
            ps.setInt(3, gioMoCua.getDate());
            ps.setString(4, maP);
            ps.setString(5, maKH);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maPhieuDatPhong = rs.getString("maPhieuDatPhong");
                Phong phong = new Phong(rs.getString("maPhong"));        
                NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
                KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
                Timestamp thoiGianDat = rs.getTimestamp("thoiGianDat");
                 Timestamp thoiGianNhanPhong = rs.getTimestamp("thoiGianNhanPhong");
                Integer soLuongNguoi = rs.getInt("soLuongNguoi");
                String ghiChu = rs.getString("ghiChu");
                phieuDatPhong = new PhieuDatPhong(maPhieuDatPhong, phong, nhanVien, khachHang, ghiChu, thoiGianDat, thoiGianNhanPhong, soLuongNguoi);
                //lst.add(phieuDatPhong);
            }
	} catch (Exception e) {
            e.printStackTrace();
        }
        return phieuDatPhong ;
    }
    
    public ArrayList<PhieuDatPhong> getKhachHangChoTheoPhieuDatVaPhong(String maP,Timestamp gioMoCua){
        PhieuDatPhong phieuDatPhong = null;
        ArrayList<PhieuDatPhong> phieuDatPhongs = new ArrayList<>();
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM PhieuDatPhong WHERE maPhong = ? and datepart(yy, thoiGianNhanPhong) >= ? and datepart(mm,thoiGianNhanPhong) >= ? and datepart(dd,thoiGianNhanPhong)>? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maP);
            ps.setInt(2, 1900+gioMoCua.getYear());
            ps.setInt(3, gioMoCua.getMonth()+1);
            ps.setInt(4, gioMoCua.getDate());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maPhieuDatPhong = rs.getString("maPhieuDatPhong");
                Phong phong = new Phong(rs.getString("maPhong"));        
                NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
                KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
                Timestamp thoiGianDat = rs.getTimestamp("thoiGianDat");
                 Timestamp thoiGianNhanPhong = rs.getTimestamp("thoiGianNhanPhong");
                Integer soLuongNguoi = rs.getInt("soLuongNguoi");
                String ghiChu = rs.getString("ghiChu");
                phieuDatPhong = new PhieuDatPhong(maPhieuDatPhong, phong, nhanVien, khachHang, ghiChu, thoiGianDat, thoiGianNhanPhong, soLuongNguoi);
                phieuDatPhongs.add(phieuDatPhong);
            }
	} catch (Exception e) {
            e.printStackTrace();
        }
        return phieuDatPhongs ;
    }
    
}
