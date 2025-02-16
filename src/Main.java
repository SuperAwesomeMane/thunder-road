import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String cars[] = new String[]{"top car", "bottom car"};
		String directions[] = new String[] {"forward", "back", "up-left", "down-left", "up-right", "down-right"};

		Scanner scan = new Scanner(System.in);
		String input;

		System.out.print("Do you want to play? [Yes or No] - ");
		input = scan.nextLine();

		if (!input.equals("yes") || !input.equals("y")) {	
			System.out.println("Yes you do!");
		}
		
		slam(cars, directions, scan);
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
