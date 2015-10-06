package ua.nure.dashkevych;

public class Calculator {

	public Double doOperation(String operation, Double num1, Double num2) throws IllegalArgumentException {
		if (operation == null)
			throw new IllegalArgumentException("Invalid operation");
		Double result = null;
		if (operation.equals("+"))
			result = doAdd(num1, num2);
		if (operation.equals("-"))
			result = doDeduct(num1, num2);
		if (operation.equals("/"))
			result = doDivide(num1, num2);
		if (operation.equals("*"))
			result = doMul(num1, num2);
		return result;
	}

	private Double doAdd(Double num1, Double num2) {
		return num1 + num2;
	}

	private Double doDeduct(Double num1, Double num2) {
		return num1 - num2;
	}

	private Double doDivide(Double num1, Double num2) {
		if (num2 == 0)
			throw new IllegalArgumentException("Second operand cannot be zero");
		return num1 / num2;
	}

	private Double doMul(Double num1, Double num2) {
		return num1 * num2;
	}
}
