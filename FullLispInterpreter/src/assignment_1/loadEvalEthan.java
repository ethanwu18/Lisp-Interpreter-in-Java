package assignment_1;
import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.StringAtom;
import main.lisp.parser.terms.TAtom;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import main.lisp.parser.terms.NilAtom;

import main.lisp.interpreter.ObservableLispInterpreter;
import main.lisp.interpreter.InterpreterModelSingleton;

public class loadEvalEthan implements Evaluator {

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		if (expr.getTail() instanceof NilAtom | !(expr.getTail().getTail() instanceof NilAtom)) {
//			System.err.println("Missing arguments for operator 'load'");
			throw new IllegalStateException("Missing arguments for operator 'load'");
		}

		try {
			String file = expr.getTail().toString();
			String fileReal = file.substring(2, file.length() - 2);
			
			Path strFile = Paths.get(fileReal);
			List<String> output = Files.readAllLines(strFile);
			
			for(String line:output) {
				InterpreterModelSingleton.get().newInput(line);
			}
		} catch (IOException e) {
				return new NilAtom();
		}
		return new TAtom();
	}
}
