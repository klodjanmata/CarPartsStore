package Menu;

import Entity.Part;
import Service.PartService;
import Util.Helper;

import java.util.List;
import java.util.Scanner;

public class PartMenu {
    private static final PartService partService = new PartService();

    public static void menu() {
        int choice;
        do {
            System.out.println("\nPart Management Menu");
            System.out.println("1- Add Part");
            System.out.println("2- Delete Part");
            System.out.println("3- Edit Part");
            System.out.println("4- View Parts");
            System.out.println("5- Import Parts from CSV");
            System.out.println("6-Export  Part to CSV");
            System.out.println("0 - Exit");
            choice = Helper.getIntFromUser();
            handleSelection(choice);
        } while (choice != 0);
    }

    public static void handleSelection(int choice) {
        switch (choice) {
            case 1 -> partService.addPart();
            case 2 -> partService.deletePart();
            case 3 -> partService.editPart();
            case 4 -> partService.printAllParts();
            case 5 -> partService.importFromCSV();
            case 6->partService.exportPartToCSV(scanner);
            case 0 -> System.out.println("Exiting Part Menu");
            default -> System.out.println("Invalid selection");
        }
    }

}
}

