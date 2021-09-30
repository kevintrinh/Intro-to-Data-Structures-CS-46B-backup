package weather;

import java.util.ArrayList;

public class Sky2 extends ArrayList<Cloud>
{
	public Sky2 ()
	{
		super(100);
	}
	
	public float getMeanHeight()
	{
		float sum = 0;
		for(Cloud i: this)
		{
			sum += i.getHeight();
		}
		return sum / this.size();
	}
}
