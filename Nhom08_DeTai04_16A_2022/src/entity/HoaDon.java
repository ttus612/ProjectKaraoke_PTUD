package entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class HoaDon {
    private String maHoaDon; 
    private NhanVien nhanVien;
    private KhachHang khachHang;
    private Date ngayLap;
    private LocalTime gioNhanPhong;
    private LocalTime gioKetThuc;
    private float thue;
    private float khuyenMai;
    private double tienKhachTra;
    private double tongTien;
    private boolean trangThai;
    private LoaiPhong loaiPhong;
    private int soHoaDon;

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public void setGioNhanPhong(LocalTime gioNhanPhong) {
        this.gioNhanPhong = gioNhanPhong;
    }

    public void setGioKetThuc(LocalTime gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public void setThue(float thue) {
        this.thue = thue;
    }

    public void setKhuyenMai(float khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public void setTienKhachTra(double tienKhachTra) {
        this.tienKhachTra = tienKhachTra;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public void setLoaiPhong(LoaiPhong loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public void setNgayLap1(LocalDate ngayLap1) {
        this.ngayLap1 = ngayLap1;
    }
    
    public HoaDon() {
    }
    public HoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
    
    public HoaDon(String maHoaDon,LocalDate ngayLap1,double tongTien,LoaiPhong loaiPhong,NhanVien nv,KhachHang kh) {
        this.maHoaDon = maHoaDon;
        this.ngayLap1 = ngayLap1;
        this.tongTien = tongTien;
        this.loaiPhong=loaiPhong;
        this.nhanVien =nv;
        this.khachHang=kh;
    }
    //Thya doikhachhang
    public HoaDon(KhachHang kh,LocalDate ngayLap1,double tongTien,int soHoaDon){
        this.khachHang=kh;
        this.ngayLap1=ngayLap1;
        this.tongTien=tongTien;
        this.soHoaDon=soHoaDon;
        
    }
    
     public HoaDon(String maHoaDon,KhachHang kh,LocalDate ngayLap1,double tongTien) {
        this.maHoaDon = maHoaDon;
        this.ngayLap1 = ngayLap1;
        this.khachHang = kh;
        this.tongTien = tongTien;
    }

     
     //Thay DOI LAN tHU N1
     public HoaDon(String maHoaDon,double tongTien,NhanVien nv){
         this.maHoaDon=maHoaDon;
         this.tongTien=tongTien;
         this.nhanVien=nv;
     }
     
     public HoaDon(KhachHang kh,String maHoaDon,NhanVien nv ,LocalDate ngayLap1 ,LocalTime gioNhanPhong,LocalTime gioKetThuc,Double tienkhachTra,Double tongTien ){
          this.khachHang =kh;
          this.nhanVien=nv;
         this.ngayLap1=ngayLap1;
         this.maHoaDon=maHoaDon;
         this.gioNhanPhong=gioNhanPhong;
         this.gioKetThuc=gioKetThuc;
         this.tienKhachTra=tienkhachTra;
         this.tongTien=tongTien;

     }
     
     // thay doi 2

    public HoaDon(String maHoaDon, NhanVien nv, KhachHang kh, LocalDate ngayLap1, LocalTime gioNhanPhong, LocalTime gioKetThuc, float thue, float khuyenMai, double tienKhachTra, double tongTien, boolean trangThai) {
        this.maHoaDon = maHoaDon;
        this.nhanVien=nv;
        this.khachHang=kh;
        this.ngayLap1 = ngayLap1;
        this.gioNhanPhong = gioNhanPhong;
        this.gioKetThuc = gioKetThuc;
        this.thue = thue;
        this.khuyenMai = khuyenMai;
        this.tienKhachTra = tienKhachTra;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }
    
    public HoaDon(KhachHang kh,double tongTien){
        this.khachHang=kh;
        this.tongTien=tongTien;
    }

    public HoaDon(String maHoaDon, LocalTime gioKetThuc) {
        this.maHoaDon = maHoaDon;
        this.gioKetThuc = gioKetThuc;
    }

    public HoaDon(String maHoaDon, float thue, float khuyenMai, double tienKhachTra, double tongTien, boolean trangThai) {
        this.maHoaDon = maHoaDon;
        this.thue = thue;
        this.khuyenMai = khuyenMai;
        this.tienKhachTra = tienKhachTra;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }
    
    

    public HoaDon(String maHoaDon, NhanVien nhanVien, KhachHang khachHang, Date ngayLap, LocalTime gioNhanPhong, LocalTime gioKetThuc, float thue, float khuyenMai, double tienKhachTra, double tongTien, boolean trangThai) {
        this.maHoaDon = maHoaDon;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.ngayLap = ngayLap;
        this.gioNhanPhong = gioNhanPhong;
        this.gioKetThuc = gioKetThuc;
        this.thue = thue;
        this.khuyenMai = khuyenMai;
        this.tienKhachTra = tienKhachTra;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public LocalTime getGioNhanPhong() {
        return gioNhanPhong;
    }

    public LocalTime getGioKetThuc() {
        return gioKetThuc;
    }

    public float getThue() {
        return thue;
    }

    public float getKhuyenMai() {
        return khuyenMai;
    }

    public double getTienKhachTra() {
        return tienKhachTra;
    }

    public double getTongTien() {
        return tongTien;
    }
    public LocalDate getNgayLap1() {
        return ngayLap1;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public LoaiPhong getLoaiPhong() {
        return loaiPhong;
    }


    public int getSoHoaDon() {
        return soHoaDon;
    }
   private LocalDate ngayLap1;
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.maHoaDon);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HoaDon other = (HoaDon) obj;
        return Objects.equals(this.maHoaDon, other.maHoaDon);
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHoaDon=" + maHoaDon + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", ngayLap=" + ngayLap + ", gioNhanPhong=" + gioNhanPhong + ", gioKetThuc=" + gioKetThuc + ", thue=" + thue + ", khuyenMai=" + khuyenMai + ", tienKhachTra=" + tienKhachTra + ", tongTien=" + tongTien + ", trangThai=" + trangThai + '}';
    } 
}
