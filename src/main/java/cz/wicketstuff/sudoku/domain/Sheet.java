/**
 * 
 */
package cz.wicketstuff.sudoku.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		
}
