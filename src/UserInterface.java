import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Adventure adventure;

    // Constructor to initialize UI with an instance of adventure
    public UserInterface(Adventure adventure) {
        this.adventure = adventure;
        scanner = new Scanner(System.in);
    }

    // Method to start UI and handle commands/get input
    public void start() {

        System.out.println("Welcome to Starship Quarantine");
        System.out.println("Type 'go north' to go north.");
        System.out.println("Type 'go south' to go south.");
        System.out.println("Type 'go west' to go west.");
        System.out.println("Type 'go east' to go east.");
        System.out.println("Type 'look' for getting a description of the current room.");
        System.out.println("Type 'health' to display your current health status.");
        System.out.println("Type 'inventory' to see current inventory of items.");
        System.out.println("Type 'eat' followed by item name to eat food.");
        System.out.println("Type 'equip' followed by the name of a weapon in your inventory to equip it.");
        System.out.println("Type 'attack' to attack with your equipped weapon.");
        System.out.println("Type 'help' to display this help menu.");
        System.out.println("Type 'exit' to exit the game.");

        boolean running = true;
        while (running) {

            String valg = scanner.nextLine();

            // Handle the different user commands --
            if (valg.startsWith("take ")) {
                String itemName = valg.substring(5).trim();
                System.out.println(adventure.take(itemName));
            } else if (valg.startsWith("drop ")) {
                String dropItemName = valg.substring(5).trim();
                System.out.println(adventure.drop(dropItemName));
            } else if (valg.startsWith("eat ")) {
                String itemName = valg.substring(4).trim();
                System.out.println(adventure.eat(itemName));
            } else if (valg.startsWith("equip ")) {
                String itemName = valg.substring(6).trim();
                System.out.println(adventure.equip(itemName));
            } else if (valg.equals("attack")) {
                String enemyName = valg.length() > 6 ? valg.substring(7).trim() : null;
                System.out.println(adventure.attack(enemyName));
            } else if (valg.equals("health")) {
                System.out.println(adventure.showHealth());
            } else if (valg.equals("go north")) {
                System.out.println(adventure.move("go north"));
            } else if (valg.equals("go south")) {
                System.out.println(adventure.move("go south"));
            } else if (valg.equals("go west")) {
                System.out.println(adventure.move("go west"));
            } else if (valg.equals("go east")) {
                System.out.println(adventure.move("go east"));
            } else if (valg.equals("look")) {
                System.out.println(adventure.look());
            } else if (valg.equals("inventory")) {
                System.out.println(adventure.showItems());
            } else if (valg.equals("help")) {
                displayHelp();
            } else if (valg.equals("exit")) {
                running = false;
                System.out.println("Exiting the game");
            } else {
                System.out.println("Not allowed. Type a new command.");
            }

        }
    }
    // Method to display help menu

    private void displayHelp() {
        System.out.println("Help Menu:");
        System.out.println("Type 'go north' to go north.");
        System.out.println("Type 'go south' to go south.");
        System.out.println("Type 'go west' to go west.");
        System.out.println("Type 'go east' to go east.");
        System.out.println("Type 'look' to get a description of the current room.");
        System.out.println("Type 'take' + item to pick up item.");
        System.out.println("Type 'drop' + item to drop item.");
        System.out.println("Type 'eat' + food item to eat food.");
        System.out.println("Type 'inventory' to see current inventory of items.");
        System.out.println("Type 'attack' to attack the nearest enemy.");
        System.out.println("Type 'attack' followed by enemy name to attack a specific enemy.");
        System.out.println("Type 'health' to display your current health status.");
        System.out.println("Type 'help' to display this help menu.");
        System.out.println("Type 'exit' to exit the game.");
    }
}
