package entity;

import dao.Dao_DichVu;
import dao.Dao_SanPham;
import java.util.Objects;

/**
 *
 * @author THANHTU
 */
public class DichVu {
    private String maDichVu;
    private SanPham sanPham;
    private String tenDichVu;
    private String donViTinh;
    private String hinhAnh;
    private boolean trangThaiDichVu;

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public boolean isTrangThaiDichVu() {
        return trangThaiDichVu;
    }

    public void setTrangThaiDichVu(boolean trangThaiDichVu) {
        this.trangThaiDichVu = trangThaiDichVu;
    }

    public DichVu() {
    }

    public DichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }  
   
    public DichVu(String maDichVu, String tenDichVu, String donViTinh ) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.donViTinh = donViTinh;
    }  
    
    public DichVu(String maDichVu, SanPham sanPham, String tenDichVu, String donViTinh, String hinhAnh, boolean trangThaiDichVu) {
        this.maDichVu = maDichVu;
        this.sanPham = sanPham;
        this.tenDichVu = tenDichVu;
        this.donViTinh = donViTinh;
        this.hinhAnh = hinhAnh;
        this.trangThaiDichVu = trangThaiDichVu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.maDichVu);
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
        final DichVu other = (DichVu) obj;
        return Objects.equals(this.maDichVu, other.maDichVu);
    }

    @Override
    public String toString() {
        return "DichVu{" + "maDichVu=" + maDichVu + ", sanPham=" + sanPham + ", tenDichVu=" + tenDichVu + ", donViTinh=" + donViTinh + ", hinhAnh=" + hinhAnh + ", trangThaiDichVu=" + trangThaiDichVu + '}';
    }

    public Double tinhGiaBan(String maSanPham) {
        Dao_SanPham  dao_SP = new Dao_SanPham();
        SanPham sp = dao_SP.timSPTheoMa(maSanPham);
        Double giaNhap = sp.getGiaNhap();
        Double giaDV = 0.0;
	giaDV =giaNhap + giaNhap*0.3;
        return giaDV;
    }
}
