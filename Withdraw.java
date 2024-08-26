import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.swing.*;

public class Withdraw extends JFrame implements ActionListener {
    JLabel amount;
    JTextField amountTextField;
    JButton withdraw, back;
    String pinNumber;

    Withdraw(String pinNumber) {
        this.pinNumber = pinNumber;
        setTitle("Deposit Page");
        amount = new JLabel("Enter Withdraw Amount:");
        amount.setFont(new Font("Releway", Font.BOLD, 22));
        amount.setBounds(50, 120, 300, 22);
        this.add(amount);

        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Releway", Font.BOLD, 22));
        amountTextField.setBounds(310, 120, 200, 22);
        this.add(amountTextField);

        withdraw = new JButton("Withdraw");
        withdraw.setBackground(Color.WHITE);
        withdraw.setBounds(400, 220, 100, 22);
        withdraw.addActionListener(this);
        this.add(withdraw);

        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setBounds(400, 250, 100, 22);
        back.addActionListener(this);
        this.add(back);

        setLayout(null);
        setVisible(true);
        setSize(800, 450);
        setLocation(350, 200);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdraw) {
            String number = amountTextField.getText();
            Date date = new Date();
            if (number.equals("e")) {
                JOptionPane.showMessageDialog(this, "Pelese Enter Amount Your Deposit");
            }

            else {
                String DB_URL = "jdbc:mysql://localhost:3306/jagrutibank";
                String USER = "root";
                String PASS = "";

                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    Statement stmt = conn.createStatement();
                    String sql = "insert into bank Values('" + pinNumber + "','" + date + "','withdraw','" + number
                            + "')";
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Rs" + number + "withdraw Succesfull");

                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                } catch (Exception on) {
                    on.printStackTrace();
                }
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}
