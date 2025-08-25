import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction_Handling {
    public static final String withdrawQ="Update accounts SET balance = balance - ? where account_number=?;";
    public static final String depositeQ="Update accounts SET balance = balance + ? where account_number=?;";
    public static void main(String[] args) {
        Connection con = Setup.Connect();

        try {
            con.setAutoCommit(false);
            PreparedStatement withdrawStatement = con.prepareStatement(withdrawQ);
            withdrawStatement.setDouble(1, 10.00);
            withdrawStatement.setString(2, "account123");
            PreparedStatement depositeStatement = con.prepareStatement(depositeQ);
            depositeStatement.setDouble(1, 10.00);
            depositeStatement.setString(2, "account234");
            int rowsAffected_withdraw= withdrawStatement.executeUpdate() ;
            int rowsAffected_deposite= depositeStatement.executeUpdate();
            if(rowsAffected_withdraw>0 && rowsAffected_deposite>0){
            con.commit();
            }else{con.rollback();
            }
            System.out.println("Transaction successful");
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }

    }
}
