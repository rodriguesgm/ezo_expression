package ca.ezo.defi.parser;

import ca.ezo.defi.expresssion.ExpressionNode;
import ca.ezo.defi.parser.elements.EmptyOperatorExpression;
import ca.ezo.defi.parser.elements.ParenthesesExpression;
import ca.ezo.defi.parser.elements.SimpleOperatorExpression;
import ca.ezo.defi.parser.elements.ValueExpression;
import lombok.Getter;

/**
 * Visitor to create the nodes structure in the right order so the expression
 * can be resolved.
 * 
 * It has a current expression that means the top root of the expression.
 * 
 * @author Guilherme
 */
public class ExpressionBuilder implements ExpressionVisitor {

	@Getter
	private ExpressionNode expression;

	/**
	 * Visitor to add a value node in the expression structure. It is always
	 * appended to the last right expression node, unless the expression is null. A
	 * value node is always the last node in the structure
	 */
	@Override
	public void visit(ValueExpression valueExp) {
		ExpressionNode value = valueExp.createNode();
		if (this.expression == null) {
			this.expression = value;
		} else {
			ExpressionNode ex = this.expression;
			while (ex.getRight() != null) {
				ex = ex.getRight();
			}
			ex.setRight(value);
		}
	}

	/**
	 * Visitor for all simple operator like (+, -, / etc). If the current expression
	 * node has priority over the passed simple operator, that means the current
	 * expression must be executed first so the current expression is added as the
	 * left node of the passed simple operator and the simple operator becomes the
	 * current expression. Otherwise, the passed simple operator has priority on the
	 * current expression and it search in the right node structure where it should
	 * be added based on the priority of each right node
	 */
	@Override
	public void visit(SimpleOperatorExpression valueExp) {
		ExpressionNode nodeExpression = valueExp.createNode();
		if (this.expression.getPriority().hasPriorityOf(nodeExpression.getPriority())) {
			nodeExpression.setLeft(this.expression);
			this.expression = nodeExpression;
		} else {
			ExpressionNode parentNode = this.expression;
			ExpressionNode rightNode = this.expression.getRight();
			while (rightNode != null && !rightNode.getPriority().hasPriorityOf(nodeExpression.getPriority())) {
				parentNode = rightNode;
				rightNode = rightNode.getRight();
			}
			nodeExpression.setLeft(rightNode);
			parentNode.setRight(nodeExpression);
		}
	}

	/**
	 * Visitor for the empty operator. Just add nothing in the structure since it
	 * just do nothing
	 */
	@Override
	public void visit(EmptyOperatorExpression emptyOperatorExpression) {
		// do nothing
	}

	/**
	 * Visitor for the expression inside a parentheses. It has the same meaning of a
	 * value, so it is always added in the last right node, this way it has priority
	 * to be executed
	 */
	@Override
	public void visit(ParenthesesExpression parenthesesExpression) {
		ExpressionNode value = parenthesesExpression.createNode();
		if (this.expression == null) {
			this.expression = value;
		} else {
			ExpressionNode ex = this.expression;
			while (ex.getRight() != null) {
				ex = ex.getRight();
			}
			ex.setRight(value);
		}
	}
}
