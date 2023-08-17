package entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class KhachHang {
    private String maKhachHang, hoTenKhachHang, CCDD, soDienThoai, diaChi;
    private Date ngaySinh;
    private boolean gioiTinh;
    private HoaDon hd;
    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String hoTenKhachHang, String CCDD, String soDienThoai, String diaChi, Date ngaySinh, boolean gioiTinh) {
        this.maKhachHang = maKhachHang;
        this.hoTenKhachHang = hoTenKhachHang;
        this.CCDD = CCDD;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        
    }
    
    public  KhachHang(String makh){
        this.maKhachHang = makh;
    }

    public  KhachHang(String makh,String tenKhachHang,String soDienThoai){
        this.maKhachHang = makh;
        this.hoTenKhachHang=tenKhachHang;
        this.soDienThoai=soDienThoai;
    }
    
    public  KhachHang(String makh,String tenkhach,String sdt,HoaDon hd){
        this.maKhachHang = makh;
        this.hoTenKhachHang = tenkhach;
        this.soDienThoai = sdt;
        this.diaChi = diaChi;  
        this.hd=hd;
    }
    
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHoTenKhachHang() {
        return hoTenKhachHang;
    }

    public void setHoTenKhachHang(String hoTenKhachHang) {
        this.hoTenKhachHang = hoTenKhachHang;
    }

    public String getCCDD() {
        return CCDD;
    }

    public void setCCDD(String CCDD) {
        this.CCDD = CCDD;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
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
        final KhachHang other = (KhachHang) obj;
        return Objects.equals(this.maKhachHang, other.maKhachHang);
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKhachHang=" + maKhachHang + ", hoTenKhachHang=" + hoTenKhachHang + ", CCDD=" + CCDD + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + '}';
    }

    /**
     * @return the hd
     */
    public HoaDon getHd() {
        return hd;
    }

    /**
     * @param hd the hd to set
     */
    public void setHd(HoaDon hd) {
        this.hd = hd;
    }
}
