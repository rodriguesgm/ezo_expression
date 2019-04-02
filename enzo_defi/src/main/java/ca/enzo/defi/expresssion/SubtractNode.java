package ca.enzo.defi.expresssion;

/**
 * Execute a subtraction between two nodes.
 * 
 * First, resolves the left node and then the right node. The result are
 * subtracted and returned.
 * 
 * It has the lowest priority in an equation
 * 
 * @author Guilherme
 */
public class SubtractNode extends ExpressionNode {

	@Override
	public double resolve() {
		return this.left.resolve() - this.right.resolve();
	}

	@Override
	public ExpressionNodePriority getPriority() {
		return ExpressionNodePriority.LOW;
	}

}
