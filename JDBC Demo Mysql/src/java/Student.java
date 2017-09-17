
import java.util.Date;

/**
 *
 * @author tha
 */
public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private String major;
    private Date bday;
    private int classId;

    public Student(String firstname, String lastname, String major, Date bday, int classId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.major = major;
        this.bday = bday;
        this.classId = classId;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMajor() {
        return major;
    }

    public Date getBday() {
        return bday;
    }
    public int getClassId() {
        return classId;
    }
    
}
