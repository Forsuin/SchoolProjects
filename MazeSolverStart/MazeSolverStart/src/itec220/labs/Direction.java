package itec220.labs;

import java.util.HashMap;

public enum Direction {
	Down('2',0,1),Right('6',1,0),RightDown('3',1,1),
	LeftDown('1',-1,1), Left('4',-1,0),	LeftUp('7',-1,-1),
	Up('8',0,-1), RightUp('9',1,-1);
			
	private static final HashMap<Character, Direction> lookup = new HashMap<Character, Direction>();
    static {
        //System.out.println("Load HashMap");
        for (Direction value :  Direction.values()) {
        	lookup.put(value.mapCharacter , value);
        }
    }
	public final char mapCharacter;
	public final  int deltaColumn;
	public final  int deltaRow;
	
	private Direction(char mapChar, int deltaColumn,int deltaRow )
	{
		this.mapCharacter = mapChar;
		this.deltaRow = deltaRow;
		this.deltaColumn = deltaColumn;
	}
	public static Direction getEnumfromChar(char map)
	{		
		return lookup.get(map);
		
	}		
	
	
}

