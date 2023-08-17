package entity;

public class LoaiNhanVien {
    private String maLoaiNhanVien, tenLoaiNhanVien;

    public LoaiNhanVien() {
    }

    public LoaiNhanVien(String maLoaiNhanVien) {
        this.maLoaiNhanVien = maLoaiNhanVien;
    }
    
    public LoaiNhanVien(String maLoaiNhanVien, String tenLoaiNhanVien) {
        this.maLoaiNhanVien = maLoaiNhanVien;
        this.tenLoaiNhanVien = tenLoaiNhanVien;
    }

    public String getMaLoaiNhanVien() {
        return maLoaiNhanVien;
    }

    public void setMaLoaiNhanVien(String maLoaiNhanVien) {
        this.maLoaiNhanVien = maLoaiNhanVien;
    }

    public String getTenLoaiNhanVien() {
        return tenLoaiNhanVien;
    }

    public void setTenLoaiNhanVien(String tenLoaiNhanVien) {
        this.tenLoaiNhanVien = tenLoaiNhanVien;
    }
    

    @Override
    public String toString() {
        return "LoaiNhanVien{" + "maLoaiNhanVien=" + maLoaiNhanVien + ", tenLoaiNhanVien=" + tenLoaiNhanVien + '}';
    }
}
