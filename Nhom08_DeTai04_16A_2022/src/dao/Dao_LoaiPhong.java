
package dao;

import connectDB.ConnectDB;
import entity.LoaiPhong;
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
public class Dao_LoaiPhong {
     public ArrayList<LoaiPhong> getDanhSachLoaiPhong() {
        ArrayList<LoaiPhong> dsLoaiPhong = new ArrayList<LoaiPhong>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM LoaiPhong";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
		String maLoaiPhong = rs.getString("maLoaiPhong");
		String tenLoaiPhong = rs.getString("tenLoai");
                Integer sucChua = rs.getInt("sucChua");
                Double giaTien = rs.getDouble("giaTien");
                
		LoaiPhong loaiPhong = new LoaiPhong(maLoaiPhong, tenLoaiPhong, sucChua, giaTien);
		dsLoaiPhong.add(loaiPhong);
            }
	} catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
	}
      return dsLoaiPhong;
    }
     
    //Tìm theo mã
    public LoaiPhong timLoaiPhongTheoMa(String maLP) {
        LoaiPhong loaiPhong = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM LoaiPhong WHERE maLoaiPhong = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maLP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maLoaiPhong = rs.getString("maLoaiPhong");
                String tenLoaiPhong = rs.getString("tenLoai");
                Integer sucChua = rs.getInt("sucChua");  
                Double giaTien = rs.getDouble("giaTien");        
                loaiPhong = new LoaiPhong(maLoaiPhong, tenLoaiPhong, sucChua, giaTien);
           }
	} catch (Exception e) {
            e.printStackTrace();
        }
        return loaiPhong;
    }
}
