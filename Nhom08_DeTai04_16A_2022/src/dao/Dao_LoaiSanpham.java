/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.LoaiSanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author phoai
 */
public class Dao_LoaiSanpham {

    public ArrayList<LoaiSanPham> getListSanPham() {
        ArrayList<LoaiSanPham> dsLoaiSanPham = new ArrayList<LoaiSanPham>();
        try {
            ConnectDB.getIntance().connect();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM LoaiSanPham";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maLoaiPhong = rs.getString("maLoaiSanPham");
                String tenLoaiPhong = rs.getString("tenLoaiSanPham");

                LoaiSanPham loaiSanPham = new LoaiSanPham(maLoaiPhong, tenLoaiPhong);
                dsLoaiSanPham.add(loaiSanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsLoaiSanPham;
    }

    public LoaiSanPham timLoaiSanPham(String maLoaiSanPham) throws Exception {
        ConnectDB.getIntance().connect();
        Connection con = ConnectDB.getConnection();
        String sql = "SELECT * FROM [dbo].[LoaiSanPham] where maLoaiSanPham = ? ";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, maLoaiSanPham);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            LoaiSanPham loaiSP = new LoaiSanPham(rs.getString("maLoaiSanPham"), rs.getString("tenLoaiSanPham"));
            return loaiSP;
        }
        return null;
    }
}
