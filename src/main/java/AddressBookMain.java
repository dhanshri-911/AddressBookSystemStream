import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {

    private static List<AddressBook> addressBooks = new LinkedList<AddressBook>();
    private static String[] addressBookName = new String[10];
    private static int numOfBooks = 0;

    private boolean checkName(String name) {
        for (int i = 0; i < addressBooks.size(); i++) {
            if (addressBookName[i].equals(name)) return true;
        }
        return false;
    }

    private static void addressMenu(AddressBook addressBook) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean exit = true;
        while (exit) {
            System.out.println("Select option 1: add user.  2: edit existing user.  3: display all users 4:Delete contact. 5:Switch Address Book");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    addressBook.addContact();
                    break;
                case 2:
                    System.out.println("Enter the user name to edit");
                    addressBook.editContact(sc.next());
                    break;
                case 3:
                    addressBook.display();
                    break;
                case 4:
                    System.out.println("Enter name");
                    addressBook.deleteContact(sc.next());
                    break;
                default:
                    exit = false;

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to address book program ");
        Scanner sc = new Scanner(System.in);

        AddressBook currentBook;
        boolean exit1 = true;
        while (exit1) {
            System.out.println("Select option 1:Add address Book 2:open Address Book 3:exit");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Enter the address book name");
                    String name = sc.next();
                    currentBook = new AddressBook();
                    addressBooks.add(currentBook);
                    addressBookName[numOfBooks] = name;
                    numOfBooks++;
                    break;
                case 2:
                    System.out.println("The Address books available :");
                    for (int i = 0; i < numOfBooks; i++) {
                        System.out.println(addressBookName[i]);
                    }
                    System.out.println("Enter the name");
                    String book = sc.next();
                    int i = 0;
                    for (i = 0; i < numOfBooks; i++) {
                        if (addressBookName[i].equals(book)) break;
                    }
                    if (i == numOfBooks) {
                        System.out.println("name Not Found");
                        break;
                    }
                    currentBook = addressBooks.get(i);
                    addressMenu(currentBook);
                    break;
                default:
                    exit1 = false;

            }
        }

        sc.close();
    }
}

