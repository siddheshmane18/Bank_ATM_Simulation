package bankmanagementsystem;
import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SignupThree extends JFrame implements ActionListener {
	
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String formno,name,fname,dob,gender,email,marital,address,city,state,pincode,mob, income, qualification, occupation, aadhar, senior, existing, pan;
	
	SignupThree(String formno,String name, String fname, String dob, String gender,
            String email, String marital, String address, String city, String state, String pincode,
            String mob, String income, String qualification, String occupation,
            String aadhar, String senior, String existing, String pan){
		this.formno=formno;
		this.name = name;
        this.fname = fname;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.marital = marital;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        
        this.mob=mob;
        this.income=income;
        this.qualification=qualification;
        this.occupation=occupation;
        this.aadhar=aadhar;
        this.senior=senior;
        this.existing=existing;
        this.pan=pan;
		setLayout(null);
		JLabel l1=new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Railway",Font.BOLD,22));
		l1.setBounds(280,40,400,40);
		add(l1);
		
		JLabel type=new JLabel("Account Type :");
		type.setFont(new Font("Railway",Font.BOLD,22));
		type.setBounds(100,140,200,30);
		add(type);
		
		r1=new JRadioButton("Savings Account");
		r1.setFont(new Font("Railway",Font.BOLD,16));
		r1.setBackground(Color.WHITE);
		r1.setBounds(100,180,180,30);
		add(r1);
		
		r2=new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Railway",Font.BOLD,16));
		r2.setBackground(Color.WHITE);
		r2.setBounds(350,180,250,30);
		add(r2);
		
		r3=new JRadioButton("Current Account");
		r3.setFont(new Font("Railway",Font.BOLD,16));
		r3.setBackground(Color.WHITE);
		r3.setBounds(100,220,150,30);
		add(r3);
		
		r4=new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("Railway",Font.BOLD,16));
		r4.setBackground(Color.WHITE);
		r4.setBounds(350,220,250,30);
		add(r4);
		
		ButtonGroup groupacc=new ButtonGroup();
		groupacc.add(r1);
		groupacc.add(r2);
		groupacc.add(r3);
		groupacc.add(r4);
		
		JLabel card=new JLabel("Card Number :");
		card.setFont(new Font("Railway",Font.BOLD,22));
		card.setBounds(100,300,200,30);
		add(card);
		
		JLabel number=new JLabel("xxxx-xxxx-xxxx-8446");
		number.setFont(new Font("Railway",Font.PLAIN,22));
		number.setBounds(330,300,300,30);
		add(number);
		
		JLabel dcard=new JLabel("Your 16 digit card number");
		dcard.setFont(new Font("Railway",Font.BOLD,12));
		dcard.setBounds(100,330,300,20);
		add(dcard);
		
		JLabel pin=new JLabel("PIN :");
		pin.setFont(new Font("Railway",Font.BOLD,22));
		pin.setBounds(100,370,200,30);
		add(pin);
		
		JLabel num=new JLabel("xxxx");
		num.setFont(new Font("Railway",Font.PLAIN,22));
		num.setBounds(330,370,300,30);
		add(num);
		
		JLabel dpin=new JLabel("Your 4 digit pin");
		dpin.setFont(new Font("Railway",Font.BOLD,12));
		dpin.setBounds(100,400,300,20);
		add(dpin);
		
		JLabel services=new JLabel("Services Required :");
		services.setFont(new Font("Railway",Font.BOLD,22));
		services.setBounds(100,450,250,30);
		add(services);
		
		c1=new JCheckBox("ATM CARD");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Railway",Font.BOLD,16));
		c1.setBounds(100,500,200,30);
		add(c1);
		
		c2=new JCheckBox("Internet Banking");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Railway",Font.BOLD,16));
		c2.setBounds(350,500,200,30);
		add(c2);
		
		c3=new JCheckBox("Mobile Banking");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Railway",Font.BOLD,16));
		c3.setBounds(100,550,200,30);
		add(c3);
		
		c4=new JCheckBox("EMAIL & SMS Alerts");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Railway",Font.BOLD,16));
		c4.setBounds(350,550,200,30);
		add(c4);
		
		c5=new JCheckBox("Cheque Book");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Railway",Font.BOLD,16));
		c5.setBounds(100,600,200,30);
		add(c5);
		
		c6=new JCheckBox("E-statement");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Railway",Font.BOLD,16));
		c6.setBounds(350,600,200,30);
		add(c6);
		
		c7=new JCheckBox("I hereby declare that the above entered details are correct.");
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Railway",Font.BOLD,12));
		c7.setBounds(100,680,600,30);
		add(c7);
		
		submit =new JButton("Submit");
//		submit.setBackground(Color.BLACK);
//		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Railway",Font.BOLD,14));
		submit.setBounds(250,720,100,30);
		submit.addActionListener(this);
		add(submit);
		
		cancel =new JButton("Cancel");
//		cancel.setBackground(Color.BLACK);
//		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Railway",Font.BOLD,14));
		cancel.setBounds(420,720,100,30);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
		else if(ae.getSource()==submit) {
			String accType=null;
			if(r1.isSelected()) {
				accType="Saving Account";
			}
			else if(r2.isSelected()) {
				accType="Fixed Deposit";
			}
			else if(r3.isSelected()) {
				accType="Current Account";
			}
			else if(r4.isSelected()) {
				accType="Recurring Deposit";
			}
			Random random=new Random();
			String cardNo=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
			String pinNo=""+Math.abs(random.nextLong()%9000L)+1000L;
			String Facility="";
			if(c1.isSelected()) {
				Facility=Facility+"ATM Card";
			} if(c2.isSelected()) {
				Facility=Facility+",Internet Banking";
			} if(c3.isSelected()) {
				Facility=Facility+",Mobile Banking";
			} if(c4.isSelected()) {
				Facility=Facility+",Email & SMS Alerts";
			} if(c5.isSelected()) {
				Facility=Facility+",Cheque Book";
			} if(c6.isSelected()) {
				Facility=Facility+",E-Statement";
			}
			
			try {
				if(accType == null) {
				    JOptionPane.showMessageDialog(null,"Account Type is required");
				    return;
				}

				if(!c7.isSelected()) {
				    JOptionPane.showMessageDialog(null,"Please accept declaration");
				    return;
				}

				if(Facility.equals("")) {
				    JOptionPane.showMessageDialog(null,"Select at least one service");
				    return;
				}else {
					Conn conn=new Conn();
					String query = "insert into customer values('"+formno+"','"+name+"','"+fname+"',"
							+ "'"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"',"
									+ "'"+state+"','"+pincode+"','"+mob+"','"+income+"','"+qualification+"',"
											+ "'"+occupation+"','"+aadhar+"','"+senior+"','"+existing+"','"+pan+"',"
													+ "'"+accType+"','"+cardNo+"','"+pinNo+"','"+Facility+"')";
					conn.s.executeUpdate(query);
					
					JOptionPane.showMessageDialog(null, "Card Number: "+cardNo+"\n Pin: "+pinNo);
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
	}

	public static void main(String[] args) {
		new SignupThree("","","","","","","","","","","","","","","","","","","");
	}

}
