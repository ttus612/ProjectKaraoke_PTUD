
package gui.main;

import connectDB.ConnectDB;
import entity.TaiKhoan;
import gui.event.EventMenu;
import gui.form.Form_DichVu;
import gui.form.Form_HoaDon;
import gui.form.Form_TrangChu;
import javax.swing.JComponent;
import gui.form.Form_DichVu;
import gui.form.Form_NhanVien;
import gui.form.Form_HoaDon;
import gui.form.Form_KhachHang;
import gui.form.Form_DatPhongHat;
import gui.form.Form_SanPham;
import gui.form.Form_DatPhongHat;
import gui.form.Form_PhongHat;
import gui.form.Form_ThongKe_NhanVien;
import gui.form.Form_ThongKe_QL;
import gui.form.Form_TrangChu;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author THANHTU
 */
public class Main extends javax.swing.JFrame {
    
    public final TaiKhoan nhanVien;
    private final String maNV;

    
    public Main(TaiKhoan nhanVien) {
        this.nhanVien = nhanVien;

        maNV = nhanVien.getMaNhanvien();
        try {
            ConnectDB.getIntance().connect();
	} catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);     
        init();
    }

    private void init(){
        menu2.addEventMenu(new EventMenu() {
            @Override
            public void menuIndexChange(int index) {
                if (index == 0){
                    setForm(new Form_TrangChu()); 
                }else if(index == 1){
                   setForm(new Form_PhongHat());
                }else if(index == 2){
                    setForm(new Form_DatPhongHat(maNV));
                }else if(index == 3){   
                    setForm(new Form_KhachHang());
                }else if(index == 4){       
                    setForm(new Form_DichVu());             
                }else if(index == 5){
                     setForm(new Form_SanPham());          
                }else if(index == 6){
                    setForm(new Form_ThongKe_NhanVien(nhanVien));
                }else if(index == 7){
                    setForm(new Form_HoaDon());
                }
                else if(index == 9){
                    setForm(new Form_NhanVien());
                }else if(index == 10){
                    setForm(new Form_NhanVien()); 
                }else if(index == 11){
                    setForm(new Form_ThongKe_QL()); 
                }else if(index == 26){
                    dispose();
                    Form_Login_v2 frm = new Form_Login_v2();                        
                    frm.setVisible(true);
                }
                
            }
        });
    }
        
    private void setForm(JComponent com){
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu2 = new gui.component.Menu(maNV);
        header1 = new gui.component.Header(maNV);
        mainPanel = new javax.swing.JPanel();
        form_TrangChu1 = new gui.form.Form_TrangChu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Karaoke CGV");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());
        mainPanel.add(form_TrangChu1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 1696, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, 1051, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(TaiKhoan tk) {
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main(tk).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.form.Form_TrangChu form_TrangChu1;
    private gui.component.Header header1;
    private javax.swing.JPanel mainPanel;
    private gui.component.Menu menu2;
    // End of variables declaration//GEN-END:variables
}
