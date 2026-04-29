package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField mobTextField,aadharTextField,panTextField;
    JButton next;
    JComboBox incomeCategories,qualCategories,occCategories;

    JRadioButton seniorYes,seniorNo,existingYes,existingNo;
    
    String formno,name,fname,dob,gender,email,marital,address,city,state,pincode;
    
    SignupTwo(String formno, String name, String fname, String dob, String gender,
            String email, String marital, String address, String city, String state, String pincode){

        this.formno = formno;
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
        setLayout(null);

        setTitle("New Account Application Form Page - 2");

        JLabel form=new JLabel("Application Form");
        form.setFont(new Font("Railway",Font.BOLD,38));
        form.setBounds(260,20,600,40);
        add(form);

        JLabel additionalDetails=new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Railway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel mob=new JLabel("Mobile Number:");
        mob.setBounds(100,140,200,30);
        add(mob);

        mobTextField=new JTextField();
        mobTextField.setBounds(300,140,400,30);
        add(mobTextField);
//
//        JLabel accountType=new JLabel("Account Type:");
//        accountType.setBounds(100,190,200,30);
//        add(accountType);
//
//        String valaccountType[]={"Savings","Salary","FD","RD"};
//        accountTypes=new JComboBox(valaccountType);
//        accountTypes.setBounds(300,190,400,30);
//        add(accountTypes);

        JLabel income=new JLabel("Income:");
        income.setBounds(100,190,200,30);
        add(income);

        String incomeCategory[]={"<1L","<2.5L","<5L","<10L","Above"};
        incomeCategories=new JComboBox(incomeCategory);
        incomeCategories.setBounds(300,190,400,30);
        add(incomeCategories);

        JLabel qualification=new JLabel("Qualification:");
        qualification.setBounds(100,240,200,30);
        add(qualification);

        String qualCategory[]={"Graduate","Post Graduate","Other"};
        qualCategories=new JComboBox(qualCategory);
        qualCategories.setBounds(300,240,400,30);
        add(qualCategories);

        JLabel occupation=new JLabel("Occupation:");
        occupation.setBounds(100,290,200,30);
        add(occupation);

        String occCategory[]={"Salaried","Self-Employed","Student","Retired","Other"};
        occCategories=new JComboBox(occCategory);
        occCategories.setBounds(300,290,400,30);
        add(occCategories);

        JLabel aadhar=new JLabel("Aadhar:");
        aadhar.setBounds(100,340,200,30);
        add(aadhar);

        aadharTextField=new JTextField();
        aadharTextField.setBounds(300,340,400,30);
        add(aadharTextField);

        JLabel senior=new JLabel("Senior Citizen:");
        senior.setBounds(100,440,200,30);
        add(senior);

        seniorYes=new JRadioButton("Yes");
        seniorYes.setBounds(300,440,80,30);
        seniorYes.setBackground(Color.WHITE);
        add(seniorYes);

        seniorNo=new JRadioButton("No");
        seniorNo.setBounds(400,440,80,30);
        seniorNo.setBackground(Color.WHITE);
        add(seniorNo);

        ButtonGroup bg1=new ButtonGroup();
        bg1.add(seniorYes);
        bg1.add(seniorNo);

        JLabel existing=new JLabel("Existing Account:");
        existing.setBounds(100,490,200,30);
        add(existing);

        existingYes=new JRadioButton("Yes");
        existingYes.setBounds(300,490,80,30);
        existingYes.setBackground(Color.WHITE);
        add(existingYes);

        existingNo=new JRadioButton("No");
        existingNo.setBounds(400,490,80,30);
        existingNo.setBackground(Color.WHITE);
        add(existingNo);

        ButtonGroup bg2=new ButtonGroup();
        bg2.add(existingYes);
        bg2.add(existingNo);

        JLabel pan=new JLabel("PAN:");
        pan.setBounds(100,390,200,30);
        add(pan);

        panTextField=new JTextField();
        panTextField.setBounds(300,390,400,30);
        add(panTextField);

        next=new JButton("NEXT");
        next.setBounds(620,570,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,750);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        String mob=mobTextField.getText();
//        String accountType=(String)accountTypes.getSelectedItem();
        String income=(String)incomeCategories.getSelectedItem();
        String qualification=(String)qualCategories.getSelectedItem();
        String occupation=(String)occCategories.getSelectedItem();
        String aadhar=aadharTextField.getText();

        String senior=null;
        if(seniorYes.isSelected()) senior="Yes";
        else if(seniorNo.isSelected()) senior="No";

        String existing=null;
        if(existingYes.isSelected()) existing="Yes";
        else if(existingNo.isSelected()) existing="No";

        String pan=panTextField.getText();

        try{
        	if(mob.equals("")) {
        	    JOptionPane.showMessageDialog(null,"Mobile Number is required");
        	    return;
        	}
        	if(mob.length() != 10) {
        	    JOptionPane.showMessageDialog(null,"Invalid Mobile Number");
        	    return;
        	}
        	if(aadhar.equals("")) {
        	    JOptionPane.showMessageDialog(null,"Aadhar Number is required");
        	    return;
        	}
        	if(aadhar.length() != 12) {
        	    JOptionPane.showMessageDialog(null,"Invalid Aadhar Number");
        	    return;
        	}
        	if(pan.equals("")) {
        	    JOptionPane.showMessageDialog(null,"PAN Number is required");
        	    return;
        	}
        	if(income == null) {
        	    JOptionPane.showMessageDialog(null,"Select Income");
        	    return;
        	}
        	if(qualification == null) {
        	    JOptionPane.showMessageDialog(null,"Select Qualification");
        	    return;
        	}
        	if(occupation == null) {
        	    JOptionPane.showMessageDialog(null,"Select Occupation");
        	    return;
        	}
        	if(senior == null) {
        	    JOptionPane.showMessageDialog(null,"Select Senior Citizen option");
        	    return;
        	}
        	if(existing == null) {
        	    JOptionPane.showMessageDialog(null,"Select Existing Account option");
        	    return;
        	}
            else{
//                Conn c=new Conn();
//'"+accountType+"',
//                String query="insert into signuptwo values('"+formno+"','"+mob+"','"+income+"','"+qualification+"','"+occupation+"','"+aadhar+"','"+senior+"','"+existing+"','"+pan+"')";
//                
//                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno, name, fname, dob, gender, email, marital, address, city, state, pincode,
                        mob, income, qualification, occupation, aadhar, senior, existing, pan).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        new SignupTwo("","","","","","","","","","","");
    }
}