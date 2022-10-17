package itec220.labs;

import java.util.Objects;

public class MazePosition {
	// Note MazePostion can only work with one Maze at a time
	// Why?
	public static int maxRow;
	public static int maxCol;
	private int row;
	private int col;
	
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}	
	public MazePosition(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	public boolean validMove(Direction d, char maze[][])
	{
		int r = this.row + d.deltaRow;		
		int c = this.col + d.deltaColumn;
		///Invalid row
		if (r >= maxRow || r < 0) return false;
		// Invalid column
		if (c >= maxCol || c < 0) return false;
		
		//invalid position
		if(maze[r][c] != ' ') return false;
		
		// if Open Space move would work
		return maze[r][c] == ' ';	
	}
	public MazePosition moveToNewPostion(Direction d)
	{
		return new MazePosition(this.row + d.deltaRow, this.col + d.deltaColumn);
	}	
	public boolean inBounds()
	{
		return (row < maxRow && col < maxCol && row >= 0 && col >= 0);
	}	
	@Override
	public int hashCode() {
		return Objects.hash(col, row);
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MazePosition other = (MazePosition) obj;
		return col == other.col && row == other.row;
	}
} 

