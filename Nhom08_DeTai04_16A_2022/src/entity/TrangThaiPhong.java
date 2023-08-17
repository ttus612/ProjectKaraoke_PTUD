package entity;

import java.util.Objects;

/**
 *
 * @author THANHTU
 */
public class TrangThaiPhong {
    private String maTrangThaiPhong, tenTrangThaiPhong;

    public TrangThaiPhong() {
    }

    public TrangThaiPhong(String maTrangThaiPhong) {
        this.maTrangThaiPhong = maTrangThaiPhong;
    }

    public TrangThaiPhong(String maTrangThaiPhong, String tenTrangThaiPhong) {
        this.maTrangThaiPhong = maTrangThaiPhong;
        this.tenTrangThaiPhong = tenTrangThaiPhong;
    }

    public TrangThaiPhong(TrangThaiPhong trangThaiPhong) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getMaTrangThaiPhong() {
        return maTrangThaiPhong;
    }

    public void setMaTrangThaiPhong(String maTrangThaiPhong) {
        this.maTrangThaiPhong = maTrangThaiPhong;
    }

    public String getTenTrangThaiPhong() {
        return tenTrangThaiPhong;
    }

    public void setTenTrangThaiPhong(String tenTrangThaiPhong) {
        this.tenTrangThaiPhong = tenTrangThaiPhong;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final TrangThaiPhong other = (TrangThaiPhong) obj;
        return Objects.equals(this.maTrangThaiPhong, other.maTrangThaiPhong);
    }

    @Override
    public String toString() {
        return "TrangThaiPhong{" + "maTrangThaiPhong=" + maTrangThaiPhong + ", tenTrangThaiPhong=" + tenTrangThaiPhong + '}';
    }
}
