package ca.enzo.defi.expresssion;

/**
 * Execute a sum between two nodes.
 * 
 * First, resolves the left node and then the right node. The result are added
 * and returned.
 * 
 * It has the lowest priority in an equation
 * 
 * @author Guilherme
 */
public class SumNode extends ExpressionNode {

	@Override
	public double resolve() {
		return this.left.resolve() + this.right.resolve();
	}

	@Override
	public ExpressionNodePriority getPriority() {
		return ExpressionNodePriority.LOW;
	}

}
