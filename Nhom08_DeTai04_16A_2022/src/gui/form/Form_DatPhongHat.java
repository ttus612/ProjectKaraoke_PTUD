package gui.form;

import dao.NhanVienDao;
import dao.Dao_ChiTietDichVu;
import dao.Dao_ChiTietHoaDon;
import dao.Dao_DatPhong;
import dao.Dao_DichVu;
import dao.Dao_HoaDon;
import dao.Dao_KhachHang;
import dao.Dao_LoaiPhong;
import dao.Dao_PhieuDat;
import dao.Dao_Phong;
import entity.ChiTietDichVu;
import entity.ChiTietHoaDon;
import entity.DichVu;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;
import entity.TrangThaiPhong;
import gui.event.EventItem;
import gui.model.ModelItem;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.lang.invoke.MethodHandles;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

/**
 *
 * @author THANHTU
 */
public class Form_DatPhongHat extends javax.swing.JPanel {

    public static Dao_Phong phong_dao = new Dao_Phong();
    public static Dao_PhieuDat dao_PhieuDat = new Dao_PhieuDat();
    public static Dao_KhachHang dao_KhachHang = new Dao_KhachHang();
    private Dao_ChiTietHoaDon dao_ChiTietHoaDon = new Dao_ChiTietHoaDon();
    public static Dao_HoaDon dao_HoaDon = new Dao_HoaDon();
    private Dao_LoaiPhong dao_LoaiPhong = new Dao_LoaiPhong();
    private Dao_DatPhong dao_DatPhong = new Dao_DatPhong();
    private NhanVienDao dao_NhanVien = new NhanVienDao();
    private Dao_ChiTietDichVu dao_ChiTietDichVu = new Dao_ChiTietDichVu();
    private Dao_DichVu dao_DichVu = new Dao_DichVu();

    public static Form_DSDatPhong home;
    public static Animator animator;
    public static Point animatePoint;
    public static ModelItem itemSelected;
    public static ArrayList<Phong> dsPhong;
    private Set<String> sdt;
    private LocalDate now;
    private Date dNow;

    private int nowHours;
    private int nowMinutes;
    private DecimalFormat dftxtPhut;
    private DecimalFormat dftxtGio;
    private KhachHang khachHang;
    private String maNVDangNhap;
    private int nowSecond;
    private DecimalFormat dftxtGiay;
    private Calendar timeNow2;
    private int hourNow;
    private int minNow;
    private int nowHours2;
    private int nowMinutes2;
    private int nowSecond2;

    public Form_DatPhongHat(String maNV) {
        initComponents();
        init();
        loadDuLieuGio();
        loadDuLieuPhut();
        layNgayHienTai();
        layGioHienTai();
        maNVDangNhap = maNV;
        
        animator = PropertySetter.createAnimator(500, mainPanel, "imageLocation", animatePoint, mainPanel.getTargetLocation());
        animator.addTarget(new PropertySetter(mainPanel, "imageSize", new Dimension(180, 120), mainPanel.getTargetSize()));
        animator.addTarget(new TimingTargetAdapter() {
            @Override
            public void end() {
                mainPanel.setImageOld(null);
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
    }

    private void init() {
        home = new Form_DSDatPhong();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(home);
        testData();
    }

    public static void testData() {
        home.setEvent(new EventItem() {
            @Override
            public void itemClick(Component com, ModelItem item) {
                System.out.println(item.getItemID());
                home.setSelected(com);
                home.showItem(item);
                if (itemSelected != null) {
                    mainPanel.setImageOld(itemSelected.getImage());
                }
                if (itemSelected != item) {
                    if (!animator.isRunning()) {
                        itemSelected = item;
                        animatePoint = getLocationOf(com);
//                        animatePoint = new Point(500,500);
                        mainPanel.setImage(item.getImage());
                        mainPanel.setImageLocation(animatePoint);
                        mainPanel.setImageSize(new Dimension(180, 120));
                        mainPanel.repaint();
                        home.setSelected(com);
                        home.showItem(item);
                        animator.start();
                    }
                }
            }
        });
        dsPhong = phong_dao.getAllPhongvaLoaiPhong();
        themDuLieuPhongVaoBang(dsPhong);
    }

    public static Point getLocationOf(Component com) {
        Point p = home.getPanelItemLocation();
        int x = p.x;
        int y = p.y;
        int itemX = com.getX();
        int itemY = com.getY();
        int left = 10;
        int top = 35;
        return new Point(x + itemX + left, y + itemY + top);
    }

    public static void themDuLieuPhongVaoBang(ArrayList<Phong> listP) {
        int ID = 1;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date ngayHienTai = Date.valueOf(LocalDate.now().format(dtf));

        DateTimeFormatter gio = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
        Timestamp gioMoCua = Timestamp.valueOf(LocalDateTime.now().format(gio));

        for (Phong phong : listP) {
            String maP = phong.getMaPhong();
            LoaiPhong maLoai = phong.getLoaiPhong();
            TrangThaiPhong maTT = phong.getTrangThaiPhong();
            String sucChua = null;
            String trangThai = null;
            String tenKH = null;
            int luotCho = phong.getLuotCho();

            if (maLoai.getMaLoaiPhong().equals("PL")) {
                sucChua = "Sức chứa: 15 đến 20 người";
            } else if (maLoai.getMaLoaiPhong().equals("PV")) {
                sucChua = "Sức chứa: 10 đến 15 người";
            } else if (maLoai.getMaLoaiPhong().equals("PN")) {
                sucChua = "Sức chứa: 01 dến 05 người";
            } else if (maLoai.getMaLoaiPhong().equals("VIP")) {
                sucChua = "Sức chứa: 20 người trở lên";
            }
            if (maTT.getMaTrangThaiPhong().equals("PT")) {
                PhieuDatPhong phieu = dao_PhieuDat.getPhieuDatPhongTheoNgayNhanVaTheoMa(maP, gioMoCua);
                if (phieu != null) {
                    phong_dao.capNhatTrangThaiPhong(phieu.getPhong().getMaPhong(), "PC");
                    trangThai = "/image/img/phongCho.png";
                } else {
                    trangThai = "/image/img/phongTrong.png";
                    if (maLoai.getMaLoaiPhong().equals("VIP")) {
                        trangThai = "/image/img/phongTrong_VIP.png";
                    }
                    tenKH = null;
                }
            } else if (maTT.getMaTrangThaiPhong().equals("PC")) {
                PhieuDatPhong phieu = dao_PhieuDat.getPhieuDatPhongTheoNgayNhanVaTheoMa(maP, gioMoCua);
                trangThai = "/image/img/phongCho.png";
                if (maLoai.getMaLoaiPhong().equals("VIP")) {
                    trangThai = "/image/img/phongCho_VIP.png";
                }

                KhachHang kh2 = dao_KhachHang.getKhachHangTheoMa(phieu.getKhachHang().getMaKhachHang());
                tenKH = kh2.getHoTenKhachHang();

            } else if (maTT.getMaTrangThaiPhong().equals("SD")) {
                trangThai = "/image/img/phongDangHoatDong.png";
                if (maLoai.getMaLoaiPhong().equals("VIP")) {
                    trangThai = "/image/img/phongDangHoatDong_VIP.png";
                }

                HoaDon hoaDon = dao_HoaDon.timHoaDonTheoNgayVaTheoPhong(ngayHienTai, maP);
                KhachHang kh3 = dao_KhachHang.getKhachHangTheoMa(hoaDon.getKhachHang().getMaKhachHang());
                tenKH = kh3.getHoTenKhachHang();
            }
//            home.addItem(new ModelItem(ID++, "Phòng: "+phong.getMaPhong(), sucChua, maLoai.getGiaTien(), maLoai.getMaLoaiPhong(), new ImageIcon(getClass().getResource(trangThai)), tenKH));           
            home.addItem(new ModelItem(ID++, phong.getMaPhong(), sucChua, maLoai.getGiaTien(), maLoai.getMaLoaiPhong(), new ImageIcon(MethodHandles.lookup().lookupClass().getResource(trangThai)), tenKH, luotCho));

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new gui.swing.Background();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnTimPhongDangSD = new javax.swing.JButton();
        btnTimPhongCho = new javax.swing.JButton();
        btnTimPhongTrong = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtPhongSo = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbbLoaiPhong = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtSoNguoi = new javax.swing.JTextField();
        btnHienTatCaPhong = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        mainPanel = new gui.swing.MainPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtSoDienThoaiKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JLabel();
        btnThemKH = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        chooserDay = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        cbbGio = new javax.swing.JComboBox<>();
        cbbPhut = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnLamMoiThongTinDatPhong = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtSoNguoiDeLuu = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        btnDatPhongCho = new javax.swing.JButton();
        btnDatPhong = new javax.swing.JButton();
        btnHuyPhong = new javax.swing.JButton();
        btnNhanPhong = new javax.swing.JButton();
        btnChuyenPhong = new javax.swing.JButton();
        btnDanhSachHd = new javax.swing.JButton();

        setOpaque(false);

        jPanel6.setBackground(new java.awt.Color(204, 153, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(121, 87, 142));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/phongHat.png"))); // NOI18N
        jLabel2.setText("Quản lí phòng hát");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc theo trạng thái phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(121, 87, 142));
        jPanel3.setOpaque(false);

        btnTimPhongDangSD.setBackground(new java.awt.Color(153, 255, 0));
        btnTimPhongDangSD.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnTimPhongDangSD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/phongDangHoatDong.png"))); // NOI18N
        btnTimPhongDangSD.setText("Phòng đang sử dụng");
        btnTimPhongDangSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimPhongDangSDActionPerformed(evt);
            }
        });

        btnTimPhongCho.setBackground(new java.awt.Color(255, 255, 51));
        btnTimPhongCho.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnTimPhongCho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/phongCho.png"))); // NOI18N
        btnTimPhongCho.setText("Phòng chờ");
        btnTimPhongCho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimPhongChoActionPerformed(evt);
            }
        });

        btnTimPhongTrong.setBackground(new java.awt.Color(111, 231, 239));
        btnTimPhongTrong.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnTimPhongTrong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/phongTrong.png"))); // NOI18N
        btnTimPhongTrong.setText("Phòng trống");
        btnTimPhongTrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimPhongTrongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimPhongDangSD, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                    .addComponent(btnTimPhongTrong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTimPhongCho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTimPhongDangSD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimPhongCho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimPhongTrong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(121, 87, 142));
        jPanel5.setOpaque(false);

        jPanel7.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Phòng số:");

        txtPhongSo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addComponent(txtPhongSo)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addComponent(txtPhongSo))
                .addGap(0, 0, 0))
        );

        jPanel9.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Loại phòng:");

        cbbLoaiPhong.addItem("All");
        ArrayList<LoaiPhong> dsLoaiPhong = dao_LoaiPhong.getDanhSachLoaiPhong();
        for(LoaiPhong item : dsLoaiPhong){
            cbbLoaiPhong.addItem(item.getTenLoai());
        }
        cbbLoaiPhong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbbLoaiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbLoaiPhong, 0, 170, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addComponent(cbbLoaiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel10.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Số người:");

        txtSoNguoi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(27, 27, 27)
                .addComponent(txtSoNguoi)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(txtSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel8)
        );

        btnHienTatCaPhong.setBackground(new java.awt.Color(177, 100, 252));
        btnHienTatCaPhong.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnHienTatCaPhong.setForeground(new java.awt.Color(255, 255, 255));
        btnHienTatCaPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/search.png"))); // NOI18N
        btnHienTatCaPhong.setText("Hiện tất cả phòng");
        btnHienTatCaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienTatCaPhongActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(177, 100, 252));
        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/reset.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnTim.setBackground(new java.awt.Color(177, 100, 252));
        btnTim.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnTim.setForeground(new java.awt.Color(255, 255, 255));
        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/search.png"))); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHienTatCaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(btnTim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLamMoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHienTatCaPhong)
                .addGap(27, 27, 27))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ghi chú", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N
        jPanel8.setForeground(new java.awt.Color(121, 87, 142));
        jPanel8.setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/phongTrong.png"))); // NOI18N
        jLabel1.setText("Phòng trống");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/phongCho.png"))); // NOI18N
        jLabel3.setText("Phòng chờ");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/phongDangHoatDong.png"))); // NOI18N
        jLabel4.setText("Phòng đang sử dụng");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/vip.png"))); // NOI18N
        jLabel5.setText("Phòng VIP");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addComponent(jLabel4)
                .addComponent(jLabel5))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phòng hát", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N
        jPanel1.setOpaque(false);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng cần đặt", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N
        jPanel11.setOpaque(false);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("Số điện thoại:");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Tên khách hàng:");

        txtSoDienThoaiKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtSoDienThoaiKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiKHActionPerformed(evt);
            }
        });
        txtSoDienThoaiKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoDienThoaiKHKeyReleased(evt);
            }
        });

        txtTenKH.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        btnThemKH.setBackground(new java.awt.Color(255, 0, 51));
        btnThemKH.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/add.png"))); // NOI18N
        btnThemKH.setText("Thêm nhanh khách hàng");
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setText("Mã khách hàng:");

        txtMaKH.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setText("Thời gian đến:");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setText("Ngày đến:");

        chooserDay.setDateFormatString("dd/MM/yyyy");
        chooserDay.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        chooserDay.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText(":");

        cbbGio.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        cbbPhut.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("giờ");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("phút");

        btnLamMoiThongTinDatPhong.setBackground(new java.awt.Color(177, 100, 252));
        btnLamMoiThongTinDatPhong.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLamMoiThongTinDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/reset.png"))); // NOI18N
        btnLamMoiThongTinDatPhong.setText("Làm mới");
        btnLamMoiThongTinDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiThongTinDatPhongActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Nhập số người:");

        txtSoNguoiDeLuu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtSoNguoiDeLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoNguoiDeLuuActionPerformed(evt);
            }
        });
        txtSoNguoiDeLuu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoNguoiDeLuuKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemKH, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addComponent(btnLamMoiThongTinDatPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(cbbGio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbPhut, 0, 83, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addComponent(chooserDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoDienThoaiKH)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoNguoiDeLuu)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSoDienThoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(txtSoNguoiDeLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(chooserDay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbGio, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel20)
                        .addComponent(jLabel9)
                        .addComponent(jLabel11))
                    .addComponent(cbbPhut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLamMoiThongTinDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Các chức năng ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N
        jPanel12.setOpaque(false);

        btnDatPhongCho.setBackground(new java.awt.Color(177, 100, 252));
        btnDatPhongCho.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDatPhongCho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/datPhongCho.png"))); // NOI18N
        btnDatPhongCho.setText("Đặt phòng chờ");
        btnDatPhongCho.setToolTipText("Chức năng đặt phòng chờ");
        btnDatPhongCho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatPhongChoActionPerformed(evt);
            }
        });

        btnDatPhong.setBackground(new java.awt.Color(177, 100, 252));
        btnDatPhong.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/datPhong.png"))); // NOI18N
        btnDatPhong.setText("Đặt phòng");
        btnDatPhong.setToolTipText("Chức năng đặt phòng");
        btnDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatPhongActionPerformed(evt);
            }
        });

        btnHuyPhong.setBackground(new java.awt.Color(177, 100, 252));
        btnHuyPhong.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnHuyPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/huyPhongCho.png"))); // NOI18N
        btnHuyPhong.setText("Hủy phòng");
        btnHuyPhong.setToolTipText("Chức năng đặt phòng");
        btnHuyPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyPhongActionPerformed(evt);
            }
        });

        btnNhanPhong.setBackground(new java.awt.Color(177, 100, 252));
        btnNhanPhong.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnNhanPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/datPhong.png"))); // NOI18N
        btnNhanPhong.setText("Nhận phòng");
        btnNhanPhong.setToolTipText("Chức năng nhận phòng");
        btnNhanPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanPhongActionPerformed(evt);
            }
        });

        btnChuyenPhong.setBackground(new java.awt.Color(177, 100, 252));
        btnChuyenPhong.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnChuyenPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/chuyenPhong.png"))); // NOI18N
        btnChuyenPhong.setText("Chuyển phòng");
        btnChuyenPhong.setToolTipText("Chức năng chuyển phòng");
        btnChuyenPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenPhongActionPerformed(evt);
            }
        });

        btnDanhSachHd.setBackground(new java.awt.Color(177, 100, 252));
        btnDanhSachHd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDanhSachHd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/hoaDon.png"))); // NOI18N
        btnDanhSachHd.setText("Danh sách hóa đơn chưa thanh toán");
        btnDanhSachHd.setToolTipText("Chức năng thanh toán nhiều hóa đơn");
        btnDanhSachHd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhSachHdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDanhSachHd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHuyPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDatPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDatPhongCho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addComponent(btnNhanPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChuyenPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDatPhongCho, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHuyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnChuyenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDanhSachHd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(background1Layout.createSequentialGroup()
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(background1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background1Layout.createSequentialGroup()
                        .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(background1Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimPhongDangSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimPhongDangSDActionPerformed
        if (txtPhongSo.getText().trim().length() <= 0 && txtSoNguoi.getText().trim().length() <= 0) {
            ArrayList<Phong> phongs = phong_dao.timPhongTheoTrangThai("SD");
            home.removeAllItem();
            themDuLieuPhongVaoBang(phongs);
        } else if (txtPhongSo.getText().trim().length() <= 0 && txtSoNguoi.getText().trim().length() > 0) {
            ArrayList<Phong> phongs = phong_dao.timPhongTheoTrangThaiVaSoNguoi("SD", Integer.parseInt(txtSoNguoi.getText()));
            home.removeAllItem();
            themDuLieuPhongVaoBang(phongs);
        }
    }//GEN-LAST:event_btnTimPhongDangSDActionPerformed

    private void btnTimPhongChoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimPhongChoActionPerformed
        if (txtPhongSo.getText().trim().length() <= 0 && txtSoNguoi.getText().trim().length() <= 0) {
            ArrayList<Phong> phongs = phong_dao.timPhongTheoTrangThai("PC");
            home.removeAllItem();
            themDuLieuPhongVaoBang(phongs);
        } else if (txtPhongSo.getText().trim().length() <= 0 && txtSoNguoi.getText().trim().length() > 0) {
            ArrayList<Phong> phongs = phong_dao.timPhongTheoTrangThaiVaSoNguoi("PC", Integer.parseInt(txtSoNguoi.getText()));
            home.removeAllItem();
            themDuLieuPhongVaoBang(phongs);
        }
    }//GEN-LAST:event_btnTimPhongChoActionPerformed

    private void btnHienTatCaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienTatCaPhongActionPerformed
        home.removeAllItem();
        testData();
    }//GEN-LAST:event_btnHienTatCaPhongActionPerformed

    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        Form_ThemNhanhKhachHang frm_ThemNhanhKhachHang = new Form_ThemNhanhKhachHang(maNVDangNhap);
        frm_ThemNhanhKhachHang.setVisible(true);
        frm_ThemNhanhKhachHang.setData(txtSoDienThoaiKH.getText());

    }//GEN-LAST:event_btnThemKHActionPerformed

    private void btnDatPhongChoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatPhongChoActionPerformed
      if (kiemTraSoL()) {
        SimpleDateFormat ngay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter ngayGio = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        DateTimeFormatter gio = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
        DateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date ngayNhanPhong = chooserDay.getDate();
        LocalDate localDate2 = Instant.ofEpochMilli(ngayNhanPhong.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

        ngayNhanPhong.setHours(Integer.parseInt(cbbGio.getSelectedItem().toString()));
        ngayNhanPhong.setMinutes(Integer.parseInt(cbbPhut.getSelectedItem().toString()));
        if (chooserDay.getDate() != null) {
            Timestamp cach30Phut = dao_PhieuDat.cachHienTai30Phut(Timestamp.valueOf(LocalDateTime.now().format(ngayGio)));
            if (ngayNhanPhong.after(cach30Phut)) {
                if (itemSelected == null) {
                    JOptionPane.showConfirmDialog(null, "Chọn phòng muốn đặt", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
                } else {
                    if (txtTenKH.getText().trim().length() > 0) {
                        String maPhong = itemSelected.getItemName();
                        Phong p = phong_dao.timPhongTheoMa(maPhong);
                        PhieuDatPhong phieuDatPhongs = dao_PhieuDat.getPhieuDatPhongTheoNgayNhanVaTheoMa(maPhong, Timestamp.valueOf(ngay.format(ngayNhanPhong)));
                        if (phieuDatPhongs==null) {
//                        if (p.getTrangThaiPhong().getMaTrangThaiPhong().equals("PC")) {
//                            JOptionPane.showConfirmDialog(null, "Phòng đẫ được đặt làm phòng chờ vui lòng chọn phòng khác", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
//                        } else if (p.getTrangThaiPhong().getMaTrangThaiPhong().equals("SD")) {
//                            JOptionPane.showConfirmDialog(null, "Phòng đẫ được đặt vui lòng chọn phòng khác", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
//                        } else {
                            String nhanVien = maNVDangNhap;
                            String maPhieu = dao_PhieuDat.getMaPhieuDatPhong();
                            //  System.out.println(LocalDateTime.now().format(ngayGio));
                            if (txtSoNguoiDeLuu.getText().trim().length() <= 0) {
                                JOptionPane.showConfirmDialog(null, "Nhập số người", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
                                txtSoNguoiDeLuu.setFocusable(true);
                            } else {
                                if(kiemTraSLKhachDatPhongCho(Integer.parseInt(txtSoNguoiDeLuu.getText()), itemSelected.getLoaiPhong())){
                                    PhieuDatPhong phieuDatPhong = new PhieuDatPhong(maPhieu, new Phong(maPhong), new NhanVien(nhanVien),
                                        khachHang, "null", Timestamp.valueOf(LocalDateTime.now().format(ngayGio)),
                                        Timestamp.valueOf(ngay.format(ngayNhanPhong)),
                                        Integer.parseInt(txtSoNguoiDeLuu.getText()));

                                boolean rs = dao_PhieuDat.taoPhieuDatPhong(phieuDatPhong);
                                if (rs) {
                                    int select = JOptionPane.showConfirmDialog(null, "Đặt phòng chờ thành công",
                                            "Thông báo", JOptionPane.OK_OPTION);
                                    if (LocalDate.now().toString().equals(sdt.format(ngayNhanPhong))) {
                                       
                                        phong_dao.capNhatTrangThaiPhong(maPhong, "PC");
                                    }
                                    phong_dao.tangLuotCho(maPhong);
                                    Form_ChiTietPhong frm_ChiTietPhong = new Form_ChiTietPhong();
                                    frm_ChiTietPhong.setVisible(true);
                                    frm_ChiTietPhong.setDataDatPhongCho(maPhong, maPhieu);
                                    home.removeAllItem();
                                    testData();

                                } else {
                                    JOptionPane.showConfirmDialog(null, "Đặt phòng chờ không thành công", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
                                }
                                }
                              
                            }
                        }
                        else{
                            JOptionPane.showConfirmDialog(null, "Phòng "+maPhong+" đã có người đặt vào ngày "+ new SimpleDateFormat("dd/MM/yyyy").format(phieuDatPhongs.getThoiGianNhanPhong()), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        }

                        //  }
                    } else {
                        JOptionPane.showConfirmDialog(null, "Nhập thông tin khách hàng", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
                        txtSoDienThoaiKH.setFocusable(true);
                    }
                }
            } else {
                JOptionPane.showConfirmDialog(null, "Ngày nhận phòng phải cách giờ hiện tại ít nhất 30 phút", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
            }
        }
      }
    }//GEN-LAST:event_btnDatPhongChoActionPerformed

    private void btnDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatPhongActionPerformed
        SimpleDateFormat dfNgay = new SimpleDateFormat("dd/MM/yyyy");
        if (chooserDay.getDate() != null) {
            //Ngày đặt(đặt trực tiếp)
            LocalDate localNow = LocalDate.now();
     
            //Ngày hiện tại
            Calendar dateNow = Calendar.getInstance();
            hourNow =  dateNow.get(Calendar.HOUR_OF_DAY);
            minNow =  dateNow.get(Calendar.MINUTE);
           
            if (localNow.equals(dNow.toLocalDate())) {
                  kiemTraThongTinKhachHang();
//                if (gioDat > hourNow) {
//                    //kiểm tra thông tin khách hàng
//                    kiemTraThongTinKhachHang();
//                }
//                if (gioDat == hourNow && phutDat >= minNow) {
//                    kiemTraThongTinKhachHang();
//                }
//                if (gioDat < hourNow || (gioDat == hourNow && phutDat < minNow)) {
//                    JOptionPane.showMessageDialog(this, "Giờ đến phải được đặt sau hoặc ngay giờ hiện tại! \nGiờ hiện tại là: " + dfHienGio.format(dateNow), "Thông báo", JOptionPane.WARNING_MESSAGE);
//                }
            } else {
                JOptionPane.showMessageDialog(this, "Ngày đến phải đặt trong ngày hôm nay! \nNgày hôm nay là: " + dfNgay.format(dateNow), "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập và chọn thông tin đầy đủ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDatPhongActionPerformed

    private void btnHuyPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyPhongActionPerformed
        if (itemSelected != null) {
            String maP = itemSelected.getItemName();
            Phong phong = phong_dao.timPhongTheoMa(maP);
            String tt = phong.getTrangThaiPhong().getMaTrangThaiPhong();

            if (tt.equals("PT")) {
                JOptionPane.showMessageDialog(this, "Phòng " + maP + " hiện đang trống nên không cần hủy !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (tt.equals("PC")) {
                int select = JOptionPane.showConfirmDialog(null, "Phòng  " + maP + " đang đã được đặt trước bạn chắc chắn muốn hủy phòng này !", "Thông báo", JOptionPane.OK_OPTION);
                if (select == JOptionPane.OK_OPTION) {
                    phong_dao.capNhatTrangThaiPhongKhiHuy(maP);
                    DateTimeFormatter gio = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
                    Timestamp gioMoCua = Timestamp.valueOf(LocalDateTime.now().format(gio));
                    PhieuDatPhong pdp = dao_PhieuDat.getPhieuDatPhongTheoNgayVaTheoMa(maP, gioMoCua);
                    String maPDP = pdp.getMaPhieuDatPhong();
                    dao_PhieuDat.xoaPhieuDatPhongKhiHuyPhong(maPDP);
                    home.removeAllItem();
                    testData();
                    JOptionPane.showMessageDialog(this, "Phòng chờ được hủy thành công(Phiếu đặt phòng" + maPDP + " đã được xóa) !", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            } else if (tt.equals("SD")) {
                ChiTietHoaDon cthd = dao_ChiTietHoaDon.timChiTietHDTheoMaHDDeHuyHD(maP);
                String maHD = cthd.getHoaDon().getMaHoaDon();
                int select = JOptionPane.showConfirmDialog(null, "Phòng " + maP + " đang sử dụng bạn chắc chắn hủy phòng này !", "Thông báo", JOptionPane.OK_OPTION);
                if (select == JOptionPane.OK_OPTION) {
                    phong_dao.capNhatTrangThaiPhongKhiHuy(maP);
                    dao_ChiTietDichVu.xoaChiTietDichVuKhiHuyPhong(maHD);
                    dao_ChiTietHoaDon.xoaChiTietHoaDonKhiHuyPhong(maHD);
                    dao_HoaDon.xoaHoaDonKhiHuyPhong(maHD);
                    home.removeAllItem();
                    testData();
                    JOptionPane.showMessageDialog(this, "Phòng được hủy thành công(Hóa đơn " + maHD + " đã được xóa) !", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng cần hủy !", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnHuyPhongActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        if (txtPhongSo.getText().trim().length() > 0) {
            ArrayList<Phong> phongs = phong_dao.timPhongTheoMaPhong(txtPhongSo.getText());
            home.removeAllItem();
            themDuLieuPhongVaoBang(phongs);
        } else if (txtSoNguoi.getText().trim().length() > 0 && txtPhongSo.getText().trim().length() <= 0) {
            ArrayList<Phong> phongs = phong_dao.timPhongTheoSoNguoi(Integer.parseInt(txtSoNguoi.getText()));
            home.removeAllItem();
            themDuLieuPhongVaoBang(phongs);
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnTimPhongTrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimPhongTrongActionPerformed
        if (txtPhongSo.getText().trim().length() <= 0 && txtSoNguoi.getText().trim().length() <= 0) {
            ArrayList<Phong> phongs = phong_dao.timPhongTheoTrangThai("PT");
            home.removeAllItem();
            themDuLieuPhongVaoBang(phongs);
        } else if (txtPhongSo.getText().trim().length() <= 0 && txtSoNguoi.getText().trim().length() > 0) {
            ArrayList<Phong> phongs = phong_dao.timPhongTheoTrangThaiVaSoNguoi("PT", Integer.parseInt(txtSoNguoi.getText()));
            home.removeAllItem();
            themDuLieuPhongVaoBang(phongs);
        }
    }//GEN-LAST:event_btnTimPhongTrongActionPerformed

    private void cbbLoaiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiPhongActionPerformed
        if (txtPhongSo.getText().trim().length() <= 0 && txtPhongSo.getText().trim().length() <= 0) {
            timPhongTheoLoai(cbbLoaiPhong.getSelectedItem().toString());
        } else if (txtSoNguoi.getText().trim().length() > 0) {

        }
    }//GEN-LAST:event_cbbLoaiPhongActionPerformed

    private void txtSoDienThoaiKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDienThoaiKHActionPerformed
        if (txtSoDienThoaiKH.getText().trim().length() ==10) {
            khachHang = dao_KhachHang.getKhachHangTheoSDT(txtSoDienThoaiKH.getText());
            if (khachHang != null) {
                txtMaKH.setText(khachHang.getMaKhachHang());
                txtTenKH.setText(khachHang.getHoTenKhachHang());
            } else {
                JOptionPane.showConfirmDialog(null, "Khách hàng không tồn tại. Yêu cầu thêm mới khách hàng", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
            }
        }
        else{
            JOptionPane.showConfirmDialog(null, "Số điện thoại tối đa 10 ký tự", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }
    }//GEN-LAST:event_txtSoDienThoaiKHActionPerformed

    private void txtSoDienThoaiKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoDienThoaiKHKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {

        } else {
            getSoDienThoai();
            String to_check = txtSoDienThoaiKH.getText();
            int to_check_len = to_check.length();
            for (String data : sdt) {
                String check_from_data = "";
                for (int i = 0; i < to_check_len; i++) {
                    if (to_check_len <= data.length()) {
                        check_from_data = check_from_data + data.charAt(i);
                    }
                }
                if (check_from_data.equals(to_check)) {
                    txtSoDienThoaiKH.setText(data);
                    txtSoDienThoaiKH.setSelectionStart(to_check_len);
                    txtSoDienThoaiKH.setSelectionEnd(data.length());
                    break;
                }
            }
        }
    }//GEN-LAST:event_txtSoDienThoaiKHKeyReleased

    private void btnLamMoiThongTinDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiThongTinDatPhongActionPerformed
        txtMaKH.setText("");
        txtSoDienThoaiKH.setText("");
        txtTenKH.setText("");
        txtSoNguoiDeLuu.setText("");
        loadDuLieuGio();
        loadDuLieuPhut();
        layNgayHienTai();
        layGioHienTai();
    }//GEN-LAST:event_btnLamMoiThongTinDatPhongActionPerformed

    private void btnNhanPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanPhongActionPerformed
        String maP = itemSelected.getItemName();
        if (phong_dao.timPhongTheoMa(maP).getTrangThaiPhong().getMaTrangThaiPhong().equals("PC")) {
            DateTimeFormatter gio = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
            Timestamp gioMoCua = Timestamp.valueOf(LocalDateTime.now().format(gio));

            SimpleDateFormat sdt = new SimpleDateFormat("HH:mm a");
            if (txtMaKH.getText().trim().length() <= 0) {
                JOptionPane.showConfirmDialog(null, "Nhập thông tin khách đặt phòng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                PhieuDatPhong pdp = dao_PhieuDat.getPhieuDatPhongTheoNgayNhanVaTheoMaPhongVaKhachHang(itemSelected.getItemName(), txtMaKH.getText(), gioMoCua);          
                NhanVien nhanVien = pdp.getNhanVien();
                KhachHang kh = dao_KhachHang.getKhachHangTheoMa(pdp.getKhachHang().getMaKhachHang());
                //KhachHang kh = pdp.getKhachHang();
                Phong phong = pdp.getPhong();
                String maHD = dao_DatPhong.taoMaHoaDonTuDong();
                
                
                timeNow2 = Calendar.getInstance();
                nowHours2 = timeNow2.get(Calendar.HOUR_OF_DAY);
                nowMinutes2 = timeNow2.get(Calendar.MINUTE);
                nowSecond2 = timeNow2.get(Calendar.SECOND);
                                    

                int gio2 = nowHours2;
                int phut2 = nowMinutes2;
                int giay2 = nowSecond2;

                LocalTime gioKetThuc  = LocalTime.of(gio2, phut2, giay2);
                
                HoaDon hoaDon = new HoaDon(maHD, nhanVien, kh, dNow, gioKetThuc, gioKetThuc, 0, 0, 0, 0, false);

//                HoaDon hoaDon = new HoaDon(maHD, nhanVien, kh, dNow, Time.valueOf(LocalTime.now()), null, 0, 0, 0, 0, false);
                dao_HoaDon.addHoaDON(hoaDon);

                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(hoaDon, phong, 0);
                dao_ChiTietHoaDon.addChiTietHoaDON(chiTietHoaDon);

                String maDichVu = "DV001";//Dịch vụ mặc định
                DichVu dv = dao_DichVu.timDichVuTheoMa(maDichVu);
                ChiTietDichVu ctdv = new ChiTietDichVu(dv, hoaDon, 6);
                dao_ChiTietDichVu.addChiTietDichVu(ctdv);

               
                dao_PhieuDat.xoaPhieuDatPhongKhiHuyPhong(pdp.getMaPhieuDatPhong());
                dao_DatPhong.capnhatTrangThaiPhong(itemSelected.getItemName(), "SD");
               
                phong_dao.giamLuotCho(maP);

                home.removeAllItem();
                testData();
                JOptionPane.showConfirmDialog(null, "Nhận phòng thành công", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
                Form_ChiTietPhong form_ChiTietPhong = new Form_ChiTietPhong();
                form_ChiTietPhong.setVisible(true);
                form_ChiTietPhong.setEditDataDatPhong(kh, maP, maHD);

            }

        } else {
            JOptionPane.showConfirmDialog(null, "Phòng phải trong trạng thái chờ", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        }

    }//GEN-LAST:event_btnNhanPhongActionPerformed

    private void btnChuyenPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenPhongActionPerformed
        if (itemSelected != null) {
            String maP = itemSelected.getItemName();
            Phong phong = phong_dao.timPhongTheoMa(maP);
            String tt = phong.getTrangThaiPhong().getMaTrangThaiPhong();

            if (tt.equals("PT")) {
                JOptionPane.showMessageDialog(this, "Phòng " + maP + " hiện đang trống  !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (tt.equals("PC")) {
                DateTimeFormatter gio = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
                Timestamp gioMoCua = Timestamp.valueOf(LocalDateTime.now().format(gio));
                PhieuDatPhong pdp = dao_PhieuDat.getPhieuDatPhongTheoNgayVaTheoMa(maP, gioMoCua);
                String maPDP = pdp.getMaPhieuDatPhong();
                int select = JOptionPane.showConfirmDialog(null, "Phòng  " + maP + " đang đã được đặt trước bạn chắc chắn muốn chuyển phòng này !", "Thông báo", JOptionPane.OK_OPTION);
                if (select == JOptionPane.OK_OPTION) {
                    Form_ChuyenPhong frm = new Form_ChuyenPhong();
                    frm.setEditDataChuyenPhongPC(maPDP, maP, tt);
                    frm.setVisible(true);
                    home.removeAllItem();
                    testData();
                }
            } else if (tt.equals("SD")) {
                ChiTietHoaDon cthd = dao_ChiTietHoaDon.timChiTietHDTheoMaHDDeHuyHD(maP);
                String maHD = cthd.getHoaDon().getMaHoaDon();
                int select = JOptionPane.showConfirmDialog(null, "Phòng " + maP + " đang sử dụng bạn chắc chắn chuyển phòng này !", "Thông báo", JOptionPane.OK_OPTION);
                if (select == JOptionPane.OK_OPTION) {
                    Form_ChuyenPhong frm = new Form_ChuyenPhong();
                    frm.setEditDataChuyenPhongSD(maHD, maP, tt);
                    frm.setVisible(true);
                    home.removeAllItem();
                    testData();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng cần  chuyển !", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnChuyenPhongActionPerformed

    private void txtSoNguoiDeLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoNguoiDeLuuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoNguoiDeLuuActionPerformed

    private void txtSoNguoiDeLuuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNguoiDeLuuKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoNguoiDeLuuKeyReleased

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtPhongSo.setText("");
        txtSoNguoi.setText("");
        cbbLoaiPhong.setSelectedIndex(0);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnDanhSachHdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhSachHdActionPerformed
        Form_DanhSachHoaDonChuaThanhToan frm = new Form_DanhSachHoaDonChuaThanhToan();
        frm.setVisible(true);            
    }//GEN-LAST:event_btnDanhSachHdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.Background background1;
    private javax.swing.JButton btnChuyenPhong;
    private javax.swing.JButton btnDanhSachHd;
    private javax.swing.JButton btnDatPhong;
    private javax.swing.JButton btnDatPhongCho;
    private javax.swing.JButton btnHienTatCaPhong;
    private javax.swing.JButton btnHuyPhong;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLamMoiThongTinDatPhong;
    private javax.swing.JButton btnNhanPhong;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnTimPhongCho;
    private javax.swing.JButton btnTimPhongDangSD;
    private javax.swing.JButton btnTimPhongTrong;
    private javax.swing.JComboBox<String> cbbGio;
    private javax.swing.JComboBox<String> cbbLoaiPhong;
    private javax.swing.JComboBox<String> cbbPhut;
    private com.toedter.calendar.JDateChooser chooserDay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static gui.swing.MainPanel mainPanel;
    private javax.swing.JLabel txtMaKH;
    private javax.swing.JTextField txtPhongSo;
    private javax.swing.JTextField txtSoDienThoaiKH;
    private javax.swing.JTextField txtSoNguoi;
    private javax.swing.JTextField txtSoNguoiDeLuu;
    private javax.swing.JLabel txtTenKH;
    // End of variables declaration//GEN-END:variables

    private void timPhongTheoLoai(String loaiPhong) {
        if (loaiPhong.equals("Phòng nhỏ")) {
            ArrayList<Phong> phongs = phong_dao.timPhongTheoLoaiPhong("PN");
            home.removeAllItem();
            themDuLieuPhongVaoBang(phongs);
        } else if (loaiPhong.equals("Phòng lớn")) {
            ArrayList<Phong> phongs = phong_dao.timPhongTheoLoaiPhong("PL");
            home.removeAllItem();
            themDuLieuPhongVaoBang(phongs);
        } else if (loaiPhong.equals("Phòng vừa")) {
            ArrayList<Phong> phongs = phong_dao.timPhongTheoLoaiPhong("PV");
            home.removeAllItem();
            themDuLieuPhongVaoBang(phongs);
        } else if (loaiPhong.equals("Phòng VIP")) {
            ArrayList<Phong> phongs = phong_dao.timPhongTheoLoaiPhong("VIP");
            home.removeAllItem();
            themDuLieuPhongVaoBang(phongs);
        } else if (loaiPhong.equals("All")) {
            home.removeAllItem();
            testData();
        }
    }

    private void getSoDienThoai() {
        ArrayList<String> ds = dao_KhachHang.getSoDienThoai();
        sdt = new TreeSet<>();
        for (String so : ds) {
            sdt.add(so);
        }
    }

    private void layNgayHienTai() {        
        now = LocalDate.now();
        int ngay = now.getDayOfMonth();
        int thang = now.getMonthValue();
        int nam = now.getYear();
        dNow = new Date(nam - 1900, thang - 1, ngay);
        chooserDay.setDate(dNow);

        
    }

    private void loadDuLieuGio() {
        for (int i = 0; i < 24; i++) {
            cbbGio.addItem("" + i);
        }

    }

    private void loadDuLieuPhut() {
        for (int i = 0; i < 60; i++) {
            cbbPhut.addItem("" + i);
        }
    }

    private void layGioHienTai() {
        
        
        timeNow2 = Calendar.getInstance();
        nowHours = timeNow2.get(Calendar.HOUR_OF_DAY);
        nowMinutes = timeNow2.get(Calendar.MINUTE);
    
        dftxtGio = new DecimalFormat("##");
        dftxtPhut = new DecimalFormat("##");
        cbbGio.setSelectedItem(dftxtGio.format(nowHours));
        cbbPhut.setSelectedItem(dftxtPhut.format(nowMinutes));
    }

    private void kiemTraThongTinKhachHang() {
        String maKH = txtMaKH.getText();
        KhachHang kh = dao_KhachHang.getKhachHangTheoMa(maKH);
        String tenKH = txtTenKH.getText();
        String soDienThoai = txtSoDienThoaiKH.getText();

        /**
         * Kiểm tra xem dữ liệu nhập có đủ hay không
         */
        if (!maKH.equals("") && !tenKH.equals("") && !soDienThoai.equals("")) {
            timeNow2 = Calendar.getInstance();
            nowHours = timeNow2.get(Calendar.HOUR_OF_DAY);
            nowMinutes = timeNow2.get(Calendar.MINUTE);
            nowSecond = timeNow2.get(Calendar.SECOND);
            dftxtGio = new DecimalFormat("##");
            dftxtPhut = new DecimalFormat("##");                       

            int gio = nowHours;
            int phut = nowMinutes;
            
            LocalTime gioDen  = LocalTime.of(gio, phut, nowSecond);
            LocalTime gioKetThuc   = LocalTime.of(gio, phut, nowSecond);
            
//            Time gioDen = new Time(gio, phut, 0);                   
//            Time gioKetThuc = new Time(gio, phut, 0);
            /**
             * Kiểm tra xem item đó có được click hay không
             */
            if (itemSelected != null) {
                /**
                 * Kiểm tra phòng có sử dụng hay không
                 */
                String maP = itemSelected.getItemName();
                Phong maTT = phong_dao.timPhongTheoMa(maP);
                String tt = maTT.getTrangThaiPhong().getMaTrangThaiPhong();
                if (tt.equals("PT")) {
                    String maHD = dao_DatPhong.taoMaHoaDonTuDong();               
                    String maNVTam = maNVDangNhap;
                    NhanVien maNV = dao_DatPhong.getMaNV(maNVTam);
                    HoaDon hd = new HoaDon(maHD, maNV, kh, dNow, gioDen, gioKetThuc, 0, 0, 0, 0, false);
                    System.out.println(hd);
                    dao_HoaDon.addHoaDON(hd);
                    ChiTietHoaDon cthd = new ChiTietHoaDon(hd, maTT, 0);
                    dao_ChiTietHoaDon.addChiTietHoaDON(cthd);

                    String maDichVu = "DV001";
                    DichVu dv = dao_DichVu.timDichVuTheoMa(maDichVu);
                    ChiTietDichVu ctdv = new ChiTietDichVu(dv, hd, 6);
                    dao_ChiTietDichVu.addChiTietDichVu(ctdv);

                    dao_DatPhong.capnhatTrangThaiPhong(itemSelected.getItemName(), "SD");
                    JOptionPane.showMessageDialog(this, "Phòng đã được đặt thành công !", "Thông báo", JOptionPane.DEFAULT_OPTION);
                    Form_ChiTietPhong phongDat = new Form_ChiTietPhong();
                    phongDat.setVisible(true);
                    phongDat.setEditDataDatPhong(kh, maP, maHD);
                    home.removeAllItem();
                    testData();
                } else if (tt.equals("PC")) {
                    JOptionPane.showMessageDialog(this, "Phòng đã được đặt vui lòng chọn phòng khác !", "Thông báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Phòng đang được sử dụng vui lòng chọn phòng khác !", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng cần đặt !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin khách hàng và chọn thông tin đầy đủ về thời gian và ngày đặt!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void setThongTinKH(KhachHang kh) {
        txtMaKH.setText(kh.getMaKhachHang());
        txtSoDienThoaiKH.setText(kh.getSoDienThoai());
        txtTenKH.setText(kh.getHoTenKhachHang());
    }

    public static void loadDSKhiThanhToan() {
        home.removeAllItem();
        testData();
    }
    public boolean kiemTraSLKhachDatPhongCho(int sl,String LP){
        if(LP.equals("PN")){
            if(sl>5){
                JOptionPane.showConfirmDialog(null, "Số lượng khách không phù hợp với phòng", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
                return false;
            }
        }
        else if(LP.equals("PV")){
            if(sl>15){
                JOptionPane.showConfirmDialog(null, "Số lượng khách không phù hợp với phòng", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
                return false;
            }
        }else if(LP.equals("PL")){
            if(sl>20){
                JOptionPane.showConfirmDialog(null, "Số lượng khách không phù hợp với phòng", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
                return false;
            }
        }
        return true;
    }

    private boolean kiemTraSoL() {
        String soLuong = txtSoNguoiDeLuu.getText().trim();
        if (soLuong .length() > 0 ) {
            try {
                Integer sn = Integer.parseInt(soLuong);
		if (sn < 0) {
                    JOptionPane.showMessageDialog(this, "Error: Số người phải > hơn 0!" , "Thông báo", JOptionPane.WARNING_MESSAGE);                                
                    txtSoNguoiDeLuu.requestFocus();
                    return false;
		}
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: Số người phải nhập số!" , "Thông báo", JOptionPane.WARNING_MESSAGE);                
                txtSoNguoiDeLuu.requestFocus();
                return false;
            }
	}
       return true;
    }
}
