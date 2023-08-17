package entity;

import java.time.LocalDate;
import java.util.Objects;

public class SanPham {

    private String maSanPham;
    private String tenSanPham;
    private String noiLayHang;
    private String nhaCungCap;
    private LoaiSanPham loaiSanPham;
    private int soLuongSanPham;
    private LocalDate ngayNhapSanPham, hanSuDung;
    private double giaNhap;

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getNoiLayHang() {
        return noiLayHang;
    }

    public void setNoiLayHang(String noiLayHang) {
        this.noiLayHang = noiLayHang;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    public LocalDate getNgayNhapSanPham() {
        return ngayNhapSanPham;
    }

    public void setNgayNhapSanPham(LocalDate ngayNhapSanPham) {
        this.ngayNhapSanPham = ngayNhapSanPham;
    }

    public LocalDate getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(LocalDate hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public SanPham() {
    }

    public SanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public SanPham(String maSanPham, String tenSanPham) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
    }
    

    public SanPham(String maSanPham, String tenSanPham, String noiLayHang, String nhaCungCap, LoaiSanPham loaiSanPham, int soLuongSanPham, LocalDate ngayNhapSanPham, LocalDate hanSuDung, double giaNhap) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.noiLayHang = noiLayHang;
        this.nhaCungCap = nhaCungCap;
        this.loaiSanPham = loaiSanPham;
        this.soLuongSanPham = soLuongSanPham;
        this.ngayNhapSanPham = ngayNhapSanPham;
        this.hanSuDung = hanSuDung;
        this.giaNhap = giaNhap;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.maSanPham);
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
        final SanPham other = (SanPham) obj;
        return Objects.equals(this.maSanPham, other.maSanPham);
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", noiLayHang=" + noiLayHang + ", nhaCungCap=" + nhaCungCap + ", loaiSanPham=" + loaiSanPham + ", soLuongSanPham=" + soLuongSanPham + ", ngayNhapSanPham=" + ngayNhapSanPham + ", hanSuDung=" + hanSuDung + ", giaNhap=" + giaNhap + '}';
    }

}
