package entity;

import java.time.LocalDate;
import java.util.Objects;

public class NhanVien {
    private String maNhanVien, tenNhanVien, CCCD, 
           diaChi, soDienThoai, maLoaiNhanVien;
    private LocalDate ngaySinh;
    private Boolean gioiTinh, trangThaiLamViec;
    private LoaiNhanVien lnv;

    public NhanVien() {
    }
    
    
    public NhanVien(String maNhanVien,String tenNhanVien,String sdt,String diaChi){
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.soDienThoai = sdt;
        this.diaChi = diaChi;
    }

    public NhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public NhanVien(String maNhanVien, String tenNhanVien) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
    }
    
    public NhanVien(String maNhanVien, String tenNhanVien, String CCCD, String diaChi, String soDienThoai, String maLoaiNhanVien, LocalDate ngaySinh, Boolean gioiTinh, Boolean trangThaiLamViec,LoaiNhanVien lnv) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.CCCD = CCCD;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.maLoaiNhanVien = maLoaiNhanVien;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.trangThaiLamViec = trangThaiLamViec;
        this.lnv=lnv;
    }
//    bam vao insertCode tu tao 

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMaLoaiNhanVien() {
        return maLoaiNhanVien;
    }

    public void setMaLoaiNhanVien(String maLoaiNhanVien) {
        this.maLoaiNhanVien = maLoaiNhanVien;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Boolean getTrangThaiLamViec() {
        return trangThaiLamViec;
    }

    public void setTrangThaiLamViec(Boolean trangThaiLamViec) {
        this.trangThaiLamViec = trangThaiLamViec;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final NhanVien other = (NhanVien) obj;
        return Objects.equals(this.maNhanVien, other.maNhanVien);
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", CCCD=" + CCCD + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", maLoaiNhanVien=" + maLoaiNhanVien + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", trangThaiLamViec=" + trangThaiLamViec + '}';
    }

    public LoaiNhanVien getLnv() {
        return lnv;
    }

    public void setLnv(LoaiNhanVien lnv) {
        this.lnv = lnv;
    }

    public int setTrangThaiLamViec() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
