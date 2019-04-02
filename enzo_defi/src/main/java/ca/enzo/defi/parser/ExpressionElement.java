package ca.enzo.defi.parser;

import ca.enzo.defi.expresssion.ExpressionNode;

public interface ExpressionElement {

	void accept(ExpressionVisitor visitor);

	ExpressionNode createNode();
}
