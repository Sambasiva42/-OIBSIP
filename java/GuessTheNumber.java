import java.util.Random;
import java.util.Scanner;

// Game class
class Game {
	
	int systemNum;
	int userNum;
	int noOfChances = 0;
	
	Game() {
		Random random = new Random();
		this.systemNum = random.nextInt(100) + 1;
	}
	
	
	public boolean takeUserNum() {
		if ( noOfChances < 5 ) {
			System.out.print("Guess the number : ");
			this.userNum = GuessTheNumber.takeIntegerInput(100);
			noOfChances++;
			return false;
		}
		else {
			System.out.println("Number of attempts finished...");
			System.out.println("Better luck next time and the Number is "+systemNum);
			return true;
		}
	}
	
	
	public boolean isCorrect() {
		
		if ( systemNum == userNum ) {
			System.out.println("Congratulations, you guess the number " + systemNum +
			" in " + noOfChances + " guesses");
			switch(noOfChances) {
				case 1:
				System.out.println("Awesome !! You won 1000$");
				break;
				case 2:
				System.out.println("Cool !! You won 800$");
				break;
				case 3:
				System.out.println("Smart !! You won 600$");
				break;
				case 4:
				System.out.println("Excellent !! You won 400$");
				break;
				case 5:
				System.out.println("Fine !! You won 200$");
				break;
			}
			System.out.println();
			return true;
		}
		else if ( noOfChances < 5 && userNum > systemNum ) {
			if ( userNum - systemNum < 3 ) {
				System.out.println("Almost there...try a smaller one ");
			}
			else if ( userNum - systemNum > 10 ) {
				System.out.println("Too High...");
			}
			else {
				System.out.println("Little High...");
			}
		}
		else if ( noOfChances < 5 && userNum < systemNum ) {
			if ( systemNum - userNum < 3 ) {
				System.out.println("Almost there...try a bigger one");
			}
			else if ( systemNum - userNum > 10 ) {
				System.out.println("Too low...");
			}
			else {
				System.out.println("Little low...");
			}
		}

		return false;
	}
}

// main class
public class GuessTheNumber{

	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) {
					System.out.println("Choose the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Enter only integer value");
				flag = false;
			}
		};
		return input;
	}
	
	// main method
	public static void main(String[] args) {
		
		// input for start the game
		System.out.println("1. Start the Game \n2. Exit");
		System.out.print("Enter your choice : ");
		int choice = takeIntegerInput(1);

		System.out.println("Your game Started\nYou will have only Five chances !!!");
		int nextRound = 1;
		int noOfRound = 0;
		
		if ( choice == 1 ) {
			
			while ( nextRound == 1 ) {
				// creating object of Game class
				Game game = new Game();
				boolean match = false;
				boolean limit = false;
				System.out.println("\nRound " + ++noOfRound + " starts...");
				
				// to check correct guess and limit cross
				while ( !match && !limit) {
					limit = game.takeUserNum();
					match = game.isCorrect();
					nextRound = 0;
				}
			}
		}
		else {
			System.exit(0);
		}
	}
}