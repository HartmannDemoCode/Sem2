package usingdb;

/**
 *
 * @author tha
 */
public class Image {
    int id;
    byte[] image;
    String name;
    String extention;
    String description;

    public Image(int id, byte[] image, String name, String extention, String desc) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.extention = extention;
        this.description = desc;
    }

    public Image() {
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
