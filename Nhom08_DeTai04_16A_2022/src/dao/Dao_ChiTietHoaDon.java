
package dao;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.Phong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp,THANHTU
 */
public class Dao_ChiTietHoaDon {
    public ChiTietHoaDon getChiTietHDTheoPhong(String maP){
           ChiTietHoaDon cthd = new ChiTietHoaDon();
           PreparedStatement preparedStatement = null;
           String sql = "SELECT * from ChiTietHoaDon where maPhong=?";
           try {
               connectDB.ConnectDB.getIntance().connect();
               Connection con = connectDB.ConnectDB.getConnection();
               
               preparedStatement = con.prepareStatement(sql);
               preparedStatement.setString(1, maP);
               
               ResultSet rs = preparedStatement.executeQuery();
               while (rs.next()) {                   
                   return new ChiTietHoaDon(new HoaDon(rs.getString("maHoaDon")), new Phong(rs.getString("maPhong")), rs.getInt("thoiLuongSuDung"));
               }
           } catch (SQLException ex) {
               Logger.getLogger(Dao_PhieuDat.class.getName()).log(Level.SEVERE, null, ex);
           }
           return null;
       }
    
    
    //Thêm chi tiết hóa đơn
    public void addChiTietHoaDON(ChiTietHoaDon cthd) {
	PreparedStatement preparedStatement = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "INSERT INTO ChiTietHoaDon VALUES(?,?,?)";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, cthd.getHoaDon().getMaHoaDon());
            preparedStatement.setString(2, cthd.getPhong().getMaPhong());
            preparedStatement.setInt(3,cthd.getThoiLuongSuDung());                        
            preparedStatement.executeUpdate();
	} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	}
    } 
    
    //Sửa thời lượng sử dụng
    public void suaThoiLuongSuDungChiTietHoaDon(ChiTietHoaDon chiTietHoaDonNew ) {
	PreparedStatement ps= null;
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();	 
            String sql = "UPDATE ChiTietHoaDon SET thoiLuongSuDung  = ? WHERE maHoaDon = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, chiTietHoaDonNew.getThoiLuongSuDung());
            ps.setString(2, chiTietHoaDonNew.getHoaDon().getMaHoaDon());
            ps.executeUpdate();	
	} catch (Exception e) {
            e.printStackTrace();	
	}
    }
    //Tìm theo mã
    public  ChiTietHoaDon timChiTietHDTheoMaHD(String maHD) {
        ChiTietHoaDon cthd = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM ChiTietHoaDon WHERE maHoaDon = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon(rs.getString("maHoaDon"));
                Phong phong = new Phong(rs.getString("maPhong"));
                Integer thoiLuongSuDung = rs.getInt("thoiLuongSuDung");
                cthd = new ChiTietHoaDon(hoaDon, phong, thoiLuongSuDung);
           }
	} catch (Exception e) {
            e.printStackTrace();
        }
        return cthd;
    }
    
        //Tìm theo mã
    public  ChiTietHoaDon timPhongTheoMaHD(String maHD) {
        ChiTietHoaDon cthd = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM ChiTietHoaDon WHERE maHoaDon = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon(rs.getString("maHoaDon"));
                Phong phong = new Phong(rs.getString("maPhong"));
                Integer thoiLuongSuDung = rs.getInt("thoiLuongSuDung");
                cthd = new ChiTietHoaDon(hoaDon, phong, thoiLuongSuDung);
           }
	} catch (Exception e) {
            e.printStackTrace();
        }
        return cthd;
    }
    
    
    //Xóa chi tiết hóa đơn khi hủy phòng
    public void xoaChiTietHoaDonKhiHuyPhong(String maHoaDon) {
	PreparedStatement preparedStatement = null;
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "DELETE FROM ChiTietHoaDon WHERE maHoaDon = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, maHoaDon);         
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
	}
    }
    
    //Tìm theo mã
    public  ChiTietHoaDon timChiTietHDTheoMaHDDeHuyHD(String maPhong) {
        ChiTietHoaDon cthd = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT TOP(1)  * FROM ChiTietHoaDon CTHD \n" +
                        "JOIN Phong P ON CTHD.maPhong = P.maPhong\n" +
                        "JOIN HoaDon HD ON CTHD.maHoaDon = HD.maHoaDon\n" +
                        "WHERE CTHD.maPhong  = ? AND maTrangThaiPhong = 'SD' \n" +
                        "ORDER BY CTHD.maHoaDon DESC";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maPhong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon(rs.getString("maHoaDon"));
                Phong phong = new Phong(rs.getString("maPhong"));
                Integer thoiLuongSuDung = rs.getInt("thoiLuongSuDung");
                cthd = new ChiTietHoaDon(hoaDon, phong, thoiLuongSuDung);
           }
	} catch (Exception e) {
            e.printStackTrace();
        }
        return cthd;
    }
    
    public boolean capNhatTrangThaiPhongKhiNhanChuyenPhong(String maPhong,String maHoaDon){
        PreparedStatement ps = null;
        String sql="UPDATE ChiTietHoaDon \n" +
                    "SET maPhong = ? \n" +
                    "WHERE maHoaDon =? ";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            ps = con.prepareStatement(sql);
            ps.setString(1, maPhong);
            ps.setString(2, maHoaDon);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
