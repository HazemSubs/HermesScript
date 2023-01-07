
public class IdAndSecuritySteps extends TroubleshootingSteps {

	public IdAndSecuritySteps(DataManipulator dataM) {
		data = dataM;
		questions = data.getQuestions("Identity and Security:");
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
