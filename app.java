import java.sql.*;
class JDBCExample {
  public static void main(String[] args) {
    String DB_URL = "jdbc:mysql://localhost:3306/jagrutibank";
    String USER = "root";
    String PASS = "";

    try {
      Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
      Statement stmt = conn.createStatement();
      //String sql="Create table login(formno varchar(20),cardNumber varchar(25),pin varchar(10))";
      String sql = "create table signupthree(formno varchar(20) ,accountType varchar(20),cardnumber varchar(25),pin varchar(10),facility varchar(100))";
      stmt.executeUpdate(sql);
      System.out.println("Record Delete successfully...");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}