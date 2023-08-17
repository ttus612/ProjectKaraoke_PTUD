/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import static connectDB.ConnectDB.con;
import entity.KhachHang;
import entity.LoaiNhanVien;
import entity.NhanVien;
import entity.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
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
public class NhanVienDao {

    public ArrayList<NhanVien> getAllNhanVien() {
        ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from NhanVien as nv join LoaiNhanVien as lnv on nv.maLoaiNhanVien = lnv.maLoaiNhanVien";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maNhanVien = rs.getString("maNhanVien");
                String tenNhanVien = rs.getString("tenNhanVien");
                String CCCD = rs.getString("CCCD");
                String ngaySinh = rs.getString("ngaySinh");
                Boolean gioiTinh = rs.getBoolean("gioiTinh");
                String diaChi = rs.getString("diaChi");
                String soDienThoai = rs.getString("soDienThoai");
                Boolean trangThaiLamViec = rs.getBoolean("trangThaiLamViec");
                Boolean quanLyNhanVien = rs.getBoolean("quanly");
                String maLoaiNhanVien = rs.getString("maLoaiNhanVien");
                LoaiNhanVien lnv = new LoaiNhanVien(rs.getString("maLoaiNhanVien"), rs.getString("tenLoaiNhanVien"));
                NhanVien nv = new NhanVien(maNhanVien, tenNhanVien, CCCD, diaChi, soDienThoai, maLoaiNhanVien, LocalDate.parse(ngaySinh), gioiTinh, trangThaiLamViec, lnv);
                dsNhanVien.add(nv);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsNhanVien;
    }

    public ArrayList<TaiKhoan> getAllTaiKhoangNhanVien() {
        ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<TaiKhoan>();
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from TaiKhoan";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maTaiKhoan = rs.getString("maTaiKhoan");
                String maNhanViens = rs.getString("maNhanvien");
                TaiKhoan tk = new TaiKhoan(maTaiKhoan, maNhanViens);
                dsTaiKhoan.add(tk);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsTaiKhoan;
    }

    public ArrayList<LoaiNhanVien> getAllLoaiNhanVien() {
        ArrayList<LoaiNhanVien> dsLoaiNhanVien = new ArrayList<LoaiNhanVien>();
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from LoaiNhanVien";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maLoaiNhanVien = rs.getString("maLoaiNhanVien");
                String tenLoaiNhanVien = rs.getString("tenLoaiNhanVien");

                LoaiNhanVien nv = new LoaiNhanVien(maLoaiNhanVien, tenLoaiNhanVien);
                dsLoaiNhanVien.add(nv);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsLoaiNhanVien;
    }

    public List<NhanVien> getNVByTen(String ten) {

        String sql = "Select * from NhanVien as nv join LoaiNhanVien as lnv on nv.maLoaiNhanVien = lnv.maLoaiNhanVien where tenNhanVien like N'%" + ten + "%' ";
        PreparedStatement statement = null;
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            statement = ConnectDB.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                LoaiNhanVien lnv = new LoaiNhanVien(rs.getString("maLoaiNhanVien"), rs.getString("tenLoaiNhanVien"));
                NhanVien nv = new NhanVien(rs.getString("maNhanVien"),
                        rs.getString("tenNhanVien"),
                        rs.getString("CCCD"), rs.getString("diaChi"),
                         rs.getString("soDienThoai"), rs.getString("maLoaiNhanVien"), LocalDate.parse(rs.getString("ngaySinh")),
                         rs.getBoolean("gioiTinh"), rs.getBoolean("trangThaiLamViec"), lnv);

                list.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String TaoSoNgauNhien() {
        String strMaHD = null;

        PreparedStatement s = null;
        String sql = "select top 1 maNhanVien from NhanVien order by maNhanVien desc";
        try {
            s = ConnectDB.getConnection().prepareStatement(sql);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                strMaHD = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tạo mã Nhân viên");
            return "";
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        String str = strMaHD.substring(2, 4);
        strMaHD = strMaHD.substring(4);
        long longMaHD = Long.parseLong(strMaHD);
        if (longMaHD == 999999) {
            if (str.equals("ZZ")) {
                return "error! (out of memory)";
            } else if (str.codePointAt(1) == 90) {
                int temp = str.codePointAt(0) + 1;
                str = (char) temp + "A";
                longMaHD = 0;
            } else {
                int temp = str.codePointAt(0);
                int temp1 = str.codePointAt(1) + 1;
                str = (char) temp + "" + (char) temp1;
                longMaHD = 0;
            }
        } else {
            longMaHD += 1;
        }
        strMaHD = longMaHD == 0 ? String.valueOf(1000001 + longMaHD) : String.valueOf(1000000 + longMaHD);
        System.err.println(strMaHD);
        strMaHD = "NV" + str + strMaHD.substring(3);
        return strMaHD;
    }

    public String TaoMaTaiKhoanNgauNhien() {
        String strMaHD = null;

        PreparedStatement s = null;
        String sql = "select top 1 maTaiKhoan from TaiKhoan order by maTaiKhoan desc";
        try {
            s = ConnectDB.getConnection().prepareStatement(sql);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                strMaHD = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tạo mã Nhân viên");
            return "";
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        String str = strMaHD.substring(2, 4);
        strMaHD = strMaHD.substring(4);

        long longMaHD = Long.parseLong(str);
        if (longMaHD == 999999) {
            if (str.equals("ZZ")) {
                return "error! (out of memory)";
            } else if (str.codePointAt(1) == 90) {
                int temp = str.codePointAt(0) + 1;
                str = (char) temp + "A";
                longMaHD = 0;
            } else {
                int temp = str.codePointAt(0);
                int temp1 = str.codePointAt(1) + 1;
                str = (char) temp + "" + (char) temp1;
                longMaHD = 0;
            }
        } else {
            longMaHD += 1;
        }
        strMaHD = longMaHD == 0 ? String.valueOf(1000001 + longMaHD) : String.valueOf(1000000 + longMaHD);

        System.err.println(strMaHD);

        strMaHD = "TK" + strMaHD.substring(5);
        return strMaHD;
    }

    public Boolean ThemNhanVien(NhanVien nv) {
        PreparedStatement preparedStatement = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "insert into NhanVien values(?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, nv.getMaNhanVien());
            preparedStatement.setString(2, nv.getTenNhanVien());
            preparedStatement.setString(3, nv.getCCCD());
            preparedStatement.setString(4, nv.getNgaySinh().toString());
            preparedStatement.setInt(5, nv.getGioiTinh() == true ? 1 : 0);
            preparedStatement.setString(6, nv.getDiaChi());
            preparedStatement.setString(7, nv.getSoDienThoai());
            preparedStatement.setInt(8, nv.getTrangThaiLamViec() ? 1 : 0);
            int bienLoaiNhanVien = 1;
            if (nv.getLnv().getMaLoaiNhanVien().equalsIgnoreCase("LN01")) {
                bienLoaiNhanVien = 0;
            }
            preparedStatement.setInt(9, bienLoaiNhanVien);
            preparedStatement.setString(10, nv.getLnv().getMaLoaiNhanVien());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
            // TODO: handle exception
        }
    }

    public boolean deleteNhanVien(String maNV) {
        ConnectDB.getIntance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "Delete From NhanVien Where maNhanVien = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, maNV);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateNV(NhanVien nv) throws SQLException {
        try {
            PreparedStatement preparedStatement = null;
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            int bienLoaiNhanVien = 0;
            if (nv.getLnv().getMaLoaiNhanVien().equalsIgnoreCase("LN01")) {
                bienLoaiNhanVien = 1;
            }
            String sql = "update NhanVien set tenNhanVien=?,CCCD=?,ngaySinh=?,gioiTinh=?,diaChi=?,soDienThoai=?,trangThaiLamViec=?,quanly=?,maLoaiNhanVien=? WHERE maNhanVien=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, nv.getTenNhanVien());
            preparedStatement.setString(2, nv.getCCCD());
            preparedStatement.setString(3, nv.getNgaySinh().toString());
            preparedStatement.setInt(4, nv.getGioiTinh() == true ? 1 : 0);
            preparedStatement.setString(5, nv.getDiaChi());
            preparedStatement.setString(6, nv.getSoDienThoai());
            preparedStatement.setInt(7, nv.getTrangThaiLamViec() == true ? 1 : 0);
            preparedStatement.setInt(8, bienLoaiNhanVien);
            preparedStatement.setString(9, nv.getLnv().getMaLoaiNhanVien());
            preparedStatement.setString(10, nv.getMaNhanVien());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public List<NhanVien> LocNhanVien(String loaiNhanViens, boolean trangThaiLamViecs) throws SQLException {
        String sql = "Select * from NhanVien as nv join LoaiNhanVien as lnv on nv.maLoaiNhanVien = lnv.maLoaiNhanVien where (nv.maLoaiNhanVien =?) and (trangThaiLamViec=?)";
        PreparedStatement statement = null;
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            statement = ConnectDB.getConnection().prepareStatement(sql);
            statement.setString(1, loaiNhanViens);
            statement.setBoolean(2, trangThaiLamViecs);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                LoaiNhanVien lnv = new LoaiNhanVien(rs.getString("maLoaiNhanVien"), rs.getString("tenLoaiNhanVien"));
                NhanVien nv = new NhanVien(rs.getString("maNhanVien"),
                        rs.getString("tenNhanVien"),
                        rs.getString("CCCD"), rs.getString("diaChi"),
                         rs.getString("soDienThoai"), rs.getString("maLoaiNhanVien"), LocalDate.parse(rs.getString("ngaySinh")),
                         rs.getBoolean("gioiTinh"), rs.getBoolean("trangThaiLamViec"), lnv);

                list.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean taoTaiKhoangNhanVien(String mataiKhoang, String maNhanVien, String userName, String password, String email) throws SQLException {
        try {
            PreparedStatement preparedStatement = null;
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "insert into TaiKhoan values(?,?,?,?,?)";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, mataiKhoang);
            preparedStatement.setString(2, maNhanVien);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, email);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }

    //Tìm theo mã
    public NhanVien timNhanVienTheoMa(String maNV) {
        NhanVien nhanVien = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM NhanVien WHERE maNhanVien = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maNhanVien = rs.getString("maNhanVien");
                String tenNhanVien = rs.getString("tenNhanVien");
                String CCCD = rs.getString("CCCD");
                LocalDate ngaySinh = rs.getDate("ngaySinh").toLocalDate();
                Boolean gioiTinh = rs.getBoolean("gioiTinh");
                String diaChi = rs.getString("diaChi");
                String soDienThoai = rs.getString("soDienThoai");
                Boolean trangThaiLamViec = rs.getBoolean("trangThaiLamViec");
                Boolean quanLy = rs.getBoolean("quanly");
                LoaiNhanVien loaiNhanVien = new LoaiNhanVien(rs.getString("maLoaiNhanVien"));
                nhanVien = new NhanVien(maNhanVien, tenNhanVien, CCCD, diaChi, soDienThoai, maNhanVien, ngaySinh, gioiTinh, trangThaiLamViec, loaiNhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    //Tìm theo mã
    public LoaiNhanVien timLoaiNhanVienTheoMaNV(String maNV) {
        LoaiNhanVien loaiNhanVien = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM  LoaiNhanVien LNV JOIN NhanVien NV  ON NV.maLoaiNhanVien = LNV.maLoaiNhanVien WHERE maNhanVien = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maLoaiNhanVien = rs.getString("maLoaiNhanVien");
                String tenLoaiNhanVien = rs.getString("tenLoaiNhanVien");
                loaiNhanVien = new LoaiNhanVien(maLoaiNhanVien, tenLoaiNhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loaiNhanVien;
    }
    
    public List<NhanVien> timNVTheoTenVaSdt(String ten, String sdt) {
        String sql = "select * from NhanVien where soDienThoai like '%" + sdt + "%' and tenNhanVien like N'%" + ten + "%'";
        PreparedStatement statement = null;
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            statement = ConnectDB.getConnection().prepareStatement(sql);

            ResultSet r = statement.executeQuery();

            while (r.next()) {
                NhanVien nv = new NhanVien(r.getString("maNhanVien"), r.getString("tenNhanVien"), r.getString("soDienThoai"), r.getString("diaChi"));
                list.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
