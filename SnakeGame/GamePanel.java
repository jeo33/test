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
	int bodyType;
	ImageIcon p1=new ImageIcon("p1.png");
	ImageIcon p2=new ImageIcon("p2.png");
	ImageIcon p3=new ImageIcon("p3.png");
	ImageIcon[] p={p1,p2,p3};
	ImageIcon Head_U=new ImageIcon("headU.png");
	ImageIcon Head_D=new ImageIcon("headD.png");
	ImageIcon Head_L=new ImageIcon("headL.png");
	ImageIcon Head_R=new ImageIcon("headR.png");
	ImageIcon stella=new ImageIcon("stella.png");
	ImageIcon mama=new ImageIcon("mamaIcon.png");
	ImageIcon baba=new ImageIcon("babaIcon.png");
	ImageIcon background=new ImageIcon("BACKGROUND.jpg");

    static final int Width_Screen=800;
    static final int Height_Screen=800;
    static final int UNIT_SIZE=50;
    static final int GAME_UNITS=(Width_Screen*Height_Screen)/UNIT_SIZE;
    final int x[]=new int[Width_Screen];
    final int y[]=new int[Height_Screen];
    int BodyUnitsStart=3;
    int AppleEaton;
	int AppleType;
    int AppleX;
    int AppleY;
    int delay=300;
    char keyPressed;
    Timer timer;
    Random random;
    GamePanel()
    {

        this.setPreferredSize(new Dimension(background.getIconWidth(),background.getIconHeight()));
        random=new Random();
		this.setBackground(Color.blue);
		this.setBounds(0,0,Width_Screen,Width_Screen);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdaptor());
        Start();

    }

    public void Start()
    {
    	for(int i=0;i<BodyUnitsStart;i++)
    	{
    		if(i==0)
    		{

   			 x[i]=(random.nextInt((int)Width_Screen/UNIT_SIZE-4*BodyUnitsStart)+3)*UNIT_SIZE;
   			 y[i]=(random.nextInt((int)Height_Screen/UNIT_SIZE-4*BodyUnitsStart)+3)*UNIT_SIZE;
				System.out.println("x : "+x[i]+"\n"+"y : "+y[i]);
    		}
    		else
    		{
    			x[i]=x[0]-i*UNIT_SIZE;
    			y[i]=y[0];
				System.out.println("x : "+x[i]+"\n"+"y : "+y[i]);
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
				AppleEaton++;
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
		background.paintIcon(this,g,0,0);

		g.setColor(Color.BLACK);
		if(collision())
		{
			g.setFont(new Font("Ink Free", Font.BOLD, 50));
			g.drawString("Score: " + AppleEaton, 1000, 50);
			g.setFont(new Font("Ink Free",Font.BOLD,80));
			g.setColor(Color.RED);
			g.drawString("You Lost",930,130);
		}
		else {
			g.setFont(new Font("Ink Free", Font.BOLD, 50));
			g.drawString("Score: " + AppleEaton, 1000, 50);
		}
		 /*
		 g.drawLine(0,0, 0,Height_Screen);
		 g.drawLine(Width_Screen,Height_Screen, Width_Screen,0);
		 g.drawLine(0,0,Width_Screen,0);
		 g.drawLine(Width_Screen,Height_Screen, 0,Height_Screen);
		 g.drawLine(Width_Screen,Height_Screen, Width_Screen,0);
		  */
		g.setColor(Color.black);
		for(int i=0;i<Height_Screen/UNIT_SIZE;i++)
		{
			g.drawLine(0,i*UNIT_SIZE, Width_Screen,i*UNIT_SIZE);
			g.drawLine(i*UNIT_SIZE,Height_Screen, i*UNIT_SIZE,0);
		}

		g.drawLine(Width_Screen,Height_Screen, 0,Height_Screen);
		g.drawLine(Width_Screen,Height_Screen, Width_Screen,0);

        g.setColor(Color.GREEN);
		switch (AppleType) {
			case -1 -> {
				mama.paintIcon(this, g, AppleX, AppleY);
				delay -= 20;
			}
			case 0 -> stella.paintIcon(this, g, AppleX, AppleY);
			case 1 -> {
				baba.paintIcon(this, g, AppleX, AppleY);
				delay += 20;
			}
		}

        g.setColor(Color.red);
   	 for(int i=0;i< BodyUnitsStart;i++)
   	 {
   		 if(i==0)
   		 {if(!collision()) {

			 switch (keyPressed) {
				 case 'w' -> Head_U.paintIcon(this, g, x[0], y[0]);
				 case 'a' -> Head_L.paintIcon(this, g, x[0], y[0]);
				 case 's' -> Head_D.paintIcon(this, g, x[0], y[0]);
				 case 'd' -> Head_R.paintIcon(this, g, x[0], y[0]);
				 default -> keyPressed = 's';
			 }
		 }


   		 }
   		 else
   		 {
				bodyType=random.nextInt(3);
   			p[bodyType].paintIcon(this,g,x[i],y[i]);
   		 }
   	 }
}


    public  void newApple()
    {
		AppleType=random.nextInt(3)-1;
        AppleX=random.nextInt((int)Width_Screen/UNIT_SIZE)*UNIT_SIZE;
        AppleY=random.nextInt((int)Height_Screen/UNIT_SIZE)*UNIT_SIZE;
    }
    
    public boolean collision()
	{
		boolean crush=(x[0]<0||y[0]<0||x[0]==Width_Screen||y[0]==Width_Screen);
		boolean loop=false;
		for(int i=1;i<BodyUnitsStart;i++)
		{
			if(x[0]==x[i]&&y[0]==y[i])
			{
				loop=true;
				break;
			}
		}
		return loop||crush;

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
   			 y[i]=y[i+1]-UNIT_SIZE;
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
   			 y[i]=y[i+1]+UNIT_SIZE;
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
   			 x[i]=x[i+1]-UNIT_SIZE;
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
   			 x[i]=x[i+1]+UNIT_SIZE;
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
		if(!collision())
		{
				move();
				Eaton();
				repaint();
		}
		else
		{
			lose();
		}


	}

	private void lose() {

	}

	public int score() {
		return AppleEaton;
	}

	public class MyKeyAdaptor extends KeyAdapter {

    	@Override
    	public void keyPressed(KeyEvent e) {
    		// TODO Auto-generated method stub
    		System.out.println("pressed");
    		switch(e.getKeyCode())
    		{
    		case KeyEvent.VK_W:case KeyEvent.VK_UP:
			{
				if(keyPressed!='s') {

					keyPressed='w';
				}
				break;
			}

    		case KeyEvent.VK_A:case KeyEvent.VK_LEFT:
				if(keyPressed!='d')
				{
				keyPressed = 'a';
				}
    			break;
    		case KeyEvent.VK_S:case KeyEvent.VK_DOWN:
				if(keyPressed!='w')
				{
				keyPressed = 's';
				}
    			break;
    		case KeyEvent.VK_D:case KeyEvent.VK_RIGHT:
				if(keyPressed!='a')
				{
					keyPressed = 'd';
				}
				break;

    		}
    	}
}


	
}