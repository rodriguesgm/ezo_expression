package ca.enzo.defi.parser;

import ca.enzo.defi.expresssion.ExpressionNode;
import lombok.Getter;
import ca.enzo.defi.expresssion.ValueNode;
import ca.enzo.defi.parser.elements.EmptyOperatorExpression;
import ca.enzo.defi.parser.elements.ParenthesesExpression;
import ca.enzo.defi.parser.elements.SimpleOperatorExpression;
import ca.enzo.defi.parser.elements.ValueExpression;

public class ExpressionBuilder implements ExpressionVisitor {

	@Getter
	private ExpressionNode expression;
//	IExpression extraOp;

	@Override
	public void visit(ValueExpression valueExp) {
		ExpressionNode value = valueExp.createNode();
		if (this.expression == null) {
			this.expression = value;
		} else if (!(this.expression instanceof ValueNode)) {
			ExpressionNode ex = this.expression;
			while (ex.getRight() != null) {
				ex = ex.getRight();
			}
			ex.setRight(value);
		}
	}

	@Override
	public void visit(SimpleOperatorExpression valueExp) {
		ExpressionNode nodeExpression = valueExp.createNode();
		if (this.expression.getPriority().hasPriorityOf(nodeExpression.getPriority())) {
			nodeExpression.setLeft(this.expression);
			this.expression = nodeExpression;
		} else {
			nodeExpression.setLeft(this.expression.getRight());
			this.expression.setRight(nodeExpression);
		}
	}

	@Override
	public void visit(EmptyOperatorExpression emptyOperatorExpression) {
		// do nothing		
	}

	@Override
	public void visit(ParenthesesExpression parenthesesExpression) {
		ExpressionNode value = parenthesesExpression.createNode();
		if (this.expression == null) {
			this.expression = value;
		} else if (!(this.expression instanceof ValueNode)) {
			ExpressionNode ex = this.expression;
			while (ex.getRight() != null) {
				ex = ex.getRight();
			}
			ex.setRight(value);
		}
	}
}
