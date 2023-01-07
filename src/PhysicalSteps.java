
public class PhysicalSteps extends TroubleshootingSteps {

	public PhysicalSteps(DataManipulator dataM) {
		data = dataM;
		questions = data.getQuestions("Physical Checks:");
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
