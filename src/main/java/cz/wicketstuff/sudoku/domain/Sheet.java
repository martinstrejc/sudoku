/**
 * 
 */
package cz.wicketstuff.sudoku.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Martin Strejc
 *
 */
public class Sheet
{

	private final Cell[][] array;
	
	public Sheet(Cell[][] array)
	{
		this.array = array;
	}
	
	public List<Cell> getRow(int index)
	{
		return Arrays.asList(array[index]);
	}

	public List<Cell> getCol(int index)
	{
		List<Cell> list = new ArrayList<>(9);
		for (Cell[] c : array) {
			list.add(c[index]);
		}
		return list;
	}

	public List<Cell> getSquare(int rowIndex, int colIndex)
	{
		List<Cell> list = new ArrayList<>(9);
		for (int r = 0; r < 3; r++) 
		{
			for (int c =0; c<3; c++)
			{
				list.add(array[rowIndex + r][colIndex + c]);				
			}
		}
		return list;
	}
	
	public boolean validate()
	{
		return
			validateRows()
			&& validateCols()
			&& validateSquares();
	}
	
	public boolean validateRows() 
	{
		for (int i = 0; i<9; i++)
		{
			if (!validateRow(i)) 
			{
				return false;
			}
		}
		return true;
	}

	public boolean validateCols() 
	{
		for (int i = 0; i<9; i++)
		{
			if (!validateCol(i)) 
			{
				return false;
			}
		}
		return true;
	}

	public boolean validateSquares() 
	{
		for (int r = 0; r < 3; r++)
		{
			for (int c = 0; c < 3; c++)
			{
				if (!validateSquare(3 * r, 3 * c))
				{
					return false;
				}
			}
		}
		return true;
	}

	public boolean validateSquare(int rowIndex, int colIndex) {
		return validate9(getSquare(rowIndex, colIndex));
	}
	
	public boolean validateRow(int index) 
	{
		return validate9(getCol(index));
	}

	public boolean validateCol(int index) 
	{
		return validate9(getCol(index));
	}

	public boolean validate9(List<Cell> row) {
		int size = row.size();
		if(size < 1 || size > 9)
		{
			throw new IllegalArgumentException("The row size has to be between 1 and 9, the current size is " + size);
		}
		Set<Integer> set9 = newSet9();
		for (Cell c : row) {
			if (!c.hasValue()) {
				return false;
			}
			set9.remove(c.getValue());
		}
		return set9.isEmpty();
	}
	
	private static Set<Integer> newSet9() {
		Set<Integer> set = new HashSet<>(16);
		for (int i = 1; i < 10; i++) 
		{
			set.add(i);
		}
		return set;
	}
		
}
