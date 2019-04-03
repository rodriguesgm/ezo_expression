package ca.enzo.defi.executer;

import java.math.BigDecimal;

import ca.enzo.defi.parser.EmptyOperatorExpression;
import ca.enzo.defi.parser.ExpressionBuilder;
import ca.enzo.defi.parser.ExpressionElement;
import ca.enzo.defi.parser.ExpressionExtractor;
import ca.enzo.defi.parser.SimpleOperatorExpression;
import ca.enzo.defi.parser.ValueExpression;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExpressionExecuter {
	
	private final String expression;
	
	public BigDecimal execute() {
		int expressionLength = this.expression.length();
		int index = 0;

		ExpressionExtractor extractor = new ExpressionExtractor(this.expression);
		ExpressionBuilder builder = new ExpressionBuilder();
		while (index < expressionLength) {
			char expressionChar = this.expression.charAt(index);
			ExpressionElement element = factory(expressionChar);

			extractor.setCurrentIndex(index);
			element.accept(extractor);

			element.accept(builder);
			index = extractor.getCurrentIndex() + 1;
		}

		return builder.getExpression().resolve();
	}
	
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
		case '.':
			return new ValueExpression();
		default:
			throw new RuntimeException("Operator is '" + expChar + "' not recognized");
		}
	}

}
