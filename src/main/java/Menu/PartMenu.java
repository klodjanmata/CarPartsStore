package Menu;

public class PartMenu {
    public static void menu(){
        System.out.println("\nPart Management Menu");
        System.out.println("1- Add Part");
        System.out.println("2- Delete Part");
        System.out.println("3- Edit Part");
        System.out.println("4- View Parts");
        System.out.println("0 - Exit");
    }

    public static void handleSelection(int choice){
        switch (choice) {
            case 1:
                //PartService.addPart();
                System.out.println("Adding Part");
                break;
            case 2:
                    System.out.println("Deleting Part");
                    break;
            case 3:
                System.out.println("Editing Part");
                break;
            case 4:
                System.out.println("Viewing Part");
                break;
            case 0:
                System.out.println("Exit");
                break;
        }
    }
}
