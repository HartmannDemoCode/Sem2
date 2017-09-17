package domain;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Sep 16, 2017 
 */
public class Phone {
    private String number;
    private String description;

    public Phone(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
