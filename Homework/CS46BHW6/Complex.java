package func;

public class Complex 
{
	private double			real;
	private double			imaginary;
	
	
	// Constructs an instance, given its real and imaginary components.
	public Complex(double real, double imaginary)
	{
		this.real = real;
		this.imaginary = imaginary;
	}
	
	
	// Constructs an instance that duplicates source.
	public Complex(Complex source)
	{
		this.real = source.real;
		this.imaginary = source.imaginary;
	}
	
	
	// Getter method.
	public double getReal()
	{
		return this.real;
	}
	

	// Getter method.
	public double getImaginary()
	{
		return this.imaginary;
	}
	
	
	//
	// Constructs and returns a new instance of Complex that represents the sum of its inputs,
	// according to the following formula:
	//
	// (a+bi) plus (c+di) = (a+c) + (b+d)i
	// 	
	// 
	public static Complex add(Complex c1, Complex c2)
	{
		double realNumber = c1.getReal() + c2.getReal();
		double imaginaryNum = c1.getImaginary() + c2.getImaginary();
		Complex addThis = new Complex(realNumber, imaginaryNum);
		return addThis;
	}
	
	
	//
	// Constructs and returns a new instance of Complex that represents the product of its inputs,
	// according to the following formula:
	//
	// (a+bi) times (c+di) = a*c + a*di + bi*c + bi*di = ac + (ad+bc)i + bd*ii
	// Since ii is -1 by definition, the last term is -bd ==> the result is ac-bd + (ad+bc)i
	//
	//
	public static Complex multiply(Complex c1, Complex c2)
	{
		double realNumber = c1.getReal() * c2.getReal();
		double realNumber2 = c1.getImaginary() * c2.getImaginary();
		double imaginaryNum = c1.getReal() * c2.getImaginary();
		double imaginaryNum2 = c1.getImaginary() * c2.getReal();
		Complex multiplyThis = new Complex(realNumber - realNumber2, imaginaryNum + imaginaryNum2);
		return multiplyThis;
	}
	
	
	//
	// The "norm" of complex number a+bi is the square root of (a^2 + b^2).
	//
	public double norm()
	{
		return Math.sqrt(Math.pow(getReal(), 2) + Math.pow(getImaginary(), 2));
	}
}
