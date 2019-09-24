package assignment_1;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class QuoteEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		if (expr instanceof NilAtom | !(expr.getTail().getTail() instanceof NilAtom)) {
//			System.err.println("Missing arguments for operator 'quote'");
			throw new IllegalStateException("Missing arguments for operator 'quote'");
		}
		SExpression stuff = expr.getTail().getHead();
		
		return stuff;
	}

}
