import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Connection con = Setup.Connect();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n========= JDBC Menu =========");
                System.out.println("1. Read Data");
                System.out.println("2. Insert Data");
                System.out.println("3. Update Data");
                System.out.println("4. Delete Data");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        Read.retrieve(con);
                        break;

                    case 2:
                        Insert.insert(con);
                        break;

                    case 3:
                        Update.update(con);
                        break;

                    case 4:
                        Delete.delete(con);
                        break;

                    case 5:
                        System.out.println("Exiting program...");
                        con.close();
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
