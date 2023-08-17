
package gui.form;

import dao.NhanVienDao;
import dao.Dao_ThongKe;
import entity.HoaDon;
import entity.LoaiNhanVien;
import entity.NhanVien;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THANHTU
 */
public class Form_QuanLyThongKe_NhanVien extends javax.swing.JPanel {
   private  Dao_ThongKe datk;
     private NhanVien nv;
    private NhanVienDao nvdao;
    private DefaultTableModel modalNhanVien;
    public Form_QuanLyThongKe_NhanVien() {
        initComponents();
        loaddata();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jDateChooser1ngaythangnamNhanVien = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTimsdt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1NhanVienThongKe = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jTextField2TimTenNhanVien = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7tongSoHoaDon = new javax.swing.JLabel();
        jLabel8TongDoanhThuTheoNhanVien = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ShowDanhSachNhanVien = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thống kê số hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Chọn ngày/tháng/năm: ");

        jButton1.setText("Thống Kê Nhân Viên");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Tìm kiếm nhân viên");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Số điện thoại   :");

        jTextFieldTimsdt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTimsdtKeyReleased(evt);
            }
        });

        jTable1NhanVienThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Họ Tên Nhân Viên", "SĐT"
            }
        ));
        jTable1NhanVienThongKe.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable1NhanVienThongKeComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1NhanVienThongKe);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Tên nhân viên  :");

        jTextField2TimTenNhanVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2TimTenNhanVienKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1ngaythangnamNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldTimsdt)
                                .addGap(10, 10, 10)))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(131, 131, 131))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2TimTenNhanVien)
                        .addGap(16, 16, 16))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1ngaythangnamNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTimsdt, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField2TimTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thống kê doanh thu theo nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Tổng số hóa đơn     :");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Tổng Doanh Thu Trong Ngày :");

        jLabel7tongSoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7tongSoHoaDon.setText("*********");

        jLabel8TongDoanhThuTheoNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8TongDoanhThuTheoNhanVien.setText("*********");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7tongSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8TongDoanhThuTheoNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7tongSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8TongDoanhThuTheoNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(jLabel6))
                .addGap(19, 19, 19))
        );

        ShowDanhSachNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Mã Hóa Đơn", "Tên Nhân Viên", "Số Điện Thoại", "Địa Chỉ", "Tổng Tiền Hóa Đơn"
            }
        ));
        jScrollPane2.setViewportView(ShowDanhSachNhanVien);

        jButton2.setText("Xuất EXCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 174, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if(jDateChooser1ngaythangnamNhanVien.getDate()==null){
            JOptionPane.showMessageDialog(null, "Chọn ngày tháng muốn thống kê");
            return;
        }
        int row=jTable1NhanVienThongKe.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(null, "Chọn nhân viên cần thống kê");
            return;
        }
        else{
            String maNV = jTable1NhanVienThongKe.getValueAt(row, 0).toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateDoanhThu=sdf.format(jDateChooser1ngaythangnamNhanVien.getDate());
            modalNhanVien=(DefaultTableModel) ShowDanhSachNhanVien.getModel();
            String[] dataThang=dateDoanhThu.toString().split("-");
            datk=new Dao_ThongKe();
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            ArrayList<HoaDon> DShd;
            try {
                DShd = (ArrayList<HoaDon>) datk.LocDanhSachHoaDonNgayThangNamNhanVien(dataThang[0].toString(),dataThang[1].toString(),dataThang[2].toString(),maNV);
                 double tongHoaDon=0;
                 double tongTien=0;
                if(DShd.size()==0){
                 JOptionPane.showMessageDialog(null, "Nhân viên này không có hóa đơn ");
                 return;
             }
                        
                DefaultTableModel dm = (DefaultTableModel) ShowDanhSachNhanVien.getModel();
                dm.getDataVector().removeAllElements();
                for(HoaDon hd: DShd){
                    modalNhanVien.addRow(new Object[]{hd.getNhanVien().getMaNhanVien(),hd.getMaHoaDon(),hd.getNhanVien().getTenNhanVien(),hd.getNhanVien().getSoDienThoai(),hd.getNhanVien().getDiaChi(),String.valueOf(formatter.format(hd.getTongTien())+" "+"VNĐ") });               
                    tongTien+=hd.getTongTien();
               }
               
               if(DShd.size()==0){
                   jLabel7tongSoHoaDon.setText("********");
                   jTable1NhanVienThongKe.removeAll();
               }
               else{
                 
                   jLabel7tongSoHoaDon.setText( formatter.format(DShd.size()));
               }
               
               if(tongTien==0){
                   
                   
                   jLabel8TongDoanhThuTheoNhanVien.setText( "*******");
                   
               }
               else{
                   
                   
                    jLabel8TongDoanhThuTheoNhanVien.setText( formatter.format(tongTien)+"VNĐ");
               }
               
               
            } catch (SQLException ex) {
                Logger.getLogger(Form_QuanLyThongKe_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void loaddata(){
        nvdao=new NhanVienDao();
        modalNhanVien=(DefaultTableModel) jTable1NhanVienThongKe.getModel();
        ArrayList<NhanVien> dsNhanVien=nvdao.getAllNhanVien();
        for(NhanVien nv:dsNhanVien){        
            modalNhanVien.addRow(new Object[]{nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getSoDienThoai()});    
        }

        
  
    }
    
    private void jTable1NhanVienThongKeComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1NhanVienThongKeComponentShown
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "haha ");
    }//GEN-LAST:event_jTable1NhanVienThongKeComponentShown

    private void jTextFieldTimsdtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimsdtKeyReleased
        // TODO add your handling code here:
        timNhanVien();
    }//GEN-LAST:event_jTextFieldTimsdtKeyReleased

    private void jTextField2TimTenNhanVienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2TimTenNhanVienKeyReleased
        // TODO add your handling code here:
       
        timNhanVien();
    }//GEN-LAST:event_jTextField2TimTenNhanVienKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          Form_ThongKe_QL ttQl=new Form_ThongKe_QL();
          ttQl.xuatExcellAllTable(ShowDanhSachNhanVien);
           // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
  private void timNhanVien(){
                nvdao=new NhanVienDao();
	        ArrayList<NhanVien> listNV = (ArrayList<NhanVien>) nvdao.timNVTheoTenVaSdt(jTextField2TimTenNhanVien.getText(), jTextFieldTimsdt.getText());
		modalNhanVien=(DefaultTableModel) jTable1NhanVienThongKe.getModel();
                modalNhanVien.getDataVector().removeAllElements();
		modalNhanVien.fireTableDataChanged();
		if (listNV.size() == 0) {
			return;
		}
		new Thread(() -> {
			for (NhanVien t : listNV) {
				modalNhanVien.addRow(new Object[] { t.getMaNhanVien(),  t.getTenNhanVien(),t.getSoDienThoai()});
			}
		}).start();
	

  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ShowDanhSachNhanVien;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1ngaythangnamNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel7tongSoHoaDon;
    private javax.swing.JLabel jLabel8TongDoanhThuTheoNhanVien;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1NhanVienThongKe;
    private javax.swing.JTextField jTextField2TimTenNhanVien;
    private javax.swing.JTextField jTextFieldTimsdt;
    // End of variables declaration//GEN-END:variables
}
