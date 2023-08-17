package entity;

import java.util.Objects;

/**
 *
 * @author THANHTU
 */
public class Phong {
    private String maPhong;
    private TrangThaiPhong trangThaiPhong;
    private LoaiPhong loaiPhong;
    private float dienTich;
    private float chieuCao;
    private String vatLieuCachAm;
    private String tiVi;
    private int soLuongTiVi;
    private String thuongHieuTiVi;
    private String ban;
    private int soLuongBan;
    private String soFa;
    private int soLuongSoFa;
    private String danLoa;
    private String moTa;
    private boolean tinhTrangBaoTri;
    private String hinhAnh;
    private int luotCho;

    public int getLuotCho() {
        return luotCho;
    }

    public void setLuotCho(int luotCho) {
        this.luotCho = luotCho;
    }
    
    

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public TrangThaiPhong getTrangThaiPhong() {
        return trangThaiPhong;
    }

    public void setTrangThaiPhong(TrangThaiPhong trangThaiPhong) {
        this.trangThaiPhong = trangThaiPhong;
    }

    public LoaiPhong getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(LoaiPhong loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public float getDienTich() {
        return dienTich;
    }

    public void setDienTich(float dienTich) {
        this.dienTich = dienTich;
    }

    public float getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(float chieuCao) {
        this.chieuCao = chieuCao;
    }

    public String getVatLieuCachAm() {
        return vatLieuCachAm;
    }

    public void setVatLieuCachAm(String vatLieuCachAm) {
        this.vatLieuCachAm = vatLieuCachAm;
    }

    public String getTiVi() {
        return tiVi;
    }

    public void setTiVi(String tiVi) {
        this.tiVi = tiVi;
    }

    public int getSoLuongTiVi() {
        return soLuongTiVi;
    }

    public void setSoLuongTiVi(int soLuongTiVi) {
        this.soLuongTiVi = soLuongTiVi;
    }

    public String getThuongHieuTiVi() {
        return thuongHieuTiVi;
    }

    public void setThuongHieuTiVi(String thuongHieuTiVi) {
        this.thuongHieuTiVi = thuongHieuTiVi;
    }

    public String getBan() {
        return ban;
    }

    public void setBan(String ban) {
        this.ban = ban;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public String getSoFa() {
        return soFa;
    }

    public void setSoFa(String soFa) {
        this.soFa = soFa;
    }

    public int getSoLuongSoFa() {
        return soLuongSoFa;
    }

    public void setSoLuongSoFa(int soLuongSoFa) {
        this.soLuongSoFa = soLuongSoFa;
    }

    public String getDanLoa() {
        return danLoa;
    }

    public void setDanLoa(String danLoa) {
        this.danLoa = danLoa;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public boolean isTinhTrangBaoTri() {
        return tinhTrangBaoTri;
    }

    public void setTinhTrangBaoTri(boolean tinhTrangBaoTri) {
        this.tinhTrangBaoTri = tinhTrangBaoTri;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Phong() {
    }

    public Phong(String maPhong) {
        this.maPhong = maPhong;
    }
    
    public Phong(String maPhong, TrangThaiPhong trangThaiPhong, LoaiPhong loaiPhong,LoaiPhong suaChua, LoaiPhong giaTien, int luotCho) {
        this.maPhong = maPhong;
        this.trangThaiPhong = trangThaiPhong;
        this.loaiPhong = loaiPhong;
        this.loaiPhong =  suaChua;
        this.loaiPhong =  giaTien;
        this.luotCho = luotCho;
    }
    
    public Phong(String maPhong, TrangThaiPhong trangThaiPhong, LoaiPhong loaiPhong, float dienTich, float chieuCao, String vatLieuCachAm, String tiVi, int soLuongTiVi, String thuongHieuTiVi, String ban, int soLuongBan, String soFa, int soLuongSoFa, String danLoa, String moTa, boolean tinhTrangBaoTri, String hinhAnh) {
        this.maPhong = maPhong;
        this.trangThaiPhong = trangThaiPhong;
        this.loaiPhong = loaiPhong;
        this.dienTich = dienTich;
        this.chieuCao = chieuCao;
        this.vatLieuCachAm = vatLieuCachAm;
        this.tiVi = tiVi;
        this.soLuongTiVi = soLuongTiVi;
        this.thuongHieuTiVi = thuongHieuTiVi;
        this.ban = ban;
        this.soLuongBan = soLuongBan;
        this.soFa = soFa;
        this.soLuongSoFa = soLuongSoFa;
        this.danLoa = danLoa;
        this.moTa = moTa;
        this.tinhTrangBaoTri = tinhTrangBaoTri;
        this.hinhAnh = hinhAnh;
    }

    public Phong(String maPhong, TrangThaiPhong trangThaiPhong, LoaiPhong loaiPhong, float dienTich, float chieuCao, String vatLieuCachAm, String tiVi, int soLuongTiVi, String thuongHieuTiVi, String ban, int soLuongBan, String soFa, int soLuongSoFa, String danLoa, String moTa, boolean tinhTrangBaoTri, String hinhAnh, int luotCho) {
        this.maPhong = maPhong;
        this.trangThaiPhong = trangThaiPhong;
        this.loaiPhong = loaiPhong;
        this.dienTich = dienTich;
        this.chieuCao = chieuCao;
        this.vatLieuCachAm = vatLieuCachAm;
        this.tiVi = tiVi;
        this.soLuongTiVi = soLuongTiVi;
        this.thuongHieuTiVi = thuongHieuTiVi;
        this.ban = ban;
        this.soLuongBan = soLuongBan;
        this.soFa = soFa;
        this.soLuongSoFa = soLuongSoFa;
        this.danLoa = danLoa;
        this.moTa = moTa;
        this.tinhTrangBaoTri = tinhTrangBaoTri;
        this.hinhAnh = hinhAnh;
        this.luotCho = luotCho;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.maPhong);
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
        final Phong other = (Phong) obj;
        return Objects.equals(this.maPhong, other.maPhong);
    }

    @Override
    public String toString() {
        return "Phong{" + "maPhong=" + maPhong + ", trangThaiPhong=" + trangThaiPhong + ", loaiPhong=" + loaiPhong + ", dienTich=" + dienTich + ", chieuCao=" + chieuCao + ", vatLieuCachAm=" + vatLieuCachAm + ", tiVi=" + tiVi + ", soLuongTiVi=" + soLuongTiVi + ", thuongHieuTiVi=" + thuongHieuTiVi + ", ban=" + ban + ", soLuongBan=" + soLuongBan + ", soFa=" + soFa + ", soLuongSoFa=" + soLuongSoFa + ", danLoa=" + danLoa + ", moTa=" + moTa + ", tinhTrangBaoTri=" + tinhTrangBaoTri + ", hinhAnh=" + hinhAnh + '}';
    }

}
