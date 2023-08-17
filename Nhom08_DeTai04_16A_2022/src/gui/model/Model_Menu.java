
package gui.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author THANHTU
 */
public class Model_Menu {
    
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public Model_Menu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    public Model_Menu() {
    }

    private String icon;
    private String name;
    private MenuType type;

    public Icon toIcon() {
        return new ImageIcon(getClass().getResource("/image/icon/" + icon + ".png"));
    }

    public Icon toIconSelected() {
        return new ImageIcon(getClass().getResource("/image/icon/" + icon + "_selected.png"));
    }

     public Icon toIconSelectedLogout() {
        return new ImageIcon(getClass().getResource("/image/icon/" + icon + ".png"));
    }
    
    public static enum MenuType {
        MENU, EMPTY, TITLE,LOGOUT,ADMIN,ADMIN_TITLE
    }
}
