package ca.ezo.defi.parser;

import ca.ezo.defi.parser.elements.EmptyOperatorExpression;
import ca.ezo.defi.parser.elements.ParenthesesExpression;
import ca.ezo.defi.parser.elements.SimpleOperatorExpression;
import ca.ezo.defi.parser.elements.ValueExpression;

/**
 * Visitor to interpreter each operator of an expression
 * 
 * @author Guilherme
 */
public interface ExpressionVisitor {

	void visit(ValueExpression valueExp);

	void visit(SimpleOperatorExpression valueExp);

	void visit(EmptyOperatorExpression emptyOperatorExpression);

	void visit(ParenthesesExpression parenthesesExpression);
}
