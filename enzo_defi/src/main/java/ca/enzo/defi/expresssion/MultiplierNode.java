package ca.enzo.defi.expresssion;

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
	public double resolve() {
		return this.left.resolve() * this.right.resolve();
	}

	@Override
	public ExpressionNodePriority getPriority() {
		return ExpressionNodePriority.MEDIUM;
	}

}
