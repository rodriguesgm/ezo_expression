package ca.ezo.defi.parser;

import ca.ezo.defi.parser.elements.EmptyOperatorExpression;
import ca.ezo.defi.parser.elements.ExpressionElement;
import ca.ezo.defi.parser.elements.SimpleOperatorExpression;
import ca.ezo.defi.parser.elements.ValueExpression;
import lombok.experimental.UtilityClass;
import ca.ezo.defi.parser.elements.ParenthesesExpression;

@UtilityClass
public final class ExpressionElementFactory {

	public static ExpressionElement factory(char expChar) {
		switch (expChar) {
		case '(':
			return new ParenthesesExpression();
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
