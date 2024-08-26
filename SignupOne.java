import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class SignupOne extends JFrame implements ActionListener{
    
    JLabel text,personalTextField,nameLabel,fnameLabel,dobLabel,genderLabel,emailaddressLabel,meritalLabel,addressLabel,cityLabel,pincodelabel,stateLabel,dateLAbel,monthLAbel,yearLAbel;

    JTextField nameTextField,fnameTextField,emilTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JRadioButton male,feMale,marride,unmarride,other;
    JButton b;
    JDateChooser dateChooser;
    
    
    Random ran = new Random();
    long firsaddressTextField = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(firsaddressTextField);
    
    SignupOne(){
        
        setTitle("NEW ACCOUNT APPLICATION FORM");
        
        
        text = new JLabel("APPLICATION FORM NO. "+first);
        text.setFont(new Font("Raleway", Font.BOLD, 38));
        
        personalTextField = new JLabel("Page 1: Personal Details");
        personalTextField.setFont(new Font("Raleway", Font.BOLD, 22));
        
        nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        
        fnameLabel = new JLabel("Father's Name:");
        fnameLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        
        dobLabel = new JLabel("Date of Birth:");
        dobLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        
        genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        
        emailaddressLabel = new JLabel("Email Address:");
        emailaddressLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        
        meritalLabel = new JLabel("Marital Status:");
        meritalLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        
        addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        
        cityLabel = new JLabel("City:");
        cityLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        
        pincodelabel = new JLabel("Pin Code:");
        pincodelabel.setFont(new Font("Raleway", Font.BOLD, 20));
        
        stateLabel = new JLabel("State:");
        stateLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        
        dateLAbel = new JLabel("Date");
        dateLAbel.setFont(new Font("Raleway", Font.BOLD, 14));
        
        monthLAbel = new JLabel("Month");
        monthLAbel.setFont(new Font("Raleway", Font.BOLD, 14));
        
        yearLAbel = new JLabel("Year");
        yearLAbel.setFont(new Font("Raleway", Font.BOLD, 14));
        
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        
        emilTextField = new JTextField();
        emilTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        
       
        
        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        
        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.BOLD, 14));
        male.setBackground(Color.WHITE);
        
        feMale = new JRadioButton("Female");
        feMale.setFont(new Font("Raleway", Font.BOLD, 14));
        feMale.setBackground(Color.WHITE);
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(male);
        groupgender.add(feMale);
        
        marride = new JRadioButton("Married");
        marride.setFont(new Font("Raleway", Font.BOLD, 14));
        marride.setBackground(Color.WHITE);
        
        unmarride = new JRadioButton("Unmarried");
        unmarride.setFont(new Font("Raleway", Font.BOLD, 14));
        unmarride.setBackground(Color.WHITE);
        
        other = new JRadioButton("Other");
        other.setFont(new Font("Raleway", Font.BOLD, 14));
        other.setBackground(Color.WHITE);
        
        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(marride);
        groupstatus.add(unmarride);
        groupstatus.add(other);
        
        dateChooser = new JDateChooser();
	
	dateChooser.setForeground(new Color(105, 105, 105));
	dateChooser.setBounds(137, 337, 200, 29);
	add(dateChooser);
        
        setLayout(null);
        text.setBounds(140,20,600,40);
        add(text);
        
        personalTextField.setBounds(290,80,600,30);
        add(personalTextField);
        
        nameLabel.setBounds(100,140,100,30);
        add(nameLabel);
        
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        fnameLabel.setBounds(100,190,200,30);
        add(fnameLabel);
        
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        dobLabel.setBounds(100,240,200,30);
        add(dobLabel);
        
        dateChooser.setBounds(300, 240, 400, 30);
        
        genderLabel.setBounds(100,290,200,30);
        add(genderLabel);
        
        male.setBounds(300,290,60,30);
        add(male);
        
        feMale.setBounds(450,290,90,30);
        add(feMale);
        
        emailaddressLabel.setBounds(100,340,200,30);
        add(emailaddressLabel);
        
        emilTextField.setBounds(300,340,400,30);
        add(emilTextField);
        
        meritalLabel.setBounds(100,390,200,30);
        add(meritalLabel);
        
        marride.setBounds(300,390,100,30);
        add(marride);
        
        unmarride.setBounds(450,390,100,30);
        add(unmarride);
        
        other.setBounds(635,390,100,30);
        add(other);
        
        
        
        addressLabel.setBounds(100,440,200,30);
        add(addressLabel);
        
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        cityLabel.setBounds(100,490,200,30);
        add(cityLabel);
        
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        pincodelabel.setBounds(100,540,200,30);
        add(pincodelabel);
        
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        stateLabel.setBounds(100,590,200,30);
        add(stateLabel);
        
        pincodeTextField.setBounds(300,590,400,30);
        add(pincodeTextField);
        
        b.setBounds(620,630,80,30);
        add(b);
        
        b.addActionListener(this); 
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(300,20);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String formno = first;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){ 
            gender = "Male";
        }else if(feMale.isSelected()){ 
            gender = "Female";
        }
            
        String email = emilTextField.getText();
        String marital = null;
        if(marride.isSelected()){ 
            marital = "Married";
        }else if(unmarride.isSelected()){ 
            marital = "Unmarried";
        }else if(other.isSelected()){ 
            marital = "Other";
        }
           
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pincode = stateTextField.getText();
        String state = pincodeTextField.getText();
        

        String DB_URL = "jdbc:mysql://localhost:3306/jagrutibank";
    String USER = "root";
    String PASS = "";
    try {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
  
        String sql="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
        stmt.executeUpdate(sql);
        System.out.println("Record insert  successfully...");
      } catch (Exception ob) {
        ob.printStackTrace();
      }

      setVisible(false);
      new SignupTwo(formno).setVisible(true);
        
    }
    
    
    public static void main(String[] args){
        new SignupOne().setVisible(true);
    }
}

