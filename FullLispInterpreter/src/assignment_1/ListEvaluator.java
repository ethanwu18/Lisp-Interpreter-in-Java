package assignment_1;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class ListEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		
		SExpression list = expr.getTail();
		
		return recurList(list, environment);
	}
	
	public SExpression recurList(SExpression next, Environment environment) {
		if (next.getTail() instanceof NilAtom) {
			return ExpressionFactory.newInstance(next.getHead().eval(environment), next.getTail().eval(environment));
		}
		return ExpressionFactory.newInstance(next.getHead().eval(environment), recurList(next.getTail(), environment));
	
	}
}
