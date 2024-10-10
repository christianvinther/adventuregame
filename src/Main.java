public class Main {
    public static void main(String[] args) {
        // Create Adventure object
        Adventure adventure = new Adventure();
        // Create UserInterface object. Pass in a instance of adventure
        UserInterface ui = new UserInterface(adventure);
        ui.start(); // Start tha game
    }
}
