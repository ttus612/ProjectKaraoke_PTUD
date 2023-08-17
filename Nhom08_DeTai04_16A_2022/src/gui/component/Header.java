
package gui.component;


import dao.NhanVienDao;
import entity.LoaiNhanVien;
import entity.NhanVien;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author THANHTU
 */
public class Header extends javax.swing.JPanel {
        
    private NhanVienDao dao_nv = new NhanVienDao();
    private LocalDate now;
    private Date dNow;

    public Header(String maNV) {
        initComponents();
        setOpaque(false);
        NhanVien nv = dao_nv.timNhanVienTheoMa(maNV);
        String tenNhanVien = nv.getTenNhanVien();
        LoaiNhanVien lnv = dao_nv.timLoaiNhanVienTheoMaNV(maNV);
        String maLoaiNV = lnv.getMaLoaiNhanVien();
        if (maLoaiNV.equals("LNV01")) {
            lblRole.setText("Admin");
        }else{
            lblRole.setText("Nhân viên");
        }
        
        lblTen.setText(tenNhanVien);
        layNgayHienTai();
        new Thread(){
            public void run(){
                while(true){
                    Calendar ca = new GregorianCalendar();
                    int hour = ca.get(Calendar.HOUR);
                    int minute = ca.get(Calendar.MINUTE);
                    int second = ca.get(Calendar.SECOND);
                    int PM_AM = ca.get(Calendar.AM_PM);
                    String day_night;
                    if (PM_AM == 1) {
                        day_night = "PM";
                    }else{
                        day_night = "AM";
                    }
                    String time = hour+":"+minute+":"+second+" "+day_night;
                    lblThoiGianNow.setText(time);
                }   
            }
        }.start();
    }

    private void layNgayHienTai() {  
        now = LocalDate.now();
	int ngay = now.getDayOfMonth();
	int thang = now.getMonthValue();
	int nam = now.getYear();    		
//        dNow = new Date(nam-1900,thang-1,ngay);
        jLabel6.setText(ngay +"/"+ thang +"/"+ nam);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTitileThoiGian = new javax.swing.JLabel();
        lblThoiGianNow = new javax.swing.JLabel();

        setBackground(new java.awt.Color(222, 193, 246));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/menu.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/user.png"))); // NOI18N

        lblTen.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTen.setText("Võ Nguyễn Thanh Tú");

        lblRole.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        lblRole.setText("Admin");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Ngày/tháng/năm:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("06/12/2002");

        lblTitileThoiGian.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitileThoiGian.setText("Thời gian:");

        lblThoiGianNow.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblThoiGianNow.setText("06:12:00 PM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(68, 68, 68)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitileThoiGian)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblThoiGianNow)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblRole))
                    .addComponent(lblTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblTen, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTitileThoiGian)
                        .addComponent(lblThoiGianNow)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 =(Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15 , 15);
        g2.fillRect(0, 0, 25, getHeight());
        g2.fillRect(getWidth()-25, getHeight()-25, getWidth(), getHeight());
        super.paintComponent(g); 
    }
    
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblThoiGianNow;
    private javax.swing.JLabel lblTitileThoiGian;
    // End of variables declaration//GEN-END:variables
}
