
package gui.form;


import dao.Dao_LoaiPhong;
import dao.Dao_Phong;
import dao.Dao_TrangThaiPhong;
import entity.LoaiPhong;
import entity.Phong;
import entity.TrangThaiPhong;
import gui.swing.ImageHelper;
import gui.swing.JPanerRadiusBorder;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THANHTU
 */
public class Form_PhongHat extends javax.swing.JPanel {

    private Dao_Phong phong_dao = new Dao_Phong();    
    private Dao_LoaiPhong loaiPhong_dao = new Dao_LoaiPhong();
    private Dao_TrangThaiPhong trangThaiPhong_dao = new Dao_TrangThaiPhong();
    
    private Component parentForm;
    private DefaultTableModel moDelPhong;
    private ArrayList<Phong> listPhong;
 
    public Form_PhongHat() {//NHỚ THÊM THƯ VIỆN VÀO
        initComponents();
        btnLuuPhongKhiSua.setVisible(false);
        listPhong = phong_dao.getDanhSachPhong();//gán danh sách vào biến
        themDuLieuPhongVaoBang(listPhong);
        themDuLieuLoaiPhongVaoCBB();
        themDuLieuTrangThaiPhongVaoCBB();
    }
    /**
     *    Các hàm khác
     */
    private void themDuLieuPhongVaoBang(ArrayList<Phong> listP) {
        moDelPhong =(DefaultTableModel)tblPhong.getModel();      
	for (Phong p : listP) {
            moDelPhong.addRow(new Object[] {
                p.getMaPhong(),
                p.getDienTich(),
                p.getChieuCao(),
                p.getVatLieuCachAm(),
                p.getTiVi(),
                p.getSoLuongTiVi(),
                p.getThuongHieuTiVi(),
                p.getBan(),
                p.getSoLuongBan(),
                p.getSoFa(),
                p.getSoLuongSoFa(),
                p.getDanLoa(),
                p.getMoTa(),
                p.getHinhAnh(),
                p.getLoaiPhong().getMaLoaiPhong(),
                p.isTinhTrangBaoTri()==true?"Bảo trì":"Hoạt động bình thường",
                p.getTrangThaiPhong().getMaTrangThaiPhong()             
            });
        }
    }
    
    private void themDuLieuLoaiPhongVaoCBB() {
        ArrayList<LoaiPhong> listLP = loaiPhong_dao.getDanhSachLoaiPhong();
        for (LoaiPhong loaiPhong : listLP) {
            cbbLoaiPhong.addItem(loaiPhong.getMaLoaiPhong());  
	}
        for (LoaiPhong loaiPhong : listLP) {
            cbbLocLoaiPhong.addItem(loaiPhong.getMaLoaiPhong());  
	}
    }
    
    private void themDuLieuTrangThaiPhongVaoCBB() {
        ArrayList<TrangThaiPhong> listTHP = trangThaiPhong_dao.getDanhSachTrangThaiPhong();
        for (TrangThaiPhong trangThaiPhong : listTHP) {
            cbbTrangThaiPhong.addItem(trangThaiPhong.getMaTrangThaiPhong());  
	}
    }
    
    private void suaPhong(Phong phongNew) {
	phong_dao.suaPhong(phongNew);
        xoaDuLieuBang();
        ArrayList<Phong> listPhongNew = phong_dao.getDanhSachPhong();//lấy lại danh sách mới
        themDuLieuPhongVaoBang(listPhongNew);
	JOptionPane.showMessageDialog(this,"Sửa thành công.");	
    }
    
    private boolean kiemTraDuLieu() {
        String dienTich = txtDienTich.getText().trim();
        String chieuCao =txtChieuCao.getText().trim();
        String vatLieuCachAm = txtVatLieuCachAm.getText().trim();
        String tiVi = txtTiVi.getText().trim();
        String soLuongTiVi = txtSoLuongTiVi.getText().trim();
        String thuongHieuTiVi = txtThuongHieuTiVi.getText().trim();
        String ban = txtBan.getText().trim();
        String soLuongBan =  txtSoLuongBan.getText().trim();
        String soFa = txtSoFa.getText().trim();
        String soLuongSoFa = txtSoLuongSoFa.getText().trim();
        String danLoa = txtDanLoa.getText().trim();
        if (dienTich.length() > 0 || dienTich.length() == 0) {
            try {
                Float dt = Float.parseFloat(dienTich);
		if (dt < 0) {
                    JOptionPane.showMessageDialog(this,  "Error: Diện tích phòng phải > hơn 0!" );
                    txtDienTich.requestFocus();
                    return false;
		}
            } catch (NumberFormatException ex) {
		JOptionPane.showMessageDialog(this,  "Error: Diện tích phòng phải nhập số!" );
                txtDienTich.requestFocus();
                return false;
            }
	}
        if (chieuCao.length() > 0 || chieuCao.length() == 0) {
            try {
                Float cc = Float.parseFloat(chieuCao);
		if (cc < 0) {
                    JOptionPane.showMessageDialog(this,  "Erorr: Chiều cao phòng phải > hơn 0!" );
                    txtChieuCao.requestFocus();
                    return false;
		}
            } catch (NumberFormatException ex) {
		JOptionPane.showMessageDialog(this,  "Error: Chiều cao phòng phải nhập số!" );
                txtChieuCao.requestFocus();
                return false;
            }
	}
        if(!(vatLieuCachAm.length()>0 && vatLieuCachAm.matches("^[ A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ0-9]+$"))) 
        {
            JOptionPane.showMessageDialog(this,"Error: Vật liệu cách âm không hợp lệ(Không chứa các kí tự đặc biệt) !");
            txtVatLieuCachAm.requestFocus();
            return false;
	}
        if(!(tiVi.length()>0 && tiVi.matches("^[ A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ0-9]+$"))) 
        {
            JOptionPane.showMessageDialog(this,"Error: TiVi không hợp lệ(Không chứa các kí tự đặc biệt)!");
            txtTiVi.requestFocus();
            return false;
	}
        if (soLuongTiVi.length() > 0 || soLuongTiVi.length() == 0) {
            try {
                Integer slTV = Integer.parseInt(soLuongTiVi);
		if (slTV < 0) {
                    JOptionPane.showMessageDialog(this,  "Erorr: Số lượng TiVi phải > hơn 0 mới hợp lệ !" );
                    txtSoLuongTiVi.requestFocus();
                    return false;
		}
            } catch (NumberFormatException ex) {
		JOptionPane.showMessageDialog(this,  "Error: Số lượng tiVi phải nhập số" );
                txtSoLuongTiVi.requestFocus();
                return false;
            }
	}
        if(!(thuongHieuTiVi.length()>0 && thuongHieuTiVi.matches("^[ A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ0-9]+$"))) 
        {
            JOptionPane.showMessageDialog(this,"Error: Thương hiệu TiVi không hợp lệ(Không chứa các kí tự đặc biệt) !");
            txtThuongHieuTiVi.requestFocus();
            return false;
	}
        if(!(ban.length()>0 && ban.matches("^[ A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ0-9]+$"))) 
        {
            JOptionPane.showMessageDialog(this,"Error: Bàn không hợp lệ(Không chứa các kí tự đặc biệt)!");
            txtBan.requestFocus();
            return false;
	}
        if (soLuongBan.length() > 0 || soLuongBan.length() == 0) {
            try {
                Integer slTV = Integer.parseInt(soLuongBan);
		if (slTV < 0) {
                    JOptionPane.showMessageDialog(this,  "Erorr: Số lượng bàn phải > hơn 0!" );
                    txtSoLuongBan.requestFocus();
                    return false;
		}
            } catch (NumberFormatException ex) {
		JOptionPane.showMessageDialog(this,  "Error: Số lượng bàn phải nhập số" );
                txtSoLuongBan.requestFocus();
                return false;
            }
	}
        
        if(!(soFa.length()>0 && soFa.matches("^[ A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ0-9]+$"))) 
        {
            JOptionPane.showMessageDialog(this,"Error: Sofa không hợp lệ(Không chứa các kí tự đặc biệt)!");
            txtSoFa.requestFocus();
            return false;
	}
        if (soLuongSoFa.length() > 0 || soLuongSoFa.length() == 0) {
            try {
                Integer slTV = Integer.parseInt(soLuongSoFa);
		if (slTV < 0) {
                    JOptionPane.showMessageDialog(this,  "Erorr: Số lượng sofa phải > hơn 0 mới hợp lệ !" );
                    txtSoLuongSoFa.requestFocus();
                    return false;
		}
            } catch (NumberFormatException ex) {
		JOptionPane.showMessageDialog(this,  "Error: Số lượng sofa phải nhập số" );
                txtSoLuongSoFa.requestFocus();
                return false;
            }
	}
        if(!(danLoa.length()>0 && danLoa.matches("^[ A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ0-9]+$"))) 
        {
            JOptionPane.showMessageDialog(this,"Error: Dàn loa không hợp lệ(Không chứa các kí tự đặc biệt) !");
            txtDanLoa.requestFocus();
            return false;
	}
        return true;
    }
    
    public void xoaDuLieuBang() {
        DefaultTableModel dm = (DefaultTableModel) tblPhong.getModel();
        dm.getDataVector().removeAllElements();
    }
    
    public void anCacPhanTuTXT(Boolean bl){
        txtMaPhong.setEnabled(bl);
        txtDienTich.setEnabled(bl);
        txtChieuCao.setEnabled(bl);
        txtVatLieuCachAm.setEnabled(bl);
        txtTiVi.setEnabled(bl);
        txtSoLuongTiVi.setEnabled(bl);      
        txtThuongHieuTiVi.setEnabled(bl);
        txtBan.setEnabled(bl);
        txtSoLuongBan.setEnabled(bl);
        txtSoFa.setEnabled(bl);
        txtSoLuongSoFa.setEnabled(bl);
        txtDanLoa.setEnabled(bl);
//        txtAreaMoTa.setEnabled(bl);
        cbbLoaiPhong.setEnabled(bl);
        chkTinhTrangBaoTri.setEnabled(bl);
        cbbTrangThaiPhong.setEnabled(bl);
        btnImage.setEnabled(bl);  
    }
    
    public void anCacButton(Boolean bl){
       btnTimPhong.setEnabled(bl);
       btnThem.setEnabled(bl);
       btnLamMoi.setEnabled(bl);
       btnSuaPhong.setEnabled(bl);
       btnLuuPhongKhiThem.setEnabled(bl);
       btnLuuPhongKhiSua.setEnabled(bl);
       btnXoaPhong.setEnabled(bl);
    }
    
    public void xoaRong(){
//        txtMaPhong.setText("");
        txtDienTich.setText("");
        txtChieuCao.setText("");
        txtVatLieuCachAm.setText("");
        txtTiVi.setText("");
        txtSoLuongTiVi.setText("");      
        txtThuongHieuTiVi.setText("");
        txtBan.setText("");
        txtSoLuongBan.setText("");
        txtSoFa.setText("");
        txtSoLuongSoFa.setText("");
        txtDanLoa.setText("");
        txtAreaMoTa.setText("");       
        ImageIcon iCon = new ImageIcon(getClass().getResource("/image/phong/chonAnh_1.png"));
        lblImage.setIcon(iCon);//hình ảnh mặc định khi xóa trắng
        lblImgPath.setText("");
        cbbLoaiPhong.setSelectedIndex(0);
        chkTinhTrangBaoTri.setSelected(false);
        cbbTrangThaiPhong.setSelectedIndex(0);
    }
    
    	
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pThongTinPhongHat = new javax.swing.JPanel();
        lblDienTich = new javax.swing.JLabel();
        lblMaPhong = new javax.swing.JLabel();
        lblSoLuongBan = new javax.swing.JLabel();
        lblVatLieuCachAm = new javax.swing.JLabel();
        lblTiVi = new javax.swing.JLabel();
        lblSoLuongTiVi = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblThuongHieuTiVi = new javax.swing.JLabel();
        lblChieuCao = new javax.swing.JLabel();
        txtChieuCao = new javax.swing.JTextField();
        lblBan = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        txtDienTich = new javax.swing.JTextField();
        txtVatLieuCachAm = new javax.swing.JTextField();
        txtThuongHieuTiVi = new javax.swing.JTextField();
        txtSoLuongTiVi = new javax.swing.JTextField();
        txtTiVi = new javax.swing.JTextField();
        txtBan = new javax.swing.JTextField();
        txtSoLuongBan = new javax.swing.JTextField();
        lblSoFa = new javax.swing.JLabel();
        txtSoFa = new javax.swing.JTextField();
        lblDanLoa = new javax.swing.JLabel();
        lblSoLuongSoFa = new javax.swing.JLabel();
        lblLoaiPhong = new javax.swing.JLabel();
        lblMoTa = new javax.swing.JLabel();
        txtSoLuongSoFa = new javax.swing.JTextField();
        txtDanLoa = new javax.swing.JTextField();
        chkTinhTrangBaoTri = new javax.swing.JCheckBox();
        lblHinhAnh = new javax.swing.JLabel();
        txtAreaMoTa = new java.awt.TextArea();
        lblTinhTrangBaoTri = new javax.swing.JLabel();
        btnImage = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();
        lblTrangThaiPhong = new javax.swing.JLabel();
        cbbLoaiPhong = new javax.swing.JComboBox<>();
        cbbTrangThaiPhong = new javax.swing.JComboBox<>();
        lblImgPath = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        pDanhSachPhong = new javax.swing.JPanel();
        scrPhong = new javax.swing.JScrollPane();
        tblPhong = new javax.swing.JTable();
        pChucNang = new javax.swing.JPanel();
        btnTimPhong = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnLuuPhongKhiThem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnSuaPhong = new javax.swing.JButton();
        btnLuuPhongKhiSua = new javax.swing.JButton();
        btnXoaPhong = new javax.swing.JButton();
        pLoc = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        cbbLocLoaiPhong = new javax.swing.JComboBox<>();
        btnLocPhong = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        pThongTinPhongHat.setBackground(new java.awt.Color(242, 240, 242));
        pThongTinPhongHat.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phòng hát", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N
        pThongTinPhongHat.setForeground(new java.awt.Color(124, 36, 207));
        pThongTinPhongHat.setOpaque(false);

        lblDienTich.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblDienTich.setText("Diện tích:");

        lblMaPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblMaPhong.setText("Mã phòng:");

        lblSoLuongBan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblSoLuongBan.setText("Số lượng bàn:");

        lblVatLieuCachAm.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblVatLieuCachAm.setText("Vật liệu cách âm:");

        lblTiVi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTiVi.setText("Ti vi:");

        lblSoLuongTiVi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblSoLuongTiVi.setText("Số lượng tivi:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lblThuongHieuTiVi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblThuongHieuTiVi.setText("Thương hiệu tivi:");

        lblChieuCao.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblChieuCao.setText("Chiều cao:");

        txtChieuCao.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lblBan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblBan.setText("Bàn:");

        txtMaPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtDienTich.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtDienTich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDienTichActionPerformed(evt);
            }
        });

        txtVatLieuCachAm.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtThuongHieuTiVi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtSoLuongTiVi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtTiVi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtBan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtSoLuongBan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lblSoFa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblSoFa.setText("So-fa:");

        txtSoFa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lblDanLoa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblDanLoa.setText("Dàn loa:");

        lblSoLuongSoFa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblSoLuongSoFa.setText("Số lượng so-fa:");

        lblLoaiPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblLoaiPhong.setText("Loại phòng:");

        lblMoTa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblMoTa.setText("Mô tả:");

        txtSoLuongSoFa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtDanLoa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        chkTinhTrangBaoTri.setText("Bảo trì");
        chkTinhTrangBaoTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTinhTrangBaoTriActionPerformed(evt);
            }
        });

        lblHinhAnh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblHinhAnh.setText("Hình ảnh:");

        txtAreaMoTa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtAreaMoTa.setSelectionEnd(-1);

        lblTinhTrangBaoTri.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTinhTrangBaoTri.setText("Tình trạng bảo trì:");

        btnImage.setBackground(new java.awt.Color(177, 100, 252));
        btnImage.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnImage.setForeground(new java.awt.Color(255, 255, 255));
        btnImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/camera.png"))); // NOI18N
        btnImage.setText("Chọn ảnh");
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/chonAnh_1.png"))); // NOI18N

        lblTrangThaiPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTrangThaiPhong.setText("Trạng thái phòng:");

        lblImgPath.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N

        javax.swing.GroupLayout pThongTinPhongHatLayout = new javax.swing.GroupLayout(pThongTinPhongHat);
        pThongTinPhongHat.setLayout(pThongTinPhongHatLayout);
        pThongTinPhongHatLayout.setHorizontalGroup(
            pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pThongTinPhongHatLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblMoTa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addComponent(txtAreaMoTa, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pThongTinPhongHatLayout.createSequentialGroup()
                        .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblMaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDienTich, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblChieuCao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblVatLieuCachAm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblThuongHieuTiVi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSoLuongTiVi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTiVi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTinhTrangBaoTri, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVatLieuCachAm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                            .addComponent(txtTiVi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtThuongHieuTiVi)
                            .addComponent(txtSoLuongTiVi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMaPhong)
                            .addComponent(txtDienTich)
                            .addComponent(txtChieuCao)
                            .addComponent(chkTinhTrangBaoTri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)))
                .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbLoaiPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                                .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pThongTinPhongHatLayout.createSequentialGroup()
                                        .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblSoLuongBan, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                            .addComponent(lblBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(10, 10, 10)
                                        .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSoLuongBan)
                                            .addComponent(txtBan)))
                                    .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                                        .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblSoLuongSoFa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblDanLoa, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblSoFa, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDanLoa)
                                            .addComponent(txtSoLuongSoFa)
                                            .addComponent(txtSoFa))))
                                .addContainerGap())
                            .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                                .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                                        .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblImgPath, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(12, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pThongTinPhongHatLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImage)
                        .addGap(249, 249, 249))
                    .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblTrangThaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbTrangThaiPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pThongTinPhongHatLayout.setVerticalGroup(
            pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                        .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE))
                    .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                        .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDienTich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSoLuongBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoLuongBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtChieuCao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoFa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoFa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblChieuCao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVatLieuCachAm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVatLieuCachAm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSoLuongSoFa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoLuongSoFa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTiVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTiVi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDanLoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDanLoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(cbbTrangThaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtThuongHieuTiVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblThuongHieuTiVi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTrangThaiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(12, 12, 12)))
                .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                        .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLoaiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSoLuongTiVi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))
                    .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                        .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbLoaiPhong)
                            .addComponent(txtSoLuongTiVi))
                        .addGap(12, 12, 12)))
                .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImgPath, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTinhTrangBaoTri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkTinhTrangBaoTri)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAreaMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pThongTinPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel10))
                    .addGroup(pThongTinPhongHatLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnImage)))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(204, 153, 255));

        jLabel17.setBackground(new java.awt.Color(121, 87, 142));
        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(121, 87, 142));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/phongHat_img.png"))); // NOI18N
        jLabel17.setText("Quản lí phòng hát");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
                .addGap(110, 110, 110))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel17))
        );

        pDanhSachPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        scrPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        tblPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng", "Diện tích", "Chiều cao", "Vật liệu cách âm", "Tivi", "Số lượng tivi", "Thương hiệu tivi", "Bàn", "Số lượng bàn", "So-fa", "Số lượng So-fa", "Dàn loa", "Mô tả", "Hình ảnh", "Loại phòng", "Tình trạng bảo trì", "Trạng thái phòng"
            }
        ));
        tblPhong.setRowHeight(33);
        tblPhong.setSelectionBackground(new java.awt.Color(200, 175, 228));
        tblPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhongMouseClicked(evt);
            }
        });
        tblPhong.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tblPhongComponentShown(evt);
            }
        });
        scrPhong.setViewportView(tblPhong);

        javax.swing.GroupLayout pDanhSachPhongLayout = new javax.swing.GroupLayout(pDanhSachPhong);
        pDanhSachPhong.setLayout(pDanhSachPhongLayout);
        pDanhSachPhongLayout.setHorizontalGroup(
            pDanhSachPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 1492, Short.MAX_VALUE)
        );
        pDanhSachPhongLayout.setVerticalGroup(
            pDanhSachPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        );

        pChucNang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Các chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        btnTimPhong.setBackground(new java.awt.Color(177, 100, 252));
        btnTimPhong.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnTimPhong.setForeground(new java.awt.Color(255, 255, 255));
        btnTimPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/search.png"))); // NOI18N
        btnTimPhong.setText("Tìm");
        btnTimPhong.setToolTipText("Nhấn 2 lần để hiển thị full danh sách");
        btnTimPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimPhongMouseClicked(evt);
            }
        });
        btnTimPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimPhongActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(177, 100, 252));
        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/buy-online.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnLuuPhongKhiThem.setBackground(new java.awt.Color(177, 100, 252));
        btnLuuPhongKhiThem.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnLuuPhongKhiThem.setForeground(new java.awt.Color(255, 255, 255));
        btnLuuPhongKhiThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/save.png"))); // NOI18N
        btnLuuPhongKhiThem.setText("Lưu");
        btnLuuPhongKhiThem.setEnabled(false);
        btnLuuPhongKhiThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuPhongKhiThemActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(177, 100, 252));
        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/reset.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnSuaPhong.setBackground(new java.awt.Color(177, 100, 252));
        btnSuaPhong.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnSuaPhong.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/edit.png"))); // NOI18N
        btnSuaPhong.setText("Sửa");
        btnSuaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPhongActionPerformed(evt);
            }
        });

        btnLuuPhongKhiSua.setBackground(new java.awt.Color(177, 100, 252));
        btnLuuPhongKhiSua.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnLuuPhongKhiSua.setForeground(new java.awt.Color(255, 255, 255));
        btnLuuPhongKhiSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/save.png"))); // NOI18N
        btnLuuPhongKhiSua.setText("Lưu");
        btnLuuPhongKhiSua.setEnabled(false);
        btnLuuPhongKhiSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuPhongKhiSuaActionPerformed(evt);
            }
        });

        btnXoaPhong.setBackground(new java.awt.Color(177, 100, 252));
        btnXoaPhong.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnXoaPhong.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/huyPhongCho.png"))); // NOI18N
        btnXoaPhong.setText("Xóa");
        btnXoaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pChucNangLayout = new javax.swing.GroupLayout(pChucNang);
        pChucNang.setLayout(pChucNangLayout);
        pChucNangLayout.setHorizontalGroup(
            pChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                    .addComponent(btnLuuPhongKhiThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLuuPhongKhiSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pChucNangLayout.setVerticalGroup(
            pChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTimPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLuuPhongKhiThem, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLuuPhongKhiSua, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
        );

        pLoc.setBackground(new java.awt.Color(242, 240, 242));
        pLoc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N
        pLoc.setForeground(new java.awt.Color(124, 36, 207));
        pLoc.setOpaque(false);

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setText("Loại phòng:");

        cbbLocLoaiPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbbLocLoaiPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hiện tất cả" }));
        cbbLocLoaiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocLoaiPhongActionPerformed(evt);
            }
        });

        btnLocPhong.setBackground(new java.awt.Color(177, 100, 252));
        btnLocPhong.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnLocPhong.setForeground(new java.awt.Color(255, 255, 255));
        btnLocPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/filter.png"))); // NOI18N
        btnLocPhong.setText("Lọc");
        btnLocPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pLocLayout = new javax.swing.GroupLayout(pLoc);
        pLoc.setLayout(pLocLayout);
        pLocLayout.setHorizontalGroup(
            pLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbLocLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLocLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(btnLocPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48))
        );
        pLocLayout.setVerticalGroup(
            pLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLocLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(cbbLocLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLocPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pDanhSachPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(pThongTinPhongHat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pLoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pThongTinPhongHat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(pDanhSachPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPhongActionPerformed
        int r = tblPhong.getSelectedRow();
        if (r == -1) {
            JOptionPane.showMessageDialog(this,"Vui lòng chọn dòng cần xóa !");
	}else {
            phong_dao.xoaPhong(tblPhong.getValueAt(tblPhong.getSelectedRow(), 0).toString());
            //cách1 xóa trong table model 
            //modelNhanVien.removeRow(r); // xóa trong table model 
            //cách 2: xóa trong table model 
            moDelPhong.setRowCount(0);
            ArrayList<Phong> listPhongSauKhiXoa = phong_dao.getDanhSachPhong();
            themDuLieuPhongVaoBang(listPhongSauKhiXoa);
            xoaRong();
            JOptionPane.showMessageDialog(this,"Xóa thành công !");	
	}   
    }//GEN-LAST:event_btnXoaPhongActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (btnThem.getText().equalsIgnoreCase("Thêm")) {
            anCacPhanTuTXT(true);
            anCacButton(false);
            xoaRong();         
            txtMaPhong.setEnabled(false);
            txtMaPhong.setText(phong_dao.getMaPhongTuDong());
            btnLuuPhongKhiThem.setEnabled(true);
            btnThem.setEnabled(true);
            btnThem.setText("Hủy");
            btnLamMoi.setEnabled(true);
            cbbTrangThaiPhong.setEnabled(false);
            cbbTrangThaiPhong.setSelectedIndex(1);

	}else if (btnThem.getText().equalsIgnoreCase("Hủy")) {
            anCacPhanTuTXT(true);
            anCacButton(true);
            xoaRong();
            txtMaPhong.setText("");
            btnLuuPhongKhiThem.setEnabled(false);
            btnThem.setEnabled(true);
            btnThem.setText("Thêm");
            cbbTrangThaiPhong.setEnabled(false);
            cbbTrangThaiPhong.setSelectedIndex(1);
        }       
    }//GEN-LAST:event_btnThemActionPerformed

    private void chkTinhTrangBaoTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTinhTrangBaoTriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkTinhTrangBaoTriActionPerformed

    private void btnLuuPhongKhiThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuPhongKhiThemActionPerformed
        if(kiemTraDuLieu()) {
            Phong p = new Phong();
            p.setMaPhong(txtMaPhong.getText().trim());
            p.setTrangThaiPhong(new TrangThaiPhong(cbbTrangThaiPhong.getSelectedItem().toString()));
            p.setLoaiPhong(new LoaiPhong(cbbLoaiPhong.getSelectedItem().toString()));
            p.setDienTich(Float.parseFloat(txtDienTich.getText().trim()));
            p.setChieuCao(Float.parseFloat(txtChieuCao.getText().trim()));
            p.setVatLieuCachAm(txtVatLieuCachAm.getText().trim());
            p.setTiVi(txtTiVi.getText().trim());
            p.setSoLuongTiVi(Integer.parseInt(txtSoLuongTiVi.getText().trim()));
            p.setThuongHieuTiVi(txtThuongHieuTiVi.getText().trim());
            p.setBan(txtBan.getText());
            p.setSoLuongBan(Integer.parseInt(txtSoLuongBan.getText().trim()));
            p.setSoFa(txtSoFa.getText().trim());
            p.setSoLuongSoFa(Integer.parseInt(txtSoLuongSoFa.getText().trim()));
            p.setDanLoa(txtDanLoa.getText().trim());
            p.setMoTa(txtAreaMoTa.getText().trim());
            p.setTinhTrangBaoTri(chkTinhTrangBaoTri.isSelected());        
            String imagePhongPath = lblImgPath.getText().trim();         
            int index = imagePhongPath.lastIndexOf('\\');//lấy path mới
            String name = imagePhongPath.substring(index+1);
            p.setHinhAnh("\\\\src\\\\image\\\\phong\\\\" + name); 
            p.setLuotCho(0);
            phong_dao.addPhong(p);
            moDelPhong.addRow(new Object[] {
                p.getMaPhong(),
                p.getDienTich(),
                p.getChieuCao(),
                p.getVatLieuCachAm(),
                p.getTiVi(),
                p.getSoLuongTiVi(),
                p.getThuongHieuTiVi(),
                p.getBan(),
                p.getSoLuongBan(),
                p.getSoFa(),
                p.getSoLuongSoFa(),
                p.getDanLoa(),
                p.getMoTa(),
                p.getHinhAnh(),
                p.getLoaiPhong().getMaLoaiPhong(),
                p.isTinhTrangBaoTri(),
                p.getTrangThaiPhong().getMaTrangThaiPhong()             
            });
            JOptionPane.showMessageDialog(this,"Thêm phòng thành công !");   
            anCacButton(true);
            xoaRong();
            txtMaPhong.setText("");
            txtMaPhong.setEnabled(true);
            btnLuuPhongKhiThem.setEnabled(false);
            btnThem.setEnabled(true);
            btnThem.setText("Thêm");              
        }               
    }//GEN-LAST:event_btnLuuPhongKhiThemActionPerformed

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed
        try {
            JFileChooser f = new JFileChooser(new File("D:\\"));
            int result = f.showSaveDialog(null);
            if(result == JFileChooser.APPROVE_OPTION){
                File selectedFile = f.getSelectedFile();
                lblImage.setIcon(ResizeImage(String.valueOf(selectedFile)));
                lblImgPath.setText(selectedFile.getPath());
            }             
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }//GEN-LAST:event_btnImageActionPerformed

    private void txtDienTichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDienTichActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDienTichActionPerformed

    private void tblPhongComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblPhongComponentShown
        // TODO add your handling code here:        
    }//GEN-LAST:event_tblPhongComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void tblPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhongMouseClicked
        int row = tblPhong.getSelectedRow();
        
        anCacPhanTuTXT(false); 
        txtMaPhong.setEnabled(false);
        anCacButton(true);
        btnLuuPhongKhiSua.setVisible(false);
        btnLuuPhongKhiThem.setVisible(true);    
        btnLuuPhongKhiThem.setEnabled(false);       
        btnThem.setEnabled(true);
        btnThem.setText("Thêm");
        btnSuaPhong.setEnabled(true);
        btnSuaPhong.setText("Sửa");
        
        txtMaPhong.setText(moDelPhong.getValueAt(row, 0).toString());    
        txtDienTich.setText(moDelPhong.getValueAt(row, 1).toString());
        txtChieuCao.setText(moDelPhong.getValueAt(row, 2).toString());
        txtVatLieuCachAm.setText(moDelPhong.getValueAt(row, 3).toString());
        txtTiVi.setText(moDelPhong.getValueAt(row, 4).toString());
        txtSoLuongTiVi.setText(moDelPhong.getValueAt(row, 5).toString());      
        txtThuongHieuTiVi.setText(moDelPhong.getValueAt(row, 6).toString());
        txtBan.setText(moDelPhong.getValueAt(row, 7).toString());
        txtSoLuongBan.setText(moDelPhong.getValueAt(row, 8).toString());
        txtSoFa.setText(moDelPhong.getValueAt(row, 9).toString());
        txtSoLuongSoFa.setText(moDelPhong.getValueAt(row, 10).toString());
        txtDanLoa.setText(moDelPhong.getValueAt(row, 11).toString());
        if (moDelPhong.getValueAt(row, 12) != null) {
           txtAreaMoTa.setText(moDelPhong.getValueAt(row, 12).toString());     
        }else{
              txtAreaMoTa.setText("Không có mô tả");
        }
        lblImage.setIcon(ResizeImage(String.valueOf(System.getProperty("user.dir") + moDelPhong.getValueAt(row, 13).toString())));
        lblImgPath.setText(System.getProperty("user.dir") + moDelPhong.getValueAt(row, 13).toString());   
 
//        String imageResource = //.... string to image resource path
//        Image myImage = ImageIO.read(getClass().getResourceAsStream(imageResource));
//        Icon logo = new ImageIcon(myImage);
        
        cbbLoaiPhong.setSelectedItem(moDelPhong.getValueAt(row, 14).toString());
        chkTinhTrangBaoTri.setSelected(moDelPhong.getValueAt(row, 15).toString() == "true" ? true : false);
        cbbTrangThaiPhong.setSelectedItem(moDelPhong.getValueAt(row, 16).toString());
    }//GEN-LAST:event_tblPhongMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        xoaRong();     
    }//GEN-LAST:event_btnLamMoiActionPerformed
    public ImageIcon ResizeImage(String ImagePath){
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    private void cbbLocLoaiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocLoaiPhongActionPerformed
        // TODO add your handling code here:      
    }//GEN-LAST:event_cbbLocLoaiPhongActionPerformed

    private void btnLocPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocPhongActionPerformed
        try {      
            xoaRong();
            txtMaPhong.setText("");
            moDelPhong.setRowCount(0);
            String inDexComBoBox =cbbLocLoaiPhong.getSelectedItem().toString();
            if (cbbLocLoaiPhong.getSelectedItem() != "Hiện tất cả") {
                ResultSet p = phong_dao.locPhongTheoLoaiPhong(inDexComBoBox);
                while (p.next()) { 
                    moDelPhong.addRow(new Object[] {
                        p.getString("maPhong"),                                       
                        p.getFloat("dienTich"),
                        p.getFloat("chieuCao"),
                        p.getString("vatLieuCachAm"),
                        p.getString("tiVi"),
                        p.getInt("soLuongTiVi"),
                        p.getString("thuongHieuTiVi"),
                        p.getString("ban"),
                        p.getInt("soLuongBan"),
                        p.getString("soFa"),
                        p.getInt("soLuongSoFa"),
                        p.getString("danLoa"),
                        p.getString("moTa"),
                        p.getBytes("hinhAnh"),  
                        p.getString("maLoaiPhong"),
                        p.getBoolean("tinhTrangBaoTri"),
                        p.getString("maTrangThaiPhong")                           
                    });
                }  
	   }else{
                xoaDuLieuBang();
		themDuLieuPhongVaoBang(listPhong);
                tblPhong.setModel(moDelPhong);
           }
	} catch (Exception e2) {
            e2.printStackTrace();
	}
    }//GEN-LAST:event_btnLocPhongActionPerformed

    private void btnSuaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPhongActionPerformed
        // TODO add your handling code here:
        if (btnSuaPhong.getText().equalsIgnoreCase("Sửa")) {
            anCacPhanTuTXT(true);
            anCacButton(false);
            
            txtMaPhong.setEnabled(false);         
            btnSuaPhong.setEnabled(true);
            btnSuaPhong.setText("Hủy");
            btnLamMoi.setEnabled(true);
            btnLuuPhongKhiThem.setVisible(false);
            btnLuuPhongKhiSua.setVisible(true);
            btnLuuPhongKhiSua.setEnabled(true);          
	}else if (btnSuaPhong.getText().equalsIgnoreCase("Hủy")) {
            anCacPhanTuTXT(true);          
            anCacButton(true);   
            xoaRong();
            
            txtMaPhong.setText("");
            btnSuaPhong.setEnabled(true);
            btnSuaPhong.setText("Sửa");
            btnLuuPhongKhiSua.setVisible(false);
            btnLuuPhongKhiThem.setVisible(true); 
            btnLuuPhongKhiThem.setEnabled(false);
            cbbTrangThaiPhong.setEnabled(false);
            cbbTrangThaiPhong.setSelectedIndex(1);
        }        
    }//GEN-LAST:event_btnSuaPhongActionPerformed

    private void btnTimPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimPhongActionPerformed
        anCacPhanTuTXT( true);
        /**
         * Tìm theo mã
         */
        if (txtMaPhong.getText().trim().length() != 0) {
            moDelPhong.setRowCount(0);
            Phong phong = phong_dao.timPhongTheoMa(txtMaPhong.getText().trim());
            if (phong != null) {
		moDelPhong.addRow(new Object[] {
                    phong.getMaPhong(),
                    phong.getDienTich(),
                    phong.getChieuCao(),
                    phong.getVatLieuCachAm(),
                    phong.getTiVi(),
                    phong.getSoLuongTiVi(),
                    phong.getThuongHieuTiVi(),
                    phong.getBan(),
                    phong.getSoLuongBan(),
                    phong.getSoFa(),
                    phong.getSoLuongSoFa(),
                    phong.getDanLoa(),
                    phong.getMoTa(),
                    phong.getHinhAnh(),
                    phong.getLoaiPhong().getMaLoaiPhong(),
                    phong.isTinhTrangBaoTri(),
                    phong.getTrangThaiPhong().getMaTrangThaiPhong()                         
                });
            }
        }
        /**
         * Tìm theo diện tích
         */
        else if(txtDienTich.getText().trim().length() != 0){       
            ArrayList<Phong> listTim;
            listTim = phong_dao.timTheoDienTich(Float.parseFloat(txtDienTich.getText().trim()));
            if ( listTim.size() > 0) {
		xoaDuLieuBang();
		themDuLieuPhongVaoBang(listTim);
            } else{
                JOptionPane.showMessageDialog(null, "Không tìm thấy phòng có diện tích: " + txtDienTich.getText());			
            }	
        }
        /**
        * Tìm theo chiều cao
        */
        else if(txtChieuCao.getText().trim().length() != 0){       
            ArrayList<Phong> listTim;
            listTim = phong_dao.timTheoChieuCao(Float.parseFloat(txtChieuCao.getText().trim()));
            if ( listTim.size() > 0) {
		xoaDuLieuBang();
		themDuLieuPhongVaoBang(listTim);
            } else{
                JOptionPane.showMessageDialog(null, "Không tìm thấy phòng có chiều cao: " + txtChieuCao.getText());			
            }	
        }
        /**
        * Tìm theo vật liệu cách âm
        */
        else if(txtVatLieuCachAm.getText().trim().length() != 0){       
            ArrayList<Phong> listTim;
            listTim = phong_dao.timTheoVatLieuCachAm(txtVatLieuCachAm.getText().trim());
            if ( listTim.size() > 0) {
		xoaDuLieuBang();
		themDuLieuPhongVaoBang(listTim);
            } else{
                JOptionPane.showMessageDialog(null, "Không tìm thấy vật liệu cách âm: " + txtVatLieuCachAm.getText());			
            }	
        }
         /**
        * Tìm theo tivi
        */
        else if(txtTiVi.getText().trim().length() != 0){       
            ArrayList<Phong> listTim;
            listTim = phong_dao.timTheoTiVi(txtTiVi.getText().trim());
            if ( listTim.size() > 0) {
		xoaDuLieuBang();
		themDuLieuPhongVaoBang(listTim);
            } else{
                JOptionPane.showMessageDialog(null, "Không tìm thấy tivi: " + txtTiVi.getText());			
            }	
        }
        /**
        * Tìm theo số lượng tivi
        */
        else if(txtSoLuongTiVi.getText().trim().length() != 0){       
            ArrayList<Phong> listTim;
            listTim = phong_dao.timTheoSoLuongTiVi(Integer.parseInt(txtSoLuongTiVi.getText().trim()));
            if ( listTim.size() > 0) {
		xoaDuLieuBang();
		themDuLieuPhongVaoBang(listTim);
            } else{
                JOptionPane.showMessageDialog(null, "Không tìm thấy phòng nào có " + txtSoLuongTiVi.getText()+"tivi !");			
            }	
        }
        /**
        * Tìm theo thương hiệu
        */
        else if(txtThuongHieuTiVi.getText().trim().length() != 0){       
            ArrayList<Phong> listTim;
            listTim = phong_dao.timTheoThuongHieuTiVi(txtThuongHieuTiVi.getText().trim());
            if ( listTim.size() > 0) {
		xoaDuLieuBang();
		themDuLieuPhongVaoBang(listTim);
            } else{
                JOptionPane.showMessageDialog(null, "Không tìm thấy tivi có thương hiệu: " + txtThuongHieuTiVi.getText());			
            }	
        }
        /**
        * Tìm theo bàn
        */
        else if(txtBan.getText().trim().length() != 0){       
            ArrayList<Phong> listTim;
            listTim = phong_dao.timTheoBan(txtBan.getText().trim());
            if ( listTim.size() > 0) {
		xoaDuLieuBang();
		themDuLieuPhongVaoBang(listTim);
            } else{
                JOptionPane.showMessageDialog(null, "Không tìm thấy phòng nào có bàn" + txtBan.getText());			
            }	
        }
        /**
        * Tìm theo sô lượng bàn
        */
        else if(txtSoLuongBan.getText().trim().length() != 0){       
            ArrayList<Phong> listTim;
            listTim = phong_dao.timTheoSoLuongBan(Integer.parseInt(txtSoLuongBan.getText().trim()));
            if ( listTim.size() > 0) {
		xoaDuLieuBang();
		themDuLieuPhongVaoBang(listTim);
            } else{
                JOptionPane.showMessageDialog(null, "Không tìm thấy phòng nào có bàn" + txtSoLuongBan.getText());			
            }	
        }
         /**
        * Tìm theo soFa
        */
        else if(txtSoFa.getText().trim().length() != 0){       
            ArrayList<Phong> listTim;
            listTim = phong_dao.timTheoSoFa(txtSoFa.getText().trim());
            if ( listTim.size() > 0) {
		xoaDuLieuBang();
		themDuLieuPhongVaoBang(listTim);
            } else{
                JOptionPane.showMessageDialog(null, "Không tìm thấy soFa:" + txtSoFa.getText());			
            }	
        }
        /**
        * Tìm theo SỐ LƯỢNG soFa
        */
        else if(txtSoLuongSoFa.getText().trim().length() != 0){       
            ArrayList<Phong> listTim;
            listTim = phong_dao.timTheoSoLuongSoFa(Integer.parseInt(txtSoLuongSoFa.getText().trim()));
            if ( listTim.size() > 0) {
		xoaDuLieuBang();
		themDuLieuPhongVaoBang(listTim);
            } else{
                JOptionPane.showMessageDialog(null, "Không tìm thấy phòng nào có" + txtSoLuongSoFa.getText() +"sofa");			
            }	
        }
        /**
        * Tìm theo dàn loa
        */
        else if(txtDanLoa.getText().trim().length() != 0){       
            ArrayList<Phong> listTim;
            listTim = phong_dao.timTheoDanLoa(txtDanLoa.getText().trim());
            if ( listTim.size() > 0) {
		xoaDuLieuBang();
		themDuLieuPhongVaoBang(listTim);
            } else{
                JOptionPane.showMessageDialog(null, "Không tìm thấy phòng nào có dàn loa" + txtDanLoa.getText());			
            }	
        }
        /**
        * Tìm theo tình trạng bảo trì
        */
        else if(chkTinhTrangBaoTri.isSelected() == true){       
            ArrayList<Phong> listTim;
            listTim = phong_dao.timTheoTinhTrangBaoTri(chkTinhTrangBaoTri.isSelected());
            if ( listTim.size() > 0) {
		xoaDuLieuBang();
		themDuLieuPhongVaoBang(listTim);
            }	
        }
        else{
            JOptionPane.showMessageDialog(parentForm, "Vui lòng nhập thông tin tìm kiếm !");
        }
    }//GEN-LAST:event_btnTimPhongActionPerformed

    private void btnLuuPhongKhiSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuPhongKhiSuaActionPerformed
        // TODO add your handling code here:
        if (kiemTraDuLieu()) {
            String maPhong = txtMaPhong.getText().trim();
            TrangThaiPhong trangThaiPhong = new TrangThaiPhong(cbbTrangThaiPhong.getSelectedItem().toString());
            LoaiPhong loaiPhong = new LoaiPhong(cbbLoaiPhong.getSelectedItem().toString());
            Float dienTich = Float.parseFloat(txtDienTich.getText().trim());
            Float chieuCao = Float.parseFloat(txtChieuCao.getText().trim());
            String vatLieuCachAm = txtVatLieuCachAm.getText().trim();
            String tiVi = txtTiVi.getText().trim();
            Integer soLuongTiVi = Integer.parseInt(txtSoLuongTiVi.getText().trim());
            String thuongHieuTiVi = txtThuongHieuTiVi.getText().trim();
            String ban = txtBan.getText().trim();
            Integer soLuongBan = Integer.parseInt(txtSoLuongBan.getText().trim());
            String soFa = txtSoFa.getText().trim();
            Integer soLuongSoFa =Integer.parseInt(txtSoLuongSoFa.getText().trim());
            String danLoa = txtDanLoa.getText().trim();
            String moTa = txtAreaMoTa.getText().trim();
            Boolean tinhTrangBaoTri = chkTinhTrangBaoTri.isSelected();          
            String imagePhongPath = lblImgPath.getText().trim();         
            int index = imagePhongPath.lastIndexOf('\\');//lấy path mới
            String name = imagePhongPath.substring(index+1);
            String hinhAnh = "\\\\src\\\\image\\\\phong\\\\"+ name;             
            Phong phongNew = new Phong(maPhong, trangThaiPhong, loaiPhong, dienTich, chieuCao, vatLieuCachAm, tiVi, soLuongTiVi, thuongHieuTiVi, ban, soLuongBan, soFa, soLuongSoFa, danLoa, moTa, tinhTrangBaoTri, hinhAnh);
            /**
            *  Lấy thông tin phòng đưa vào hàm sửa
            */    
            suaPhong(phongNew); 
            anCacPhanTuTXT(false);
            anCacButton(true);
            btnLuuPhongKhiThem.setVisible(true);
            btnLuuPhongKhiThem.setEnabled(false);
            btnLuuPhongKhiSua.setVisible(false);           
            btnSuaPhong.setEnabled(true);
            btnSuaPhong.setText("Sửa"); 
        }  
    }//GEN-LAST:event_btnLuuPhongKhiSuaActionPerformed

    private void btnTimPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimPhongMouseClicked
        if (evt.getClickCount() == 2) {
           xoaDuLieuBang();
            themDuLieuPhongVaoBang(listPhong);                    
        }
    }//GEN-LAST:event_btnTimPhongMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImage;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLocPhong;
    private javax.swing.JButton btnLuuPhongKhiSua;
    private javax.swing.JButton btnLuuPhongKhiThem;
    private javax.swing.JButton btnSuaPhong;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimPhong;
    private javax.swing.JButton btnXoaPhong;
    private javax.swing.JComboBox<String> cbbLoaiPhong;
    private javax.swing.JComboBox<String> cbbLocLoaiPhong;
    private javax.swing.JComboBox<String> cbbTrangThaiPhong;
    private javax.swing.JCheckBox chkTinhTrangBaoTri;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBan;
    private javax.swing.JLabel lblChieuCao;
    private javax.swing.JLabel lblDanLoa;
    private javax.swing.JLabel lblDienTich;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblImgPath;
    private javax.swing.JLabel lblLoaiPhong;
    private javax.swing.JLabel lblMaPhong;
    private javax.swing.JLabel lblMoTa;
    private javax.swing.JLabel lblSoFa;
    private javax.swing.JLabel lblSoLuongBan;
    private javax.swing.JLabel lblSoLuongSoFa;
    private javax.swing.JLabel lblSoLuongTiVi;
    private javax.swing.JLabel lblThuongHieuTiVi;
    private javax.swing.JLabel lblTiVi;
    private javax.swing.JLabel lblTinhTrangBaoTri;
    private javax.swing.JLabel lblTrangThaiPhong;
    private javax.swing.JLabel lblVatLieuCachAm;
    private javax.swing.JPanel pChucNang;
    private javax.swing.JPanel pDanhSachPhong;
    private javax.swing.JPanel pLoc;
    private javax.swing.JPanel pThongTinPhongHat;
    private javax.swing.JScrollPane scrPhong;
    private javax.swing.JTable tblPhong;
    private java.awt.TextArea txtAreaMoTa;
    private javax.swing.JTextField txtBan;
    private javax.swing.JTextField txtChieuCao;
    private javax.swing.JTextField txtDanLoa;
    private javax.swing.JTextField txtDienTich;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtSoFa;
    private javax.swing.JTextField txtSoLuongBan;
    private javax.swing.JTextField txtSoLuongSoFa;
    private javax.swing.JTextField txtSoLuongTiVi;
    private javax.swing.JTextField txtThuongHieuTiVi;
    private javax.swing.JTextField txtTiVi;
    private javax.swing.JTextField txtVatLieuCachAm;
    // End of variables declaration//GEN-END:variables
}
