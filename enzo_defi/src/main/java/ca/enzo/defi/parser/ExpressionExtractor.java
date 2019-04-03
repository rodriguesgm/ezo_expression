package ca.enzo.defi.parser;

import java.math.BigDecimal;

import ca.enzo.defi.parser.elements.ExpressionElement;
import ca.enzo.defi.parser.elements.ValueExpression;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExpressionExtractor {

	private final String expression;
	private int currentIndex = 0;

	public boolean hasMore() {
		return this.expression.length() > this.currentIndex;
	}

	public ExpressionElement nextNode() {
		char nextChar = this.expression.charAt(this.currentIndex);
		ExpressionElement element = ExpressionElementFactory.factory(nextChar);
		int nextIndexIncrement = 1;
		if (element instanceof ValueExpression) {
			nextIndexIncrement = this.parseNumber((ValueExpression) element);
		}
		this.currentIndex += nextIndexIncrement;
		return element;
	}

	private int parseNumber(ValueExpression valueExp) {
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
		valueExp.setValue(new BigDecimal(number));
		return number.length();
	}
}
