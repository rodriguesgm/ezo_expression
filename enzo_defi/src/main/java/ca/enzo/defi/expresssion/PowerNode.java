package ca.enzo.defi.expresssion;

import java.math.BigDecimal;

/**
 * Execute an exponentiation operation between two nodes.
 * 
 * First, resolves the left node and then the right node. The right result is
 * the exponent of the left result
 * 
 * @author Guilherme
 */
public class PowerNode extends ExpressionNode {

	@Override
	public BigDecimal resolve() {
		return this.left.resolve().pow(this.right.resolve().intValue());
	}

	@Override
	public ExpressionNodePriority getPriority() {
		return ExpressionNodePriority.HIGHER;
	}
}
