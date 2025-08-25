import java.sql.*;
import java.util.Scanner;

public class Insert {

    public static void insert(Connection con) {
        try{
            Scanner input = new Scanner(System.in);
            int id;String name;String job_title;double salary;
            System.out.println("Enter Employee ID");
            id = input.nextInt();
            System.out.println("Enter Employee Name");
            name = input.next();
            System.out.println("Enter Employee Job Title");
            job_title = input.next();
            System.out.println("Enter Employee Salary");
            salary = input.nextDouble();

            String Query="INSERT INTO Employees (Id,name,job_title,salary) VALUES(?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, job_title);
            ps.setDouble(4, salary);
            int rowsAffected=ps.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Inserted successfully");
            }else{
                System.out.println("Insert failed");
            }
            ps.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
