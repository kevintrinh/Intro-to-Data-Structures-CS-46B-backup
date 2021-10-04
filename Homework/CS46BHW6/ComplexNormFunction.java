package func;

public class ComplexNormFunction implements DoubleFunctionOfTwoInts{

	@Override
	public double fOfXY(int x, int y) {
		return new Complex(x, y).norm();
	}

	@Override
	public String getName() {
		return "ComplexNorm";
	}

}