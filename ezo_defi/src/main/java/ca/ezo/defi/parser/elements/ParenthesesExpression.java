package ca.ezo.defi.parser.elements;

import ca.ezo.defi.expresssion.ExpressionNode;
import ca.ezo.defi.parser.ExpressionVisitor;
import lombok.Setter;
import ca.ezo.defi.expresssion.ParenthesesNode;

public class ParenthesesExpression implements ExpressionElement {

	@Setter private ExpressionNode expression;
	
	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public ExpressionNode createNode() {
		return new ParenthesesNode(this.expression);
	}

}
