import java.util.*;

public class Game {

	public static Scanner scan = new Scanner(System.in);
	public static Player player;
	public static boolean isRunning;

	//Reads user input
	public static String readString(String prompt, ArrayList<String> userChoices) {

		String input;
		int wrongInputCounter = 0; //Counts how many wrong inputs user entered

		do {
			System.out.println(prompt);
			input = scan.nextLine();
			input = input.toLowerCase();
			wrongInputCounter += 1;
			if(!userChoices.contains(input) && wrongInputCounter > 0) {
				System.out.println("Action not available! Please enter something else...");
			}
		} while(!userChoices.contains(input));

		return input;
	}

	//Simulates clearing the console
	public static void clearConsole() {
		for(int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	//Method to print text separator with length n
	public static void printSeparator(int n) {
		for(int i = 0; i < n; i++) {

			System.out.print("-");
		}
		System.out.println();
	}

	//Prints a heading
	public static void printHeading(String title) {

		printSeparator(title.length() + 5);
		System.out.println(title);
		printSeparator(title.length() + 5);
	}

	//Method to prompt user to enter something
	public static void anythingToContinue() {

		System.out.println("\nEnter anything to continue...");
		scan.nextLine();
	}

	//Method to start the game
	public static void startGame() {
		boolean nameSet = false;
		String name;

		//print title screen
		clearConsole();
		printSeparator(80);
		System.out.print("\t");
		printSeparator(60);
		System.out.println("\t\tHELLARMY ARMAGEDDON");
		System.out.println("\t\tAlpha version 3.0.0");
		System.out.println("\t\tText RPG by WSK_Lucky and Victor_Chokito");
		System.out.print("\t");
		printSeparator(60);
		printSeparator(80);
		anythingToContinue();

		//Player name loop
		do {
			clearConsole();
			printHeading("What is your name?");
			System.out.println("-> ");
			name = scan.nextLine();
			clearConsole();
			printHeading("Your name is: " + name + ".\nWould you like to change your name?");
			System.out.println("Yes?");
			System.out.println("No?");
			ArrayList<String> userChoices = new ArrayList<String>();
			userChoices.add("yes");
			userChoices.add("no");
			String input = readString("-> ", userChoices);
			if(input.equalsIgnoreCase("no")) {
				nameSet = true;
			}

		} while(!nameSet);

		clearConsole();
		anythingToContinue();
		chooseStartingAttributes(name);

	}

	public static void chooseStartingAttributes(String name) {

		clearConsole();
		printSeparator(100);
		System.out.println("You have the following attributes: ");
		printSeparator(60);
		printAttributes();
		printSeparator(60);
		System.out.println("You have 15, 14, 13, 12, 10, and 8 points to distribute among those attributes.");
		printSeparator(100);
		anythingToContinue();
		int[] userChoices = {15, 14, 13, 12, 10, 8};

		int strength = 0;
		int dexterity = 0;
		int constitution = 0;
		int intelligence= 0;
		int wisdom = 0;
		int charisma = 0;

		ArrayList<String> attributes = new ArrayList<String>();
		attributes.add("strength");
		attributes.add("dexterity");
		attributes.add("constitution");
		attributes.add("intelligence");
		attributes.add("wisdom");
		attributes.add("charisma");

		for(int i = 0; i < userChoices.length; i++) {
			//asks where player wants to place points
			clearConsole();
			printSeparator(60);
			System.out.println("In what attribute would you like to put " + userChoices[i] + " points?");
			printSeparator(30);
			for(int j = 0; j < attributes.size(); j++) {
				String s = attributes.get(j).substring(0, 1).toUpperCase() + attributes.get(j).substring(1);
				System.out.println("\t-" + s + "-");
			}
			printSeparator(30);
			printSeparator(60);

			//gets input from user
			String chosenAttribute = readString("-> ", attributes);
			attributes.remove(chosenAttribute);

			//allocates points to proper attribute
			if(chosenAttribute.equalsIgnoreCase("Strength")) {
				strength = userChoices[i];
			} else if(chosenAttribute.equalsIgnoreCase("Dexterity")) {
				dexterity = userChoices[i];
			} else if(chosenAttribute.equalsIgnoreCase("Constitution")) {
				constitution = userChoices[i];;
			} else if(chosenAttribute.equalsIgnoreCase("Intelligence")) {
				intelligence = userChoices[i];
			} else if(chosenAttribute.equalsIgnoreCase("Wisdom")) {
				wisdom = userChoices[i];
			} else if(chosenAttribute.equalsIgnoreCase("Charisma")) {
				charisma = userChoices[i];
			}

		}

		//Creates the player
		player = new Player(name, strength, dexterity, constitution, intelligence, wisdom, charisma);

		clearConsole();
		printHeading("You have successfully created your character!");
		anythingToContinue();

		isRunning = true; //Allows game to continue running

		gameLoop(); //Starts the main game loop
	}

	private static void printAttributes() {

		System.out.println("\t-Strength-");
		System.out.println("\t-Dexterity-");
		System.out.println("\t-Constitution-");
		System.out.println("\t-Intelligence-");
		System.out.println("\t-Wisdom-");
		System.out.println("\t-Charisma-");
	}

	//Method to continue the adventure
	public static void continueAdventure() {

	}

	//Prints the main menu
	public static void printMenu() {

		clearConsole();
		printHeading("MENU");
		System.out.println("Enter an action: ");
		printSeparator(20);
		System.out.println("-Continue on adventure-");
		System.out.println("-Character Sheet-");
		System.out.println("-Inventory-");
		System.out.println("-Exit Game-");
		printSeparator(20);
	}

	//Print the character sheet
	public static void characterSheet() {

		clearConsole();
		printHeading("CHARACTER SHEET");
		System.out.println(player);
		anythingToContinue();

	}
	
	//Prints the player's inventory
	private static void printInventory() {
		Game.printSeparator(20);
		System.out.println("Inventory");
		Game.printSeparator(20);
		int itemNum = 1;
		for(Items item : player.getInventory()) {
			System.out.println(itemNum + ") " + item.getName());
			itemNum += 1;
		}
		Game.printSeparator(20);
	}

	//Shows the player's inventory
	public static void showInventory() {
		if(player.getInventory().size() == 0) {
			clearConsole();
			Game.printSeparator(20);
			System.out.println("Inventory");
			Game.printSeparator(20);
			System.out.println("Inventory is Empty");
			System.out.println("\n\n");
			Game.printSeparator(20);
			anythingToContinue();
		} else {
			printInventory();
			
			//Ask reader if they want to inspect an item in their inventory
			inspectInventory();
		}
	}
	
	//Inspects inventory by asking user if they want to inspect an item
	private static void inspectInventory() {
		
		System.out.println("\n\n-> Enter ''inspect'' to inspect an item or ''exit'' to exit inventory...");
		ArrayList<String> userChoices = new ArrayList<String>();
		userChoices.add("inspect");
		userChoices.add("exit");
		String input = readString("-> ", userChoices);
		
		if(input.equalsIgnoreCase("inspect")) {
			userChoices.remove("inspect");
			for(Items item : player.getInventory()) {
				userChoices.add(item.getName());
			}
			
			//Asks user what item to inspect
			System.out.println("-> Which item would you like to inspect? ");
			input = readString("-> ", userChoices);
			
			//Checks if user will exit inventory
			if(input.equalsIgnoreCase("exit")) {
				clearConsole();
				anythingToContinue();
			} else {
				clearConsole();
				for(Items item : player.getInventory()) {
					if(input.equalsIgnoreCase(item.getName())) {
						System.out.println(item);
					}
				}
				anythingToContinue();
				clearConsole();
				printInventory();
				inspectInventory();
			}
		} else if(input.equalsIgnoreCase("exit")) {
			clearConsole();
			anythingToContinue();
		}
	}


	//Main game loop
	public static void gameLoop() {

		while(isRunning) {
			printMenu();
			ArrayList<String> userChoices = new ArrayList<String>();
			userChoices.add("character sheet");
			userChoices.add("continue adventure");
			userChoices.add("inventory");
			userChoices.add("exit game");
			String input = readString("-> ", userChoices);

			if(input.equalsIgnoreCase("continue adventure")) {
				continueAdventure();
			} else if(input.equalsIgnoreCase("character sheet")) {
				characterSheet();
			} else if(input.equalsIgnoreCase("inventory")) { 
				showInventory();
			} else if(input.equalsIgnoreCase("exit game")) {
		
				System.out.println("You have exited the game!");
				isRunning = false;
			}
		}
	}

}
