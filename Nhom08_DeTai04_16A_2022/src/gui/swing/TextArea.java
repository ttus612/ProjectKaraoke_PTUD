
package gui.swing;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import javax.swing.JTextArea;

/**
 *
 * @author THANHTU
 */
public class TextArea extends JTextArea{
    public TextArea() {
        setEditable(false);
        setFocusable(false);
        setWrapStyleWord(true);
        setLineWrap(true);
    }

    @Override
    public synchronized void addMouseListener(MouseListener l) {

    }

    @Override
    public synchronized void addMouseMotionListener(MouseMotionListener l) {

    }

    @Override
    public synchronized void addMouseWheelListener(MouseWheelListener l) {

    }

    @Override
    public void addNotify() {

    }
}
