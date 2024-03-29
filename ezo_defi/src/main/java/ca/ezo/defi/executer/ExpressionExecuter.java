package ca.ezo.defi.executer;

import java.math.BigDecimal;

import ca.ezo.defi.expresssion.ExpressionNode;
import ca.ezo.defi.parser.ExpressionBuilder;
import ca.ezo.defi.parser.ExpressionExtractor;
import ca.ezo.defi.parser.elements.ExpressionElement;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExpressionExecuter {
	
	private final String expression;
	
	public BigDecimal execute() {
		return this.buildExpression().resolve();
	}
	
	public ExpressionNode buildExpression() {
		ExpressionExtractor extractor = new ExpressionExtractor(this.expression);
		ExpressionBuilder builder = new ExpressionBuilder();
		while (extractor.hasMore()) {
			ExpressionElement element = extractor.nextNode();

			element.accept(builder);
		}

		return builder.getExpression();
	}
}
