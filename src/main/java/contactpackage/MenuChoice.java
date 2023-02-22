package contactpackage;

public enum MenuChoice {
    Exit, SearchContacts, ViewContacts, CreateContact, DeleteContact;

    public static MenuChoice fromInt(int choice) {
        return MenuChoice.values()[choice];
    }

}