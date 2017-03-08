import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {

    private final StringProperty firstName = new SimpleStringProperty(this,"firstName");
    private final StringProperty lastName = new SimpleStringProperty(this,"lastName");
    private final StringProperty email = new SimpleStringProperty(this,"email");
    private final LongProperty phone = new SimpleLongProperty(this,"phone");
    private final StringProperty address = new SimpleStringProperty(this,"address");
    private static int id=0;


    public Customer(String firstName,String lastName,String email,long phone,String address){
        this(firstName,lastName,email,phone,address,id++);
    }

    public Customer(String firstName,String lastName,String email,long phone,String address,int id){
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhone(phone);
        setAddress(address);
        setId(id);
    }


    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public long getPhone() {
        return phone.get();
    }

    public LongProperty phoneProperty() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone.set(phone);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Customer.id = id;
    }
}
