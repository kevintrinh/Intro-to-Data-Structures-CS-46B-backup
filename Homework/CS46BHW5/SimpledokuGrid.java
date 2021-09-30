package simpledoku;

import java.util.*;
import java.util.ArrayList;

public class SimpledokuGrid 
{
	private int				nCellsPerSide;
	private int[][]			values;
	
	
	public SimpledokuGrid(int nCellsPerSide)
	{
		this.nCellsPerSide = nCellsPerSide;
		values = new int[nCellsPerSide][nCellsPerSide];
	}
	
	
	// This is called a "copy constructor". A copy ctor has 1 arg, which is the same type as
	// the current class. The ctor should make the new instance look just like the "source"
	// instance. CAUTION: The source and the current grid should each have their own "values"
	// array. So don't say "this.values = source.values". You have to create a new values
	// array, and copy numbers from source.values into the new array, one at a time.
	public SimpledokuGrid(SimpledokuGrid source)
	{	
		// COMPLETE THIS
		this.nCellsPerSide = source.nCellsPerSide;
		this.values = new int[source.nCellsPerSide][source.nCellsPerSide];
		for(int row = 0; row < nCellsPerSide; row++)
			for(int column = 0; column < nCellsPerSide; column++) {
				this.values[row][column] = source.values[row][column];
			}
	}	
	
	
	//
	// Returns true if the input list contains a repeated value that isn't zero.
	// Call this from isLegal(). DON’T CHANGE THIS METHOD, BUT UNDERSTAND HOW IT WORKS.
	//
	private boolean containsNonZeroRepeats(ArrayList<Integer> checkUs)
	{
		HashSet<Integer> set = new HashSet<>();
		for (Integer i: checkUs)
		{
			if (i != 0)
			{
				if (set.contains(i))
					return true;
				else
					set.add(i);
			}
		}
		return false;
	}
	
	
	public boolean isLegal()
	{
		// Check all rows. For each row, put the corresponding numbers from
		// the "values" array into an ArrayList<Integer>. Then pass the array
		// list to containsNonZeroRepeats(). If containsNonZeroRepeats() return true,
		// then this grid isn't legal, so return false.
		for(int row = 0; row < nCellsPerSide; row++) {
			ArrayList<Integer> checkUs = new ArrayList<Integer>();
			for(int column = 0; column < nCellsPerSide; column++)
				checkUs.add(values[row][column]);
			if(containsNonZeroRepeats(checkUs))
				return false;
		}
		
		// Check all columns. For each column, put the corresponding numbers from
		// the "values" array into an ArrayList<Integer>. Then pass the array
		// list to containsNonZeroRepeats(). If containsNonZeroRepeats() return true,
		// then this grid isn't legal, so return false.
		for(int column = 0; column < nCellsPerSide; column++) {
			ArrayList<Integer> checkUs1 = new ArrayList<Integer>();
			for(int row = 0; row < nCellsPerSide; row++)
				checkUs1.add(values[row][column]);
			if(containsNonZeroRepeats(checkUs1))
				return false;
		}

		// Check top-left to bottom-right diagonal. 
		ArrayList<Integer> checkUs2 = new ArrayList<Integer>();
		for(int i = 0; i < nCellsPerSide; i++)
			checkUs2.add(values[i][i]);
		if(containsNonZeroRepeats(checkUs2))
			return false;
		
		// Check top-right to bottom-left diagonal. 
		ArrayList<Integer> checkUs3 = new ArrayList<Integer>();
		for(int i = 0; i < nCellsPerSide; i++)
			checkUs3.add(values[i][nCellsPerSide - i - 1]);
		if(containsNonZeroRepeats(checkUs3))
			return false;
		
		// If we haven't returned yet, this grid must be legal.
		return true;
	}
	
	
	// Returns true if all members of the values[][] array are non-zero.
	public boolean isFull()
	{
		for(int row = 0; row < nCellsPerSide; row++)
			for(int column = 0; column < nCellsPerSide; column++)
				if(values[row][column] == 0)
					return false;
		return true;
	}	
	
	
	
	// Returns the Evaluation corresponding to the state of this grid. The return will be
	// Evaluation.ABANDON, Evaluation.ACCEPT, or Evaluation.CONTINUE. Abandon if illegal,
	// accept if legal and the grid is full, continue if legal and incomplete.
	public Evaluation evaluate()
	{
		if(isLegal() == false) 
			return Evaluation.ABANDON;
		else if (isLegal() == true && isFull() == true)
			return Evaluation.ACCEPT;
		else if (isLegal() == true && isFull() == false)
			return Evaluation.CONTINUE;
		else
			return null;
	}
	
	
	// Returns a size=2 array of ints that index the next empty cell in the values[][] array.
	// The 2 ints in the returned array are the first and second indices into the values[][] array.
	// Returns null if this grid is full.  DON’T CHANGE THIS METHOD, BUT UNDERSTAND HOW IT WORKS.
	private int[] getIndicesOfNextEmptyCell()
	{
		for (int x=0; x<nCellsPerSide; x++)
			for (int y=0; y<nCellsPerSide; y++)
				if (values[x][y] == 0)
					return new int[] {x, y};
		
		return null;
	}
	
	
	//
	// COMPLETE THIS
	//
	//
	// Finds an empty member of "values". Returns an array list containing nCellsPerSide grids that look 
	// like the current grid, except the empty member contains 1, 2, 3 .... nCellsPerSide. 
	// 
	//
	// Example: if this grid = 12300
	//                         00000
	//                         00000
	//                         00000
	//                         00000
	//
	// Then the returned array list contains:
	//
	//      12310        12320        12330        12340        12350
	//      00000        00000        00000        00000        00000
	//      00000        00000        00000        00000        00000
	//      00000        00000        00000        00000        00000
	//      00000        00000        00000        00000        00000
	//
	// To create each new grids, use the copy ctor and pass in "this" grid. Then
	// change one member of the "values" of the new grid.
	// CAUTION: 
	ArrayList<SimpledokuGrid> generateAllNextGrids()
	{		
		int[] indicesOfNext = getIndicesOfNextEmptyCell();
		ArrayList<SimpledokuGrid> nextGrids = new ArrayList<SimpledokuGrid>();
		// Generate some grids and put them in nextGrids. Be sure that every
		// grid is a separate object.
		for(int i = 1; i <= nCellsPerSide; i ++) {
			SimpledokuGrid theGrid = new SimpledokuGrid(this);
			theGrid.values[indicesOfNext[0]][indicesOfNext[1]] = i;
			nextGrids.add(theGrid);
		}
		
		return nextGrids;
	}
	
	
	// Use this for debugging if it's helpful.  DON’T CHANGE THIS METHOD, BUT UNDERSTAND HOW IT WORKS.
	public String toString()
	{
		String s = "";
		for (int j=0; j<nCellsPerSide; j++)
		{
			for (int i=0; i<nCellsPerSide; i++)
			{
				if (values[j][i] == 0)
					s += ".";
				else
					s += ("" + values[j][i]);
			}
			s += "\n";
		}
		return s;
	}
}
