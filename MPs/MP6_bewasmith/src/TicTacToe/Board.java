package TicTacToe;

public class Board {
	private char[][] board;
	private int size;
	char emptySpace = '-';

	public Board(int size) {
		this.size = size;
		this.board = new char[size][size];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = '-';
			}
		}
	}

	public boolean isTaken(int row, int coloum) {
		return board[row - 1][coloum - 1] != emptySpace;
	}

	public void placeToken(char token, int row, int col) {
		if (isTaken(row, col)) {
			System.out.println("spot is taken");

		} else if (isFull() == false) {
			this.board[row - 1][col - 1] = token;
		}
	}

	public void displayBoard() {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print("|" + board[i][j]);
			}
			System.out.println("|");
		}
	}

	public boolean isFull() {
		char check;
		boolean full;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
			if(board[i][j]== emptySpace) {
				return false;
			}
			}return true;
		}
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board.length; j++) {
//				if (board[i][j] == emptySpace) {
//					return false;
//				}
//			}
//		}
		return false;
	}

	public char getHorizontalWinner() {
		char begin;
		boolean winner;
		for (int i = 0; i < size; i++) {
			begin = board[i][0];
			if (begin != emptySpace) {
				winner = true;
				for (int j = 0; j < size; j++) {
					if (board[i][j] != begin) {
						winner = false;
						break;
					}
				}
				if (winner) {
					return begin;
				}
			}
		}
		return emptySpace;
	}

	public char getVerticalWinner() {
		char begin;
		boolean winner;
		for (int i = 0; i < size; i++) {
			begin = board[0][i];
			if (begin != emptySpace) {
				winner = true;
				for (int j = 0; j < size; j++) {
					if (board[j][i] != begin) {
						winner = false;
						break;
					}
				}
				if (winner) {
					return begin;
				}
			}
		}
		return emptySpace;
	}

	public char getDiagonalWinner() {
		char begin;
		boolean winner;
		begin = board[0][0];
		if (begin != emptySpace) {
			winner = true;
			for (int i = 0; i < size; i++) {
				if (board[i][i] != begin) {
					winner = false;
					break;
				}
			}
			if (winner) {
				return begin;
			}
		}
		begin = board[0][size - 1];
		if (begin != emptySpace) {
			winner = true;
			for (int i = 1; i < size; i++) {
				if (board[i][size - 1 - i] != begin) {
					winner = false;
					break;
				}
			}
			if (winner) {
				return begin;
			}
		}
		return emptySpace;
	}

	public char getWinner() {
		if (getHorizontalWinner() != emptySpace) {
			return getHorizontalWinner();
		}
		if (getDiagonalWinner() != emptySpace) {
			return getDiagonalWinner();
		}
		if (getVerticalWinner() != emptySpace) {
			return getVerticalWinner();
		}
		return emptySpace;

	}
}
