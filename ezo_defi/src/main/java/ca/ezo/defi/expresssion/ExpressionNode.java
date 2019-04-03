package ca.ezo.defi.expresssion;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * An abstraction of a node in an equation. Every item of the equation is
 * consider as a node, so it can be a number, an operator, etc..
 * 
 * A basic operation usually has to consider its left node and its right note,
 * some particular cases as a {@link ValueNode} or some specific operator,
 * behaves differently
 * 
 * @author Guilherme
 */
public abstract class ExpressionNode {

	@Getter	@Setter
	protected ExpressionNode right;
	@Getter	@Setter
	protected ExpressionNode left;

	/**
	 * @return Should execute the respective action on the nodes and return the result
	 */
	public abstract BigDecimal resolve();

	/**
	 * @return Should return its priority on the equation
	 */
	public abstract ExpressionNodePriority getPriority();
}
