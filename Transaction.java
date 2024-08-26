import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transaction extends JFrame  implements ActionListener
{
    JButton deposit,withdrawl,pinchange,balanceenquiry,exit;
    String pinNumber;
    Transaction(String pinNumber)
    {
        this.pinNumber=pinNumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100, 900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        this.add(image);

        JLabel text=new JLabel("Please Select Transaction");
        text.setBounds(250,230,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,15));
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(250,320 ,130, 20);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(450, 320, 130, 20);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

       

        

        pinchange=new JButton("Pin Change");
        pinchange.setBounds(450,360, 130, 20);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(250,360, 130, 20);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit=new JButton("Exit");
        exit.setBounds(450,410, 130, 20);
        exit.addActionListener(this);
        image.add(exit);
 
        setSize(900,900);
        setVisible(true);
        setLocation(300,0);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==exit)
        {
            System.exit(0);
        }else if(e.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }else if(e.getSource()==withdrawl)
        {
            setVisible(false);
            new Withdraw(pinNumber).setVisible(true);
        }else if(e.getSource()==pinchange)
        {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);

        }else if(e.getSource()==balanceenquiry)
        {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        Transaction ob=new Transaction("");
    }
}
