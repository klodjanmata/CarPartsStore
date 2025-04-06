import Util.Helper;

public class Main {
    public static void main(String[] args) {

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

