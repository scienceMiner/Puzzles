package uk.co.collopy.escapepuzzle;

import java.util.Random;

public class ArrowCell { 


	public int _value; 
	private Direction _direction; 
	public boolean _inside; 


	public ArrowCell(Direction text) 
	{
		this(text, 0, false) ; 
	}


	public ArrowCell(Direction text, int val)
	{
		this(text, val, false) ; 
	}

	public ArrowCell(Direction text, int val , boolean inside)
	{
		_direction = text; 
		_value = val; 
		_inside = inside; 
	}


	public static ArrowCell create(boolean inside) 
	{
		Random rand = new Random(); 
		// use value at all 
		int value = rand.nextInt(20); 
		ArrowCell c = new ArrowCell(Direction.randomDirection(),value, inside);

		return c;
	}


	public static ArrowCell create() 
	{
		return create(false); 
	} 

	public void display() 
	{
		if ( _inside) 
			System. out. print( _direction.name().substring(0,1) + "\t X " + " | " );
		else
			System. out. print( _direction.name().substring(0,1) + "\t O " + " | " );
	}

	public void setlnside(boolean flag) 
	{
		_inside = flag; 
	}
	public boolean getlnside() 
	{
		return _inside; 
	}
	public Direction getDirection() 
	{
		return _direction; 
	}
	public void setDirection(Direction dir) 
	{
		_direction = dir; 
	}
}