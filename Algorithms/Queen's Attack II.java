public class Solution {

	public static void main(String[] args) throws IOException {

		FastReaderIO.FastReader fr = new FastReaderIO.FastReader();
		int boardSize = fr.nextInt();
		int obstacles = fr.nextInt();
		int row_Queen = fr.nextInt();
		int column_Queen = fr.nextInt();
		int obstacle[][] = new int[obstacles][2];
		int count = 0;
		// Row Column coordinates of the closes object in each direction
		int rRObstacle = -1;
		int cRObstacle = -1;
		int rBRObstacle = -1;
		int cBRObstacle = -1;
		int rBObstacle = -1;
		int cBObstacle = -1;
		int rBLObstacle = -1;
		int cBLObstacle = -1;
		int rLObstacle = -1;
		int cLObstacle = -1;
		int rTLObstacle = -1;
		int cTLObstacle = -1;
		int rTObstacle = -1;
		int cTObstacle = -1;
		int rTRObstacle = -1;
		int cTRObstacle = -1;

		// Total squares attacked by the queen
		int reachableSquares = 0;

		int diffQ = row_Queen - (column_Queen);
		int summQ = row_Queen + (column_Queen);
		while (obstacles-- > 0) {
			// Finds the closest object in each direction
			int rObstacle = fr.nextInt();
			int cObstacle = fr.nextInt();

			// Right
			if ((cObstacle < cRObstacle || rRObstacle == -1) && cObstacle > column_Queen && rObstacle == row_Queen) {
				rRObstacle = rObstacle;
				cRObstacle = cObstacle;
			}

			// Bottom Right
			if (row_Queen - rObstacle == cObstacle - column_Queen && cObstacle > column_Queen && rObstacle < row_Queen
					&& ((rObstacle > rBRObstacle && cObstacle < cBRObstacle) || rBRObstacle == -1)) {
				rBRObstacle = rObstacle;
				cBRObstacle = cObstacle;
			}

			// Bottom
			if ((rObstacle > rBObstacle || rBObstacle == -1) && rObstacle < row_Queen && cObstacle == column_Queen) {
				rBObstacle = rObstacle;
				cBObstacle = cObstacle;
			}

			// Bottom Left
			if (row_Queen - rObstacle == column_Queen - cObstacle && cObstacle < column_Queen && rObstacle < row_Queen
					&& ((rObstacle > rBLObstacle && cObstacle > cBLObstacle) || rBLObstacle == -1)) {
				rBLObstacle = rObstacle;
				cBLObstacle = cObstacle;
			}

			// Left
			if ((cObstacle > cLObstacle || rLObstacle == -1) && cObstacle < column_Queen && rObstacle == row_Queen) {
				rLObstacle = rObstacle;
				cLObstacle = cObstacle;
			}

			// Top Left
			if (column_Queen - cObstacle == rObstacle - row_Queen && cObstacle < column_Queen && rObstacle > row_Queen
					&& ((rObstacle < rTLObstacle && cObstacle > cTLObstacle) || rTLObstacle == -1)) {
				rTLObstacle = rObstacle;
				cTLObstacle = cObstacle;
			}

			// Top
			if ((rObstacle < rTObstacle || rTObstacle == -1) && rObstacle > row_Queen && cObstacle == column_Queen) {
				rTObstacle = rObstacle;
				cTObstacle = cObstacle;
			}

			// Top Right
			if (rObstacle - row_Queen == cObstacle - column_Queen && cObstacle > column_Queen && rObstacle > row_Queen
					&& ((rObstacle < rTRObstacle && cObstacle < cTRObstacle) || rTRObstacle == -1)) {
				rTRObstacle = rObstacle;
				cTRObstacle = cObstacle;
			}

		}

		// Calculates the distance to the closest obstacle in each direction and
		// adds it to reachableSquares
		// R B L T
		reachableSquares += (cRObstacle != -1) ? (cRObstacle - column_Queen - 1) : boardSize - column_Queen;
		reachableSquares += (rBObstacle != -1) ? (row_Queen - rBObstacle - 1) : row_Queen - 1;
		reachableSquares += (cLObstacle != -1) ? (column_Queen - cLObstacle - 1) : column_Queen - 1;
		reachableSquares += (rTObstacle != -1) ? (rTObstacle - row_Queen - 1) : boardSize - row_Queen;

		// BR BL TL TR
		reachableSquares += (cBRObstacle != -1) ? (cBRObstacle - column_Queen - 1)
				: Math.min(boardSize - column_Queen, row_Queen - 1);
		reachableSquares += (rBLObstacle != -1) ? (column_Queen - cBLObstacle - 1)
				: Math.min(column_Queen - 1, row_Queen - 1);
		reachableSquares += (cTLObstacle != -1) ? (column_Queen - cTLObstacle - 1)
				: Math.min(column_Queen - 1, boardSize - row_Queen);
		reachableSquares += (rTRObstacle != -1) ? (cTRObstacle - column_Queen - 1)
				: Math.min(boardSize - column_Queen, boardSize - row_Queen);
		System.out.println(reachableSquares);
	}
}
