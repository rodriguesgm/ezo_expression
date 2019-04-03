package ca.enzo.defi.expresssion;

import java.math.BigDecimal;

/**
 * Execute a division between two nodes.
 * 
 * First, resolves the left node and then the right node. The result are divided
 * and returned.
 * 
 * @author Guilherme
 */
public class DivisionNode extends ExpressionNode {

	@Override
	public BigDecimal resolve() {
		return this.left.resolve().divide(this.right.resolve());
	}

	@Override
	public ExpressionNodePriority getPriority() {
		return ExpressionNodePriority.MEDIUM;
	}
}
