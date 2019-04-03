package ca.enzo.defi.parser.elements;

import ca.enzo.defi.expresssion.ExpressionNode;
import ca.enzo.defi.parser.ExpressionVisitor;

public class EmptyOperatorExpression implements ExpressionElement {

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public ExpressionNode createNode() {
		throw new UnsupportedOperationException("Empty operator has no node");
	}
}
