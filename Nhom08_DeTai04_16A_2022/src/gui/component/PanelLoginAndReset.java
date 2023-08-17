package gui.component;

import gui.swing.Button;
import gui.swing.MyTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelLoginAndReset extends javax.swing.JLayeredPane {
    private Button btnLogin;

    public PanelLoginAndReset() {
        initComponents();
        initReset();
        initLogin();
        login.setVisible(true);
        reset.setVisible(false);
    }
    
    private void initLogin() {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]50[]10[]25[]10[]push"));
        JLabel label = new JLabel("Đăng Nhập");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        login.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/image/icon/user_1.png")));
        txtUser.setHint("Tài khoản");
        login.add(txtUser, "w 60%");
        MyTextField txtPass = new MyTextField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/image/icon/pass.png")));
        txtPass.setHint("Mật khẩu");
        login.add(txtPass, "w 60%");
        btnLogin = new Button();
        btnLogin.setBackground(new Color(7, 164, 121));
        btnLogin.setForeground(new Color(250, 250, 250));
        btnLogin.setText("Đăng Nhập");
        login.add(btnLogin, "w 40%, h 40");
    }
    
    private void initReset() {
        reset.setLayout(new MigLayout("wrap", "push[center]push", "push[]10[]50[]25[]25[]push"));
        JLabel label = new JLabel("Quên Mật Khẩu?");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        reset.add(label);
        JLabel label1 = new JLabel("<html><p style=\"text-align:center\">Nhập địa chỉ email tài khoản của bạn và chúng tôi sẽ gửi cho bạn một <br> liên kết để đặt lại mật khẩu của bạn.</p><html>");
        label1.setFont(new Font("sansserif", 1, 15));
        label1.setForeground(new Color(7, 164, 121));
        reset.add(label1);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/image/icon/mail.png")));
        txtUser.setHint("Email");
        reset.add(txtUser, "w 60%");
        Button resetPass = new Button();
        resetPass.setBackground(new Color(7, 164, 121));
        resetPass.setForeground(new Color(250, 250, 250));
        resetPass.setText("Yêu cầu đặt lại mật khẩu");
        reset.add(resetPass, "w 40%, h 40");
    }
    
    public void showReset(boolean show) {
        if(show) {
            login.setVisible(true);
            reset.setVisible(false);
        } else {
            login.setVisible(false);
            reset.setVisible(true);
        }
    }
    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {                                        
        
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        reset = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        reset.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout resetLayout = new javax.swing.GroupLayout(reset);
        reset.setLayout(resetLayout);
        resetLayout.setHorizontalGroup(
            resetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        resetLayout.setVerticalGroup(
            resetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(reset, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel reset;
    // End of variables declaration//GEN-END:variables
}
