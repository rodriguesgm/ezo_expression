package ca.enzo.defi.expresssion;

/**
 * Definition of priorities for nodes. Builder uses it to determine which node
 * must be executed first
 * 
 * @author Guilherme
 */
public enum ExpressionNodePriority {

	LOW(0), MEDIUM(500), HIGH(1000), HIGHER(2000), SUPREME(3000);

	private int priority;

	ExpressionNodePriority(int priority) {
		this.priority = priority;
	}

	public boolean hasPriorityOf(ExpressionNodePriority rightNode) {
		return this.priority >= rightNode.priority;
	}
}
