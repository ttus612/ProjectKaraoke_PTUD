package gui.component;

import gui.model.Model_Card;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author THANHTU
 */
public class Card extends javax.swing.JPanel {

    private final Model_Card data;
    private final Timer timer;
    private final Timer timerStop;
    private final CardDescription carDescription;
    private int y = 140;
    private int speed = 5;//tốc độ animation
    private boolean showing = false;
   
    public Card(Model_Card data) {
        this.data = data;
        initComponents();
        setOpaque(false);
        carDescription = new CardDescription(data.getTitle(), data.getDescription());
        carDescription.setLocation(0,y);
        setPreferredSize(new Dimension(180,200));//chỉnh độ rộng vừng chứa --180-
        carDescription.setSize(new Dimension(180, 160));//180 -160
        add(carDescription);
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showing) {
                    y -= speed;
                    if (y <= 50) {
                        y = 50;
                        carDescription.setLocation(0, y);
                        timer.stop();
                    }else{
                        carDescription.setLocation(0, y);
                    }
                }else{
                    y += speed;
                    if (y>= 140) {
                        y = 140;
                        carDescription.setLocation(0, y);
                        timer.stop();
                    }else{
                        carDescription.setLocation(0, y);
                    }
                }
            }
        });
        timerStop = new Timer(500,  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showing = false;
                timerStop.stop();
                timer.start();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                showing = true;
                timerStop.stop();
                timer.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                timerStop.start();
            }           
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        int i=0;
        JOptionPane.showMessageDialog(carDescription, "i"+i);
        i++;
        System.out.println(data);
    }//GEN-LAST:event_formMouseClicked

    @Override
    protected void paintComponent(Graphics g) {
        //style draw image\
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        Rectangle size = getAutoSize(data.getIcon());
        g2.drawImage(toImage(data.getIcon()), size.x +10 , size.y +10, size.width, size.height, null);//Chỉnh khoảng cách các hình
        super.paintComponent(g); 

      
    }

    @Override
    public void paint(Graphics g) {
        //style color
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, getHeight(), Color.decode("#CC99FF"), 0, getHeight()-50, new Color(0,0,0,0));
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
       
    }

    private Rectangle getAutoSize(Icon image){
        
        int w = 150;//Kích thước ảnh - 150
        int h = 160;//160
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int)(scale * iw);
        int height = (int) (scale * ih);
        int x = (w-width)/2;
        int y = (h - height)/2;
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }
    private Image toImage(Icon icon){
        return ((ImageIcon)icon).getImage();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
