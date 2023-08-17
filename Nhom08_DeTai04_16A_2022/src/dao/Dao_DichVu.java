/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.DichVu;
import entity.SanPham;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class Dao_DichVu {
    public ArrayList<DichVu> getDanhSachDichVu(){
        ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM DichVu DV JOIN SanPham SP ON DV.maSanPham = SP.maSanPham";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                DichVu dv = new DichVu();
                dv.setMaDichVu(rs.getString("maDichVu"));
                dv.setSanPham(new SanPham(rs.getString("maSanPham"), rs.getString("tenSanPham")));
                dv.setTenDichVu(rs.getString("tenDichVu"));
                dv.setDonViTinh(rs.getString("donViTinh"));
                dv.setHinhAnh(rs.getString("hinhAnh")); 
                dv.setTrangThaiDichVu(rs.getBoolean("trangThaiDichVu"));                        
		dsDichVu.add(dv);
            }
	} catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsDichVu;
    }
    
    //Phát sinh mã tự động
    public String getMaDVTuDong() {
        String maDV="";
        ConnectDB.getIntance();
        Connection con = ConnectDB.getConnection();
        String sql = "select CONCAT('DV', RIGHT(CONCAT('000',ISNULL(right(max(maDichVu),3),0) + 1),3)) from DichVu where maDichVu like  'DV%'";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
            maDV = rs.getString(1);			}
	} catch (SQLException e) {
            e.printStackTrace();
	}
	return maDV;
    }
    //thêm dịch vụ
    public void addDichVU(DichVu dv) {
	PreparedStatement preparedStatement = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "INSERT INTO DichVu VALUES(?,?,?,?,?,?)";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, dv.getMaDichVu());
            preparedStatement.setString(2, dv.getSanPham().getMaSanPham());          
            preparedStatement.setString(3, dv.getTenDichVu());            
            preparedStatement.setString(4, dv.getDonViTinh());           
            preparedStatement.setString(5, dv.getHinhAnh());
            preparedStatement.setBoolean(6, dv.isTrangThaiDichVu());                     
            preparedStatement.executeUpdate();
	} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	}
    } 
    //Xóa dịch vụ
    public void xoaDichVu(String maDichVu) {
	PreparedStatement preparedStatement = null;
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "DELETE FROM DichVu WHERE maDichVu = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, maDichVu);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
	}
    }
     //Sửa dịch vụ
    public void suaDichVu(DichVu dichVuNew ) {
	PreparedStatement ps= null;
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();	 
            String sql = "UPDATE DichVu SET maSanPham = ?, tenDichVu = ?,donViTinh = ?,hinhAnh = ?,trangThaiDichVu = ? WHERE maDichVu = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, dichVuNew.getSanPham().getMaSanPham());
            ps.setString(2, dichVuNew.getTenDichVu());
            ps.setString(3, dichVuNew.getDonViTinh());
            ps.setString(4, dichVuNew.getHinhAnh());  
            ps.setBoolean(5, dichVuNew.isTrangThaiDichVu());  
            ps.setString(6, dichVuNew.getMaDichVu());
            ps.executeUpdate();	
	} catch (Exception e) {
            e.printStackTrace();	
	}
    }
    
    //Tìm 
    //Tìm theo mã
    public DichVu timDichVuTheoMa(String maDV) {
        DichVu dichVu = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM DichVu WHERE maDichVu = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maDV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maDichVu = rs.getString("maDichVu");
                SanPham sanPham = new SanPham(rs.getString("maSanPham"));        
                String tenDichVu = rs.getString("tenDichVu");
                String donViTinh = rs.getString("donViTinh");  
                String hinhAnh  = rs.getString("hinhAnh");
                Boolean trangThaiDichVu = rs.getBoolean("trangThaiDichVu");
                dichVu = new DichVu(maDichVu, sanPham, tenDichVu, donViTinh, hinhAnh, trangThaiDichVu);
           }
	} catch (Exception e) {
            e.printStackTrace();
        }
        return dichVu;
    }
    
    //Tìm theo tenDV
    public DichVu timDichVuTheoTenDV(String tenDV) {
        DichVu dichVu = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM DichVu WHERE tenDichVu = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenDV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maDichVu = rs.getString("maDichVu");
                SanPham sanPham = new SanPham(rs.getString("maSanPham"));        
                String tenDichVu = rs.getString("tenDichVu");
                String donViTinh = rs.getString("donViTinh");  
                String hinhAnh  = rs.getString("hinhAnh");
                Boolean trangThaiDichVu = rs.getBoolean("trangThaiDichVu");
                dichVu = new DichVu(maDichVu, sanPham, tenDichVu, donViTinh, hinhAnh, trangThaiDichVu);
           }
	} catch (Exception e) {
            e.printStackTrace();
        }
        return dichVu;
    }
    //Tìm theo tên
    public ArrayList<DichVu> timTheoTenDichVu(String tt) {
	ArrayList<DichVu> lstP = new ArrayList<DichVu>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();

            String sql = "SELECT * FROM DichVu WHERE tenDichVu = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {              
                String maDichVu = rs.getString("maDichVu");
                SanPham sanPham = new SanPham(rs.getString("maSanPham"));        
                String tenDichVu = rs.getString("tenDichVu");
                String donViTinh = rs.getString("donViTinh");  
                String hinhAnh  = rs.getString("hinhAnh");
                Boolean trangThaiDichVu = rs.getBoolean("trangThaiDichVu");
                DichVu dv = new DichVu(maDichVu, sanPham, tenDichVu, donViTinh, hinhAnh, trangThaiDichVu);
                lstP.add(dv);
            }
        } catch (Exception e) {
            e.printStackTrace();
	}
	return lstP;
    }
    //Tìm theo đơn vị tính
    public ArrayList<DichVu> timTheoDonViTinh(String tt) {
	ArrayList<DichVu> lstP = new ArrayList<DichVu>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();

            String sql = "SELECT * FROM DichVu WHERE donViTinh = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {            
                String maDichVu = rs.getString("maDichVu");
                SanPham sanPham = new SanPham(rs.getString("maSanPham"));        
                String tenDichVu = rs.getString("tenDichVu");
                String donViTinh = rs.getString("donViTinh");  
                String hinhAnh  = rs.getString("hinhAnh");
                Boolean trangThaiDichVu = rs.getBoolean("trangThaiDichVu");
                DichVu dv = new DichVu(maDichVu, sanPham, tenDichVu, donViTinh, hinhAnh, trangThaiDichVu);
                lstP.add(dv);
            }
        } catch (Exception e) {
            e.printStackTrace();
	}
	return lstP;
    }
    //Tìm theo mã sản phẩm
    public ArrayList<DichVu> timTheoMaSanPham(String tt) {
	ArrayList<DichVu> lstP = new ArrayList<DichVu>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();

            String sql = "SELECT * FROM DichVu WHERE maSanPham = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {            
                String maDichVu = rs.getString("maDichVu");
                SanPham sanPham = new SanPham(rs.getString("maSanPham"));        
                String tenDichVu = rs.getString("tenDichVu");
                String donViTinh = rs.getString("donViTinh");  
                String hinhAnh  = rs.getString("hinhAnh");
                Boolean trangThaiDichVu = rs.getBoolean("trangThaiDichVu");
                DichVu dv = new DichVu(maDichVu, sanPham, tenDichVu, donViTinh, hinhAnh, trangThaiDichVu);
                lstP.add(dv);
            }
        } catch (Exception e) {
            e.printStackTrace();
	}
	return lstP;
    }
    
    //Tìm theo trạng thái phục vụ
    public ArrayList<DichVu> timTheoTrangThaiDichVu(Boolean tt) {
	ArrayList<DichVu> lstP = new ArrayList<DichVu>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();

            String sql = "SELECT * FROM DichVu WHERE trangThaiDichVu = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {            
                String maDichVu = rs.getString("maDichVu");
                SanPham sanPham = new SanPham(rs.getString("maSanPham"));        
                String tenDichVu = rs.getString("tenDichVu");
                String donViTinh = rs.getString("donViTinh");  
                String hinhAnh  = rs.getString("hinhAnh");
                Boolean trangThaiDichVu = rs.getBoolean("trangThaiDichVu");
                DichVu dv = new DichVu(maDichVu, sanPham, tenDichVu, donViTinh, hinhAnh, trangThaiDichVu);
                lstP.add(dv);
            }
        } catch (Exception e) {
            e.printStackTrace();
	}
	return lstP;
    }
    
    //Tìm theo mã sản phẩm
    public ArrayList<DichVu> timTheoTenLoaiSanPham(String tenLSP) {
	ArrayList<DichVu> lstP = new ArrayList<DichVu>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();

            String sql = "SELECT * FROM DichVu DV \n" +
                        "JOIN SanPham SP ON DV.maSanPham = SP.maSanPham\n" +
                        "JOIN LoaiSanPham LSP ON LSP.maLoaiSanPham = SP.maLoaiSanPham\n" +
                        "WHERE tenLoaiSanPham =	N'?'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenLSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {            
                String maDichVu = rs.getString("maDichVu");
                SanPham sanPham = new SanPham(rs.getString("maSanPham"));        
                String tenDichVu = rs.getString("tenDichVu");
                String donViTinh = rs.getString("donViTinh");  
                String hinhAnh  = rs.getString("hinhAnh");
                Boolean trangThaiDichVu = rs.getBoolean("trangThaiDichVu");
                DichVu dv = new DichVu(maDichVu, sanPham, tenDichVu, donViTinh, hinhAnh, trangThaiDichVu);
                lstP.add(dv);
            }
        } catch (Exception e) {
            e.printStackTrace();
	}
	return lstP;
    }
    
    public ArrayList<DichVu> getDanhSachDichVuTheoTen(String ten){
        ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM DichVu DV \n" +
                        "JOIN SanPham SP ON DV.maSanPham = SP.maSanPham\n" +
                        "JOIN LoaiSanPham LSP ON LSP.maLoaiSanPham = SP.maLoaiSanPham\n" +
                        "WHERE tenLoaiSanPham =	N'"+ten+"'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                DichVu dv = new DichVu();
                dv.setMaDichVu(rs.getString("maDichVu"));
                dv.setSanPham(new SanPham(rs.getString("maSanPham")));
                dv.setTenDichVu(rs.getString("tenDichVu"));
                dv.setDonViTinh(rs.getString("donViTinh"));
                dv.setHinhAnh(rs.getString("hinhAnh")); 
                dv.setTrangThaiDichVu(rs.getBoolean("trangThaiDichVu"));                        
		dsDichVu.add(dv);
            }
	} catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsDichVu;
    }
}
