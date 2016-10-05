import java.util.Scanner;

/**
* <Farmer's Game>
* The goal of the game is to get all 4 objects across the river
* @author Luke Ittycheria
* @version 2.0
*/


public class FarmersGame
{

	//Global Scope

	public static boolean cabb = false;
	public static boolean sheep = false;
	public static boolean wolf = false;
	public static boolean human = false;
	public static boolean gameKeep = true;
	
	public static void main(String args[])
	{
		
		welcome();
		while(gameKeep == true)
		{
			displayGameStatus();
			gamePlay();
		}
	}

	/**
	* This method prints the instructions of the game 
	* No parameters or return values
	*/
	public static void welcome()
	{
		System.out.println("Welcome to the Farmer's Game!");
		System.out.println("The goal of the game is to get all 4 objects across the river");
		System.out.println("Only one object can tag along with the human at a time, but the human can go alone");
		System.out.println("Be careful though, if you leave the cabbage with the sheep the sheep will eat the cabbage");
		System.out.println("Also if you leave the sheep with the wolf, the wolf will eat the sheep");
		System.out.println("Good Luck!");
	}
	
	/**
	* This method displays the game visuals
	* No parameters or return values
	*/
	public static void displayGameStatus()
	{
		String bank0 = "    ";
		String bank1 = "    ";
		
		if(!cabb)
			bank0 += "C ";
		else
			bank1 += "C ";
		if(!sheep)
			bank0 += "S ";
		else
			bank1 += "S ";
		if(!wolf)
			bank0 += "W ";
		else
			bank1 += "W ";
		if(!human)
			bank0 += "H ";
		else
			bank1 += "H ";
		
		System.out.println(bank0);
		System.out.println("---------------------");
		System.out.println("\n \n \n");
		System.out.println("---------------------");
		System.out.print(bank1);
	}
	
	/**
	* This method is the actual user interface of the game
	* This method checks if the user has won or lost the game
	* This method also lets the user move the players
	* No parameters or return values
	*/
	public static void gamePlay()
	{
		Scanner keyboard = new Scanner(System.in);
		if(cabb == sheep && wolf != sheep && human != sheep)
		{
			System.out.println("You lose! The sheep ate the cabbage.");
			gameKeep = false;
		}
		
		else if(sheep == wolf && cabb != sheep && human != wolf)
		{
			System.out.println("You lose! The wolf ate the sheep.");
			gameKeep = false;
		}
		
		else if(cabb == true && sheep == true && wolf == true && human == true)
		{
			System.out.println("You win!!");
			gameKeep = false;
		}
		
		
		
		else
		{
			System.out.println("");
			System.out.println("What would you like to move?");
			 String user_choice = keyboard.nextLine();
		
			if(user_choice.equals("C"))
			{
				if(cabb == human)
				{
					cabb = !cabb;
					human = !human;
				}
				else
				{
					System.out.println("Not a valid move");
				}	
			}
		
			if(user_choice.equals("S"))
			{
				if(sheep == human) //SHEEP = !SHEEP
				{
					sheep = !sheep;
					human = !human;
				}
				else
				{	
					System.out.println("Not a valid move");
				}		
			}
		
			if(user_choice.equals("W"))
			{
				if(wolf == human)
				{
					wolf = !wolf;
					human = !human;
				}
				else
				{
					System.out.println("Not a valid move");
				}
				
			}
			if(user_choice.equals("H"))
			{
				human = !human;
				
			}
		
		}
		
	}

}