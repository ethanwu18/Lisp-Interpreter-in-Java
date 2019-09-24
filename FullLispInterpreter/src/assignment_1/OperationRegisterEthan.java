package assignment_1;


import main.lisp.evaluator.BasicOperationRegisterer;
import main.lisp.evaluator.BuiltinOperationManagerSingleton;
import main.lisp.evaluator.OperationRegisterer;

public class OperationRegisterEthan extends BasicOperationRegisterer implements OperationRegisterer {

	public static void registerNew() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("load", new loadEvalEthan());
		BuiltinOperationManagerSingleton.get().registerEvaluator("quote", new QuoteEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("eval", new EvalEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("list", new ListEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("cond", new CondEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator(">", new GreatEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("<", new LessEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator(">=", new GreatEqEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("<=", new LessEqEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("and", new AndEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("or", new OrEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("not", new NotEvaluator());
	}

	public void registerOperations() {
		// TODO Auto-generated method stub
		registerAll();
		registerNew();
	}

}
