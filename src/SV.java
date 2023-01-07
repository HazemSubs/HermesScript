import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class SV {

	protected Shell shell;
	private Text ticketInformationTextbox;
	private Text questionTextbox;
	private Text answerTextbox;
	private Text Tips;

	/**
	 * Launch the application.
	 * @param args
	 */
//	public static void main(String[] args) {
//		try {
//			SV window = new SV();
//			window.open();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1920, 1080);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Composite leftComposite = new Composite(shell, SWT.BORDER);
		leftComposite.setBounds(10, 10, 610, 950);
		
		Label ticketLabel = new Label(leftComposite, SWT.NONE);
		ticketLabel.setFont(SWTResourceManager.getFont("Calibri Light", 14, SWT.NORMAL));
		ticketLabel.setBounds(10, 10, 206, 44);
		ticketLabel.setText("Ticket Information:");
		
		ticketInformationTextbox = new Text(leftComposite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		ticketInformationTextbox.setFont(SWTResourceManager.getFont("Calibri Light", 10, SWT.NORMAL));
		ticketInformationTextbox.setBounds(10, 60, 588, 828);
		
		Button notesSwitch = new Button(leftComposite, SWT.RADIO);
		notesSwitch.setFont(SWTResourceManager.getFont("Calibri Light", 14, SWT.NORMAL));
		notesSwitch.setBounds(392, 10, 206, 44);
		notesSwitch.setText("Notes View");
		
		Button btnFinishTicket = new Button(leftComposite, SWT.NONE);
		btnFinishTicket.setText("Finish Ticket\r\n");
		btnFinishTicket.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.BOLD));
		btnFinishTicket.setBounds(10, 894, 588, 44);
		
		Composite middleComposite = new Composite(shell, SWT.BORDER);
		middleComposite.setBounds(640, 10, 610, 950);
		
		questionTextbox = new Text(middleComposite, SWT.BORDER | SWT.READ_ONLY);
		questionTextbox.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		questionTextbox.setBounds(10, 60, 588, 142);
		
		Label middleLabel = new Label(middleComposite, SWT.NONE);
		middleLabel.setAlignment(SWT.CENTER);
		middleLabel.setFont(SWTResourceManager.getFont("Calibri Light", 14, SWT.NORMAL));
		middleLabel.setBounds(10, 10, 588, 44);
		middleLabel.setText("Starting Scenario:");
		
		answerTextbox = new Text(middleComposite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		answerTextbox.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		answerTextbox.setBounds(10, 208, 588, 680);

		Button submitAnswerBtn = new Button(middleComposite, SWT.NONE);
		submitAnswerBtn.setBounds(10, 894, 588, 44);
		submitAnswerBtn.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.BOLD));
		submitAnswerBtn.setText("Submit\r\n");
		submitAnswerBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox finishTicketConfirmation = new MessageBox(shell);
				finishTicketConfirmation.setText("Error");
				finishTicketConfirmation.setMessage("Error opening browser from HermesScript, try opening it manually");
				int answer = finishTicketConfirmation.open();
			}
		});
		
		Composite rightComposite = new Composite(shell, SWT.BORDER);
		rightComposite.setBounds(1270, 10, 610, 950);
//		
//		MessageBox finishTicketConfirmation = new MessageBox(shell, SWT.YES | SWT.NO);
//		finishTicketConfirmation.setText("Ticket Finish Confirmation");
//		finishTicketConfirmation.setMessage("Are you sure you want to close this ticket (You may not be able to recover your work later)");
//		finishTicketConfirmation.open();
		
		Tips = new Text(rightComposite, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		Tips.setBounds(10, 10, 588, 468);
//		driver.close();

	}
}
