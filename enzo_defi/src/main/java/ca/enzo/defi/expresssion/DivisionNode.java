package ca.enzo.defi.expresssion;

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
	public double resolve() {
		return this.left.resolve() / this.right.resolve();
	}

	@Override
	public ExpressionNodePriority getPriority() {
		return ExpressionNodePriority.MEDIUM;
	}

}
