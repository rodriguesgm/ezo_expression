package ca.ezo.defi.parser.elements;

import java.math.BigDecimal;

import ca.ezo.defi.expresssion.ExpressionNode;
import ca.ezo.defi.expresssion.ValueNode;
import ca.ezo.defi.parser.ExpressionVisitor;
import lombok.Setter;

public class ValueExpression implements ExpressionElement {

	@Setter private BigDecimal value;

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public ExpressionNode createNode() {
		return new ValueNode(this.value);
	}
}
