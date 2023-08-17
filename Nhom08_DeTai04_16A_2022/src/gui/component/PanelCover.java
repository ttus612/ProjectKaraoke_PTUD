
package gui.component;

import gui.swing.ButtonOutLine;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelCover extends javax.swing.JPanel {

    private final DecimalFormat df = new DecimalFormat("##0.###");
    private ActionListener event;
    private MigLayout layout;
    private JLabel title, des, des1;
    private ButtonOutLine btn;
    private boolean islogin;
    
    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]25[]10[]25[]push");
        setLayout(layout);
        init();
    }
    
    private void init() {
        title = new JLabel("Karaoke CGV");
        title.setFont(new Font("sansserif", 1, 30));
        title.setForeground(new Color(245,245,245));
        add(title);
        des = new JLabel("Hãy giữ kết nối với chúng tôi");
        des.setForeground(new Color(245,245,245));
        add(des);
        des1 = new JLabel("Đăng nhập bằng thông tin cá nhân của bạn");
        des1.setForeground(new Color(245,245,245));
        add(des1);
        btn = new ButtonOutLine();
        btn.setBackground(new Color(255,255,255));
        btn.setForeground(new Color(255,255,255));
        btn.setText("Quên mật khẩu ?");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.actionPerformed(e);
            }
        });
        add(btn, "w 60%, h 40");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        GradientPaint gra = new GradientPaint(0, 0, new Color(64, 2, 123), 0, getHeight(), new Color(228, 48, 217));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    public void addEvent(ActionListener event) {
        this.event = event;
    }
    
    public void resetLeft(double v) {
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(des, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(des1, "pad 0 -" + v + "% 0 0");
    }

    public void resetRight(double v) {
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(des, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(des1, "pad 0 -" + v + "% 0 0");
    }

    public void loginLeft(double v) {
        v = Double.valueOf(df.format(v));
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(des, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(des1, "pad 0 " + v + "% 0 " + v + "%");
    }

    public void loginRight(double v) {
        v = Double.valueOf(df.format(v));
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(des, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(des1, "pad 0 " + v + "% 0 " + v + "%");
    }
    
    public void login(boolean login) {
        if(this.islogin != login) {
            if(login) {
                title.setText("Karaoke CGV");
                des.setText("Chào mừng!");
                des1.setText("Hãy cùng nhau xây dựng những điều tuyệt vời");
                btn.setText("Đăng Nhập");
            } else {
                title.setText("Karaoke CGV");
                des.setText("Hãy giữ kết nối với chúng tôi");
                des1.setText("Đăng nhập bằng thông tin cá nhân của bạn");
                btn.setText("Quên Mật Khẩu ?");
            }
        }
        this.islogin = login;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
