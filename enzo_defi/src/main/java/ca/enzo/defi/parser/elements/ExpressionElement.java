package ca.enzo.defi.parser.elements;

import ca.enzo.defi.expresssion.ExpressionNode;
import ca.enzo.defi.parser.ExpressionVisitor;

public interface ExpressionElement {

	void accept(ExpressionVisitor visitor);

	ExpressionNode createNode();
}
