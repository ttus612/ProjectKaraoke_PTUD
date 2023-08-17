package dao;

import connectDB.ConnectDB;
import entity.LoaiSanPham;
import entity.SanPham;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Dao_SanPham {

    private Dao_LoaiSanpham loaiSanPham_dao = new Dao_LoaiSanpham();

    public ArrayList<SanPham> getAllSanPham() {
        ArrayList<SanPham> dsSanPham = new ArrayList<SanPham>();
        String sql = "select * from SanPham join LoaiSanPham ON SanPham.maLoaiSanPham = LoaiSanPham.maLoaiSanPham Order by maSanPham DESC";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(rs.getString("maSanPham"));
                sanPham.setTenSanPham(rs.getString("tenSanPham"));
                sanPham.setSoLuongSanPham(rs.getInt("soLuongSanPham"));
                sanPham.setNgayNhapSanPham(rs.getDate("ngayNhapSanPham").toLocalDate());
                sanPham.setHanSuDung(rs.getDate("hanSuDung").toLocalDate());
                sanPham.setNoiLayHang(rs.getString("noiLayHang"));
                sanPham.setGiaNhap(rs.getDouble("giaNhap"));
                sanPham.setNhaCungCap(rs.getString("nhaCungCap"));
                sanPham.setLoaiSanPham(new LoaiSanPham(rs.getString("maLoaiSanPham"), rs.getString("tenLoaiSanPham")));
                dsSanPham.add(sanPham);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dsSanPham;
    }

    public ArrayList<SanPham> getDanhSachMaSanPham() {
        ArrayList<SanPham> dsMaSanPham = new ArrayList<SanPham>();
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM SanPham";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("maSanPham"));
                sp.setTenSanPham(rs.getString("tenSanPham"));
                dsMaSanPham.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsMaSanPham;
    }

    public boolean addSanPham(SanPham sp) {
        PreparedStatement pre = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "Insert into SanPham Values(?,?,?,?,?,?,?,?,?)";
            pre = con.prepareStatement(sql);
            pre.setString(1, sp.getMaSanPham());
            pre.setString(2, sp.getTenSanPham());
            pre.setInt(3, sp.getSoLuongSanPham());
            pre.setDate(4, java.sql.Date.valueOf(sp.getNgayNhapSanPham()));
            pre.setDate(5, java.sql.Date.valueOf(sp.getHanSuDung()));
            pre.setString(6, sp.getNoiLayHang());
            pre.setDouble(7, sp.getGiaNhap());
            pre.setString(8, sp.getNhaCungCap());
            pre.setString(9, sp.getLoaiSanPham().getMaLoaiSanPham());
            pre.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSanPham(String maSanPham) {
        ConnectDB.getIntance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int count = 0;
        try {
            Statement stmTimSP = con.createStatement();
            ResultSet amountSP = stmTimSP.executeQuery("Select Count(maSanPham) As total from DichVu Where maSanPham = '" + maSanPham + "' ");
            while (amountSP.next()) {
                count = amountSP.getInt("total");
            }
            System.out.println(count);
            if (count == 0) {
                String sql = "Delete From SanPham Where maSanPham = ?";
                statement = con.prepareStatement(sql);
                statement.setString(1, maSanPham);
                statement.executeUpdate();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại!. Sản phẩm đang tồn tại trong dịch vụ");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateSP(SanPham sp, String maSanPham) throws SQLException {
        PreparedStatement pre = null;
        ConnectDB.getIntance().connect();
        Connection con = ConnectDB.getConnection();
        int count = 0;
        try {
            Statement stmTimSP = con.createStatement();
            ResultSet amountSP = stmTimSP.executeQuery("Select Count(maSanPham) As total from SanPham Where maSanPham = '" + maSanPham + "' ");
            while (amountSP.next()) {
                count = amountSP.getInt("total");
            }
            System.out.println(count);
            if (count != 0) {
                String sql = "update SanPham set tenSanPham=?,soLuongSanPham=?,ngayNhapSanPham=?,hanSuDung=?,noiLayHang=?,giaNhap=?,nhaCungCap=?,maLoaiSanPham=? WHERE maSanPham=?";
                pre = con.prepareStatement(sql);
                pre.setString(1, sp.getTenSanPham());
                pre.setInt(2, sp.getSoLuongSanPham());
                pre.setDate(3, java.sql.Date.valueOf(sp.getNgayNhapSanPham()));
                pre.setDate(4, java.sql.Date.valueOf(sp.getHanSuDung()));
                pre.setString(5, sp.getNoiLayHang());
                pre.setDouble(6, sp.getGiaNhap());
                pre.setString(7, sp.getNhaCungCap());
                pre.setString(8, sp.getLoaiSanPham().getMaLoaiSanPham());
                pre.setString(9, sp.getMaSanPham());
                pre.executeUpdate();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public String TaoSoNgauNhien() {
        String strMaSP = null;

        PreparedStatement s = null;
        String sql = "select top 1 maSanPham from SanPham order by maSanPham desc";
        try {
            s = ConnectDB.getConnection().prepareStatement(sql);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                strMaSP = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tạo mã sản phẩm");
            return "";
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        String str = strMaSP.substring(2, 4);
        System.out.println("str: " + str);
        strMaSP = strMaSP.substring(2);
        long longMaSP = Long.parseLong(strMaSP);
        if (longMaSP == 999999) {
            if (str.equals("ZZ")) {
                return "error! (out of memory)";
            } else if (str.codePointAt(1) == 90) {
                int temp = str.codePointAt(0) + 1;
                str = (char) temp + "A";
                longMaSP = 0;
            } else {
                int temp = str.codePointAt(0);
                int temp1 = str.codePointAt(1) + 1;
                str = (char) temp + "" + (char) temp1;
                longMaSP = 0;
            }
        } else {
            longMaSP += 1;
        }
        strMaSP = longMaSP == 0 ? String.valueOf(1000001 + longMaSP) : String.valueOf(1000000 + longMaSP);
        System.err.println(strMaSP);
        strMaSP = "SP" + strMaSP.substring(3);
        return strMaSP;
    }

    public List<SanPham> getSanPhamTheoTen(String ten) {
        String sql = "Select * from SanPham as sp join LoaiSanPham as loaiSP on sp.maLoaiSanPham = loaiSP.maLoaiSanPham where tenSanPham like N'%" + ten + "%' ";
        PreparedStatement statement = null;
        List<SanPham> list = new ArrayList<>();
        try {
            statement = ConnectDB.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                LoaiSanPham lsp = new LoaiSanPham(rs.getString("maLoaiSanPham"), rs.getString("tenLoaiSanPham"));
                SanPham sp = new SanPham(rs.getString("maSanPham"), rs.getString("tenSanPham"), rs.getString("noiLayHang"),
                        rs.getString("nhaCungCap"), lsp, rs.getInt("soLuongSanPham"),
                        rs.getDate("ngayNhapSanPham").toLocalDate(), rs.getDate("hanSuDung").toLocalDate(), rs.getDouble("giaNhap"));
                list.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ResultSet filteSanPhamTheoLoai(String tenLoaiSanPham) {
        PreparedStatement preparedStatement = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "select maSanPham,tenSanPham, soLuongSanPham, ngayNhapSanPham, hanSuDung, noiLayHang, giaNhap, nhaCungCap, tenLoaiSanPham from SanPham join LoaiSanPham on SanPham.maLoaiSanPham = LoaiSanPham.maLoaiSanPham where tenLoaiSanPham = ? ";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, tenLoaiSanPham);
            ResultSet rs = preparedStatement.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SanPham timSPTheoMa(String maSP) {
        SanPham sanPham = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM SanPham WHERE maSanPham = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maSanPham = rs.getString("maSanPham");
                String tenSanPham = rs.getString("tenSanPham");
                Integer soLuongSanPham = rs.getInt("soLuongSanPham");
                LocalDate ngayNhapSanPham = rs.getDate("ngayNhapSanPham").toLocalDate();
                LocalDate hanSuDung = rs.getDate("hanSuDung").toLocalDate();
                String noiLayHang = rs.getString("noiLayHang");
                Double giaNhap = rs.getDouble("giaNhap");
                String nhaCungCap = rs.getString("nhaCungCap");
                LoaiSanPham loaiSanPham = new LoaiSanPham(rs.getString("maLoaiSanPham"));
                sanPham = new SanPham(maSanPham, tenSanPham, noiLayHang, nhaCungCap, loaiSanPham, soLuongSanPham, ngayNhapSanPham, hanSuDung, giaNhap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    public ArrayList<SanPham> timSanPhamTheoDK(String tenSanPham, String soLuongSanPham, String giaNhap, String noiLayHang, String HSD, String ngayNhap, String nCC) {
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        System.out.println(tenSanPham);
        System.out.println(soLuongSanPham);
        System.out.println(giaNhap);
        System.out.println(noiLayHang);
        System.out.println(HSD);
        System.out.println(ngayNhap);
        System.out.println(nCC);
        String sql = "SELECT * FROM SanPham INNER JOIN LoaiSanPham ON SanPham.maLoaiSanPham = LoaiSanPham.maLoaiSanPham where tenSanPham like ? and soLuongSanPham like ? and giaNhap like ? and noiLayHang like ? and hanSuDung like ? and ngayNhapSanPham like ? and nhacungCap like ?";
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + tenSanPham + "%");
            stmt.setString(2, "%" + soLuongSanPham + "%");
            stmt.setString(3, "%" + giaNhap + "%");
            stmt.setString(4, "%" + noiLayHang + "%");
            stmt.setString(5, "%" + HSD + "%");
            stmt.setString(6, "%" + ngayNhap + "%");
            stmt.setString(7, "%" + nCC + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                LocalDate ngayNhapSanPham = rs.getDate("ngayNhapSanPham").toLocalDate();
                LocalDate hanSuDung = rs.getDate("hanSuDung").toLocalDate();
                LoaiSanPham loaiSanPham = loaiSanPham_dao.timLoaiSanPham(rs.getString("maLoaiSanPham"));
                SanPham sanPham = new SanPham(rs.getString("maSanPham"), rs.getString("tenSanPham"), rs.getString("noiLayHang"),
                        rs.getString("nhaCungCap"), loaiSanPham, rs.getInt("soLuongSanPham"), ngayNhapSanPham, hanSuDung, rs.getDouble("giaNhap"));
                listSanPham.add(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }
}