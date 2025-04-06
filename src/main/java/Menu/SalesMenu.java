package Menu;

import Service.SaleTransactionService;
import Util.Helper;

public class SalesMenu {
    private static final SaleTransactionService saleService = new SaleTransactionService();

    public static void menu() {
        int choice;
        do {
            System.out.println("\nSales Menu");
            System.out.println("1- Sell Part");
            System.out.println("2- View Sales");
            System.out.println("0 - Exit");
            choice = Helper.getIntFromUser();
            handleSelection(choice);
        } while (choice != 0);
    }

    public static void handleSelection(int choice) {
        switch (choice) {
            case 1 -> saleService.sellPart();
            case 2 -> saleService.viewSales();
            case 0 -> System.out.println("Exiting Sales Menu");
            default -> System.out.println("Invalid selection");
        }
    }
}
