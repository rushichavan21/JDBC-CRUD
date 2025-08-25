import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Image_Handling {
    public static void insert() {
        Connection con =Setup.Connect();
        String query="INSERT INTO image_table(image_data) VALUES (?)";
        String image_path="data/sample.png";
        try {
        FileInputStream fis = new FileInputStream(image_path);
        byte [] imageData= new byte[fis.available()];
        fis.read(imageData);
            PreparedStatement ps=con.prepareStatement(query);
            ps.setBytes(1, imageData);
            int rowsAffected=ps.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Image has been added successfully");
            }else{
                System.out.println("Error adding image");
            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void download(){
        String folderPath="data";
        String query="Select image_data from image_table where image_id=(?);";
        try{
        Connection con=Setup.Connect();
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1,1);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            byte[] image_data=rs.getBytes("image_data");
            OutputStream os=new FileOutputStream(folderPath+"/"+"downloaded.png");
            os.write(image_data);
            System.out.println("Image has been downloaded successfully");
         }else{
            System.out.println("Image not found");
        }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
//        insert();
        download();

    }
}
