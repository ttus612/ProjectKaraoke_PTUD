package entity;

import java.util.Objects;

/**
 *
 * @author THANHTU
 */
public class LoaiPhong {
    private String maLoaiPhong;
    private String tenLoai;
    private int sucChua;
    private Double giaTien;

    public String getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

    public LoaiPhong() {
    }

    public LoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }
    
  

    public LoaiPhong(String maLoaiPhong, int sucChua) {
        this.maLoaiPhong = maLoaiPhong;
        this.sucChua = sucChua;
    }

    public LoaiPhong(String maLoaiPhong, Double giaTien) {
        this.maLoaiPhong = maLoaiPhong;
        this.giaTien = giaTien;
    }
    
    public LoaiPhong(String maLoaiPhong, String tenLoai, int sucChua, Double giaTien) {
        this.maLoaiPhong = maLoaiPhong;
        this.tenLoai = tenLoai;
        this.sucChua = sucChua;
        this.giaTien = giaTien;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.maLoaiPhong);
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
        final LoaiPhong other = (LoaiPhong) obj;
        return Objects.equals(this.maLoaiPhong, other.maLoaiPhong);
    }

    @Override
    public String toString() {
        return "LoaiPhong{" + "maLoaiPhong=" + maLoaiPhong + ", tenLoai=" + tenLoai + ", sucChua=" + sucChua + ", giaTien=" + giaTien + '}';
    }
}