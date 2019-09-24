package assignment_1;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.DecimalAtom;
import main.lisp.parser.terms.IntegerAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;

public class LessEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		expr = expr.getTail();
		if (expr instanceof NilAtom || expr.getHead() instanceof NilAtom || expr.getTail() instanceof NilAtom) {
//			System.err.println("Missing arguments for operator '<'");
			throw new IllegalStateException("Missing arguments for operator '<'");
		}
		
		SExpression firstEvaled = expr.getHead().eval(environment);
		SExpression secondEvaled = expr.getTail().eval(environment);
		
		IntegerAtom firstInt = null;
		IntegerAtom secondInt = null;
		DecimalAtom firstDec = null;
		DecimalAtom secondDec = null;
		
		int correctArgs = 0;
		
		if (firstEvaled instanceof IntegerAtom) {
			firstInt = (IntegerAtom)firstEvaled;
			correctArgs++;
		}
		if (firstEvaled instanceof DecimalAtom) {
			firstDec = (DecimalAtom)firstEvaled;
			correctArgs++;
		}
		
		if (secondEvaled instanceof IntegerAtom) {
			secondInt = (IntegerAtom)secondEvaled;
			correctArgs++;
		}
		if (secondEvaled instanceof DecimalAtom) {
			secondDec = (DecimalAtom)secondEvaled;
			correctArgs++;
		}
		
		if (correctArgs != 2) {
//			System.err.println("Arguments for operator '<' must both evaluate to numbers");
			throw new IllegalStateException("Arguments for operator '<' must both evaluate to numbers");
		}
		
		boolean less;
		
		if (firstInt != null) {
			if (secondInt != null) {
				less = firstInt.getValue().longValue() < secondInt.getValue().longValue();
			} else {
				less = firstInt.getValue().longValue() < secondDec.getValue().doubleValue();
			}
		} else {
			if (secondInt != null) {
				less = firstDec.getValue().doubleValue() < secondInt.getValue().longValue();
			} else {
				less = firstDec.getValue().doubleValue() < secondDec.getValue().doubleValue();
			}
		}
			
		if (less) {
			return new TAtom();
		} else {
			return new NilAtom();
		}
	}

}
