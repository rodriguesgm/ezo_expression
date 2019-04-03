package ca.enzo.defi.executer;

import java.math.BigDecimal;

import ca.enzo.defi.parser.ExpressionBuilder;
import ca.enzo.defi.parser.ExpressionExtractor;
import ca.enzo.defi.parser.elements.ExpressionElement;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExpressionExecuter {
	
	private final String expression;
	
	public BigDecimal execute() {
		ExpressionExtractor extractor = new ExpressionExtractor(this.expression);
		ExpressionBuilder builder = new ExpressionBuilder();
		while (extractor.hasMore()) {
			ExpressionElement element = extractor.nextNode();

			element.accept(builder);
		}

		return builder.getExpression().resolve();
	}
}
