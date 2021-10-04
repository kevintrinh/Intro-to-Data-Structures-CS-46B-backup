package func;

public class MyOwnFunction implements DoubleFunctionOfTwoInts{

	@Override
	public double fOfXY(int x, int y) {	
		if (Math.hypot(x, y) < 50)
			return 0;
		if (x < 0 && y < 0 || x > 0 && y > 0)
			return 1000 * Math.hypot(x, y);
		if (x > 0 && y < 0 || x < 0 && y > 0)
			return  + 10000 * Math.hypot(x, y);
		return 0;
	}

	@Override
	public String getName() {
		return "MyOwn";
	}

}
