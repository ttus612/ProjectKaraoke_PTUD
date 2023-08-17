package entity;

import java.util.Objects;

public class TaiKhoan {
    private String maTaiKhoan;
    private String maNhanvien;
    private String userName;
    private String passWord;

    public TaiKhoan(String maTaiKhoan, String maNhanvien) {
       
        this.maTaiKhoan = maTaiKhoan;
        this.maNhanvien = maNhanvien;
    }

    public TaiKhoan(String maTaiKhoan, String maNhanvien, String userName, String passWord) {
        this.maTaiKhoan = maTaiKhoan;
        this.maNhanvien = maNhanvien;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public String getMaNhanvien() {
        return maNhanvien;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public void setMaNhanvien(String maNhanvien) {
        this.maNhanvien = maNhanvien;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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
        final TaiKhoan other = (TaiKhoan) obj;
        return Objects.equals(this.maTaiKhoan, other.maTaiKhoan);
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "maTaiKhoan=" + maTaiKhoan + ", maNhanvien=" + maNhanvien + ", userName=" + userName + ", passWord=" + passWord + '}';
    }
}
