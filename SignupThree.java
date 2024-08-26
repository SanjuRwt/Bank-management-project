import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

     JCheckBox AtmCard, InterNetBanking, mobileBanking, EmailAlert, chequeBook, eStatement, declaretion;
    JRadioButton savingaccount,fixedDeposit,currentaccount,reccuringaccount;
    JButton submit,cancel;
    String formno;

    SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);
        JLabel accountDetails=new JLabel("Page 3:Account Details");
       accountDetails.setFont(new Font("Releway",Font.BOLD,22));
       accountDetails.setBounds(280, 40, 400, 40);
       this.add(accountDetails);

       JLabel type=new JLabel("Account Type");
       type.setFont(new Font("Releway",Font.BOLD,22));
       type.setBounds(100, 140, 200, 30);
       this.add(type);

       savingaccount=new JRadioButton("Saving Account");
       savingaccount.setFont(new Font("Releway", Font.BOLD,16));
       savingaccount.setBackground(Color.white);
       savingaccount.setBounds(100, 190, 150, 20);
       this.add(savingaccount);

       fixedDeposit=new JRadioButton("Fixed Deposit Account");
       fixedDeposit.setFont(new Font("Releway", Font.BOLD,16));
       fixedDeposit.setBackground(Color.white);
       fixedDeposit.setBounds(300, 190, 200, 20);
       this.add(fixedDeposit);

       currentaccount=new JRadioButton("Current Account");
       currentaccount.setFont(new Font("Releway", Font.BOLD,16));
       currentaccount.setBackground(Color.white);
       currentaccount.setBounds(100, 220, 200, 20);
       this.add(currentaccount);

       reccuringaccount=new JRadioButton("Recrring  Account");
       reccuringaccount.setFont(new Font("Releway", Font.BOLD,16));
       reccuringaccount.setBackground(Color.white);
       reccuringaccount.setBounds(300, 220, 200, 20);
       this.add(reccuringaccount);

       ButtonGroup accountButton=new ButtonGroup();
       accountButton.add(savingaccount);
       accountButton.add(fixedDeposit);
       accountButton.add(currentaccount);
       accountButton.add(reccuringaccount);

    

       JLabel services=new JLabel("Services Requried:");
       services.setFont(new Font("Releway",Font.BOLD,22));
       services.setBounds(100, 270, 200, 30);
       this.add(services);

       AtmCard=new JCheckBox("ATM");
       AtmCard.setBackground(Color.white);
       AtmCard.setFont(new Font("Releway",Font.BOLD,16));
       AtmCard.setBounds(100, 300, 100, 30);
       this.add(AtmCard);

       InterNetBanking=new JCheckBox("Internet Banking");
       InterNetBanking.setBackground(Color.white);
       InterNetBanking.setFont(new Font("Releway",Font.BOLD,16));
       InterNetBanking.setBounds(350, 300, 300, 30);
       this.add(InterNetBanking);

       mobileBanking=new JCheckBox("Mobile Banking");
       mobileBanking.setBackground(Color.white);
       mobileBanking.setFont(new Font("Releway",Font.BOLD,16));
       mobileBanking.setBounds(100, 330, 200, 30);
       this.add(mobileBanking);

       EmailAlert=new JCheckBox("Email & Sms Alerts");
       EmailAlert.setBackground(Color.white);
       EmailAlert.setFont(new Font("Releway",Font.BOLD,16));
       EmailAlert.setBounds(350, 330, 300, 30);
       this.add(EmailAlert);

       chequeBook=new JCheckBox("Cheque Book");
       chequeBook.setBackground(Color.white);
       chequeBook.setFont(new Font("Releway",Font.BOLD,16));
       chequeBook.setBounds(100, 355, 200, 30);
       this.add(chequeBook);

       eStatement=new JCheckBox("E-Statement");
       eStatement.setBackground(Color.white);
       eStatement.setFont(new Font("Releway",Font.BOLD,16));
       eStatement.setBounds(350, 355, 300, 30);
       this.add(eStatement);
   
       declaretion=new JCheckBox("HereBy Declare that the above enterd details are current to the best of my knowledge");
       declaretion.setBackground(Color.white);
       declaretion.setFont(new Font("Releway",Font.BOLD,12));
       declaretion.setBounds(100, 400, 600, 30);
       this.add(declaretion);

        submit=new JButton("Submit");
       submit.setBackground(Color.black);
       submit.setForeground(Color.white);
       submit.setFont(new Font("Releway",Font.BOLD,22));
       submit.setBounds(220, 440, 150, 30);
       submit.addActionListener(this);
       this.add(submit);

       cancel=new JButton("Cancel");
       cancel.setBackground(Color.black);
       cancel.setForeground(Color.white);
       cancel.setFont(new Font("Releway",Font.BOLD,22));
       cancel.setBounds(420, 440, 150, 30);
       cancel.addActionListener(this);
       this.add(cancel);

       setSize(900, 850);
       setLocation(350, 0);
       getContentPane().setBackground(Color.white);
       setVisible(true); 

        

    }

    public void actionPerformed(ActionEvent ae) {
        String atype = null;
        if (savingaccount.isSelected()) {
            atype = "Saving Account";
        } else if (fixedDeposit.isSelected()) {
            atype = "Fixed Deposit Account";
        } else if (currentaccount.isSelected()) {
            atype = "Current Account";
        } else if (reccuringaccount.isSelected()) {
            atype = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        String facility = "";
        if (AtmCard.isSelected()) {
            facility = facility + " ATM Card";
        }
        if (InterNetBanking.isSelected()) {
            facility = facility + " Internet Banking";
        }
        if (mobileBanking.isSelected()) {
            facility = facility + " Mobile Banking";
        }
        if (EmailAlert.isSelected()) {
            facility = facility + " EMAIL Alerts";
        }
        if (chequeBook.isSelected()) {
            facility = facility + " Cheque Book";
        }
        if (eStatement.isSelected()) {
            facility = facility + " E-Statement";
        }

        try {
            if (ae.getSource() == submit) {

                if (atype.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else {
                    String DB_URL = "jdbc:mysql://localhost:3306/jagrutibank";
                    String USER = "root";
                    String PASS = "";
                    try {
                        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        Statement stmt = conn.createStatement();

                        String sql = "insert into signupthree values('" + formno + "','" + atype + "','" + cardno
                                + "','" + pin + "','" + facility + "')";
                        String sql2 = "insert into login values('" + formno + "','" + cardno + "','" + pin + "')";
                        stmt.executeUpdate(sql);
                        stmt.executeUpdate(sql2);
                        System.out.println("Record insert  successfully...");

                        JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:" + pin);
                    } catch (Exception ob) {
                        ob.printStackTrace();
                    }
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }

            } else if (ae.getSource() == cancel) {
                System.exit(0);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new SignupThree("");
    }

}