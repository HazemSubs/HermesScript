//import org.eclipse.swt.SWT;
//import org.eclipse.swt.events.SelectionAdapter;
//import org.eclipse.swt.events.SelectionEvent;
//import org.eclipse.swt.layout.GridData;
//import org.eclipse.swt.layout.GridLayout;
//import org.eclipse.swt.widgets.Button;
//import org.eclipse.swt.widgets.Composite;
//import org.eclipse.swt.widgets.Label;
//import org.eclipse.swt.widgets.Shell;
//import org.eclipse.swt.widgets.Text;
//import org.eclipse.wb.swt.SWTResourceManager;
//
//public class ViewerCreator {
//	
//	DataManipulator data;
//	StartingSteps sSteps;
//	private Composite leftComposite;
//	private Composite rightComposite;
//	private Composite middleComposite;
//	private StartingSteps startingSteps;
//	
//	public ViewerCreator() {
//		data = new DataManipulator();
//	}
//	
//	public Shell initializeShell() {
//		Shell shell = new Shell();
//		shell.setSize(1920, 1080);
//		shell.setText("HermesScript");
//		shell.setLayout(new GridLayout(10, false));
//		return shell;
//	}
//
//	public void initializeMainScreen(Shell shell, Text generalNotes, Text remindersText) {
//		leftComposite = new Composite(shell, SWT.BORDER);
//		GridData gd_leftComposite = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
//		gd_leftComposite.heightHint = 980;
//		gd_leftComposite.widthHint = 520;
//		leftComposite.setLayoutData(gd_leftComposite);
//		
//		Label notesLabel = new Label(leftComposite, SWT.NONE);
//		notesLabel.setFont(SWTResourceManager.getFont("Calibri Light", 14, SWT.NORMAL));
//		notesLabel.setBounds(10, 10, 200, 44);
//		notesLabel.setText("Notes for the Night:");
//		
//		generalNotes = new Text(leftComposite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
//		generalNotes.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
//		generalNotes.setBounds(10, 60, 500, 800);
//		
//		middleComposite = new Composite(shell, SWT.BORDER);		
//		middleComposite.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
//		
//		Button troubleshootBtn = new Button(middleComposite, SWT.NONE);
//		troubleshootBtn.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				initializeTroubleshooting(shell);
//				shell.layout();
//			}
//		});
//		troubleshootBtn.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
//		troubleshootBtn.setBounds(0, 446, 370, 90);
//		troubleshootBtn.setText("New Ticket");
//		
//		rightComposite = new Composite(shell, SWT.BORDER);
//		GridData gd_rightComposite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
//		gd_rightComposite.heightHint = 980;
//		gd_rightComposite.widthHint = 1000;
//		rightComposite.setLayoutData(gd_rightComposite);
//		
//		remindersText = new Text(rightComposite, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
//		remindersText.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
//		remindersText.setBounds(10, 10, 980, 960);
//		remindersText.setText(data.getReminders());
//		
//	}
//	
//	// Starting Steps
//	public Shell initalizeStartingsStepsScreen() {
//		return null;
//	}
////	public Shell initializeTroubleshooting(Shell shell) {
////		shell = new Shell();
////		shell.setSize(1920, 1080);
////		shell.setText("SWT Application");
////		shell.setLayout(null);
////		
////		leftComposite = new Composite(shell, SWT.BORDER);
////		leftComposite.setBounds(10, 10, 610, 950);
////		
////		Label ticketLabel = new Label(leftComposite, SWT.NONE);
////		ticketLabel.setFont(SWTResourceManager.getFont("Calibri Light", 14, SWT.NORMAL));
////		ticketLabel.setBounds(10, 10, 206, 44);
////		ticketLabel.setText("Ticket Information:");
////		
////		Text ticketInformationTextbox = new Text(leftComposite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
////		ticketInformationTextbox.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
////		ticketInformationTextbox.setBounds(10, 60, 588, 878);
////		
////		Button notesSwitch = new Button(leftComposite, SWT.CHECK);
////		notesSwitch.setFont(SWTResourceManager.getFont("Calibri Light", 14, SWT.NORMAL));
////		notesSwitch.setBounds(392, 10, 206, 44);
////		notesSwitch.setText("Notes View");
////		
////		middleComposite = new Composite(shell, SWT.BORDER);
////		middleComposite.setBounds(640, 10, 610, 950);
////		
////		Text questionTextbox = new Text(middleComposite, SWT.BORDER | SWT.READ_ONLY);
////		questionTextbox.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
////		questionTextbox.setBounds(10, 60, 588, 82);
////		
////		Label middleLabel = new Label(middleComposite, SWT.NONE);
////		middleLabel.setAlignment(SWT.CENTER);
////		middleLabel.setFont(SWTResourceManager.getFont("Calibri Light", 14, SWT.NORMAL));
////		middleLabel.setBounds(10, 10, 588, 44);
////		middleLabel.setText("Starting Scenario:");
////		
////		Text answerTextbox = new Text(middleComposite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
////		answerTextbox.setBounds(10, 148, 588, 790);
////		
////		rightComposite = new Composite(shell, SWT.BORDER);
////		rightComposite.setBounds(1270, 10, 610, 950);
////		
////		Text Tips = new Text(rightComposite, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
////		Tips.setBounds(10, 10, 588, 468);
////		
////		shell.layout();
////		
////		return shell;
////		
////	}
//
//}
