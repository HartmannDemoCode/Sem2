package data;

import java.io.InputStream;
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
    

    public boolean insertImg(String name, String contenttype, InputStream image) {

        ResultSet rs = null;
        PreparedStatement psmnt = null;
        boolean result = false;
        try {
            
            psmnt = conn.prepareStatement("insert into image(image, name, contenttype) " + "values(?,?,?)");
            psmnt.setString(2, name);
            
            psmnt.setBinaryStream(1, image);
            psmnt.setString(2, name);
            psmnt.setString(3, contenttype);
            
            
            if (psmnt.executeUpdate()>0) {
                result = true;
            } else {
                result = false;
            }
        } 
        catch (Exception ex) {
            System.out.println("Found some error : ");
            ex.printStackTrace();
        } finally {
            DB.close(psmnt, null, null);
        }
        return result;
    }
    
    public List<Image> getAllImages(){
        List<Image> images = new ArrayList();
        try {
            String sql = "SELECT id, image, name, contenttype FROM image";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int id = rs.getInt(1);
                Blob blob = rs.getBlob(2);
                InputStream image = blob.getBinaryStream();
                String name = rs.getString(3);
                String contentType = rs.getString(4);
                images.add(new Image(id, image, name, contentType));
            }
            return images;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return images;
    }
    public int[] getAllImageIds(){
        List<Image> images = getAllImages();
        int[] result = new int[images.size()];
        for (int i = 0; i < images.size(); i++) {
            result[i] = images.get(i).getId();
        }
        return result;
    }
    
    public Image getImg(int imgno) {
      Image img = null;
        try {
            String sql = "SELECT id, image, name, contenttype FROM image WHERE id = ?";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            pstmt.setInt(1, imgno);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                Blob blob = rs.getBlob("image");
                InputStream image = blob.getBinaryStream();
                String name = rs.getString("name");
                String contentType = rs.getString("contenttype");
                img = new Image(id, image, name, contentType);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return img;
    }
    public boolean deleteImage(int id){
        try {
            String sql = "DELETE FROM image WHERE id = ?";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
