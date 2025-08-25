import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
    public static void update(Connection con) {
         String updateQ="Update Employees set job_title = ? where id =? ;";
        try {
            PreparedStatement ps = con.prepareStatement(updateQ);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter employee ID to update :");
            int id = sc.nextInt();
            System.out.println("Enter employee job title");
            String jobTitle = sc.next();
            ps.setInt(2, id);
            ps.setString(1, jobTitle);
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected > 0) {
                System.out.println("Update Successful");
            }else{
                System.out.println("Update Failed");
            }
            ps.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
