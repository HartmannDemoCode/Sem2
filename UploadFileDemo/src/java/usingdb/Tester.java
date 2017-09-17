package usingdb;

import java.io.InputStream;

/**
 *
 * @author tha
 */
public class Tester {

    private static ImageMapper im = new ImageMapper();
    public static void main(String[] args) {
        Tester t = new Tester();
        t.insertImgs();
        //byte[] bytes = t.getBytes(1);
        im.getImgAsStream(1);
        
    }
    public InputStream getImage(int imgno){
        InputStream is = im.getImgAsStream(imgno);
        return is;
    }
    public byte[] getBytes(int imgno){
        byte[] bytes = im.getImgAsBytes(imgno);
        return bytes;
    }
    
    public void insertImgs(){
        im.insertImg("C:/Uploads/evaluation.jpg", "evaluation", "jpg","This is a small picture of a stamp the prints: ");
        im.insertImg("C:/Uploads/delayed.jpg", "delayed", "jpg", "This is a stamp saying delayed");
        im.insertImg("C:/Uploads/sunpack.jpg", "sunpack", "jpg", "This picture shows how......");
    }
}
