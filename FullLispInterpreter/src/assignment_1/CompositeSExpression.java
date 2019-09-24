package assignment_1;

import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.BasicExpression;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.StringAtom;
import main.lisp.parser.terms.NilAtom;

public class CompositeSExpression extends BasicExpression implements SExpression {

	public CompositeSExpression(SExpression head, SExpression tail) {
		super(head, tail);
		// TODO Auto-generated constructor stub
	}

	public boolean isList() {
		if(this.getTail() instanceof NilAtom) {
			return true;
		} else if(this.getTail() instanceof Atom) {
			return false;
		} else {
			return this.getTail().isList();
		}
	}
	
	/**
	 * Creates a {@code String} representation of list contained in
	 * this S-Expression or an empty string if this is not a list.
	 * 
	 * @return formatted list
	 */
	public String toString() {
		return this.isList() ? "(" + this.toStringAsList() + ")" : this.toStringAsSExpression();
	}
	
	
	public String toStringAsList() {
		if (this.getTail() instanceof NilAtom) {
			return this.getHead().toString();
		} else {
			return this.getHead().toString() + " " + this.getTail().toStringAsList();
		}
	}
	
	/**
	 * Creates a {@code String} representation of this S-Expression
	 * 
	 * @return formatted S-Expression
	 */
	public String toStringAsSExpression() {
		return "(" + this.getHead().toString() + " " + "." + " " + this.getTail().toString() + ")";
	}
	
	public String toStringAsSExpressionDeep() {
		return "(" + this.getHead().toStringAsSExpressionDeep() + " " + "." + " " + this.getTail().toStringAsSExpressionDeep() + ")";
	}
}
