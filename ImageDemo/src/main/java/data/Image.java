package data;

import java.io.InputStream;

/**
 *
 * @author tha
 */
public class Image {
    int id;
    InputStream image;
    String name;
    String contentType;

    public Image(int id, InputStream image, String name, String contentType) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.contentType = contentType;
        
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Image() {
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

}
