import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int cases = Integer.parseInt(in.nextLine());
		
		for (int currCase = 0; currCase < cases; currCase++)
		{
			String line = in.nextLine();
			int rows = Integer.parseInt(line.split(" ")[0]);
			int cols = Integer.parseInt(line.split(" ")[1]);
			int days = Integer.parseInt(line.split(" ")[2]);
			
			char[][] board = new char[rows][cols];
			char[][] board2 = new char[rows][cols];
			
			for (int currRow = 0; currRow < rows; currRow++)
			{
				String boardLine = in.nextLine();
				for(int currCol = 0; currCol < cols; currCol++)
				{
					board[currRow][currCol] = boardLine.toCharArray()[currCol];
				}
			}
			
			char[][] oldBoard = null;
			char[][] newBoard = null;
			
			for (int day = 0; day < days; day++)
			{
				oldBoard = day % 2 == 0 ? board : board2;
				newBoard = day % 2 == 0 ? board2 : board;
				
				for (int currRow = 0; currRow < rows; currRow++)
				{
					for(int currCol = 0; currCol < cols; currCol++)
					{
						char currChar = oldBoard[currRow][currCol];
						char newChar = currChar == 'R' ? 'P' : currChar == 'P' ? 'S' : 'R';
						
						if ((currRow > 0 && oldBoard[currRow-1][currCol] == newChar) ||
								(currCol > 0 && oldBoard[currRow][currCol-1] == newChar) ||
								(currRow < rows-1 && oldBoard[currRow+1][currCol] == newChar) ||
								(currCol < cols-1 && oldBoard[currRow][currCol+1] == newChar)
								)
							newBoard[currRow][currCol] = newChar;
						else
							newBoard[currRow][currCol] = currChar;
					}
				}
			}
			for (int currRow = 0; currRow < rows; currRow++)
			{
				for(int currCol = 0; currCol < cols; currCol++)
				{
					System.out.print(newBoard[currRow][currCol]);
				}
				System.out.println();
			}
			System.out.println(); // not sure...
		}
	}

}
