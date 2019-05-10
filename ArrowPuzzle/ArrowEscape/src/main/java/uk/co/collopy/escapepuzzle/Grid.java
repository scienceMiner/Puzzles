package uk.co.collopy.escapepuzzle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


// TODO : CHANGE OUTPUT TO LOGGING
// TODO : Add a telemetry solution for this


public class Grid<E> {

	public static void main(String[] args) {
		int row = 10;
		int col = 10;
		
		Grid<ArrowCell> grid = new Grid<ArrowCell>(ArrowCell.class,row,col);
		
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col ; j++)
			{
				grid.set(i, j, ArrowCell.create());
			}
		
		grid.set(1, 1, ArrowCell.create(true));
		grid.display();
		grid.escape(1, 1);
		
	}


	private E[][] _a; 
	private List<ArrayList<E>> _list;
	boolean _isList; 
	private int _row; 
	private int _col; 


	public Grid(Class<E> c, int s, int l, boolean isList, E dummy )
	{
		if (isList) 
		{
			_list = new ArrayList<ArrayList<E>>();

			for (int i = 0 ; i < s ; i++ )
			{
				ArrayList<E> arrList = new ArrayList<E>();
				for (int j = 0 ; j < l ; j++ )
				{
					arrList.add(dummy);

				}

				_list.add(arrList);
			}
		}
		else
		{
			new Grid<E>(c,s,l);
		}
	}


	public Grid(Class<E> c, int s, int l )
	{
		// 	Use reflect Array native method to create array
		// of a type only known at run time
		@SuppressWarnings("unchecked")
		final E[][] a = (E[][]) Array.newInstance(c,s,l);
		this._a = a;
		_row = s;
		_col = l;
	}

	E get(int i, int j) {
		return _a[i][j];
	}

	void set(int i, int j, E e) {
		_a[i][j] = e;
	}
	
	
	void escape(int x, int y) {
		
		Position p1 = new Position(x,y);
		
		while ( inGrid(x,y)) {
			
			ArrowCell crnt = (ArrowCell) this.get(x,y);
			Direction dir = crnt.getDirection();
			crnt.setlnside(false);
			
			p1.move(dir);
			
			if (!inGrid(p1.getX(),p1.getY()))
			{
				System.out.println(" MOVED ..... ");
				p1.display();
				break;
			}
			else
			{
				System.out.println( "INSIDE GRID ");
				p1.display();
			}
			
			
			Direction newDir = Direction.rotate(crnt.getDirection());
			crnt.setDirection(newDir);
			
			x = p1.getX();
			y = p1.getY();
			
			ArrowCell newCrnt = (ArrowCell) this.get(x, y);
			newCrnt.setlnside(true);
			
			System.out.println("\n\n");
			p1.display();
			display();
			
			
			
		}
		
		System.out.println(" ESCAPED ");
		
	}
	
	
	public void display() {
		for (int i = 0 ; i < _row ; i++ )
		{
			for (int j = 0; j < _col; j++ )
			{
				ArrowCell c1 = (ArrowCell) this.get(i,j);
				c1.display();
			}
			System.out.println();
		}
	}
	
	public boolean inGrid(int x, int y) {
		return (( x >= 0 && x <= _row ) && ( y >= 0 && y <= _col ));
	}
	
}