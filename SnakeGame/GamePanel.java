package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    static final int Width_Screen=600;
    static final int Height_Screen=600;
    static final int UNIT_SIZE=25;
    static final int GAME_UNITS=(Width_Screen*Height_Screen)/UNIT_SIZE;
    final int x[]=new int[Width_Screen];
    final int y[]=new int[Height_Screen];
    int BodyUnitsStart=3;
    int AppleEaton;
    int AppleX;
    int AppleY;
    int delay=300;
    int tempx;
    int tempy;
    char keyPressed;
    Timer timer;
    Random random;
    GamePanel()
    {

        this.setPreferredSize(new Dimension(Width_Screen,Height_Screen));
        this.setBackground(Color.black);
        random=new Random();
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdaptor());
        Start();

    }

    public void Start()
    {
    	for(int i=0;i<3;i++)
    	{
    		if(i==0)
    		{

   			 x[i]=(random.nextInt((int)Width_Screen/UNIT_SIZE)-2*BodyUnitsStart+3)*UNIT_SIZE;
   			 y[i]=(random.nextInt((int)Height_Screen/UNIT_SIZE)-2*BodyUnitsStart+3)*UNIT_SIZE;
    		}
    		else
    		{
    			x[i]=x[0]-i*25;
    			y[i]=y[0];
    		}

    	}
        timer=new Timer(delay,this);
        timer.start();
        
		
	       
	        newApple();
	        	
	        
	        repaint();
		



    }
    public boolean Eaton()
    {
    	for(int i=0;i<BodyUnitsStart;i++)
    	{
    		if((x[i]==AppleX)&&(y[i]==AppleY))
    		{
    			BodyUnitsStart++;
    			newApple();
    			return true;
    		}
    	}
    	return false;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }


     public void draw(Graphics g)
    {
    	 g.setColor(Color.CYAN);
        
        for(int i =0;i<Height_Screen/UNIT_SIZE;i++)
        {
            g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,Height_Screen);

            g.drawLine(0,i*UNIT_SIZE,Width_Screen,i*UNIT_SIZE);

        }
        g.setColor(Color.GREEN);
        g.fillOval(AppleX,AppleY,UNIT_SIZE,UNIT_SIZE);
        
        g.setColor(Color.red);
   	 for(int i=0;i< BodyUnitsStart;i++)
   	 {
   		 if(i==0)
   		 {
   			 g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
   		 }
   		 else
   		 {
   			 g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
   		 }
   	 }
}


    public  void newApple()
    {
        AppleX=random.nextInt((int)Width_Screen/UNIT_SIZE)*UNIT_SIZE;
        AppleY=random.nextInt((int)Height_Screen/UNIT_SIZE)*UNIT_SIZE;

    }
    
    
    public void move()
    {
    	
		switch(keyPressed)
		{
		case'w':
			up();
			break;
		case'a':
			left();
			break;
		case's':
			down();
			break;
		case'd':
			right();
			break;
		default:
			keyPressed='s';
			break;
		
			}
    }
    
    public void up()
    {
    	for(int i=BodyUnitsStart;i>=0;i--)
    	{
    		if(i==0)
    		{
    			

   			 y[i]=y[i+1]-25;
   			 
    		}
    		else
    		{
    			x[i]=x[i-1];
    			y[i]=y[i-1];
    		}
    	}
    }
    
    
    
    public void down()
    {
    	for(int i=BodyUnitsStart;i>=0;i--)
    	{
    		if(i==0)
    		{

   			 y[i]=y[i+1]+25;
   			 
   			 
    		}
    		else
    		{
    			x[i]=x[i-1];
    			y[i]=y[i-1];
    		}
    	}
    }
    
    
    
    
    public void left()
    {
    	for(int i=BodyUnitsStart;i>=0;i--)
    	{
    		if(i==0)
    		{

   			 x[i]=x[i+1]-25;
   			 
    		}
    		else
    		{
    			x[i]=x[i-1];
    			y[i]=y[i-1];
    		}
    	}
    }
    
    
    
    public void right()
    {
    	for(int i=BodyUnitsStart;i>=0;i--)
    	{
    		if(i==0)
    		{

   			 x[i]=x[i+1]+25;
   			 
    		}
    		else
    		{
    			x[i]=x[i-1];
    			y[i]=y[i-1];
    		}
    	}
    }
    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		move();
		Eaton();
		repaint();
		
	}

    public class MyKeyAdaptor extends KeyAdapter {

    	

    	@Override
    	public void keyPressed(KeyEvent e) {
    		// TODO Auto-generated method stub
    		System.out.println("pressed");
    		switch(e.getKeyCode())
    		{
    		case KeyEvent.VK_W:
    			keyPressed='w';
    			break;
    		case KeyEvent.VK_A:
    			keyPressed='a';
    			break;
    		case KeyEvent.VK_S:
    			keyPressed='s';
    			break;
    		case KeyEvent.VK_D:
    			keyPressed='d';
    			break;
    		default:
    			keyPressed='s';
    			break;
    		}
    	}
}


	
}