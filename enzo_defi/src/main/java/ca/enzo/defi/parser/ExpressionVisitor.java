package ca.enzo.defi.parser;

import ca.enzo.defi.parser.elements.EmptyOperatorExpression;
import ca.enzo.defi.parser.elements.SimpleOperatorExpression;
import ca.enzo.defi.parser.elements.ValueExpression;

public interface ExpressionVisitor {

	void visit(ValueExpression valueExp);
	void visit(SimpleOperatorExpression valueExp);
	void visit(EmptyOperatorExpression emptyOperatorExpression);
}
