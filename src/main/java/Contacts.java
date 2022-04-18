public class Contacts {private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String  phoneNumber;
    private int pinCode;
    private String email;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setPhoneNumber(String number) {
        this.phoneNumber = number;
    }
    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getAddress() {
        return this.address;
    }
    public String getCity() {
        return this.city;
    }
    public String getState() {
        return this.state;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public int getPinCode() {
        return this.pinCode;
    }
    public String getEmail() {
        return this.email;
    }

    public boolean equals(Object object) {
        if(object == this)  return true;
        if(!(object instanceof Contacts)) return false;
        Contacts contacts = (Contacts) object;
        return (this.firstName.equals(contacts.firstName)  && this.lastName.equals(contacts.lastName) && this.address.equals(contacts.address) && this.city.equals(contacts.city)
                && this.state.equals(contacts.state) && this.phoneNumber.equals(contacts.phoneNumber) && this.pinCode == contacts.pinCode && this.email.equals(contacts.email));
    }
}

