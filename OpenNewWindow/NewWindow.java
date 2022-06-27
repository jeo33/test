package test;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewWindow {
	JFrame frame= new JFrame();
	JLabel l=new JLabel();
	NewWindow(){
		l.setText("hello");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.add(l);
		l.setBounds(50,50,100,100);
		
	}

}
