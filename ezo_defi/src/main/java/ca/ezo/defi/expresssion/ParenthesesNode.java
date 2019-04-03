package ca.ezo.defi.expresssion;

import java.math.BigDecimal;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class ParenthesesNode extends ExpressionNode {

	private final ExpressionNode expression;

	@Override
	public BigDecimal resolve() {
		return this.expression.resolve();
	}

	@Override
	public ExpressionNodePriority getPriority() {
		return ExpressionNodePriority.HIGHER;
	}

}
