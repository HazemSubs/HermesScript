
public class AdditionalSteps extends TroubleshootingSteps {

	public AdditionalSteps(DataManipulator dataM) {
		data = dataM;
		questions = data.getQuestions("Additional Information:");
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
