package ca.enzo.defi.parser;

import ca.enzo.defi.parser.elements.EmptyOperatorExpression;
import ca.enzo.defi.parser.elements.ExpressionElement;
import ca.enzo.defi.parser.elements.SimpleOperatorExpression;
import ca.enzo.defi.parser.elements.ValueExpression;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class ExpressionElementFactory {

	public static ExpressionElement factory(char expChar) {
		switch (expChar) {
		case ' ':
			return new EmptyOperatorExpression();
		case '+':
		case '*':
		case '-':
		case '/':
		case '^':
			return new SimpleOperatorExpression(expChar);
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
		case '0':
			return new ValueExpression();
		default:
			throw new RuntimeException("Operator is '" + expChar + "' not recognized");
		}
	}
}
