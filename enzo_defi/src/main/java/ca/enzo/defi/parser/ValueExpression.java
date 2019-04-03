package ca.enzo.defi.parser;

import java.math.BigDecimal;

import ca.enzo.defi.expresssion.ExpressionNode;
import ca.enzo.defi.expresssion.ValueNode;
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
	
//	public double readValue(String expression, int startIndex) {
//		
//	}
}
