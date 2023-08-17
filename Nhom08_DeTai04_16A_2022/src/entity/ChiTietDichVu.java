package entity;

import java.util.Objects;

public class ChiTietDichVu {
    private DichVu dichVu;
    private HoaDon hoaDon; 
    private int soLuong;

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public ChiTietDichVu() {
    }


    public ChiTietDichVu(DichVu dichVu, HoaDon hoaDon, int soLuong) {
        this.dichVu = dichVu;
        this.hoaDon = hoaDon;
        this.soLuong = soLuong;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.dichVu);
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
        final ChiTietDichVu other = (ChiTietDichVu) obj;
        return Objects.equals(this.dichVu, other.dichVu);
    }

    @Override
    public String toString() {
        return "ChiTietDichVu{" + "dichVu=" + dichVu + ", hoaDon=" + hoaDon + ", soLuong=" + soLuong + '}';
    }

   
}
