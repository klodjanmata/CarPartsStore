import Menu.PartMenu;
import Menu.SalesMenu;
import Menu.SupplierMenu;
import Util.Helper;

import Menu.MainMenu;

public class Main {
    public static void main(String[] args) {
        while(true) {
            MainMenu.printMainMenu();
            int choice = getChoice();
            if(choice == 0) {
                return;
            }
            executeOperation(choice);
        }

    }

    public static void executeOperation(int choice) {
        switch (choice) {
            case 1:
                PartMenu.menu();
                PartMenu.handleSelection(getChoice());
                break;

                case 2:
                    SupplierMenu.menu();
                    SupplierMenu.handleSelection(getChoice());
                    break;

            case 3:
                SalesMenu.menu();
                SalesMenu.handleSelection(getChoice());
                break;

        }
    }

    public static int getChoice(){
        int choice = -1;
        try{
            choice = Helper.getIntFromUser();
        }catch (Exception e){
            choice = -1;
        }
        return choice;
    }
}

