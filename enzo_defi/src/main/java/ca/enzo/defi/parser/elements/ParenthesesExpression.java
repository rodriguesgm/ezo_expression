package ca.enzo.defi.parser.elements;

import ca.enzo.defi.expresssion.ExpressionNode;
import ca.enzo.defi.parser.ExpressionVisitor;
import lombok.Setter;
import ca.enzo.defi.expresssion.ParenthesesNode;

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
