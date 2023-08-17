package gui.form;

import dao.Dao_LoaiSanpham;
import dao.Dao_SanPham;
import entity.LoaiSanPham;
import entity.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_SanPham extends javax.swing.JPanel {

    private Dao_LoaiSanpham loaiSanPham_Dao = new Dao_LoaiSanpham();
    private Dao_SanPham sanPham_Dao = new Dao_SanPham();
    private DefaultTableModel modelSanPham;
    private ArrayList<SanPham> listSanPham;

    public Form_SanPham() {
        initComponents();
        dcHSD.getJCalendar().setMinSelectableDate(new Date());
        dcNgayNhap.getJCalendar().setMaxSelectableDate(new Date());
        listSanPham = sanPham_Dao.getAllSanPham();
        themDuLieuSanPhamVaoBang(listSanPham);
        themDuLieuLoaiPhongVaoCBB();
    }

    private void themDuLieuSanPhamVaoBang(ArrayList<SanPham> listSanPham) {
        modelSanPham = (DefaultTableModel) tableSanPham.getModel();
//        listPhong = phong_dao.getDanhSachPhong();//không cần hàng này vì ta đã truyền tham số vào , để có thể sử dụng được nhiều hơn
        for (SanPham sp : listSanPham) {
            modelSanPham.addRow(new Object[]{
                sp.getMaSanPham(),
                sp.getTenSanPham(),
                sp.getSoLuongSanPham(),
                sp.getLoaiSanPham().getTenLoaiSanPham(),
                sp.getGiaNhap(),
                sp.getNoiLayHang(),
                sp.getHanSuDung(),
                sp.getNgayNhapSanPham(),
                sp.getNhaCungCap()
            });
        }
    }

    private void themDuLieuLoaiPhongVaoCBB() {
        ArrayList<LoaiSanPham> listSP = loaiSanPham_Dao.getListSanPham();
        for (LoaiSanPham loaiSP : listSP) {
            cbbLoaiSP.addItem(loaiSP.getMaLoaiSanPham() + ":" + loaiSP.getTenLoaiSanPham());
        }
        for (LoaiSanPham loaiSP : listSP) {
            cbbLocSP.addItem(loaiSP.getTenLoaiSanPham());
        }
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMonthChooserBeanInfo1 = new com.toedter.calendar.JMonthChooserBeanInfo();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnFilter = new javax.swing.JButton();
        cbbLocSP = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtMaSP1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtSoLuongSP = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txttenSP1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtGiaNhap1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtNhaCC = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dcHSD = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        txtNoiLayHang = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        dcNgayNhap = new com.toedter.calendar.JDateChooser();
        cbbLoaiSP = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        tableSanPham.setBackground(new java.awt.Color(238, 239, 243));
        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng sản phẩm", "Loại sản phẩm", "Giá nhập", "Nơi lấy hàng", "Hạng sử dụng", "Ngày nhập", "Nhà cung cấp "
            }
        ));
        tableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableSanPham);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1653, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        jPanel16.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Loại sản phẩm :");

        btnFilter.setBackground(new java.awt.Color(177, 100, 252));
        btnFilter.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnFilter.setForeground(new java.awt.Color(255, 255, 255));
        btnFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/filter.png"))); // NOI18N
        btnFilter.setText("Lọc");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        cbbLocSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hiện tất cả" }));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbLocSP, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbbLocSP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Mã sản phẩm :");

        txtMaSP1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaSP1.setEnabled(false);
        txtMaSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSP1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("Số lượng sản phẩm: ");

        txtSoLuongSP.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addGap(488, 488, 488)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSoLuongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(164, 164, 164)
                    .addComponent(txtMaSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(691, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(16, Short.MAX_VALUE)
                    .addComponent(txtMaSP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Tên sản phẩm :");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Loại sản phẩm :");

        txttenSP1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Giá nhập:");

        txtGiaNhap1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Ngày nhập:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttenSP1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addComponent(txtGiaNhap1))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txttenSP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtGiaNhap1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Nhà cung cấp:");

        txtNhaCC.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Hạn sử dụng:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Nơi lấy hàng:");

        txtNoiLayHang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtNoiLayHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoiLayHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(dcHSD, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNoiLayHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txtNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addComponent(dcHSD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtNoiLayHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        cbbLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbLoaiSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dcNgayNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
                        .addGap(19, 19, 19))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbbLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dcNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Các chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        btnUpdate.setBackground(new java.awt.Color(177, 100, 252));
        btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/edit.png"))); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(177, 100, 252));
        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/buy-online.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(177, 100, 252));
        btnRefresh.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/reset.png"))); // NOI18N
        btnRefresh.setText("Làm mới");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(177, 100, 252));
        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/huyPhongCho.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(177, 100, 252));
        btnSearch.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/search.png"))); // NOI18N
        btnSearch.setText("Tìm");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel8.setBackground(new java.awt.Color(204, 153, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(121, 87, 142));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/sanPham.png"))); // NOI18N
        jLabel2.setText("Quản lí sản phẩm");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField43ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (validateFiled()) {
            txtMaSP1.setText(sanPham_Dao.TaoSoNgauNhien());
            String maSanPham = txtMaSP1.getText();
            System.out.println("maSanPham: " + maSanPham);
            String tenSP = txttenSP1.getText();
            Double giaNhap = Double.parseDouble(txtGiaNhap1.getText());
            String noiLayHang = txtNoiLayHang.getText();
            Date inputNgayNhap = dcNgayNhap.getDate();
            LocalDate ngayNhap = inputNgayNhap.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Date inputHSD = dcHSD.getDate();
            LocalDate hanSD = inputHSD.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String nhaCC = txtNhaCC.getText();
            String temp = (String) cbbLoaiSP.getSelectedItem();
            String[] temp2 = temp.split(":");
            LoaiSanPham loaiSanPham = new LoaiSanPham(temp2[0], temp2[1]);
            int soLuongSP = Integer.parseInt(txtSoLuongSP.getText());

            SanPham sp = new SanPham(maSanPham, tenSP, noiLayHang, nhaCC, loaiSanPham, soLuongSP, ngayNhap, hanSD, giaNhap);

            if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm sản phẩm ?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (sanPham_Dao.addSanPham(sp)) {
                    modelSanPham.addRow(new Object[]{sp.getMaSanPham(), sp.getTenSanPham(), sp.getSoLuongSanPham(), sp.getLoaiSanPham().getTenLoaiSanPham(), sp.getGiaNhap(), sp.getNoiLayHang(), sp.getHanSuDung(), sp.getNgayNhapSanPham(), sp.getNhaCungCap()});
                    JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm sản phẩm thất bại");
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int r = tableSanPham.getSelectedRow();
        if (r == -1)
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xoá");
        else {
            if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xoá?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (sanPham_Dao.deleteSanPham(txtMaSP1.getText())) {
                    modelSanPham.removeRow(r);
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSanPhamMouseClicked
        int row = tableSanPham.getSelectedRow();
        txtMaSP1.setText(tableSanPham.getValueAt(row, 0).toString());
        txttenSP1.setText(tableSanPham.getValueAt(row, 1).toString());
        txtSoLuongSP.setText(tableSanPham.getValueAt(row, 2).toString());
        cbbLoaiSP.setSelectedItem(tableSanPham.getValueAt(row, 3).toString());
        txtGiaNhap1.setText(tableSanPham.getValueAt(row, 4).toString());
        txtNoiLayHang.setText(tableSanPham.getValueAt(row, 5).toString());
        txtNhaCC.setText(tableSanPham.getValueAt(row, 8).toString());
        try {
            String hanSD = tableSanPham.getValueAt(row, 6).toString();
            Date sdf = new SimpleDateFormat("yyyy-MM-dd").parse((String) hanSD);
            dcHSD.setDate(sdf);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String ngayNhap = tableSanPham.getValueAt(row, 7).toString();
            Date sdf = new SimpleDateFormat("yyyy-MM-dd").parse((String) ngayNhap);
            dcNgayNhap.setDate(sdf);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tableSanPhamMouseClicked

    public void refersh() {
        txtMaSP1.setText(sanPham_Dao.TaoSoNgauNhien());
        txttenSP1.setText("");
        txtGiaNhap1.setText("");
        txtNoiLayHang.setText("");
        txtSoLuongSP.setText("");
        txtNhaCC.setText("");
        try {
            dcHSD.setDate(null);
            dcNgayNhap.setDate(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(dcHSD, e);
        }
        try {
            dcNgayNhap.setDate(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(dcNgayNhap, e);
        }
    }

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refersh();
        lamMoiTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private boolean kiemTraTen() {
        String cmnd = txtNhaCC.getText();
        if (cmnd.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Nhập tên để tìm sản phẩm");
            txtNhaCC.requestFocus();
            return false;
        }
        return true;
    }

    public void xoaDuLieuBang() {
        DefaultTableModel dm = (DefaultTableModel) tableSanPham.getModel();
        dm.getDataVector().removeAllElements();
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        modelSanPham.setNumRows(0);
        String loaiSP = cbbLoaiSP.getSelectedItem().toString().split(";")[0];
        String tenSP = txttenSP1.getText().trim();
        String soLuongSP = txtSoLuongSP.getText();
        String giaNhap = txtGiaNhap1.getText().trim().split("\\.")[0];
        String noiLayHang = txtNoiLayHang.getText().trim();
        String ngayNhap;
        String hanSuDung;
        if(this.dcNgayNhap.getDate() == null) {
            ngayNhap = "";
        } else {
            Date tempNgayNhap = dcNgayNhap.getDate();
            ngayNhap = dateFormat.format(tempNgayNhap);
        }
        if(this.dcHSD.getDate() == null) {
            hanSuDung = "";
        } else {
            Date tempHanSuDung = dcHSD.getDate();
            hanSuDung = dateFormat.format(tempHanSuDung);
        }
        String nhaCC = txtNhaCC.getText().trim();

        for (SanPham sp : sanPham_Dao.timSanPhamTheoDK(tenSP, soLuongSP, giaNhap, noiLayHang, hanSuDung, ngayNhap, nhaCC)) {
            if (sp != null) {
                modelSanPham.addRow(new Object[]{
                    sp.getMaSanPham(),
                    sp.getTenSanPham(),
                    sp.getSoLuongSanPham(),
                    sp.getLoaiSanPham().getTenLoaiSanPham(),
                    sp.getGiaNhap(),
                    sp.getNoiLayHang(),
                    sp.getHanSuDung(),
                    sp.getNgayNhapSanPham(),
                    sp.getNhaCungCap()
                });
            }
        }
        JOptionPane.showMessageDialog(this, "Tìm thành công!");
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int r = tableSanPham.getSelectedRow();
        if (r == -1)
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
        else {
            if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa không ?", "Cảnh báo",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    if (validateFiled()) {
                        String maSanPham = txtMaSP1.getText();
                        String tenSP = txttenSP1.getText();
                        Double giaNhap = Double.valueOf(txtGiaNhap1.getText().trim());
                        String noiLayHang = txtNoiLayHang.getText();
                        Date inputNgayNhap = dcNgayNhap.getDate();
                        LocalDate ngayNhap = inputNgayNhap.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        Date inputHSD = dcHSD.getDate();
                        LocalDate hanSD = inputHSD.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        String nhaCC = txtNhaCC.getText();
                        String temp = (String) cbbLoaiSP.getSelectedItem();
                        String[] temp2 = temp.split(":");
                        LoaiSanPham loaiSanPham = new LoaiSanPham(temp2[0], temp2[1]);
                        int soLuongSP = Integer.parseInt(txtSoLuongSP.getText());
                        DateFormat dateFormat = null;
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                        SanPham sp = new SanPham(maSanPham, tenSP, noiLayHang, nhaCC, loaiSanPham, soLuongSP, ngayNhap, hanSD, giaNhap);
                        if (sanPham_Dao.updateSP(sp, maSanPham)) {
                            modelSanPham.setValueAt(txtNhaCC.getText(), r, 1);
                            modelSanPham.setValueAt(txtSoLuongSP.getText(), r, 2);
                            modelSanPham.setValueAt(cbbLoaiSP.getSelectedItem().toString(), r, 3);
                            modelSanPham.setValueAt(txtNhaCC.getText(), r, 4);
                            modelSanPham.setValueAt(txtNoiLayHang.getText(), r, 5);
                            modelSanPham.setValueAt(sdf.format(dcHSD.getDate()), r, 6);
                            modelSanPham.setValueAt(sdf.format(dcNgayNhap.getDate()), r, 7);
                            modelSanPham.setValueAt(txtNhaCC.getText(), r, 8);
                            JOptionPane.showMessageDialog(null, "Sửa thành công");
                            refersh();
                        } else {
                            JOptionPane.showMessageDialog(null, "Sửa thất bại! Vui lòng kiểm tra lại thông tin");
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Form_SanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        try {
            refersh();
            modelSanPham.setRowCount(0);
            String inDexComBoBox = cbbLocSP.getSelectedItem().toString();
            if (cbbLocSP.getSelectedItem() != "Hiện tất cả") {
                ResultSet p = sanPham_Dao.filteSanPhamTheoLoai(inDexComBoBox);
                while (p.next()) {
                    modelSanPham.addRow(new Object[]{
                        p.getString("maSanPham"),
                        p.getString("tenSanPham"),
                        p.getInt("soLuongSanPham"),
                        p.getString("tenloaiSanPham"),
                        p.getDouble("giaNhap"),
                        p.getString("noiLayHang"),
                        p.getDate("ngayNhapSanPham"),
                        p.getDate("hanSuDung"),
                        p.getString("nhaCungCap"),});
                }
            } else {
                xoaDuLieuBang();
                themDuLieuSanPhamVaoBang(listSanPham);
                tableSanPham.setModel(modelSanPham);
            }
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void txtNoiLayHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoiLayHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoiLayHangActionPerformed

    private void txtMaSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSP1ActionPerformed

    private void cbbLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLoaiSPActionPerformed

    private void lamMoiTable() {
        modelSanPham.getDataVector().removeAllElements();
        listSanPham = sanPham_Dao.getAllSanPham();
        themDuLieuSanPhamVaoBang(listSanPham);
    }
    
    private boolean validateFiled() {
        String maSanPham = txtMaSP1.getText();
        String tenSP = txttenSP1.getText();
        String giaNhap = txtGiaNhap1.getText();
        String noiLayHang = txtNoiLayHang.getText();
        String nhaCC = txtNhaCC.getText();
        String soLuongSP = txtSoLuongSP.getText();

        if (!(maSanPham != null && !maSanPham.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm không được rỗng, không được trùng");
            return false;
        }
        if (!(tenSP != null && !tenSP.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không được rỗng");
            return false;
        }
        if (!(noiLayHang != null && !noiLayHang.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Nơi nhập hàng không được rỗng");
            return false;
        }
        if (!(nhaCC != null && !nhaCC.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Nhà cung cấp không được rỗng");
            return false;
        }
        if (this.dcHSD.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hạn sử dụng cho sản phẩm");
        }
        if (this.dcNgayNhap.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hạn sử dụng cho sản phẩm");
        }
        try {
            Double temp = Double.valueOf(txtGiaNhap1.getText().trim());
            if (temp < 0) {
                JOptionPane.showMessageDialog(this, "Lỗi: Giá nhập phải > 0");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Lỗi: Giá nhập phải > 0");
            return false;
        }
        try {
            int temp = Integer.valueOf(txtSoLuongSP.getText().trim());
            if (temp < 0) {
                JOptionPane.showMessageDialog(this, "Lỗi: Số lượng sản phẩm phải > 0");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Lỗi: Số lượng sản phẩm nhập phải > 0");
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbLoaiSP;
    private javax.swing.JComboBox<String> cbbLocSP;
    private com.toedter.calendar.JDateChooser dcHSD;
    private com.toedter.calendar.JDateChooser dcNgayNhap;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooserBeanInfo jMonthChooserBeanInfo1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableSanPham;
    private javax.swing.JTextField txtGiaNhap1;
    private javax.swing.JTextField txtMaSP1;
    private javax.swing.JTextField txtNhaCC;
    private javax.swing.JTextField txtNoiLayHang;
    private javax.swing.JTextField txtSoLuongSP;
    private javax.swing.JTextField txttenSP1;
    // End of variables declaration//GEN-END:variables
}
