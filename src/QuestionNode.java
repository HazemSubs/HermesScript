
public class QuestionNode {
	
	private String stringQuestion;
	private String[] tips;
	public boolean answered = false;
	
	public QuestionNode(String quest, String[] qTips) {
		stringQuestion = quest;
		tips = qTips;
	}

	public String getStringQuestion() {
		return stringQuestion;
	}

	public void setStringQuestion(String stringQuestion) {
		this.stringQuestion = stringQuestion;
	}

	public String[] getTips() {
		return tips;
	}
	
	public int getNumOfTips() {
		int num = 0;
		for (int i = 0; i < tips.length; i++) {
			if (tips[i] != null) num++;
		}
		return num;
	}

	public void setTips(String[] tips) {
		this.tips = tips;
	}

}
