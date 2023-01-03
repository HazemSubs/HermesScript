
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
	
}
