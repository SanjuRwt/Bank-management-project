import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Login extends JFrame implements ActionListener
{
    JButton login,clear,signup;
    JTextField cardNoTextField;
    JPasswordField pinNoTextField;
    String pinNumber;
    Login(String pinNumber)
    {
        this.pinNumber=pinNumber;
        setTitle("Login Page");
        setLayout(null);
        ImageIcon logoImage=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=logoImage.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(70,10,100,100);
        this.add(l1);

        JLabel text=new JLabel("Welcome Jagruti Bank");
        text.setFont(new Font("Osward",Font.BOLD,34));
        text.setBounds(200, 40, 400, 40);
        this.add(text);

        JLabel cardNo=new JLabel("Enter Pin No:");
        cardNo.setFont(new Font("Relway",Font.BOLD,20));
        cardNo.setBounds(120, 200, 200 , 30);
        this.add(cardNo); 

        cardNoTextField=new JTextField();
        cardNoTextField.setBounds(300, 150 , 250 , 30);
        this.add(cardNoTextField);

        JLabel pin=new JLabel("ENTER CARD NO:");
        pin.setFont(new Font("Relway",Font.BOLD,20));
        pin.setBounds(120, 150, 250 , 30);
        this.add(pin);

    
        pinNoTextField=new JPasswordField();
        pinNoTextField.setBounds(300, 200,250, 30);
        this.add(pinNoTextField);

        login=new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.addActionListener(this);
        login.setForeground(Color.WHITE);
        this.add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        clear.addActionListener(this);
        this.add(clear);

        signup=new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        this.add(signup);
        getContentPane().setBackground(Color.white);

        setVisible(true);
        setSize(800, 450);
        setLocation(350, 200);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==clear)
        {
            cardNoTextField.setText("");
            pinNoTextField.setText("");
        }else if(e.getSource()==login)
        {
          
            String DB_URL = "jdbc:mysql://localhost:3306/jagrutibank";
            String USER = "root";
            String PASS = "";
        
            try {
              Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
              Statement stmt = conn.createStatement();
              String cardNumber=cardNoTextField.getText();
              String pinNumber=pinNoTextField.getText();
              String sql="select * from login where cardNumber ='"+cardNumber+"'and pin='"+pinNumber+"'";
              ResultSet rrrs= stmt.executeQuery(sql);
              if(rrrs.next())
              {
                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
              }else{
                JOptionPane.showMessageDialog(null,"Incorrect CardNumber And PinNumber");
              }
            } catch (Exception ob) {
             System.out.println(ob);
            }
        }else if(e.getSource()==signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }

    }

    public static void main(String[] args) {
        Login ob=new Login("");
}
}

