package mydemo1;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.wb.swt.SWTResourceManager;


public class AdminscoreMana {
	  private Shell shell;
	  public User user;
	public AdminscoreMana(User user ) {
		super();
		this.user = user;
		shell=new Shell(SWT.SHELL_TRIM);
		shell.setText("\u7BA1\u7406\u5458\u7A97\u53E3");
		shell.setSize(574, 463);
		shell.setLayout(new GridLayout(3, true));
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setText("\u6B22\u8FCE\u4F7F\u7528\u7B80\u6613\u5B66\u751F\u6210\u7EE9\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 22, SWT.NORMAL));
		GridData gd_lblNewLabel = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 3, 1);
		gd_lblNewLabel.heightHint = 95;
		gd_lblNewLabel.widthHint = 559;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.NORMAL));
		GridData gd_lblNewLabel_1 = new GridData(SWT.CENTER, SWT.BOTTOM, false, false, 3, 1);
		gd_lblNewLabel_1.heightHint = 44;
		lblNewLabel_1.setLayoutData(gd_lblNewLabel_1);
		lblNewLabel_1.setText("\u7CFB\u7EDF\u7BA1\u7406");
		
		Button btnSet = new Button(shell, SWT.NONE);
		btnSet.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnSet.setText("\u4E13\u4E1A\u4E0E\u8BFE\u7A0B\u8BBE\u7F6E");
		
		Button btnUserlogin = new Button(shell, SWT.NONE);
		
		GridData gd_btnNewButton_2 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton_2.widthHint = 142;
		btnUserlogin.setLayoutData(gd_btnNewButton_2);
		btnUserlogin.setText("\u7528\u6237\u6CE8\u518C");
		
		Button btnStdSele = new Button(shell, SWT.NONE);
		
		btnStdSele.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnStdSele.setText("\u5206\u6D3E\u5B66\u751F");
		
		btnSet.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {			
			    try {
					Display display = Display.getDefault();
					InitDept thisclass =new InitDept();
					thisclass.getShell().open();
					while (!thisclass.getShell().isDisposed()) {
						if (!display.readAndDispatch()) {
							display.sleep();
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}  
			}
		});
		
		btnUserlogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell oldshell2=null;
				oldshell2=shell;				
				oldshell2.dispose();
			    try {
					Display display = Display.getDefault();
					RgisterTabFolder thisclass =new RgisterTabFolder();
					thisclass.getShell().open();
					while (!thisclass.getShell().isDisposed()) {
						if (!display.readAndDispatch()) {
							display.sleep();
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}  
			}
		});
		
		btnStdSele.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			    try {
					Display display = Display.getDefault();
					StudentSelect thisclass=new StudentSelect();
					thisclass.getShell().open();
					while (!thisclass.getShell().isDisposed()) {
						if (!display.readAndDispatch()) {
							display.sleep();
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}  
			}
		});
	}
	public Shell getShell() {
		return shell;
	}
	
}
