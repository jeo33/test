package project;
import com.sun.jdi.Field;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class demo extends JPanel {

    ImageIcon i=new ImageIcon("C:\\Users\\zsy11\\Desktop\\rocket.png");
    int w=i.getIconWidth();
    int h=i.getIconHeight();
    Point p1;
    Point p2;
    demo() {
        p1=new Point(0,0);
        ClickListener ClickListener = new ClickListener();
        DragListener DragListener=new DragListener();
        this.addMouseListener( ClickListener);
        this.addMouseMotionListener(DragListener);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        i.paintIcon(this,g,(int)p1.getX(),(int)p1.getY());
    }
    private class ClickListener extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            p2=e.getPoint();
        }
    }
    private class DragListener extends MouseMotionAdapter
    {
        public void mouseDragged(MouseEvent e)
        {
            Point temp=e.getPoint();
            p1.translate( ((int)(temp.getX()-p2.getX())),((int)(temp.getY()-p2.getY())));
            p2=temp;
            repaint();


        }
    }

}
