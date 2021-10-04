package func;

public class ComplexSquaredNormFunction implements DoubleFunctionOfTwoInts{

	@Override
	public double fOfXY(int x, int y) {
		return Math.pow(new Complex(x, y).norm(), 2);
	}

	@Override
	public String getName() {
		return "ComplexSquaredNorm";
	}
	
}
