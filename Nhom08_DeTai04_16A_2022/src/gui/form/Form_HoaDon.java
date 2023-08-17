
package gui.form;

import dao.NhanVienDao;
import dao.Dao_HoaDon;
import entity.HoaDon;
import entity.LoaiNhanVien;
import entity.NhanVien;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THANHTU
 */
public class Form_HoaDon extends javax.swing.JPanel {
    private Dao_HoaDon daohd;
    private DefaultTableModel modalHoaDon;
    public Form_HoaDon() {
        initComponents();
          docDuLieu();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        maKhaChHangTexField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4SDT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextmaHd = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1HoaDon = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 153, 255));

        jLabel2.setBackground(new java.awt.Color(121, 87, 142));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(121, 87, 142));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/order.png"))); // NOI18N
        jLabel2.setText("Quản lí hóa đơn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, 0))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Mã Khách Hàng:");

        maKhaChHangTexField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maKhaChHangTexFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Mã Hóa Đơn  :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Ngày lập:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Số điện thoại KH:");

        jTextField4SDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4SDTKeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(177, 100, 252));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/search.png"))); // NOI18N
        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(177, 100, 252));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/reset.png"))); // NOI18N
        jButton2.setText("Làm mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextmaHd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextmaHdActionPerformed(evt);
            }
        });
        jTextmaHd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextmaHdKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4SDT, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextmaHd, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                        .addGap(5, 5, 5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maKhaChHangTexField)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextmaHd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(maKhaChHangTexField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField4SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        jTable1HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Tên Khách Hàng", "Số Điện Thoại Khách Hàng", "Mã Khách Hàng", "Tên Nhân Viên", "Ngày Lập ", "Mã Nhân Viên", "Giờ Nhận Phòng", "Giờ Kết Thúc", "Tiền Khách Trả", "Tổng Tiền"
            }
        ));
        jScrollPane1.setViewportView(jTable1HoaDon);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Hiển thị tất cả hóa đơn");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(71, 71, 71))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1322, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

      jTextmaHd.setText("");
      maKhaChHangTexField.setText("");
      jTextField4SDT.setText("");
      jDateChooser1.setDate(null);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel dm = (DefaultTableModel) jTable1HoaDon.getModel();
        dm.getDataVector().removeAllElements();
        docDuLieu();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void maKhaChHangTexFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maKhaChHangTexFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maKhaChHangTexFieldActionPerformed

    private void jTextmaHdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextmaHdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextmaHdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        daohd=new Dao_HoaDon();
        modalHoaDon=(DefaultTableModel) jTable1HoaDon.getModel();
        if(jTextmaHd.getText().toString().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Mã Hóa Đơn không được để trông ");
         return;
        }
        
        if(maKhaChHangTexField.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Mã khách hàng  không được để trông ");
           return;
        }
        
         if(jTextField4SDT.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "số điện thoại khách hàng  không được để trống ");
         return;
        }
          
        if(jDateChooser1.getDate()==null){
         JOptionPane.showMessageDialog(null, "Chọn ngày tháng muốn thống kê");
         return;
        }
       
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                 String dateDoanhThu=sdf.format(jDateChooser1.getDate());
                 String[] ngayKhachHang=dateDoanhThu.toString().split("-");
                 DecimalFormat formatter = new DecimalFormat("###,###,###");
                 ArrayList<HoaDon> dsHoaDon=(ArrayList<HoaDon>) daohd.getAllHoaDonTheoMakhTenKhachSdtNgayLap(maKhaChHangTexField.getText().toString(),jTextmaHd.getText().toString(),jTextField4SDT.getText().toString(),ngayKhachHang[2].toString(),ngayKhachHang[1].toString(),ngayKhachHang[0].toString());
                  
            if (dsHoaDon.size() == 0) {
			JOptionPane.showMessageDialog(this, "Không có nhân viên này");
			return;
		}
            else{
            modalHoaDon.getDataVector().removeAllElements();
            for(HoaDon hd:dsHoaDon){
                 modalHoaDon.addRow(new Object[]{hd.getMaHoaDon(),hd.getKhachHang().getHoTenKhachHang(),hd.getKhachHang().getSoDienThoai(),hd.getKhachHang().getMaKhachHang(),hd.getNhanVien().getTenNhanVien(),hd.getNgayLap1(),hd.getNhanVien().getMaNhanVien(),hd.getGioNhanPhong(),hd.getGioKetThuc(),String.valueOf(formatter.format(hd.getTienKhachTra())+" "+"VNĐ"),String.valueOf(formatter.format(hd.getTongTien())+ " " + "VNĐ")});    
             }
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4SDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4SDTKeyReleased
        // TODO add your handling code here:
        timHoaDon();
    }//GEN-LAST:event_jTextField4SDTKeyReleased

    private void jTextmaHdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextmaHdKeyReleased
        timHoaDon();// TODO add your handling code here:
    }//GEN-LAST:event_jTextmaHdKeyReleased
 private void timHoaDon(){
                daohd=new Dao_HoaDon();
	        ArrayList<HoaDon> listHoaDon = (ArrayList<HoaDon>) daohd.timHdTheoTenVaSdt(jTextmaHd.getText().toString(),jTextField4SDT.getText().toString());
		   modalHoaDon=(DefaultTableModel) jTable1HoaDon.getModel();
                modalHoaDon.getDataVector().removeAllElements();
                DecimalFormat formatter = new DecimalFormat("###,###,###");
		modalHoaDon.fireTableDataChanged();
		if (listHoaDon.size() == 0) {
			return;
		}
		new Thread(() -> {
			for (HoaDon hd : listHoaDon) {
				     modalHoaDon.addRow(new Object[]{hd.getMaHoaDon(),hd.getKhachHang().getHoTenKhachHang(),hd.getKhachHang().getSoDienThoai(),hd.getKhachHang().getMaKhachHang(),hd.getNhanVien().getTenNhanVien(),hd.getNgayLap1(),hd.getNhanVien().getMaNhanVien(),hd.getGioNhanPhong(),hd.getGioKetThuc(),String.valueOf(formatter.format(hd.getTienKhachTra())+" "+"VNĐ"),String.valueOf(formatter.format(hd.getTongTien())+ " " + "VNĐ")});    
			}
		}).start();
	

  }
    
  private void docDuLieu(){
        daohd=new Dao_HoaDon();
        modalHoaDon=(DefaultTableModel) jTable1HoaDon.getModel();
        ArrayList<HoaDon> dsHoaDon=daohd.getAllHoaDon();
        DecimalFormat formatter = new DecimalFormat("###,###,###");
               
        for(HoaDon hd:dsHoaDon){        
            modalHoaDon.addRow(new Object[]{hd.getMaHoaDon(),hd.getKhachHang().getHoTenKhachHang(),hd.getKhachHang().getSoDienThoai(),hd.getKhachHang().getMaKhachHang(),hd.getNhanVien().getTenNhanVien(),hd.getNgayLap1(),hd.getNhanVien().getMaNhanVien(),hd.getGioNhanPhong(),hd.getGioKetThuc(),String.valueOf(formatter.format(hd.getTienKhachTra())+" "+"VNĐ"),String.valueOf(formatter.format(hd.getTongTien())+ " " + "VNĐ")});    
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1HoaDon;
    private javax.swing.JTextField jTextField4SDT;
    private javax.swing.JTextField jTextmaHd;
    private javax.swing.JTextField maKhaChHangTexField;
    // End of variables declaration//GEN-END:variables
}
