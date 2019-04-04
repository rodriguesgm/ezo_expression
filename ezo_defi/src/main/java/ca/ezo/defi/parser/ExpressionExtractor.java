package ca.ezo.defi.parser;

import java.math.BigDecimal;
import java.util.Stack;

import ca.ezo.defi.parser.elements.ExpressionElement;
import ca.ezo.defi.parser.elements.ExpressionElementFactory;
import ca.ezo.defi.parser.elements.ParenthesesExpression;
import ca.ezo.defi.parser.elements.ValueExpression;
import lombok.RequiredArgsConstructor;
import ca.ezo.defi.executer.ExpressionExecuter;
import ca.ezo.defi.expresssion.ExpressionNode;

/**
 * Gets a expression and extract each node (number, operator, sub-expression,
 * etc) of it.
 * 
 * @author Guilherme
 */
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
		} else if (element instanceof ParenthesesExpression) {
			nextIndexIncrement = this.extractParenthesesExpression((ParenthesesExpression) element);
		}
		this.currentIndex += nextIndexIncrement;
		return element;
	}

	private int extractParenthesesExpression(ParenthesesExpression exp) {
		int index = this.currentIndex;
		Stack<Boolean> stack = new Stack<Boolean>();

		stack.push(true);
		String expression = "(";
		do {
			index++;
			char currentChar = this.expression.charAt(index);
			expression += currentChar;
			if (currentChar == '(') {
				stack.push(true);
			} else if (currentChar == ')') {
				stack.pop();
			}
		} while (!stack.isEmpty());

		String parenthesesExpression = expression.substring(1, expression.length() - 1);
		ExpressionNode node = new ExpressionExecuter(parenthesesExpression).buildExpression();
		exp.setExpression(node);
		return expression.length();
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
