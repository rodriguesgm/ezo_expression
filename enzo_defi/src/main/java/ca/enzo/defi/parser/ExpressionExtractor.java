package ca.enzo.defi.parser;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class ExpressionExtractor implements ExpressionVisitor {

	private final String expression;
	@Setter @Getter private int currentIndex;

	@Override
	public void visit(ValueExpression valueExp) {
		int index = this.currentIndex;
		String number = "";
		char digit = this.expression.charAt(index);
		do {
			number += digit;
			index++;
			if (index < this.expression.length()) {
				digit = this.expression.charAt(index);
			} else {
				digit = '\u0000';
			}
		} while (Character.isDigit(digit) || digit == '.');
		this.currentIndex = --index;
		valueExp.setValue(new BigDecimal(number));
	}

	@Override
	public void visit(SimpleOperatorExpression valueExp) {
		
	}

	@Override
	public void visit(EmptyOperatorExpression emptyOperatorExpression) {
		
	}

}
