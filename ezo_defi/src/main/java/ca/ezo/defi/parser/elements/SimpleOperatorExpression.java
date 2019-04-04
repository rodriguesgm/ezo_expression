package ca.ezo.defi.parser.elements;

import ca.ezo.defi.expresssion.DivisionNode;
import ca.ezo.defi.expresssion.ExpressionNode;
import ca.ezo.defi.expresssion.MultiplierNode;
import ca.ezo.defi.expresssion.PowerNode;
import ca.ezo.defi.expresssion.SubtractNode;
import ca.ezo.defi.expresssion.SumNode;
import ca.ezo.defi.parser.ExpressionVisitor;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SimpleOperatorExpression implements ExpressionElement {
	private char expChar;

	public SimpleOperatorExpression(char expChar) {
		this.expChar = expChar;
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public ExpressionNode createNode() {
		switch (expChar) {
		case '-':
			return new SubtractNode();
		case '/':
			return new DivisionNode();
		case '+':
			return new SumNode();
		case '*':
			return new MultiplierNode();
		case '^':
			return new PowerNode();
		default:
			throw new RuntimeException("SimpleOperator is '" + expChar + "' not recognized");
		}
	}
}
