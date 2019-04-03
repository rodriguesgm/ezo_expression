package ca.enzo.defi.expresssion;

import java.math.BigDecimal;

import lombok.RequiredArgsConstructor;

/**
 * Represents a minimal operator in an expression, that means, a number
 * 
 * It can not have left or right expressions, it only know itself and resolves
 * to itself.
 * 
 * It has the highest priority, that means, it must be resolved before any other
 * part of the expression
 * 
 * @author Guilherme
 */
@RequiredArgsConstructor
public class ValueNode extends ExpressionNode {

	private final BigDecimal value;

	@Override
	public BigDecimal resolve() {
		return this.value;
	}

	@Override
	public ExpressionNodePriority getPriority() {
		return ExpressionNodePriority.SUPREME;
	}

	public void setLeft(ExpressionNode left) {
		throw new UnsupportedOperationException("ValueNode does not support left or right expressions");
	}

	public void setRight(ExpressionNode left) {
		throw new UnsupportedOperationException("ValueNode does not support left or right expressions");
	}

	public ExpressionNode getLeft() {
		throw new UnsupportedOperationException("ValueNode does not support left or right expressions");
	}

	public ExpressionNode getRight() {
		throw new UnsupportedOperationException("ValueNode does not support left or right expressions");
	}
}
