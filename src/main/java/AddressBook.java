import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    List<Contacts> referenceBook = new LinkedList<Contacts>();
    private int numOfContacts = 0;

    public void addContact() {
        System.out.println("Enter Person details:");

        Contacts contacts = intake();
        boolean isDuplicate = referenceBook.stream().anyMatch(contact -> contacts.equals(contact));
        if(isDuplicate) {
            System.out.println("Duplicate data entry. discarded");
        }
        else{
            referenceBook.add(contacts);
        }
    }

    public void editContact(String name) {
        int i=0;
        for(i=0;i<referenceBook.size();i++) {
            if(name.equals(referenceBook.get(i).getFirstName())) break;
        }
        if(i == referenceBook.size()) {
            System.out.println("name not found");
            return;
        }
        System.out.println("Changing details, Enter new details  of "+name);
        referenceBook.add(intake());
    }

    public void display() {
        Scanner sc = new Scanner(System.in);
        Contacts contacts = null;
        System.out.println("Persons present in the address book:");
        for(int i=0; i<referenceBook.size();i++) {
            System.out.print(referenceBook.get(i).getFirstName()+"  ");
        }
        System.out.println();
        System.out.println("Enter name to see details");
        String name = sc.next();

        for(int i = 0;i<referenceBook.size();i++) {
            if(referenceBook.get(i).getFirstName().equals(name)) {
                contacts = referenceBook.get(i);
                break;
            }
        }
        if(contacts == null) {
            System.out.println("name not found!");
            return;
        }
        output(contacts);
    }

    public void deleteContact(String name) {
        int i=0;
        for(i=0;i<referenceBook.size();i++) {
            if(referenceBook.get(i).getFirstName().equals(name)) {
                break;
            }
        }
        if(i==numOfContacts) {
            System.out.println("Name not found");
            return;
        }
        referenceBook.remove(i);
        System.out.println("Deleted details of : "+ name);
    }

    public static Contacts intake() {
        Scanner sc = new Scanner(System.in);
        Contacts contacts1 = new Contacts();

        System.out.println("Enter firstName:");
        contacts1.setFirstName(sc.next());
        System.out.println("Enter SecondName:");
        contacts1.setLastName(sc.next());
        System.out.println("Enter Address:");
        contacts1.setAddress(sc.next());
        System.out.println("Enter City:");
        contacts1.setCity(sc.next());
        System.out.println("Enter State:");
        contacts1.setState(sc.next());
        System.out.println("Enter Pin code:");
        contacts1.setPinCode(sc.nextInt());
        System.out.println("Enter Phone nmber:");
        contacts1.setPhoneNumber(sc.next());
        System.out.println("Enter email:");
        contacts1.setEmail(sc.next());
        return contacts1;
    }

    public static void output(Contacts contacts) {
        System.out.println("Enter firstName : " + contacts.getFirstName());
        System.out.println("Enter SecondName : " + contacts.getLastName());
        System.out.println("Enter Address : " + contacts.getAddress());
        System.out.println("Enter City : " + contacts.getCity());
        System.out.println("Enter State : " + contacts.getState());
        System.out.println("Enter Pin code : " + contacts.getPinCode());
        System.out.println("Enter Phone nmber : " + contacts.getPhoneNumber());
        System.out.println("Enter email : " + contacts.getEmail());
    }
}
