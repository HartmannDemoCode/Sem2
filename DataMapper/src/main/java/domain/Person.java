package domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Sep 16, 2017 
 */
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private List<Phone> phones = new ArrayList();

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void addPhone(Phone phone) {
        this.phones.add(phone);
    }

    @Override
    public String toString() {
        String numbers = "";
        for (Phone phone : phones) {
            numbers += phone.getDescription()+": "+phone.getNumber();
        }
        return "id: " + id + " firstName: " + firstName + " lastName: " + lastName + " phones: " + numbers;
    }
    
}
