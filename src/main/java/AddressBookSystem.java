import java.util.Scanner;

public class AddressBookSystem {
    public static void main(String[] args) {
        AddressBookMain addressBookMain = new AddressBookMain();
        AddressBook addressBook = new AddressBook();
        int numOfBooks = 0;

        System.out.println(" Welcome to address book program ");
        Scanner sc = new Scanner(System.in);

        AddressBook currentBook;
        boolean exit1 = true;
        while (exit1) {
            System.out.println("Select option 1:Add address Book 2:open Address Book 3:search by city or state  4 : display users in city or state 5:exit");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Enter the address book name");
                    String name = sc.next();
                    currentBook = new AddressBook();
                    addressBookMain.addressBooks.add(currentBook);
                    addressBookMain.addressBookName[numOfBooks] = name;
                    numOfBooks++;
                    break;
                case 2:
                    System.out.println("The Address books available :");
                    for (int i = 0; i < numOfBooks; i++) {
                        System.out.println(addressBookMain.addressBookName[i]);
                    }
                    System.out.println("Enter the name");
                    String book = sc.next();
                    int i = 0;
                    for (i = 0; i < numOfBooks; i++) {
                        if (addressBookMain.addressBookName[i].equals(book)) break;
                    }
                    if (i == numOfBooks) {
                        System.out.println("name Not Found");
                        break;
                    }
                    currentBook = addressBookMain.addressBooks.get(i);
                    addressBookMain.addressMenu(currentBook);
                    break;
                case 3:
                    System.out.println("Select 1:search by city 2: search by state");
                    int option = sc.nextInt();
                    if (option == 1) {
                        System.out.println("enter city");
                        String city = sc.next();
                        System.out.println("enter firstName");
                        String firstName = sc.next();
                        addressBookMain.searchByCity(city, firstName);
                    } else {
                        System.out.println("enter state");
                        String state = sc.next();
                        System.out.println("enter firstName");
                        String firstName = sc.next();
                        addressBookMain.searchByState(state, firstName);
                    }
                    break;
                case 4:
                    System.out.println("Select 1: display persons in a city 2: display persons in a state");
                    if (sc.nextInt() == 1) {
                        System.out.println("Enter city name");
                        addressBookMain.personsInCity(sc.next());
                    } else {
                        System.out.println("Enter state name");
                        addressBookMain.personsInState(sc.next());
                    }
                    break;
                case 5:
                    System.out.println("Select 1: count by city    2: count by state");
                    if(sc.nextInt() == 1) {
                        System.out.println("Enter city name");
                        addressBookMain.countByCity(sc.next());
                    }
                    else {
                        System.out.println("Enter state name");
                        addressBookMain.countByState(sc.next());
                    }
                    break;
                default:
                    exit1 = false;

            }
        }
        sc.close();
    }
}
