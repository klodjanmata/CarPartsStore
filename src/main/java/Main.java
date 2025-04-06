import Menu.MainMenu;
import Menu.PartMenu;
import Menu.SalesMenu;
import Menu.SupplierMenu;
import Util.Helper;

public class Main {
    public static void main(String[] args) {
        while (true) {
            MainMenu.printMainMenu();
            int choice = getChoice();
            if (choice == 0) {
                System.out.println("Exiting system. Goodbye!");
                break;
            }
            executeOperation(choice);
        }
    }

    public static void executeOperation(int choice) {
        switch (choice) {
            case 1 -> PartMenu.menu();
            case 2 -> SupplierMenu.menu();
            case 3 -> SalesMenu.menu();
            default -> System.out.println("Invalid option!");
        }
    }

    public static int getChoice() {
        int choice;
        try {
            choice = Helper.getIntFromUser();
        } catch (Exception e) {
            choice = -1;
        }
        return choice;
    }
}
