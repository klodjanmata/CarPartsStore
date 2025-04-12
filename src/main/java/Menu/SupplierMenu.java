package Menu;

import Service.SupplierService;
import Util.Helper;

public class
SupplierMenu {
    private static final SupplierService supplierService = new SupplierService();

    public static void menu() {
        int choice;
        do {
            System.out.println("\nSupplier Menu");
            System.out.println("1 - Add Supplier");
            System.out.println("2 - Delete Supplier");
            System.out.println("3 - Edit Supplier");
            System.out.println("4 - View Supplier");
            System.out.println("0 - Exit");
            choice = Helper.getIntFromUser();
            handleSelection(choice);
        } while (choice != 0);
    }

    public static void handleSelection(int choice) {
        switch (choice) {
            case 1 -> supplierService.addSupplier();
            case 2 -> supplierService.deleteSupplier();
            case 3 -> supplierService.editSupplier();
            case 4 -> supplierService.printAllSuppliers();
            case 0 -> System.out.println("Exiting Supplier Menu");
            default -> System.out.println("Invalid selection");
        }
    }
}

