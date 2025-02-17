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

		String cars[] = new String[]{"top car", "bottom car"};
		String directions[] = new String[] {"forward", "back", "up-left", "down-left", "up-right", "down-right"};
		String playerColor;

		List<String> colors = new ArrayList<String>();
		//		"green", "white", "blue", "purple", "yellow", "orange"

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

		System.out.print("Do you want to play? [Yes or No] - ");
		System.out.println();

		input = scan.nextLine();

		if (!(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes"))) {	
			System.out.println("Yes you do!");
		}

		System.out.println("How many players? [Max 6]");
		System.out.println();

		boolean settingGame = true;

		while (settingGame) {

			try {
				//get player count as int
				playerCount = scan.nextInt();
				scan.nextLine();

				if (playerCount > maxPlayers) {
					System.out.println("Invalid number of players. Select 1-6.");
				} 
				else {

					System.out.println(playerCount + " players confirmed.");

					//	loop to choose color for each player


					for (int p = 1; p <= playerCount; p++) {

						Player newPlayer;
						System.out.println("Select color for player " + p + ".");

						boolean choosingColor = true;
						while (choosingColor) {

							System.out.println(colors);
							System.out.println();
							//	get color choice as string
							input = scan.nextLine();
							System.out.println();

							if(!containsNumbers(input)) {

								boolean matchFound = false;

								for (int i = 0; i < colors.size(); i++) {

									String listColor = colors.get(i);
									if (listColor.equals(input)) {

										System.out.println("Player " + p + " is " + input);
										System.out.println();

										players.add(newPlayer = new Player(p, input, ""));
										choosingColor = !choosingColor;
										colors.remove(input);
										matchFound = true;
									} 
								}
								if (!matchFound) {
									System.out.println("Not a valid color. Choose again:");
									System.out.println();
								}

								colors.remove(colorsToRemove);
							}
							else {
								System.out.println("No numbers!");
								System.out.println();
							}
						} //	end of colors for loop
						if (p >= playerCount) {
							settingGame = !settingGame;
						}

					} //	end of player for loop

				}

				if(!settingGame) {
					System.out.println("Game is set!");
					System.out.println("There are " + players.size() + " players.");

					for (int p = 0; p < players.size(); p++) {
						System.out.println("Player " + players.get(p).getPlayerNumber() + " is " + players.get(p).getPlayerColor());
					}
				}

			} catch (NumberFormatException e) {
				System.out.println("Try again.");
			} catch (InputMismatchException e) {
				System.out.println("Try again - Please enter a number, 1-6");
				scan.nextLine();
			}
			System.out.println();

		}	//end of game setup loop

		//		slam(cars, directions, scan);
	}

	public static boolean containsNumbers(String str){
		for(char ch : str.toCharArray()){
			if(Character.isDigit(ch)){
				return true;
			}
		}
		return false;
	}

	public static boolean isInt (String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static void slam(String[] cars, String[] directions, Scanner scan) {	

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
			}
			else if (input.equals("no") || input.equals("n")) {
				System.out.println("Wow pussy");
				playing = !playing;
			}
			else if (input.equals("fuck you")) {
				System.err.println("No, fuck YOU!");
				System.err.println("Game Over.");
				playing = !playing;
			}
			else {
				System.err.println("Yes or no idiot...");
			}
		}
	}

}
