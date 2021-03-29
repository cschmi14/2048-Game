package gameFiles;

import java.util.Random;

public class Board {

	protected int[][] b;
	protected Random r = new Random();

	public Board() {
		b = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				b[i][j] = 0;
			}
		}
		int a = r.nextInt(4);
		int c = r.nextInt(4);
		int e = r.nextInt(2);
		if (e == 1) {
			b[a][c] = 2;
		} 
		else {
			b[a][c] = 4;
		}
		e = r.nextInt(2);
		int f = r.nextInt(4);
		int g = r.nextInt(4);
		boolean done = false;
		while (!done) {
			if (f == a && g == c) {
				f = r.nextInt(4);
				g = r.nextInt(4);
				e = r.nextInt(2);
			}
			else if (e == 1) {
				b[f][g] = 2;
				done = true;
			}
			else {
				b[f][g] = 4;
				done = true;
			}
		}
	}

	public int[][] returnBoardState() {
		return b;
	}
	
	public void resetBoard() {
		b = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				b[i][j] = 0;
			}
		}
		int a = r.nextInt(4);
		int c = r.nextInt(4);
		int e = r.nextInt(2);
		if (e == 1) {
			b[a][c] = 2;
		} 
		else {
			b[a][c] = 4;
		}
		e = r.nextInt(2);
		int f = r.nextInt(4);
		int g = r.nextInt(4);
		boolean done = false;
		while (!done) {
			if (f == a && g == c) {
				f = r.nextInt(4);
				g = r.nextInt(4);
				e = r.nextInt(2);
			}
			else if (e == 1) {
				b[f][g] = 2;
				done = true;
			}
			else {
				b[f][g] = 4;
				done = true;
			}
		}
	}

	public void randomNum() {
		String[] coordinates = {"00","01","02","03","10","11","12","13","20","21","22","23","30","31","32","33",};
		String point = "";
		int x;
		int y;
		int index = r.nextInt(16);
		int num = r.nextInt(2);
		boolean done = false;
		while (!done) {
			point = coordinates[index];
			x = Character.getNumericValue(point.charAt(0));
			y = Character.getNumericValue(point.charAt(1));
			if (b[x][y] == 0) {
				if (num == 1) {
					b[x][y] = 4;
					done = true;
				}
				else {
					b[x][y] = 2;
					done = true;
				}	
			}
			else {
				coordinates = removeElement(coordinates, index);
				index = r.nextInt(coordinates.length);
				num = r.nextInt(2);
			}
		}
	}

	public void printBoard() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public String[] removeElement(String[] a, int n) {
		String[] copy = new String[a.length - 1];
		for (int i = 0, j = 0; i < a.length; i++) {
			if (i != n) {
				copy[j] = a[i];
				j++;
			}
		}
		return copy;
	}

	public int[][] moveLeft() {

		for (int i = 0; i < 4; i++) {

			if (b[i][1] == 0 && b[i][0] == 0 && b[i][2] == 0) {
				b[i][0] = b[i][3];
				b[i][3] = 0;
			} else if (b[i][0] == 0 && b[i][1] == 0) {
				b[i][0] = b[i][2];
				b[i][2] = 0;
			} else if (b[i][0] == 0) {
				b[i][0] = b[i][1];
				b[i][1] = 0;
			}
			if (b[i][0] == b[i][1]) {
				b[i][0] *= 2;
				b[i][1] = 0;
			} else if (b[i][0] == b[i][3] && b[i][2] == 0 && b[i][1] == 0) {
				b[i][0] *= 2;
				b[i][3] = 0;
			} else if (b[i][0] == b[i][2] && b[i][1] == 0) {
				b[i][0] *= 2;
				b[i][2] = 0;
			}
			if (b[i][1] == 0 && b[i][2] == 0) {
				b[i][1] = b[i][3];
				b[i][3] = 0;
			} else if (b[i][1] == 0) {
				b[i][1] = b[i][2];
				b[i][2] = 0;
			}
			if (b[i][1] == b[i][2] && b[i][1] != 0) {
				b[i][1] *= 2;
				b[i][2] = 0;
			} else if (b[i][1] == b[i][3] && b[i][2] == 0) {
				b[i][1] *= 2;
				b[i][3] = 0;
			}
			if (b[i][2] == b[i][3]) {
				b[i][2] *= 2;
				b[i][3] = 0;
			} else if (b[i][2] == 0) {
				b[i][2] = b[i][3];
				b[i][3] = 0;
			}

		}
		return b;

	}

	public int[][] moveRight() {

		for (int i = 0; i < 4; i++) {

			if (b[i][2] == 0 && b[i][3] == 0 && b[i][1] == 0) {
				b[i][3] = b[i][0];
				b[i][0] = 0;
			} else if (b[i][3] == 0 && b[i][2] == 0) {
				b[i][3] = b[i][1];
				b[i][1] = 0;
			} else if (b[i][3] == 0) {
				b[i][3] = b[i][2];
				b[i][2] = 0;
			}
			if (b[i][3] == b[i][2]) {
				b[i][3] *= 2;
				b[i][2] = 0;
			} else if (b[i][3] == b[i][1] && b[i][2] == 0) {
				b[i][3] *= 2;
				b[i][1] = 0;
			} else if (b[i][3] == b[i][0] && b[i][1] == 0 && b[i][2] == 0) {
				b[i][3] *= 2;
				b[i][0] = 0;
			}
			if (b[i][2] == 0 && b[i][1] == 0) {
				b[i][2] = b[i][0];
				b[i][0] = 0;
			} else if (b[i][2] == 0) {
				b[i][2] = b[i][1];
				b[i][1] = 0;
			}
			if (b[i][1] == b[i][2]) {
				b[i][2] *= 2;
				b[i][1] = 0;
			} else if (b[i][2] == b[i][0] && b[i][1] == 0) {
				b[i][2] *= 2;
				b[i][0] = 0;
			}
			if (b[i][1] == b[i][0]) {
				b[i][1] *= 2;
				b[i][0] = 0;
			} else if (b[i][1] == 0) {
				b[i][1] = b[i][0];
				b[i][0] = 0;
			}

		}
		return b;

	}

	public int[][] moveDown() {

		for (int i = 0; i < 4; i++) {

			if (b[1][i] == 0 && b[2][i] == 0 && b[3][i] == 0) {
				b[3][i] = b[0][i];
				b[0][i] = 0;
			} else if (b[3][i] == 0 && b[2][i] == 0) {
				b[3][i] = b[1][i];
				b[1][i] = 0;
			} else if (b[3][i] == 0) {
				b[3][i] = b[2][i];
				b[2][i] = 0;
			}
			if (b[3][i] == b[2][i]) {
				b[3][i] *= 2;
				b[2][i] = 0;
			} else if (b[1][i] == b[3][i] && b[2][i] == 0) {
				b[3][i] *= 2;
				b[1][i] = 0;
			} else if (b[0][i] == b[3][i] && b[1][i] == 0 && b[2][i] == 0) {
				b[3][i] *= 2;
				b[0][i] = 0;
			}
			if (b[1][i] == 0 && b[2][i] == 0) {
				b[2][i] = b[0][i];
				b[0][i] = 0;
			} else if (b[2][i] == 0) {
				b[2][i] = b[1][i];
				b[1][i] = 0;
			}
			if (b[1][i] == b[2][i]) {
				b[2][i] *= 2;
				b[1][i] = 0;
			} else if (b[0][i] == b[2][i] && b[1][i] == 0) {
				b[2][i] *= 2;
				b[0][i] = 0;
			}
			if (b[0][i] == b[1][i]) {
				b[1][i] *= 2;
				b[0][i] = 0;
			} else if (b[1][i] == 0) {
				b[1][i] = b[0][i];
				b[0][i] = 0;
			}

		}
		return b;

	}

	public int[][] moveUp() {

		for (int i = 0; i < 4; i++) {

			if (b[2][i] == 0 && b[1][i] == 0 && b[0][i] == 0) {
				b[0][i] = b[3][i];
				b[3][i] = 0;
			} else if (b[0][i] == 0 && b[1][i] == 0) {
				b[0][i] = b[2][i];
				b[2][i] = 0;
			} else if (b[0][i] == 0) {
				b[0][i] = b[1][i];
				b[1][i] = 0;
			}
			if (b[0][i] == b[1][i]) {
				b[0][i] *= 2;
				b[1][i] = 0;
			} else if (b[2][i] == b[0][i] && b[1][i] == 0) {
				b[0][i] *= 2;
				b[2][i] = 0;
			} else if (b[3][i] == b[0][i] && b[2][i] == 0 && b[1][i] == 0) {
				b[0][i] *= 2;
				b[3][i] = 0;
			}
			if (b[2][i] == 0 && b[1][i] == 0) {
				b[1][i] = b[3][i];
				b[3][i] = 0;
			} else if (b[1][i] == 0) {
				b[1][i] = b[2][i];
				b[2][i] = 0;
			}
			if (b[2][i] == b[1][i]) {
				b[1][i] *= 2;
				b[2][i] = 0;
			} else if (b[3][i] == b[1][i] && b[2][i] == 0) {
				b[1][i] *= 2;
				b[3][i] = 0;
			}
			if (b[3][i] == b[2][i]) {
				b[2][i] *= 2;
				b[3][i] = 0;
			} else if (b[2][i] == 0) {
				b[2][i] = b[3][i];
				b[3][i] = 0;
			}

		}
		return b;

	}

}
