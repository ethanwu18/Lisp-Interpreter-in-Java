package assignment_1;
import gradingTools.comp524f19.assignment1.Assignment1Suite;
import trace.grader.basics.GraderBasicsTraceUtility;
import util.trace.Tracer;

public class runA1Tests {
	public static void main (String[] args) {
		// the following two lines should be uncommented if you do not understand why your tests fails
		Tracer.showInfo(true);
		GraderBasicsTraceUtility.setBufferTracedMessages(false);
		Assignment1Suite.main(args);
	}

}
