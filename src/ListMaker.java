import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    private static Scanner in = new Scanner(System.in);

    private static ArrayList<String> lines = new ArrayList<>();

    private static String line = "";

    private static boolean confirmQuit = false;

    public static void main(String[] args) {

        String menuPrompt = "A - Add  D - Delete  P - Print  Q - Quit";
        String cmd = ""; //A, I, D, V, or Q
        boolean done = false;

        do {

            //Display Current List
            displayList();

            //Display command menu in the input prompt and get user cmd input
            cmd = SafeInput.getRegExString(in, menuPrompt, "[AaDdPpQq]");

            cmd = cmd.toUpperCase();

            //execute
            switch (cmd) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    displayList();
                    break;
                case "Q":
                    quitList();
                    break;
            }

        }while(!done);
    }

    private static void quitList() {
        confirmQuit = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
        if(confirmQuit)
            System.exit(0);
    }

    private static void addItem() {
        line = SafeInput.getNonZeroLenString(in, "Enter the new item to add to the list");
        lines.add(line);
    }

    private static void deleteItem() {
        //get an item number for the item to delete from the user
        int itemToDelete = 0;
        int indexToDelete = 0;

        itemToDelete = SafeInput.getRangedInt(in, "Enter the number of the item you want to delete: ", 1, lines.size());
        //convert the item to an index
        itemToDelete = itemToDelete - 1;
        lines.remove(itemToDelete);
    }

    private static void displayList() {
        System.out.println("==========================================");
        if(lines.size() > 0) {
            int itemNum = 1;
            for(String l:lines) {
                System.out.println(itemNum + ". " + l);
                itemNum++;
            }
        } else {
            System.out.println("The list is currently empty!");
        }
        System.out.println("==========================================");
    }

}
