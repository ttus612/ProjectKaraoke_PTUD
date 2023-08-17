
package gui.swing;

import gui.model.Model_Menu;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author THANH TU
 */
public class MenuItem extends javax.swing.JPanel {

      private final Model_Menu data;
    
    public MenuItem(Model_Menu data) {
        this.data = data;
        initComponents();
        setOpaque(false);
        if (data.getType() == Model_Menu.MenuType.MENU) {
            lblIcon.setIcon(data.toIcon());
            lblName.setText(data.getName());
            lblName.setFont(new Font("Time New Roman",  Font.PLAIN, 15));
        }else if(data.getType() == Model_Menu.MenuType.TITLE){
            lblIcon.setText(data.getName()); 
            lblIcon.setFont(new Font("Time New Roman",  Font.BOLD, 18));
            lblIcon.setForeground(new Color(121, 87, 142));
            lblName.setVisible(false);
        }else if(data.getType() == Model_Menu.MenuType.LOGOUT){
            lblName.setForeground(new Color(214,217,223));
            lblIcon.setIcon(data.toIcon());
            lblName.setText(data.getName());
            lblName.setFont(new Font("Time New Roman",  Font.BOLD, 18));
        
            lblIcon.setForeground(new Color(121, 87, 142));
        }else if(data.getType() == Model_Menu.MenuType.ADMIN_TITLE){
            lblIcon.setText(data.getName()); 
            lblIcon.setFont(new Font("Time New Roman",  Font.BOLD, 18));
            lblIcon.setForeground(new Color(121, 87, 142));
            lblName.setVisible(false);
        }else if(data.getType() == Model_Menu.MenuType.ADMIN){
            lblIcon.setIcon(data.toIcon());
            lblName.setText(data.getName());
            lblName.setFont(new Font("Time New Roman",  Font.PLAIN, 15));
        }
        else{
            lblName.setText(" "); 
        }
    }

    public void setSelected(boolean selected){
        if (data.getType() == Model_Menu.MenuType.MENU) {
            if (selected) {
                lblIcon.setIcon(data.toIconSelected());
                lblName.setForeground(new Color(121, 87, 142));
            }else{
                lblIcon.setIcon(data.toIcon());
                lblName.setForeground(new Color(214,217,223));
            }
        } else if (data.getType() == Model_Menu.MenuType.ADMIN) {
            if (selected) {
                lblIcon.setIcon(data.toIconSelected());
                lblName.setForeground(new Color(121, 87, 142));
            }else{
                lblIcon.setIcon(data.toIcon());
                lblName.setForeground(new Color(214,217,223));
            }
        }else if (data.getType() == Model_Menu.MenuType.LOGOUT) {
            if (selected) {
                lblIcon.setIcon(data.toIconSelectedLogout());
                lblName.setForeground(new Color(121, 87, 142));
            }else{
                lblIcon.setIcon(data.toIcon());
                lblName.setForeground(new Color(214,217,223));
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIcon = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();

        lblName.setForeground(new java.awt.Color(228, 226, 226));
        lblName.setText("Menu Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblIcon)
                .addGap(18, 18, 18)
                .addComponent(lblName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblName;
    // End of variables declaration//GEN-END:variables
}
