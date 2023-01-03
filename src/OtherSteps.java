
public class OtherSteps extends TroubleshootingSteps {

	private int numOfQuestions;
	private boolean done = false;
	
	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public OtherSteps() {
		data = new DataManipulator();
		questions = data.getQuestions("Others:");
		numOfQuestions = data.getNumOfQuestions(questions);
	}
	
	public QuestionNode[] getQuestions() {
		return questions;
	}
	
	public int getNumOfQuestions() {
		return numOfQuestions;
	}

	public void setNumOfQuestions(int numOfQuestions) {
		this.numOfQuestions = numOfQuestions;
	}

	public void checkIfDone() {
		for (int i = 0; i < numOfQuestions; i++) {
			if (!questions[i].answered) return;
		}
		setDone(true);
	}
	
	public static void main(String args[]) {
		OtherSteps s = new OtherSteps();
		s.setDone(true);
		System.out.println(s.isDone());
		s = new OtherSteps();
		System.out.println(s.isDone());
	}
}
