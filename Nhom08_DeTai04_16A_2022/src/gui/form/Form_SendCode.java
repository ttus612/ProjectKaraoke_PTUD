package gui.form;

import gui.main.Form_Login_v2;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Form_SendCode extends javax.swing.JFrame {

    private Random rand;
    private int randomCode;

    public Form_SendCode() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSend = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        btnVertify = new javax.swing.JButton();
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
        jLabel6.setText("Email");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 40, -1));

        txtEmail.setText("phoaianvlogs@gmail.com");
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 390, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/Avatar_Container.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        btnSend.setBackground(new java.awt.Color(177, 100, 252));
        btnSend.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSend.setText("Gửi");
        btnSend.setBorder(null);
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        jPanel2.add(btnSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 120, 40));

        jLabel7.setForeground(new java.awt.Color(73, 80, 87));
        jLabel7.setText("Nhập code");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));
        jPanel2.add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 390, 40));

        btnExit.setBackground(new java.awt.Color(177, 100, 252));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnExit.setText("Thoát");
        btnExit.setBorder(null);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel2.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 120, 40));

        btnVertify.setBackground(new java.awt.Color(177, 100, 252));
        btnVertify.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVertify.setText("Xác nhận");
        btnVertify.setBorder(null);
        btnVertify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVertifyActionPerformed(evt);
            }
        });
        jPanel2.add(btnVertify, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, 120, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/rsz_header_login.jpg"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, -1));

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

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        if (validateEmail()) {
            String to = txtEmail.getText().trim();
            rand = new Random();
            randomCode = rand.nextInt(999999);

            String from = "phoaianvlogs@gmail.com";
            String messageCode = "Karaoke CGV: Mã của bạn là " + randomCode;

            //Get system properties
            Properties properties = System.getProperties();

            //Setup mail server
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.auth", "true");

            Session session = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("phoaianvlogs@gmail.com", "pogpkdjbakvpmbzh");
                }
            });

            //Used to debug SMTP issues
            session.setDebug(true);

            try {
                MimeMessage message = new MimeMessage(session);

                message.setFrom(new InternetAddress(from));

                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                message.setSubject("Karaoke CGV");

                message.setText(messageCode);

                Transport.send(message);

                JOptionPane.showMessageDialog(this, "Gửi email thành công, Vui lòng kiểm tra email của bạn để nhận mã Code!");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        Form_Login_v2 loginV2 = new Form_Login_v2();
        loginV2.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnVertifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVertifyActionPerformed
        if (validateCode()) {
            if (Integer.valueOf(txtCode.getText().trim()) == randomCode) {
                Form_ForgotPassword forgotPassword = new Form_ForgotPassword(txtEmail.getText());
                forgotPassword.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Code không chính xác, Vui lòng thử lại!");
            }
        }
    }//GEN-LAST:event_btnVertifyActionPerformed

    private boolean validateEmail() {
        String email = txtEmail.getText();

        if (!(email != null && !email.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Email không được rỗng");
            txtEmail.requestFocus();
            return false;
        }
        if (!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng!");
            txtEmail.selectAll();
            txtEmail.requestFocus();
            return false;
        }
        return true;
    }

    private boolean validateCode() {
        String code = txtCode.getText();

        if (!(code != null && !code.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Code không được rỗng");
            txtCode.requestFocus();
            return false;
        }
        if (!code.matches("^[0-9]{1,6}$")) {
            JOptionPane.showMessageDialog(this, "Code phải có 6 số");
            txtCode.selectAll();
            txtCode.requestFocus();
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnVertify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCode;
    public javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
