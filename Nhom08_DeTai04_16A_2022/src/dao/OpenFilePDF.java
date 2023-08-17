/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class OpenFilePDF {
    public static void openBill(String path) {
        try {
            if((new File(System.getProperty("user.dir") + "\\src\\exportFile\\xuatHoaDon\\" + path + ".pdf")).exists()){
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll, FileProtocolHandler " + System.getProperty("user.dir") + "\\src\\exportFile\\xuatHoaDon\\" + path + ".pdf");
            } else {
                JOptionPane.showMessageDialog(null, "File is not Exists");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
