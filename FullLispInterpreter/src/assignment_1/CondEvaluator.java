package assignment_1;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class CondEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		if (expr.getTail() instanceof Atom) {
//			System.err.println("Missing arguments for operator 'cond'");
			throw new IllegalStateException("Missing arguments for operator 'cond'");
		}
		
		SExpression condStr = expr.getTail();
		
		return recurList(condStr, environment);
	}

	public SExpression recurList(SExpression next, Environment environment) {
		
		if (!(next.getHead().getHead().eval(environment) instanceof NilAtom)) {
			if(next.getHead().getTail() instanceof NilAtom) {
				return next.getHead().getHead().eval(environment); // (cond (T)) -> T does not work :(
			} else {
				return next.getHead().getTail().eval(environment);
			}
			
		}
		if (next.getTail() instanceof NilAtom) {
			return new NilAtom();
		} 
		return recurList(next.getTail(), environment);
	
	}

}
