package usingdb;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class ImageMapper {

    private Connection conn = DB.getConnection();
    private List<Image> images = new ArrayList();
    
    public List<Image> loadImages() throws SQLException{
        String sql = "SELECT id, image, name, extension, description FROM image";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            images = new ArrayList(); //empty the list.
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int id = rs.getInt(1);
                Blob blob = rs.getBlob(2);
                byte[] image = blob.getBytes(1, (int)blob.length());
                String name = rs.getString(3);
                String extension = rs.getString(4);
                String desc = rs.getString(5);
                images.add(new Image(id, image, name, extension, desc));
            }
            return images;
    }

    public void insertImg(String path, String name, String extension, String desc) {

        ResultSet rs = null;
        PreparedStatement psmnt = null;
        FileInputStream fis;
        try {
            File image = new File(path);

            psmnt = conn.prepareStatement("insert into image(image, name, extension, description) " + "values(?,?,?,?)");
            psmnt.setString(2, name);
            fis = new FileInputStream(image);
            psmnt.setBinaryStream(1, (InputStream) fis, (int)(image.length()));
            psmnt.setString(3, extension);
            psmnt.setString(4, desc);
            int s = psmnt.executeUpdate();
            
            if (s > 0) {
                System.out.println("image uploaded successfully !");
            } else {
                System.out.println("error in upload image.");
            }
        } 
        catch (Exception ex) {
            System.out.println("Found some error : ");
            ex.printStackTrace();
        } finally {
            DB.close(psmnt, null, null);
        }
    }
    public List<Image> getAll(){
        List<Image> images = new ArrayList();
        try {
            String sql = "SELECT id, image, name, extension FROM image";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int id = rs.getInt(1);
                Blob blob = rs.getBlob(2);
                byte[] bytes = blob.getBytes(1, (int)blob.length());
                String name = rs.getString(3);
                String extension = rs.getString(4);
                images.add(new Image(id, bytes, name, extension, extension));
            }
            return images;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return images;
    }
    public File getImgAsFile(int imgno){
        File file = new File("test.jpg");
        BufferedOutputStream bout = null;
        try {
            OutputStream out = new FileOutputStream(file);
            bout = new BufferedOutputStream(out);
            bout.write(getImgAsBytes(imgno));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        finally{
            if(bout != null) try {
                bout.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return file;
    }
    
    public InputStream getImgAsStream(int imgno) {
        Blob image = null;
        int size;
        InputStream in = null;
        byte[] imgData = null;
        
        try {
            String sql = "SELECT image FROM image WHERE id = ?";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            pstmt.setInt(1, imgno);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                image = rs.getBlob(1);
                size = (int)image.length(); // number of bytes
                System.out.println("image size: "+size);
                in = image.getBinaryStream(); //inputstream
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return in;
    }
    public byte[] getImgAsBytes(int imgno) {
        Blob image = null;
        int size;
        InputStream in = null;
        byte[] imgData = null;
        
        try {
            String sql = "SELECT image FROM image WHERE id = ?";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            pstmt.setInt(1, imgno);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                image = rs.getBlob(1);
                size = (int)image.length(); // number of bytes
                in = image.getBinaryStream(); //inputstream
                imgData = image.getBytes(1,size);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return imgData;
    }
}
