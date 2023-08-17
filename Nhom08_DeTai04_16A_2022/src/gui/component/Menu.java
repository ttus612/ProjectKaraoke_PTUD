
package gui.component;

import dao.NhanVienDao;
import dao.Dao_TaiKhoan;
import entity.LoaiNhanVien;
import entity.NhanVien;
import entity.TaiKhoan;
import gui.event.EventMenuSelected;
import gui.event.EventMenu;
import gui.event.EventMenuCallBack;
import gui.main.Form_Login_v2;
import gui.main.Main;
import gui.model.Model_Menu;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author THANHTU
 */
public class Menu extends javax.swing.JPanel {

    private final String manv;
    
    public void addEventMenu(EventMenu event){
        this.event = event;
    }

    private NhanVienDao dao_nv = new NhanVienDao();
    private Dao_TaiKhoan dao_tk = new Dao_TaiKhoan();
    private int selectedIndex = -1;
    private final Timer timer;
    private boolean toUp;
    private int menuTarget;
    int menuY;
    private int speed = 20;
    private EventMenuCallBack callBack;
    private EventMenu event;
    
    public Menu(String maNV) {
        initComponents();
        setOpaque(false);
        manv = maNV;
        NhanVien nv = dao_nv.timNhanVienTheoMa(maNV);
        String tenNhanVien = nv.getTenNhanVien();
        LoaiNhanVien lnv = dao_nv.timLoaiNhanVienTheoMaNV(maNV);
        String maLoaiNV = lnv.getMaLoaiNhanVien();
        listMenu.setOpaque(false);
        listMenu.addEventSelectedMenu(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, EventMenuCallBack callBack) {
                if (index != selectedIndex) {
                    Menu.this.callBack = callBack;
                    toUp = selectedIndex > index;
                    if (selectedIndex == -1) {
                        speed = 15;
                    }else{
                        speed = selectedIndex - index;
                        if (speed < 0) {
                            speed *= -2;
                        }
                    }
                    speed ++;
                    selectedIndex = index;
                    menuTarget = selectedIndex*35+listMenu.getY();
                    if (!timer.isRunning()) {
                        timer.start();
                    }
                }
                if (index == 26) {
                    repaint();
                    timer.stop();
                    callBack.call(selectedIndex);
                    if (event != null) {
                        event.menuIndexChange(selectedIndex);
                    }
                }
            }
        });
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (toUp) {
                    if (menuY <= menuTarget - 3) {
                        menuY = menuTarget;
                        repaint();
                        timer.stop();
                        callBack.call(selectedIndex);
                        if (event != null) {
                            event.menuIndexChange(selectedIndex);
                        }
                    }else{
                        menuY -= speed;
                        repaint(); 
                    }
                }else{
                    if (menuY > menuTarget + 3) {
                        menuY = menuTarget; 
                        repaint();
                        timer.stop();
                        callBack.call(selectedIndex);
                        if (event != null) {
                            event.menuIndexChange(selectedIndex);
                        }
                    }else{
                        menuY += speed;
                        repaint();
                    }
                }
            }
        });
        if (maLoaiNV.equals("LNV01")) {            
            initData();
        }else{
            initData2();  
        }
        
    }
    private void initData(){
        listMenu.addItem(new Model_Menu("trangChu", "Trang chủ", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("phongHat", "Phòng", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("datPhong_menu", "Đặt phòng", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("khachHang", "Khách hàng", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("dichVu", "Dịch vụ", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("sanPham", "Sản phẩm", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("thongKe", "Thống kê", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("hoaDon", "Hóa đơn", Model_Menu.MenuType.MENU));
            
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "Admin", Model_Menu.MenuType.ADMIN_TITLE));
        listMenu.addItem(new Model_Menu("nhanVien", "Nhân viên", Model_Menu.MenuType.ADMIN));
        listMenu.addItem(new Model_Menu("thongKe", "Thống kê", Model_Menu.MenuType.ADMIN));
        
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));        
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("logout", "Đăng xuất", Model_Menu.MenuType.LOGOUT));
 
    }
    
    private void initData2(){
        listMenu.addItem(new Model_Menu("trangChu", "Trang chủ", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("phongHat", "Phòng", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("datPhong_menu", "Đặt phòng", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("khachHang", "Khách hàng", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("dichVu", "Dịch vụ", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("sanPham", "Sản phẩm", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("thongKe", "Thống kê", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("hoaDon", "Hóa đơn", Model_Menu.MenuType.MENU));
            
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));        
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("logout", "Đăng xuất", Model_Menu.MenuType.LOGOUT));
 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
        listMenu = new gui.swing.ListMenu<>();
        jPanel2 = new javax.swing.JPanel();

        jPanel1.setOpaque(false);

        lblTieuDe.setFont(new java.awt.Font("VNI-Fato", 1, 24)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(255, 255, 255));
        lblTieuDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/logo.png"))); // NOI18N
        lblTieuDe.setText("Karaoke CGV");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTieuDe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTieuDe)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        listMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMenuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(listMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMenuMouseClicked
 
    }//GEN-LAST:event_listMenuMouseClicked

    @Override
      protected void paintComponent(Graphics grphcs) {
          Graphics2D g2 =(Graphics2D)grphcs;
          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          GradientPaint g = new GradientPaint(0, 0, Color.decode("#7303c0"), 0, getHeight(), Color.decode("#ffdeff9"));
          g2.setPaint(g);
          g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);//bo góc
          if (selectedIndex >= 0) {
            int menuX = 10;
            int height = 35;
            int width = getWidth();   
            g2.setColor(new Color(255,255,255));
            if (selectedIndex <=7) {            
                g2.fillRoundRect(menuX, menuY, width, height, 35, 35);
                Path2D.Float f = new Path2D.Float();
                f.moveTo(width -30, menuY);
                f.curveTo(width - 10, menuY, width, menuY, width, menuY-30);
                f.lineTo(width, menuY + height + 30);
                f.curveTo(width, menuY+height, width-10, menuY+ height, width-30, menuY+height);
                g2.fill(f); 
            }else if(selectedIndex == 26){
                   g2.fillRoundRect(menuX , menuY, width, height, 35, 35);
            }
            else{
                g2.fillRoundRect(menuX , menuY-15, width, height, 35, 35);
            }
        
        }
          super.paintComponent(grphcs); 
      }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTieuDe;
    private gui.swing.ListMenu<String> listMenu;
    // End of variables declaration//GEN-END:variables

   

}
