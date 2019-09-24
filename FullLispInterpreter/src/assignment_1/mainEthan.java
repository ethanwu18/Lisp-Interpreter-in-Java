package assignment_1;
import main.Main;
import main.lisp.parser.terms.ExpressionFactory;

public class mainEthan {
	public static void main(String[] args) {
		OperationRegisterEthan.registerNew();
		ExpressionFactory.setClass(CompositeSExpression.class);

		Main.main(args);
	}
}
