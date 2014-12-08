import java.util.*;
/**
 * This class creates a "Bot" that operates as the programs voice and prompter. 
 * It creates a new Binary Tree and manipulates it using methods belonging to the BinaryTree class.
 * This "Bot" will ask the questions and insert answers into a Binary Tree.
 * It will keep guessing until it gives up or reaches a correct answer.
 * @author chao
 *
 */
public class Bot{
	Scanner in = new Scanner(System.in); //Open input stream
	/**
	 * Default Constructor, creates a new Binary Tree
	 */
	Bot(){
		GuessTree = new BinaryTree();
	}
	/**
	 * This method asks the user questions and will try to guess what the animal is.
	 */
	void askQuestion(){
		String animal;
		String question;
		char YorN;
		if (GuessTree.isEmpty()){
			/*TREE IS EMPTY*/
			giveUp();
			//System.out.println(root.data);
		}
		else if (GuessTree.isAtEnd()){
			/*AT END NODE*/
			//System.out.println("END");
			animal = GuessTree.current.data;
			question = "Is it " + AorAn(animal) + " " + animal + "?";
			//DoWhile loop to check character entered and allow user to re-enter valid arguments
			do{
			System.out.println(question);
			YorN = in.nextLine().toUpperCase().charAt(0);
			if (YorN == 'Y'){
				System.out.println("I win!");
				GuessTree.setCurrentToStart();
			}
			else if (YorN == 'N'){
				giveUp();
			}
			else{
				System.out.println("Invalid Character. Try Again.");
			}}while(YorN != 'Y' && YorN != 'N');
		}
		else{
			/*ASKING QUESTION*/
			//System.out.println("ASKING");
			question =  GuessTree.current.data;//Question Node
			//DoWhile loop to check character entered and allow user to re-enter valid arguments
			do{
			System.out.println(question);
			YorN = in.nextLine().toUpperCase().charAt(0);
			if (YorN == 'Y'){
				GuessTree.moveCurrentYes();
				askQuestion();
			}
			else if (YorN == 'N'){
				if(GuessTree.current.left == null){
					giveUp();
					
					
				}
				else{
					GuessTree.moveCurrentNo();
					askQuestion();
				}
			}
			else{
				System.out.println("Invalid Character. Try Again.");
			}
		}while(YorN != 'Y' && YorN != 'N');
		}
	}
	/**
	 * If the Bot cannot guess the correct animal, it will give up and ask
	 * the user to input the animal and a question that describes it.
	 */
	void giveUp(){
		String oldAnimal; //guessed Animal
		String animal; //new Animal
		String question; //Concatenated String
		String newQuestion; //new Question
		System.out.println("I give up. What is it? ");
		animal = in.nextLine();
		question = "What question would tell me it is " 
					+ AorAn(animal) + " " + animal + "?";
		System.out.println(question);
		newQuestion = in.nextLine();
		/*IF BINARY TREE IS EMPTY*/
		if (GuessTree.isEmpty()){
			//moves new question to the right
			GuessTree.Insert(newQuestion, "Y");
			//moves new animal to the right
			GuessTree.Insert(animal, "Y");
			GuessTree.setCurrentToStart();
		}
		/*IF CURRENT POINTER IS AT STARTING NODE
		 *AND USER ENTERS NO FOR FIRST QUESTION*/
		else if( GuessTree.current.data == GuessTree.root.data){
			//moves new question to the left
			GuessTree.Insert(newQuestion, "N");
			//set current pointer to the new question node
			GuessTree.moveCurrentNo();
			//moves new animal to the right of new question
			GuessTree.current.right = new Node(animal);
			GuessTree.setCurrentToStart();
			
		}
		else{
			/*IF NODE IS A QUESTION*/
			if(GuessTree.current.data.contains("?")){
				//Create new left node
				GuessTree.current.left = new Node(newQuestion);
				//Create new left.right node
				GuessTree.current.left.right = new Node(animal);
				GuessTree.setCurrentToStart();
			}
			/*IF GUESSED ANIMAL IS WRONG*/
			else{
				//oldAnimal is the animal guess by the Bot
				oldAnimal = GuessTree.current.data;
				//the new question replaces the oldAnimal node
				GuessTree.current.data = newQuestion;
				//the oldAnimal is pushed to the left
				GuessTree.current.left = new Node(oldAnimal);
				//the new correct animal placed to the right
				GuessTree.current.right = new Node(animal);
				GuessTree.setCurrentToStart();
			}
		}
		
	//	GuessTree.Print();

	}
	/**
	 * This method places correct grammatical structure, a or an, in front of an animal string.	
	 * @param animal The animal that needs to be analyzed
	 * @return aOran an if the animal's first letter begins with a vowel, a for anything else
	 */
	String AorAn(String animal){
		Character firstLetter; 
		//Array of Vowels
		ArrayList<Character> vowels = new ArrayList<Character>();
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
		
		firstLetter = animal.toUpperCase().charAt(0);
		
		if (vowels.contains(firstLetter)){
			return "an";
		}
		else{
			return "a";
		}
		
	}
	BinaryTree GuessTree; //Binary Tree for storing questions and answers
}
