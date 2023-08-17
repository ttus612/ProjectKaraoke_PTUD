
package dao;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.LoaiNhanVien;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.Phong;
import entity.TrangThaiPhong;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author THANHTU
 */
public class Dao_DatPhong {

    private LocalDate now;
    private Date dNow;
    
    /**
    * 
    * @param maPhong
    * @param trangThaiPhong
    * @return cập nhập mã phòng và trạng thái phòng
    */

    public boolean capnhatTrangThaiPhong(String maPhong, String trangThaiPhong) {		
	PreparedStatement stmt = null;
	int n=0;
	try {
            ConnectDB.getIntance();
            Connection con = ConnectDB.getConnection();
            stmt = con.prepareStatement("UPDATE Phong SET maTrangThaiPhong =  ? WHERE maPhong =  ?");
            stmt.setString(1, trangThaiPhong);
	    stmt.setString(2, maPhong);
	    n = stmt.executeUpdate();
	} catch (SQLException e) {
	    // TODO: handle exception
	    e.printStackTrace();
	} finally {
	    try {
		stmt.close();
	    } catch (SQLException e2) {
	        // TODO: handle exception
		e2.printStackTrace();
	    }
        }
	return n>0;
    }
         
    //Load 1 NV dang lam viec theo manv
    public NhanVien getMaNV(String info) { 
        NhanVien nv = new NhanVien();
        ConnectDB.getIntance();
        Connection con = ConnectDB.getConnection();
        String sqlMa = "select [maNhanVien] from [dbo].[NhanVien] where maNhanVien = '"+info+"'";	
        try {
            Statement stm = con.createStatement();
            ResultSet rsMa = stm.executeQuery(sqlMa);
            while(rsMa.next()) {
                nv.setMaNhanVien(rsMa.getString(1));			                                                 
            }			
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nv;
    }
        
    //phát sinh mã
    public String taoMaHoaDonTuDong() {
	String strMaHD = null;
	PreparedStatement s = null;
	String sql = "select top 1 maHoaDon from HoaDon order by maHoaDon desc";
	try {
            s = ConnectDB.getConnection().prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                strMaHD = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tạo mã HĐ");
            return "";
	} finally {
            try {
                s.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
	if (strMaHD == null) {
            strMaHD = "HDA000000000";
	}
        String strSo = strMaHD.substring(3,6);
                
        Integer intMaHD = Integer.parseInt(strSo);
              
        char strA = 0 ;
        if (intMaHD <999) {
            strA = 'A';
        }else{
            strA = 'B';
        }
                
	if (intMaHD == 99) {
            if (strSo.equals("ZZ")) {
                return "error! (out of memory)";
            } else if (strSo.codePointAt(1) == 90) {
                int temp = strSo.codePointAt(0) + 1;
                strSo = (char) temp + "B";
		intMaHD = 0;
            } else {
                int temp = strSo.codePointAt(0);
                int temp1 = strSo.codePointAt(1) + 1;
                strSo = (char) temp + "" + (char) temp1;
                intMaHD = 0;
            }
        }else {
            intMaHD += 1;
        }
                
        java.util.Date dateNow = new java.util.Date();
        SimpleDateFormat dfNgay = new SimpleDateFormat("ddMMyy");
                
        if (intMaHD < 100) {
            strMaHD = "HD"+ strA+"0"+ intMaHD + dfNgay.format(dateNow) ;
        }else{
            strMaHD = "HD"+ strA+ intMaHD + dfNgay.format(dateNow) ;
        }
        return strMaHD;
    }
        
    
        
}
