package gui.form;

import dao.Dao_ChiTietHoaDon;
import dao.Dao_HoaDon;
import dao.Dao_KhachHang;
import dao.Dao_Phong;
import entity.ChiTietDichVu;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.Phong;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.AbstractAction;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THANHTU
 */
public class Form_DanhSachHoaDonChuaThanhToan extends javax.swing.JFrame {

    private Dao_HoaDon hoaDon_dao = new Dao_HoaDon();
    private ArrayList<HoaDon> listHD;
    private DefaultTableModel modelHD;
    private Dao_ChiTietHoaDon dao_CTHD = new Dao_ChiTietHoaDon();
    private Dao_KhachHang dao_KH = new Dao_KhachHang();
    
    public Form_DanhSachHoaDonChuaThanhToan() {
        initComponents();
        listHD = hoaDon_dao.getDanhSachHDChuaTT();
        themDuLieuVaoBang(listHD);
        themDuLieuVaoCBBTenKhachHang(listHD);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        btnTinhTien = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHDChuaThanhToan = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbbTenKhachHang = new javax.swing.JComboBox<>();
        cbbSoDienThoaiKH = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(204, 153, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(121, 87, 142));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/chiTietHoaDon.png"))); // NOI18N
        jLabel1.setText("Danh sách hóa đơn chưa thanh toán");

        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/back.png"))); // NOI18N
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(261, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1062, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblBack)
                    .addContainerGap(742, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBack)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        btnTinhTien.setBackground(new java.awt.Color(177, 100, 252));
        btnTinhTien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTinhTien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/money.png"))); // NOI18N
        btnTinhTien.setText("Thanh toán");
        btnTinhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhTienActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách hóa đơn chưa thanh toán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(124, 36, 207))); // NOI18N

        tblHDChuaThanhToan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "1", "Mã hóa đơn", "Tên nhân viên", "Tên khách hàng", "Số điện thoại khách hàng", "Mã phòng", "Ngày lập", "Giờ nhận phòng", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHDChuaThanhToan);
        if (tblHDChuaThanhToan.getColumnModel().getColumnCount() > 0) {
            tblHDChuaThanhToan.getColumnModel().getColumn(0).setMaxWidth(20);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1183, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách khách hàng đang đặt phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(124, 36, 207))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Tên khách hàng:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Số điện thoại khách hàng:");

        cbbTenKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cbbTenKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hiện tất cả" }));
        cbbTenKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTenKhachHangActionPerformed(evt);
            }
        });

        cbbSoDienThoaiKH.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cbbSoDienThoaiKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hiện tất cả" }));
        cbbSoDienThoaiKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSoDienThoaiKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(79, 79, 79)
                .addComponent(cbbTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbSoDienThoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(cbbTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3)
                .addComponent(cbbSoDienThoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTinhTien)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnTinhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblBackMouseClicked

    private void btnTinhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhTienActionPerformed
        Form_ChiTietHoaDon frm = new Form_ChiTietHoaDon();
        String maHD;
        String maP;
        ArrayList<String> danhSachHoaDon = new ArrayList<>();
        ArrayList<String> danhSachNV = new ArrayList<>();
        for (int i = 0; i < tblHDChuaThanhToan.getModel().getRowCount(); i++) {
            if ((Boolean) tblHDChuaThanhToan.getModel().getValueAt(i, 0)) {
                maHD = (String) tblHDChuaThanhToan.getModel().getValueAt(i, 1);
                maP = (String) tblHDChuaThanhToan.getModel().getValueAt(i, 2);
                danhSachHoaDon.add(maHD);
                danhSachNV.add(maP);
                
            }
        }

        frm.danhSachData(danhSachHoaDon, danhSachNV);
        this.dispose();
        frm.setVisible(true);

    }//GEN-LAST:event_btnTinhTienActionPerformed

    private void cbbTenKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTenKhachHangActionPerformed
        if(cbbTenKhachHang.getSelectedIndex() != 0){
            xoaDuLieuBang();     
            String tenKH=cbbTenKhachHang.getSelectedItem().toString();
            ArrayList<HoaDon> listDichVuTheoTen = hoaDon_dao.getDanhSachHDChuaTTTheoTen(tenKH);
            KhachHang kh = new KhachHang();
            for (HoaDon hd : listDichVuTheoTen) {        
                ChiTietHoaDon cthd = dao_CTHD.timPhongTheoMaHD(hd.getMaHoaDon());
                kh = dao_KH.getKhachHangTheoMa(hd.getKhachHang().getMaKhachHang());
                modelHD.addRow(new Object[]{
                    false,
                    hd.getMaHoaDon(),
                    hd.getNhanVien().getTenNhanVien(),
                    hd.getKhachHang().getHoTenKhachHang(),
                    kh.getSoDienThoai(),
                    cthd.getPhong().getMaPhong(),
                    hd.getNgayLap(),
                    hd.getGioNhanPhong(),
                    hd.isTrangThai() == true ? "Đã thanh toán" : "Chưa thanh toán"
                });
            }      
            cbbSoDienThoaiKH.setSelectedItem(kh.getSoDienThoai());
        }else{
            xoaDuLieuBang();
            listHD = hoaDon_dao.getDanhSachHDChuaTT();
            themDuLieuVaoBang(listHD);
        }
        
        
    }//GEN-LAST:event_cbbTenKhachHangActionPerformed

    private void cbbSoDienThoaiKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSoDienThoaiKHActionPerformed
        if(cbbSoDienThoaiKH.getSelectedIndex() != 0){
            xoaDuLieuBang();     
            String sdtKH=cbbSoDienThoaiKH.getSelectedItem().toString();
            ArrayList<HoaDon> listDichVuTheoSDT = hoaDon_dao.getDanhSachHDChuaTTTheoSdt(sdtKH);
            KhachHang kh = new KhachHang();
            for (HoaDon hd : listDichVuTheoSDT) {        
                ChiTietHoaDon cthd = dao_CTHD.timPhongTheoMaHD(hd.getMaHoaDon());
                kh = dao_KH.getKhachHangTheoMa(hd.getKhachHang().getMaKhachHang());
                modelHD.addRow(new Object[]{
                    false,
                    hd.getMaHoaDon(),
                    hd.getNhanVien().getTenNhanVien(),
                    hd.getKhachHang().getHoTenKhachHang(),
                    kh.getSoDienThoai(),
                    cthd.getPhong().getMaPhong(),
                    hd.getNgayLap(),
                    hd.getGioNhanPhong(),
                    hd.isTrangThai() == true ? "Đã thanh toán" : "Chưa thanh toán"
                });
            }      
            cbbTenKhachHang.setSelectedItem(kh.getHoTenKhachHang());
        }else{
            xoaDuLieuBang();
            listHD = hoaDon_dao.getDanhSachHDChuaTT();
            themDuLieuVaoBang(listHD);
        }
        
        
        
        
    }//GEN-LAST:event_cbbSoDienThoaiKHActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_DanhSachHoaDonChuaThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_DanhSachHoaDonChuaThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_DanhSachHoaDonChuaThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_DanhSachHoaDonChuaThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_DanhSachHoaDonChuaThanhToan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTinhTien;
    private javax.swing.JComboBox<String> cbbSoDienThoaiKH;
    private javax.swing.JComboBox<String> cbbTenKhachHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBack;
    private javax.swing.JTable tblHDChuaThanhToan;
    // End of variables declaration//GEN-END:variables

    private void themDuLieuVaoBang(ArrayList<HoaDon> listHD) {
        modelHD = (DefaultTableModel) tblHDChuaThanhToan.getModel();
        for (HoaDon hd : listHD) {        
            ChiTietHoaDon cthd = dao_CTHD.timPhongTheoMaHD(hd.getMaHoaDon());
            KhachHang kh = dao_KH.getKhachHangTheoMa(hd.getKhachHang().getMaKhachHang());
       
            modelHD.addRow(new Object[]{
                false,
                hd.getMaHoaDon(),
                hd.getNhanVien().getTenNhanVien(),
                hd.getKhachHang().getHoTenKhachHang(),
                kh.getSoDienThoai(),
                cthd.getPhong().getMaPhong(),
                hd.getNgayLap(),
                hd.getGioNhanPhong(),
                hd.isTrangThai() == true ? "Đã thanh toán" : "Chưa thanh toán"
            });
        }
    }
    
    private void themDuLieuVaoCBBTenKhachHang(ArrayList<HoaDon> listHD) {
        List<String> tenKH  = new ArrayList<String>();
        List<String> sdtKH  = new ArrayList<String>();
        for (HoaDon hd : listHD) {
            tenKH.add(hd.getKhachHang().getHoTenKhachHang());
            KhachHang kh = dao_KH.getKhachHangTheoMa(hd.getKhachHang().getMaKhachHang());
            sdtKH.add(kh.getSoDienThoai());
        }       
        List<String>  tenKHLoc =  tenKH.stream().distinct().collect(Collectors.toList());  
        List<String>  sdtKHLoc =  sdtKH.stream().distinct().collect(Collectors.toList());        
        for (int i = 0; i < tenKHLoc.size(); i++) {
            cbbTenKhachHang.addItem(tenKHLoc.get(i));
            cbbSoDienThoaiKH.addItem(sdtKHLoc .get(i));
        }
    }
     
    public void xoaDuLieuBang() {
        DefaultTableModel dm = (DefaultTableModel) tblHDChuaThanhToan.getModel();
        dm.getDataVector().removeAllElements();
    }
}
