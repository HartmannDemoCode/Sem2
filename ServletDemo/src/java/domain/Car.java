package domain;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Sep 17, 2017 
 */
public class Car {
    private String make;
    private String model;
    private String year;

    public Car(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
}
