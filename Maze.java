import java.util.ArrayList;

public class Maze {
    private Cell[][] cells;

    // vertWalls[row][col] true if wall separating cell[i][j] from cell[i][j+1] 
    private boolean[][] vertWalls;

    // horWalls[row][col] true if wall separating cell[i][j] from cell[i+1][j]
    private boolean[][] horWalls;
    
    private Cell start;
    private Cell goal;
    public int[] startLocation = new int[2];
	public int[] goalLocation = new int[2];

    // constructor for Maze
    //   - source is in row sRow and column sCol
    //   - goal is in row gRow and column gCol
    public Maze (int width, int height, int sRow, int sCol, int gRow, int gCol, boolean[][] vertWalls, boolean[][] horWalls) {
	startLocation[0] = sRow;
	startLocation[1] = sCol;
	goalLocation[0] = gRow;
	goalLocation[1] = gCol;

	this.vertWalls = vertWalls;
	this.horWalls = horWalls;
	
	cells = new Cell[height][width];
	
	for (int i = 0; i < height; i++) {
	    for (int j = 0; j < width; j++) {
		cells[i][j] = new Cell(this, i, j, (i == gRow && j == gCol));
	    }

	}

	setNeighbors();

	start = cells[sRow][sCol];
	goal = cells[gRow][gCol];
    }

    // assign neighbors to Cells in cells according to grid and walls
    private void setNeighbors () {
	for (int i = 0; i < cells.length; i++) {
	    for (int j = 0; j < cells[i].length; j++) {

		//System.out.println("Adding neighbors for cell (" + i + ", " + j + ")");

		// add north neighbor, if any
		if (i > 0 && !horWalls[i-1][j])
		    cells[i][j].addNeighbor(cells[i-1][j]);

		// add east neighbor, if any
		if (j < cells[i].length - 1 && !vertWalls[i][j])
		    cells[i][j].addNeighbor(cells[i][j+1]);

		// add south neighbor, if any
		if (i < cells.length - 1 && !horWalls[i][j])
		    cells[i][j].addNeighbor(cells[i+1][j]);

		// add west neighbor, if any
		if (j > 0 && !vertWalls[i][j-1]) {
		    cells[i][j].addNeighbor(cells[i][j-1]);
		}			
	    }
	}
    }

    // return a string that either prints path from start to goal, or
    // a message indicating that no such solution exists
    public String getSolution () {
	Stack<Cell> active = new Stack<Cell>();
	active.push(start);

	ArrayList<Cell> visited = new ArrayList<Cell>();
	
	if (solve(active, visited)) {
	    StringBuilder str = new StringBuilder();
	    
	    while (!active.isEmpty()) {
		str.insert(0, active.pop().toString() + ", ");
	    }

	    return str.toString();
	}

	return "Maze not solvable.";
    }

    // solve 
    private boolean solve (Stack<Cell> active, ArrayList<Cell> visited) {
	// first check if current (i.e., top of active) is goal
	// if so, return true
	if (active.peek().isGoal())
	    return true;

	// the "current" Cell cur is the top Cell in active
	Cell cur = active.peek();
	ArrayList<Cell> neighbors = cur.getNeighbors();

	// check if maze can be solved from any of cur's neighbors
	for (Cell cell : neighbors) {
	    if (!visited.contains(cell)) {
		visited.add(cell);
		active.push(cell);

		// if we reached goal from cell, return true!
		// in this case, active contains all cells along path from start to goal
		if (solve(active, visited))
		    return true;
	    }
	}

	// if no solution found from cur, pop cur off stack and return false
	active.pop();
	return false;
    }

    // return a string representation of the maze
    public String toString () {
	StringBuilder str = new StringBuilder();

	// draw top edge
	for (int j = 0; j < horWalls[0].length; j++) {
	    str.append("+-");
	}
	str.append("+\n");

	for (int i = 0; i < vertWalls.length; i++) {

	    // draw vertical walls
	    str.append("|");
	    for (int j = 0; j < vertWalls[i].length; j++) {
		str.append(" ");
		if (vertWalls[i][j])
		    str.append("|");
		else
		    str.append(" ");
	    }
	    str.append(" |\n");

	    // draw horizontal walls
	    if (i < horWalls.length) {
		str.append("+");
		for (int j = 0; j < horWalls[i].length; j++) {
		    if (horWalls[i][j])
			str.append("-");
		    else
			str.append(" ");

		    str.append("+");
		}
		str.append("\n");
	    }

	}

	// draw bottom edge
	for (int j = 0; j < horWalls[0].length; j++) {
	    str.append("+-");
	}
	str.append("+\n");

	return str.toString();
    }

			
    
}


// a class representing a cell in a maze
class Cell {
    private Maze mz;
    private ArrayList<Cell> neighbors = new ArrayList<Cell>();
    private int row;
    private int col;
    private boolean isGoal;

    public Cell (Maze mz, int row, int col, boolean isGoal) {
	this.mz = mz;
	this.row = row;
	this.col = col;
	this.isGoal = isGoal;
    }

    public void addNeighbor (Cell c) {
	neighbors.add(c);
    }

    public ArrayList<Cell> getNeighbors () {
	return neighbors;
    }

    public String toString() {
	return "(" + row + ", " + col + ")";
    }

    public boolean isGoal () {
	return isGoal;
    }
}
