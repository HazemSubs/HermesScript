
public class StartingSteps extends TroubleshootingSteps {
	
	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public StartingSteps() {
		data = new DataManipulator();
		questions = data.getQuestions("Starting Scenario:");
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

}
