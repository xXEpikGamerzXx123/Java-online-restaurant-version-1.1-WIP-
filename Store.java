import java.util.*;
//starting the class
public class RestaurantSimulator {
    static class MenuItem {
        String name;
        double price;

        MenuItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return name + " - $" + price;
        }
    }

    static List<MenuItem> menu = new ArrayList<>();
    static List<MenuItem> cart = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        setupMenu();

        System.out.println(" Welcome to the Java Restaurant!");
        boolean ordering = true;

        while (ordering) {//this loop asks the user for input and will either show the menu or proceed to checkout
            showMenu();
            System.out.print("Enter the number of the item to add to cart (or 0 to checkout): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                ordering = false;
                continue;
            }

            if (choice >= 1 && choice <= menu.size()) {
                cart.add(menu.get(choice - 1));
                System.out.println(" Added to cart: " + menu.get(choice - 1).name);
            } else {
                System.out.println(" Invalid choice.");
            }
        }

        checkout(scanner);
        scanner.close();
    }

    static void setupMenu() {
        menu.add(new MenuItem("Burger", 5.99));
        menu.add(new MenuItem("Pizza", 7.49));
        menu.add(new MenuItem("Salad", 4.99));
        menu.add(new MenuItem("Soda", 1.99));
        menu.add(new MenuItem("Ice Cream", 2.99));
    }

    static void showMenu() {
        System.out.println("\n Menu:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }

    static void checkout(Scanner scanner) {//this is the function for checkout when paying for the items
        System.out.println("\n Your Cart:");
        double total = 0;
        for (MenuItem item : cart) {
            System.out.println("- " + item);
            total += item.price;
        }
        System.out.printf(" Total: $%.2f\n", total);

        System.out.print("Enter payment amount: $");
        double payment = scanner.nextDouble();

        if (payment >= total) {
            double change = payment - total;
            System.out.printf(" Payment accepted! Your change is $%.2f\n", change);
            System.out.println(" Thank you for dining with us!");
        } else {
            System.out.printf(" Not enough money. You need $%.2f more.\n", total - payment);
            System.out.println("Please try again next time.");
        }
    }
}
