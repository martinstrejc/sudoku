/**
 * 
 */
package cz.wicketstuff.sudoku.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Martin Strejc
 *
 */
public class Cell
{

	private final Integer value;
	
	private final boolean initial;
	
	private final List<Integer> options;

	public Cell()
	{
		this(null, false, new LinkedList<>());
	}

	public Cell(int value)
	{
		this(value, true, null);
	}

	public Cell(Integer value, boolean initial, List<Integer> options)
	{
		this.value = value;
		this.initial = initial;
		this.options = options;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public boolean isInitial()
	{
		return initial;
	}
	
	public boolean isCalculated()
	{
		return !initial && hasValue();
	}
	
	public boolean hasValue() {
		return value != null;
	}
	
	public List<Integer> getOptions()
	{
		return options;
	}

}
