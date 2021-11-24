import java.util.Arrays;

public class MazeTester {
    public static void main (String[] args) {

	// 2 x 2 solvable

	/*
		boolean[][] vWalls = {{true},
			      {false}};

		boolean[][] hWalls = {{false, false}};

		Maze maze = new Maze (2, 2, 0, 0, 0, 1, vWalls, hWalls);

	 */


	// 2 x 2 not solvable

	// boolean[][] vWalls = {{true},
	// 		      {true}};
	
	// boolean[][] hWalls = {{false, false}};

	// Maze maze = new Maze (2, 2, 0, 0, 0, 1, vWalls, hWalls);
	
	
	// 3 x 3 snake
	/*
		boolean[][] vWalls = {{true, false},
			      {true, true},
	 		      {false, true}};
	
	 boolean[][] hWalls = {{false, false, false},
	 		      {false, false, false}};

	 Maze maze = new Maze (3, 3, 0, 0, 2, 2, vWalls, hWalls);

	*/
	// no walls

	// boolean[][] vWalls = {{false, false},
	// 		      {false, false},
	// 		      {false, false}};
	
	// boolean[][] hWalls = {{false, false, false},
	// 		      {false, false, false}};

	// Maze maze = new Maze (3, 3, 0, 0, 1, 0, vWalls, hWalls);


	// 4 x 4 example

	// boolean[][] vWalls = {{true, false, false},
	// 		      {false, true, true},
	// 		      {true, true, true},
	// 		      {false, false, false}};
	
	// boolean[][] hWalls = {{false, true, false, false},
	// 		      {true, false, false, false},
	// 		      {false, false, true, false}};

	// Maze maze = new Maze (4, 4, 0, 0, 0, 1, vWalls, hWalls);

	// 5 x 5 example

		boolean[][] vWalls = {{true, false, true, false},
	 		      {false, true, false, false},
	 		      {true, true, true, false},
	 		      {false, false, true, true}, {false, true, false, true}};

	 	boolean[][] hWalls = {{false, false, true, false, true},
	 		      {true, false, true, true, false},
	 		      {true, false, false, false, false}, {false, true, false, false, false}};

	 	Maze maze = new Maze (5, 5, 0, 0, 4, 4, vWalls, hWalls);






		System.out.println(maze.toString());
	System.out.println("To solve this maze starting from cell " + Arrays.toString(maze.startLocation) + " and ending at goal cell " + Arrays.toString(maze.goalLocation));
	System.out.println("Use the path: " + maze.getSolution());
    }
}
