
package dao;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiNhanVien;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.Phong;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp, THANH TU
 */
public class Dao_HoaDon {

    public KhachHang getKhachHangTheoHoaDon(String maHD) {
        KhachHang kh = new KhachHang();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT maKhachHang from HoaDon where maHoaDon=?";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, maHD);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return new KhachHang(rs.getString("maKhachHang"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_PhieuDat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Thêm phòng
    public void addHoaDON(HoaDon hd) {
        PreparedStatement preparedStatement = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "INSERT INTO HoaDon VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, hd.getMaHoaDon());
            preparedStatement.setString(2, hd.getNhanVien().getMaNhanVien());
            preparedStatement.setString(3, hd.getKhachHang().getMaKhachHang());
            preparedStatement.setDate(4, hd.getNgayLap());
            preparedStatement.setTime(5, java.sql.Time.valueOf(hd.getGioNhanPhong()));
            preparedStatement.setTime(6, java.sql.Time.valueOf( hd.getGioKetThuc()));
//            preparedStatement.setTime(5, hd.getGioNhanPhong());
//            preparedStatement.setTime(6, hd.getGioKetThuc());
            preparedStatement.setFloat(7, hd.getThue());
            preparedStatement.setFloat(8, hd.getKhuyenMai());
            preparedStatement.setDouble(9, hd.getTienKhachTra());
            preparedStatement.setBoolean(10, hd.isTrangThai());
            preparedStatement.setDouble(11, hd.getTongTien());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public HoaDon timHoaDonTheoMaHoaDon(String maHD) {
        HoaDon hoaDon = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM HoaDon WHERE maHoaDon = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
                KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
                Date ngayLap = rs.getDate("ngayLap");
                LocalTime gioNhanPhong = rs.getTime("gioNhanPhong").toLocalTime();
                LocalTime gioKetThuc = rs.getTime("gioKetThuc").toLocalTime();
                Float thue = rs.getFloat("thue");
                Float khuyenMai = rs.getFloat("khuyenMai");
                Double tienKhachTra = rs.getDouble("tienKhachTra");
                Boolean trangThai = rs.getBoolean("trangThai");
                Double tongTien = rs.getDouble("tongTien");
                hoaDon = new HoaDon(maHoaDon, nhanVien, khachHang, ngayLap, gioNhanPhong, gioKetThuc, thue, khuyenMai, tienKhachTra, tongTien, trangThai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoaDon;
    }

    //Sửa giờ kết thúc
    public void suaGioKetThucHoaDon(HoaDon hoaDonNew) {
        PreparedStatement ps = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "UPDATE HoaDon SET gioKetThuc = ? WHERE maHoaDon = ?";
            ps = con.prepareStatement(sql);
             ps.setTime(1, java.sql.Time.valueOf(hoaDonNew.getGioKetThuc()));
            
//            ps.setTime(1, hoaDonNew.getGioKetThuc());
            ps.setString(2, hoaDonNew.getMaHoaDon());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Sửa thuế, khuyến mãi, tiền khách trả , trạng thái, tổng tiền
    public void suaThue_KhuyenMai_TienKhachTra_TrangThai__TongTien_HoaDon(HoaDon hoaDonNew) {
        PreparedStatement ps = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "UPDATE HoaDon SET thue = ?, khuyenMai = ?, tienKhachTra = ?, trangThai = ?, tongTien = ? WHERE maHoaDon = ?";
            ps = con.prepareStatement(sql);
            ps.setFloat(1, hoaDonNew.getThue());
            ps.setFloat(2, hoaDonNew.getKhuyenMai());
            ps.setDouble(3, hoaDonNew.getTienKhachTra());
            ps.setBoolean(4, hoaDonNew.isTrangThai());
            ps.setDouble(5, hoaDonNew.getTongTien());
            ps.setString(6, hoaDonNew.getMaHoaDon());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HoaDon timHoaDonTheoMaPhongVaTrangThaiFalse(String maPhong) {
        HoaDon hoaDon = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM HoaDon HD JOIN ChiTietHoaDon CTHD  ON CTHD.maHoaDon = HD.maHoaDon WHERE maPhong = ? AND trangThai = 0";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maPhong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
                KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
                Date ngayLap = rs.getDate("ngayLap");
                LocalTime gioNhanPhong = rs.getTime("gioNhanPhong").toLocalTime();
                LocalTime gioKetThuc = rs.getTime("gioKetThuc").toLocalTime();
                Float thue = rs.getFloat("thue");
                Float khuyenMai = rs.getFloat("khuyenMai");
                Double tienKhachTra = rs.getDouble("tienKhachTra");
                Boolean trangThai = rs.getBoolean("trangThai");
                Double tongTien = rs.getDouble("tongTien");
                hoaDon = new HoaDon(maHoaDon, nhanVien, khachHang, ngayLap, gioNhanPhong, gioKetThuc, thue, khuyenMai, tienKhachTra, tongTien, trangThai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoaDon;
    }

    //Tim hóa đơn theo ngày
    public HoaDon timHoaDonTheoNgay(Date ngayHienTai) {
        HoaDon hoaDon = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM HoaDon WHERE ngayLap = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, ngayHienTai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
                KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
                Date ngayLap = rs.getDate("ngayLap");
                LocalTime gioNhanPhong = rs.getTime("gioNhanPhong").toLocalTime();
                LocalTime gioKetThuc = rs.getTime("gioKetThuc").toLocalTime();
                Float thue = rs.getFloat("thue");
                Float khuyenMai = rs.getFloat("khuyenMai");
                Double tienKhachTra = rs.getDouble("tienKhachTra");
                Boolean trangThai = rs.getBoolean("trangThai");
                Double tongTien = rs.getDouble("tongTien");
                hoaDon = new HoaDon(maHoaDon, nhanVien, khachHang, ngayLap, gioNhanPhong, gioKetThuc, thue, khuyenMai, tienKhachTra, tongTien, trangThai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoaDon;
    }

    public HoaDon timHoaDonTheoNgayVaTheoPhong(Date ngayHienTai, String maP) {
        HoaDon hoaDon = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM HoaDon hd JOIN ChiTietHoaDon ct on hd.maHoaDon = ct.maHoaDon WHERE hd.ngayLap = ? and ct.maPhong=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, ngayHienTai);
            ps.setString(2, maP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                NhanVien nhanVien = new NhanVien(rs.getString("maNhanVien"));
                KhachHang khachHang = new KhachHang(rs.getString("maKhachHang"));
                Date ngayLap = rs.getDate("ngayLap");
                LocalTime gioNhanPhong = rs.getTime("gioNhanPhong").toLocalTime();
                LocalTime gioKetThuc = rs.getTime("gioKetThuc").toLocalTime();
                Float thue = rs.getFloat("thue");
                Float khuyenMai = rs.getFloat("khuyenMai");
                Double tienKhachTra = rs.getDouble("tienKhachTra");
                Boolean trangThai = rs.getBoolean("trangThai");
                Double tongTien = rs.getDouble("tongTien");
                hoaDon = new HoaDon(maHoaDon, nhanVien, khachHang, ngayLap, gioNhanPhong, gioKetThuc, thue, khuyenMai, tienKhachTra, tongTien, trangThai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoaDon;
    }

    //hoa Don thay doi 
    public ArrayList<HoaDon> getAllHoaDon() {
        ArrayList<HoaDon> dsNhanVien = new ArrayList<HoaDon>();
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "select *from HoaDon as hd join KhachHang kh on hd.maKhachHang=kh.maKhachHang join NhanVien as nv on hd.maNhanVien=nv.maNhanVien";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maKhachHang = rs.getString("maKhachHang");
                String tenKhachHang = rs.getString("hoTenKhachHang");
                String SDT = rs.getString("soDienThoai");
                String maHoaDon = rs.getString("maHoaDon");
                String tenNhanVien = rs.getString("tenNhanVien");
                String ngayLap = rs.getString("ngayLap");
                LocalTime gioiNhanPhong = rs.getTime("gioNhanPhong").toLocalTime();
                LocalTime gioKetThuc = rs.getTime("gioKetThuc").toLocalTime();
                Double tienKhachTra = rs.getDouble("tienKhachTra");
                Double tongTien = rs.getDouble("tongTien");
                 NhanVien nv=new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"),rs.getString("soDienThoai"),rs.getString("DiaChi"));
                KhachHang kh=new KhachHang(rs.getString("maKhachHang"),rs.getString("hoTenKhachHang"),rs.getString("soDienThoai"));
                HoaDon hd = new HoaDon(kh, maHoaDon,nv, LocalDate.parse(ngayLap), gioiNhanPhong, gioKetThuc, tienKhachTra, tongTien);
                dsNhanVien.add(hd);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return dsNhanVien;
    }

    public ArrayList<HoaDon> getAllHoaDonTheoMakhTenKhachSdtNgayLap(String maKh, String mahd, String sdt, String ngay, String thang, String nam) {
        ArrayList<HoaDon> dsNhanHoaDon = new ArrayList<HoaDon>();
     
        try {
            PreparedStatement statement = null;
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();

            String sql = "select *from HoaDon as hd join KhachHang kh on hd.maKhachHang=kh.maKhachHang join NhanVien as nv on hd.maNhanVien=nv.maNhanVien where hd.maHoaDon=? and hd.maKhachHang=? AND kh.soDienThoai=? and MONTH(ngayLap)=? and YEAR(ngayLap)=? and DAY(ngayLap)=? ";
//           and hd.maKhachHang=? AND kh.soDienThoai=? and MONTH(ngayLap)=? and YEAR(ngayLap)=? and DAY(ngayLap)=
            statement = con.prepareStatement(sql);
            statement.setString(1, mahd);
            statement.setString(2, maKh);
            statement.setString(3, sdt);
            statement.setString(4, thang);
            statement.setString(5, nam);
            statement.setString(6, ngay);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String maKhachHang = rs.getString("maKhachHang");
                String tenKhachHang = rs.getString("hoTenKhachHang");
                String SDT = rs.getString("soDienThoai");
                String maHoaDon = rs.getString("maHoaDon");
                String tenNhanVien = rs.getString("tenNhanVien");
                String ngayLap = rs.getString("ngayLap");
                LocalTime gioiNhanPhong = rs.getTime("gioNhanPhong").toLocalTime();
                LocalTime gioKetThuc = rs.getTime("gioKetThuc").toLocalTime();
                Double tienKhachTra = rs.getDouble("tienKhachTra");
                Double tongTien = rs.getDouble("tongTien");
                 NhanVien nv=new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"),rs.getString("soDienThoai"),rs.getString("DiaChi"));
                KhachHang kh=new KhachHang(rs.getString("maKhachHang"),rs.getString("hoTenKhachHang"),rs.getString("soDienThoai"));
                HoaDon hd = new HoaDon(kh, maHoaDon,nv, LocalDate.parse(ngayLap), gioiNhanPhong, gioKetThuc, tienKhachTra, tongTien);
                dsNhanHoaDon.add(hd);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsNhanHoaDon;
    }

    public List<HoaDon> timHdTheoTenVaSdt(String maHaDon, String sdt) {
        String sql = "select *from HoaDon as hd join KhachHang kh on hd.maKhachHang=kh.maKhachHang join NhanVien as nv on hd.maNhanVien=nv.maNhanVien where hd.maHoaDon like '%" + maHaDon + "%' and kh.soDienThoai like '%" + sdt + "%'";
        PreparedStatement statement = null;
        List<HoaDon> list = new ArrayList<HoaDon>();
        try {
            statement = ConnectDB.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maKhachHang = rs.getString("maKhachHang");
                String tenKhachHang = rs.getString("hoTenKhachHang");
                String SDT = rs.getString("soDienThoai");
                String maHoaDon = rs.getString("maHoaDon");
                String tenNhanVien = rs.getString("tenNhanVien");
                String ngayLap = rs.getString("ngayLap");
                LocalTime gioiNhanPhong = rs.getTime("gioNhanPhong").toLocalTime();
                LocalTime gioKetThuc = rs.getTime("gioKetThuc").toLocalTime();
                Double tienKhachTra = rs.getDouble("tienKhachTra");
                Double tongTien = rs.getDouble("tongTien");
                NhanVien nv=new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"),rs.getString("soDienThoai"),rs.getString("DiaChi"));
                KhachHang kh=new KhachHang(rs.getString("maKhachHang"),rs.getString("hoTenKhachHang"),rs.getString("soDienThoai"));
                HoaDon hd = new HoaDon(kh, maHoaDon,nv, LocalDate.parse(ngayLap), gioiNhanPhong, gioKetThuc, tienKhachTra, tongTien);
                list.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    //Xóa  hóa đơn khi hủy phòng
    public void xoaHoaDonKhiHuyPhong(String maHoaDon) {
	PreparedStatement preparedStatement = null;
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "DELETE FROM HoaDon WHERE maHoaDon = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, maHoaDon);         
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
	}
    }
    
    //Danh sách hóa đơn chưa thanh toán
    public ArrayList<HoaDon> getDanhSachHDChuaTT(){
        ArrayList<HoaDon> dsHoaDonChuaTT = new ArrayList<HoaDon>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM HoaDon HD JOIN ChiTietHoaDon CTHD ON HD.maHoaDon = CTHD.maHoaDon\n" +
                        "JOIN NhanVien NV ON NV.maNhanVien = HD.maNhanVien\n" +
                        "JOIN KhachHang KH ON KH.maKhachHang = HD.maKhachHang\n" +
                        "JOIN Phong P ON P.maPhong = CTHD.maPhong\n" +
                        "WHERE HD.trangThai = 0";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();             
                hd.setMaHoaDon(rs.getString("maHoaDon"));
                hd.setNhanVien(new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")));
                hd.setKhachHang(new KhachHang(rs.getString("maKhachHang"), rs.getString("hoTenKhachHang"), rs.getString("soDienThoai")));
                hd.setNgayLap(rs.getDate("ngayLap"));
                hd.setGioNhanPhong(rs.getTime("gioNhanPhong").toLocalTime());
                hd.setGioKetThuc(rs.getTime("gioKetThuc").toLocalTime());
                hd.setThue(rs.getFloat("thue"));
                hd.setKhuyenMai(rs.getFloat("khuyenMai"));
                hd.setTienKhachTra(rs.getDouble("tienKhachTra"));
                hd.setTrangThai(rs.getBoolean("trangThai"));
                hd.setTrangThai(rs.getBoolean("tongTien"));
                dsHoaDonChuaTT.add(hd);
            }
	} catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsHoaDonChuaTT;
    }
  
    public ArrayList<HoaDon> getDanhSachHDChuaTTTheoTen(String tenKH){
	  ArrayList<HoaDon> dsHoaDonChuaTT = new ArrayList<HoaDon>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();

           String sql = "SELECT * FROM HoaDon HD JOIN ChiTietHoaDon CTHD ON HD.maHoaDon = CTHD.maHoaDon\n" +
                        "JOIN NhanVien NV ON NV.maNhanVien = HD.maNhanVien\n" +
                        "JOIN KhachHang KH ON KH.maKhachHang = HD.maKhachHang\n" +
                        "JOIN Phong P ON P.maPhong = CTHD.maPhong\n" +
                        "WHERE HD.trangThai = 0 AND hoTenKhachHang = N'"+tenKH+"'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {            
                HoaDon hd = new HoaDon();             
                hd.setMaHoaDon(rs.getString("maHoaDon"));
                hd.setNhanVien(new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")));
                hd.setKhachHang(new KhachHang(rs.getString("maKhachHang"), rs.getString("hoTenKhachHang"),rs.getString("soDienThoai")));
                hd.setNgayLap(rs.getDate("ngayLap"));
                hd.setGioNhanPhong(rs.getTime("gioNhanPhong").toLocalTime());
                hd.setGioKetThuc(rs.getTime("gioKetThuc").toLocalTime());
                hd.setThue(rs.getFloat("thue"));
                hd.setKhuyenMai(rs.getFloat("khuyenMai"));
                hd.setTienKhachTra(rs.getDouble("tienKhachTra"));
                hd.setTrangThai(rs.getBoolean("trangThai"));
                hd.setTrangThai(rs.getBoolean("tongTien"));
                dsHoaDonChuaTT.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
	}
	return dsHoaDonChuaTT;
    }
    
    public ArrayList<HoaDon> getDanhSachHDChuaTTTheoSdt(String sdtKH){
	  ArrayList<HoaDon> dsHoaDonChuaTT = new ArrayList<HoaDon>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();

           String sql = "SELECT * FROM HoaDon HD JOIN ChiTietHoaDon CTHD ON HD.maHoaDon = CTHD.maHoaDon\n" +
                        "JOIN NhanVien NV ON NV.maNhanVien = HD.maNhanVien\n" +
                        "JOIN KhachHang KH ON KH.maKhachHang = HD.maKhachHang\n" +
                        "JOIN Phong P ON P.maPhong = CTHD.maPhong\n" +
                        "WHERE HD.trangThai = 0 AND KH.soDienThoai = N'"+sdtKH+"'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {            
                HoaDon hd = new HoaDon();             
                hd.setMaHoaDon(rs.getString("maHoaDon"));
                hd.setNhanVien(new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")));
                hd.setKhachHang(new KhachHang(rs.getString("maKhachHang"), rs.getString("hoTenKhachHang"),rs.getString("soDienThoai")));
                hd.setNgayLap(rs.getDate("ngayLap"));
                hd.setGioNhanPhong(rs.getTime("gioNhanPhong").toLocalTime());
                hd.setGioKetThuc(rs.getTime("gioKetThuc").toLocalTime());
                hd.setThue(rs.getFloat("thue"));
                hd.setKhuyenMai(rs.getFloat("khuyenMai"));
                hd.setTienKhachTra(rs.getDouble("tienKhachTra"));
                hd.setTrangThai(rs.getBoolean("trangThai"));
                hd.setTrangThai(rs.getBoolean("tongTien"));
                dsHoaDonChuaTT.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
	}
	return dsHoaDonChuaTT;
    }
}
