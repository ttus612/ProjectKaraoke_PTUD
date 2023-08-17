
package dao;

import connectDB.ConnectDB;
import entity.LoaiPhong;
import entity.Phong;
import entity.TrangThaiPhong;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author THANHTU
 */
public class Dao_Phong {
    //Hiển thị toàn bộ danh sách
    public ArrayList<Phong> getDanhSachPhong(){
        ArrayList<Phong> dsPhong = new ArrayList<Phong>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM Phong";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Phong p = new Phong();
                p.setMaPhong(rs.getString("maPhong"));
                p.setTrangThaiPhong(new TrangThaiPhong(rs.getString("maTrangThaiPhong")));
                p.setLoaiPhong(new LoaiPhong(rs.getString("maLoaiPhong")));
                p.setDienTich(rs.getFloat("dienTich"));
                p.setChieuCao(rs.getFloat("chieuCao"));
                p.setVatLieuCachAm(rs.getString("vatLieuCachAm"));
                p.setTiVi(rs.getString("tiVi"));
                p.setSoLuongTiVi(rs.getInt("soLuongTiVi"));
                p.setThuongHieuTiVi(rs.getString("thuongHieuTiVi"));
                p.setBan(rs.getString("ban"));
                p.setSoLuongBan(rs.getInt("soLuongBan"));
                p.setSoFa(rs.getString("soFa"));
                p.setSoLuongSoFa(rs.getInt("soLuongSoFa"));
                p.setDanLoa(rs.getString("danLoa"));
                p.setMoTa(rs.getString("moTa"));
                p.setTinhTrangBaoTri(rs.getBoolean("tinhTrangBaoTri"));
                p.setHinhAnh(rs.getString("hinhAnh")); 
                p.setLuotCho(rs.getInt("luotCho"));
		dsPhong.add(p);
            }
	} catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsPhong;
    }
    
    
    //Thêm phòng
    public void addPhong(Phong p) {
	PreparedStatement preparedStatement = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "INSERT INTO Phong VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, p.getMaPhong());
            preparedStatement.setString(2, p.getTrangThaiPhong().getMaTrangThaiPhong());
            preparedStatement.setString(3, p.getLoaiPhong().getMaLoaiPhong());
            preparedStatement.setFloat(4, p.getDienTich());
            preparedStatement.setFloat(5, p.getChieuCao());  
            preparedStatement.setString(6, p.getVatLieuCachAm());
            preparedStatement.setString(7, p.getTiVi());
            preparedStatement.setInt(8, p.getSoLuongTiVi());
            preparedStatement.setString(9, p.getThuongHieuTiVi());
            preparedStatement.setString(10, p.getBan());
            preparedStatement.setInt(11, p.getSoLuongBan());
            preparedStatement.setString(12, p.getSoFa());
            preparedStatement.setInt(13, p.getSoLuongSoFa());
            preparedStatement.setString(14, p.getDanLoa());
            preparedStatement.setString(15, p.getMoTa());
            preparedStatement.setBoolean(16, p.isTinhTrangBaoTri());
            preparedStatement.setString(17, p.getHinhAnh());
            preparedStatement.setInt(18, p.getLuotCho());
            preparedStatement.executeUpdate();
	} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	}
    } 
    
    //Xóa phòng
    public void xoaPhong(String maPhong) {
	PreparedStatement preparedStatement = null;
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "DELETE FROM Phong WHERE maPhong = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, maPhong);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
	}
    }
    
    //Sửa phòng
    public void suaPhong(Phong phongNew ) {
	PreparedStatement ps= null;
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();	 
            String sql = "UPDATE Phong SET maTrangThaiPhong = ?, maLoaiPhong = ?,dienTich = ?,chieuCao = ?,vatLieuCachAm = ?, tiVi = ?, soLuongTiVi = ?, thuongHieuTiVi = ?, ban = ?, soLuongBan = ?,soFa = ?, soLuongSoFa = ?,danLoa = ?, moTa = ?,tinhTrangBaoTri = ?,hinhAnh = ? WHERE maPhong = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, phongNew.getTrangThaiPhong().getMaTrangThaiPhong());
            ps.setString(2, phongNew.getLoaiPhong().getMaLoaiPhong());
            ps.setFloat(3, phongNew.getDienTich());
            ps.setFloat(4, phongNew.getChieuCao());  
            ps.setString(5, phongNew.getVatLieuCachAm());  
            ps.setString(6, phongNew.getTiVi());  
            ps.setInt(7, phongNew.getSoLuongTiVi());  
            ps.setString(8, phongNew.getThuongHieuTiVi());  
            ps.setString(9, phongNew.getBan());  
            ps.setInt(10, phongNew.getSoLuongBan());  
            ps.setString(11, phongNew.getSoFa());  
            ps.setInt(12, phongNew.getSoLuongSoFa());  
            ps.setString(13, phongNew.getDanLoa());  
            ps.setString(14, phongNew.getMoTa());  
            ps.setBoolean(15, phongNew.isTinhTrangBaoTri());  
            ps.setString(16, phongNew.getHinhAnh());  
            ps.setString(17, phongNew.getMaPhong());       
            ps.executeUpdate();	
	} catch (Exception e) {
            e.printStackTrace();	
	}
    }
    
    //Lọc theo loại phòng
    public ResultSet locPhongTheoLoaiPhong(String maLoaiPhong) {
	PreparedStatement preparedStatement = null;
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM Phong WHERE maLoaiPhong = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, maLoaiPhong);
            ResultSet rs = preparedStatement.executeQuery();          
            return rs;
	} catch (Exception e) {
            e.printStackTrace();
	}
        return null;
    }   
    //Phát sinh mã tự động
    public String getMaPhongTuDong() {
		String maP="";
		ConnectDB.getIntance();
		Connection con = ConnectDB.getConnection();
		String sql = "select CONCAT('P', RIGHT(CONCAT('000',ISNULL(right(max(maPhong),3),0) + 1),3)) from Phong where maPhong like  'P%'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				maP = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maP;
	}
    
    //Tìm 
    
    //Tìm theo mã
    public Phong timPhongTheoMa(String maP) {
        Phong phong = null;
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM Phong WHERE maPhong = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maPhong = rs.getString("maPhong");
                TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThaiPhong"));      
                LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong")); 
                Float dienTich = rs.getFloat("dienTich");           
                Float chieuCao = rs.getFloat("chieuCao");
                String vatLieuCachAm = rs.getString("vatLieuCachAm");
                String tiVi = rs.getString("tiVi");        
                Integer soLuongTiVi = rs.getInt("soLuongTiVi");
                String thuongHieuTiVi = rs.getString("thuongHieuTiVi");
                String ban = rs.getString("ban");
                Integer soLuongBan = rs.getInt("soLuongBan");
                String soFa = rs.getString("soFa");
                Integer soLuongSoFa =rs.getInt("soLuongSoFa");
                String danLoa = rs.getString("danLoa");
                String moTa = rs.getString("moTa");
                Boolean tinhTrangBaoTri = rs.getBoolean("tinhTrangBaoTri");
                String hinhAnh  = rs.getString("hinhAnh");               
                phong = new Phong(maPhong, trangThaiPhong, loaiPhong, dienTich, chieuCao, vatLieuCachAm, tiVi, soLuongTiVi, thuongHieuTiVi, ban, soLuongBan, soFa, soLuongSoFa, danLoa, moTa, tinhTrangBaoTri, hinhAnh);
            }
	} catch (Exception e) {
            e.printStackTrace();
        }
        return phong;
    }
    //Tìm theo diện tích
    public ArrayList<Phong> timTheoDienTich(Float tt) {
        ArrayList<Phong> lstP = new ArrayList<Phong>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM Phong WHERE dienTich = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1, tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maPhong = rs.getString("maPhong");
                TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThaiPhong"));      
                LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong")); 
                Float dienTich = rs.getFloat("dienTich");           
                Float chieuCao = rs.getFloat("chieuCao");
                String vatLieuCachAm = rs.getString("vatLieuCachAm");
                String tiVi = rs.getString("tiVi");        
                Integer soLuongTiVi = rs.getInt("soLuongTiVi");
                String thuongHieuTiVi = rs.getString("thuongHieuTiVi");
                String ban = rs.getString("ban");
                Integer soLuongBan = rs.getInt("soLuongBan");
                String soFa = rs.getString("soFa");
                Integer soLuongSoFa =rs.getInt("soLuongSoFa");
                String danLoa = rs.getString("danLoa");
                String moTa = rs.getString("moTa");
                Boolean tinhTrangBaoTri = rs.getBoolean("tinhTrangBaoTri");
                String hinhAnh  = rs.getString("hinhAnh");            
                Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, dienTich, chieuCao, vatLieuCachAm, tiVi, soLuongTiVi, thuongHieuTiVi, ban, soLuongBan, soFa, soLuongSoFa, danLoa, moTa, tinhTrangBaoTri, hinhAnh);
                lstP.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
			// TODO: handle exception
	}
	return lstP;
    }
    //Tìm theo chiều cao
    public ArrayList<Phong> timTheoChieuCao(Float tt) {
	ArrayList<Phong> lstP = new ArrayList<Phong>();
	try {
	ConnectDB.getIntance().connect();
	Connection con = ConnectDB.getConnection();

	String sql = "SELECT * FROM Phong WHERE chieuCao = ?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setFloat(1, tt);
	ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maPhong = rs.getString("maPhong");
                TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThaiPhong"));      
                LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong")); 
                Float dienTich = rs.getFloat("dienTich");           
                Float chieuCao = rs.getFloat("chieuCao");
                String vatLieuCachAm = rs.getString("vatLieuCachAm");
                String tiVi = rs.getString("tiVi");        
                Integer soLuongTiVi = rs.getInt("soLuongTiVi");
                String thuongHieuTiVi = rs.getString("thuongHieuTiVi");
                String ban = rs.getString("ban");
                Integer soLuongBan = rs.getInt("soLuongBan");
                String soFa = rs.getString("soFa");
                Integer soLuongSoFa =rs.getInt("soLuongSoFa");
                String danLoa = rs.getString("danLoa");
                String moTa = rs.getString("moTa");
                Boolean tinhTrangBaoTri = rs.getBoolean("tinhTrangBaoTri");
                String hinhAnh  = rs.getString("hinhAnh");                
                Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, dienTich, chieuCao, vatLieuCachAm, tiVi, soLuongTiVi, thuongHieuTiVi, ban, soLuongBan, soFa, soLuongSoFa, danLoa, moTa, tinhTrangBaoTri, hinhAnh);
                lstP.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
            return lstP;
	}
    
    //Tìm theo vật liệu cách âm
    public ArrayList<Phong> timTheoVatLieuCachAm(String tt) {
	ArrayList<Phong> lstP = new ArrayList<Phong>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();

            String sql = "SELECT * FROM Phong WHERE vatLieuCachAm = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maPhong = rs.getString("maPhong");
                TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThaiPhong"));      
                LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong")); 
                Float dienTich = rs.getFloat("dienTich");           
                Float chieuCao = rs.getFloat("chieuCao");
                String vatLieuCachAm = rs.getString("vatLieuCachAm");
                String tiVi = rs.getString("tiVi");        
                Integer soLuongTiVi = rs.getInt("soLuongTiVi");
                String thuongHieuTiVi = rs.getString("thuongHieuTiVi");
                String ban = rs.getString("ban");
                Integer soLuongBan = rs.getInt("soLuongBan");
                String soFa = rs.getString("soFa");
                Integer soLuongSoFa =rs.getInt("soLuongSoFa");
                String danLoa = rs.getString("danLoa");
                String moTa = rs.getString("moTa");
                Boolean tinhTrangBaoTri = rs.getBoolean("tinhTrangBaoTri");
                String hinhAnh  = rs.getString("hinhAnh");               
                Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, dienTich, chieuCao, vatLieuCachAm, tiVi, soLuongTiVi, thuongHieuTiVi, ban, soLuongBan, soFa, soLuongSoFa, danLoa, moTa, tinhTrangBaoTri, hinhAnh);
                lstP.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
	}
	return lstP;
    }
    //Tìm theo tiVi
    public ArrayList<Phong> timTheoTiVi(String tt) {
	ArrayList<Phong> lstP = new ArrayList<Phong>();
	try {
	ConnectDB.getIntance().connect();
	Connection con = ConnectDB.getConnection();

	String sql = "SELECT * FROM Phong WHERE tiVi = ?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, tt);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
            String maPhong = rs.getString("maPhong");
            TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThaiPhong"));      
            LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong")); 
            Float dienTich = rs.getFloat("dienTich");           
            Float chieuCao = rs.getFloat("chieuCao");
            String vatLieuCachAm = rs.getString("vatLieuCachAm");
            String tiVi = rs.getString("tiVi");        
            Integer soLuongTiVi = rs.getInt("soLuongTiVi");
            String thuongHieuTiVi = rs.getString("thuongHieuTiVi");
            String ban = rs.getString("ban");
            Integer soLuongBan = rs.getInt("soLuongBan");
            String soFa = rs.getString("soFa");
            Integer soLuongSoFa =rs.getInt("soLuongSoFa");
            String danLoa = rs.getString("danLoa");
            String moTa = rs.getString("moTa");
            Boolean tinhTrangBaoTri = rs.getBoolean("tinhTrangBaoTri");
            String hinhAnh  = rs.getString("hinhAnh");               
            Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, dienTich, chieuCao, vatLieuCachAm, tiVi, soLuongTiVi, thuongHieuTiVi, ban, soLuongBan, soFa, soLuongSoFa, danLoa, moTa, tinhTrangBaoTri, hinhAnh);
                lstP.add(p);
            }
	} catch (Exception e) {
            e.printStackTrace();
			// TODO: handle exception
	}
	return lstP;
    }
    //Tìm theo sô lượng tiVi
    public ArrayList<Phong> timTheoSoLuongTiVi(Integer tt) {
	ArrayList<Phong> lstP = new ArrayList<Phong>();
	try {
	ConnectDB.getIntance().connect();
	Connection con = ConnectDB.getConnection();

	String sql = "SELECT * FROM Phong WHERE soLuongTiVi = ?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1, tt);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
            String maPhong = rs.getString("maPhong");
            TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThaiPhong"));      
            LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong")); 
            Float dienTich = rs.getFloat("dienTich");           
            Float chieuCao = rs.getFloat("chieuCao");
            String vatLieuCachAm = rs.getString("vatLieuCachAm");
            String tiVi = rs.getString("tiVi");        
            Integer soLuongTiVi = rs.getInt("soLuongTiVi");
            String thuongHieuTiVi = rs.getString("thuongHieuTiVi");
            String ban = rs.getString("ban");
            Integer soLuongBan = rs.getInt("soLuongBan");
            String soFa = rs.getString("soFa");
            Integer soLuongSoFa =rs.getInt("soLuongSoFa");
            String danLoa = rs.getString("danLoa");
            String moTa = rs.getString("moTa");
            Boolean tinhTrangBaoTri = rs.getBoolean("tinhTrangBaoTri");
            String hinhAnh  = rs.getString("hinhAnh");                
            Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, dienTich, chieuCao, vatLieuCachAm, tiVi, soLuongTiVi, thuongHieuTiVi, ban, soLuongBan, soFa, soLuongSoFa, danLoa, moTa, tinhTrangBaoTri, hinhAnh);
                lstP.add(p);
            }
	} catch (Exception e) {
            e.printStackTrace();
			// TODO: handle exception
	}
	return lstP;
    }
    //Tìm theo sô lượng tiVi
    public ArrayList<Phong> timTheoThuongHieuTiVi(String tt) {
	ArrayList<Phong> lstP = new ArrayList<Phong>();
	try {
	ConnectDB.getIntance().connect();
	Connection con = ConnectDB.getConnection();

	String sql = "SELECT * FROM Phong WHERE thuongHieuTiVi = ?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, tt);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
            String maPhong = rs.getString("maPhong");
            TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThaiPhong"));      
            LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong")); 
            Float dienTich = rs.getFloat("dienTich");           
            Float chieuCao = rs.getFloat("chieuCao");
            String vatLieuCachAm = rs.getString("vatLieuCachAm");
            String tiVi = rs.getString("tiVi");        
            Integer soLuongTiVi = rs.getInt("soLuongTiVi");
            String thuongHieuTiVi = rs.getString("thuongHieuTiVi");
            String ban = rs.getString("ban");
            Integer soLuongBan = rs.getInt("soLuongBan");
            String soFa = rs.getString("soFa");
            Integer soLuongSoFa =rs.getInt("soLuongSoFa");
            String danLoa = rs.getString("danLoa");
            String moTa = rs.getString("moTa");
            Boolean tinhTrangBaoTri = rs.getBoolean("tinhTrangBaoTri");
            String hinhAnh  = rs.getString("hinhAnh");               
            Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, dienTich, chieuCao, vatLieuCachAm, tiVi, soLuongTiVi, thuongHieuTiVi, ban, soLuongBan, soFa, soLuongSoFa, danLoa, moTa, tinhTrangBaoTri, hinhAnh);
                lstP.add(p);
            }
	} catch (Exception e) {
            e.printStackTrace();
			// TODO: handle exception
	}
	return lstP;
    }
    //Tìm theo bàn
    public ArrayList<Phong> timTheoBan(String tt) {
	ArrayList<Phong> lstP = new ArrayList<Phong>();
	try {
	ConnectDB.getIntance().connect();
	Connection con = ConnectDB.getConnection();

	String sql = "SELECT * FROM Phong WHERE ban = ?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, tt);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
            String maPhong = rs.getString("maPhong");
            TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThaiPhong"));      
            LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong")); 
            Float dienTich = rs.getFloat("dienTich");           
            Float chieuCao = rs.getFloat("chieuCao");
            String vatLieuCachAm = rs.getString("vatLieuCachAm");
            String tiVi = rs.getString("tiVi");        
            Integer soLuongTiVi = rs.getInt("soLuongTiVi");
            String thuongHieuTiVi = rs.getString("thuongHieuTiVi");
            String ban = rs.getString("ban");
            Integer soLuongBan = rs.getInt("soLuongBan");
            String soFa = rs.getString("soFa");
            Integer soLuongSoFa =rs.getInt("soLuongSoFa");
            String danLoa = rs.getString("danLoa");
            String moTa = rs.getString("moTa");
            Boolean tinhTrangBaoTri = rs.getBoolean("tinhTrangBaoTri");
            String hinhAnh  = rs.getString("hinhAnh");                
            Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, dienTich, chieuCao, vatLieuCachAm, tiVi, soLuongTiVi, thuongHieuTiVi, ban, soLuongBan, soFa, soLuongSoFa, danLoa, moTa, tinhTrangBaoTri, hinhAnh);
                lstP.add(p);
            }
	} catch (Exception e) {
            e.printStackTrace();
			// TODO: handle exception
	}
	return lstP;
    }
    //Tìm theo số lượng bàn
    public ArrayList<Phong> timTheoSoLuongBan(Integer tt) {
	ArrayList<Phong> lstP = new ArrayList<Phong>();
	try {
	ConnectDB.getIntance().connect();
	Connection con = ConnectDB.getConnection();

	String sql = "SELECT * FROM Phong WHERE soLuongBan = ?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1, tt);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
            String maPhong = rs.getString("maPhong");
            TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThaiPhong"));      
            LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong")); 
            Float dienTich = rs.getFloat("dienTich");           
            Float chieuCao = rs.getFloat("chieuCao");
            String vatLieuCachAm = rs.getString("vatLieuCachAm");
            String tiVi = rs.getString("tiVi");        
            Integer soLuongTiVi = rs.getInt("soLuongTiVi");
            String thuongHieuTiVi = rs.getString("thuongHieuTiVi");
            String ban = rs.getString("ban");
            Integer soLuongBan = rs.getInt("soLuongBan");
            String soFa = rs.getString("soFa");
            Integer soLuongSoFa =rs.getInt("soLuongSoFa");
            String danLoa = rs.getString("danLoa");
            String moTa = rs.getString("moTa");
            Boolean tinhTrangBaoTri = rs.getBoolean("tinhTrangBaoTri");
            String hinhAnh  = rs.getString("hinhAnh");     
            Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, dienTich, chieuCao, vatLieuCachAm, tiVi, soLuongTiVi, thuongHieuTiVi, ban, soLuongBan, soFa, soLuongSoFa, danLoa, moTa, tinhTrangBaoTri, hinhAnh);
                lstP.add(p);
            }
	} catch (Exception e) {
            e.printStackTrace();
			// TODO: handle exception
	}
	return lstP;
    }
    //Tìm theo soFa
    public ArrayList<Phong> timTheoSoFa(String tt) {
	ArrayList<Phong> lstP = new ArrayList<Phong>();
	try {
	ConnectDB.getIntance().connect();
	Connection con = ConnectDB.getConnection();

	String sql = "SELECT * FROM Phong WHERE soFa = ?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, tt);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
            String maPhong = rs.getString("maPhong");
            TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThaiPhong"));      
            LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong")); 
            Float dienTich = rs.getFloat("dienTich");           
            Float chieuCao = rs.getFloat("chieuCao");
            String vatLieuCachAm = rs.getString("vatLieuCachAm");
            String tiVi = rs.getString("tiVi");        
            Integer soLuongTiVi = rs.getInt("soLuongTiVi");
            String thuongHieuTiVi = rs.getString("thuongHieuTiVi");
            String ban = rs.getString("ban");
            Integer soLuongBan = rs.getInt("soLuongBan");
            String soFa = rs.getString("soFa");
            Integer soLuongSoFa =rs.getInt("soLuongSoFa");
            String danLoa = rs.getString("danLoa");
            String moTa = rs.getString("moTa");
            Boolean tinhTrangBaoTri = rs.getBoolean("tinhTrangBaoTri");
            String hinhAnh  = rs.getString("hinhAnh");            
            Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, dienTich, chieuCao, vatLieuCachAm, tiVi, soLuongTiVi, thuongHieuTiVi, ban, soLuongBan, soFa, soLuongSoFa, danLoa, moTa, tinhTrangBaoTri, hinhAnh);
                lstP.add(p);
            }
	} catch (Exception e) {
            e.printStackTrace();
			// TODO: handle exception
	}
	return lstP;
    }
    //Tìm theo số lượng soFa
    public ArrayList<Phong> timTheoSoLuongSoFa(Integer tt) {
	ArrayList<Phong> lstP = new ArrayList<Phong>();
	try {
	ConnectDB.getIntance().connect();
	Connection con = ConnectDB.getConnection();

	String sql = "SELECT * FROM Phong WHERE soLuongSoFa  = ?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1, tt);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
            String maPhong = rs.getString("maPhong");
            TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThaiPhong"));      
            LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong")); 
            Float dienTich = rs.getFloat("dienTich");           
            Float chieuCao = rs.getFloat("chieuCao");
            String vatLieuCachAm = rs.getString("vatLieuCachAm");
            String tiVi = rs.getString("tiVi");        
            Integer soLuongTiVi = rs.getInt("soLuongTiVi");
            String thuongHieuTiVi = rs.getString("thuongHieuTiVi");
            String ban = rs.getString("ban");
            Integer soLuongBan = rs.getInt("soLuongBan");
            String soFa = rs.getString("soFa");
            Integer soLuongSoFa =rs.getInt("soLuongSoFa");
            String danLoa = rs.getString("danLoa");
            String moTa = rs.getString("moTa");
            Boolean tinhTrangBaoTri = rs.getBoolean("tinhTrangBaoTri");
            String hinhAnh  = rs.getString("hinhAnh");                
            Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, dienTich, chieuCao, vatLieuCachAm, tiVi, soLuongTiVi, thuongHieuTiVi, ban, soLuongBan, soFa, soLuongSoFa, danLoa, moTa, tinhTrangBaoTri, hinhAnh);
                lstP.add(p);
            }
	} catch (Exception e) {
            e.printStackTrace();
			// TODO: handle exception
	}
	return lstP;
    }
    //Tìm theo dàn loa
    public ArrayList<Phong> timTheoDanLoa(String tt) {
	ArrayList<Phong> lstP = new ArrayList<Phong>();
	try {
	ConnectDB.getIntance().connect();
	Connection con = ConnectDB.getConnection();

	String sql = "SELECT * FROM Phong WHERE danLoa = ?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, tt);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
            String maPhong = rs.getString("maPhong");
            TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThaiPhong"));      
            LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong")); 
            Float dienTich = rs.getFloat("dienTich");           
            Float chieuCao = rs.getFloat("chieuCao");
            String vatLieuCachAm = rs.getString("vatLieuCachAm");
            String tiVi = rs.getString("tiVi");        
            Integer soLuongTiVi = rs.getInt("soLuongTiVi");
            String thuongHieuTiVi = rs.getString("thuongHieuTiVi");
            String ban = rs.getString("ban");
            Integer soLuongBan = rs.getInt("soLuongBan");
            String soFa = rs.getString("soFa");
            Integer soLuongSoFa =rs.getInt("soLuongSoFa");
            String danLoa = rs.getString("danLoa");
            String moTa = rs.getString("moTa");
            Boolean tinhTrangBaoTri = rs.getBoolean("tinhTrangBaoTri");
            String hinhAnh  = rs.getString("hinhAnh");                
            Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, dienTich, chieuCao, vatLieuCachAm, tiVi, soLuongTiVi, thuongHieuTiVi, ban, soLuongBan, soFa, soLuongSoFa, danLoa, moTa, tinhTrangBaoTri, hinhAnh);
                lstP.add(p);
            }
	} catch (Exception e) {
            e.printStackTrace();
			// TODO: handle exception
	}
	return lstP;
    }
    //Tìm theo tình trạng bảo trì
    public ArrayList<Phong> timTheoTinhTrangBaoTri(Boolean tt) {
	ArrayList<Phong> lstP = new ArrayList<Phong>();
	try {
	ConnectDB.getIntance().connect();
	Connection con = ConnectDB.getConnection();

	String sql = "SELECT * FROM Phong WHERE tinhTrangBaoTri = ?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setBoolean(1, tt);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
            String maPhong = rs.getString("maPhong");
            TrangThaiPhong trangThaiPhong = new TrangThaiPhong(rs.getString("maTrangThaiPhong"));      
            LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong")); 
            Float dienTich = rs.getFloat("dienTich");           
            Float chieuCao = rs.getFloat("chieuCao");
            String vatLieuCachAm = rs.getString("vatLieuCachAm");
            String tiVi = rs.getString("tiVi");        
            Integer soLuongTiVi = rs.getInt("soLuongTiVi");
            String thuongHieuTiVi = rs.getString("thuongHieuTiVi");
            String ban = rs.getString("ban");
            Integer soLuongBan = rs.getInt("soLuongBan");
            String soFa = rs.getString("soFa");
            Integer soLuongSoFa =rs.getInt("soLuongSoFa");
            String danLoa = rs.getString("danLoa");
            String moTa = rs.getString("moTa");
            Boolean tinhTrangBaoTri = rs.getBoolean("tinhTrangBaoTri");
            String hinhAnh  = rs.getString("hinhAnh");              
            Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, dienTich, chieuCao, vatLieuCachAm, tiVi, soLuongTiVi, thuongHieuTiVi, ban, soLuongBan, soFa, soLuongSoFa, danLoa, moTa, tinhTrangBaoTri, hinhAnh);
                lstP.add(p);
            }
	} catch (Exception e) {
            e.printStackTrace();
			// TODO: handle exception
	}
	return lstP;
    }
    
    //Lấy danh sách đặt phòng
    public ArrayList<Phong> getAllPhongvaLoaiPhong() {
        ArrayList<Phong> ds = new ArrayList<>();
        String sql = "SELECT p.maPhong, p.maTrangThaiPhong, p.maLoaiPhong ,p.luotCho, lp.sucChua, lp.giaTien from Phong p join LoaiPhong lp on p.maLoaiPhong = lp.maLoaiPhong";
        try{
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                String maPhong = rs.getString("maPhong");
                int luotCho = rs.getInt("luotCho");
                TrangThaiPhong trangThaiPhong = new TrangThaiPhong( rs.getString("maTrangThaiPhong"));
                LoaiPhong loaiPhong = new LoaiPhong( rs.getString("maLoaiPhong"));
                LoaiPhong sucChua = new LoaiPhong( rs.getString("maLoaiPhong"), rs.getInt("sucChua"));
                LoaiPhong giaTien = new LoaiPhong( rs.getString("maLoaiPhong"), rs.getDouble("giaTien"));
                Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, sucChua, giaTien, luotCho);                   
                ds.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ds;
    }
    
    //Tìm phòng theo trạng thái
    public ArrayList<Phong> timPhongTheoTrangThai(String maTT){
        ArrayList<Phong> ds = new ArrayList<>();
        String sql = "SELECT p.maPhong, p.maTrangThaiPhong, p.maLoaiPhong , p.luotCho, lp.sucChua, lp.giaTien from Phong p join LoaiPhong lp on p.maLoaiPhong = lp.maLoaiPhong where p.maTrangThaiPhong =?";
        try{
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maTT);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String maPhong = rs.getString("maPhong");
                int luotCho = rs.getInt("luotCho");
                TrangThaiPhong trangThaiPhong = new TrangThaiPhong( rs.getString("maTrangThaiPhong"));
                LoaiPhong loaiPhong = new LoaiPhong( rs.getString("maLoaiPhong"));
                LoaiPhong sucChua = new LoaiPhong( rs.getString("maLoaiPhong"), rs.getInt("sucChua"));
                LoaiPhong giaTien = new LoaiPhong( rs.getString("maLoaiPhong"), rs.getDouble("giaTien"));
                Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, sucChua, giaTien, luotCho);                   
                ds.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ds;
    }
    
    //Tìm theo loại
    public ArrayList<Phong> timPhongTheoLoaiPhong(String maLoai){
        ArrayList<Phong> ds = new ArrayList<>();
        String sql = "SELECT p.maPhong, p.maTrangThaiPhong, p.maLoaiPhong, p.luotCho, lp.sucChua, lp.giaTien from Phong p join LoaiPhong lp on p.maLoaiPhong = lp.maLoaiPhong where p.maLoaiPhong =?";
        try{
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maLoai);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String maPhong = rs.getString("maPhong");
                int luotCho = rs.getInt("luotCho");
                TrangThaiPhong trangThaiPhong = new TrangThaiPhong( rs.getString("maTrangThaiPhong"));
                LoaiPhong loaiPhong = new LoaiPhong( rs.getString("maLoaiPhong"));
                LoaiPhong sucChua = new LoaiPhong( rs.getString("maLoaiPhong"), rs.getInt("sucChua"));
                LoaiPhong giaTien = new LoaiPhong( rs.getString("maLoaiPhong"), rs.getDouble("giaTien"));
                Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, sucChua, giaTien, luotCho);                   
                ds.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ds;
    }
    
    //Tim phòng theo trang thái và so người
    public ArrayList<Phong> timPhongTheoTrangThaiVaSoNguoi(String trangThai, int sl){
        ArrayList<Phong> ds = new ArrayList<>();
        String maloaiPhong = null;
        if(sl>=1&&sl<=5){
            maloaiPhong = "PN";
        }else if(sl>5&&sl<=10){
            maloaiPhong = "PV";
        }else if(sl>10&&sl<=20){
            maloaiPhong = "PL";
        }else if(sl>20){
            maloaiPhong = "VIP";
        }
        
        String sql = "SELECT p.maPhong, p.maTrangThaiPhong, p.maLoaiPhong, p.luotCho, lp.sucChua, lp.giaTien from Phong p join LoaiPhong lp on p.maLoaiPhong = lp.maLoaiPhong where p.maTrangThaiPhong =? and p.maLoaiPhong=?";
        try{
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, trangThai);
            ps.setString(2, maloaiPhong);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String maPhong = rs.getString("maPhong");
                int luotCho = rs.getInt("luotCho");
                TrangThaiPhong trangThaiPhong = new TrangThaiPhong( rs.getString("maTrangThaiPhong"));
                LoaiPhong loaiPhong = new LoaiPhong( maloaiPhong);
                LoaiPhong sucChua = new LoaiPhong( rs.getString("maLoaiPhong"), rs.getInt("sucChua"));
                LoaiPhong giaTien = new LoaiPhong( rs.getString("maLoaiPhong"), rs.getDouble("giaTien"));
                Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, sucChua, giaTien, luotCho);                   
                ds.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ds;
    }
    
    //Tìm theo số người 
    public ArrayList<Phong> timPhongTheoSoNguoi(int sl){
        ArrayList<Phong> ds = new ArrayList<>();
        String maloaiPhong = null;
        if(sl>=1&&sl<=5){
            maloaiPhong = "PN";
        }else if(sl>5&&sl<=10){
            maloaiPhong = "PV";
        }else if(sl>10&&sl<=20){
            maloaiPhong = "PL";
        }else if(sl>20){
            maloaiPhong = "VIP";
        }
        
        String sql = "SELECT p.maPhong, p.maTrangThaiPhong, p.maLoaiPhong, p.luotCho, lp.sucChua, lp.giaTien from Phong p join LoaiPhong lp on p.maLoaiPhong = lp.maLoaiPhong where p.maLoaiPhong=?";
        try{
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maloaiPhong);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String maPhong = rs.getString("maPhong");
                int luotCho = rs.getInt("luotCho");
                TrangThaiPhong trangThaiPhong = new TrangThaiPhong( rs.getString("maTrangThaiPhong"));
                LoaiPhong loaiPhong = new LoaiPhong( maloaiPhong);
                LoaiPhong sucChua = new LoaiPhong( rs.getString("maLoaiPhong"), rs.getInt("sucChua"));
                LoaiPhong giaTien = new LoaiPhong( rs.getString("maLoaiPhong"), rs.getDouble("giaTien"));
                Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, sucChua, giaTien, luotCho);                   
                ds.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ds;
    }
    
    //tìm theo ma Phong
    public ArrayList<Phong> timPhongTheoMaPhong(String maPhong){
        ArrayList<Phong> ds = new ArrayList<>();
        String sql = "SELECT p.maPhong, p.maTrangThaiPhong, p.maLoaiPhong, p.luotCho, lp.sucChua, lp.giaTien from Phong p join LoaiPhong lp on p.maLoaiPhong = lp.maLoaiPhong where p.maPhong =?";
        try{
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maPhong);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                TrangThaiPhong trangThaiPhong = new TrangThaiPhong( rs.getString("maTrangThaiPhong"));
                int luotChot = rs.getInt("luotCho");
                LoaiPhong loaiPhong = new LoaiPhong( rs.getString("maLoaiPhong"));
                LoaiPhong sucChua = new LoaiPhong( rs.getString("maLoaiPhong"), rs.getInt("sucChua"));
                LoaiPhong giaTien = new LoaiPhong( rs.getString("maLoaiPhong"), rs.getDouble("giaTien"));
                Phong p = new Phong(maPhong, trangThaiPhong, loaiPhong, sucChua, giaTien, luotChot);                   
                ds.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ds;
    }
    
    public boolean capNhatTrangThaiPhong(String maPhong,String trangThai){
        PreparedStatement ps = null;
        String sql="update Phong set maTrangThaiPhong = ? where maPhong = ?";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            ps = con.prepareStatement(sql);
            ps.setString(1, trangThai);
            ps.setString(2, maPhong);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
     //Sửa trạng thái sau khi thanh toán
    public void suaTrangThaiPhongTrongSauKhiThanhToan(Phong phongNew ) {
	PreparedStatement ps= null;
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();	 
            String sql = "UPDATE Phong SET maTrangThaiPhong = 'PT' WHERE maPhong = ?";
            ps = con.prepareStatement(sql); 
            ps.setString(1, phongNew.getMaPhong());
            ps.executeUpdate();	
	} catch (Exception e) {
            e.printStackTrace();	
	}
    }
    
    //Sửa trạng thái sau khi hủy
    public boolean capNhatTrangThaiPhongKhiHuy(String maPhong){     
        PreparedStatement ps = null;
        String sql = "UPDATE Phong SET maTrangThaiPhong = 'PT' WHERE maPhong = ?";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();           
            ps = con.prepareStatement(sql); 
            ps.setString(1, maPhong);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //Sửa trạng thái sau khi chuyển --> phòng sd cũ thành phòng trống
    public boolean capNhatTrangThaiPhongKhiChuyenThanhPT(String maPhong){     
        PreparedStatement ps = null;
        String sql = "UPDATE Phong SET maTrangThaiPhong = 'PT' WHERE maPhong = ?";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();           
            ps = con.prepareStatement(sql); 
            ps.setString(1, maPhong);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //Sửa trạng thái sau khi chuyển --> phòng pc cũ thành phòng trống
    public boolean capNhatTrangThaiPhongKhiChuyenThanhPC(String maPhongnNew){     
        PreparedStatement ps = null;
        String sql = "UPDATE Phong SET maTrangThaiPhong = 'PC' WHERE maPhong = ?";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();           
            ps = con.prepareStatement(sql); 
            ps.setString(1, maPhongnNew);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
     
    //Sửa trạng thái sau khi chuyển --> phòng sd cũ thành phòng trống
    public boolean capNhatTrangThaiPhongKhiChuyenThanhSD(String maPhongNew){     
        PreparedStatement ps = null;
        String sql = "UPDATE Phong SET maTrangThaiPhong = 'SD' WHERE maPhong = ?";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();           
            ps = con.prepareStatement(sql); 
            ps.setString(1, maPhongNew);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }    
    
    //Danh sach phong trong
    public ArrayList<Phong> getDanhSachPhongTrong(){
        ArrayList<Phong> dsPhong = new ArrayList<Phong>();
	try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM Phong\n" +
                        "WHERE maTrangThaiPhong = 'PT'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Phong p = new Phong();
                p.setMaPhong(rs.getString("maPhong"));
                p.setTrangThaiPhong(new TrangThaiPhong(rs.getString("maTrangThaiPhong")));
                p.setLoaiPhong(new LoaiPhong(rs.getString("maLoaiPhong")));
                p.setDienTich(rs.getFloat("dienTich"));
                p.setChieuCao(rs.getFloat("chieuCao"));
                p.setVatLieuCachAm(rs.getString("vatLieuCachAm"));
                p.setTiVi(rs.getString("tiVi"));
                p.setSoLuongTiVi(rs.getInt("soLuongTiVi"));
                p.setThuongHieuTiVi(rs.getString("thuongHieuTiVi"));
                p.setBan(rs.getString("ban"));
                p.setSoLuongBan(rs.getInt("soLuongBan"));
                p.setSoFa(rs.getString("soFa"));
                p.setSoLuongSoFa(rs.getInt("soLuongSoFa"));
                p.setDanLoa(rs.getString("danLoa"));
                p.setMoTa(rs.getString("moTa"));
                p.setTinhTrangBaoTri(rs.getBoolean("tinhTrangBaoTri"));
                p.setHinhAnh(rs.getString("hinhAnh"));  
		dsPhong.add(p);
            }
	} catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsPhong;
    }
    
    public void tangLuotCho(String maPhong){
        PreparedStatement ps = null;
        String sql="update Phong set luotCho = luotCho+1 where maPhong = ?";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            ps = con.prepareStatement(sql);
            ps.setString(1, maPhong);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void giamLuotCho(String maPhong){
        PreparedStatement ps = null;
        String sql="update Phong set luotCho = luotCho-1 where maPhong = ?";
        try {
            connectDB.ConnectDB.getIntance().connect();
            Connection con = connectDB.ConnectDB.getConnection();
            
            ps = con.prepareStatement(sql);
            ps.setString(1, maPhong);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
