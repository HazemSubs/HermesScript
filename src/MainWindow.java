import java.awt.Desktop;
import java.net.URI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class MainWindow {

	protected Shell shell;
	private static DataManipulator data;
	private Text remindersText;
	private Text generalNotes;
	
	private Text ticketInformationTextbox;
	private Label ticketLabel, notesLabel, middleLabel;
	private Text questionTextbox;
	private Text tips;
	private Button submitAnswerBtn;
	private Button finishTicketBtn;
	private Text answerTextbox;
	
	private String notes = "";
	private String ticketString;
	private Composite leftComposite;
	private Composite rightComposite;
	private Composite middleComposite;
	
	private StartingSteps sSteps;
	private PhysicalSteps pSteps;
	private AdditionalSteps aSteps;
	private ConfigurationSteps cSteps;
	private IdAndSecuritySteps iSteps;
	private OtherSteps oSteps;
	
	private String lastTicket = "";
	private Button hBtn;
	private Button cfBtn;
	private Button ssBtn;
	private Button showLastTicketBtn;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		data = new DataManipulator();
		createShell();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	protected void createShell() {
		shell = new Shell();
		shell.setSize(1920, 1080);
		shell.setText("HermesScript");
		shell.setLayout(null);
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		leftComposite = new Composite(shell, SWT.BORDER);
		leftComposite.setBounds(10, 10, 610, 950);
		
		notesLabel = new Label(leftComposite, SWT.NONE);
		notesLabel.setFont(SWTResourceManager.getFont("Calibri Light", 14, SWT.NORMAL));
		notesLabel.setBounds(10, 10, 300, 44);
		notesLabel.setText("Notes for the Night:");
		
		generalNotes = new Text(leftComposite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		generalNotes.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		generalNotes.setBounds(10, 60, 588, 828);
		generalNotes.setText(notes);
		
		middleComposite = new Composite(shell, SWT.BORDER);
		middleComposite.setBounds(640, 10, 610, 950);
		
		Button troubleshootBtn = new Button(middleComposite, SWT.NONE);
		troubleshootBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				startTroubleshooting();
			}
		});
		troubleshootBtn.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		troubleshootBtn.setBounds(119, 430, 370, 44);
		troubleshootBtn.setText("New Ticket");
		
		hBtn = new Button(middleComposite, SWT.NONE);
		hBtn.setText("H");
		hBtn.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		hBtn.setBounds(119, 530, 370, 44);
		hBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				openURL("https://www.google.com/");
			}
		});
		
		cfBtn = new Button(middleComposite, SWT.NONE);
		cfBtn.setText("CF");
		cfBtn.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		cfBtn.setBounds(119, 580, 370, 44);
		cfBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				openURL("https://connect-it.uwo.ca/");
			}
		});
		
		ssBtn = new Button(middleComposite, SWT.NONE);
		ssBtn.setText("SS");
		ssBtn.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		ssBtn.setBounds(119, 630, 370, 44);
		ssBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				openURL("https://www.uwo.ca/");
			}
		});
		
		showLastTicketBtn = new Button(middleComposite, SWT.NONE);
		showLastTicketBtn.setText("Show Last Ticket");
		showLastTicketBtn.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		showLastTicketBtn.setBounds(119, 730, 370, 44);
		if (lastTicket.equals("")) showLastTicketBtn.setEnabled(false);
		showLastTicketBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!lastTicket.equals(""))
				{
					toggleNotesLastTicketView();
				}
			}
		});
		
		rightComposite = new Composite(shell, SWT.BORDER);
		rightComposite.setBounds(1270, 10, 610, 950);
		
		remindersText = new Text(rightComposite, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		remindersText.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		remindersText.setBounds(10, 10, 588, 928);
		remindersText.setText(data.getReminders());
	}
	
	public void startTroubleshooting() {
		// SPACIO
		this.initializeQuestionScreen();
		sSteps = new StartingSteps();
		pSteps = new PhysicalSteps();
		aSteps = new AdditionalSteps();
		cSteps = new ConfigurationSteps();
		iSteps = new IdAndSecuritySteps();
		oSteps = new OtherSteps();
		
		this.askQuestion();
	}
	
	private void initializeQuestionScreen() {
		this.disposeComposites();
		
		leftComposite = new Composite(shell, SWT.BORDER);
		leftComposite.setBounds(10, 10, 610, 950);
		
		ticketLabel = new Label(leftComposite, SWT.NONE);
		ticketLabel.setFont(SWTResourceManager.getFont("Calibri Light", 14, SWT.NORMAL));
		ticketLabel.setBounds(10, 10, 206, 44);
		ticketLabel.setText("Ticket Information:");
		
		ticketInformationTextbox = new Text(leftComposite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		ticketInformationTextbox.setFont(SWTResourceManager.getFont("Calibri Light", 11, SWT.NORMAL));
		ticketInformationTextbox.setBounds(10, 60, 588, 828);
		
		finishTicketBtn = new Button(leftComposite, SWT.NONE);
		finishTicketBtn.setText("Finish Ticket");
		finishTicketBtn.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.BOLD));
		finishTicketBtn.setBounds(10, 894, 588, 44);
		finishTicketBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				finishTicket();
			}
		});
		
		Button notesSwitch = new Button(leftComposite, SWT.CHECK);
		notesSwitch.setFont(SWTResourceManager.getFont("Calibri Light", 14, SWT.NORMAL));
		notesSwitch.setBounds(392, 10, 206, 44);
		notesSwitch.setText("Notes View");
		notesSwitch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				toggleNotesView(notesSwitch);
			}
		});
		
		middleComposite = new Composite(shell, SWT.BORDER);
		middleComposite.setBounds(640, 10, 610, 950);
		
		questionTextbox = new Text(middleComposite, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP );
		questionTextbox.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		questionTextbox.setBounds(10, 60, 588, 142);
		
		middleLabel = new Label(middleComposite, SWT.NONE);
		middleLabel.setAlignment(SWT.CENTER);
		middleLabel.setFont(SWTResourceManager.getFont("Calibri Light", 14, SWT.NORMAL));
		middleLabel.setBounds(10, 10, 588, 44);
		
		answerTextbox = new Text(middleComposite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		answerTextbox.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		answerTextbox.setBounds(10, 208, 588, 680);
		answerTextbox.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent e) {
				if ((e.keyCode == SWT.KEYPAD_CR || e.keyCode == SWT.CR) && (e.stateMask & SWT.MODIFIER_MASK) == SWT.CTRL)
				{
					submitAnswerBtn.notifyListeners(e.keyCode, new Event());
				}
			}
		});
		
		submitAnswerBtn = new Button(middleComposite, SWT.NONE);
		submitAnswerBtn.setBounds(10, 894, 588, 44);
		submitAnswerBtn.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.BOLD));
		submitAnswerBtn.setText("Submit");
		submitAnswerBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (askQuestion() == false) return; // No more questions can be asked!
				String temp = answerTextbox.getText().trim();
				if (!temp.equals("") && (!temp.equals("\n")) && (!temp.equals("\n\n"))) ticketInformationTextbox.append(temp + "\n");
				answerTextbox.setText("");
				answerTextbox.setFocus();
			}
		});
		
		rightComposite = new Composite(shell, SWT.BORDER);
		rightComposite.setBounds(1270, 10, 610, 950);
		
		tips = new Text(rightComposite, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		ticketInformationTextbox.setFont(SWTResourceManager.getFont("Calibri Light", 11, SWT.NORMAL));
		tips.setBounds(10, 10, 588, 468);
		
		answerTextbox.setFocus();
	}

	private boolean askQuestion() {
		if (!sSteps.isDone()) {
			middleLabel.setText("Starting Scenario:");
			this.askInStartingSteps();
			if (!sSteps.isTicketHeadingPresent()) {
				ticketInformationTextbox.append("Starting Scenario:\n");
				sSteps.setTicketHeadingPresent(true);
			}
		} else if (!pSteps.isDone()) {
			middleLabel.setText("Physical Checks:");
			this.askInPhysicalSteps();
			if (!pSteps.isTicketHeadingPresent()) {
				ticketInformationTextbox.append("\nPhysical Checks:\n");
				pSteps.setTicketHeadingPresent(true);
			}
		} else if (!aSteps.isDone()) {
			middleLabel.setText("Additional Information:");
			this.askInAdditionalSteps();
			if (!aSteps.isTicketHeadingPresent()) {
				ticketInformationTextbox.append("\nAdditional Information:\n");
				aSteps.setTicketHeadingPresent(true);
			}
		} else if (!cSteps.isDone()) {
			middleLabel.setText("Configure Network:");
			this.askInConfigurationSteps();
			if (!cSteps.isTicketHeadingPresent()) {
				ticketInformationTextbox.append("\nConfigure Network:\n");
				cSteps.setTicketHeadingPresent(true);
			}
		} else if (!iSteps.isDone()) {
			middleLabel.setText("Identity and Security:");
			this.askInIdAndSecuritySteps();
			if (!iSteps.isTicketHeadingPresent()) {
				ticketInformationTextbox.append("\nIdentity and Security:\n");
				iSteps.setTicketHeadingPresent(true);
			}
		} else if (!oSteps.isDone()) {
			middleLabel.setText("Others:");
			this.askInOtherSteps();
			if (!oSteps.isTicketHeadingPresent()) {
				ticketInformationTextbox.append("\nOthers:\n");
				oSteps.setTicketHeadingPresent(true);
			}
		} else {
			this.finishTicket();
			return false;
		}
		return true;
	}

	private void askInStartingSteps() {
		QuestionNode[] questions = sSteps.getQuestions();
		for (int i = 0; i < sSteps.getNumOfQuestions(); i++) {
			if (!questions[i].answered) {
				questionTextbox.setText(questions[i].getStringQuestion().replaceFirst("^\\* ", ""));
				String tip = questions[i].getTips()[0];
				for (int j = 1; j < questions[i].getNumOfTips(); j++) tip = tip + "\n" + questions[i].getTips()[j];
				tips.setText(tip);
				questions[i].answered = true;
				return;
			}
		}
		sSteps.checkIfDone();
		if (sSteps.isDone()) {
			askQuestion();
		}
	}
	
	private void askInPhysicalSteps() {
		QuestionNode[] questions = pSteps.getQuestions();
		for (int i = 0; i < pSteps.getNumOfQuestions(); i++) {
			if (!questions[i].answered) {
				questionTextbox.setText(questions[i].getStringQuestion().replaceFirst("^\\* ", ""));
				String tip = "";
				if (questions[i].getNumOfTips() > 0) {
					tip = questions[i].getTips()[0];
				}
				if (questions[i].getNumOfTips() > 1) {
					for (int j = 1; j < questions[i].getNumOfTips(); j++) tip = tip + "\n" + questions[i].getTips()[j];
				}
				tips.setText(tip);
				questions[i].answered = true;
				return;
			}
		}
		pSteps.checkIfDone();
		if (pSteps.isDone()) {
			askQuestion();
		}
	}
	
	private void askInAdditionalSteps() {
		QuestionNode[] questions = aSteps.getQuestions();
		for (int i = 0; i < aSteps.getNumOfQuestions(); i++) {
			if (!questions[i].answered) {
				questionTextbox.setText(questions[i].getStringQuestion().replaceFirst("^\\* ", ""));
				String tip = "";
				if (questions[i].getNumOfTips() > 0) {
					tip = questions[i].getTips()[0];
				}
				if (questions[i].getNumOfTips() > 1) {
					for (int j = 1; j < questions[i].getNumOfTips(); j++) tip = tip + "\n" + questions[i].getTips()[j];
				}
				tips.setText(tip);
				questions[i].answered = true;
				return;
			}
		}
		aSteps.checkIfDone();
		if (aSteps.isDone()) {
			askQuestion();
		}
	}
	
	private void askInConfigurationSteps() {
		QuestionNode[] questions = cSteps.getQuestions();
		for (int i = 0; i < cSteps.getNumOfQuestions(); i++) {
			if (!questions[i].answered) {
				questionTextbox.setText(questions[i].getStringQuestion().replaceFirst("^\\* ", ""));
				String tip = "";
				if (questions[i].getNumOfTips() > 0) {
					tip = questions[i].getTips()[0];
				}
				if (questions[i].getNumOfTips() > 1) {
					for (int j = 1; j < questions[i].getNumOfTips(); j++) tip = tip + "\n" + questions[i].getTips()[j];
				}
				tips.setText(tip);
				questions[i].answered = true;
				return;
			}
		}
		cSteps.checkIfDone();
		if (cSteps.isDone()) {
			askQuestion();
		}
	}
	

	private void askInIdAndSecuritySteps() {
		QuestionNode[] questions = iSteps.getQuestions();
		for (int i = 0; i < iSteps.getNumOfQuestions(); i++) {
			if (!questions[i].answered) {
				questionTextbox.setText(questions[i].getStringQuestion().replaceFirst("^\\* ", ""));
				String tip = "";
				if (questions[i].getNumOfTips() > 0) {
					tip = questions[i].getTips()[0];
				}
				if (questions[i].getNumOfTips() > 1) {
					for (int j = 1; j < questions[i].getNumOfTips(); j++) tip = tip + "\n" + questions[i].getTips()[j];
				}
				tips.setText(tip);
				questions[i].answered = true;
				return;
			}
		}
		iSteps.checkIfDone();
		if (iSteps.isDone()) {
			askQuestion();
		}
	}
	
	private void askInOtherSteps() {
		QuestionNode[] questions = oSteps.getQuestions();
		for (int i = 0; i < oSteps.getNumOfQuestions(); i++) {
			if (!questions[i].answered) {
				questionTextbox.setText(questions[i].getStringQuestion().replaceFirst("^\\* ", ""));
				String tip = "";
				if (questions[i].getNumOfTips() > 0) {
					tip = questions[i].getTips()[0];
				}
				if (questions[i].getNumOfTips() > 1) {
					for (int j = 1; j < questions[i].getNumOfTips(); j++) tip = tip + "\n" + questions[i].getTips()[j];
				}
				tips.setText(tip);
				questions[i].answered = true;
				return;
			}
		}
		oSteps.checkIfDone();
		if (oSteps.isDone()) {
			submitAnswerBtn.dispose();
			answerTextbox.setVisible(false);
			ticketInformationTextbox.setFocus();
		}
	}

	private void disposeComposites() {
		if (!generalNotes.isDisposed()) this.saveNotes();
		leftComposite.dispose();
		middleComposite.dispose();
		rightComposite.dispose();
	}

	private void saveNotes() {
		notes = generalNotes.getText();
	}
	
	private void saveTicketInfo() {
		ticketString = ticketInformationTextbox.getText();
	}
	
	private void toggleNotesView(Button viewSwitch) {

		if (viewSwitch.getSelection() == true) {
			this.saveTicketInfo();
			ticketInformationTextbox.dispose();
			ticketLabel.dispose();
			
			generalNotes = new Text(leftComposite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
			generalNotes.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
			generalNotes.setBounds(10, 60, 588, 828);
			generalNotes.setText(notes);
			
			notesLabel = new Label(leftComposite, SWT.NONE);
			notesLabel.setFont(SWTResourceManager.getFont("Calibri Light", 14, SWT.NORMAL));
			notesLabel.setBounds(10, 10, 200, 44);
			notesLabel.setText("Notes for the Night:");
			
			if (!submitAnswerBtn.isDisposed()) submitAnswerBtn.setVisible(false);
			finishTicketBtn.setVisible(false);
			
		} else {
			
			this.saveNotes();
			generalNotes.dispose();
			notesLabel.dispose();
			
			ticketInformationTextbox = new Text(leftComposite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
			ticketInformationTextbox.setFont(SWTResourceManager.getFont("Calibri Light", 11, SWT.NORMAL));
			ticketInformationTextbox.setBounds(10, 60, 588, 828);
			ticketInformationTextbox.setText(ticketString);
			
			ticketLabel = new Label(leftComposite, SWT.NONE);
			ticketLabel.setFont(SWTResourceManager.getFont("Calibri Light", 14, SWT.NORMAL));
			ticketLabel.setBounds(10, 10, 206, 44);
			ticketLabel.setText("Ticket Information:");			
			
			if (!submitAnswerBtn.isDisposed()) submitAnswerBtn.setVisible(true);
			finishTicketBtn.setVisible(true);
		}
	}
	
	private void toggleNotesLastTicketView() {
		showLastTicketBtn.setEnabled(false);
		notesLabel.setText("Last Ticket's Information:");
		saveNotes();
		
		Text previousTicketTextbox = new Text(leftComposite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		previousTicketTextbox.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		previousTicketTextbox.setBounds(10, 60, 588, 828);
		previousTicketTextbox.setText(lastTicket);
		previousTicketTextbox.setEditable(false);
		generalNotes.setVisible(false);
		
		Button backBtn = new Button(leftComposite, SWT.NONE);
		backBtn.setText("Back to General Notes");
		backBtn.setBounds(10, 894, 588, 44);
		backBtn.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.BOLD));
		backBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				notesLabel.setText("Notes for the Night:");
				previousTicketTextbox.dispose();
				showLastTicketBtn.setEnabled(true);
				generalNotes.setVisible(true);
				backBtn.dispose();
			}
		});
	}
	
	private void finishTicket() {
		MessageBox finishTicketConfirmation = new MessageBox(shell, SWT.NO | SWT.YES);
		finishTicketConfirmation.setText("Confirmation of Ticket Closing");
		finishTicketConfirmation.setMessage("Are you sure you want to close this ticket? (You may not be able to recover this ticket later)");
		int answer = finishTicketConfirmation.open();
		lastTicket = ticketInformationTextbox.getText();
		if (answer == SWT.YES) {
			disposeComposites();
			createContents();
		}
	}
	
	private void openURL(String URL) {
		if (Desktop.isDesktopSupported()) {
			Desktop desk = Desktop.getDesktop();
			try {
				desk.browse(new URI(URL));
			} catch (Exception e2) {
				MessageBox errorBox = new MessageBox(shell);
				errorBox.setText("Error: Cannot open browser");
				errorBox.setMessage("Error opening browser from HermesScript, try opening it manually");
				errorBox.open();
			}
		}	
	}
}
