package ca.ezo.defi.expresssion;

import java.math.BigDecimal;

import lombok.RequiredArgsConstructor;

/**
 * Representes an expression inside ().
 * It has a hole structure of an expression nodes and the resolve only
 * executes the resolve of that structure
 * 
 * @author Guilherme
 */
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
