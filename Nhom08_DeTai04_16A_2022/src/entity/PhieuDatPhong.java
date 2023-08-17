package entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public  class PhieuDatPhong {
    private String maPhieuDatPhong; 
    private Phong phong;
    private NhanVien nhanVien;
    private KhachHang khachHang;
    private String ghiChu;
    private Timestamp thoiGianDat;
    private Timestamp thoiGianNhanPhong;
    private int soLuongNguoi;

    public String getMaPhieuDatPhong() {
        return maPhieuDatPhong;
    }

    public void setMaPhieuDatPhong(String maPhieuDatPhong) {
        this.maPhieuDatPhong = maPhieuDatPhong;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Timestamp getThoiGianDat() {
        return thoiGianDat;
    }

    public void setThoiGianDat(Timestamp thoiGianDat) {
        this.thoiGianDat = thoiGianDat;
    }

    public Timestamp getThoiGianNhanPhong() {
        return thoiGianNhanPhong;
    }

    public void setThoiGianNhanPhong(Timestamp thoiGianNhanPhong) {
        this.thoiGianNhanPhong = thoiGianNhanPhong;
    }

    public int getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public void setSoLuongNguoi(int soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }

    public PhieuDatPhong() {
    }

    public PhieuDatPhong(String maPhieuDatPhong) {
        this.maPhieuDatPhong = maPhieuDatPhong;
    }

    public PhieuDatPhong(String maPhieuDatPhong, Phong phong, NhanVien nhanVien, KhachHang khachHang, String ghiChu, Timestamp thoiGianDat, Timestamp thoiGianNhanPhong, int soLuongNguoi) {
        this.maPhieuDatPhong = maPhieuDatPhong;
        this.phong = phong;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.ghiChu = ghiChu;
        this.thoiGianDat = thoiGianDat;
        this.thoiGianNhanPhong = thoiGianNhanPhong;
        this.soLuongNguoi = soLuongNguoi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.maPhieuDatPhong);
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
        final PhieuDatPhong other = (PhieuDatPhong) obj;
        return Objects.equals(this.maPhieuDatPhong, other.maPhieuDatPhong);
    }

    @Override
    public String toString() {
        return "PhieuDatPhong{" + "maPhieuDatPhong=" + maPhieuDatPhong + ", phong=" + phong + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", ghiChu=" + ghiChu + ", thoiGianDat=" + thoiGianDat + ", thoiGianNhanPhong=" + thoiGianNhanPhong + ", soLuongNguoi=" + soLuongNguoi + '}';
    }
}
