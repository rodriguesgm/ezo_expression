package ca.enzo.defi.expresssion;

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
	public double resolve() {
		return Math.pow(this.left.resolve(), this.right.resolve());
	}

	@Override
	public ExpressionNodePriority getPriority() {
		return ExpressionNodePriority.HIGHER;
	}
}
