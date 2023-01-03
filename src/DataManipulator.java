import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class DataManipulator {
	
	private String remindersFilePath = "data/reminders.txt";
	private String spacioFilePath = "data/spacio.txt";
	private File remindersFile = null;
	private File spacioFile = null;
	private Scanner fileScanner = null;
	private Random rand = new Random();
	
	public DataManipulator() {
		remindersFile = new File(remindersFilePath);
		spacioFile = new File(spacioFilePath);
	}
	
	public String getReminders() {
		
		String reminders = "";
		try {
			fileScanner = new Scanner(remindersFile);
			while(fileScanner.hasNext()) {
				reminders += fileScanner.nextLine() + "\n";
			}
		} catch (Exception e) {
			System.out.println("Error scanning reminders file! Error code: 0x0001.0");
			reminders = "Error, reminders file empty or non-existant";
		}
		
		return reminders;
	}
	
	public int getNumOfReminders() {
		int numOfReminders = 0;
		
		try {
			fileScanner = new Scanner(remindersFile);
			while (fileScanner.hasNext()) {
				numOfReminders++; 
				fileScanner.nextLine();
				}
		} catch (Exception e) {
			System.out.println("Error scanning reminders file! Error code: 0x0002.1");
		}
		return numOfReminders;
	}
	
	public String getReminder(int index) {
		String reminder = "";
		
		try {
			
			fileScanner = new Scanner(remindersFile);
			int iterate = 1;
			while (fileScanner.hasNext()) {
				if (iterate == index) return fileScanner.nextLine();
				fileScanner.nextLine();
				iterate++;
			} 
			
		} catch (Exception e) {
			System.out.println("Error scanning reminders file! Error code: 0x0002.2");
	}
		
		return reminder;
	}
	
	public String getRandomReminder() {
		int index = rand.nextInt(getNumOfReminders())+1;
		String reminder = "";
		
		try {
			fileScanner = new Scanner(remindersFile);
			int iterate = 1;
			while (fileScanner.hasNext()) {
				if (iterate == index) return fileScanner.nextLine();
				fileScanner.nextLine();
				iterate++;}
		} catch (Exception e) {
			System.out.println("Error scanning reminders file! Error code: 0x0002.2");
		}
		
		return reminder;
	}

	public String[] retrieveQuestions(String scenario) {
		String[] questions = new String[100];
		int questionIndex = 0;
		try {
			fileScanner = new Scanner(spacioFile);
			
			// Loop (next 2 lines) to find the "Starting Scenario"
			while (fileScanner.hasNext()) {
				String line = fileScanner.nextLine();
				
				if (line.equals(scenario)) {
					
					// Loop to get all lines that start with * (i.e., questions)
					line = fileScanner.nextLine();
					while (line.startsWith("*")) {
						questions[questionIndex] = line;
						
						// Catch the end of the file as an exception
						try {
						line = fileScanner.nextLine();
						} catch (Exception e2) {
							return questions;
						}
						// Loop to find all lines after the questions (i.e., the tips)
						while (!line.startsWith("*") && !line.equals("")) {
							questions[questionIndex] = questions[questionIndex]+ "\n" + line;
							line = fileScanner.nextLine();
						}
						
						questionIndex++;
					}
					
				}
			}
		} catch (Exception e) {
			System.out.println("Error scanning SPACIO file! Error code: 0x0003");
		}
		return questions;
	}
	
	public QuestionNode[] getQuestions(String scenario) {
		String[] questionsAndTips = this.retrieveQuestions(scenario);
		QuestionNode[] questions = new QuestionNode[100];
		
		for (int i = 0; questionsAndTips[i] != null; i++) 
		{
			// Scan a question
			Scanner scanner = new Scanner(questionsAndTips[i]);
			String tempQuestion = scanner.nextLine();
			
			// Find the tips
			int tipIndex = 0;
			String[] tempTipArray = new String[100];
			while (scanner.hasNext()) {
				tempTipArray[tipIndex] = scanner.nextLine();
				tipIndex++;
			}
			questions[i] = new QuestionNode(tempQuestion, tempTipArray);
		}
		return questions;
	}
	
	public int getNumOfQuestions(QuestionNode[] questions) {
		int num = 0;
		for (int i = 0; questions[i] != null; i++) {
			num++;
		}
		return num;
	}

	public static void main(String[] args) {
		DataManipulator d = new DataManipulator();
		String scenario = "Starting Scenario:";
		StartingSteps a = new StartingSteps();
//		a.getQuestions();
		System.out.println("123");
		a.getQuestions();
		System.out.println(d.getNumOfQuestions(d.getQuestions(scenario)));
	}

}
