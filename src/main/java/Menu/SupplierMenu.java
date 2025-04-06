package Menu;

import javax.swing.text.View;
import java.sql.SQLOutput;

public class SupplierMenu {

    public static void menu(){
        System.out.println("\nSupplier Menu");
        System.out.println("1 - Add Supplier");
        System.out.println("2 - Delete Supplier");
        System.out.println("3 - Edit Supplier");
        System.out.println("4 - View Supplier");
        System.out.println("0 - Exit");
    }

    public static void handleSelection(int choice){
        switch (choice) {


            case 1:
                System.out.println("Adding Supplier");
                break;
            case 2:
                    System.out.println("Deleting Supplier");
                    break;
            case 3:
                System.out.println("Editing Supplier");
                break;
            case 4:
                System.out.println("Viewing Supplier");
                break;
            case 0:
                System.out.println("Exit");
                break;
        }
    }
}
