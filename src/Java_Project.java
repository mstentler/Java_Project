import java.util.Scanner;

//Initial commit - Guillermo Stentler - 10/3/2017
public class Java_Project {
	public static void main(String[] args) {
		Board test = new Board();
		Player ply1 = new Player();
		Player ply2 = new Player();
		test.Print();
		while(true) {
			if(test.Valid_move(ply1.make_move_x(), ply1.make_move_y()))
			{
				int x, y;
				x = ply1.make_move_x();
				y = ply1.make_move_y();
				test.make_move(x, y, 1);
				test.Print();
			}
			else 
			{
				System.out.println("Invalid Move!");
			}
//			test.Print();
		}
	}
}

class Board {
	//2D array to store the board 
	int[][] board = new int[5][5];
	//Constructor that initializes the board with 
	//NUmbers of the left and top edges and zeros 
	public Board() {
		for(int i=1;i<5;i++) {
			for(int j=1;j<5;j++) {
				board[i][j] = 0;
			}
		}
		for(int i=0;i<5;i++)
			board[0][i] = i;
		for(int i=0;i<5;i++)
			board[i][0] = i;
		
	}
	//Method that loops thru the board array and prints 
	//to console the elements 
	public void Print() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(board[i][j]);
				System.out.print(" ");
			}
			System.out.println(board[i][4]);
		}
	}
	//Method that checks that board position is available
	public Boolean Valid_move(int x, int y) {
		int temp = board[x][y];
		if(temp == 0)
			return true;
		else 
			return false;
	}
	//Method that changes board position to player number 
	public void make_move(int x, int y, int p) {
		board[x][y] = p;
	}
	//Method that checks the board to see if there is a winner 
	public Boolean Check_board() {
		
		return true;
	}
}

class Player {
	//2D array to record the moves made by each player 
	//Each element corresponds to an element in the 2D board 
	//array in the Board class i.e. board[1][4] <=> board_moves[5]
	int[] board_moves = new int[16];
	//Method that stores the move made to the board_moves array 
	public void record_move(int x, int y, int p) {
		board_moves[x+y] = p;
	}
	//Method that returns the X position for move 
	public int make_move_x() {
		Scanner in = new Scanner(System.in);
		System.out.print("Row?: ");
		return in.nextInt();
		
	}
	//Method that returns the Y position for move 
	public int make_move_y() {
		Scanner in = new Scanner(System.in);
		System.out.print("Column?: ");
		return in.nextInt();
	}
}