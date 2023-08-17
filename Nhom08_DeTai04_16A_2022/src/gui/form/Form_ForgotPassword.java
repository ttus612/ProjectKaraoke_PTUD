package gui.form;

import dao.Dao_TaiKhoan;
import gui.main.Form_Login_v2;
import javax.swing.JOptionPane;

public class Form_ForgotPassword extends javax.swing.JFrame {

    private boolean showMKNew = true;
    private boolean showMKConfirm = true;
    private Dao_TaiKhoan taiKhoan_dao = new Dao_TaiKhoan();
    private String email;

    public Form_ForgotPassword() {
        initComponents();
    }

    public Form_ForgotPassword(String email) {
        this.email = email;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        show_MatKhau1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        show_MatKhau = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(73, 80, 87));
        jLabel6.setText("Mật khẩu mới");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        jPanel2.add(txtNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 340, 40));

        show_MatKhau1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        show_MatKhau1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/show_Matkhau.png"))); // NOI18N
        show_MatKhau1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_MatKhau1ActionPerformed(evt);
            }
        });
        jPanel2.add(show_MatKhau1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 50, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/Avatar_Container.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        jLabel7.setForeground(new java.awt.Color(73, 80, 87));
        jLabel7.setText("Xác nhận mật khẩu mới");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));
        jPanel2.add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 340, 40));

        show_MatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        show_MatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/show_Matkhau.png"))); // NOI18N
        show_MatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_MatKhauActionPerformed(evt);
            }
        });
        jPanel2.add(show_MatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 50, 40));

        btnOk.setBackground(new java.awt.Color(177, 100, 252));
        btnOk.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOk.setText("Đồng ý");
        btnOk.setBorder(null);
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        jPanel2.add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 120, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/rsz_header_login.jpg"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/Card_Content.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 450, 300));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 450, 410));

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

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if (validatePassword()) {
            try {
                String password = String.valueOf(txtNewPassword.getPassword());
                taiKhoan_dao.forgotPassword(email, password);
                JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
                Form_Login_v2 loginV2 = new Form_Login_v2();
                loginV2.setVisible(true);
                this.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void show_MatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_MatKhauActionPerformed
                if (showMKConfirm == true) {
            txtConfirmPassword.setEchoChar((char) 0);
            showMKConfirm = false;
        } else {
            txtConfirmPassword.setEchoChar('*');
            showMKConfirm = true;
        }
    }//GEN-LAST:event_show_MatKhauActionPerformed

    private void show_MatKhau1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_MatKhau1ActionPerformed
        if (showMKNew == true) {
            txtNewPassword.setEchoChar((char) 0);
            showMKNew = false;
        } else {
            txtNewPassword.setEchoChar('*');
            showMKNew = true;
        }
    }//GEN-LAST:event_show_MatKhau1ActionPerformed

    private boolean validatePassword() {
        String password = String.valueOf(txtNewPassword.getPassword());

        if (!(password != null && !password.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Mật khẩu mới không được rỗng");
            txtNewPassword.requestFocus();
            return false;
        }
        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")) {
            JOptionPane.showMessageDialog(this, "1.Mật khẩu phải chứa ít nhất một chữ số [0-9].\n"
                    + "2.Mật khẩu phải chứa ít nhất một ký tự Latinh viết thường [az].\n"
                    + "3.Mật khẩu phải chứa ít nhất một ký tự Latinh viết hoa [AZ].\n"
                    + "4.Mật khẩu phải chứa ít nhất một ký tự đặc biệt như ! @ # & ( ).\n"
                    + "5.Mật khẩu phải có độ dài ít nhất 8 ký tự và tối đa 20 ký tự.");
            txtNewPassword.selectAll();
            txtNewPassword.requestFocus();
            return false;
        }
        if (!String.valueOf(txtNewPassword.getPassword()).equals(String.valueOf(txtConfirmPassword.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Mật khẩu mới và xác nhận mật khẩu không khớp!");
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton show_MatKhau;
    private javax.swing.JButton show_MatKhau1;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JPasswordField txtNewPassword;
    // End of variables declaration//GEN-END:variables
}
