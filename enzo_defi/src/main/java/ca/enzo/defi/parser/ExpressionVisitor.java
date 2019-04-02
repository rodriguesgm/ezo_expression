package ca.enzo.defi.parser;

public interface ExpressionVisitor {

	void visit(ValueExpression valueExp);
	void visit(SimpleOperatorExpression valueExp);
	void visit(EmptyOperatorExpression emptyOperatorExpression);
}
