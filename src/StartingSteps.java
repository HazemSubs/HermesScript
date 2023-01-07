
public class StartingSteps extends TroubleshootingSteps {

	public StartingSteps(DataManipulator dataM) {
		data = dataM;
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

}
