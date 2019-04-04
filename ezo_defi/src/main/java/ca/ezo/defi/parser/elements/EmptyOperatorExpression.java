package ca.ezo.defi.parser.elements;

import ca.ezo.defi.expresssion.ExpressionNode;
import ca.ezo.defi.parser.ExpressionVisitor;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
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
