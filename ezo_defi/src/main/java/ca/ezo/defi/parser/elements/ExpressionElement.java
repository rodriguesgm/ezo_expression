package ca.ezo.defi.parser.elements;

import ca.ezo.defi.expresssion.ExpressionNode;
import ca.ezo.defi.parser.ExpressionVisitor;

public interface ExpressionElement {

	void accept(ExpressionVisitor visitor);

	ExpressionNode createNode();
}
