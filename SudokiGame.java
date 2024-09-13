package maon;

public class SudokiGame {
	
	private static int Size=9;
	
	
	static boolean Solved(int[][] board)
	{
		for(int i=0; i<Size;i++)
		{
			for(int j=0; j<Size;j++)
			{
				if(board[i][j]==0)
				{
					
					for(int tryNumber=1;tryNumber<Size+1;tryNumber++)
					{ if(valid(board ,i ,j , tryNumber))
					 {
						board[i][j]=tryNumber;
						if(Solved(board)) 
							return true;
						else board[i][j]=0;
					 }
					}
				}
			}
		}
		return true;
	}
	
	
	static boolean valid(int [][]board , int row, int col,int number)
	{
		for(int i=0;i<Size;i++)
			if(board[row][i]==number)return false;
		
		
		for(int i=0;i<Size;i++)
			if(board[i][col]==number)return false;
		
		 int localBoxRow = row - row % 3;
	        int localBoxCol = col - col % 3;

	        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
	            for (int j = localBoxCol; j < localBoxCol + 3; j++) {
	                if (board[i][j] == number) {
	                    return false;
	                }
	            }
	        }

	        return true;

	}
	
	    static void printBoard(int[][] board) {
	        for (int row = 0; row < Size; row++) {
	            if (row % 3 == 0 && row != 0) {
	                System.out.println("-----------");
	            }
	            for (int col = 0; col < Size; col++) {
	                if (col % 3 == 0 && col != 0) {
	                    System.out.print("|");
	                }
	                System.out.print(board[row][col]);
	            }
	            System.out.println();
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] board = {
		            {7, 0, 2, 0, 5, 0, 6, 0, 0},
		            {0, 0, 0, 0, 0, 3, 0, 0, 0},
		            {1, 0, 0, 0, 0, 9, 5, 0, 0},
		            {8, 0, 0, 0, 3, 0, 0, 9, 0},
		            {0, 4, 3, 1, 0, 0, 7, 5, 0},
		            {0, 9, 0, 0, 0, 0, 0, 0, 8},
		            {0, 0, 9, 7, 0, 0, 1, 0, 5},
		            {0, 0, 0, 2, 0, 0, 0, 0, 0},
		            {0, 0, 7, 0, 4, 0, 2, 0, 3}
		        };
		 if (Solved(board)) {
	            System.out.println("Sudoku solved successfully!");
	        } else {
	            System.out.println("Unsolvable Sudoku!");
	        }

	        printBoard(board);

	}}

	
	
	
	
	
	

