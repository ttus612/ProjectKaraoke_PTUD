package gui.model;

import javax.swing.Icon;

/**
 *
 * @author THANHTU
 */
public class ModelItem {

    private int itemID;
    private String itemName;
    private String description;
    private double price;
    private String loaiPhong;
    private Icon image;
    private boolean check;
    public String tenKH;
    public int luotCho;

    public int getLuotCho() {
        return luotCho;
    }

    public void setLuotCho(int luotCho) {
        this.luotCho = luotCho;
    }
    
    

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }
    
    public int getItemID() {
        return itemID;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    public ModelItem(int itemID, String itemName, String description, double price, String loaiPhong, Icon image, String tenKH, int luotCho) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.loaiPhong = loaiPhong;
        this.image = image;
        this.tenKH = tenKH;
        this.luotCho = luotCho;
    }

    public ModelItem() {
    }
}
