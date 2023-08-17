package gui.form;

import dao.NhanVienDao;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.Dao_ChiTietDichVu;
import dao.Dao_ChiTietHoaDon;
import dao.Dao_DichVu;
import dao.Dao_HoaDon;
import dao.Dao_KhachHang;
import dao.Dao_LoaiPhong;
import dao.Dao_Phong;
import dao.OpenFilePDF;
import entity.ChiTietDichVu;
import entity.ChiTietHoaDon;
import entity.DichVu;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.Phong;
import static gui.form.Form_ChiTietPhong.phong_dao;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hp,THANHTU
 */
public class Form_ChiTietHoaDon extends javax.swing.JFrame {

    private NhanVienDao dao_NhanVien = new NhanVienDao();
    private Dao_KhachHang dao_KhachHang = new Dao_KhachHang();
    private Dao_HoaDon dao_HoaDon = new Dao_HoaDon();
    private Dao_Phong dao_Phong = new Dao_Phong();
    private Dao_ChiTietHoaDon dao_Cthd = new Dao_ChiTietHoaDon();
    private Dao_ChiTietDichVu dao_ChiTietDichVu = new Dao_ChiTietDichVu();
    private Dao_DichVu dao_DichVu = new Dao_DichVu();
    private Dao_LoaiPhong dao_LoaiPhong = new Dao_LoaiPhong();
    private Double tongTien;
    private String maHD;
    private String maPhong;
    private ArrayList<ChiTietDichVu> listCTDichVu;
    private DefaultTableModel modelDichVuPhong;
    private java.util.Date timeNow2;
    private int nowHours;
    private int nowMinutes;
    private DecimalFormat dftxtGio;
    private DecimalFormat dftxtPhut;
    private Double tienSauKhiGiamGia;
    private ArrayList dsHD;
    private ArrayList dsNhanVien;
  
    public Form_ChiTietHoaDon() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        lblTitileMaNhanVien = new javax.swing.JLabel();
        lblMaNhanVien = new javax.swing.JLabel();
        lblNgayLap = new javax.swing.JLabel();
        lblTitileNgayLap = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTitileMaHD = new javax.swing.JLabel();
        lblTitileMaPhong = new javax.swing.JLabel();
        lblTitileHourNhanPhong = new javax.swing.JLabel();
        lblTitileGioKetThuc = new javax.swing.JLabel();
        lblTitleHourSuDung = new javax.swing.JLabel();
        lblHourNhanPhong = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        lblMaPhong = new javax.swing.JLabel();
        lblGioKetThuc = new javax.swing.JLabel();
        lblHourSuDung = new javax.swing.JLabel();
        lblTitileMaKhachHang = new javax.swing.JLabel();
        lblTitleTenKhachHang = new javax.swing.JLabel();
        lblTitleSDTKhachHang = new javax.swing.JLabel();
        lblMaKhachHang = new javax.swing.JLabel();
        lblTenKhachHang = new javax.swing.JLabel();
        lblSDTKhachHang = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lblTitleTongDichVu = new javax.swing.JLabel();
        lblTitleTongTienPhong = new javax.swing.JLabel();
        lblTitleThueVAT = new javax.swing.JLabel();
        lblTitleTongTien = new javax.swing.JLabel();
        lblTongTienPhong = new javax.swing.JLabel();
        lblThueVAT = new javax.swing.JLabel();
        lblTongDichVu = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        txtTitleMaGiamGia = new javax.swing.JLabel();
        txtTitleTienKhachDua = new javax.swing.JLabel();
        txtTitleTienKhachTra = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        txtTienTraKhach = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTongTienSauKhiGiam = new javax.swing.JLabel();
        lblVND = new javax.swing.JLabel();
        cbbKM = new javax.swing.JComboBox<>();
        btnInHoaDon = new javax.swing.JButton();
        btnXacNhan = new javax.swing.JButton();
        lblTitileTenNhanVien = new javax.swing.JLabel();
        lblTenNhanVien = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 153, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(121, 87, 142));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/chiTietHoaDon.png"))); // NOI18N
        jLabel1.setText("Chi tiết hóa đơn");

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblBack)
                    .addContainerGap(742, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBack)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        lblTitileMaNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTitileMaNhanVien.setForeground(new java.awt.Color(204, 51, 0));
        lblTitileMaNhanVien.setText("Mã nhân viên:");

        lblMaNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblMaNhanVien.setForeground(new java.awt.Color(204, 51, 0));
        lblMaNhanVien.setText("NV01");

        lblNgayLap.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblNgayLap.setForeground(new java.awt.Color(204, 51, 0));
        lblNgayLap.setText("02/10/2022");

        lblTitileNgayLap.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTitileNgayLap.setForeground(new java.awt.Color(204, 51, 0));
        lblTitileNgayLap.setText("Ngày lập hóa đơn:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(124, 36, 207)), "Thông tin hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(124, 36, 207))); // NOI18N

        lblTitileMaHD.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTitileMaHD.setText("Mã hóa đơn:");

        lblTitileMaPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTitileMaPhong.setText("Mã phòng:");

        lblTitileHourNhanPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTitileHourNhanPhong.setText("Giờ nhận phòng:");

        lblTitileGioKetThuc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTitileGioKetThuc.setText("Giờ kết thúc:");

        lblTitleHourSuDung.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTitleHourSuDung.setText("Tổng thời gian:");

        lblHourNhanPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblHourNhanPhong.setText("19:00");

        lblMaHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblMaHoaDon.setText("HD021022A01");

        lblMaPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblMaPhong.setText("PN01");

        lblGioKetThuc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblGioKetThuc.setText("20:00");

        lblHourSuDung.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblHourSuDung.setText("2 giờ");

        lblTitileMaKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTitileMaKhachHang.setText("Mã khách hàng:");

        lblTitleTenKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTitleTenKhachHang.setText("Tên khách hàng:");

        lblTitleSDTKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTitleSDTKhachHang.setText("Số điện thoại:");

        lblMaKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblMaKhachHang.setText("KH1020");

        lblTenKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTenKhachHang.setText("Nguyễn Văn Bảo");

        lblSDTKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblSDTKhachHang.setText("0123456789");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTitileMaHD)
                        .addGap(50, 50, 50)
                        .addComponent(lblMaHoaDon))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTitileMaPhong)
                        .addGap(64, 64, 64)
                        .addComponent(lblMaPhong))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitileHourNhanPhong)
                            .addComponent(lblTitileGioKetThuc))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGioKetThuc)
                            .addComponent(lblHourNhanPhong))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTitileMaKhachHang)
                        .addGap(18, 18, 18)
                        .addComponent(lblMaKhachHang)
                        .addGap(61, 61, 61))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitleTenKhachHang)
                            .addComponent(lblTitleSDTKhachHang)
                            .addComponent(lblTitleHourSuDung))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblHourSuDung))
                            .addComponent(lblSDTKhachHang)
                            .addComponent(lblTenKhachHang))))
                .addGap(270, 270, 270))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitileMaKhachHang)
                            .addComponent(lblMaKhachHang))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitleTenKhachHang)
                            .addComponent(lblTenKhachHang))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitleSDTKhachHang)
                            .addComponent(lblSDTKhachHang))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitleHourSuDung)
                            .addComponent(lblHourSuDung)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaHoaDon, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTitileMaHD))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitileMaPhong)
                            .addComponent(lblMaPhong))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitileHourNhanPhong)
                            .addComponent(lblHourNhanPhong))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitileGioKetThuc)
                            .addComponent(lblGioKetThuc))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(124, 36, 207)), "Dịch vụ phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(124, 36, 207))); // NOI18N

        tblDichVu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên dịch vụ", "Đơn vị tính", "Số lượng", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDichVu.setRowHeight(33);
        tblDichVu.setSelectionBackground(new java.awt.Color(200, 175, 228));
        jScrollPane1.setViewportView(tblDichVu);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(124, 36, 207)), "Tổng tiền", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(124, 36, 207))); // NOI18N

        lblTitleTongDichVu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTitleTongDichVu.setText("Tổng dịch vụ:");

        lblTitleTongTienPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTitleTongTienPhong.setText("Tổng tiền phòng:");

        lblTitleThueVAT.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTitleThueVAT.setText("Thuế VAT:");

        lblTitleTongTien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTitleTongTien.setText("Tổng tiền ban đầu:");

        lblTongTienPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTongTienPhong.setText("200.000 VND");

        lblThueVAT.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblThueVAT.setText("10");

        lblTongDichVu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTongDichVu.setText("500.000 VND");

        lblTongTien.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(204, 51, 0));
        lblTongTien.setText("700.000");

        txtTitleMaGiamGia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTitleMaGiamGia.setText("Giảm giá(%):");

        txtTitleTienKhachDua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTitleTienKhachDua.setText("Tiền khách đưa:");

        txtTitleTienKhachTra.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTitleTienKhachTra.setText("Tiền trả khách:");

        txtTienKhachDua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });

        txtTienTraKhach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTienTraKhach.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("%");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 51, 0));
        jLabel3.setText("VNĐ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Tổng tiền sau khi giảm:");

        lblTongTienSauKhiGiam.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTongTienSauKhiGiam.setForeground(new java.awt.Color(204, 51, 0));
        lblTongTienSauKhiGiam.setText("700.000");

        lblVND.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblVND.setForeground(new java.awt.Color(204, 51, 0));
        lblVND.setText("VNĐ");

        cbbKM.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cbbKM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "KM10%", "KM20%", "KM30%" }));
        cbbKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitleThueVAT)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitleTongTienPhong)
                            .addComponent(lblTitleTongDichVu)
                            .addComponent(lblTitleTongTien))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTongTienPhong)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblThueVAT)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblTongTien)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)))
                                .addGap(560, 560, 560)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTitleMaGiamGia)
                                    .addComponent(txtTitleTienKhachDua)
                                    .addComponent(txtTitleTienKhachTra)
                                    .addComponent(jLabel4)))
                            .addComponent(lblTongDichVu))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbKM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTienTraKhach)
                            .addComponent(txtTienKhachDua)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 248, Short.MAX_VALUE)
                                .addComponent(lblTongTienSauKhiGiam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblVND)))))
                .addGap(93, 93, 93))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTitleTongDichVu)
                        .addComponent(lblTongDichVu))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTitleMaGiamGia)
                        .addComponent(cbbKM, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTitleTienKhachDua))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTitleTongTienPhong)
                        .addComponent(lblTongTienPhong)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTitleThueVAT)
                        .addComponent(lblThueVAT)
                        .addComponent(txtTienTraKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(txtTitleTienKhachTra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTitleTongTien)
                        .addComponent(lblTongTien)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblVND)
                        .addComponent(lblTongTienSauKhiGiam))
                    .addComponent(jLabel4))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btnInHoaDon.setBackground(new java.awt.Color(177, 100, 252));
        btnInHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnInHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/printer.png"))); // NOI18N
        btnInHoaDon.setText("In hóa đơn");
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });

        btnXacNhan.setBackground(new java.awt.Color(255, 51, 0));
        btnXacNhan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/hoaDon.png"))); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        lblTitileTenNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTitileTenNhanVien.setForeground(new java.awt.Color(204, 51, 0));
        lblTitileTenNhanVien.setText("Tên nhân viên:");

        lblTenNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTenNhanVien.setForeground(new java.awt.Color(204, 51, 0));
        lblTenNhanVien.setText("Võ Nguyễn Thanh Tú");

        btnLamMoi.setBackground(new java.awt.Color(177, 100, 252));
        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/reset.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitileMaNhanVien)
                    .addComponent(lblTitileTenNhanVien))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTenNhanVien)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMaNhanVien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitileNgayLap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNgayLap)
                        .addGap(133, 133, 133))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInHoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXacNhan)
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoi)
                        .addGap(104, 104, 104))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitileMaNhanVien)
                    .addComponent(lblMaNhanVien)
                    .addComponent(lblTitileNgayLap)
                    .addComponent(lblNgayLap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitileTenNhanVien)
                    .addComponent(lblTenNhanVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInHoaDon)
                    .addComponent(btnXacNhan)
                    .addComponent(btnLamMoi))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        if(kiemTraDuLieuTienNhap()) {
            if (!txtTienKhachDua.equals("")) {            
                Double tienKhachDua = Double.parseDouble(txtTienKhachDua.getText().trim());
                DecimalFormat dfTongTien = new DecimalFormat("##,000 VNĐ");
                Double tienTraKhach = tienKhachDua - tienSauKhiGiamGia;
                txtTienTraKhach.setText(dfTongTien.format(tienTraKhach));       
            }              
        }         
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed
        //Tạo ra 1 file PDF
        if (dsHD != null) {
            String maHD = "";
            for (int i = 0; i < dsHD.size(); i++) {
                maHD = maHD + dsHD.get(i);
            }
            String path = System.getProperty("user.dir") + "\\src\\exportFile\\xuatHoaDon\\" + maHD + ".pdf";   
         
            com.itextpdf.text.Font textFont = FontFactory.getFont("font/SVN-Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 10); //10 is the size
            com.itextpdf.text.Font textFont24 = FontFactory.getFont("font/SVN-Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 24); //30 is the size

            Document doc = new Document();
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(path));
                doc.open();
                Paragraph karaokeName = new Paragraph("                      KARAOKE CGV\n", textFont24);
                doc.add(karaokeName);
                Paragraph karaokeNameDiaChi = new Paragraph("                               Địa chỉ: 40 Nguyễn Văn Bảo. Quận Gò Vấp, Thành phố Hồ Chí Minh\n", textFont);
                doc.add(karaokeNameDiaChi);
                Paragraph karaokeNameSDT = new Paragraph("                                                          Số điện thoại: 0329675269\n", textFont);
                doc.add(karaokeNameSDT);
                Paragraph starLine = new Paragraph("========================================================================================", textFont);
                doc.add(starLine);

                //Thông tin nhân viên
                Paragraph paragraphMaNhanVienLine1 = new Paragraph("               Mã nhân viên:" + lblMaNhanVien.getText() + "                                                     Ngày lập hóa đơn: " + lblNgayLap.getText() + "\n", textFont);
                doc.add(paragraphMaNhanVienLine1);
                Paragraph paragraphTenNhanVienLine2 = new Paragraph("              Tên nhân viên: " + lblTenNhanVien.getText(), textFont);
                doc.add(paragraphTenNhanVienLine2);
                doc.add(starLine);

                //Thông tin hóa đơn
                Paragraph paragraphMaHoaDonLine1 = new Paragraph("              Mã hóa đơn:" + lblMaHoaDon.getText() + "                              Mã khách hàng: " + lblMaKhachHang.getText() + "\n", textFont);
                doc.add(paragraphMaHoaDonLine1);
                Paragraph paragraphMaHoaDonLine2 = new Paragraph("              Mã Phòng:" + lblMaPhong.getText() + "                                                                   Tên khách hàng: " + lblTenKhachHang.getText() + "\n", textFont);
                doc.add(paragraphMaHoaDonLine2);

                Paragraph paragraphMaHoaDonLine3 = new Paragraph("              Giờ nhận phòng:" + lblHourNhanPhong.getText() + "                                      Số điện thoại: " + lblSDTKhachHang.getText() + "\n", textFont);
                doc.add(paragraphMaHoaDonLine3);
                Paragraph paragraphMaHoaDonLine4 = new Paragraph("              Giờ kết thúc:" + lblGioKetThuc.getText() + "                                                                    Tổng thời gian: " + lblHourSuDung.getText() + "\n", textFont);
                doc.add(paragraphMaHoaDonLine4);
                doc.add(starLine);

                //Dịch vụ Table
                Paragraph paragraph4 = new Paragraph("              Dịch vụ", textFont);
                doc.add(paragraph4);
                Paragraph paragraph5 = new Paragraph("\n", textFont);
                doc.add(paragraph5);
                PdfPTable tbl = new PdfPTable(4);
                tbl.addCell(new Phrase("                Tên dịch vụ", textFont));
                tbl.addCell(new Phrase("                Đơn vị tính", textFont));
                tbl.addCell(new Phrase("                Số lượng", textFont));
                tbl.addCell(new Phrase("                Tổng tiền", textFont));
                for (int i = 0; i < tblDichVu.getRowCount(); i++) {
                    String ten = tblDichVu.getValueAt(i, 0).toString();
                    String dvt = tblDichVu.getValueAt(i, 1).toString();
                    String sl = tblDichVu.getValueAt(i, 2).toString();
                    String tongTien = tblDichVu.getValueAt(i, 3).toString();
                    tbl.addCell(new Phrase(ten, textFont));
                    tbl.addCell(new Phrase(dvt, textFont));
                    tbl.addCell(new Phrase(sl, textFont));
                    tbl.addCell(new Phrase(tongTien, textFont));
                }
                doc.add(tbl);
                doc.add(starLine);
                //Thông tin tổng tiền:

                Paragraph paragraphTongTienLine1 = new Paragraph("              Tổng tiền dịch vụ:" + lblTongDichVu.getText() + "                                                                    Giảm giá: " + cbbKM.getSelectedItem().toString(), textFont);
                doc.add(paragraphTongTienLine1);
                Paragraph paragraphTongTienLine2 = new Paragraph("              Tổng tiền phòng:" + lblTongTienPhong.getText() + "                       Tiền khách đưa: " + txtTienKhachDua.getText() + "\n", textFont);
                doc.add(paragraphTongTienLine2);

                Paragraph paragraphTongTienLine4 = new Paragraph("              Thuế VAT:" + lblThueVAT.getText() + "%                                                                                             Tiền trả khách: " + txtTienTraKhach.getText() + "\n", textFont);
                doc.add(paragraphTongTienLine4);
                Paragraph paragraphTongTienLine5 = new Paragraph("              Tổng tiền ban đầu:" + lblTongTien.getText() + "VNĐ\n", textFont);
                doc.add(paragraphTongTienLine5);
                Paragraph paragraphTongTienLine6 = new Paragraph("              Tổng tiền sau khi giảm: " + lblTongTienSauKhiGiam.getText() + "\n", textFont);
                doc.add(paragraphTongTienLine6);

                doc.add(starLine);
                Paragraph thanskMsg = new Paragraph("               Xin cám ơn quí khách đã sử sụng phòng hát của chúng tôi, mong bạn sẽ quay lại vào những lần tới ^^", textFont);
                doc.add(thanskMsg);
                doc.close();
                //open pdf
                OpenFilePDF.openBill(maHD);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } 
        }else{          
            String path = System.getProperty("user.dir") + "\\src\\exportFile\\xuatHoaDon\\" + maHD + ".pdf";
            com.itextpdf.text.Font textFont = FontFactory.getFont("font/SVN-Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 10); //10 is the size
            com.itextpdf.text.Font textFont24 = FontFactory.getFont("font/SVN-Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 24); //30 is the size

            Document doc = new Document();
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(path));
                doc.open();
                Paragraph karaokeName = new Paragraph("                      KARAOKE CGV\n", textFont24);
                doc.add(karaokeName);
                Paragraph karaokeNameDiaChi = new Paragraph("                               Địa chỉ: 40 Nguyễn Văn Bảo. Quận Gò Vấp, Thành phố Hồ Chí Minh\n", textFont);
                doc.add(karaokeNameDiaChi);
                Paragraph karaokeNameSDT = new Paragraph("                                                          Số điện thoại: 0329675269\n", textFont);
                doc.add(karaokeNameSDT);
                Paragraph starLine = new Paragraph("==================================================================================", textFont);
                doc.add(starLine);

                //Thông tin nhân viên
                Paragraph paragraphMaNhanVienLine1 = new Paragraph("               Mã nhân viên:" + lblMaNhanVien.getText() + "                                             Ngày lập hóa đơn: " + lblNgayLap.getText() + "\n", textFont);
                doc.add(paragraphMaNhanVienLine1);
                Paragraph paragraphTenNhanVienLine2 = new Paragraph("              Tên nhân viên: " + lblTenNhanVien.getText(), textFont);
                doc.add(paragraphTenNhanVienLine2);
                doc.add(starLine);

                //Thông tin hóa đơn
                Paragraph paragraphMaHoaDonLine1 = new Paragraph("              Mã hóa đơn:" + lblMaHoaDon.getText() + "                                          Mã khách hàng: " + lblMaKhachHang.getText() + "\n", textFont);
                doc.add(paragraphMaHoaDonLine1);
                Paragraph paragraphMaHoaDonLine2 = new Paragraph("              Mã Phòng:" + lblMaPhong.getText() + "                                                            Tên khách hàng: " + lblTenKhachHang.getText() + "\n", textFont);
                doc.add(paragraphMaHoaDonLine2);

                Paragraph paragraphMaHoaDonLine3 = new Paragraph("              Giờ nhận phòng:" + lblHourNhanPhong.getText() + "                                           Số điện thoại: " + lblSDTKhachHang.getText() + "\n", textFont);
                doc.add(paragraphMaHoaDonLine3);
                Paragraph paragraphMaHoaDonLine4 = new Paragraph("              Giờ kết thúc:" + lblGioKetThuc.getText() + "                                                  Tổng thời gian: " + lblHourSuDung.getText() + "\n", textFont);
                doc.add(paragraphMaHoaDonLine4);
                doc.add(starLine);

                //Dịch vụ Table
                Paragraph paragraph4 = new Paragraph("              Dịch vụ", textFont);
                doc.add(paragraph4);
                Paragraph paragraph5 = new Paragraph("\n", textFont);
                doc.add(paragraph5);
                PdfPTable tbl = new PdfPTable(4);
                tbl.addCell(new Phrase("                Tên dịch vụ", textFont));
                tbl.addCell(new Phrase("                Đơn vị tính", textFont));
                tbl.addCell(new Phrase("                Số lượng", textFont));
                tbl.addCell(new Phrase("                Tổng tiền", textFont));
                for (int i = 0; i < tblDichVu.getRowCount(); i++) {
                    String ten = tblDichVu.getValueAt(i, 0).toString();
                    String dvt = tblDichVu.getValueAt(i, 1).toString();
                    String sl = tblDichVu.getValueAt(i, 2).toString();
                    String tongTien = tblDichVu.getValueAt(i, 3).toString();
                    tbl.addCell(new Phrase(ten, textFont));
                    tbl.addCell(new Phrase(dvt, textFont));
                    tbl.addCell(new Phrase(sl, textFont));
                    tbl.addCell(new Phrase(tongTien, textFont));
                }
                doc.add(tbl);
                doc.add(starLine);
                //Thông tin tổng tiền:
                Paragraph paragraphTongTienLine1 = new Paragraph("              Tổng tiền dịch vụ:" + lblTongDichVu.getText() + "                                                        Giảm giá: " + cbbKM.getSelectedItem().toString(), textFont);
                doc.add(paragraphTongTienLine1);
                Paragraph paragraphTongTienLine2 = new Paragraph("              Tổng tiền phòng:" + lblTongTienPhong.getText() + "                                                         Tiền khách đưa: " + txtTienKhachDua.getText() + "\n", textFont);
                doc.add(paragraphTongTienLine2);

                Paragraph paragraphTongTienLine4 = new Paragraph("              Thuế VAT:" + lblThueVAT.getText() + "%                                                                              Tiền trả khách: " + txtTienTraKhach.getText() + "\n", textFont);
                doc.add(paragraphTongTienLine4);
                Paragraph paragraphTongTienLine5 = new Paragraph("              Tổng tiền ban đầu:" + lblTongTien.getText() + "VNĐ \n", textFont);
                doc.add(paragraphTongTienLine5);
                Paragraph paragraphTongTienLine6 = new Paragraph("              Tổng tiền sau khi giảm: " + lblTongTienSauKhiGiam.getText() + "\n", textFont);
                doc.add(paragraphTongTienLine6);

                doc.add(starLine);
                Paragraph thanskMsg = new Paragraph("               Xin cám ơn quí khách đã sử sụng phòng hát của chúng tôi, mong bạn sẽ quay lại vào những lần tới ^^", textFont);
                doc.add(thanskMsg);
                doc.close();
                //open pdf
                OpenFilePDF.openBill(maHD);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } 
        
        }
    }//GEN-LAST:event_btnInHoaDonActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        int output = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắc muốn thanh toán", "Xác nhận", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
        if (output == JOptionPane.YES_OPTION) {
            if (kiemTraDuLieu()) {
                Float thue = Float.parseFloat(lblThueVAT.getText().trim());
                String giamGia = cbbKM.getSelectedItem().toString();
                float khuyeMai = (float) 0;
                if(giamGia.equals("KM10%")) {
                    khuyeMai = 10;
                }else if(giamGia.equals("KM20%")){
                    khuyeMai = 20;
                }else if(giamGia.equals("KM30%")){
                    khuyeMai = 30;
                }else {
                    khuyeMai = (float) 0;
                }
                Double tienKhachDua = Double.parseDouble(txtTienKhachDua.getText().trim());
                System.out.println(dsHD);
                if (dsHD != null) {
                    for (int i = 0; i < dsHD.size(); i++) {
                        HoaDon hd = dao_HoaDon.timHoaDonTheoMaHoaDon((String) dsHD.get(i));
                        ChiTietHoaDon cthd = dao_Cthd.timChiTietHDTheoMaHD((String) dsHD.get(i));
                        ChiTietDichVu ctdv = dao_ChiTietDichVu.timChiTietTheoMaHD((String) dsHD.get(i));

                        HoaDon hoaDonNew = new HoaDon(hd.getMaHoaDon(), thue, khuyeMai, tienKhachDua, tongTien, true);
                        dao_HoaDon.suaThue_KhuyenMai_TienKhachTra_TrangThai__TongTien_HoaDon(hoaDonNew);

                        Phong phongNew = new Phong(cthd.getPhong().getMaPhong());
                        dao_Phong.suaTrangThaiPhongTrongSauKhiThanhToan(phongNew);               
                    }  
                }else{
                    HoaDon hoaDonNew = new HoaDon(maHD, thue, khuyeMai, tienKhachDua, tongTien, true);       
                    dao_HoaDon.suaThue_KhuyenMai_TienKhachTra_TrangThai__TongTien_HoaDon(hoaDonNew);
                    Phong phongNew = new Phong(maPhong);
                    dao_Phong.suaTrangThaiPhongTrongSauKhiThanhToan(phongNew);    
                }

                JOptionPane.showMessageDialog(rootPane, "Thanh toán thành công !");          
                this.dispose();
                Form_DatPhongHat.loadDSKhiThanhToan();
            }          
        } else if (output == JOptionPane.NO_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        cbbKM.setSelectedIndex(0);
        txtTienKhachDua.setText("");
        txtTienTraKhach.setText("");
        DecimalFormat dfTongTien = new DecimalFormat("##,000 VNĐ");
        lblTongTienSauKhiGiam.setText(dfTongTien.format(tongTien));
        lblVND.setVisible(false);
   
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblBackMouseClicked

    private void cbbKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKMActionPerformed
            float giamGia = 0;
            if (cbbKM.getSelectedItem() == "KM10%") {
                giamGia = 10;        
                tinhTienGiamGia(giamGia);
            }else if(cbbKM.getSelectedItem() == "KM20%"){
                giamGia = 20;
                tinhTienGiamGia(giamGia);
            }
            else if(cbbKM.getSelectedItem() == "KM30%"){
                giamGia = 30;
                tinhTienGiamGia(giamGia);
            }
    }//GEN-LAST:event_cbbKMActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_ChiTietHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JComboBox<String> cbbKM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblGioKetThuc;
    private javax.swing.JLabel lblHourNhanPhong;
    private javax.swing.JLabel lblHourSuDung;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblMaKhachHang;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblMaPhong;
    private javax.swing.JLabel lblNgayLap;
    private javax.swing.JLabel lblSDTKhachHang;
    private javax.swing.JLabel lblTenKhachHang;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblThueVAT;
    private javax.swing.JLabel lblTitileGioKetThuc;
    private javax.swing.JLabel lblTitileHourNhanPhong;
    private javax.swing.JLabel lblTitileMaHD;
    private javax.swing.JLabel lblTitileMaKhachHang;
    private javax.swing.JLabel lblTitileMaNhanVien;
    private javax.swing.JLabel lblTitileMaPhong;
    private javax.swing.JLabel lblTitileNgayLap;
    private javax.swing.JLabel lblTitileTenNhanVien;
    private javax.swing.JLabel lblTitleHourSuDung;
    private javax.swing.JLabel lblTitleSDTKhachHang;
    private javax.swing.JLabel lblTitleTenKhachHang;
    private javax.swing.JLabel lblTitleThueVAT;
    private javax.swing.JLabel lblTitleTongDichVu;
    private javax.swing.JLabel lblTitleTongTien;
    private javax.swing.JLabel lblTitleTongTienPhong;
    private javax.swing.JLabel lblTongDichVu;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTongTienPhong;
    private javax.swing.JLabel lblTongTienSauKhiGiam;
    private javax.swing.JLabel lblVND;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienTraKhach;
    private javax.swing.JLabel txtTitleMaGiamGia;
    private javax.swing.JLabel txtTitleTienKhachDua;
    private javax.swing.JLabel txtTitleTienKhachTra;
    // End of variables declaration//GEN-END:variables

    public void setEditDataDatChiTietHoaDon(HoaDon hd, Double tienPhong, Double tienDichVu, LocalTime gioKetThuc) {
        //Thông tin nhân viên
        String maNhanVien = hd.getNhanVien().getMaNhanVien();
        NhanVien nhanVien = dao_NhanVien.timNhanVienTheoMa(maNhanVien);
        String tenNhanVien = nhanVien.getTenNhanVien();
        lblMaNhanVien.setText(maNhanVien);
        lblTenNhanVien.setText(tenNhanVien);
        SimpleDateFormat dfNgay = new SimpleDateFormat("dd/MM/yyyy");
        lblNgayLap.setText(dfNgay.format(hd.getNgayLap()));

        //Thông tin hóa đơn
        maHD = hd.getMaHoaDon();
        lblMaHoaDon.setText(maHD);

        ChiTietHoaDon cthd = dao_Cthd.timChiTietHDTheoMaHD(maHD);
        maPhong = cthd.getPhong().getMaPhong();
        lblHourNhanPhong.setText(hd.getGioNhanPhong().toString());
        lblGioKetThuc.setText(gioKetThuc.toString());

        DecimalFormat dfGio = new DecimalFormat("##,00 giờ");
        Integer thoiGianSuDung = cthd.getThoiLuongSuDung();

        lblHourSuDung.setText(dfGio.format(thoiGianSuDung));

        //Thông tin khách hàng
        String maKhachHang = hd.getKhachHang().getMaKhachHang();
        KhachHang khachHang = dao_KhachHang.getKhachHangTheoMa(maKhachHang);
        String tenKhachHang = khachHang.getHoTenKhachHang();
        String soDienThoai = khachHang.getSoDienThoai();

        lblMaKhachHang.setText(maKhachHang);
        lblTenKhachHang.setText(tenKhachHang);
        lblSDTKhachHang.setText(soDienThoai);

        //Bảng dịch vụ
        listCTDichVu = dao_ChiTietDichVu.getDanhSachCTDichVu(maHD);
        themDuLieuVaoBang(listCTDichVu);

        //Thông tin tổng tiền
        DecimalFormat dfTien = new DecimalFormat("##,000 VNĐ");
        lblTongDichVu.setText(dfTien.format(tienDichVu));
        lblTongTienPhong.setText(dfTien.format(tienPhong));

        float thue = (float) 10;
        lblThueVAT.setText(thue + "");

        DecimalFormat dfTongTien = new DecimalFormat("##,000");
        tongTien = tinhTongTien(tienPhong, tienDichVu, thue);
        lblTongTien.setText(dfTongTien.format(tongTien));
        
        tienSauKhiGiamGia = tongTien;
        lblTongTienSauKhiGiam.setText(lblTongTien.getText());

    }

    private Double tinhTongTien(Double tienPhong, Double tienDichVu, float thue) {
        double tongTien = 0;
        tongTien = (tienPhong + tienDichVu) + (tienPhong + tienDichVu) * (thue / 100);
        return tongTien;
    }

    private void themDuLieuVaoBang(ArrayList<ChiTietDichVu> listCTDichVu) {
        modelDichVuPhong = (DefaultTableModel) tblDichVu.getModel();
        for (ChiTietDichVu ctdv : listCTDichVu) {
            String maCTDV = ctdv.getDichVu().getMaDichVu();
            DichVu dv = dao_DichVu.timDichVuTheoMa(maCTDV);
            modelDichVuPhong.addRow(new Object[]{
                ctdv.getDichVu().getTenDichVu(),
                ctdv.getDichVu().getDonViTinh(),
                ctdv.getSoLuong(),
                tinhTongTien(ctdv.getSoLuong(), ctdv.getDichVu().tinhGiaBan(dv.getSanPham().getMaSanPham()))
            });
        }
    }

    private Double tinhTongTien(Integer soLuong, Double giaBan) {
        Double gia = 0.0;
        gia = soLuong * giaBan;
        return gia;
    }

    public void danhSachData(ArrayList dsMaHD, ArrayList dsNV) {
        dsHD = dsMaHD;
        dsNhanVien = dsNV;
        String maHD = "|";
        String maP = "|";
        String maNV = "";
        String maKH = "";
        String gioNhanPhong = "|";
        String gioSuDungAll = "|";
        String tienPhongAll = "|";
        Double tienPhongALLValue = 0.0;
        Double tienDichVu = 0.0;
        //Giờ kết thúc
        Calendar ca = new GregorianCalendar();
        String hour = (ca.get(Calendar.HOUR_OF_DAY) > 9) ? "" + ca.get(Calendar.HOUR_OF_DAY) + "" : "0" + ca.get(Calendar.HOUR_OF_DAY);
        String minute = (ca.get(Calendar.MINUTE) > 9) ? "" + ca.get(Calendar.MINUTE) + "" : "0" + ca.get(Calendar.MINUTE);
       
        int gioRa = Integer.parseInt(hour);
        int phutRa = Integer.parseInt(minute);
        int giayRa = ca.get(Calendar.SECOND);
         
        LocalTime gioKetThuc = LocalTime.of(gioRa, phutRa, giayRa);
        lblGioKetThuc.setText(gioKetThuc.toString());

        for (int i = 0; i < dsMaHD.size(); i++) {

            HoaDon hd = dao_HoaDon.timHoaDonTheoMaHoaDon((String) dsMaHD.get(i));
            ChiTietHoaDon cthd = dao_Cthd.timChiTietHDTheoMaHD((String) dsMaHD.get(i));
            ChiTietDichVu ctdv = dao_ChiTietDichVu.timChiTietTheoMaHD((String) dsMaHD.get(i));

            //Nhân viên
            maNV = hd.getNhanVien().getMaNhanVien();
            NhanVien nv = dao_NhanVien.timNhanVienTheoMa(maNV);
            lblMaNhanVien.setText(maNV);
            lblTenNhanVien.setText(nv.getTenNhanVien());

            //Khách hàng
            maKH = hd.getKhachHang().getMaKhachHang();
            KhachHang kh = dao_KhachHang.getKhachHangTheoMa(maKH);
            lblMaKhachHang.setText(maKH);
            lblTenKhachHang.setText(kh.getHoTenKhachHang());
            lblSDTKhachHang.setText(kh.getSoDienThoai());

            //Ngày lập    
            SimpleDateFormat dfNgay = new SimpleDateFormat("dd/MM/yyyy");
            lblNgayLap.setText(dfNgay.format(hd.getNgayLap()));

            //Danh sách hóa đơn
            maHD = maHD + " " + hd.getMaHoaDon() + "|";
            lblMaHoaDon.setText(maHD);

            //Danh sách hóa phòng
            maP = maP + " " + cthd.getPhong().getMaPhong() + "|";
            lblMaPhong.setText(maP);

            //Giờ nhận phòng
            gioNhanPhong = gioNhanPhong + " " + hd.getGioNhanPhong() + " |";
            lblHourNhanPhong.setText(gioNhanPhong.toString());

            //Giờ sử dụng
            int gioVao = hd.getGioNhanPhong().getHour();
            int phutVao = hd.getGioNhanPhong().getMinute();

            int gioSuDung = gioRa - gioVao;
            int phutSuDung = phutRa - phutVao;

            int doiSangPhutVao = gioVao * 60 + phutVao;
            int doiSangPhutRa = gioRa * 60 + phutRa;
            int tinhPhut = doiSangPhutRa - doiSangPhutVao;

            if (phutSuDung < 30) {
                gioSuDung = gioSuDung;
                if (phutSuDung < 0) {
                    gioSuDung = gioSuDung - 1;
                    phutSuDung = Math.abs(phutSuDung);
                } else if(phutSuDung > 0) {

                    gioSuDung = gioSuDung;
                    phutSuDung = phutSuDung;
      
                }
            } else {
                gioSuDung = gioSuDung + 1;
                phutSuDung = 0;
            }
            String gioSD = gioSuDung + "giờ : " + phutSuDung + "phút";
            gioSuDungAll = gioSuDungAll + " " + gioSD + "|";
            lblHourSuDung.setText(gioSuDungAll);

            //Tiền phòng
            Phong phong = phong_dao.timPhongTheoMa(cthd.getPhong().getMaPhong());
            String maLoaiPhong = phong.getLoaiPhong().getMaLoaiPhong();
            LoaiPhong thongTinLoaiPhong = dao_LoaiPhong.timLoaiPhongTheoMa(maLoaiPhong);
            Double giaPhong = thongTinLoaiPhong.getGiaTien();
            Double tienPhong = Form_ChiTietPhong.tinhTienPhong(gioSuDung, giaPhong);
            if (tienPhong == -1) {
                tienPhong = giaPhong;
            }
            DecimalFormat dfTien = new DecimalFormat("##,000 VNĐ");
            tienPhongAll = tienPhongAll + " " + (dfTien.format(tienPhong)+"-"+ cthd.getPhong().getMaPhong())+ "|";
            tienPhongALLValue = tienPhongALLValue + tienPhong;
            lblTongTienPhong.setText(tienPhongAll);

            //Tiền dịch vụ
            //Bảng dịch vụ
            listCTDichVu = dao_ChiTietDichVu.getDanhSachCTDichVu(cthd.getHoaDon().getMaHoaDon());
            themDuLieuVaoBang(listCTDichVu);           
            DecimalFormat df = new DecimalFormat("##,000VNĐ");
            tienDichVu = tongTienDV();
            lblTongDichVu.setText(df.format(tienDichVu));       
        }
        //Tổng tiền ban đầu
        float thue = (float) 10;
        DecimalFormat df = new DecimalFormat("##,000");
        tongTien = tongTienBanDau(tienDichVu, tienPhongALLValue, thue);
        if (tongTien > 1000000) {
            tongTien = tongTien - tongTien*(20/100);
        }else{
            tongTien = tongTien;
        }
        lblTongTien.setText(df.format(tongTien));
        
        //Tổng tiền sau khi giảm
        tienSauKhiGiamGia = tongTien;
        lblTongTienSauKhiGiam.setText(lblTongTien.getText());              
    }
    private Double tongTienDV() {
        Double total = 0.0;
        for (int i = 0; i < tblDichVu.getRowCount(); i++) {
            Double amount = (Double) tblDichVu.getValueAt(i, 3);
            total += amount;
        }
        return total;
    }
    
    private Double tongTienBanDau(Double tienDV, Double tienP, float thue) {
        Double total = 0.0;    
        total = (tienDV + tienP)+(tienDV + tienP) * (thue / 100);        
        return total;

    }
    
    private boolean kiemTraDuLieu() {
        String tienKhachDuaKT =txtTienKhachDua.getText().trim();
        if (tienKhachDuaKT.length() > 0  || tienKhachDuaKT.length() == 0) {
            try {
                Double tien = Double.parseDouble(tienKhachDuaKT);
		if(tien < tienSauKhiGiamGia){
                    JOptionPane.showMessageDialog(this,  "Error: Tiền khách đưa phải > hơn 0! và phải lớn hơn tiền sau khi giảm" );
                    txtTienKhachDua.requestFocus();
                    return false;
                }
            } catch (NumberFormatException ex) {
		JOptionPane.showMessageDialog(this,  "Error: Tiền khách đưa không được để trống!" );
                txtTienKhachDua.requestFocus();
                return false;
            }
	}
        return true;
    }

    private void tinhTienGiamGia(float giamGia) {
        DecimalFormat dfTongTien = new DecimalFormat("##,000 VNĐ");
        tienSauKhiGiamGia = tongTien - tongTien * (giamGia / 100);
        lblVND.setVisible(false);
        lblTongTienSauKhiGiam.setText(dfTongTien.format(tienSauKhiGiamGia));
    }

    private boolean kiemTraDuLieuTienNhap() {
        String tienKhachD = txtTienKhachDua.getText().trim();
       if (tienKhachD.length() > 0 ) {
            try {
                Double tien = Double.parseDouble(tienKhachD);
		if (tien < 0 || tien < tienSauKhiGiamGia) {
                    JOptionPane.showMessageDialog(this, "Error:Tiền khách đưa phải lớn hơn không và phải lớn hơn tiền trả khách" , "Thông báo", JOptionPane.WARNING_MESSAGE);                
                    txtTienKhachDua.requestFocus();
                    return false;
		}
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: Tiền khách đư phải nhập số !" , "Thông báo", JOptionPane.WARNING_MESSAGE);                
                txtTienKhachDua.requestFocus();
                return false;
            }
	}
        return true;
    }

    
}
