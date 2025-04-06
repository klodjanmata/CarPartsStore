package Menu;

public class SalesMenu {
    public static void menu(){
        System.out.println("\nSales Menu");
        System.out.println("1- Sell");
        System.out.println("2- View todays sales");
        System.out.println("3- Export sales to CSV");
        System.out.println("0 - Exit");
    }
    public static void handleSelection (int choice){
        switch (choice) {
            case 1:
                System.out.println("Selling");
                break;
            case 2:
                System.out.println("Viewing todays sales");
                break;
            case 3:
                System.out.println("Exporting sales to CSV");
                break;
            case 4:
                System.out.println("Exiting");
                break;

        }
    }
}
