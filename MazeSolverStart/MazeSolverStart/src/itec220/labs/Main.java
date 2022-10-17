package itec220.labs;
public class Main {

	// since we load as a resource source folder name not included 
	private static final String RESOURCE_INPUT_PATH = "/files/input/";
	private static final String RESOURCE_OUTPUT_PATH = "/files/output/";
	public static void main(String[] args) {
		
	
		for(int i = 1; i < 5; i++) {
			MazeSolver solver = new MazeSolver();
			String file = String.format("Maze%d.txt", i);
			
			// Eventually try to solve all 4 mazes 
			solver.loadMazeResource(RESOURCE_INPUT_PATH + file);
			
			System.out.format("Maze %d to be solved\n", i);
			// Step 1 Just print the maze ....
			solver.printMaze();
			
			
			//print out maze as you go
			//solver.solve(true);
			
			//do not print out maze as you go
			boolean solved = solver.solve(false);

			// after you have called solve this will have the complete maze
			if(solved) System.out.format("Maze %d solved\n", i);
			solver.printFinalMaze();
			System.out.println("\n");
		}
	}

}
