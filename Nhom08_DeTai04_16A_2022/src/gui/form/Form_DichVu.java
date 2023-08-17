
package gui.form;

import dao.Dao_DichVu;
import dao.Dao_SanPham;
import entity.DichVu;
import entity.SanPham;
import gui.swing.ImageHelper;
import java.awt.Image;
import javax.swing.ImageIcon;
import gui.swing.JPanerRadiusBorder;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THANHTU
 */
public class Form_DichVu extends javax.swing.JPanel {

    private Dao_DichVu dichVu_dao = new Dao_DichVu();
    private Dao_SanPham sanPham_dao = new Dao_SanPham();
    
    private Component parentForm;
    private DefaultTableModel modelDichVu;
    private ArrayList<DichVu> listDichVu;
    public Form_DichVu() {
        initComponents();
        btnLuuDichVuKhiSua.setVisible(false);
        listDichVu = dichVu_dao.getDanhSachDichVu();
        themDuLieuVaoBang(listDichVu);
        themDuLieuSanPhamPhongVaoCBB();
    }

    private void themDuLieuVaoBang(ArrayList<DichVu> listDV){
        modelDichVu = (DefaultTableModel)tblDichVu.getModel();
        for (DichVu dv : listDV) {
            modelDichVu.addRow(new Object[] {
                dv.getMaDichVu(),
                dv.getTenDichVu(),
                dv.getDonViTinh(),
                dv.isTrangThaiDichVu()==true?"Sẵn sàng":"Chưa sẵn sàng",
                dv.getHinhAnh(),
                dv.getSanPham().getTenSanPham(),
                dv.tinhGiaBan(dv.getSanPham().getMaSanPham())
            });
        }
    }
    private void themDuLieuSanPhamPhongVaoCBB() {
        ArrayList<SanPham> listSP = sanPham_dao.getDanhSachMaSanPham();
        for (SanPham sanPham : listSP) {
            cbbSanPham.addItem(sanPham.getTenSanPham());
        }
    }
    
     public void xoaRong(){
//        txtMaDichVu.setText("");
        txtTenDichVu.setText("");
        txtDonViTinh.setText("");
        chkTrangThaiDichVu.setSelected(false);
        cbbSanPham.setSelectedIndex(0);       
        ImageIcon iCon = new ImageIcon(getClass().getResource("/image/sanPham/chonAnh_1.png"));
        lblImage.setIcon(iCon);//hình ảnh mặc định khi xóa trắng
        lblImgPath.setText("");
    }
     
    public void xoaDuLieuBang() {
        DefaultTableModel dm = (DefaultTableModel) tblDichVu.getModel();
        dm.getDataVector().removeAllElements();
    }
    
    public void anCacPhanTuTXT(Boolean bl){
        txtMaDichVu.setEnabled(bl);
        txtTenDichVu.setEnabled(bl);
        txtDonViTinh.setEnabled(bl);
        chkTrangThaiDichVu.setEnabled(bl);       
        cbbSanPham.setEnabled(bl);
        btnAnh.setEnabled(bl);  
    }
        
    public void anCacButton(Boolean bl){
       btnTimDV.setEnabled(bl);
       btnThemDV.setEnabled(bl);
       btnLamMoi.setEnabled(bl);
       btnSuaDV.setEnabled(bl);
       btnLuuDichVuKhiSua.setEnabled(bl);
       btnLuuDichVuKhiThem.setEnabled(bl);
       btnXoaDV.setEnabled(bl);
    }
    
    private void suaDichVu(DichVu dichVuNew) {
	dichVu_dao.suaDichVu(dichVuNew);
        xoaDuLieuBang();
        ArrayList<DichVu> listDichVuNew = dichVu_dao.getDanhSachDichVu();//lấy lại danh sách mới
        themDuLieuVaoBang(listDichVuNew);
	JOptionPane.showMessageDialog(this,"Sửa thành công.");	
    }
    
      private boolean kiemTraDuLieu() {
        String maDichVu = txtMaDichVu.getText().trim();  
        String tenDichVu = txtTenDichVu.getText().trim();
        String donViTinh = txtDonViTinh.getText().trim();        
            
        if(!(tenDichVu.length()>0 && tenDichVu.matches("^[ A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ0-9]+$"))) 
        {
            JOptionPane.showMessageDialog(this,"Error: Tên dịch vụ không hợp lệ(Không chứa các kí tự đặc biệt)!");
            txtTenDichVu.requestFocus();
            return false;
	}
        if(!(donViTinh.length()>0 && donViTinh.matches("^[ A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ0-9]+$"))) 
        {
            JOptionPane.showMessageDialog(this,"Error: Đơn vị tính không hợp lệ(Không chứa các kí tự đặc biệt)!");
            txtDonViTinh.requestFocus();
            return false;
	}  
        if (cbbSanPham.getSelectedIndex()== 0) {
            JOptionPane.showMessageDialog(this,"Error: Vui lòng chọn mã sản phẩm!");
            cbbSanPham.requestFocus();
            return false;
          }
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        pDanhSachDichVu = new javax.swing.JPanel();
        scrDichVu = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pThongTinDichVu = new javax.swing.JPanel();
        lblMaDichVu = new javax.swing.JLabel();
        lblTenDichVu = new javax.swing.JLabel();
        lblDonViTinh = new javax.swing.JLabel();
        lblTrangThaiDichVu = new javax.swing.JLabel();
        txtMaDichVu = new javax.swing.JTextField();
        txtTenDichVu = new javax.swing.JTextField();
        lblHinh = new javax.swing.JLabel();
        cbbSanPham = new javax.swing.JComboBox<>();
        lblSanPham = new javax.swing.JLabel();
        txtDonViTinh = new javax.swing.JTextField();
        chkTrangThaiDichVu = new javax.swing.JCheckBox();
        btnAnh = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();
        lblImgPath = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        pChucNang = new javax.swing.JPanel();
        btnSuaDV = new javax.swing.JButton();
        btnThemDV = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnXoaDV = new javax.swing.JButton();
        btnTimDV = new javax.swing.JButton();
        btnLuuDichVuKhiThem = new javax.swing.JButton();
        btnLuuDichVuKhiSua = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pDanhSachDichVu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách dịch vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Đơn vị tính", "Trạng thái dịch vụ", "Hình ảnh", "Sản phẩm", "Giá bán"
            }
        ));
        tblDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDichVuMouseClicked(evt);
            }
        });
        scrDichVu.setViewportView(tblDichVu);

        javax.swing.GroupLayout pDanhSachDichVuLayout = new javax.swing.GroupLayout(pDanhSachDichVu);
        pDanhSachDichVu.setLayout(pDanhSachDichVuLayout);
        pDanhSachDichVuLayout.setHorizontalGroup(
            pDanhSachDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrDichVu)
        );
        pDanhSachDichVuLayout.setVerticalGroup(
            pDanhSachDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDanhSachDichVuLayout.createSequentialGroup()
                .addComponent(scrDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel5.setBackground(new java.awt.Color(204, 153, 255));
        jPanel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(121, 87, 142));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/dichVu.png"))); // NOI18N
        jLabel1.setText("Quản lý dịch vụ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pThongTinDichVu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin dịch vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N
        pThongTinDichVu.setForeground(new java.awt.Color(124, 36, 207));
        pThongTinDichVu.setMaximumSize(new java.awt.Dimension(1190, 770));

        lblMaDichVu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblMaDichVu.setText("Mã dịch vụ:");

        lblTenDichVu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTenDichVu.setText("Tên dịch vụ:");

        lblDonViTinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblDonViTinh.setText("Đơn vị tính:");

        lblTrangThaiDichVu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTrangThaiDichVu.setText("Trạng thái dịch vụ:");

        txtMaDichVu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDichVuActionPerformed(evt);
            }
        });

        txtTenDichVu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTenDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDichVuActionPerformed(evt);
            }
        });

        lblHinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblHinh.setText("Hình ảnh:");

        cbbSanPham.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbbSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn sản phẩm" }));

        lblSanPham.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblSanPham.setText("Sản phẩm:");

        txtDonViTinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtDonViTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonViTinhActionPerformed(evt);
            }
        });

        chkTrangThaiDichVu.setText("Sẵn sàng phục vụ");
        chkTrangThaiDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTrangThaiDichVuActionPerformed(evt);
            }
        });

        btnAnh.setBackground(new java.awt.Color(177, 100, 252));
        btnAnh.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnAnh.setForeground(new java.awt.Color(255, 255, 255));
        btnAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/camera.png"))); // NOI18N
        btnAnh.setText("Chọn ảnh");
        btnAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnhActionPerformed(evt);
            }
        });

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/chonAnh.png"))); // NOI18N

        lblImgPath.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Giá bán:");

        txtGiaBan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtGiaBan.setEnabled(false);
        txtGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pThongTinDichVuLayout = new javax.swing.GroupLayout(pThongTinDichVu);
        pThongTinDichVu.setLayout(pThongTinDichVuLayout);
        pThongTinDichVuLayout.setHorizontalGroup(
            pThongTinDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pThongTinDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pThongTinDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pThongTinDichVuLayout.createSequentialGroup()
                        .addGroup(pThongTinDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pThongTinDichVuLayout.createSequentialGroup()
                                .addGroup(pThongTinDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(pThongTinDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenDichVu)
                                    .addComponent(txtDonViTinh)
                                    .addComponent(txtMaDichVu)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pThongTinDichVuLayout.createSequentialGroup()
                                .addComponent(lblTrangThaiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkTrangThaiDichVu)
                                .addGap(0, 320, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pThongTinDichVuLayout.createSequentialGroup()
                                .addComponent(lblSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbSanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pThongTinDichVuLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiaBan)))
                        .addGroup(pThongTinDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pThongTinDichVuLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pThongTinDichVuLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(pThongTinDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblImgPath, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblImage))))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pThongTinDichVuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAnh)
                        .addGap(224, 224, 224))))
        );
        pThongTinDichVuLayout.setVerticalGroup(
            pThongTinDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pThongTinDichVuLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblHinh)
                .addGap(0, 0, 0)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblImgPath, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(pThongTinDichVuLayout.createSequentialGroup()
                .addGroup(pThongTinDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaDichVu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pThongTinDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenDichVu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pThongTinDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDonViTinh)
                    .addComponent(txtDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pThongTinDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTrangThaiDichVu)
                    .addComponent(chkTrangThaiDichVu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pThongTinDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSanPham))
                .addGap(18, 18, 18)
                .addGroup(pThongTinDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pChucNang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Các chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        btnSuaDV.setBackground(new java.awt.Color(177, 100, 252));
        btnSuaDV.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnSuaDV.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/edit.png"))); // NOI18N
        btnSuaDV.setText("Sửa");
        btnSuaDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDVActionPerformed(evt);
            }
        });

        btnThemDV.setBackground(new java.awt.Color(177, 100, 252));
        btnThemDV.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnThemDV.setForeground(new java.awt.Color(255, 255, 255));
        btnThemDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/buy-online.png"))); // NOI18N
        btnThemDV.setText("Thêm");
        btnThemDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDVActionPerformed(evt);
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

        btnXoaDV.setBackground(new java.awt.Color(177, 100, 252));
        btnXoaDV.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnXoaDV.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/huyPhongCho.png"))); // NOI18N
        btnXoaDV.setText("Xóa");
        btnXoaDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDVActionPerformed(evt);
            }
        });

        btnTimDV.setBackground(new java.awt.Color(177, 100, 252));
        btnTimDV.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnTimDV.setForeground(new java.awt.Color(255, 255, 255));
        btnTimDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/search.png"))); // NOI18N
        btnTimDV.setText("Tìm");
        btnTimDV.setToolTipText("Nhấn 2 lần để hiển thị full danh sách");
        btnTimDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimDVMouseClicked(evt);
            }
        });
        btnTimDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimDVActionPerformed(evt);
            }
        });

        btnLuuDichVuKhiThem.setBackground(new java.awt.Color(177, 100, 252));
        btnLuuDichVuKhiThem.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnLuuDichVuKhiThem.setForeground(new java.awt.Color(255, 255, 255));
        btnLuuDichVuKhiThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/save.png"))); // NOI18N
        btnLuuDichVuKhiThem.setText("Lưu");
        btnLuuDichVuKhiThem.setEnabled(false);
        btnLuuDichVuKhiThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuDichVuKhiThemActionPerformed(evt);
            }
        });

        btnLuuDichVuKhiSua.setBackground(new java.awt.Color(177, 100, 252));
        btnLuuDichVuKhiSua.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnLuuDichVuKhiSua.setForeground(new java.awt.Color(255, 255, 255));
        btnLuuDichVuKhiSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/save.png"))); // NOI18N
        btnLuuDichVuKhiSua.setText("Lưu");
        btnLuuDichVuKhiSua.setEnabled(false);
        btnLuuDichVuKhiSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuDichVuKhiSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pChucNangLayout = new javax.swing.GroupLayout(pChucNang);
        pChucNang.setLayout(pChucNangLayout);
        pChucNangLayout.setHorizontalGroup(
            pChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                    .addComponent(btnXoaDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLuuDichVuKhiThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLuuDichVuKhiSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pChucNangLayout.setVerticalGroup(
            pChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTimDV, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThemDV, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLuuDichVuKhiThem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLuuDichVuKhiSua, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pThongTinDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pDanhSachDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pThongTinDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(pDanhSachDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDichVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDichVuActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        xoaRong();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtMaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDichVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDichVuActionPerformed

    private void txtDonViTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonViTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonViTinhActionPerformed

    private void chkTrangThaiDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTrangThaiDichVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkTrangThaiDichVuActionPerformed

    private void btnAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnhActionPerformed
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
    }//GEN-LAST:event_btnAnhActionPerformed

    private void tblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMouseClicked
        // TODO add your handling code here:
        int row = tblDichVu.getSelectedRow();
        
        anCacPhanTuTXT(false); 
        txtMaDichVu.setEnabled(false);
        anCacButton(true);
        btnLuuDichVuKhiThem.setVisible(true);
        btnLuuDichVuKhiThem.setEnabled(false);
        btnLuuDichVuKhiSua.setVisible(false);
        btnThemDV.setEnabled(true);
        btnThemDV.setText("Thêm");
        btnSuaDV.setEnabled(true);
        btnSuaDV.setText("Sửa");
        
        txtMaDichVu.setText(modelDichVu.getValueAt(row, 0).toString());
        txtTenDichVu.setText(modelDichVu.getValueAt(row, 1).toString());
        txtDonViTinh.setText(modelDichVu.getValueAt(row, 2).toString());
        chkTrangThaiDichVu.setSelected(modelDichVu.getValueAt(row, 3).toString() == "true" ? true : false);
        lblImage.setIcon(ResizeImage(String.valueOf(System.getProperty("user.dir") + modelDichVu.getValueAt(row, 4).toString())));
        lblImgPath.setText(System.getProperty("user.dir") + modelDichVu.getValueAt(row, 4).toString());      
        cbbSanPham.setSelectedItem(modelDichVu.getValueAt(row, 5).toString());
        txtGiaBan.setText(modelDichVu.getValueAt(row, 6).toString());
    }//GEN-LAST:event_tblDichVuMouseClicked

    private void btnThemDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDVActionPerformed
        // TODO add your handling code here:
         if (btnThemDV.getText().equalsIgnoreCase("Thêm")) {
            anCacPhanTuTXT(true);
            anCacButton(false);
            xoaRong();         
            txtMaDichVu.setEnabled(false);
            txtMaDichVu.setText(dichVu_dao.getMaDVTuDong());
            btnLuuDichVuKhiThem.setEnabled(true);
            btnThemDV.setEnabled(true);
            btnThemDV.setText("Hủy");
            btnLamMoi.setEnabled(true);

	}else if (btnThemDV.getText().equalsIgnoreCase("Hủy")) {
            anCacPhanTuTXT(true);
            anCacButton(true);
            xoaRong();
            txtMaDichVu.setText("");
//            txtMaDichVu.setEnabled(true);
            btnLuuDichVuKhiThem.setEnabled(false);
            btnThemDV.setEnabled(true);
            btnThemDV.setText("Thêm");
        }       
        
    }//GEN-LAST:event_btnThemDVActionPerformed

    private void btnLuuDichVuKhiThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuDichVuKhiThemActionPerformed
        // TODO add your handling code here:
        if(kiemTraDuLieu()) {
            DichVu dv = new DichVu();
            dv.setMaDichVu(txtMaDichVu.getText().trim());
            dv.setSanPham(new SanPham(cbbSanPham.getSelectedItem().toString()));
            dv.setTenDichVu(txtTenDichVu.getText().trim());
            dv.setDonViTinh(txtDonViTinh.getText().trim());
            String imageDichVuPath = lblImgPath.getText().trim();  
            int index = imageDichVuPath.lastIndexOf('\\');//lấy path mới
            String name = imageDichVuPath.substring(index+1);
            dv.setHinhAnh("\\\\src\\\\image\\\\sanPham\\\\" + name);
            dv.setTrangThaiDichVu(chkTrangThaiDichVu.isSelected());
            dichVu_dao.addDichVU(dv);
            modelDichVu.addRow(new Object[]{
                dv.getMaDichVu(),
                dv.getTenDichVu(),
                dv.getDonViTinh(),
                dv.isTrangThaiDichVu(),
                dv.getHinhAnh(),
                dv.getSanPham().getMaSanPham()
            });
            JOptionPane.showMessageDialog(this,"Thêm dịch vụ thành công !");   
            anCacButton(true);
            xoaRong(); 
            txtMaDichVu.setText("");
            txtMaDichVu.setEnabled(true);
            btnLuuDichVuKhiThem.setEnabled(false);
            btnThemDV.setEnabled(true);
            btnThemDV.setText("Thêm");   
        }         
    }//GEN-LAST:event_btnLuuDichVuKhiThemActionPerformed

    private void btnXoaDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDVActionPerformed
        int r = tblDichVu.getSelectedRow();
        if (r == -1) {
            JOptionPane.showMessageDialog(this,"Vui lòng chọn dòng cần xóa !");
	}else {
            dichVu_dao.xoaDichVu(tblDichVu.getValueAt(tblDichVu.getSelectedRow(), 0).toString());
            //cách1 xóa trong table model 
            //modelNhanVien.removeRow(r); // xóa trong table model 
            //cách 2: xóa trong table model 
            modelDichVu.setRowCount(0);
            ArrayList<DichVu> listDichVuSauKhiXoa = dichVu_dao.getDanhSachDichVu();
            themDuLieuVaoBang(listDichVuSauKhiXoa);
            xoaRong();
            JOptionPane.showMessageDialog(this,"Xóa thành công !");	
	}        
    }//GEN-LAST:event_btnXoaDVActionPerformed

    private void btnLuuDichVuKhiSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuDichVuKhiSuaActionPerformed
        if (kiemTraDuLieu()) {
            String maDichVu = txtMaDichVu.getText().trim();
            SanPham sanPham = new SanPham(cbbSanPham.getSelectedItem().toString());
            String tenDichVu = txtTenDichVu.getText().trim();
            String donViTinh = txtDonViTinh.getText().trim();
            String imageDichVuPath = lblImgPath.getText().trim();         
            int index = imageDichVuPath.lastIndexOf('\\');//lấy path mới
            String name = imageDichVuPath.substring(index+1);
            String hinhAnh = "\\\\src\\\\image\\\\sanPham\\\\"+ name;      
            Boolean tinhTrangBaoTri = chkTrangThaiDichVu.isSelected();          
            DichVu dichVuNew = new DichVu(maDichVu, sanPham, tenDichVu, donViTinh, hinhAnh, tinhTrangBaoTri);
            /**
            *  Lấy thông tin dịch vụ đưa vào hàm sửa
            */    
            suaDichVu(dichVuNew); 
            anCacPhanTuTXT(false);
            anCacButton(true);
            btnLuuDichVuKhiThem.setVisible(true);
            btnLuuDichVuKhiThem.setEnabled(false);
            btnLuuDichVuKhiSua.setVisible(false);           
            btnSuaDV.setEnabled(true);
            btnSuaDV.setText("Sửa");   
        }     
    }//GEN-LAST:event_btnLuuDichVuKhiSuaActionPerformed

    private void btnSuaDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDVActionPerformed
    if (btnSuaDV.getText().equalsIgnoreCase("Sửa")) {
        anCacPhanTuTXT(true);
        anCacButton(false);
            
        txtMaDichVu.setEnabled(false);         
        btnSuaDV.setEnabled(true);
        btnSuaDV.setText("Hủy");
        btnLamMoi.setEnabled(true);
        btnLuuDichVuKhiThem.setVisible(false);
        btnLuuDichVuKhiSua.setVisible(true);
        btnLuuDichVuKhiSua.setEnabled(true); 
	}else if (btnSuaDV.getText().equalsIgnoreCase("Hủy")) {
            anCacPhanTuTXT(true);          
            anCacButton(true);   
            xoaRong();
            
            txtMaDichVu.setText("");
            btnSuaDV.setEnabled(true);
            btnSuaDV.setText("Sửa");
            btnLuuDichVuKhiSua.setVisible(false);
            btnLuuDichVuKhiThem.setVisible(true); 
            btnLuuDichVuKhiThem.setEnabled(false);
        }      
    }//GEN-LAST:event_btnSuaDVActionPerformed

    private void btnTimDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimDVActionPerformed
        anCacPhanTuTXT( true);
        /**
        * Tìm theo mã
        */
        if (txtMaDichVu.getText().trim().length() != 0) {
            modelDichVu.setRowCount(0);
            DichVu dichVu = dichVu_dao.timDichVuTheoMa(txtMaDichVu.getText().trim());
            if (dichVu != null) {
		modelDichVu.addRow(new Object[] {
                    dichVu.getMaDichVu(),
                    dichVu.getTenDichVu(),
                    dichVu.getDonViTinh(),
                    dichVu.isTrangThaiDichVu(),
                    dichVu.getHinhAnh(),
                    dichVu.getSanPham().getMaSanPham()                                   
               });
            }
        }
        /**
        * Tìm theo tên
        */
        else if (txtTenDichVu.getText().trim().length() != 0) {
            ArrayList<DichVu> listTim;
            listTim = dichVu_dao.timTheoTenDichVu(txtTenDichVu.getText().trim());
            if ( listTim.size() > 0) {
		xoaDuLieuBang();
		themDuLieuVaoBang(listTim);
            } else{
                JOptionPane.showMessageDialog(null, "Không tìm thấy dịch vụ có tên: " + txtTenDichVu.getText());			
            }
        }
        /**
        * Tìm theo đơn vị tính
        */
        else if (txtDonViTinh.getText().trim().length() != 0) {
            ArrayList<DichVu> listTim;
            listTim = dichVu_dao.timTheoDonViTinh(txtDonViTinh.getText().trim());
            if ( listTim.size() > 0) {
		xoaDuLieuBang();
		themDuLieuVaoBang(listTim);
            } else{
                JOptionPane.showMessageDialog(null, "Không tìm thấy đơn vị tính nào là: " + txtDonViTinh.getText());			
            }
        }
        /**
        * Tìm theo mã sản phẩm
        */
        else if (cbbSanPham.getSelectedItem().toString().length() != 0 && cbbSanPham.getSelectedItem() != "Chọn mã sản phẩm") {
            ArrayList<DichVu> listTim;
            listTim = dichVu_dao.timTheoMaSanPham(cbbSanPham.getSelectedItem().toString());
            if ( listTim.size() > 0) {
		xoaDuLieuBang();
		themDuLieuVaoBang(listTim);
            } else{
                JOptionPane.showMessageDialog(null, "Không tìm thấy mã sản phẩm nào là: " + cbbSanPham.getSelectedItem().toString());			
            }
        }
        /**
        * Tìm theo trạng thái dich vụ
        */
        else if (chkTrangThaiDichVu.isSelected() == true ) {
            ArrayList<DichVu> listTim;
            listTim = dichVu_dao.timTheoTrangThaiDichVu(chkTrangThaiDichVu.isSelected());
            if ( listTim.size() > 0) {
		xoaDuLieuBang();
		themDuLieuVaoBang(listTim);
            } else{
                JOptionPane.showMessageDialog(null, "Không tìm thấy đơn vị tính nào là: " + txtDonViTinh.getText());			
            }
        }
    }//GEN-LAST:event_btnTimDVActionPerformed

    private void btnTimDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimDVMouseClicked
        if (evt.getClickCount() == 2) {
            xoaDuLieuBang();
            themDuLieuVaoBang(listDichVu);       
            xoaRong();
            txtMaDichVu.setText("");
        }
    }//GEN-LAST:event_btnTimDVMouseClicked

    private void txtGiaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBanActionPerformed
    public ImageIcon ResizeImage(String ImagePath){
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnh;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLuuDichVuKhiSua;
    private javax.swing.JButton btnLuuDichVuKhiThem;
    private javax.swing.JButton btnSuaDV;
    private javax.swing.JButton btnThemDV;
    private javax.swing.JButton btnTimDV;
    private javax.swing.JButton btnXoaDV;
    private javax.swing.JComboBox<String> cbbSanPham;
    private javax.swing.JCheckBox chkTrangThaiDichVu;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblDonViTinh;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblImgPath;
    private javax.swing.JLabel lblMaDichVu;
    private javax.swing.JLabel lblSanPham;
    private javax.swing.JLabel lblTenDichVu;
    private javax.swing.JLabel lblTrangThaiDichVu;
    private javax.swing.JPanel pChucNang;
    private javax.swing.JPanel pDanhSachDichVu;
    private javax.swing.JPanel pThongTinDichVu;
    private javax.swing.JScrollPane scrDichVu;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTextField txtDonViTinh;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaDichVu;
    private javax.swing.JTextField txtTenDichVu;
    // End of variables declaration//GEN-END:variables
}
