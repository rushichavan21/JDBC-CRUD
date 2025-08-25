import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Batch_Process {
    public static void main(String[] args) {
        Connection con = Setup.Connect();
        try {
            con.setAutoCommit(false);
            Statement st = con.createStatement();
            st.addBatch("insert into employees(id,name,job_title,salary) values (6,'Rushi6','ceo-1',15.0)");
            st.addBatch("insert into employees(id,name,job_title,salary) values (7,'Rushi7','ceo-2',35.0)");
            st.addBatch("insert into employees(id,name,job_title,salary) values (8,'Rushi8','ceo-3',335.0)");
            int[] batchRes = st.executeBatch();
            con.commit();
            System.out.println("batch executed successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
