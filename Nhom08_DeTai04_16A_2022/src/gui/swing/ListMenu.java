
package gui.swing;

import gui.event.EventMenuCallBack;
import gui.event.EventMenuSelected;
import gui.model.Model_Menu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author THANHTU
 * @param <E>
 */
public class ListMenu<E extends Object> extends JList<E> {
    
    public void addEventSelectedMenu(EventMenuSelected event){
        events.add(event);
    }
    
    private final DefaultListModel model;
    private final List<EventMenuSelected> events;
    private int selectedIndex = -1;
    private EventMenuSelected event;
    public void addEventMenuSelected(EventMenuSelected eventMenu) {
        this.event = event;
    }

    @SuppressWarnings("unchecked")
    public ListMenu() {
        model = new DefaultListModel();
        events = new ArrayList<>();
        super.setModel(model);
                addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    Object obj = model.getElementAt(index);
                    if (obj instanceof Model_Menu) {
                        Model_Menu data = (Model_Menu) obj;
                        if (data.getType() ==  Model_Menu.MenuType.MENU) {
                            if(index != selectedIndex){
                                selectedIndex = -1;
                                runEvent(index);
                            }  
                        }else if (data.getType() ==  Model_Menu.MenuType.ADMIN) {
                            if(index != selectedIndex){
                                selectedIndex = -1;
                                runEvent(index);
                            }  
                        }else if (data.getType() ==  Model_Menu.MenuType.LOGOUT) {
                            if(index != selectedIndex){
                                selectedIndex = -1;
                                runEvent(index);
                            }  
                        }
                    }else{
                        if(index != selectedIndex){
                            selectedIndex = -1;
                            runEvent(index);
                        }  
                    }
                }
            }
        });
    }
    
    private void runEvent(int indexChange){
        for(EventMenuSelected event:events){
            event.menuSelected(indexChange, new EventMenuCallBack() {
                @Override
                public void call(int index) {
                    //gọi lại hàm khi chạy sự kiện khi có animation thành công
                   selectedIndex = index;
                   repaint();
                }
            });
        }
    }
    
    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object o, int index, boolean selected, boolean focus) {
                Model_Menu data;
                if (o instanceof Model_Menu) {
                    data = (Model_Menu) o;
                }else{
                    data = new Model_Menu("1", o + "", Model_Menu.MenuType.MENU);
                }
                MenuItem item = new MenuItem(data);
                item.setSelected(index == selectedIndex);
                return item;
            }   
        };
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public void setModel(ListModel<E> lm) {
        for (int i = 0; i < lm.getSize(); i++) {
            model.addElement(lm.getElementAt(i));
        }
    }
    
    @SuppressWarnings("unchecked")
    public void addItem(Model_Menu data){
        model.addElement(data);
    }
}
