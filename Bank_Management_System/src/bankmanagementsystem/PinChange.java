package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
	
	JPasswordField pin,repin;
	JButton back,change;
	String CardNo;
	
	PinChange(String CardNo){
		this.CardNo=CardNo;
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text=new JLabel("Change Your PIN");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(270,280,500,35); 
		image.add(text);
		
		JLabel pintext=new JLabel("New PIN:");
		pintext.setForeground(Color.WHITE);
		pintext.setFont(new Font("System",Font.PLAIN,16));
		pintext.setBounds(165,320,180,25); 
		image.add(pintext);
		
		 pin=new JPasswordField();
		pin.setFont(new Font("Railway",Font.BOLD,25));
		pin.setBounds(330,320,180,25);
		image.add(pin);
		
		
		JLabel repintext=new JLabel("Re-Enter New PIN:");
		repintext.setForeground(Color.WHITE);
		repintext.setFont(new Font("System",Font.PLAIN,16));
		repintext.setBounds(165,360,180,25); 
		image.add(repintext);
		
		 repin=new JPasswordField();
		repin.setFont(new Font("Railway",Font.BOLD,25));
		repin.setBounds(330,360,180,25);
		image.add(repin);
		
		 change=new JButton("CHANGE");
		change.setBounds(355,485,150,30);
		change.setContentAreaFilled(false);
		 change.setFocusPainted(false);
		 change.setForeground(Color.decode("#E5B567"));
		 change.addActionListener(this);
		image.add(change);
		
		 back=new JButton("BACK");
		back.setBounds(355,520,150,30);
		back.setContentAreaFilled(false);
		 back.setFocusPainted(false);
		 back.setForeground(Color.decode("#E5B567"));
		 back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setLocation(300,10);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==change) {
			try {
				String npin=pin.getText();
				String rpin=repin.getText();
				if(!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Entered PIN does not match");
					return;
				}
				if(npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter the new PIN");
					return;
				}
				if(rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please re-enter the new PIN");
					return;
				}
				Conn conn=new Conn();
				String q1="update customer set pinNumber = '"+rpin+"' where cardNumber='"+CardNo+"'";
				conn.s.executeUpdate(q1);
				JOptionPane.showMessageDialog(null, "PIN updated Successfully");
				setVisible(false);
				new Transactions(CardNo).setVisible(true);
				
			}catch(Exception e){
				System.out.println(e);
			}
		}else {
			setVisible(false);
			new Transactions(CardNo).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}

}
