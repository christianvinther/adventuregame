public class Map {
    private Room currentRoom;

    // Constructor to initialize map + call method to create rooms
    public Map() {
        createRooms();
    }

    // Method to create rooms + their connections
    public void createRooms() {
        // Creating individual room instances with their names and descriptions
        Room room1 = new Room("Room 1", "Control room: Blinking consoles and a large viewscreen.");
        Room room2 = new Room("Room 2", "Storage area: Stacked crates and dim lighting.");
        Room room3 = new Room("Room 3", "Greenhouse: Rows of plants under artificial lights.");
        Room room4 = new Room("Room 4", "Sleeping quarters: Bunk beds and personal lockers.");
        Room room5 = new Room("Room 5", "Engine room: Humming machinery and pipes.");
        Room room6 = new Room("Room 6", "Observation deck: Large windows with a space view.");
        Room room7 = new Room("Room 7", "Medical bay: Clean surfaces and medical equipment.");
        Room room8 = new Room("Room 8", "Rec room: Gaming tables and comfortable seating.");
        Room room9 = new Room("Room 9", "Airlock: Protective suits and safety warnings.");

        // Creating items
        Item flashlight = new Item("flashlight", "A bright LED flashlight");
        Item keycard = new Item("keycard", "Access card for secure areas");
        Item wrench = new Item("wrench", "Adjustable wrench for repairs");
        Item radio = new Item("radio", "Short-range communication device");
        Item gloves = new Item("gloves", "Protective work gloves");
        Item tablet = new Item("tablet", "Portable computer tablet");
        Item rope = new Item("rope", "Strong synthetic rope");

        // create Food items
        Food rations = new Food("rations", "Vacuum-sealed meal pack", 15);
        Food water = new Food("water", "Bottle of purified water", 10);
        Food energybar = new Food("energybar", "High-calorie snack bar", 12);
        Food fruit = new Food("fruit", "Assorted dried fruit", 8);
        Food nuts = new Food("nuts", "Mixed nuts in a sealed pack", 7);
        Food soup = new Food("soup", "Self-heating soup can", 14);
        Food candy = new Food("candy", "Pack of hard candies", 5);
        Food vegetablemix = new Food("veggiemix", "Dehydrated vegetable mix", 9);
        Food proteinshake = new Food("proteinshake", "Ready-to-drink protein shake", 11);
        Food vitaminpill = new Food("vitaminpill", "Daily multivitamin supplement", 3);

        // create Weapons
        Weapon stunbaton = new MeleeWeapon("stunbaton", "Non-lethal electric baton", 3);
        Weapon laser = new RangedWeapon("laser", "Standard-issue laser pistol", 5, 4);
        Weapon taser = new RangedWeapon("taser", "Short-range electroshock weapon", 3, 5);
        Weapon net = new RangedWeapon("net", "Restraining net launcher", 2, 3);
        Weapon knife = new MeleeWeapon("knife", "Tactical combat knife", 2);
        Weapon crossbow = new RangedWeapon("crossbow", "Silent bolt-firing weapon", 4, 6);
        Weapon club = new MeleeWeapon("club", "Heavy-duty security club", 3);
        Weapon slingshot = new RangedWeapon("slingshot", "Wrist-mounted projectile launcher", 2, 4);
        Weapon staff = new MeleeWeapon("staff", "Collapsible fighting staff", 3);
        Weapon grenades = new RangedWeapon("grenades", "Set of stun grenades", 1, 8);

        // create Enemies
        Enemy securityBot = new Enemy("Security Bot", "Automated security robot", 20,
                new RangedWeapon("taser", "Built-in taser", 2, 5));
        Enemy mutantRat = new Enemy("Mutant Rat", "Oversized aggressive rodent", 15,
                new MeleeWeapon("teeth", "Sharp teeth", 3));
        Enemy malfunctioningDroid = new Enemy("Malfunctioning Droid", "Erratically behaving service droid", 18,
                new MeleeWeapon("arm", "Flailing mechanical arm", 4));
        Enemy escapedPrisoner = new Enemy("Escaped Prisoner", "Dangerous fugitive", 25,
                new MeleeWeapon("shiv", "Makeshift knife", 5));
        Enemy toxicSpore = new Enemy("Toxic Spore", "Mobile fungal growth", 10,
                new RangedWeapon("spores", "Poisonous spore release", 1, 7));
        Enemy rogueAI = new Enemy("Rogue AI", "Holographic projection of corrupted AI", 30,
                new RangedWeapon("energy pulse", "Damaging energy discharge", 3, 6));
        Enemy parasiteHost = new Enemy("Parasite Host", "Crew member infected by alien parasite", 22,
                new MeleeWeapon("tentacle", "Mutated tentacle attack", 4));
        Enemy securityGuard = new Enemy("Corrupted Guard", "Mind-controlled security personnel", 28,
                new RangedWeapon("pistol", "Standard issue sidearm", 4, 5));
        Enemy malfunctioningTurret = new Enemy("Malfunctioning Turret", "Automated defense gun", 35,
                new RangedWeapon("bullets", "Rapid-fire ammunition", 2, 8));
        Enemy alienPet = new Enemy("Alien Pet", "Escaped exotic creature", 17,
                new MeleeWeapon("claws", "Sharp claws", 4));


        // Adding enemies to rooms
        room1.addEnemy(rogueAI);
        room2.addEnemy(securityBot);
        room3.addEnemy(toxicSpore);
        room4.addEnemy(parasiteHost);
        room5.addEnemy(escapedPrisoner);
        room6.addEnemy(alienPet);
        room7.addEnemy(malfunctioningDroid);
        room8.addEnemy(mutantRat);
        room9.addEnemy(securityGuard);

        // Adding a bit of weapons to rooms :)
        room1.addItem(laser);
        room1.addItem(grenades);
        room2.addItem(stunbaton);
        room3.addItem(crossbow);
        room5.addItem(club);
        room6.addItem(slingshot);
        room7.addItem(taser);
        room7.addItem(net);
        room8.addItem(knife);
        room9.addItem(staff);

        // Adding foodie foodie to rooms
        room1.addItem(rations);
        room2.addItem(water);
        room2.addItem(soup);
        room3.addItem(vitaminpill);
        room4.addItem(energybar);
        room4.addItem(fruit);
        room5.addItem(nuts);
        room5.addItem(candy);
        room6.addItem(vegetablemix);
        room7.addItem(proteinshake);
        room8.addItem(water);

        // Adding other items to rooms
        room1.addItem(keycard);
        room3.addItem(gloves);
        room4.addItem(flashlight);
        room5.addItem(wrench);
        room6.addItem(tablet);
        room8.addItem(radio);
        room9.addItem(rope);

// Setting up rooms
        room1.setEast(room2);
        room1.setSouth(room4);


        room2.setWest(room1);
        room2.setEast(room3);

        room3.setSouth(room6);
        room3.setWest(room2);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);

        room9.setNorth(room6);
        room9.setWest(room8);


        // Set initial current rooom
        currentRoom = room1;

    }

    // GETTER to get the current room you are in
    public Room getCurrentRoom() {
        return currentRoom;
    }
}