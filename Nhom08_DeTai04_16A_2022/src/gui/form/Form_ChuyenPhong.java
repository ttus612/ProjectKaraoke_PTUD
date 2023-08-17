package gui.form;

import dao.Dao_ChiTietDichVu;
import dao.Dao_ChiTietHoaDon;
import dao.Dao_PhieuDat;
import dao.Dao_Phong;
import entity.ChiTietDichVu;
import entity.LoaiPhong;
import entity.Phong;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author THANHTU
 */
public class Form_ChuyenPhong extends javax.swing.JFrame {

    private Dao_ChiTietHoaDon dao_ChiTietHoaDon = new Dao_ChiTietHoaDon();
    private Dao_Phong dao_Phong = new Dao_Phong();
    private Dao_PhieuDat dao_PhieuDatPhong = new Dao_PhieuDat();
    private Object loaiPhong_dao;

    public Form_ChuyenPhong() {
        initComponents();
        themDuLieuPhongTrongVaoCBB();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblMaPhongHienTai = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTitleMaHD = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        lblTitleMaPDP = new javax.swing.JLabel();
        lblMaPDP = new javax.swing.JLabel();
        cbbChuyenPhong = new javax.swing.JComboBox<>();
        btnChuyenPhong = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnLamMoi1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 153, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(121, 87, 142));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/chuyenPhong.png"))); // NOI18N
        jLabel1.setText("Chuyển phòng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập phòng mà bạn muốn chuyển", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(124, 36, 207))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Bạn muốn chuyển từ phòng:");

        lblMaPhongHienTai.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("sang phòng:");

        lblTitleMaHD.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTitleMaHD.setText("Mã hóa đơn:");

        lblMaHD.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Trạng thái phòng:");

        lblTrangThai.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        lblTitleMaPDP.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTitleMaPDP.setText("Mã phiếu đặt phòng:");

        lblMaPDP.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(lblTitleMaPDP)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblMaPDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(lblTitleMaHD)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaPhongHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbChuyenPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitleMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaPDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lblTitleMaPDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 22, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaPhongHienTai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(cbbChuyenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        btnChuyenPhong.setBackground(new java.awt.Color(177, 100, 252));
        btnChuyenPhong.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnChuyenPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/chuyenPhong.png"))); // NOI18N
        btnChuyenPhong.setText("Chuyển");
        btnChuyenPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenPhongActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(177, 100, 252));
        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/logout.png"))); // NOI18N
        btnLamMoi.setText("Thoát");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnLamMoi1.setBackground(new java.awt.Color(177, 100, 252));
        btnLamMoi1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLamMoi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/reset.png"))); // NOI18N
        btnLamMoi1.setText("Làm mới");
        btnLamMoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoi1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnChuyenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLamMoi1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChuyenPhong)
                    .addComponent(btnLamMoi1)
                    .addComponent(btnLamMoi))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnChuyenPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenPhongActionPerformed
        String maP = lblMaPhongHienTai.getText().trim();
        Phong phong = dao_Phong.timPhongTheoMa(maP);
        String tt = phong.getTrangThaiPhong().getMaTrangThaiPhong();
        if (tt.equals("SD")) {
            String maPhongHienTai = lblMaPhongHienTai.getText().trim();
            String maPhongMoi = cbbChuyenPhong.getSelectedItem().toString();
            String maHD = lblMaHD.getText().trim();
            dao_ChiTietHoaDon.capNhatTrangThaiPhongKhiNhanChuyenPhong(maPhongMoi, maHD);
            dao_Phong.capNhatTrangThaiPhongKhiChuyenThanhPT(maPhongHienTai);
            dao_Phong.capNhatTrangThaiPhongKhiChuyenThanhSD(maPhongMoi);
            Form_DatPhongHat.loadDSKhiThanhToan();
            JOptionPane.showMessageDialog(rootPane, "Chuyển phòng thành công!");          
            this.dispose();
        } else if (tt.equals("PC")) {
            String maPhongHienTai = lblMaPhongHienTai.getText().trim();
            String maPhongMoi = cbbChuyenPhong.getSelectedItem().toString();
            String maPDP = lblMaPDP.getText().trim();
            dao_Phong.capNhatTrangThaiPhongKhiChuyenThanhPT(maPhongHienTai);
            dao_Phong.capNhatTrangThaiPhongKhiChuyenThanhPC(maPhongMoi);
            dao_PhieuDatPhong.capNhatTrangThaiPhongKhiNhanChuyenPhong(maPhongMoi, maPDP);
            
            Form_DatPhongHat.loadDSKhiThanhToan();
            JOptionPane.showMessageDialog(rootPane, "Chuyển phòng thành công!");
            this.dispose();
        }
    }//GEN-LAST:event_btnChuyenPhongActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnLamMoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoi1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_ChuyenPhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenPhong;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLamMoi1;
    private javax.swing.JComboBox<String> cbbChuyenPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblMaPDP;
    private javax.swing.JLabel lblMaPhongHienTai;
    private javax.swing.JLabel lblTitleMaHD;
    private javax.swing.JLabel lblTitleMaPDP;
    private javax.swing.JLabel lblTrangThai;
    // End of variables declaration//GEN-END:variables

    public void setEditDataChuyenPhongSD(String maHoaDon, String maPhong, String trangThai) {
        lblMaPDP.setVisible(false);
        lblTitleMaPDP.setVisible(false);
        lblMaHD.setText(maHoaDon);
        lblMaPhongHienTai.setText(maPhong);
        lblTrangThai.setText(trangThai);
    }

    public void setEditDataChuyenPhongPC(String maPDP, String maPhong, String trangThai) {
        lblMaHD.setVisible(false);
        lblTitleMaHD.setVisible(false);
        lblMaPDP.setText(maPDP);
        lblMaPhongHienTai.setText(maPhong);
        lblTrangThai.setText(trangThai);
    }
    
    private void themDuLieuPhongTrongVaoCBB() {
        ArrayList<Phong> listTTP = dao_Phong.getDanhSachPhongTrong();
        for (Phong phongTrong : listTTP) {
            cbbChuyenPhong.addItem(phongTrong.getMaPhong());  
	}
    }
    
}
