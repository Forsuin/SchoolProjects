package itec220.labs;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.concurrent.TimeUnit;

public class MazeSolver {

	private char[][] printMaze;
	private char[][] solveMaze;
	private StackA<MazePosition> path = new StackA<>();
    private boolean solved = false;
	
	public MazeSolver() {
		super();

	}
	
	private boolean inDeadEnd(MazePosition position) {
		int numBadNeighbors = 0;
		
		if(!position.validMove(Direction.Up, solveMaze)) numBadNeighbors++;
		if(!position.validMove(Direction.Down, solveMaze)) numBadNeighbors++;
		if(!position.validMove(Direction.Left, solveMaze)) numBadNeighbors++;
		if(!position.validMove(Direction.Right, solveMaze)) numBadNeighbors++;
		
		return (numBadNeighbors == 4);
	}
	
	/**
	 * Solves the maze by updating the solveMaze array. Starts at S finishes a F
	 * 
	 * @param printUpdates if true it will print every update to the map to standard
	 *                     i/o. If it is false it will only print the final
	 *                     completed map.
	 * @return true if this map was solved. False if it cannot be solved.
	 */
	private boolean solveMaze(boolean printUpdates) {
		//Find start
		MazePosition start = null;
		
		for(int i = 0; i < solveMaze.length; i++) {
			if(solveMaze[i][0] == 'S') {
				start = new MazePosition(i, 0);
				break;
			}
		}
		
		StackA<MazePosition> stack = new StackA<MazePosition>();
		
		MazePosition current = new MazePosition(start.getRow(), start.getCol());
		stack.push(current);
		
		while(!solved) {			
			if(!inDeadEnd(current)) {
				Direction dir = null;
				
				//move to finish neighbor
				for(Direction d : Direction.values()) {
					MazePosition testPos = current.moveToNewPostion(d);
					if(!testPos.inBounds()) continue;
					
					if(solveMaze[current.getRow() + d.deltaRow][current.getCol() + d.deltaColumn] == 'F') {
						dir = d;
						solved = true;
						break;
					}
				}
				
				//skip if neighbor is finish
				if(dir == null) {
					//find next available opening
					for(Direction d : Direction.values()) {
						if(current.validMove(d, solveMaze)) {
							dir = d;
							break;
						}
					}
				}
				
				current = current.moveToNewPostion(dir);
				solveMaze[current.getRow()][current.getCol()] = '!';
				stack.push(current);
			}
			//In dead end
			else {
				while(inDeadEnd(current)) {
					solveMaze[current.getRow()][current.getCol()] = 'b';
					stack.pop();
					try {
						current = stack.peek();
					}
					catch(EmptyStackException e) {
						//unsolvable maze
						return false;
					}
				}
			}
			
			
			if(printUpdates) {
				try {
					TimeUnit.MILLISECONDS.sleep(0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				printMaze(solveMaze);
			}
		}
		
		//update printMaze
		for(int row = 0; row < solveMaze.length; row++) {
			for(int col = 0; col < solveMaze[row].length; col++) {
				if(solveMaze[row][col] != 'b' && solveMaze[row][col] != '!') {
					printMaze[row][col] = solveMaze[row][col];
				}
				else {
					printMaze[row][col] = ' ';
				}
			}
		}
		
		while(!stack.isEmpty()) {
			MazePosition pos = stack.pop();
			printMaze[pos.getRow()][pos.getCol()] = '#';
		}
		
		//solved maze
		return true;
	}

	/**
	 * Solves the maze by updating the solveMaze array. Starts at S finishes a F
	 * 
	 * @param printUpdates if true it will print every update to the map to standard
	 *                     i/o. If it is false it will only print the final
	 *                     completed map.
	 * @return true if this map was solved. False if it cannot be solved.
	 */
	public boolean solve(boolean printUpdates) {

		boolean isSolved = solveMaze(printUpdates);
		
		if(!isSolved) {
			System.out.println("\nMaze is unable to be solved");
		}
		
		return isSolved;
	}

	/**
	 * Solves the maze by updating the solveMaze array. Starts at S finishes a F
	 * 
	 * @return true if this map was solved.
	 */
	public boolean solve() {
		return solveMaze(false);
	}

	/**
	 * Prints the contents of maze array to to standard i/o. Should include the
	 * correct path through the maze.
	 */
	public void printFinalMaze() {
		for(char[] arr : printMaze) {
			for(char c : arr) {
				System.out.print(c);
			}
			System.out.print('\n');
		}
	}

	/**
	 * Prints the contents of maze array to to standard i/o.
	 */
	private void printMaze(char[][] maze) {
		for(char[] arr : maze) {
			for(char c : arr) {
				System.out.print(c);
			}
			System.out.print('\n');
		}
	}

	/**
	 * Prints the contents of solve maze array to to standard i/o. This is mostly to
	 * test that you can print the maze
	 */
	public void printMaze() {
		printMaze(solveMaze);
	}
	
	/**
	 * Reads the file indicated by filename and loads it into both printMaze and
	 * solveMaze printMaze is a clean copy of the maze to use at the end to print
	 * the solution solveMaz is the working copy of the maze which will be altered
	 * to navigate a path.
	 * 
	 * @param filename the name of the file to be read map to standard i/o. If it is
	 *                 false it will only print the final completed map.
	 * @return true if the file was read successfully.
	 */
	public boolean loadMazeResource(String filename) {
		// if you want to load different mazes you may need to reset some things

		ArrayList<String> lines = FileUtility.readFileResouurce(filename);
		if(lines.size() == 0)
		{
			System.out.println("Error No Maze Read!!!!");
			return false; 
		}
		
			// add a new character array of character arrays
			printMaze = new char[lines.size()][];
			solveMaze = new char[lines.size()][];
			int maxRows = lines.size();
			int maxCols = 0;
			for (int i = 0; i < lines.size(); i++) {
				// add a new character array to store the map characters
				printMaze[i] = new char[lines.get(i).length()];
				solveMaze[i] = new char[lines.get(i).length()];
				// maze is same width each row
				// so should be the same all the time...
				// but just in case
				maxCols = Math.max(maxCols, lines.get(i).length());
				for (int j = 0; j < lines.get(i).length(); j++) {
					// add the individual characters
					solveMaze[i][j] = lines.get(i).charAt(j);
					printMaze[i][j] = lines.get(i).charAt(j);

					//YOU May WANT TO DO SOMETHING HERE
					// hint you may want to check for something here
					// what two things do you need to have...
					
				}
			

			}
			// allows position to check if it is valid
			MazePosition.maxCol = maxCols;
			MazePosition.maxRow = maxRows;
		
		return true;
	}

	

}
