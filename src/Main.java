import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String cars[] = new String[]{"top car", "bottom car"};
		String directions[] = new String[] {"forward", "back", "up-left", "down-left", "up-right", "down-right"};
		String playerColor;
		String colors[] = new String[]{"green", "white", "blue", "purple", "yellow", "orange"};

		Scanner scan = new Scanner(System.in);
		String input = "";

		System.out.print("Do you want to play? [Yes or No] - ");
		input = scan.nextLine();

		if (!(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes"))) {	
			System.out.println("Yes you do!");
		}

		System.out.println("Select your color.");

		for (int i = 0; i < colors.length; i++) {
			if (i < colors.length - 1) {
				System.out.print(colors[i] + ", ");
			} else {
				System.out.print(colors[i]);
			}
		}

		
		boolean choosing = true;

		while (choosing) {

			input = scan.nextLine();

			for (int i = 0; i < colors.length; i++) {

				if (input.equalsIgnoreCase(colors[i])) {
					playerColor = input;
					System.out.println("you are " + playerColor);
					choosing = !choosing;
					break;
				} else {
					if (i == colors.length - 1) {
						System.out.println("Not a valid color");
						System.out.println("Choose another option: ");
					}
				}
			}
		}

		//		slam(cars, directions, scan);
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
