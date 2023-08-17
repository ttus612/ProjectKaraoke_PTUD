/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.KhachHang;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class Dao_KhachHang {
    public ArrayList<KhachHang> getAllKhachHang(){
        ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
        String sql = "SELECT * from KhachHang";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                String maKhachHang = rs.getString("maKhachHang");
                String hoTenKhachHang = rs.getString("hoTenKhachHang");
                Date ngaySinh = rs.getDate("ngaySinh");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                String diaChi = rs.getString("diaChi");
                String cccd = rs.getString("CCCD");
                String soDienThoai = rs.getString("soDienThoai");
                dsKhachHang.add(new KhachHang(maKhachHang, hoTenKhachHang, cccd, soDienThoai, diaChi, ngaySinh,gioiTinh));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dsKhachHang;
    }
    
    public int getSoLuongKhachHang(){
        int total=0;
        String sql = "SELECT * from KhachHang";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                total+=1;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return total;
    }
    
    public ArrayList<String> getSoDienThoai(){
        ArrayList<String> sdt = new ArrayList<String>();
        String sql = "SELECT soDienThoai from KhachHang";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                String soDienThoai = rs.getString("soDienThoai");
                sdt.add(soDienThoai);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sdt;
    }
    
    
    
    public ArrayList<String> getMaKH(){
        ArrayList<String> maKH = new ArrayList<String>();
        String sql = "SELECT maKhachHang from KhachHang";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                String ma = rs.getString("maKhachHang");
                maKH.add(ma);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maKH;
    }
    
    public ArrayList<String> getCCCD(){
        ArrayList<String> maKH = new ArrayList<String>();
        String sql = "SELECT CCCD from KhachHang";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                String ma = rs.getString("CCCD");
                maKH.add(ma);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maKH;
    }
    
    public boolean themKhachHang(KhachHang kh){
        PreparedStatement preparedStatement = null;
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            String sql = "insert into KhachHang values(?,?,?,?,?,?,?)";
            preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1, kh.getMaKhachHang());
            preparedStatement.setString(2, kh.getHoTenKhachHang());
            preparedStatement.setDate(3, kh.getNgaySinh());
            preparedStatement.setBoolean(4, kh.isGioiTinh());
            preparedStatement.setString(5, kh.getDiaChi());
            preparedStatement.setString(6, kh.getCCDD());
            preparedStatement.setString(7, kh.getSoDienThoai());
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
    
    public boolean xoaKhachHang(String maKH){
        PreparedStatement ps = null;
	try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
			
            String sql = "delete from KhachHang where maKhachHang = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, maKH);
            ps.executeUpdate();
            return true;
	} catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Khách hàng này hiện đang có hóa đơn hoặc phiếu đặt phòng trong hệ thống nên không thể xóa",
                    "Thông báo", JOptionPane.OK_CANCEL_OPTION);
            return false;
	}
    }
   
    
    public boolean capNhapKhachHang(KhachHang khachHang){
        PreparedStatement ps= null;
		try {
			connectDB.ConnectDB.getIntance().connect();
			Connection con = connectDB.ConnectDB.getConnection();
			
			 
			String sql = "update KhachHang "
					+ "set hoTenKhachHang = ?, "
					+ "ngaySinh = ?, "
					+ "gioiTinh = ?, "
					+ "diaChi = ?, "
					+ "CCCD = ?, "
					+ "soDienThoai = ? "
					+ "where maKhachHang = ?";
			ps = con.prepareStatement(sql);
                        ps.setString(1, khachHang.getHoTenKhachHang());
                        ps.setDate(2, khachHang.getNgaySinh());
                        ps.setBoolean(3, khachHang.isGioiTinh());
                        ps.setString(4, khachHang.getDiaChi());
                        ps.setString(5, khachHang.getCCDD());
                        ps.setString(6, khachHang.getSoDienThoai());
                        ps.setString(7, khachHang.getMaKhachHang());
				
			ps.executeUpdate();
                        return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
        return false;
    }
    public ArrayList<KhachHang> timKhachHangTheoTen(String tenKH){
        PreparedStatement preparedStatement = null;
        ArrayList<KhachHang> dsKhachHang = new ArrayList<>();
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            String sql ="SELECT * from KhachHang where hoTenKhachHang=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, tenKH);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {                
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(rs.getString("maKhachHang"));
                kh.setHoTenKhachHang(rs.getString("hoTenKhachHang"));
                kh.setNgaySinh(rs.getDate("ngaySinh"));
                kh.setGioiTinh(rs.getBoolean("gioiTinh"));
                kh.setCCDD(rs.getString("CCCD"));
                kh.setDiaChi(rs.getString("diaChi"));
                kh.setSoDienThoai(rs.getString("soDienThoai"));
                dsKhachHang.add(kh);
                return dsKhachHang;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    ///////////Tìm/////////////////////
    public KhachHang getKhachHangTheoSDT(String sdt){
        PreparedStatement preparedStatement = null;
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            String sql ="SELECT * from KhachHang where soDienThoai=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, sdt);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {                
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(rs.getString("maKhachHang"));
                kh.setHoTenKhachHang(rs.getString("hoTenKhachHang"));
                kh.setNgaySinh(rs.getDate("ngaySinh"));
                kh.setGioiTinh(rs.getBoolean("gioiTinh"));
                kh.setCCDD(rs.getString("CCCD"));
                kh.setDiaChi(rs.getString("diaChi"));
                kh.setSoDienThoai(rs.getString("soDienThoai"));
                return kh;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public KhachHang getKhachHangTheoMa(String ma){
        PreparedStatement preparedStatement = null;
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            String sql ="SELECT * from KhachHang where maKhachHang=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, ma);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {                
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(rs.getString("maKhachHang"));
                kh.setHoTenKhachHang(rs.getString("hoTenKhachHang"));
                kh.setNgaySinh(rs.getDate("ngaySinh"));
                kh.setGioiTinh(rs.getBoolean("gioiTinh"));
                kh.setCCDD(rs.getString("CCCD"));
                kh.setDiaChi(rs.getString("diaChi"));
                kh.setSoDienThoai(rs.getString("soDienThoai"));
                return kh;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public KhachHang getKhachHangTheoCCCD(String cccd){
        PreparedStatement preparedStatement = null;
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            String sql ="SELECT * from KhachHang where CCCD=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, cccd);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {                
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(rs.getString("maKhachHang"));
                kh.setHoTenKhachHang(rs.getString("hoTenKhachHang"));
                kh.setNgaySinh(rs.getDate("ngaySinh"));
                kh.setGioiTinh(rs.getBoolean("gioiTinh"));
                kh.setCCDD(rs.getString("CCCD"));
                kh.setDiaChi(rs.getString("diaChi"));
                kh.setSoDienThoai(rs.getString("soDienThoai"));
                return kh;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public KhachHang getKhachHangTheoTenVaSDT(String ten, String sdt){
        PreparedStatement preparedStatement = null;
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            String sql ="SELECT * from KhachHang where hoTenKhachHang=? and soDienThoai=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, ten);
            preparedStatement.setString(2, sdt);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {                
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(rs.getString("maKhachHang"));
                kh.setHoTenKhachHang(rs.getString("hoTenKhachHang"));
                kh.setNgaySinh(rs.getDate("ngaySinh"));
                kh.setGioiTinh(rs.getBoolean("gioiTinh"));
                kh.setCCDD(rs.getString("CCCD"));
                kh.setDiaChi(rs.getString("diaChi"));
                kh.setSoDienThoai(rs.getString("soDienThoai"));
                return kh;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public KhachHang getKhachHangTheoTenVaCCCD(String ten, String cccd){
        PreparedStatement preparedStatement = null;
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            String sql ="SELECT * from KhachHang where hoTenKhachHang=? and CCCD=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, ten);
            preparedStatement.setString(2, cccd);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {                
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(rs.getString("maKhachHang"));
                kh.setHoTenKhachHang(rs.getString("hoTenKhachHang"));
                kh.setNgaySinh(rs.getDate("ngaySinh"));
                kh.setGioiTinh(rs.getBoolean("gioiTinh"));
                kh.setCCDD(rs.getString("CCCD"));
                kh.setDiaChi(rs.getString("diaChi"));
                kh.setSoDienThoai(rs.getString("soDienThoai"));
                return kh;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
