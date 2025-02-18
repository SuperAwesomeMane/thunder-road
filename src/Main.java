import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> colors = new ArrayList<String>();
		// "green", "white", "blue", "purple", "yellow", "orange"

		colors.add("green");
		colors.add("white");
		colors.add("blue");
		colors.add("purple");
		colors.add("yellow");
		colors.add("orange");

		List<String> colorsToRemove = new ArrayList<String>();

		int playerCount = 0;
		int maxPlayers = colors.size();

		List<Player> players = new ArrayList<>();

		Scanner scan = new Scanner(System.in);
		String input = "";

		System.out.println("THUNDER FUCKING ROAD!!!!!");

		System.out.println("How many players? [2-6]");
		System.out.println();

		setupGame(colors, maxPlayers, players, scan);

		playGame(players, scan);

		// slam(cars, directions, scan);
	}

	private static void setupGame(List<String> colors, int maxPlayers, List<Player> players, Scanner scan) {

		int playerCount;
		String input;
		boolean settingGame = true;

		while (settingGame) {

			try {
				// get player count as int
				playerCount = scan.nextInt();
				scan.nextLine();

				if (playerCount <= maxPlayers && playerCount > 1) {

					System.out.println(playerCount + " players confirmed.");

					// loop to choose color for each player

					for (int p = 1; p <= playerCount; p++) {

						Player newPlayer;
						System.out.println("Select color for player " + p + ".");

						boolean choosingColor = true;
						while (choosingColor) {

							System.out.println(colors.toString().toUpperCase());
							System.out.println();

							// get color choice as string
							input = scan.nextLine();
							System.out.println();

							if (!containsNumbers(input)) {

								boolean matchFound = false;

								for (int i = 0; i < colors.size(); i++) {

									String listColor = colors.get(i);

									if (listColor.equals(input)) {

										System.out.println("Player " + p + " is " + input.toUpperCase());
										System.out.println();

										players.add(newPlayer = new Player(p, input, "car", 10));
										choosingColor = !choosingColor;
										colors.remove(input);
										matchFound = true;
									}
								}
								if (!matchFound) {
									System.out.println("Not a valid color. Choose again:");
									System.out.println();
								}

							} else {
								System.out.println("No numbers!");
								System.out.println();
							}
						} // end of colors for loop
						if (p >= playerCount) {
							settingGame = !settingGame;
						}

					} // end of player for loop
				} else {
					System.out.println("Invalid number of players. Select 2-6.");
				}

				if (!settingGame) {
					System.out.println("Game is set!");
					System.out.println("There are " + players.size() + " players.");

					for (int p = 0; p < players.size(); p++) {
						System.out.println("Player " + players.get(p).getPlayerNumber() + " is "
								+ players.get(p).getPlayerColor().toUpperCase());
					}
					System.out.println("All players have 10 HP");
				}

			} catch (NumberFormatException e) {
				System.out.println("Try again.");
			} catch (InputMismatchException e) {
				System.out.println("Try again - Please enter a number, 2-6");
				scan.nextLine();
			}
			System.out.println();

		} // end of game setup loop
	}

	public static void playGame (List<Player> playerList, Scanner scan) {

		String[] cars = new String[]{"top car", "bottom car"};
		String[] directions = new String[]{"forward", "back", "up-left", "down-left", "up-right", "down-right"};

		//		List<Player> playerListCopy = new ArrayList<Player>(currentPlayers);

		String input = "";

		String[] attackType = new String[]{"slam", "shoot"};

		boolean playingGame = true;
		while (playingGame) {

			//			int playerTurn = 0;
			Player currentPlayer;

			for (int p = 0; p < playerList.size(); p++) {
				currentPlayer = playerList.get(p);

				System.out.println("Player " + currentPlayer.getPlayerNumber() 
				+ "'s turn. [" + currentPlayer.getPlayerColor().toUpperCase() + ", " 
				+ currentPlayer.getPlayerHealth() + "HP, Top Car]");
				System.out.println();

				System.out.println("who do you want to slam? [Bottom Car]");
				System.out.println();
				System.out.println("Enter enemy color: You have " + currentPlayer.getPlayerHealth() + "HP");

				//list options if enemy choice is alive

				boolean choosingVictim = true;

				//choose enemy
				while (choosingVictim) {

					for (Player checkedPlayer : playerList) 
					{
						if (!(checkedPlayer.getPlayerColor().equals(currentPlayer.getPlayerColor()) && checkedPlayer.getPlayerHealth() != 0))
						{
							System.out.println("Player " + checkedPlayer.getPlayerNumber() + ", " + checkedPlayer.getPlayerColor().toUpperCase() + ", " + checkedPlayer.getPlayerHealth() + "HP");
						}
					}

					input = scan.nextLine();

					if (!containsNumbers(input) ) {

						boolean matchFound = false;

						for (int i = 0; i < playerList.size(); i++) {
							Player victim = playerList.get(i);

							if (!victim.getPlayerColor().equals(currentPlayer.getPlayerColor())) {

								if ((victim.getPlayerColor().equals(input) && victim.getPlayerHealth() > 0))
								{
									damage(victim, cars, directions);

									choosingVictim = !choosingVictim;
									if (victim.getPlayerHealth() <= 0) {
										System.err.println("Player " + victim.getPlayerNumber() + " [" + victim.getPlayerColor().toUpperCase() + "] has died!!!");
										playerList.remove(victim);
									} 
									matchFound = true;
								}
							}
						}
						if (!matchFound){
							System.out.println("Invalid. Choose again");
						}
					}

				}

				//				playerTurn++;

				//end the game if only 1 player is left
				if(playerList.size() == 1) {
					System.out.println();
					System.out.println("Player " + playerList.get(0).getPlayerNumber() + " [" + playerList.get(0).getPlayerColor().toUpperCase() + "] wins!!!");
					playingGame = false;
				}

			}
		}
	}

	private static void damage(Player p, String[] cars, String[] dir) {
		Random random = new Random();
		boolean missed;

		if(Math.round(Math.random()) == 0) {
			missed = false;
		}
		else {
			missed = true;
		}

		if(missed) {
			System.err.println("Attack missed!");
			System.out.println();
		}
		else {
			int damage = random.nextInt(6) + 1;
			int currentHealth = p.getPlayerHealth() - damage;
			p.setPlayerHealth(currentHealth);
			System.out.println("Player " + p.getPlayerNumber() + " hit! [" + p.getPlayerHealth() + " HP remaing]");
			System.out.println();
		}
	}

	public static boolean containsNumbers(String str) {
		for (char ch : str.toCharArray()) {
			if (Character.isDigit(ch)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static void slam(Player player, Player victim, String[] cars, String[] directions, Scanner scan) {

		Random random = new Random();
		boolean playing = true;
		String input;

		while (playing) {
			System.out.print("Ready to slam? [Yes or No] - ");
			input = scan.nextLine();

			String randomCar = cars[random.nextInt((cars.length))];
			String randomDirection = directions[random.nextInt(directions.length)];

			if (input.equals("y") || input.equals("yes")) {
				System.out.println(randomCar + " will move 1 space " + randomDirection);
			} else if (input.equals("no") || input.equals("n")) {
				System.out.println("Wow pussy");
				playing = !playing;
			} else if (input.equals("fuck you")) {
				System.err.println("No, fuck YOU!");
				System.err.println("Game Over.");
				playing = !playing;
			} else {
				System.err.println("Yes or no idiot...");
			}
		}
	}

}
