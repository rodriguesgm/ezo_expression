package ca.enzo.defi.expresssion;

import java.math.BigDecimal;

/**
 * Execute a multiplication between two nodes.
 * 
 * First, resolves the left node and then the right node. The result are
 * multiplied and returned.
 * 
 * @author Guilherme
 */
public class MultiplierNode extends ExpressionNode {

	@Override
	public BigDecimal resolve() {
		return this.left.resolve().multiply(this.right.resolve());
	}

	@Override
	public ExpressionNodePriority getPriority() {
		return ExpressionNodePriority.MEDIUM;
	}

}
