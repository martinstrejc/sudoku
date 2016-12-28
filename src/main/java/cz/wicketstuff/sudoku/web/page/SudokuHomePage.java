/**
 * 
 */
package cz.wicketstuff.sudoku.web.page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.DataGridView;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;

import cz.wicketstuff.sudoku.domain.Cell;

/**
 * @author Martin Strejc
 *
 */
public class SudokuHomePage extends WebPage
{

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public SudokuHomePage()
	{
		List<ICellPopulator<ArrayList<Cell>>> columns = new ArrayList<>(9);
		columns.add(new Populator());
		columns.add(new Populator());
		columns.add(new Populator());

		columns.add(new Populator());
		columns.add(new Populator());
		columns.add(new Populator());

		columns.add(new Populator());
		columns.add(new Populator());
		columns.add(new Populator());

		queue(new WebMarkupContainer("table"));
		queue(new DataGridView<ArrayList<Cell>>("rows", columns,
			new ListDataProvider<ArrayList<Cell>>(generateData2b())));
	}

	public static class Populator implements ICellPopulator<ArrayList<Cell>>
	{

		private static final long serialVersionUID = 1L;

		@Override
		public void detach()
		{
			// nothing to detach
		}

		@Override
		public void populateItem(Item<ICellPopulator<ArrayList<Cell>>> cellItem,
			String componentId, IModel<ArrayList<Cell>> rowModel)
		{
			Cell cell = rowModel.getObject().get(cellItem.getIndex());
			cellItem.add(new AttributeModifier("class",
				() -> cell.isInitial() ? "initial" : (cell.isCalculated() ? "calculated" : "")));
			cellItem
				.add(new Label(componentId, () -> cell.hasValue() ? cell.getValue() : "..." ));
		}

	}

	public static List<ArrayList<Cell>> generateData2b() 
	{
		Cell[][] array = generateData2();
		
		List<ArrayList<Cell>> list = new ArrayList<>(9);
		for(Cell[] row : array) 
		{
			list.add(new ArrayList<>(Arrays.asList(row)));
		}
		return list;
	}

	public static Cell[][] generateData2()
	{

		Cell[][] array = new Cell[9][9];
		Cell[] row = new Cell[9];
		row[0] = new Cell(1);
		row[1] = new Cell(2, false, null);
		row[2] = new Cell(3, false, null);
		row[3] = new Cell(4);
		row[4] = new Cell();
		row[5] = new Cell(6);
		row[6] = new Cell(7, false, null);
		row[7] = new Cell(8);
		row[8] = new Cell(9);
		
		for (int i = 0; i < array.length; i++) {
			array[i] = row;
		}
		return array;
		
	}

}
