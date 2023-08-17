
package dao;

import connectDB.ConnectDB;
import entity.TrangThaiPhong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author THANHTU
 */
public class Dao_TrangThaiPhong {
      public ArrayList<TrangThaiPhong> getDanhSachTrangThaiPhong() {
        ArrayList<TrangThaiPhong> dsTrangThaiPhong = new ArrayList<TrangThaiPhong>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM TrangThaiPhong";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
		String maTrangThaiPhong= rs.getString("maTrangThaiPhong");
		String tenTrangThaiPhong = rs.getString("tenTrangThaiPhong");                   
		TrangThaiPhong trangThaiPhong = new TrangThaiPhong(maTrangThaiPhong, tenTrangThaiPhong);
		dsTrangThaiPhong.add(trangThaiPhong);
            }
	} catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
	}
      return dsTrangThaiPhong;
    }
    
      //tìm trạng thái theo mã
    public TrangThaiPhong timTrangThaiPhongTheoMa(String maTT) {
        TrangThaiPhong trangThaiPhong = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM TrangThaiPhong WHERE maTrangThaiPhong = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maTT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maTrangThaiPhong = rs.getString("maTrangThaiPhong");
                String tenTrangThaiPhong = rs.getString("tenTrangThaiPhong");
  
                trangThaiPhong = new TrangThaiPhong(maTrangThaiPhong, tenTrangThaiPhong);
           }
	} catch (Exception e) {
            e.printStackTrace();
        }
        return trangThaiPhong;
    }
}
