/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiNhanVien;
import entity.LoaiPhong;
import entity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author giahy
 */
public class Dao_ThongKe {
    public ArrayList<HoaDon> getAllHoaDon(){
        ArrayList<HoaDon> dsHoaDon  = new ArrayList<HoaDon>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "select *from HoaDon as hd Join ChiTietHoaDon as ct  on hd.maHoaDon= ct.maHoaDon join Phong as p on  ct.maPhong =p.maPhong join nhanVien as nv on hd.maNhanVien=nv.maNhanVien join khachHang as kh on hd.maKhachHang=kh.maKhachHang";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maHoaDon=rs.getString("maHoaDon");
                String maKhachHang=rs.getString("maKhachHang");
		String ngayLap=rs.getString("ngayLap");
                Double tongTien=rs.getDouble("tongTien");
                String maLoaiPhong=rs.getString("maLoaiPhong");
                LoaiPhong lp=new LoaiPhong(maLoaiPhong);
                NhanVien nv=new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"),rs.getString("soDienThoai"),rs.getString("DiaChi"));
                KhachHang kh=new KhachHang(rs.getString("maKhachHang"),rs.getString("hoTenKhachHang"),rs.getString("soDienThoai"));
                HoaDon hd=new HoaDon(maHoaDon, LocalDate.parse(ngayLap),tongTien,lp,nv,kh);
                dsHoaDon.add(hd);
            }
	} catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsHoaDon;
    }
    //tHAY doi 
      public List<HoaDon> LocDanhSachHoaDonNgayThangNam(String ngay,String thang,String nam ) throws SQLException {
		String sql = "SELECT *FROM HoaDon WHERE year(ngayLap)=? and month(ngayLap)=? and day(ngayLap)=? " ;
//                 String sql1= "SELECT *FROM HoaDon";
		PreparedStatement statement = null;           
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			 statement = ConnectDB.getConnection().prepareStatement(sql);
                         statement.setString(1, nam);
                         statement.setString(2, thang);
                         statement.setString(3, ngay);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
                                KhachHang kh=new KhachHang(rs.getString("maKhachHang"));
				 HoaDon hd=new HoaDon(rs.getString("maHoaDon"),kh, LocalDate.parse(rs.getString("ngayLap")),rs.getDouble("tongTien"));
				list.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
      
      
      //bang thong ke tong so hoa don khach hang
       public List<KhachHang> LocDanhSachHoaDonNgayThangNamKhachHang(String ngayThongKe) throws SQLException {
//		String sql = "select *from HoaDon as hd join KhachHang as kh on hd.maKhachHang=kh.maKhachHang where YEAR(ngayLap)=? and MONTH(ngayLap)=? and day(ngayLap)=?" ;
//                 String sql1= "SELECT *FROM HoaDon";
                 String sql="SELECT kh.hoTenKhachHang,hd.maKhachHang,hd.ngayLap ,kh.soDienThoai, SUM(tongTien) as tongTien ,count(hd.maHoaDon) AS soHoaDon\n" +
"  FROM HoaDon as hd JOIN KhachHang AS kh ON  hd.maKhachHang=kh.maKhachHang  where ngayLap='"+ngayThongKe+"'\n" +
"  GROUP BY hd.maKhachHang ,kh.hoTenKhachHang,hd.ngayLap,kh.soDienThoai order by sum(tongTien) desc;";
                
		PreparedStatement statement = null;           
		List<KhachHang> list = new ArrayList<KhachHang>();
		try {
			 statement = ConnectDB.getConnection().prepareStatement(sql);
//                         statement.setString(1, nam);
//                         statement.setString(2, thang);
//                         statement.setString(3, ngay);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {  
                               KhachHang khs=new KhachHang(rs.getString("maKhachHang"),rs.getString("hoTenKhachHang"),rs.getString("soDienThoai"));
                               HoaDon hd=new HoaDon(khs, LocalDate.parse(rs.getString("ngayLap")),rs.getDouble("tongTien"),rs.getInt("soHoaDon"));
                               KhachHang kh =new KhachHang(rs.getString("maKhachHang"), rs.getString("hoTenKhachHang"), rs.getString("soDienThoai"),hd);	
                               list.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
    
      //ThayDOI
         public List<HoaDon> LocDanhSachHoaDonTheoThangNam(String nam,String thang) throws SQLException {
            
		String sql = "SELECT *FROM HoaDon WHERE year(ngayLap)=? and month(ngayLap)=?" ;
//                 String sql1= "SELECT *FROM HoaDon";
		PreparedStatement statement = null;           
		List<HoaDon> listtheoThangNam = new ArrayList<HoaDon>();
		try {
			 statement = ConnectDB.getConnection().prepareStatement(sql);
                         statement.setString(1, nam);
                         statement.setString(2, thang);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
                                 KhachHang kh=new KhachHang(rs.getString("maKhachHang"));
				 HoaDon hd=new HoaDon(rs.getString("maHoaDon"),kh, LocalDate.parse(rs.getString("ngayLap")),rs.getDouble("tongTien"));
				 listtheoThangNam.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listtheoThangNam;
	}
  
      
             public List<HoaDon> LocDanhSachHoaDonNgayThangNamNhanVien(String nam,String thang,String ngay,String manv) throws SQLException {
		String sql = "select *from HoaDon AS hd join NhanVien AS nv on hd.maNhanVien =nv.maNhanVien where YEAR(hd.ngayLap)=? and MONTH(hd.ngayLap)=? and day(hd.ngayLap)=? and nv.maNhanVien=? " ;
//                 String sql1= "SELECT *FROM HoaDon";
                
		PreparedStatement statement = null;           
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			 statement = ConnectDB.getConnection().prepareStatement(sql);
                         statement.setString(1, nam);
                         statement.setString(2, thang);
                         statement.setString(3, ngay);
                           statement.setString(4, manv);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {  
                             
                                NhanVien nv=new NhanVien(rs.getString("maNhanVien"),rs.getString("tenNhanVien"),rs.getString("soDienThoai"),rs.getString("diaChi"));
                                HoaDon hd=new HoaDon(rs.getString("maHoaDon"),rs.getDouble("tongTien"),nv);
                               	
                                list.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
                
                
		return list;
	}
             
             
              public ArrayList<HoaDon> getAllHoaDonNhanVien(String maNhanVien){
        ArrayList<HoaDon> dsHoaDon  = new ArrayList<HoaDon>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "select *from HoaDon as hd Join ChiTietHoaDon as ct  on hd.maHoaDon= ct.maHoaDon join Phong as p on  ct.maPhong =p.maPhong join nhanVien as nv on hd.maNhanVien=nv.maNhanVien  join khachHang as kh on hd.maKhachHang=kh.maKhachHang  where hd.maNhanVien ='"+maNhanVien+"'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maHoaDon=rs.getString("maHoaDon");
                String maKhachHang=rs.getString("maKhachHang");
		String ngayLap=rs.getString("ngayLap");
                Double tongTien=rs.getDouble("tongTien");
                String maLoaiPhong=rs.getString("maLoaiPhong");
                LoaiPhong lp=new LoaiPhong(maLoaiPhong);
                String maNhanViens=rs.getString("maNhanVien");
                String tenNhanViens=rs.getString("tenNhanVien");
                NhanVien nv=new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"),rs.getString("soDienThoai"),rs.getString("DiaChi"));
                KhachHang kh=new KhachHang(rs.getString("maKhachHang"),rs.getString("hoTenKhachHang"),rs.getString("soDienThoai"));
                HoaDon hd=new HoaDon(maHoaDon, LocalDate.parse(ngayLap),tongTien,lp,nv,kh);
               
                dsHoaDon.add(hd);
            }
	} catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsHoaDon;
    }
        //Thay Doi      
               public List<HoaDon> LocDanhSachHoaDonNgayThangNamTheoNhanVien(String ngay,String thang,String nam ,String maNhanVien) throws SQLException {
		String sql = "SELECT *FROM HoaDon WHERE year(ngayLap)=? and month(ngayLap)=? and day(ngayLap)=?  and maNhanVien= '"+maNhanVien+"'  " ;
//                 String sql1= "SELECT *FROM HoaDon";
		PreparedStatement statement = null;           
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			 statement = ConnectDB.getConnection().prepareStatement(sql);
                         statement.setString(1, nam);
                         statement.setString(2, thang);
                         statement.setString(3, ngay);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
                                KhachHang kh=new KhachHang(rs.getString("maKhachHang"));
				 HoaDon hd=new HoaDon(rs.getString("maHoaDon"),kh, LocalDate.parse(rs.getString("ngayLap")),rs.getDouble("tongTien"));
				list.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
               
               
               
               public List<HoaDon> LocDanhSachHoaDonTheoThangNamNhanVien(String nam,String thang,String maNhanVien) throws SQLException {
		String sql = "SELECT *FROM HoaDon WHERE year(ngayLap)=? and month(ngayLap)=? and maNhanVien='"+maNhanVien+"'" ;
//                 String sql1= "SELECT *FROM HoaDon";
		PreparedStatement statement = null;           
		List<HoaDon> listtheoThangNam = new ArrayList<HoaDon>();
		try {
			 statement = ConnectDB.getConnection().prepareStatement(sql);
                         statement.setString(1, nam);
                         statement.setString(2, thang);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
                              KhachHang kh=new KhachHang(rs.getString("maKhachHang"));
				 HoaDon hd=new HoaDon(rs.getString("maHoaDon"),kh, LocalDate.parse(rs.getString("ngayLap")),rs.getDouble("tongTien"));
				 listtheoThangNam.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listtheoThangNam;
	}
               
               
                public List<HoaDon> LocDanhSachHoaDonKhachHangTheoThangNam(String nam) throws SQLException {
		String sql = "SELECT top 3 kh.hoTenKhachHang,hd.maKhachHang,kh.soDienThoai,MONTH(ngayLap) as thang, SUM(tongTien) as tongTien ,count(hd.maHoaDon) AS soHoaDon\n" +
"FROM HoaDon as hd JOIN KhachHang AS kh ON  hd.maKhachHang=kh.maKhachHang where YEAR(ngayLap)='"+nam+"'\n" +
"GROUP BY hd.maKhachHang ,kh.hoTenKhachHang, kh.soDienThoai,MONTH(ngayLap) order by sum(tongTien) desc;" ;
		PreparedStatement statement = null;           
		List<HoaDon> listtheoThangNam = new ArrayList<HoaDon>();
		try {
			 statement = ConnectDB.getConnection().prepareStatement(sql);
//                   statement.setString(1, nam);
//                   statement.setString(2, thang);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
                                 KhachHang khs=new KhachHang(rs.getString("maKhachHang"),rs.getString("hoTenKhachHang"),rs.getString("soDienThoai"));
                              
				 HoaDon hd=new HoaDon(khs,rs.getDouble("tongTien"));
				 listtheoThangNam.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listtheoThangNam;
	}
}
