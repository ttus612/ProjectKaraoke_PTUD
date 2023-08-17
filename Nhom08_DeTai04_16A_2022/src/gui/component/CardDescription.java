package gui.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;

/**
 *
 * @author THANHTU
 */
public class CardDescription extends javax.swing.JPanel {

    public CardDescription(String title, String description) {
        initComponents();
        setOpaque(false);
        txt.setBackground(new Color(0,0,0,0));
        lbTitle.setText(title);
        txt.setText(description);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        txt = new gui.swing.TextArea();

        lbTitle.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(76, 76, 76));
        lbTitle.setText("Title");
        lbTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));

        txt.setBackground(new java.awt.Color(255, 255, 255));
        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txt.setColumns(20);
        txt.setRows(5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255,255,255,200));
        Path2D.Float f= new Path2D.Float();
        f.moveTo(0, 30);
        f.curveTo(50, 0, 100, 40, 180, 0);//độ rộng của des
        f.lineTo(180, getHeight());
        f.lineTo(0, getHeight());
        g2.fill(f);
        super.paintComponent(g); 
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbTitle;
    private gui.swing.TextArea txt;
    // End of variables declaration//GEN-END:variables
}
