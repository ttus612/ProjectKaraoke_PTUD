
package gui.model;

import javax.swing.Icon;

/**
 *
 * @author THANHTU
 */
public class Model_Card {
    Icon icon;
    String title;
    String description;

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Model_Card() {
    }

    public Model_Card(Icon icon, String title, String description) {
        this.icon = icon;
        this.title = title;
        this.description = description;
    }
    
}
