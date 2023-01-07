import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;

public class InformationDialog extends Dialog {

	protected Object result;
	protected Shell shlTicketInformation;
	private Button wiredBtn, wirelessBtn, gamingBtn, freeFormBtn, finalizeBtn;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public InformationDialog(Shell parent, int style) {
		super(parent, style);
		setText("Ticket Information");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlTicketInformation.open();
		shlTicketInformation.layout();
		Display display = getParent().getDisplay();
		while (!shlTicketInformation.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlTicketInformation = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.PRIMARY_MODAL);
		shlTicketInformation.setSize(336, 425);
		shlTicketInformation.setText("Ticket Information");
		
		Group grpTicketType = new Group(shlTicketInformation, SWT.NONE);
		grpTicketType.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		grpTicketType.setText("Ticket Type");
		grpTicketType.setBounds(10, 10, 300, 179);
		
		wiredBtn = new Button(grpTicketType, SWT.RADIO);
		wiredBtn.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		wiredBtn.setBounds(10, 30, 280, 30);
		wiredBtn.setText("Wired");
		
		wirelessBtn = new Button(grpTicketType, SWT.RADIO);
		wirelessBtn.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		wirelessBtn.setText("Wireless");
		wirelessBtn.setBounds(10, 66, 280, 30);
		
		gamingBtn = new Button(grpTicketType, SWT.RADIO);
		gamingBtn.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		gamingBtn.setText("Gaming");
		gamingBtn.setBounds(10, 102, 280, 30);
		
		freeFormBtn = new Button(grpTicketType, SWT.RADIO);
		freeFormBtn.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		freeFormBtn.setText("Free Form");
		freeFormBtn.setBounds(10, 138, 280, 30);
		
		finalizeBtn = new Button(shlTicketInformation, SWT.NONE);
		finalizeBtn.setFont(SWTResourceManager.getFont("Calibri Light", 12, SWT.NORMAL));
		finalizeBtn.setBounds(10, 195, 300, 30);
		finalizeBtn.setText("Submit");
		finalizeBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				submitted();
			}
		});

	}
	
	private void submitted() {
		if (wiredBtn.getSelection()) result = wiredBtn.getText().toLowerCase();
		if (wirelessBtn.getSelection()) result = wirelessBtn.getText().toLowerCase();
		if (gamingBtn.getSelection()) result = gamingBtn.getText().toLowerCase();
		if (freeFormBtn.getSelection()) result = freeFormBtn.getText().toLowerCase();
		shlTicketInformation.dispose();
	}
}
