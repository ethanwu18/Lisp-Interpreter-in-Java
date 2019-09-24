package assignment_1;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;

public class AndEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		if (expr.getTail() instanceof NilAtom) {
//			System.err.println("Missing arguments for operator 'and'");
			throw new IllegalStateException("Missing arguments for operator 'and'");
		}
		SExpression andStr = expr.getTail();
		
		return recurList(andStr, environment);
	}

	public SExpression recurList(SExpression next, Environment environment) {
		if (next.getTail() instanceof NilAtom) {
			return next.getHead().eval(environment);
		} 
		if (next.getHead().eval(environment) instanceof NilAtom) {
			return new NilAtom();
		}
		
		return recurList(next.getTail(), environment);
	
	}
}
