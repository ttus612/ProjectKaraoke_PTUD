package gui.main;

import dao.NhanVienDao;
import dao.Dao_TaiKhoan;
import entity.NhanVien;
import entity.TaiKhoan;
import gui.component.Header;
import gui.form.Form_DatPhongHat;
import gui.form.Form_SendCode;
import gui.form.Form_ThemNhanhKhachHang;
import gui.main.Main;
import gui.model.ModelLogin;
import java.awt.Desktop;
import java.net.URL;
import javax.swing.JOptionPane;

public class Form_Login_v2 extends javax.swing.JFrame {

    private boolean showMK = true;
    private Dao_TaiKhoan daoTaiKhoan;
    public String maNhanVienThongKe;
    private NhanVienDao dao_nv = new NhanVienDao();

    public ModelLogin getDataLogin() {
        return dataLogin;
    }

    /**
     * Creates new form NewJFrame
     */
    public Form_Login_v2() {
        initComponents();
        this.setLocationRelativeTo(null);
        daoTaiKhoan = new Dao_TaiKhoan();
    }

    private ModelLogin dataLogin;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnHDSD = new javax.swing.JButton();
        btnForgotPassword = new javax.swing.JButton();
        show_MatKhau = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(73, 80, 87));
        jLabel6.setText("Mã nhân viên");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        txtUser.setText("NV078901");
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        jPanel2.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 390, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/Avatar_Container.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        btnLogin.setBackground(new java.awt.Color(177, 100, 252));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogin.setText("Đăng Nhập");
        btnLogin.setBorder(null);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 390, 40));

        jLabel7.setForeground(new java.awt.Color(73, 80, 87));
        jLabel7.setText("Mật khẩu");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/rsz_header_login.jpg"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/Lock.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 20, -1));

        btnHDSD.setForeground(new java.awt.Color(116, 120, 141));
        btnHDSD.setText("Hướng dẫn sử dụng");
        btnHDSD.setBorder(null);
        btnHDSD.setBorderPainted(false);
        btnHDSD.setContentAreaFilled(false);
        btnHDSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHDSDActionPerformed(evt);
            }
        });
        jPanel2.add(btnHDSD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 190, 20));

        btnForgotPassword.setForeground(new java.awt.Color(116, 120, 141));
        btnForgotPassword.setText("Quên Mật Khẩu");
        btnForgotPassword.setBorder(null);
        btnForgotPassword.setBorderPainted(false);
        btnForgotPassword.setContentAreaFilled(false);
        btnForgotPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForgotPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(btnForgotPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 190, 20));

        show_MatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        show_MatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/show_Matkhau.png"))); // NOI18N
        show_MatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_MatKhauActionPerformed(evt);
            }
        });
        jPanel2.add(show_MatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 50, 40));

        txtPass.setText("12345678");
        txtPass.setCaretPosition(0);
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        jPanel2.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 330, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/Card_Content.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 450, 380));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 450, 490));

        jPanel1.setBackground(new java.awt.Color(244, 243, 243));
        jPanel1.setForeground(new java.awt.Color(60, 63, 65));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/Ellipse 209.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 450, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/Union.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHDSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHDSDActionPerformed
        try {
            Desktop.getDesktop().browse(new URL("https://drive.google.com/file/d/1xzAU_Xi04_2-TGROXKyi7Wd8uJ5UEBEA/view?usp=share_link").toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnHDSDActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String maNV = txtUser.getText().trim();
        String pass = String.valueOf(txtPass.getPassword());
        dataLogin = new ModelLogin(maNV, pass);
        login();

    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void btnForgotPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForgotPasswordActionPerformed
        Form_SendCode sendCode = new Form_SendCode();
        sendCode.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnForgotPasswordActionPerformed

    private void show_MatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_MatKhauActionPerformed
        if (showMK == true) {
            txtPass.setEchoChar((char) 0);
            showMK = false;
        } else {
            txtPass.setEchoChar('*');
            showMK = true;
        }
    }//GEN-LAST:event_show_MatKhauActionPerformed

    private void login() {
        try {
            TaiKhoan user = daoTaiKhoan.login(dataLogin);

            if (user != null) {
                this.dispose();
                NhanVien nv = dao_nv.timNhanVienTheoMa(user.getMaNhanvien());
                Header h = new Header(user.getMaNhanvien());
                Form_DatPhongHat dp = new Form_DatPhongHat(user.getMaNhanvien());
                Form_ThemNhanhKhachHang themNhanhKH = new Form_ThemNhanhKhachHang(user.getMaNhanvien());
                Main.main(user);
                setVisible(false);

            } else {
                JOptionPane.showMessageDialog(this, "Mã nhân viên, mật khẩu không đúng");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi đăng nhập");
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Login_v2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnForgotPassword;
    private javax.swing.JButton btnHDSD;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton show_MatKhau;
    public javax.swing.JPasswordField txtPass;
    public javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

}
