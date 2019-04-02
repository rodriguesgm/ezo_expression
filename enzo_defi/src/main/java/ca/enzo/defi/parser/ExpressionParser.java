package ca.enzo.defi.parser;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class ExpressionParser implements ExpressionVisitor {

	private final String expression;
	@Setter private int currentIndex;

	@Override
	public void visit(ValueExpression valueExp) {
		char digit = this.expression.charAt(this.currentIndex);
		int value = Character.digit(digit, 10);
		valueExp.setValue(value);
	}

	@Override
	public void visit(SimpleOperatorExpression valueExp) {
		
	}

	@Override
	public void visit(EmptyOperatorExpression emptyOperatorExpression) {
		
	}

}
