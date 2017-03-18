package balti.myaddressapp.MOdel;

/**
 * Created by BALTI on 3/10/2017.
 */

public class Contacts {

    int id;
    String Name;
    String PhoneNo;
    String Email;

    public void setType(String type) {
        Type = type;
    }

    public String getType() {

        return Type;
    }

    String Type;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public String getEmail() {
        return Email;
    }
}
