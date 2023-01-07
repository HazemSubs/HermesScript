
public class ConfigurationSteps extends TroubleshootingSteps {
	
	public ConfigurationSteps(DataManipulator dataM) {
		data = dataM;
		questions = data.getQuestions("Configure Network:");
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
