
package gui.swing;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author THANHTU
 */
public class ImageHelper {//Điều chỉnh kích thước hình ảnh
    public static Image resize(Image originalImage, int targetWight, int targetHeight){
        Image resultingImage = originalImage.getScaledInstance(targetWight, targetHeight, Image.SCALE_SMOOTH);
        return resultingImage;
    }
    public static byte[] toByteArray(Image img, String type) throws IOException{//chuyển hình ảnh vào mản byte
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimage.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bimage, type, baos);
        byte[] imageInByte = baos.toByteArray();
        
        return imageInByte;      
    }
    public static Image createImageFormByteArray(byte[] data, String type) throws IOException{//chuyển mảng byte về đối tượng Image cho phép hiển thị lên label
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        BufferedImage bImage2 =  ImageIO.read((bis));
        
        Image img = bImage2.getScaledInstance(bImage2.getWidth(), bImage2.getHeight(), Image.SCALE_SMOOTH);
        return img;
    }
}
