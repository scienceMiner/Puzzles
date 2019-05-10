package uk.co.collopy.escapepuzzle;


public class Position { 
	private int _x; 
	private int _y; 

	public Position(int x, int y)
	{
		setX(x) ; 
		setY(y) ; 
	}

	public int getX() {
		return _x;
	}

	public void  setX(int _x) { 
		this._x = _x;
	}

	public int getY() {
		return _y;
	}

	public void  setY(int _y) { 
		this._y = _y;
	}


	public void move(Direction dir) { 
		if (dir. equals(Direction.EAST)) 
			_y = _y + 1;
		if (dir. equals(Direction.WEST)) 
			_y = _y - 1;
		if (dir. equals(Direction.NORTH)) 
			_x = _x - 1; 
		if (dir. equals(Direction.SOUTH)) 
			_x = _x + 1;

	}

	public void display() { 
		System.out.println(" X: " + _x + " Y: " + _y );
	}


}
