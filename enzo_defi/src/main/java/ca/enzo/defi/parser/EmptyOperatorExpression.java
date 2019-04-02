package ca.enzo.defi.parser;

import ca.enzo.defi.expresssion.ExpressionNode;

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
