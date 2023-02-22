public class Contact {
    private String name;
    private int phoneNumber;

//    constructor
    public Contact(String name) {
        this.name = name;
        phoneNumber = phoneNumber;
    }
//    constructor
    public Contact(String name, int phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public String toFileString() {
        return String.format("%s,%d", name, phoneNumber);
    }

    public static Contact fromFileStirng(String fileString){
        String [] pieces = fileString.split(",");
        Contact contact = new Contact(pieces[0]);
        contact.setPhoneNumber(Integer.parseInt(pieces[1]));
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
