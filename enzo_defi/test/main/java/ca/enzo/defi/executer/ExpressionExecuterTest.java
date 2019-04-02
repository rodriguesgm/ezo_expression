package ca.enzo.defi.executer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExpressionExecuterTest {

	@Test
	void tests_git_exemples() {
		String expression = "1+1";
		double result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result, 2.0);

		expression = "1 + 2";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result, 3.0);

//		expression = "1 + -1";
//		result = new ExpressionExecuter(expression).execute();
//		Assertions.assertEquals(result, 0.0);
//
//		expression = "-1 - -1";
//		result = new ExpressionExecuter(expression).execute();
//		Assertions.assertEquals(result, 0.0);

		expression = "5-4";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result, 1.0);

		expression = "5*2";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result, 10.0);

//		expression = "(2+5)*3";
//		result = new ExpressionExecuter(expression).execute();
//		Assertions.assertEquals(result, 21.0);

//		expression = "10/2";
//		result = new ExpressionExecuter(expression).execute();
//		Assertions.assertEquals(result, 5.0);

		expression = "2+2*5+5";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result, 17.0);

//		expression = "2.8*3-1";
//		result = new ExpressionExecuter(expression).execute();
//		Assertions.assertEquals(result, 7.4);

		expression = "2^8";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result, 256.0);

		expression = "2^8*5-1";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result, 1279.0);

//		expression = "sqrt(4)";
//		result = new ExpressionExecuter(expression).execute();
//		Assertions.assertEquals(result, 2.0);

//		expression = "1/0";
//		result = new ExpressionExecuter(expression).execute();
//		Assertions.assertEquals(result, 0.0);
	}

	@Test
	void tests_custom_exemples() {
		String expression = "3 + 2 /4* 3+ 2*2  - 1 *4+3/2";
		double result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result, 6.0);
		
		expression = "5*2^8-1";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result, 1279.0);
		
		expression = "2*2^8*5-1";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result, 2559.0);
		
	}
}
