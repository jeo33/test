package test;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LaunchPage implements ActionListener {

	JFrame frame=new JFrame();
	JButton b=new JButton("Click to open");
	LaunchPage(){
		b.setBounds(100, 160, 200, 40);
		b.setFocusable(false);
		b.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.add(b);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b)
		{
			frame.dispose();
			NewWindow mywindow=new NewWindow();
		}
	}
	
}


