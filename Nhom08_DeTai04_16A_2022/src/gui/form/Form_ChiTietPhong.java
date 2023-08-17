package gui.form;

import dao.Dao_ChiTietDichVu;
import dao.Dao_ChiTietHoaDon;
import dao.Dao_DichVu;
import dao.Dao_HoaDon;
import dao.Dao_KhachHang;
import dao.Dao_LoaiPhong;
import dao.Dao_PhieuDat;
import dao.Dao_Phong;
import dao.Dao_TrangThaiPhong;
import entity.ChiTietDichVu;
import entity.ChiTietHoaDon;
import entity.DichVu;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.PhieuDatPhong;
import entity.Phong;
import entity.TrangThaiPhong;
import gui.main.Main;
import gui.swing.JPanerRadiusBorder;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hp,THANHTU
 */
public class Form_ChiTietPhong extends javax.swing.JFrame {

    private Dao_LoaiPhong dao_LoaiPhong = new Dao_LoaiPhong();
    private Dao_TrangThaiPhong dao_TrangThaiPhong = new Dao_TrangThaiPhong();
    private Dao_ChiTietHoaDon dao_ChiTietHoaDon = new Dao_ChiTietHoaDon();
    private Dao_Phong dao_Phong = new Dao_Phong();
    private Dao_KhachHang dao_KhachHang = new Dao_KhachHang();
    private Dao_PhieuDat dao_PhieuDat = new Dao_PhieuDat();
    public static Dao_HoaDon dao_HoaDon = new Dao_HoaDon();
    public static Dao_Phong phong_dao = new Dao_Phong();
    public static Dao_ChiTietDichVu dao_ChiTietDichVu = new Dao_ChiTietDichVu();
    public static Dao_DichVu dao_DichVu = new Dao_DichVu();

    private Calendar timeNow2;
    private int nowHours;
    private int nowMinutes;
    private DecimalFormat dftxtGio;
    private DecimalFormat dftxtPhut;
    private DecimalFormat dftxtGiay;
    private LocalDate now;
    private java.sql.Date dNow;
    private int nowSecond;
    public static DefaultTableModel modelDichVuPhong;
    private ArrayList<ChiTietDichVu> listCTDichVu;
    private DefaultTableModel tableModel;
    private ArrayList<PhieuDatPhong> phieuDatPhongs;

    public Form_ChiTietPhong() {
        initComponents();
        ScaleImage();
        jPanelThoiGianKetThucKhiNhanTinhTien.setVisible(false);
        layNgayHienTai();

    }

    public void ScaleImage() {
        ImageIcon icon = new ImageIcon("D:\\HK1_22_23\\PTUD\\Nhom08_DeTai04_16A_2022\\src\\image\\img\\phongDangHoatDong.png");

        Image img = icon.getImage();
        Image imageScale = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(imageScale);
        lblImage.setIcon(imageIcon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        lblMaPhong = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblSucChua = new javax.swing.JLabel();
        lblLoaiPhong = new javax.swing.JLabel();
        lblGiaTheoGio = new javax.swing.JLabel();
        lblTrangThaiPhong = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblGioNhanPhong = new javax.swing.JLabel();
        lblTitileMaPhong = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVuPhong = new javax.swing.JTable();
        btnThemDV = new javax.swing.JButton();
        btnXoaDV = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnThayDoiSoLuong = new javax.swing.JButton();
        txtDoiSoLuong = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtSoDienThoaiKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachCho = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanelThoiGianKetThucAction = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lblHourNowAction = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblMinNowAction = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblSecNowAction = new javax.swing.JLabel();
        lblAM_PM_Action = new javax.swing.JLabel();
        jPanelThoiGianKetThucKhiNhanTinhTien = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        lblHourNowKhiNhanTinhTien = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblMinNowKhiNhanTinhTien = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblSecNowKhiNhanTinhTien = new javax.swing.JLabel();
        lblAM_PM_KhiNhanTinhTien = new javax.swing.JLabel();
        jPanelKhiNhanTinhTien1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblHourSuDung = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblMinSuDung = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanelKhiNhanTinhTien5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblHienTai = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanelKhiNhanTinhTien2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblNgayNhanPhong = new javax.swing.JLabel();
        jPanelNow2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lblTienPhong = new javax.swing.JLabel();
        jPanelKhiNhanTinhTien3 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblTienDichVu = new javax.swing.JLabel();
        jPanelKhiNhanTinhTien4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblHourNhanPhong = new javax.swing.JLabel();
        btnTinhTien = new javax.swing.JButton();

        setTitle("Chi tiết phòng");

        jPanel1.setBackground(new java.awt.Color(204, 153, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(121, 87, 142));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/chiTietPhong.png"))); // NOI18N
        jLabel1.setText("Chi tiết phòng");

        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/back.png"))); // NOI18N
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(291, 291, 291))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblBack)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(124, 36, 207)), "Thông tin phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(124, 36, 207))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(124, 36, 207));
        jPanel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lblMaPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblMaPhong.setText("PN01");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Loại phòng:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Trạng thái:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Sức chứa:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Giá theo giờ:");

        lblSucChua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblSucChua.setText("1-5 người");

        lblLoaiPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblLoaiPhong.setText("Phòng nhỏ");

        lblGiaTheoGio.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblGiaTheoGio.setText("100.000 VND");

        lblTrangThaiPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTrangThaiPhong.setText("Đang sử dụng");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Giờ nhận phòng:");

        lblGioNhanPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblGioNhanPhong.setText("19:00");

        lblTitileMaPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTitileMaPhong.setText("Mã phòng:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblTitileMaPhong)
                                .addGap(128, 128, 128)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSucChua)
                                    .addComponent(lblGioNhanPhong)
                                    .addComponent(lblLoaiPhong)
                                    .addComponent(lblTrangThaiPhong)
                                    .addComponent(lblGiaTheoGio)
                                    .addComponent(lblMaPhong)))
                            .addComponent(jLabel7)
                            .addComponent(jLabel13)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaPhong)
                    .addComponent(lblTitileMaPhong, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblTrangThaiPhong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblLoaiPhong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblSucChua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblGioNhanPhong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblGiaTheoGio))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new TitledBorder("Dịch vụ phòng"));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(124, 36, 207)), "Danh sách các dịch vụ đã đặt", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(124, 36, 207))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(124, 36, 207));
        jPanel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tblDichVuPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblDichVuPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Tên dịch vụ", "Giá bán", "Số lượng", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDichVuPhong.setRowHeight(30);
        tblDichVuPhong.setSelectionBackground(new java.awt.Color(200, 175, 228));
        tblDichVuPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDichVuPhongMouseClicked(evt);
            }
        });
        tblDichVuPhong.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblDichVuPhongPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tblDichVuPhong);

        btnThemDV.setBackground(new java.awt.Color(177, 100, 252));
        btnThemDV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThemDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/add.png"))); // NOI18N
        btnThemDV.setText("Thêm dịch vụ");
        btnThemDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDVActionPerformed(evt);
            }
        });

        btnXoaDV.setBackground(new java.awt.Color(177, 100, 252));
        btnXoaDV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXoaDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/delete.png"))); // NOI18N
        btnXoaDV.setText("Xóa dịch vụ");
        btnXoaDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDVActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thay đổi số lượng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(124, 36, 207))); // NOI18N

        btnThayDoiSoLuong.setBackground(new java.awt.Color(177, 100, 252));
        btnThayDoiSoLuong.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThayDoiSoLuong.setText("Thay đổi");
        btnThayDoiSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThayDoiSoLuongActionPerformed(evt);
            }
        });

        txtDoiSoLuong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtDoiSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThayDoiSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDoiSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThayDoiSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118)
                .addComponent(btnThemDV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaDV)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemDV, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel5.setBorder(new TitledBorder("Thông tin khách hàng"));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(124, 36, 207)), "Thông tin khách hàng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(124, 36, 207))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("SĐT khách hàng:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("Họ tên khách hàng:");

        txtSoDienThoaiKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtSoDienThoaiKH.setText("0123456789");
        txtSoDienThoaiKH.setEnabled(false);

        txtTenKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTenKH.setText("Nguyễn Văn Bảo");
        txtTenKH.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setText("Mã khách hàng:");

        txtMaKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaKH.setText("xxxxx");
        txtMaKH.setEnabled(false);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách khách chờ"));

        tblKhachCho.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblKhachCho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên khách hàng", "Số điện thoại", "Ngày nhận", "Giờ đăng ký"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblKhachCho);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(33, 33, 33)
                        .addComponent(txtSoDienThoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoDienThoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel6.setBorder(new TitledBorder("Tạm tính"));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(124, 36, 207), 1, true), "Tạm tính", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(124, 36, 207))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setText("Thời gian kết thúc:");

        lblHourNowAction.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblHourNowAction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHourNowAction.setText("0");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText(":");

        lblMinNowAction.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblMinNowAction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinNowAction.setText("0");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel25.setText(":");

        lblSecNowAction.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblSecNowAction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSecNowAction.setText("0");

        lblAM_PM_Action.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblAM_PM_Action.setText("AM");

        javax.swing.GroupLayout jPanelThoiGianKetThucActionLayout = new javax.swing.GroupLayout(jPanelThoiGianKetThucAction);
        jPanelThoiGianKetThucAction.setLayout(jPanelThoiGianKetThucActionLayout);
        jPanelThoiGianKetThucActionLayout.setHorizontalGroup(
            jPanelThoiGianKetThucActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThoiGianKetThucActionLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHourNowAction, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMinNowAction, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSecNowAction, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAM_PM_Action, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelThoiGianKetThucActionLayout.setVerticalGroup(
            jPanelThoiGianKetThucActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelThoiGianKetThucActionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelThoiGianKetThucActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lblHourNowAction)
                    .addComponent(jLabel24)
                    .addComponent(lblMinNowAction)
                    .addComponent(jLabel25)
                    .addComponent(lblSecNowAction)
                    .addComponent(lblAM_PM_Action, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setText("Thời gian kết thúc:");

        lblHourNowKhiNhanTinhTien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblHourNowKhiNhanTinhTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHourNowKhiNhanTinhTien.setText("0");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText(":");

        lblMinNowKhiNhanTinhTien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblMinNowKhiNhanTinhTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinNowKhiNhanTinhTien.setText("0");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel27.setText(":");

        lblSecNowKhiNhanTinhTien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblSecNowKhiNhanTinhTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSecNowKhiNhanTinhTien.setText("0");

        lblAM_PM_KhiNhanTinhTien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblAM_PM_KhiNhanTinhTien.setText("AM");

        javax.swing.GroupLayout jPanelThoiGianKetThucKhiNhanTinhTienLayout = new javax.swing.GroupLayout(jPanelThoiGianKetThucKhiNhanTinhTien);
        jPanelThoiGianKetThucKhiNhanTinhTien.setLayout(jPanelThoiGianKetThucKhiNhanTinhTienLayout);
        jPanelThoiGianKetThucKhiNhanTinhTienLayout.setHorizontalGroup(
            jPanelThoiGianKetThucKhiNhanTinhTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThoiGianKetThucKhiNhanTinhTienLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHourNowKhiNhanTinhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMinNowKhiNhanTinhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSecNowKhiNhanTinhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAM_PM_KhiNhanTinhTien)
                .addContainerGap())
        );
        jPanelThoiGianKetThucKhiNhanTinhTienLayout.setVerticalGroup(
            jPanelThoiGianKetThucKhiNhanTinhTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThoiGianKetThucKhiNhanTinhTienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelThoiGianKetThucKhiNhanTinhTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHourNowKhiNhanTinhTien)
                    .addComponent(jLabel26)
                    .addComponent(lblMinNowKhiNhanTinhTien)
                    .addComponent(jLabel27)
                    .addComponent(lblSecNowKhiNhanTinhTien)
                    .addComponent(lblAM_PM_KhiNhanTinhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Thời gian sử dụng:");
        jLabel11.setToolTipText("Thời gian sử dụng sẽ  bằng thời gian hiện tại trừ cho thời gian nhận phòng");

        lblHourSuDung.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblHourSuDung.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHourSuDung.setText("0");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel22.setText("giờ");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText(":");

        lblMinSuDung.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblMinSuDung.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinSuDung.setText("0");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setText("phút");

        javax.swing.GroupLayout jPanelKhiNhanTinhTien1Layout = new javax.swing.GroupLayout(jPanelKhiNhanTinhTien1);
        jPanelKhiNhanTinhTien1.setLayout(jPanelKhiNhanTinhTien1Layout);
        jPanelKhiNhanTinhTien1Layout.setHorizontalGroup(
            jPanelKhiNhanTinhTien1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhiNhanTinhTien1Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHourSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMinSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelKhiNhanTinhTien1Layout.setVerticalGroup(
            jPanelKhiNhanTinhTien1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKhiNhanTinhTien1Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addGroup(jPanelKhiNhanTinhTien1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHourSuDung)
                    .addComponent(jLabel22)
                    .addComponent(jLabel14)
                    .addComponent(lblMinSuDung)
                    .addComponent(jLabel20)))
        );

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Ngày hiện tại:");

        lblHienTai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblHienTai.setText("06/12/2022");

        javax.swing.GroupLayout jPanelKhiNhanTinhTien5Layout = new javax.swing.GroupLayout(jPanelKhiNhanTinhTien5);
        jPanelKhiNhanTinhTien5.setLayout(jPanelKhiNhanTinhTien5Layout);
        jPanelKhiNhanTinhTien5Layout.setHorizontalGroup(
            jPanelKhiNhanTinhTien5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhiNhanTinhTien5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHienTai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(61, 61, 61))
        );
        jPanelKhiNhanTinhTien5Layout.setVerticalGroup(
            jPanelKhiNhanTinhTien5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKhiNhanTinhTien5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelKhiNhanTinhTien5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHienTai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelKhiNhanTinhTien1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelThoiGianKetThucKhiNhanTinhTien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelThoiGianKetThucAction, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelKhiNhanTinhTien5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanelKhiNhanTinhTien5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelThoiGianKetThucAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelThoiGianKetThucKhiNhanTinhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelKhiNhanTinhTien1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Ngày nhận phòng:");

        lblNgayNhanPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblNgayNhanPhong.setText("06/12/2022");

        javax.swing.GroupLayout jPanelKhiNhanTinhTien2Layout = new javax.swing.GroupLayout(jPanelKhiNhanTinhTien2);
        jPanelKhiNhanTinhTien2.setLayout(jPanelKhiNhanTinhTien2Layout);
        jPanelKhiNhanTinhTien2Layout.setHorizontalGroup(
            jPanelKhiNhanTinhTien2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhiNhanTinhTien2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblNgayNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanelKhiNhanTinhTien2Layout.setVerticalGroup(
            jPanelKhiNhanTinhTien2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKhiNhanTinhTien2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelKhiNhanTinhTien2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNgayNhanPhong)))
        );

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setText("Tiền phòng:");

        lblTienPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTienPhong.setText("Đang tính...");

        javax.swing.GroupLayout jPanelNow2Layout = new javax.swing.GroupLayout(jPanelNow2);
        jPanelNow2.setLayout(jPanelNow2Layout);
        jPanelNow2Layout.setHorizontalGroup(
            jPanelNow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNow2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNow2Layout.setVerticalGroup(
            jPanelNow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNow2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTienPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Tiền dịch vụ:");

        lblTienDichVu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTienDichVu.setText("Chưa có dịch vụ nào");

        javax.swing.GroupLayout jPanelKhiNhanTinhTien3Layout = new javax.swing.GroupLayout(jPanelKhiNhanTinhTien3);
        jPanelKhiNhanTinhTien3.setLayout(jPanelKhiNhanTinhTien3Layout);
        jPanelKhiNhanTinhTien3Layout.setHorizontalGroup(
            jPanelKhiNhanTinhTien3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhiNhanTinhTien3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(98, 98, 98)
                .addComponent(lblTienDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel37)
                .addGap(21, 21, 21))
        );
        jPanelKhiNhanTinhTien3Layout.setVerticalGroup(
            jPanelKhiNhanTinhTien3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKhiNhanTinhTien3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelKhiNhanTinhTien3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTienDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Thời gian nhận phòng:");

        lblHourNhanPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblHourNhanPhong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHourNhanPhong.setText("06:10 AM");

        javax.swing.GroupLayout jPanelKhiNhanTinhTien4Layout = new javax.swing.GroupLayout(jPanelKhiNhanTinhTien4);
        jPanelKhiNhanTinhTien4.setLayout(jPanelKhiNhanTinhTien4Layout);
        jPanelKhiNhanTinhTien4Layout.setHorizontalGroup(
            jPanelKhiNhanTinhTien4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhiNhanTinhTien4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(29, 29, 29)
                .addComponent(lblHourNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelKhiNhanTinhTien4Layout.setVerticalGroup(
            jPanelKhiNhanTinhTien4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKhiNhanTinhTien4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelKhiNhanTinhTien4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHourNhanPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelNow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelKhiNhanTinhTien3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanelKhiNhanTinhTien4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanelKhiNhanTinhTien2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelKhiNhanTinhTien2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelKhiNhanTinhTien4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelKhiNhanTinhTien3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );

        btnTinhTien.setBackground(new java.awt.Color(177, 100, 252));
        btnTinhTien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTinhTien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/money.png"))); // NOI18N
        btnTinhTien.setText("Thanh toán");
        btnTinhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhTienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTinhTien)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTinhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTinhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhTienActionPerformed
        timeNow2 = Calendar.getInstance();
        nowHours = timeNow2.get(Calendar.HOUR_OF_DAY);
        nowMinutes = timeNow2.get(Calendar.MINUTE);
        nowSecond = timeNow2.get(Calendar.SECOND);
        
        dftxtGio = new DecimalFormat("##");
        dftxtPhut = new DecimalFormat("##");
        dftxtGiay = new DecimalFormat("##");
        
        //Mã phòng
        String maPhong = lblMaPhong.getText();
        Phong phong = phong_dao.timPhongTheoMa(maPhong);
        //Mã hóa đơn
        HoaDon hd = dao_HoaDon.timHoaDonTheoMaPhongVaTrangThaiFalse(maPhong);
        String maHoaDon = hd.getMaHoaDon();

        HoaDon hoaDon = dao_HoaDon.timHoaDonTheoMaHoaDon(maHoaDon);
        int gioVao = hoaDon.getGioNhanPhong().getHour();
        int phutVao = hoaDon.getGioNhanPhong().getMinute();

        int gioRa = Integer.parseInt(lblHourNowAction.getText());
        int phutRa = Integer.parseInt(lblMinNowAction.getText());

        //Thời gian kết thúc
        jPanelThoiGianKetThucAction.setVisible(false);
        jPanelThoiGianKetThucKhiNhanTinhTien.setVisible(true);

        //Thời gian sử dụng
        int gioSuDung = gioRa - gioVao;
        int phutSuDung = phutRa - phutVao;
        if (gioSuDung == 0) {
            lblHourNowKhiNhanTinhTien.setText(dftxtGio.format(nowHours));
            lblMinNowKhiNhanTinhTien.setText(dftxtPhut.format(nowMinutes));
            lblSecNowKhiNhanTinhTien.setText(dftxtGiay.format(nowSecond));
        }
        lblHourNowKhiNhanTinhTien.setText(dftxtGio.format(nowHours));
        lblMinNowKhiNhanTinhTien.setText(dftxtPhut.format(nowMinutes));
        lblSecNowKhiNhanTinhTien.setText(dftxtGiay.format(nowSecond));

        //Tiền phòng
        int doiSangPhutVao = gioVao * 60 + phutVao;
        int doiSangPhutRa = gioRa * 60 + phutRa;
        int tinhPhut = doiSangPhutRa - doiSangPhutVao;
        if (phutSuDung < 30) {
            gioSuDung = gioSuDung;
            if (phutSuDung < 0) {
                lblHourSuDung.setText(dftxtGio.format((gioSuDung - 1)));
                lblMinSuDung.setText(dftxtPhut.format((tinhPhut)));
            } else {
                lblHourSuDung.setText(dftxtGio.format((gioSuDung)));
                lblMinSuDung.setText(dftxtPhut.format((phutSuDung)));
            }
        } else {
            gioSuDung = gioSuDung + 1;
            phutSuDung = 0;
            lblHourSuDung.setText(dftxtGio.format((gioSuDung)));
            lblMinSuDung.setText(dftxtPhut.format((phutSuDung)));
        }

        //Tiền dịch vụ
        DecimalFormat df = new DecimalFormat("##,000VNĐ");
        Double tienDichVu = tongTienDVDeLuuValue();
        if (lblTienDichVu.getText() == "Chưa có dịch vụ nào") {
            lblTienDichVu.setText(df.format(tienDichVu));
        }

        String maLoaiPhong = phong.getLoaiPhong().getMaLoaiPhong();
        LoaiPhong thongTinLoaiPhong = dao_LoaiPhong.timLoaiPhongTheoMa(maLoaiPhong);
        Double giaPhong = thongTinLoaiPhong.getGiaTien();
        Double tienPhong = tinhTienPhong(gioSuDung, giaPhong);
        if (tienPhong == -1) {
            tienPhong = giaPhong;
        }
        lblTienPhong.setText(df.format(tienPhong));

        //Cập nhật hóa đơn
        
        LocalTime gioKetThuc   = LocalTime.of(gioRa, phutRa, nowSecond);
//        System.out.println("LocalTime"+gioKetThuc );
        
//        Time gioKetThuc = new Time(gioRa, phutRa, 0);     
//        System.out.println("Time"+gioKetThuc);
      
        
        HoaDon hoaDonNew = new HoaDon(maHoaDon, gioKetThuc);
        dao_HoaDon.suaGioKetThucHoaDon(hoaDonNew);

        //Cập nhật chi tiết hóa đơn
        ChiTietHoaDon chiTietHoaDonNew = new ChiTietHoaDon(hoaDon, gioSuDung);
        dao_ChiTietHoaDon.suaThoiLuongSuDungChiTietHoaDon(chiTietHoaDonNew);

        Form_ChiTietHoaDon frm_ChiTietHD = new Form_ChiTietHoaDon();

        frm_ChiTietHD.setEditDataDatChiTietHoaDon(hoaDon, tienPhong, tienDichVu, gioKetThuc);

        frm_ChiTietHD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTinhTienActionPerformed

    private void btnThemDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDVActionPerformed
        Form_ThemDichVuKhiDatPhong frmThemDVKhiDatPhong = new Form_ThemDichVuKhiDatPhong();
        String maPhong = lblMaPhong.getText();
        Phong phong = phong_dao.timPhongTheoMa(maPhong);
        //Mã hóa đơn
        HoaDon hd = dao_HoaDon.timHoaDonTheoMaPhongVaTrangThaiFalse(maPhong);
        frmThemDVKhiDatPhong.setEditDataDV(hd);
        frmThemDVKhiDatPhong.setVisible(true);

    }//GEN-LAST:event_btnThemDVActionPerformed

    private void btnXoaDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDVActionPerformed
        int r = tblDichVuPhong.getSelectedRow();
        if (r == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa !");
        } else {
            String maPhong = lblMaPhong.getText();
            Phong phong = phong_dao.timPhongTheoMa(maPhong);
            //Mã hóa đơn
            HoaDon hd = dao_HoaDon.timHoaDonTheoMaPhongVaTrangThaiFalse(maPhong);
            String maHoaDon = hd.getMaHoaDon();
            ChiTietDichVu ctdv = dao_ChiTietDichVu.timChiTietTheoMaHD(maHoaDon);
            String maDV = ctdv.getDichVu().getMaDichVu();
            dao_ChiTietDichVu.xoaChiTietDichVu(maHoaDon, maDV);
            modelDichVuPhong.setRowCount(0);

            ArrayList<ChiTietDichVu> listDichVuSauKhiXoa = dao_ChiTietDichVu.getDanhSachCTDichVu(maHoaDon);
            themDuLieuVaoBang(listDichVuSauKhiXoa);
            JOptionPane.showMessageDialog(this, "Xóa thành công !");
        }
    }//GEN-LAST:event_btnXoaDVActionPerformed

    public static void xoaDuLieuBang() {
        DefaultTableModel dm = (DefaultTableModel) tblDichVuPhong.getModel();
        dm.getDataVector().removeAllElements();
    }

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lblBackMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tblDichVuPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuPhongMouseClicked
        int row = tblDichVuPhong.getSelectedRow();
        txtDoiSoLuong.setText(modelDichVuPhong.getValueAt(row, 3).toString());

    }//GEN-LAST:event_tblDichVuPhongMouseClicked

    private void tblDichVuPhongPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblDichVuPhongPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDichVuPhongPropertyChange

    private void btnThayDoiSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThayDoiSoLuongActionPerformed

        int row = tblDichVuPhong.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa !");
        } else {
            if (kiemTraDuLieu()) {
                txtDoiSoLuong.setEnabled(true);
                btnThayDoiSoLuong.setEnabled(true);
                String maHD = modelDichVuPhong.getValueAt(row, 0).toString();
                HoaDon hd = dao_HoaDon.timHoaDonTheoMaHoaDon(maHD);
                String tenDV = modelDichVuPhong.getValueAt(row, 1).toString();
                DichVu dv = dao_DichVu.timDichVuTheoTenDV(tenDV);
                String maDV = dv.getMaDichVu();
                Integer soLuong = Integer.parseInt(txtDoiSoLuong.getText().trim());
                ChiTietDichVu ctdvNew = new ChiTietDichVu(dv, hd, soLuong);
                dao_ChiTietDichVu.suaCTDV(ctdvNew);
                xoaDuLieuBang();

                ArrayList<ChiTietDichVu> listCTDichVuNew = dao_ChiTietDichVu.getDanhSachCTDichVu(maHD);
                themDuLieuVaoBang(listCTDichVuNew);
                //Tiền dịch vụ
                DecimalFormat df = new DecimalFormat("##,000VNĐ");
                Double tienDichVu = tongTienDVDeLuuValue();
                lblTienDichVu.setText(df.format(tienDichVu));
                JOptionPane.showMessageDialog(this, "Sửa thành công.");
            }
        }
    }//GEN-LAST:event_btnThayDoiSoLuongActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_ChiTietPhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThayDoiSoLuong;
    private javax.swing.JButton btnThemDV;
    private javax.swing.JButton btnTinhTien;
    private javax.swing.JButton btnXoaDV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelKhiNhanTinhTien1;
    private javax.swing.JPanel jPanelKhiNhanTinhTien2;
    private javax.swing.JPanel jPanelKhiNhanTinhTien3;
    private javax.swing.JPanel jPanelKhiNhanTinhTien4;
    private javax.swing.JPanel jPanelKhiNhanTinhTien5;
    private javax.swing.JPanel jPanelNow2;
    private javax.swing.JPanel jPanelThoiGianKetThucAction;
    private javax.swing.JPanel jPanelThoiGianKetThucKhiNhanTinhTien;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAM_PM_Action;
    private javax.swing.JLabel lblAM_PM_KhiNhanTinhTien;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblGiaTheoGio;
    private javax.swing.JLabel lblGioNhanPhong;
    private javax.swing.JLabel lblHienTai;
    private javax.swing.JLabel lblHourNhanPhong;
    private javax.swing.JLabel lblHourNowAction;
    private javax.swing.JLabel lblHourNowKhiNhanTinhTien;
    private javax.swing.JLabel lblHourSuDung;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblLoaiPhong;
    public static javax.swing.JLabel lblMaPhong;
    private javax.swing.JLabel lblMinNowAction;
    private javax.swing.JLabel lblMinNowKhiNhanTinhTien;
    private javax.swing.JLabel lblMinSuDung;
    private javax.swing.JLabel lblNgayNhanPhong;
    private javax.swing.JLabel lblSecNowAction;
    private javax.swing.JLabel lblSecNowKhiNhanTinhTien;
    private javax.swing.JLabel lblSucChua;
    public static javax.swing.JLabel lblTienDichVu;
    private javax.swing.JLabel lblTienPhong;
    private javax.swing.JLabel lblTitileMaPhong;
    private javax.swing.JLabel lblTrangThaiPhong;
    public static javax.swing.JTable tblDichVuPhong;
    private javax.swing.JTable tblKhachCho;
    private javax.swing.JTextField txtDoiSoLuong;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSoDienThoaiKH;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables

    public void setEditDataDatPhong(KhachHang kh, String maPhong, String maHD) {
        //Thông tin khách hàng
        txtMaKH.setText(kh.getMaKhachHang());
        txtTenKH.setText(kh.getHoTenKhachHang());
        txtSoDienThoaiKH.setText(kh.getSoDienThoai());

        //Thông tin phòng
        Phong p = dao_Phong.timPhongTheoMa(maPhong);
        lblMaPhong.setText(p.getMaPhong());

        if (p.getTrangThaiPhong().getMaTrangThaiPhong().equals("PC")) {
            lblTrangThaiPhong.setText("Phòng chờ");
        } else if (p.getTrangThaiPhong().getMaTrangThaiPhong().equals("PT")) {
            lblTrangThaiPhong.setText("Phòng trống");
        } else if (p.getTrangThaiPhong().getMaTrangThaiPhong().equals("SD")) {
            lblTrangThaiPhong.setText("Phòng đang sử dụng");
        }

        String maLoaiPhong = p.getLoaiPhong().getMaLoaiPhong();
        LoaiPhong thongTinLoaiPhong = dao_LoaiPhong.timLoaiPhongTheoMa(maLoaiPhong);
        lblLoaiPhong.setText(thongTinLoaiPhong.getTenLoai());

        lblSucChua.setText(thongTinLoaiPhong.getSucChua() + "");
        DecimalFormat df = new DecimalFormat("##,000VNĐ/giờ");

        lblGiaTheoGio.setText(df.format(thongTinLoaiPhong.getGiaTien()));

        lblImage.setIcon(ResizeImage(String.valueOf(System.getProperty("user.dir") + p.getHinhAnh().toString())));

        lblTienPhong.setText("Đang tính ...");

        HoaDon hd = dao_HoaDon.timHoaDonTheoMaHoaDon(maHD);

        lblGioNhanPhong.setText(hd.getGioNhanPhong().toString());
//        SimpleDateFormat dfNgay = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter  dfNgay = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        lblNgayNhanPhong.setText(dfNgay.format(hd.getNgayLap().toLocalDate()));

        //Thông tin phần tạm tính
        Calendar ca = new GregorianCalendar();
        int PM_AM = ca.get(Calendar.AM_PM);
        String day_night;
        if (PM_AM == 1) {
            day_night = "PM";          
        } else {
            day_night = "AM";
        }
        lblHourNhanPhong.setText(hd.getGioNhanPhong().toString() +" "+ day_night);

        layGioHienTai();

        listCTDichVu = dao_ChiTietDichVu.getDanhSachCTDichVu(maHD);
        themDuLieuVaoBang(listCTDichVu);

        DateTimeFormatter gio = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
        Timestamp gioMoCua = Timestamp.valueOf(LocalDateTime.now().format(gio));
        phieuDatPhongs = dao_PhieuDat.getKhachHangChoTheoPhieuDatVaPhong(p.getMaPhong(), gioMoCua);

        themKhachCho(phieuDatPhongs);

        tongTienDVKhiOpen();

    }

    public void setEditDataThongTinPhongKhiClick(Phong p) {
        //Thông tin khách hàng
        if (p.getTrangThaiPhong().getMaTrangThaiPhong().equals("PT")) {
            dataPhongTrong(p);
        } else if (p.getTrangThaiPhong().getMaTrangThaiPhong().equals("PC")) {
            String maPhong = p.getMaPhong();
            PhieuDatPhong phieuDatPhong = dao_PhieuDat.timPhieuDatPhongTheoMaPhong(maPhong);
            String maPhieuDat = phieuDatPhong.getMaPhieuDatPhong();
            setDataDatPhongCho(maPhong, maPhieuDat);
        } else if (p.getTrangThaiPhong().getMaTrangThaiPhong().equals("SD")) {
            //Mã phòng
            String maPhong = p.getMaPhong();
            //Mã hóa đơn
            HoaDon hoaDon1 = dao_HoaDon.timHoaDonTheoMaPhongVaTrangThaiFalse(maPhong);
            System.out.println(hoaDon1.getMaHoaDon());
            String maHoaDon = hoaDon1.getMaHoaDon();

            //Mã khách hàng
            String maKhachHang = hoaDon1.getKhachHang().getMaKhachHang();
            KhachHang kh = dao_KhachHang.getKhachHangTheoMa(maKhachHang);
            setEditDataDatPhong(kh, maPhong, maHoaDon);
        }

        DateTimeFormatter gio = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
        Timestamp gioMoCua = Timestamp.valueOf(LocalDateTime.now().format(gio));
        phieuDatPhongs = dao_PhieuDat.getKhachHangChoTheoPhieuDatVaPhong(p.getMaPhong(), gioMoCua);

        themKhachCho(phieuDatPhongs);
    }

    public void setDataDatPhongCho(String maPhong, String phieuDat) {
        Phong p = dao_Phong.timPhongTheoMa(maPhong);
        PhieuDatPhong pdp = dao_PhieuDat.getPhieuTheoMa(phieuDat);
        KhachHang kh = dao_KhachHang.getKhachHangTheoMa(pdp.getKhachHang().getMaKhachHang());

        lblMaPhong.setText(p.getMaPhong());
        if (p.getTrangThaiPhong().getMaTrangThaiPhong().equals("PC")) {
            lblTrangThaiPhong.setText("Phòng chờ");
        } else if (p.getTrangThaiPhong().getMaTrangThaiPhong().equals("PT")) {
            lblTrangThaiPhong.setText("Phòng trống");
        } else if (p.getTrangThaiPhong().getMaTrangThaiPhong().equals("SD")) {
            lblTrangThaiPhong.setText("Phòng đang sử dụng");
        }

        if (p.getLoaiPhong().getMaLoaiPhong().equals("PN")) {
            lblLoaiPhong.setText("Phòng nhỏ");
            lblSucChua.setText("1-5 người");
            lblGiaTheoGio.setText("100,000VNĐ/giờ");
        } else if (p.getLoaiPhong().getMaLoaiPhong().equals("PV")) {
            lblLoaiPhong.setText("Phòng vừa");
            lblSucChua.setText("5-10 người");
            lblGiaTheoGio.setText("150,000VNĐ/giờ");
        } else if (p.getLoaiPhong().getMaLoaiPhong().equals("PL")) {
            lblLoaiPhong.setText("Phòng lớn");
            lblSucChua.setText("10-20 người");
            lblGiaTheoGio.setText("200,000VNĐ/giờ");
        } else if (p.getLoaiPhong().getMaLoaiPhong().equals("VIP")) {
            lblLoaiPhong.setText("Phòng VIP");
            lblSucChua.setText("20 người trở lên");
            lblGiaTheoGio.setText("300,000VNĐ/giờ");
        }

        lblImage.setIcon(ResizeImage(String.valueOf(System.getProperty("user.dir") + p.getHinhAnh().toString())));

        txtSoDienThoaiKH.setText(kh.getSoDienThoai());
        txtTenKH.setText(kh.getHoTenKhachHang());
        txtMaKH.setText(kh.getMaKhachHang());

        Timestamp gioNhanPhong = pdp.getThoiGianNhanPhong();
        Timestamp gioDat = pdp.getThoiGianDat();

        SimpleDateFormat dfTime = new SimpleDateFormat("HH:mm a");
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter dfDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        lblGioNhanPhong.setText(dfTime.format(gioNhanPhong.getTime()));
        lblHourNhanPhong.setText(dfTime.format(gioNhanPhong.getTime()));
        lblNgayNhanPhong.setText(dt.format(gioNhanPhong));

        lblHienTai.setText(LocalDate.now().format(dfDate));
        lblTienPhong.setText("0");

        btnTinhTien.setEnabled(false);

        layNgayHienTai();

        DateTimeFormatter gio = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
        Timestamp gioMoCua = Timestamp.valueOf(LocalDateTime.now().format(gio));
        phieuDatPhongs = dao_PhieuDat.getKhachHangChoTheoPhieuDatVaPhong(p.getMaPhong(), gioMoCua);

        themKhachCho(phieuDatPhongs);
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private void layGioHienTai() {
        timeNow2 = Calendar.getInstance();
        nowHours = timeNow2.get(Calendar.HOUR_OF_DAY);
        nowMinutes = timeNow2.get(Calendar.MINUTE);
        nowSecond = timeNow2.get(Calendar.SECOND);
        dftxtGio = new DecimalFormat("##");
        dftxtPhut = new DecimalFormat("##");
        dftxtGiay = new DecimalFormat("##");
        new Thread() {
            public void run() {
                while (true) {
                    Calendar ca = new GregorianCalendar();
                    String hour = (ca.get(Calendar.HOUR_OF_DAY) > 9) ? "" + ca.get(Calendar.HOUR_OF_DAY) + "" : "0" +  ca.get(Calendar.HOUR_OF_DAY);
                    String minute = (ca.get(Calendar.MINUTE) > 9) ? "" + ca.get(Calendar.MINUTE) + "" : "0" + ca.get(Calendar.MINUTE);
                    String second = (ca.get(Calendar.SECOND) > 9) ? "" + ca.get(Calendar.SECOND) + "" : "0" + ca.get(Calendar.SECOND);
                    int PM_AM = ca.get(Calendar.AM_PM);
                    String day_night;
                    if (PM_AM == 1) {
                        day_night = "PM";
                        lblAM_PM_Action.setText(day_night);
                    } else {
                        day_night = "AM";
                        lblAM_PM_Action.setText(day_night);
                    }
                    lblHourNowAction.setText(hour);
                    lblMinNowAction.setText(minute);
                    lblSecNowAction.setText(second);
                }
            }
        }.start();
    }

    private void layNgayHienTai() {
        now = LocalDate.now();
        int ngay = now.getDayOfMonth();
        int thang = now.getMonthValue();
        int nam = now.getYear();
        dNow = new java.sql.Date(nam - 1900, thang - 1, ngay);
        SimpleDateFormat dfNgay = new SimpleDateFormat("dd/MM/yyyy");
        lblHienTai.setText(dfNgay.format(dNow));
    }

    private void dataPhongTrong(Phong p) {
        txtMaKH.setText("Trống");
        txtTenKH.setText("Trống");
        txtSoDienThoaiKH.setText("Trống");

        //Thông tin phòng
        lblMaPhong.setText(p.getMaPhong());

        String maTrangThaiPhong = p.getTrangThaiPhong().getMaTrangThaiPhong();
        TrangThaiPhong thongTinTrangThaiPhong = dao_TrangThaiPhong.timTrangThaiPhongTheoMa(maTrangThaiPhong);
        lblTrangThaiPhong.setText(thongTinTrangThaiPhong.getTenTrangThaiPhong());

        String maLoaiPhong = p.getLoaiPhong().getMaLoaiPhong();
        LoaiPhong thongTinLoaiPhong = dao_LoaiPhong.timLoaiPhongTheoMa(maLoaiPhong);
        lblLoaiPhong.setText(thongTinLoaiPhong.getTenLoai());

        lblSucChua.setText(thongTinLoaiPhong.getSucChua() + "");

        DecimalFormat df = new DecimalFormat("##,000VNĐ/giờ");
        lblGiaTheoGio.setText(df.format(thongTinLoaiPhong.getGiaTien()));

        lblImage.setIcon(ResizeImage(String.valueOf(System.getProperty("user.dir") + p.getHinhAnh().toString())));

        lblGioNhanPhong.setText("Trống");

        //Thông tin tạm tính
        lblTienPhong.setText("Trống");
        lblNgayNhanPhong.setText("Trống");
        lblHourNhanPhong.setText("Trống");

        //Các nút
        btnThemDV.setEnabled(false);
        btnXoaDV.setEnabled(false);
        btnTinhTien.setEnabled(false);
        tblDichVuPhong.setEnabled(false);

        DateTimeFormatter gio = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
        Timestamp gioMoCua = Timestamp.valueOf(LocalDateTime.now().format(gio));
        phieuDatPhongs = dao_PhieuDat.getKhachHangChoTheoPhieuDatVaPhong(p.getMaPhong(), gioMoCua);

        themKhachCho(phieuDatPhongs);

        layNgayHienTai();
    }

    public static double tinhTienPhong(int gioSuDung, Double giaPhong) {
        int tongThoiGian = gioSuDung;
        double tongTienThuePhong = 0;
        if (tongThoiGian > 0) {
            if (tongThoiGian > 1) {
                tongTienThuePhong = tongThoiGian * giaPhong;
                return tongTienThuePhong;
            } else {
                tongTienThuePhong = giaPhong;
                return tongTienThuePhong;
            }
        }
        return -1;
    }

    public static void themDuLieuVaoBang(ArrayList<ChiTietDichVu> listCtdv) {
        modelDichVuPhong = (DefaultTableModel) tblDichVuPhong.getModel();
        for (ChiTietDichVu ctdv : listCtdv) {
            String maCTDV = ctdv.getDichVu().getMaDichVu();
            DichVu dv = dao_DichVu.timDichVuTheoMa(maCTDV);
            modelDichVuPhong.addRow(new Object[]{
                ctdv.getHoaDon().getMaHoaDon(),
                ctdv.getDichVu().getTenDichVu(),
                ctdv.getDichVu().tinhGiaBan(dv.getSanPham().getMaSanPham()),
                ctdv.getSoLuong(),
                tinhTongTien(ctdv.getSoLuong(), ctdv.getDichVu().tinhGiaBan(dv.getSanPham().getMaSanPham()))

            });
        }

    }

    public static Double tinhTongTien(Integer soLuong, Double giaBan) {
        Double gia = 0.0;
        gia = soLuong * giaBan;
        return gia;
    }

    public static Double tongTienDVDeLuuValue() {
        Double total = 0.0;
        for (int i = 0; i < tblDichVuPhong.getRowCount(); i++) {
            Double amount = (Double) tblDichVuPhong.getValueAt(i, 4);
            total += amount;
        }
        return total;

    }

    public void tongTienDVKhiOpen() {
        Double total = 0.0;
        for (int i = 0; i < tblDichVuPhong.getRowCount(); i++) {
            Double amount = (Double) tblDichVuPhong.getValueAt(i, 4);
            total += amount;
        }
        DecimalFormat df = new DecimalFormat("##,000VNĐ");
        lblTienDichVu.setText(df.format(total));
    }

    public static void loadDSDichVu() {
        xoaDuLieuBang();
        String maPhong = lblMaPhong.getText();
        Phong phong = phong_dao.timPhongTheoMa(maPhong);
        //Mã hóa đơn
        HoaDon hd = dao_HoaDon.timHoaDonTheoMaPhongVaTrangThaiFalse(maPhong);
        String maHoaDon = hd.getMaHoaDon();
        ArrayList<ChiTietDichVu> listDichVuNew = dao_ChiTietDichVu.getDanhSachCTDichVu(maHoaDon);
        themDuLieuVaoBang(listDichVuNew);

        DecimalFormat df = new DecimalFormat("##,000VNĐ");
        Double tienDichVu = tongTienDVDeLuuValue();
        lblTienDichVu.setText(df.format(tienDichVu));
    }

    private boolean kiemTraDuLieu() {
        String soLuong = txtDoiSoLuong.getText().trim();

        if (soLuong.length() > 0 || soLuong.length() == 0) {
            try {
                Double sl = Double.parseDouble(soLuong);
                if (sl < 0) {
                    JOptionPane.showMessageDialog(this, "Error: Số lượng phải > hơn 0!");
                    txtDoiSoLuong.requestFocus();
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: Số lượng phải > hơn 0!");
                txtDoiSoLuong.requestFocus();
                return false;
            }
        }
        return true;
    }

    private void themKhachCho(ArrayList<PhieuDatPhong> list) {
        tableModel = (DefaultTableModel) tblKhachCho.getModel();
        tableModel.getDataVector().removeAllElements();
        DateFormat ngay = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat gioi = new SimpleDateFormat("HH:mm a");
        for (PhieuDatPhong item : list) {
            KhachHang kh = dao_KhachHang.getKhachHangTheoMa(item.getKhachHang().getMaKhachHang());
            tableModel.addRow(new Object[]{kh.getHoTenKhachHang(), kh.getSoDienThoai(), ngay.format(item.getThoiGianNhanPhong()), gioi.format(item.getThoiGianNhanPhong())});
        }
    }
}
