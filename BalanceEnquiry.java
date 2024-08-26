import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back, chek;
    String pinNumber;
    BalanceEnquiry(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);

        JLabel text = new JLabel("JAGRUTI BANK");
        text.setBounds(200, 40, 200, 22);
        text.setFont(new Font("Releway", Font.BOLD, 22));
        this.add(text);
        int balance = 0;
        String DB_URL = "jdbc:mysql://localhost:3306/jagrutibank";
            String USER = "root";
            String PASS = "";
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();

               String sql="select * From bank where pin='"+pinNumber+"'";
               ResultSet rs= stmt.executeQuery(sql);
               while(rs.next())
               {
                if (rs.getString("type").equals("deposit"))  {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            } catch (Exception ob) {
                ob.printStackTrace();
            }

        JLabel balanceText = new JLabel("Your Balance is " + balance);
        balanceText.setBounds(200, 100, 200, 22);
        this.add(balanceText);

        back = new JButton("Back");
        back.setBounds(380, 400, 100, 22);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        this.add(back);

        setSize(600, 600);
        setVisible(true);
        setLocation(350, 80);
        setTitle("Balance Enquiry");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }


    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}