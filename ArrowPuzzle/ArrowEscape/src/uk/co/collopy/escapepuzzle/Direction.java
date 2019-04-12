package uk.co.collopy.escapepuzzle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Direction {
	NORTH, EAST, SOUTH, WEST; 

	// Cache the Directions 
	private static final List<Direction> VALUES = 
			Collections.unmodifiableList(Arrays.asList(values())); 

	private static final int SIZE = VALUES.size();

	// Random for Direction setting 

	private static final Random RANDOM = new Random(); 

	public static Direction randomDirection() { 
		return VALUES.get(RANDOM.nextInt(SIZE ));
	}

	public static Direction rotate(Direction currentDir) 
	{
		if (currentDir.equals(Direction.NORTH)) 
			currentDir = Direction. EAST; 
		else if (currentDir.equals(Direction.EAST)) 
			currentDir = Direction. SOUTH; 
		else if (currentDir.equals(Direction.SOUTH)) 
			currentDir = Direction .WEST; 
		else if (currentDir.equals(Direction.WEST)) 
			currentDir = Direction.NORTH; 
		return currentDir; 


	}

}
