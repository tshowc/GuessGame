import java.util.*;

/**
 * This is the main class that instantiates the Bot class and begins the guessing game.
 * It will ask the user if he or she has thought of an animal.
 * Also it will ask the user to play again after he or she finishes a game. 
 * @author chao
 *
 */
public class GameMain {

	/**
	 * Main that begins the guessing game
	 * @param args 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bot GuessBot = new Bot();
		char charChoice;//Y or N to start game
		char charEnd;//Y or N to play again

		Scanner in  = new Scanner(System.in);
		
		System.out.println("Hello! I will do my best to guess your animal!");
		
		do{//DoWhile loop to check character entered and allow user to re-enter valid arguments
		System.out.println("Ok. Think of an animal. Ready? ('y' to continue)");
		charChoice = in.nextLine().toUpperCase().charAt(0);
		if (charChoice == 'Y'){
			do{//Ask questions
			GuessBot.askQuestion();
			
			do{//DoWhile loop to check character entered and allow user to re-enter valid arguments
			System.out.println("Would you like to play again? (y/n)");
			charEnd = in.nextLine().toUpperCase().charAt(0);
			if (charEnd != 'Y' && charEnd != 'N'){
				System.out.println("Invalid Character.");
			}}while(charEnd != 'Y' && charEnd != 'N');
			}while(charEnd != 'N');
		}
		else if(charChoice == 'N'){
			System.out.println("I'll wait.");
		}
		else{
			System.out.println("Invalid Character. Try Again.");
		}
		}while(charChoice != 'Y');
		
		in.close(); //Closes input stream
	}

}
