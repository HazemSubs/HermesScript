
public class OtherSteps extends TroubleshootingSteps {

	public OtherSteps(DataManipulator dataM) {
		data = dataM;
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
	
}
