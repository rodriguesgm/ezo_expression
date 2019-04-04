package ca.ezo.defi.executer;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExpressionExecuterTest {

	@Test
	void tests_git_exemples() {
		String expression = "1+1";
		BigDecimal result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 2.0);

		expression = "1 + 2";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 3.0);

//		expression = "1 + -1";
//		result = new ExpressionExecuter(expression).execute();
//		Assertions.assertEquals(result, 0.0);

//		expression = "-1 - -1";
//		result = new ExpressionExecuter(expression).execute();
//		Assertions.assertEquals(result, 0.0);

		expression = "5-4";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 1.0);

		expression = "5*2";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 10.0);

		expression = "(2+5)*3";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 21.0);

		expression = "10/2";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 5.0);

		expression = "2+2*5+5";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 17.0);

		expression = "2.8*3-1";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 7.4);

		expression = "2^8";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 256.0);

		expression = "2^8*5-1";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 1279.0);

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
		BigDecimal result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 6.0);

		expression = "5*2^8-1";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 1279.0);

		expression = "2*2^8*5-1";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 2559.0);

		expression = "2.81*3-1";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 7.43);
		
		expression = "10324.234 + 234.234 * 234.1223 / 2";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 37743.9354091);
		
		expression = "2*2 * ( 3 + 1 ) ^ 3 / 2";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 128.0);

		expression = "3 ^ ( 3 + 1 )  / 2";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 40.5);
		
		expression = "2*2 + ( 3 * 1 ^3 ) - 3 / 2";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 5.5);

		expression = "(2*25.34 + ( (34.3) * 1 ^ ( 30 - 4.4) ) - 3 / 2)";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 83.48);
		
		expression = "3 + 2 * 3 ^ 3";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 57.0);
		
		expression = "3 ^ 2 * 3 + 3";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 30.0);

		expression = "3 + 2 ^ 3 * 3";
		result = new ExpressionExecuter(expression).execute();
		Assertions.assertEquals(result.doubleValue(), 27.0);
	}
}
