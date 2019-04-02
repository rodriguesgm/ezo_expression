package ca.enzo.defi.parser;

import ca.enzo.defi.expresssion.ExpressionNode;
import ca.enzo.defi.expresssion.ValueNode;
import lombok.Setter;

public class ValueExpression implements ExpressionElement {

	@Setter private int value;

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public ExpressionNode createNode() {
		return new ValueNode(this.value);
	}
}
