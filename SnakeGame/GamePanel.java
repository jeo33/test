package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.sql.Time;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    static final int Width_Screen=600;
    static final int Height_Screen=600;
    static final int UNIT_SIZE=25;
    static final int GAME_UNITS=(Width_Screen*Height_Screen)/UNIT_SIZE;
    final int x[]=new int[Width_Screen];
    final int y[]=new int[Height_Screen];
    int BodyUnitsStart=6;
    int AppleEaton;
    int AppleX;
    int AppleY;
    int delay=75;
    Timer timer;
    Random random;
    GamePanel()
    {

        this.setPreferredSize(new Dimension(Width_Screen,Height_Screen));
        this.setBackground(Color.black);
        random=new Random();
        Start();

    }

    public void Start()
    {
        timer=new Timer(delay,this);
        timer.start();

        newApple();



    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }


     public void draw(Graphics g)
    {
        for(int i =0;i<Height_Screen/UNIT_SIZE;i++)
        {
            g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,Height_Screen);

            g.drawLine(0,i*UNIT_SIZE,Width_Screen,i*UNIT_SIZE);

        }
        g.setColor(Color.GREEN);
        g.fillOval(AppleX,AppleY,UNIT_SIZE,UNIT_SIZE);

    }


    public  void newApple()
    {
        AppleX=random.nextInt((int)Width_Screen/UNIT_SIZE)*UNIT_SIZE;
        AppleY=random.nextInt((int)Height_Screen/UNIT_SIZE)*UNIT_SIZE;

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
