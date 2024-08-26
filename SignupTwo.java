import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SignupTwo extends JFrame implements ActionListener
{
    JLabel additonalDetails,relig,categ,incom,educational,occupat,panNNumber,aadharNumber,seniorCitizen,existingAccount,quali,formNo,formNumber;
    JButton b;
    JRadioButton syes,sno,eyes,eno;
    JTextField raleway,rale;
    String formno;
    JComboBox religions,categorys,incomes,educations,occupations;
    SignupTwo(String formno)
    {
        this.formno=formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        additonalDetails = new JLabel("Page 2: ADDITONAL DETAILS");
        additonalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        
        relig = new JLabel("Religion:");
        relig.setFont(new Font("Raleway", Font.BOLD, 18));

        categ = new JLabel("Category:");
        categ.setFont(new Font("Raleway", Font.BOLD, 18));
        
        incom= new JLabel("Income:");
        incom.setFont(new Font("Raleway", Font.BOLD, 18));
        
        educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 18));
        
        quali = new JLabel("Qualification:");
        quali.setFont(new Font("Raleway", Font.BOLD, 18));
        
        occupat = new JLabel("Occupation:");
       occupat.setFont(new Font("Raleway", Font.BOLD, 18));
        
        panNNumber = new JLabel("Pan Number:");
        panNNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        
        aadharNumber = new JLabel("Aadhar Number:");
        aadharNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        
        seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 18));
        
        existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 18));
        
        formNo = new JLabel("Form No:");
        formNo.setFont(new Font("Raleway", Font.BOLD, 13));
        
        formNumber = new JLabel(formno);
        formNumber.setFont(new Font("Raleway", Font.BOLD, 13));
        
        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
    
        
        raleway = new JTextField();
        raleway.setFont(new Font("Raleway", Font.BOLD, 14));
        
        rale = new JTextField();
        rale.setFont(new Font("Raleway", Font.BOLD, 14));
        
        syes = new JRadioButton("Yes");
        syes.setFont(new Font("Raleway", Font.BOLD, 14));
        syes.setBackground(Color.WHITE);
        
        sno = new JRadioButton("No");
        sno.setFont(new Font("Raleway", Font.BOLD, 14));
        sno.setBackground(Color.WHITE);
        
        eyes = new JRadioButton("Yes");
        eyes.setFont(new Font("Raleway", Font.BOLD, 14));
        eyes.setBackground(Color.WHITE);
        
        eno = new JRadioButton("No");
        eno.setFont(new Font("Raleway", Font.BOLD, 14));
        eno.setBackground(Color.WHITE);
        
        String religion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religions = new JComboBox<>(religion);
        religions.setBackground(Color.WHITE);
        religions.setFont(new Font("Raleway", Font.BOLD, 14));
        setLayout(null);

        String category[] = {"General","OBC","SC","ST","Other"};
        categorys = new JComboBox<>(category);
        categorys.setBackground(Color.WHITE);
        categorys.setFont(new Font("Raleway", Font.BOLD, 14));
        formNo.setBounds(700,10,60,30);
        add(formNo);

        String income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        incomes = new JComboBox<>(income);
        incomes.setBackground(Color.WHITE);
        incomes.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        educations = new JComboBox<>(education);
        educations.setBackground(Color.WHITE);
        educations.setFont(new Font("Raleway", Font.BOLD, 14));
        formNumber.setBounds(760,10,60,30);
        add(formNumber);

         String occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occupations = new JComboBox<>(occupation);
        occupations.setBackground(Color.WHITE);
        occupations.setFont(new Font("Raleway", Font.BOLD, 14));
        
        additonalDetails.setBounds(280,30,600,40);
        add(additonalDetails);
        
        relig.setBounds(100,120,100,30);
        add(relig);
        
        religions.setBounds(350,120,320,30);
        add(religions);
        
        categ.setBounds(100,170,100,30);
        add(categ);
        
        categorys.setBounds(350,170,320,30);
        add(categorys);
        
        incom.setBounds(100,220,100,30);
        add(incom);
        
        incomes.setBounds(350,220,320,30);
        add(incomes);
        
        educational.setBounds(100,270,150,30);
        add(educational);
        
        educations.setBounds(350,270,320,30);
        add(educations);
        
        quali.setBounds(100,290,150,30);
        add(quali);
        
        occupat.setBounds(100,340,150,30);
        add(occupat);
        
        occupations.setBounds(350,340,320,30);
        add(occupations);
        
        panNNumber.setBounds(100,390,150,30);
        add(panNNumber);
        
        raleway.setBounds(350,390,320,30);
        add(raleway);
        
        aadharNumber.setBounds(100,440,180,30);
        add(aadharNumber);
        
        rale.setBounds(350,440,320,30);
        add(rale);
        
        seniorCitizen.setBounds(100,490,150,30);
        add(seniorCitizen);
        
        syes.setBounds(350,490,100,30);
        add(syes);
        
        sno.setBounds(460,490,100,30);
        add(sno);
        
        existingAccount.setBounds(100,540,180,30);
        add(existingAccount);
        
        eyes.setBounds(350,540,100,30);
        add(eyes);
        
        eno.setBounds(460,540,100,30);
        add(eno);
        
        b.setBounds(570,640,100,30);
       this.add(b);
        
        b.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
    setVisible(true);
    setLocation(350, 10);

    }
    public void actionPerformed(ActionEvent ae){
        String religion = (String)religions.getSelectedItem(); 
        String category = (String)categorys.getSelectedItem();
        String income = (String)incomes.getSelectedItem();
        String education = (String)educations.getSelectedItem();
        String occupation = (String)occupations.getSelectedItem();

        String pan = panNNumber.getText();
        String aadhar = aadharNumber.getText();
        
        String scitizen = "";
        if(syes.isSelected()){ 
            scitizen = "Yes";
        }
        else if(sno.isSelected()){ 
            scitizen = "No";
        }
           
        String eaccount = "";
        if(eyes.isSelected()){ 
            eaccount = "Yes";
        }else if(eno.isSelected()){ 
            eaccount = "No";
        }


    String DB_URL = "jdbc:mysql://localhost:3306/jagrutibank";
    String USER = "root";
    String PASS = "";
    try {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
    
       String sql="insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";
        stmt.executeUpdate(sql);
        System.out.println("Record insert  successfully...");
      } catch (Exception ob) {
        ob.printStackTrace();
      }
      setVisible(false);
      new SignupThree(formno).setVisible(true);


    }
    public static void main(String[] args) {
        SignupTwo obj=new SignupTwo(" ");
    }
}
