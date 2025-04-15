import java.util.Scanner;
import java.util.ArrayList;

public class Store {
    
    
    
    
    
    
    static ArrayList<String> Menu = new ArrayList<>();
    static ArrayList<String> Beverages = new ArrayList<>();
    static ArrayList<String> Cart = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    static int option;
    static String itemChosen;









    // Function to check the option
    static void optionChecker(int option) {
        if (option == 1) {
            System.out.println("-------------------------Menu------------------------\n");
            for (int i = 0; i < Menu.size(); i++) {
                System.out.println(Menu.get(i));
            }
            System.out.println("\n\n\n ---------------------Beverages------------------\n\n\n");
            for (int i = 0; i < Beverages.size(); i++) {
                System.out.println(Beverages.get(i));
            }
            System.out.println("\nChoose an item to add to your cart, or type 'back' to return to the home page:");
            in.nextLine(); // Clear the buffer (since we used nextInt() earlier)
            itemChosen = in.nextLine().trim(); // Trim to remove extra spaces

            // Check if the item is in Menu or Beverages (case-insensitive)
            boolean itemFound = false;
            for (String item : Menu) {
                if (item.equalsIgnoreCase(itemChosen)) {
                    Cart.add(item); // Add the correctly formatted item (e.g., "Burrito" instead of "burrito")
                    System.out.println(item + " added to cart!");
                    itemFound = true;
                    break;
                }
            }
            if (!itemFound) {
                for (String item : Beverages) {
                    if (item.equalsIgnoreCase(itemChosen)) {
                        Cart.add(item);
                        System.out.println(item + " added to cart!");
                        itemFound = true;
                        break;
                    }
                }
            }

            if (itemChosen.equalsIgnoreCase("back")) {
                // Return to home (you can add logic here)
                System.out.println("Returning to home...");
            } else if (!itemFound) {
                System.out.println("Error: Item not found!");
            }
        }
        
        //if option 1 statement ends here
        
        
    }










    // Function to initialize the menu and add dishes
    static void initializeMenu() {
        Menu.add("Burrito");
        Menu.add("Bruschetta");
        Menu.add("Edamame");
        Menu.add("Pork Gyoza");
        Menu.add("Kimchi Pancake");
        Menu.add("Ramen Tonkotsu");
        Menu.add("Beef Bulgogi");
        Menu.add("Kung Pao Chicken");
        Menu.add("Sushi Platter");
        Menu.add("Jajangmyeon");
        Menu.add("Chiles Rellenos");
        Menu.add("Vegetable Tempura");
        Menu.add("Mapo Tofu");
        Menu.add("Bibimbap");
        Menu.add("Pad Thai");
        Menu.add("Yangzhou Fried Rice");
        Menu.add("Tteokbokki");
        Menu.add("Mochi Ice Cream");
        Menu.add("Churros");
        Menu.add("Bruschetta");
        Menu.add("Spinach & Artichoke Dip");
        Menu.add("Crispy Calamari");
        Menu.add("Stuffed Mushrooms");
        Menu.add("Lasagna");
        Menu.add("Grilled Salmon");
        Menu.add("Beef Tenderloin");
        Menu.add("Shrimp Scampi Linguine");
        Menu.add("Truffle Mac & Cheese");
        Menu.add("California Roll Sushi");
        Menu.add("Tacos al pastor");
        Menu.add("Cheese Burger");
        Menu.add("Hot Dog");
        Menu.add("Hawaiian Pizza");
        Menu.add("Peperonni Pizza");
        Menu.add("Vegan Pizza");
    }







    // Function to initialize beverages
    static void initializeBeverages() {
        Beverages.add("MTN Dew");
        Beverages.add("Pepsi");
        Beverages.add("Coke");
        Beverages.add("Fanta");
        Beverages.add("Sprite");
    }






//Main method




    public static void main(String args[]) {
        initializeMenu();
        initializeBeverages();
        System.out.println("------------------Welcome to Mat's epic restaurant----------------");
        System.out.println("\n\n\n");
        System.out.println("Choose an option below:");
        System.out.println("1. Menu\n2. Shopping Cart\n3. Check out");

        option = in.nextInt();
        optionChecker(option);
    }
}


