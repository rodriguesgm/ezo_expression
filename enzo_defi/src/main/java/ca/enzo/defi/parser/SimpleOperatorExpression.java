package ca.enzo.defi.parser;

import ca.enzo.defi.expresssion.DivisionNode;
import ca.enzo.defi.expresssion.ExpressionNode;
import ca.enzo.defi.expresssion.MultiplierNode;
import ca.enzo.defi.expresssion.SubtractNode;
import ca.enzo.defi.expresssion.SumNode;
import ca.enzo.defi.expresssion.PowerNode;

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
