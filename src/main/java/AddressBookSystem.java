import java.util.Scanner;

public class AddressBookSystem {
    public static void main(String[] args) {
        AddressBookMain addressBookMain = new AddressBookMain();
        AddressBook addressBook = new AddressBook();
        int numOfBooks =0;

        System.out.println(" Welcome to address book program ");
        Scanner sc = new Scanner(System.in);

        AddressBook currentBook;
        boolean exit1 = true;
        while(exit1) {
            System.out.println("Select option 1:Add address Book 2:open Address Book 3:search by city or state 4:exit");
            switch (sc.nextInt()) {
                case 1 -> {
                    System.out.println("Enter the address book name");
                    String name = sc.next();
                    currentBook = new AddressBook();
                    AddressBookMain.addressBooks.add(currentBook);
                    AddressBookMain.addressBookName[numOfBooks] = name;
                    numOfBooks++;
                }
                case 2 -> {
                    System.out.println("The Address books available :");
                    for (int i = 0; i < numOfBooks; i++) {
                        System.out.println(AddressBookMain.addressBookName[i]);
                    }
                    System.out.println("Enter the name");
                    String book = sc.next();
                    int i = 0;
                    for (i = 0; i < numOfBooks; i++) {
                        if (AddressBookMain.addressBookName[i].equals(book)) break;
                    }
                    if (i == numOfBooks) {
                        System.out.println("name Not Found");
                        break;
                    }
                    currentBook = AddressBookMain.addressBooks.get(i);
                    AddressBookMain.addressMenu(currentBook);
                }
                case 3 -> {
                    System.out.println("Select 1:search by city 2: search by state");
                    int option = sc.nextInt();
                    if (option == 1) {
                        System.out.println("enter city");
                        String city = sc.next();
                        System.out.println("enter firstName");
                        String firstName = sc.next();
                        addressBook.searchByCity(city, firstName);
                    } else {
                        System.out.println("enter state");
                        String state = sc.next();
                        System.out.println("enter firstName");
                        String firstName = sc.next();
                        addressBook.searchByState(state, firstName);
                    }
                }
                default -> exit1 = false;
            }
        }
        sc.close();
    }
}


