import java.util.ArrayList;
import java.util.Scanner;

class PhoneBook {

    private String name;
    private String phone;
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}

public class MyClass {

    private static ArrayList<PhoneBook> friendList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("__________________________");
            System.out.println("|                        |");
            System.out.println("| 1. Add Friend          |");
            System.out.println("| 2. Display All Friends |");
            System.out.println("| 3. Search Friend       |");
            System.out.println("| 4. Edit Friend         |");
            System.out.println("| 5. Delete Friend       |");
            System.out.println("| 0. Exit                |");
            System.out.println("|________________________|");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    addFriend();
                    break;
                case 2:
                    displayAllFriends();
                    break;
                case 3:
                    searchFriend();
                    break;
                case 4:
                    editFriend();
                    break;
                case 5:
                    deleteFriend();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
                    System.out.println();
            }
        }
    }

    private static void addFriend() {
        PhoneBook friend = new PhoneBook();
        System.out.print("Enter friend's name: ");
        friend.setName(scanner.nextLine());
        System.out.print("Enter friend's phone number: ");
        friend.setPhone(scanner.nextLine());
        System.out.print("Enter friend's email address: ");
        friend.setEmail(scanner.nextLine());

        friendList.add(friend);
        System.out.println("Friend added successfully!");
        System.out.println();
    }

    private static void displayAllFriends() {
        if (friendList.isEmpty()) {
            System.out.println("Friend list is empty.");
            System.out.println();
        } else {
            System.out.println("Friend List:");
            for (int i = 0; i < friendList.size(); i++) {
                PhoneBook friend = friendList.get(i);
                if(i >=0 && i < 9) System.out.print("0");
                System.out.print((i+1) + ".");
                System.out.println(" Name: " + friend.getName());
                System.out.println("    Phone: " + friend.getPhone());
                System.out.println("    Email: " + friend.getEmail());
                System.out.println();
            }
        }
    }

    private static void searchFriend() {
        System.out.print("Enter search term (Name/Phone/Email): ");
        String searchTerm = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < friendList.size(); i++) {
            PhoneBook friend = friendList.get(i);

            if (friend.getName().equalsIgnoreCase(searchTerm)
                    || friend.getPhone().equalsIgnoreCase(searchTerm)
                    || friend.getEmail().equalsIgnoreCase(searchTerm)) {
                System.out.println("Friend found:");
                System.out.println(" Name: " + friend.getName());
                System.out.println(" Phone: " + friend.getPhone());
                System.out.println(" Email: " + friend.getEmail());
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Friend not found! Please try again.");
            System.out.println();
        }
    }

    private static void editFriend() {
        System.out.print("Enter friend's name: ");
        String friendName = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < friendList.size(); i++) {
            PhoneBook friend = friendList.get(i);
            if (friend.getName().equalsIgnoreCase(friendName)) {
                System.out.println("Which information do you want to edit?");
                System.out.println("1. Name (Current name: "+friend.getName()+")");
                System.out.println("2. Phone (Current phone: "+friend.getPhone()+")");
                System.out.println("3. Email (Current email: "+friend.getEmail()+")");
                System.out.print("Select any one: ");
                
                int select = scanner.nextInt();
                scanner.nextLine();
                
                switch (select) {
                    case 1:
                        System.out.print("Enter new name: ");
                        friend.setName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.print("Enter new phone number: ");
                        friend.setPhone(scanner.nextLine());
                        break;
                    case 3:
                        System.out.print("Enter new email address: ");
                        friend.setEmail(scanner.nextLine());
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }

                if(select >= 1 && select <= 3)
                    System.out.println("Friend information updated successfully!");
                System.out.println();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Friend not found.");
            System.out.println();
        }
    }

    private static void deleteFriend() {
        System.out.print("Enter friend's name to delete: ");
        String friendName = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < friendList.size(); i++) {
            PhoneBook friend = friendList.get(i);
            if (friend.getName().equals(friendName)) {
                friendList.remove(i);
                System.out.println("Friend deleted successfully!");
                System.out.println();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Friend not found.");
            System.out.println();
        }
    }
}
