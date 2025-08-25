import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {

    public static void delete(Connection con){
        String Query="Delete from employees WHERE id=?;";
        try{
            PreparedStatement ps = con.prepareStatement(Query);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Employee ID to delete");
            int id = sc.nextInt();
            ps.setInt(1, id);;
         int rowsAffected=ps.executeUpdate();
         if(rowsAffected>0){
             System.out.println("Row Deleted Successfully");
         }else {
             System.out.println("Row Not Deleted Successfully");
         }
        ps.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
