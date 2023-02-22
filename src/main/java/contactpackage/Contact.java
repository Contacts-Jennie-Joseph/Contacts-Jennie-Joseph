package contactpackage;

public class Contact {
    private String name;
    private String phoneNumber;

//    constructor
    public Contact(String name) {
        this.name = name;
        phoneNumber = phoneNumber;
    }
//    constructor
    public Contact(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public String toFileString() {
        return String.format("%s,%s", name, phoneNumber);
    }

    public static Contact fromFileString(String fileString){
        String [] pieces = fileString.split(",");
        Contact contact = new Contact(pieces[0]);
        contact.setPhoneNumber(pieces[1]);
        return contact;
    }

    @Override
    public String toString() {
        return "contact{" +
                "name = '" + name + '\'' +
                ", phoneNumber = " + phoneNumber +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
