
package dao;

import connectDB.ConnectDB;
import entity.ChiTietDichVu;
import entity.DichVu;
import entity.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author THANHTU
 */
public class Dao_ChiTietDichVu {
      //Lọc theo loại phòng
    public ResultSet locDV(String maHoaDon) {
	PreparedStatement preparedStatement = null;
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM ChiTietDichVu CTDV \n" +
                        "JOIN DichVu DV ON CTDV.maDichVu = DV.maDichVu\n" +
                        "JOIN SanPham SP ON SP.maSanPham = DV.maSanPham\n" +
                        "WHERE maHoaDon = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, maHoaDon);
            ResultSet rs = preparedStatement.executeQuery();          
            return rs;
	} catch (Exception e) {
            e.printStackTrace();
	}
        return null;
    }  
    
    //Thêm chi tiết dịch vụ
    public void addChiTietDichVu(ChiTietDichVu ctdv) {
	PreparedStatement preparedStatement = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "INSERT INTO ChiTietDichVu VALUES(?,?,?)";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, ctdv.getDichVu().getMaDichVu());
            preparedStatement.setString(2, ctdv.getHoaDon().getMaHoaDon());           
            preparedStatement.setInt(3,ctdv.getSoLuong());                        
            preparedStatement.executeUpdate();
	} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	}
    } 
    
    //Tìm theo mãHD
    public ChiTietDichVu timChiTietTheoMaHD(String maHD) {
        ChiTietDichVu chiTietDichVu = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM ChiTietDichVu CTDV \n" +
                        "JOIN DichVu DV ON CTDV.maDichVu = DV.maDichVu\n" +
                        "JOIN SanPham SP ON SP.maSanPham = DV.maSanPham\n" +
                        "WHERE maHoaDon = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DichVu dichVu = new DichVu(rs.getString("maDichVu"));
                HoaDon hoaDon = new HoaDon(rs.getString("maHoaDon"));
                Integer soLuong = rs.getInt("soLuong");
                chiTietDichVu = new ChiTietDichVu(dichVu, hoaDon, soLuong);
           }
	} catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietDichVu;
    }
    
    //Lấy danh sách theo mã
    public ArrayList<ChiTietDichVu> getDanhSachCTDichVu(String maHD){
        ArrayList<ChiTietDichVu> dsCTDichVu = new ArrayList<ChiTietDichVu>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM ChiTietDichVu CTDV JOIN DichVu DV ON CTDV.maDichVu = DV.maDichVu WHERE maHoaDon =  '"+maHD+"'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ChiTietDichVu ctdv = new ChiTietDichVu();       
                ctdv.setDichVu(new DichVu(rs.getString("maDichVu"),rs.getString("tenDichVu"), rs.getString("donViTinh")));
                ctdv.setHoaDon(new HoaDon(rs.getString("maHoaDon")));
                ctdv.setSoLuong(rs.getInt("soLuong"));                     
		dsCTDichVu.add(ctdv);
            }
	} catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsCTDichVu;
    }

    public void xoaChiTietDichVu(String maHoaDon, String maDichVu) {
	PreparedStatement preparedStatement = null;
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "DELETE FROM ChiTietDichVu WHERE maHoaDon = ? AND maDichVu = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, maHoaDon);
            preparedStatement.setString(2, maDichVu);          
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
	}
    }
    
    //Xóa chi tiết dịch vụ khi hủy phòng
    public void xoaChiTietDichVuKhiHuyPhong(String maHoaDon) {
	PreparedStatement preparedStatement = null;
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "DELETE FROM ChiTietDichVu WHERE maHoaDon = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, maHoaDon);         
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
	}
    }
    
    
    //Sửa CTDV
    public void suaCTDV(ChiTietDichVu ctdvNew ) {
	PreparedStatement ctdv= null;
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();	 
            String sql ="UPDATE ChiTietDichVu\n" +
                        "SET soLuong = ?\n" +
                        "WHERE maDichVu = ? AND maHoaDon = ?";
            ctdv = con.prepareStatement(sql);
            ctdv.setInt(1, ctdvNew.getSoLuong());
            ctdv.setString(2, ctdvNew.getDichVu().getMaDichVu());
            ctdv.setString(3, ctdvNew.getHoaDon().getMaHoaDon());       
            ctdv.executeUpdate();	
	} catch (Exception e) {
            e.printStackTrace();	
	}
    }
    

}
