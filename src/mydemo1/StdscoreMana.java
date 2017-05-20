package mydemo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class StdscoreMana{
	private Student student=null;
	private Shell shell;
	public User user;
	private Text textStdNum;
	private Text textStdName;
	private Text textClassName;
	private Text textClassScores;
	private int index;
	private Combo comboStdOPSele;




	public StdscoreMana(User  user) {
		super();
		this.user = user;	
	    LinkedList<Student>stdList=null;
		   try {  //读取磁盘文件，并实例化当前学生	   
		    FileInputStream fis=new FileInputStream("stdList.obj");
		    ObjectInputStream ois=new ObjectInputStream(fis);
		    stdList =(LinkedList<Student>) ois.readObject();  //得到当前学生列表
		    ois.close();
		    fis.close();
		    for (Student std:stdList) {   //检测用户的合法性
				String stdNum= "" + std.getId();
				System.out.println("我是臭虫一号，我的值是："+stdNum);
				if (stdNum.equals(user.getName())) {
					student =std;
					System.out.println("我是臭虫二号，我的值是："+student.getId());
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		shell=new Shell(SWT.SHELL_TRIM);
		shell.setSize(600, 418);
		shell.setText("\u767B\u5F55\u6210\u529F");
		shell.setLayout(new GridLayout(1, false));
		System.out.println("我是臭虫三号，我的值是："+student.getName());	  	
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblNewLabel.setText("\u6B22\u8FCE\u60A8\u4F7F\u7528\u5B66\u751F\u6210\u7EE9\u7BA1\u7406\u7CFB\u7EDF");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite = new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1);
		gd_composite.heightHint = 332;
		gd_composite.widthHint = 564;
		composite.setLayoutData(gd_composite);
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayout(new GridLayout(2, false));
		
		Composite composite_2 = new Composite(composite_1, SWT.NONE);
		composite_2.setLayout(new GridLayout(3, false));
		GridData gd_composite_2 = new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1);
		gd_composite_2.widthHint = 251;
		gd_composite_2.heightHint = 327;
		composite_2.setLayoutData(gd_composite_2);
		
		Label lblNewLabel_1 = new Label(composite_2, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 3, 1));
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setText("\u6210\u7EE9\u6570\u636E");
		
		Label lblNewLabel_2 = new Label(composite_2, SWT.NONE);
		lblNewLabel_2.setText("\u5B66\u53F7\uFF1A");
		new Label(composite_2, SWT.NONE);
		
		textStdNum = new Text(composite_2, SWT.BORDER | SWT.READ_ONLY);
		textStdNum.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textStdNum.setText(""+student.getId());
		
		Label lblNewLabel_3 = new Label(composite_2, SWT.NONE);
		lblNewLabel_3.setText("\u59D3\u540D\uFF1A");
		new Label(composite_2, SWT.NONE);
		
		textStdName = new Text(composite_2, SWT.BORDER | SWT.READ_ONLY);
		textStdName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textStdName.setText(student.getName());
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Label label = new Label(composite_2, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
		gd_label.widthHint = 241;
		label.setLayoutData(gd_label);
		
		Label lblNewLabel_4 = new Label(composite_2, SWT.NONE);
		lblNewLabel_4.setText("\u8BFE\u7A0B\u540D");
		new Label(composite_2, SWT.NONE);
		
		Label lblNewLabel_5 = new Label(composite_2, SWT.NONE);
		lblNewLabel_5.setText("\u6210\u7EE9");
		
		textClassName = new Text(composite_2, SWT.BORDER | SWT.READ_ONLY);
		textClassName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite_2, SWT.NONE);
		
		textClassScores = new Text(composite_2, SWT.BORDER | SWT.READ_ONLY);
		textClassScores.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Composite composite_3 = new Composite(composite_1, SWT.NONE);
		composite_3.setLayout(new FillLayout(SWT.VERTICAL));
		GridData gd_composite_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_3.heightHint = 317;
		gd_composite_3.widthHint = 293;
		composite_3.setLayoutData(gd_composite_3);
		
		Label lblNewLabel_6 = new Label(composite_3, SWT.CENTER);
		lblNewLabel_6.setText("\u64CD\u4F5C\u83DC\u5355");
		
		Button btnNewButton = new Button(composite_3, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				index=0;
				updateLeft();
			}
		});
		btnNewButton.setText("\u7B2C\u4E00\u95E8\u8BFE\u7A0B");
		
		updateLeft();
		
		
		
		Button btnNewButton_1 = new Button(composite_3, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (index<student.getCourseList().size()-1) {
					index++;
					System.out.println(index);
					updateLeft();
				}else {
					index=0;
					updateLeft();//以索引index为媒介，更新当前课程的名字和成绩
				}
			}
		});
		btnNewButton_1.setText("\u4E0B\u4E00\u95E8\u8BFE\u7A0B");
		
		Button btnNewButton_2 = new Button(composite_3, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (index >0) {
					index--;
					updateLeft();
				}else {
					index=student.getCourseList().size()-1;
					updateLeft();//以索引index为媒介，更新当前课程的名字和成绩
				}
			}
		});
		btnNewButton_2.setText("\u4E0A\u4E00\u95E8\u8BFE\u7A0B");
		
		Button btnNewButton_3 = new Button(composite_3, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				index=student.getCourseList().size()-1;
				updateLeft();//以索引index为媒介，更新当前课程的名字和成绩
				
			}
		});
		btnNewButton_3.setText("\u6700\u540E\u4E00\u95E8\u8BFE\u7A0B");
		
		comboStdOPSele = new Combo(composite_3, SWT.NONE);
		comboStdOPSele.setText("\u8BFE\u7A0B\u540D\uFF1F");
		for (Course course:student.getCourseList()) {
			comboStdOPSele.add(course.getname());
		}
		comboStdOPSele.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent arg0) {
				int idx=comboStdOPSele.getSelectionIndex();
				String seleCN=comboStdOPSele.getItem(idx);
				if (seleCN!=null&&!seleCN.equals("")) {
					for (int i = 0; i <student.getCourseList().size(); i++) {
						Course course =student.getCourseList().get(i);
						if (course.getname().equals(seleCN)) {
							index=i;
							updateLeft();
							break;
						}
					}
				}
			}
		});
		
	}

  private void updateLeft() {   //以索引index为媒介，更新当前课程的名字和成绩
		ArrayList<Course>courseList=student.getCourseList();
		textClassName.setText(courseList.get(index).getname());
		textClassScores.setText(""+courseList.get(index).getscore());
	}

public Shell getShell(){
	  return shell;
  }

}
