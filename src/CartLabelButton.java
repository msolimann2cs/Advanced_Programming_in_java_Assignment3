import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CartLabelButton{
    JLabel temp_label;

    public CartLabelButton(String name){
        this.temp_label = new JLabel(name);
        temp_label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("KOSMK");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public JLabel getLabel(){
        return temp_label;
    }

    public void setBounds(int i, int i1, int i2, int i3) {
        temp_label.setBounds(i,i1,i2,i3);
    }

    public void setFont(Font serif) {
        temp_label.setFont(serif);
    }
}