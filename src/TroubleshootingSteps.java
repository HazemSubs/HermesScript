
public class TroubleshootingSteps {

	protected DataManipulator data;
	protected QuestionNode[] questions;
	protected int numOfQuestions;
	protected boolean done = false;
	protected boolean ticketHeadingPresent = false;	

	public boolean isTicketHeadingPresent() {
		return ticketHeadingPresent;
	}

	public void setTicketHeadingPresent(boolean ticketHeadingPresent) {
		this.ticketHeadingPresent = ticketHeadingPresent;
	}
	
	public boolean setQuestionAnwsered(String question) {
		for (int i = 0; i < numOfQuestions; i++) {
			if (questions[i].getStringQuestion().equals(question)) {
				questions[i].answered = true;
				checkIfDone();
				return true;
			}
		}
		return false;
	}
	
	public void checkIfDone() {
		for (int i = 0; i < numOfQuestions; i++) {
			if (!questions[i].answered) return;
		}
		setDone(true);
	}
	
	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
}
