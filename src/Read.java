import java.sql.*;

public class Read {

    public static void retrieve(Connection con) {
        String QUERY="Select * from employees";
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(QUERY);

            System.out.println("======================================");

            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String job_title = res.getString("job_title");
                double salary = res.getDouble("salary");

                System.out.println("Id : " + id);
                System.out.println("Name : " + name);
                System.out.println("Job title : " + job_title);
                System.out.println("Salary : " + salary);
                System.out.println("======================================");
            }

            res.close();
            st.close();

        } catch (SQLException e) {
            System.out.println("Error while retrieving: " + e.getMessage());
        }
    }
}
