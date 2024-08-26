import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.*;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pinTextField, rePinTextField;
    JButton change, back;
    String pinNumber;

    PinChange(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);

        JLabel text = new JLabel("Change Your Pin ");
        text.setFont(new Font("Releway", Font.BOLD, 22));
        text.setBounds(300, 40, 200, 18);
        this.add(text);

        JLabel pin = new JLabel("Enter New Pin:");
        pin.setFont(new Font("Releway", Font.BOLD, 18));
        pin.setBounds(200, 100, 200, 22);
        this.add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(350, 100, 200, 22);
        this.add(pinTextField);

        JLabel repin = new JLabel("Enter Re-Pin:");
        repin.setFont(new Font("Releway", Font.BOLD, 18));
        repin.setBounds(200, 170, 200, 22);
        this.add(repin);

        rePinTextField = new JPasswordField();
        rePinTextField.setBounds(350, 170, 200, 22);
        this.add(rePinTextField);

        change = new JButton("Change");
        change.setBackground(Color.black);
        change.setForeground(Color.white);
        change.addActionListener(this);
        change.setBounds(400, 250, 100, 22);
        this.add(change);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(400, 280, 100, 22);
        this.add(back);

        setSize(900, 450);
        setVisible(true);
        setTitle("Pin Change");
        setLocation(300, 150);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change) {
            String newPin = pinTextField.getText();
            String rePin = rePinTextField.getText();

            if (!newPin.equals(rePin)) {
                JOptionPane.showMessageDialog(null, "Your RePin Does Not Macth");
            }

            if(newPin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Plese Enter New Pin");
            }

            if(rePin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Plese Enter rePin Pin");
            }

            String DB_URL = "jdbc:mysql://localhost:3306/jagrutibank";
            String USER = "root";
            String PASS = "";
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();

                String sql="update bank set pin ='"+rePin+"'where pin='"+pinNumber+"'";
                String sql2="update login set pin='"+rePin+"'where pin='"+pinNumber+"'";
                String sql3="update signupthree set pin='"+rePin+"'where pin='"+pinNumber+"'";


                stmt.executeUpdate(sql);
                stmt.executeUpdate(sql2);
                stmt.executeUpdate(sql3);
                JOptionPane.showMessageDialog(null,"Record update   successfully...");

                setVisible(false);
                new Transaction(rePin).setVisible(true);
            } catch (Exception ob) {
                ob.printStackTrace();
            }
        }else if(e.getSource()==back)
        {
            setVisible(false);
            new Transaction("").setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
