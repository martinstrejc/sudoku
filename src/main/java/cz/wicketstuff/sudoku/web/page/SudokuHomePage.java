/**
 * 
 */
package cz.wicketstuff.sudoku.web.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.DataGridView;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;

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
		List<ICellPopulator<ArrayList<Integer>>> columns = new ArrayList<>(9);
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
		queue(new DataGridView<ArrayList<Integer>>("rows", columns, new ListDataProvider<ArrayList<Integer>>(generateData())));
	}
	
	public static class Populator implements ICellPopulator<ArrayList<Integer>> {

		private static final long serialVersionUID = 1L;
		
		@Override
		public void detach()
		{
			// nothing to detach
		}

		@Override
		public void populateItem(Item<ICellPopulator<ArrayList<Integer>>> cellItem,
			String componentId, IModel<ArrayList<Integer>> rowModel)
		{
			cellItem.add(new Label(componentId, () -> rowModel.getObject().get(cellItem.getIndex())));
		}
		
	}
	
	public static List<ArrayList<Integer>> generateData() {
		
		final ArrayList<Integer> rowVector = new ArrayList<>(9);
		rowVector.add(1);
		rowVector.add(2);
		rowVector.add(3);
		rowVector.add(4);
		rowVector.add(5);
		rowVector.add(6);
		rowVector.add(7);
		rowVector.add(8);
		rowVector.add(9);
		
		final List<ArrayList<Integer>> rows = new ArrayList<>(9);
		rows.add(rowVector);
		rows.add(rowVector);
		rows.add(rowVector);

		rows.add(rowVector);
		rows.add(rowVector);
		rows.add(rowVector);

		rows.add(rowVector);
		rows.add(rowVector);
		rows.add(rowVector);

		return rows;
	}


}
