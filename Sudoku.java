import java.util.*;

public class Sudoku
{
	public static void main(String[] args)
	{
		//Setup inputs
		Scanner input = new Scanner(System.in);
		//Creates, declares and initializes the multi-dimensional array
		int[][] board = new int[9][9];
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[0].length; j++)
			{
				board[i][j] = input.nextInt();
			}
		}
		if(checkRows(board) && checkColumns(board) && checkBoxes(board))
		{
			System.out.println("valid");
		}
		else
		{
			System.out.println("invalid");
		}
	}

	public static boolean checkRows(int[][] board)
	{
		for(int i = 0; i < board.length; i++)
		{
			//In each row, check each number 1-9 and see how many times each appears
			for(int j = 1; j <= 9; j++)
			{
				int count = 0; //Count the number of times each number 1-9 appears
				for(int k = 0; k < board[0].length; k++)
				{
					if(board[i][k] == j)
					{
						count++;
					}
				}
				if(count != 1)
				{
					return false;
				}
			}
		}
		return true;
	}

	public static boolean checkColumns(int[][] board)
	{
		for(int i = 0; i < board[0].length; i++)
		{
			//In each column, check each number 1-9 and see how many times each appears
			for(int j = 1; j <= 9; j++)
			{
				int count = 0; //Count the number of times each number 1-9 appears
				for(int k = 0; k < board.length; k++)
				{
					if(board[k][i] == j)
					{
						count++;
					}
				}
				if(count != 1)
				{
					return false;
				}
			}
		}
		return true;
	}

	public static boolean checkBoxes(int[][] board)
	{
		//Goes to the top left of each of the nine 3x3 boxes
		for(int i = 0; i < board.length; i += 3)
		{
			for(int j = 0; j < board[0].length; j += 3)
			{
				//In each box, check each number 1-9 and see how many times each appears
				for(int n = 1; n <= 9; n++)
				{
					int count = 0;
					//Goes through the 3x3 box
					for(int k = i; k < i + 3; k++) //Row
					{
						for(int l = j; l < j + 3; l++) //Column
						{
							if(board[k][l] == n)
							{
								count++;
							}
						}
					}
					if(count != 1)
					{
						return false;
					}
				}
			}
		}
		return true;
	}
}
