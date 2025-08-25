import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Prepared_Statement {
    public static void example(Connection con){
        String Query="Select * from employees where id=?;";
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1,1);
            ResultSet rs = ps.executeQuery();
            System.out.println("===============================");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println("id =" + id);
                System.out.println("name =" + name);
                System.out.println("job_title =" + job_title);
                System.out.println("salary =" + salary);
                System.out.println("================================");
            }
        }catch(SQLException e){
            System.out.println("SQLException caught");
        }
        }
}
