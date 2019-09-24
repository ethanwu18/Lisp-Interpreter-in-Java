package assignment_1;

import java.util.HashMap;
import java.util.Map;

import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.OperationManager;

public class OperationManagerEthan implements OperationManager {

private final Map<String, Evaluator> evaluatorMap;
	
	public OperationManagerEthan() {
		evaluatorMap = new HashMap<>();
	}
	
	public void registerEvaluator(String name, Evaluator evaluator) {
		evaluatorMap.put(name.toUpperCase(), evaluator);
	}
	
	public Evaluator getEvaluator(String name) {
		return evaluatorMap.get(name.toUpperCase());
	}

}
