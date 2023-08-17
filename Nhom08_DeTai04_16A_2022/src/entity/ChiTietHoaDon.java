package entity;

import java.util.Objects;

public class ChiTietHoaDon {
    private HoaDon hoaDon;
    private Phong phong;
    private int thoiLuongSuDung;

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public int getThoiLuongSuDung() {
        return thoiLuongSuDung;
    }

    public void setThoiLuongSuDung(int thoiLuongSuDung) {
        this.thoiLuongSuDung = thoiLuongSuDung;
    }

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(HoaDon hoaDon, int thoiLuongSuDung) {
        this.hoaDon = hoaDon;
        this.thoiLuongSuDung = thoiLuongSuDung;
    }
    
    public ChiTietHoaDon(HoaDon hoaDon, Phong phong, int thoiLuongSuDung) {
        this.hoaDon = hoaDon;
        this.phong = phong;
        this.thoiLuongSuDung = thoiLuongSuDung;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.hoaDon);
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
        final ChiTietHoaDon other = (ChiTietHoaDon) obj;
        return Objects.equals(this.hoaDon, other.hoaDon);
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "hoaDon=" + hoaDon + ", phong=" + phong + ", thoiLuongSuDung=" + thoiLuongSuDung + '}';
    }
}
