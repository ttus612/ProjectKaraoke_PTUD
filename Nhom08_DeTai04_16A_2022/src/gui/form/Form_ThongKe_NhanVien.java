
package gui.form;
import dao.NhanVienDao;
import dao.Dao_TaiKhoan;
import dao.Dao_ThongKe;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;
import gui.main.Form_Login_v2;
import gui.main.Main;
import gui.model.ModelLogin;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;


import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.Desktop;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author THANHTU
 */
public class Form_ThongKe_NhanVien extends javax.swing.JPanel {
    private Dao_TaiKhoan daoTaiKhoan;
    private ModelLogin dataLogin;
    public ModelLogin getDataLogin() {
        return dataLogin;
    }
    private  Dao_ThongKe datk;
    private DefaultTableModel modalThongKetable;
    private DefaultTableModel modalThongKetableKhachHang;
    public Form_ThongKe_NhanVien(TaiKhoan nv) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        initComponents();
         docDuLieuTaiKhoanNhanVienThongKe(nv.getMaNhanvien());
//         jPanel14newFormThongKeNhanVien.add(new Form_QuanLyThongKe_NhanVien());
    }
    
   
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPaneThongKeoThang = new javax.swing.JTabbedPane();
        jPanel11ShowThongKeTheoThang = new javax.swing.JPanel();
        jPanel11showBieuDoThongKe = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        daonhthuthang = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel13thongKeDoanhThuTheoNam = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        daonhthunam = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableThongKeBieuDo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabelDoanhTheoNgayTable = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelTongDoanhThu = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabelSoHoaDon = new javax.swing.JLabel();
        jLabelTongDoanhThuVua = new javax.swing.JLabel();
        jLabelThongKePhongThuong = new javax.swing.JLabel();
        jLabelTongDoanhThuphonglon = new javax.swing.JLabel();
        jLabelTongDoanhThuPhongVip = new javax.swing.JLabel();
        jLabelTongDoanhThuTrungBinh = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabelDoanhThuTrongNgay1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tenNhanVien = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        maNhanVienThongKe = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1NgayThangNam = new com.toedter.calendar.JDateChooser();
        ThongKeTheoQuanLy = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1KHACHHang = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser2ThongKeKhachHang = new com.toedter.calendar.JDateChooser();
        ThongKeTheoQuanLy1TheoKhachHang = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22SoluongKhachHang = new javax.swing.JLabel();
        jLabel23TongTienKhachHang = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 153, 255));

        jLabel2.setBackground(new java.awt.Color(121, 87, 142));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(121, 87, 142));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/img/thongKe_2.png"))); // NOI18N
        jLabel2.setText("Thống kê dành cho nhân viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );

        jTabbedPane1.setBackground(new java.awt.Color(204, 153, 255));
        jTabbedPane1.setForeground(new java.awt.Color(121, 87, 142));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kết quả thống kê theo biểu đồ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        jPanel11ShowThongKeTheoThang.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel11ShowThongKeTheoThangComponentShown(evt);
            }
        });

        jPanel11showBieuDoThongKe.setLayout(new java.awt.BorderLayout());

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("Tổng doanh thu các nhân bán được trong tháng :");

        daonhthuthang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        daonhthuthang.setText("*******");

        jPanel11.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel11ShowThongKeTheoThangLayout = new javax.swing.GroupLayout(jPanel11ShowThongKeTheoThang);
        jPanel11ShowThongKeTheoThang.setLayout(jPanel11ShowThongKeTheoThangLayout);
        jPanel11ShowThongKeTheoThangLayout.setHorizontalGroup(
            jPanel11ShowThongKeTheoThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11ShowThongKeTheoThangLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel11ShowThongKeTheoThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11showBieuDoThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11ShowThongKeTheoThangLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(34, 34, 34)
                        .addComponent(daonhthuthang)
                        .addGap(0, 485, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel11ShowThongKeTheoThangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11ShowThongKeTheoThangLayout.setVerticalGroup(
            jPanel11ShowThongKeTheoThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11ShowThongKeTheoThangLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel11ShowThongKeTheoThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(daonhthuthang))
                .addGap(30, 30, 30)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 557, Short.MAX_VALUE)
                .addComponent(jPanel11showBieuDoThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPaneThongKeoThang.addTab("Doanh Thu Theo Tháng", jPanel11ShowThongKeTheoThang);

        jPanel10.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel10ComponentShown(evt);
            }
        });

        jPanel13thongKeDoanhThuTheoNam.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel13thongKeDoanhThuTheoNamComponentShown(evt);
            }
        });
        jPanel13thongKeDoanhThuTheoNam.setLayout(new java.awt.BorderLayout());

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("Tổng doanh thu các nhân viên trong năm :");

        daonhthunam.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        daonhthunam.setText("*******");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13thongKeDoanhThuTheoNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(daonhthunam)))
                .addContainerGap(551, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(daonhthunam))
                .addGap(47, 47, 47)
                .addComponent(jPanel13thongKeDoanhThuTheoNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(540, Short.MAX_VALUE))
        );

        jTabbedPaneThongKeoThang.addTab("Doanh Thu Theo Năm", jPanel10);

        jTableThongKeBieuDo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Mã Khách Hàng", "Tên Khách Hàng", "Ngày Lập", "Tổng Tiền ", "Loại Phòng", "Mã Nhân Viên", "Tên Nhân Viên"
            }
        ));
        jScrollPane2.setViewportView(jTableThongKeBieuDo);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Xuất excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setText("Doanh thu trong ngày nhân viên bán được:");

        jLabelDoanhTheoNgayTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDoanhTheoNgayTable.setText("xxxxxxxxxxxxx");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDoanhTheoNgayTable)
                        .addGap(0, 537, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabelDoanhTheoNgayTable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );

        jTabbedPaneThongKeoThang.addTab("Doanh Thu theo Ngày", jPanel12);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneThongKeoThang)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneThongKeoThang)
                .addGap(67, 67, 67))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kết quả thống kê theo dữ liệu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Tổng doanh thu:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Tổng số hóa đơn:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Phòng thường:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Phòng vừa:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Phòng lớn:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Phòng VIP:");

        jLabelTongDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTongDoanhThu.setText("xxxxxxxxxxxxx");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setText("Doanh thu trung bình:");

        jLabelSoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSoHoaDon.setText("xxxxxxxxxxxxx");

        jLabelTongDoanhThuVua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTongDoanhThuVua.setText("xxxxxxxxxxxxx");

        jLabelThongKePhongThuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelThongKePhongThuong.setText("xxxxxxxxxxxxx");

        jLabelTongDoanhThuphonglon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTongDoanhThuphonglon.setText("xxxxxxxxxxxxx");

        jLabelTongDoanhThuPhongVip.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTongDoanhThuPhongVip.setText("xxxxxxxxxxxxx");

        jLabelTongDoanhThuTrungBinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTongDoanhThuTrungBinh.setText("xxxxxxxxxxxxx");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Doanh thu trong ngày:");

        jLabelDoanhThuTrongNgay1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDoanhThuTrongNgay1.setText("xxxxxxxxxxxxx");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setText("Tên nhân viên :");

        tenNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setText("Mã nhân viên :");

        maNhanVienThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(maNhanVienThongKe))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tenNhanVien))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelDoanhThuTrongNgay1))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTongDoanhThu, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelSoHoaDon, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelTongDoanhThuVua, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelThongKePhongThuong, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelTongDoanhThuphonglon, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelTongDoanhThuPhongVip, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelTongDoanhThuTrungBinh, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(maNhanVienThongKe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tenNhanVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabelDoanhThuTrongNgay1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelTongDoanhThu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelSoHoaDon))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelThongKePhongThuong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabelTongDoanhThuphonglon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabelTongDoanhThuVua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabelTongDoanhThuPhongVip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabelTongDoanhThuTrungBinh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thống kê", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Chọn ngày/tháng/ năm:");

        jDateChooser1NgayThangNam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser1NgayThangNamMouseClicked(evt);
            }
        });

        ThongKeTheoQuanLy.setText("Thống Kê");
        ThongKeTheoQuanLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongKeTheoQuanLyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1NgayThangNam, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ThongKeTheoQuanLy))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ThongKeTheoQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1NgayThangNam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Doanh Thu", jPanel5);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kết quả thống kê khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        jTable1KHACHHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Tổng tiền", "Ngày lập", "Số hóa đơn"
            }
        ));
        jScrollPane1.setViewportView(jTable1KHACHHang);

        jButton2.setText("Xuất File EXCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(688, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thống kê", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Chọn ngày/tháng/ năm:");

        ThongKeTheoQuanLy1TheoKhachHang.setText("Thống Kê");
        ThongKeTheoQuanLy1TheoKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongKeTheoQuanLy1TheoKhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2ThongKeKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ThongKeTheoQuanLy1TheoKhachHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser2ThongKeKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ThongKeTheoQuanLy1TheoKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kết quả thống kê tổng quát", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(121, 87, 142))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Số lượng hóa đơn nhân viên lập cho khách hàng:");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setText("Tổng tiền nhân viên bán được:");

        jLabel22SoluongKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22SoluongKhachHang.setText("xxxxxxxxxxxxx");

        jLabel23TongTienKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23TongTienKhachHang.setText("xxxxxxxxxxxxx");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23TongTienKhachHang)
                    .addComponent(jLabel22SoluongKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel22SoluongKhachHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23TongTienKhachHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Khách Hàng", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ThongKeTheoQuanLy1TheoKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongKeTheoQuanLy1TheoKhachHangActionPerformed
        // TODO add your handling code here:
        if(jDateChooser2ThongKeKhachHang.getDate()==null){
            JOptionPane.showMessageDialog(null, "Chọn ngày tháng muốn thống kê");
            return;
        }
        else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateDoanhThu=sdf.format(jDateChooser2ThongKeKhachHang.getDate());
            String[] ngayKhachHang=dateDoanhThu.toString().split("-");
            datk=new Dao_ThongKe();
            try {
                ArrayList<KhachHang> dsKh=(ArrayList<KhachHang>) datk.LocDanhSachHoaDonNgayThangNamKhachHang(dateDoanhThu.toString());
                Double tong=0.0;
                Double tongSoHoaDOn=0.0;
                modalThongKetableKhachHang=(DefaultTableModel) jTable1KHACHHang.getModel();
                int sluongKhachHang=0;
                if(dsKh.size()==0){
                    jLabel23TongTienKhachHang.setText(0+"VNĐ");
                    jLabel22SoluongKhachHang.setText(dsKh.size()+"");
                    modalThongKetableKhachHang.getDataVector().removeAllElements();
                    JOptionPane.showMessageDialog(null, "Không có  khách hàng cần thống kê ");
                    return;
                }
                else{
                    DecimalFormat formatters = new DecimalFormat("###,###,###");
                    for(KhachHang kh:dsKh ){
                      modalThongKetableKhachHang.addRow(new Object[]{kh.getMaKhachHang(),kh.getHoTenKhachHang(),kh.getSoDienThoai(),String.valueOf(formatters.format(kh.getHd().getTongTien())) +"VND",kh.getHd().getNgayLap1(),kh.getHd().getSoHoaDon()});    
                        tong+=kh.getHd().getTongTien();
                        tongSoHoaDOn+=kh.getHd().getSoHoaDon();
                    }
                    jLabel22SoluongKhachHang.setText(tongSoHoaDOn+"");
                    DecimalFormat formatter = new DecimalFormat("###,###,###");
                    jLabel23TongTienKhachHang.setText( formatter.format(tong)+" "+"VNĐ");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Form_ThongKe_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ThongKeTheoQuanLy1TheoKhachHangActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        xuatExcellAllTable(jTable1KHACHHang);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    public void docDuLieuTaiKhoanNhanVienThongKe(String maNhanvien ){
        daoTaiKhoan=new Dao_TaiKhoan();
      

           try {
            TaiKhoan user = daoTaiKhoan.GetTenUserLoginForThongKe(maNhanvien);
            if (user != null) {
              
                  maNhanVienThongKe.setText(user.getMaNhanvien());
                 tenNhanVien.setText(user.getUserName());
           
            } else {
                JOptionPane.showMessageDialog(this, "không xác định được nhân viên nào cần thống kê vui lòng đăng nhập ");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi đăng nhập không thể thống kê nhân viên");
    
            e.printStackTrace();
        }
    }

    private void ThongKeTheoQuanLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongKeTheoQuanLyActionPerformed
        // TODO add your handling code here:
        if(jDateChooser1NgayThangNam.getDate()==null){
            JOptionPane.showMessageDialog(null, "Chọn ngày tháng muốn thống kê");
            return;
        }
        
        else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateDoanhThu=sdf.format(jDateChooser1NgayThangNam.getDate());
            jLabelDoanhTheoNgayTable.setText(dateDoanhThu);
            jLabelDoanhThuTrongNgay1.setText(dateDoanhThu);
            String[] dataThang=dateDoanhThu.toString().split("-");
            datk=new Dao_ThongKe();
            ArrayList<HoaDon> DShd=(ArrayList<HoaDon>) datk.getAllHoaDonNhanVien(maNhanVienThongKe.getText());
            Double tong=0.0;
            Double trungBinhHoaDon=0.0;
            Double tongTienPhongThuong=0.0;
            Double tongTienPhongLon=0.0;
            Double tongTienPhongVua=0.0;
            Double tongTienPhongVip=0.0;
            int soHoaDon=0;
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            modalThongKetable=(DefaultTableModel) jTableThongKeBieuDo.getModel();
            for(HoaDon hd: DShd){
                if(hd.getNgayLap1().toString().equals(dateDoanhThu.toString())){
                    modalThongKetable.addRow(new Object[]{hd.getMaHoaDon(),hd.getKhachHang().getMaKhachHang(),hd.getKhachHang().getHoTenKhachHang(),hd.getNgayLap1(),String.valueOf(formatter.format(hd.getTongTien())+" "+"VNĐ"),hd.getLoaiPhong().getMaLoaiPhong(),hd.getNhanVien().getMaNhanVien(),hd.getNhanVien().getTenNhanVien()});
                    tong+=hd.getTongTien();
                    soHoaDon+=1;
                    //                tong tien phong lon
                    if(hd.getLoaiPhong().getMaLoaiPhong().equalsIgnoreCase("PL")){
                        tongTienPhongLon+=hd.getTongTien();
                    }
                    //                tong tien phong vip
                    if(hd.getLoaiPhong().getMaLoaiPhong().equalsIgnoreCase("VIP")){
                        tongTienPhongVip+=hd.getTongTien();
                    }
                    //                tong tien phong Vua
                    if(hd.getLoaiPhong().getMaLoaiPhong().equalsIgnoreCase("PV")){
                        tongTienPhongVua+=hd.getTongTien();
                    }
                    //                tong tien phong
                    if(hd.getLoaiPhong().getMaLoaiPhong().equalsIgnoreCase("PN")){
                        tongTienPhongThuong+=hd.getTongTien();
                    }
                }
                //thong ke bieu do
            }

            if(tong==0){
                jLabelTongDoanhThu.setText( 0+" " +"VNĐ");
            }
            else{

                jLabelTongDoanhThu.setText( formatter.format(tong)+" "+"VNĐ");
            }
            DecimalFormat formatters = new DecimalFormat("###,###,###");
            jLabelSoHoaDon.setText(soHoaDon+"");
            jLabelThongKePhongThuong.setText( formatters.format(tongTienPhongThuong)+" "+"VNĐ");
            jLabelTongDoanhThuPhongVip.setText( formatters.format(tongTienPhongVip)+" "+"VNĐ");
            jLabelTongDoanhThuVua.setText( formatters.format(tongTienPhongVua)+" "+"VNĐ");
            jLabelTongDoanhThuphonglon.setText( formatters.format(tongTienPhongLon)+" "+"VNĐ");
            if(soHoaDon>0){
                jLabelTongDoanhThuTrungBinh.setText( formatters.format(tong/soHoaDon)+" "+"VNĐ");
            }
            if(soHoaDon==0){
                jLabelTongDoanhThuTrungBinh.setText(0+" " +"VNĐ");
                JOptionPane.showMessageDialog(null, "Không có hóa đơn trong ngày ,tháng,năm này ");
                ChartPanel chartPanel;
                chartPanel = new ChartPanel(showChartNull());
                setForm(chartPanel);
                setFormNam(chartPanel);
                daonhthuthang.setText("0"+" "+"VNĐ");
                daonhthunam.setText("0"+"VNĐ");
                modalThongKetable.getDataVector().removeAllElements();
            }
            else{
                try {
                    ChartPanel chartPanel,chartPanelNam;
                    chartPanel = new ChartPanel(createChartThang(dataThang[0].toString(),dataThang[1].toString(),dataThang[2].toString(),datk));
                    chartPanelNam=new ChartPanel(createChartNam(dataThang[0].toString(),dataThang[1].toString(),datk));
                    jLabelDoanhTheoNgayTable.setText(dateDoanhThu);
                    jLabelDoanhThuTrongNgay1.setText(dateDoanhThu);
                    setForm(chartPanel);
                    setFormNam(chartPanelNam);
                } catch (SQLException ex) {
                    Logger.getLogger(Form_ThongKe_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_ThongKeTheoQuanLyActionPerformed

    private void jDateChooser1NgayThangNamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1NgayThangNamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1NgayThangNamMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        xuatExcellAllTable(jTableThongKeBieuDo);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel10ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel10ComponentShown
        // TODO add your handling code here:
        //            ChartPanel chartPanel;
        //            chartPanel = new ChartPanel(showChartNull());
        //            setFormNam(chartPanel);
    }//GEN-LAST:event_jPanel10ComponentShown

    private void jPanel13thongKeDoanhThuTheoNamComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel13thongKeDoanhThuTheoNamComponentShown
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel13thongKeDoanhThuTheoNamComponentShown

    private void jPanel11ShowThongKeTheoThangComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel11ShowThongKeTheoThangComponentShown
        // TODO add your handling code here:
        //            ChartPanel chartPanel;
        //            chartPanel = new ChartPanel(showChartNull());
        //            setForm(chartPanel);
    }//GEN-LAST:event_jPanel11ShowThongKeTheoThangComponentShown

    private void setForm(JComponent com){
        jPanel11.removeAll();
        jPanel11.add(com);
        jPanel11.repaint();
        jPanel11.revalidate();
    }
 
 
 
  private void setFormNam(JComponent com){
      
        jPanel13thongKeDoanhThuTheoNam.removeAll();
        jPanel13thongKeDoanhThuTheoNam.add(com);
        jPanel13thongKeDoanhThuTheoNam.repaint();
        jPanel13thongKeDoanhThuTheoNam.revalidate();
    }//bỏ  
//    ham su dung chun de xuat excel
    
   public  void xuatExcellAllTable(JTable tableXuatExcel){
        int rowCount = tableXuatExcel.getRowCount();
		if(rowCount == 0) {
			JOptionPane.showMessageDialog(null, "Không có dữ liệu để xuất thống kê!");
			return;
		}
             try{
           
                       JFileChooser jFileChooser = new JFileChooser();
                        File saveFile = jFileChooser.getSelectedFile();
                        jFileChooser.addChoosableFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "Excell file (*.xls, *xlsx)";
			}
			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				} else {
					return f.getName().toLowerCase().endsWith(".xls") || f.getName().toLowerCase().endsWith(".xlsx");
				}
			}

		});
         
         int is = jFileChooser.showSaveDialog(this);
         if (is == 0) {
			String path = jFileChooser.getSelectedFile().getAbsolutePath();
			if (!path.matches("(.)+(\\.xls|\\.xlsx)$")) {
				path += ".xlsx";
			}
			
                         if(path != null){
                         saveFile = new File(path.toString()+".xlsx");
                         Workbook wb = new XSSFWorkbook();
                         Sheet sheet = wb.createSheet("Sheet1");

                         Row rowCol = sheet.createRow(0);
                         for(int i=0;i<tableXuatExcel.getColumnCount();i++){
                             Cell cell = rowCol.createCell(i);
                             cell.setCellValue(tableXuatExcel.getColumnName(i));
                         }

                         for(int j=0;j<tableXuatExcel.getRowCount();j++){
                             Row row = sheet.createRow(j+1);
                             for(int k=0;k<tableXuatExcel.getColumnCount();k++){
                                 Cell cell = row.createCell(k);
                                 if(tableXuatExcel.getValueAt(j, k)!=null){
                                     cell.setCellValue(tableXuatExcel.getValueAt(j, k).toString());
                                 }
                             }
                         }
                         FileOutputStream out = new FileOutputStream(new File(path.toString()));
                          wb.write(out);
                          wb.close();
                          out.close();
                          JOptionPane.showMessageDialog(null,"success");
                          openFile(path.toString());
                     }else{
                         JOptionPane.showMessageDialog(null,"ERROR");
                     }

			
		}
         
         
       }catch(FileNotFoundException e){
           System.out.println(e);
       }catch(IOException io){
           System.out.println(io);
       }
    } 
    
    	
    
    
    public void openFile(String file){
        try{
            File path = new File(file);
            Desktop.getDesktop().open(path);
        }catch(IOException ioe){
            System.out.println(ioe);
        }
    }
 
 	
    
    private JFreeChart createChartThang(String namCurrent,String thangCurrent,String ngayCurrent,Dao_ThongKe daotk) throws SQLException {
	    long tongTientatcacacHoaDonTrongThang=0;
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 1; i < 32; i++) {
			String ngay = String.valueOf(i);
                         ArrayList<HoaDon> list = (ArrayList<HoaDon>) daotk.LocDanhSachHoaDonNgayThangNamTheoNhanVien(ngay, thangCurrent, namCurrent,maNhanVienThongKe.getText().toString());
			long tt = 0;
                       
                        for (HoaDon hd : list) {
                               
				tt += hd.getTongTien();                                   
			}
                        tongTientatcacacHoaDonTrongThang+=tt;
			dataset.addValue(tt, "Tổng tiền", ngay);  
                        
		}	
                DecimalFormat formatter = new DecimalFormat("###,###,###");
                daonhthuthang.setText(formatter.format(tongTientatcacacHoaDonTrongThang)+" "+"VNĐ");
               
		JFreeChart barChart = ChartFactory.createBarChart("BIỂU ĐỒ DOANH THU TRONG THÁNG " + thangCurrent, "Ngày",
				"Tổng tiền (VND)", dataset, PlotOrientation.VERTICAL, true, true, false);
		return barChart;
	}
    
    
    private JFreeChart createChartNam(String namCurrent,String thangCurrent,Dao_ThongKe daotk) throws SQLException{
        
          long tongTientatcacacHoaDonTrongNam=0;
            DefaultCategoryDataset datasetnam = new DefaultCategoryDataset();
		for (int i = 1; i <13; i++) {
			String thang = String.valueOf(i);
                        //lu i day phai la thang
                         ArrayList<HoaDon> list = (ArrayList<HoaDon>) daotk.LocDanhSachHoaDonTheoThangNamNhanVien(namCurrent, thang,maNhanVienThongKe.getText());
			
                         long ttnam = 0;
                        for (HoaDon hd : list) {
                               
				ttnam += hd.getTongTien();                                   
			}
//                        JOptionPane.showMessageDialog(jDateChooser2, ttnam);
//                        System.out.println(tongTientatcacacHoaDonTrongNam);
                        tongTientatcacacHoaDonTrongNam+=ttnam;
			datasetnam.addValue(ttnam, "Tổng tiền", thang);    
		}	
                DecimalFormat formatter = new DecimalFormat("###,###,###");
                daonhthunam.setText(formatter.format(tongTientatcacacHoaDonTrongNam)+" "+"VNĐ");
		JFreeChart barChart = ChartFactory.createBarChart("BIỂU ĐỒ DOANH THU TRONG NĂM " + namCurrent, "Tháng ",
				"Tổng tiền (VND)", datasetnam, PlotOrientation.VERTICAL, true, true, false);
		return barChart;
        
    }
        
        private JFreeChart showChartNull() {
              DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 1; i < 31; i++) {
			String ngay = String.valueOf(i);
                       
			long tt = 0;
			dataset.addValue(tt, "Tổng tiền", ngay);  
		}	
                JFreeChart barChart = ChartFactory.createBarChart("BIỂU ĐỒ DOANH THU TRONG THÁNG " , "Ngày",
				"Tổng tiền (VND)", dataset, PlotOrientation.VERTICAL, true, true, false);
		return barChart;
        }
        
        
      

                
                       
                   
      
                
                
	

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ThongKeTheoQuanLy;
    private javax.swing.JButton ThongKeTheoQuanLy1TheoKhachHang;
    private javax.swing.JLabel daonhthunam;
    private javax.swing.JLabel daonhthuthang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1NgayThangNam;
    private com.toedter.calendar.JDateChooser jDateChooser2ThongKeKhachHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22SoluongKhachHang;
    private javax.swing.JLabel jLabel23TongTienKhachHang;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDoanhTheoNgayTable;
    private javax.swing.JLabel jLabelDoanhThuTrongNgay1;
    private javax.swing.JLabel jLabelSoHoaDon;
    private javax.swing.JLabel jLabelThongKePhongThuong;
    private javax.swing.JLabel jLabelTongDoanhThu;
    private javax.swing.JLabel jLabelTongDoanhThuPhongVip;
    private javax.swing.JLabel jLabelTongDoanhThuTrungBinh;
    private javax.swing.JLabel jLabelTongDoanhThuVua;
    private javax.swing.JLabel jLabelTongDoanhThuphonglon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel11ShowThongKeTheoThang;
    private javax.swing.JPanel jPanel11showBieuDoThongKe;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13thongKeDoanhThuTheoNam;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPaneThongKeoThang;
    private javax.swing.JTable jTable1KHACHHang;
    private javax.swing.JTable jTableThongKeBieuDo;
    private javax.swing.JLabel maNhanVienThongKe;
    private javax.swing.JLabel tenNhanVien;
    // End of variables declaration//GEN-END:variables

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
