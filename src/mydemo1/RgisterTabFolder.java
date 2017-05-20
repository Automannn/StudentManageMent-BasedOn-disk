package mydemo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

import com.sun.org.apache.bcel.internal.classfile.Field;

import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class RgisterTabFolder{
	private Shell shell;
	private LinkedList<Student>stdList;
	private LinkedList<Teacher>tchList;
	private LinkedList<Department>departmentlist;
	private Department depart;
	private Student currStudent;
	private Teacher currTeacher;
	private int preTI;
	private Text textStdNum;
	private Text textStdName;
	private Text textStdGrade;
	private Text textStdClass;
	private Text textStdInterest;
	private Text textTchNum;
	private Text textTchName;
	private Text textTchAge;
	private Text textAreaTchAddr;
	private Text textTchIntro;
	private Label labelStdPic;
	private Label labelScoresTitle;
	private TabItem tabItemStd;
	private TabItem tabItemTch;
	private TabItem tabItemCourse;
	private Combo comboScoresDept;
	private Combo comboStdDept;
	private Composite groupScoresCommonList;
	private Composite groupScoresDeptOrienList;
	private Composite groupScoresDeptBasesList;
	private Button btnScoresClose;
	private Button btnQuit;
	private Combo comboTchDept;
	private Label labelTchImg;

	public RgisterTabFolder() throws IOException {
		super();
		
	    shell=new Shell( SWT.SHELL_TRIM);
	    shell.setSize(781, 534);
	    shell.setText("\u6CE8\u518C\u754C\u9762");
		shell .setLayout(new FillLayout(SWT.HORIZONTAL));
		
		TabFolder tabFolder = new TabFolder(shell , SWT.BORDER);
		
		tabItemStd = new TabItem(tabFolder, SWT.NONE);
		tabItemStd.setText("\u5B66\u751F\u6CE8\u518C");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tabItemStd.setControl(composite);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite_2 = new Composite(composite_1, SWT.NONE);
		composite_2.setLayout(new GridLayout(2, false));
		
		Composite composite_3 = new Composite(composite_2, SWT.NONE);
		composite_3.setLayout(new GridLayout(2, true));
		GridData gd_composite_3 = new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1);
		gd_composite_3.exclude = true;
		gd_composite_3.heightHint = 420;
		gd_composite_3.widthHint = 295;
		composite_3.setLayoutData(gd_composite_3);
		
		Composite composite_4 = new Composite(composite_2, SWT.NONE);
		GridLayout gl_composite_4 = new GridLayout(3, false);
		gl_composite_4.horizontalSpacing = 20;
		gl_composite_4.verticalSpacing = 30;
		composite_4.setLayout(gl_composite_4);
		GridData gd_composite_4 = new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1);
		gd_composite_4.heightHint = 374;
		gd_composite_4.widthHint = 313;
		composite_4.setLayoutData(gd_composite_4);
		
		Label lblNewLabel = new Label(composite_4, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("\u5B66\u53F7\uFF1A");
		new Label(composite_4, SWT.NONE);
		
		textStdNum = new Text(composite_4, SWT.BORDER);
		textStdNum.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_1 = new Label(composite_4, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("\u59D3\u540D\uFF1A");
		new Label(composite_4, SWT.NONE);
		
		textStdName = new Text(composite_4, SWT.BORDER);
		textStdName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_2 = new Label(composite_4, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_2.setText("\u4E13\u4E1A\uFF1A");
		new Label(composite_4, SWT.NONE);
		
		comboStdDept = new Combo(composite_4, SWT.READ_ONLY);
		comboStdDept.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		if (departmentlist==null) {
			readDeptList();   //���רҵ�б�Ϊ�գ����ȡdeptList.obj�ļ���������һ��רҵ�б�
			for (Department department:departmentlist) {
				comboStdDept.add(department.getName());   //����רҵ�б��е�ÿһ��רҵ������ӵ�ѧ��ѡ��רҵ����ѡ��
				departmentlist=null;  //���רҵ�б��ڴ�
			}
		}
		
		Label lblNewLabel_3 = new Label(composite_4, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_3.setText("\u5E74\u7EA7\uFF1A");
		new Label(composite_4, SWT.NONE);
		
		textStdGrade = new Text(composite_4, SWT.BORDER);
		textStdGrade.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_4 = new Label(composite_4, SWT.NONE);
		lblNewLabel_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_4.setText("\u73ED\u7EA7\uFF1A");
		new Label(composite_4, SWT.NONE);
		
		textStdClass = new Text(composite_4, SWT.BORDER);
		textStdClass.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite_4, SWT.NONE);
		
		Button btnStdToScores = new Button(composite_4, SWT.NONE);
		btnStdToScores.setText("\u8BFE\u7A0B\u9009\u62E9");
		
		stdList=new LinkedList<Student>();  //ʵ����һ��ѧ��ע�������б�
		btnStdToScores.addSelectionListener(new SelectionAdapter() {
			

			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					
					int stdNum=Integer.parseInt(textStdNum.getText().trim());    //�õ�ѧ����ѧ��
					for (Student std:stdList) {   //����ѧ���б��е�ÿһ��ѧ�������ѧ���Ƿ��ظ�
						if (stdNum==std.getId()) {
							MessageDialog.openInformation(shell, "ѧ���ظ�", "��ѧ��ѧ�������Ѿ����ڣ�");
							return;
						}
					}
				    String stdName =textStdName.getText().trim();
				    updateDpart(comboStdDept);  //���רҵ�ĺϷ��ԣ�����ѡ�е�רҵ��ֵ��Depart
				    Department department=depart;   //ʵ����һ��רҵ����Depart���ڴ渳����
				    int grade=Integer.parseInt(textStdGrade.getText().trim());
				    int cClass=Integer.parseInt(textStdClass.getText());
				    String stdPicImg=labelStdPic.getText()==null||labelStdPic.getText().equals("")?"":labelStdPic.getText();
				    String stdInterest=textStdInterest.getText()==null||textStdInterest.getText().equals("")?"":textStdInterest.getText();
				    currStudent=new Student(stdNum, stdName, department, grade, cClass, stdPicImg, stdInterest);   //ʵ����һ����ǰѧ���Ķ���
				    preTI = tabFolder.getSelectionIndex();
				    labelScoresTitle.setText(currStudent.getName()+"ͬѧ ѡ��γ�");
				    comboScoresDept.setText(depart.getName());
				    clearLastClassList();    //��ʼ���γ��б����
				    addCourseItem();  //���µ�ǰѧ����ѡרҵ�����õ���רҵ�Ŀγ��б�����ʾ����
				    tabFolder.setSelection(tabItemCourse);
				} catch (NullPointerException ee) {
					MessageDialog.openInformation(shell, "���ݲ�����", "ѧ�ţ�������רҵ���꼶�Ͱ༶����Ϊ�գ�");  
				}catch (NumberFormatException ee1) {
					MessageDialog.openInformation(shell, "���ݲ���ȷ", "ѧ�ţ��꼶�Ͱ༶ӦΪ������");
				}
			}

			
		});
		
		new Label(composite_4, SWT.NONE);
		
		Composite composite_5 = new Composite(composite_2, SWT.NONE);
		GridLayout gl_composite_5 = new GridLayout(2, false);
		gl_composite_5.verticalSpacing = 80;
		composite_5.setLayout(gl_composite_5);
		GridData gd_composite_5 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_composite_5.heightHint = 381;
		gd_composite_5.widthHint = 309;
		composite_5.setLayoutData(gd_composite_5);
		
		Label lblNewLabel_5 = new Label(composite_5, SWT.NONE);
		lblNewLabel_5.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false, 1, 1));
		lblNewLabel_5.setText("\u7167\u7247\uFF1A");
		
		Composite composite_6 = new Composite(composite_5, SWT.BORDER);
		composite_6.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite_6 = new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1);
		gd_composite_6.heightHint = 114;
		gd_composite_6.widthHint = 123;
		composite_6.setLayoutData(gd_composite_6);
		
	    labelStdPic = new Label(composite_6, SWT.NONE);
		labelStdPic.setText("New Label");
		
		Label lblNewLabel_6 = new Label(composite_5, SWT.NONE);
		lblNewLabel_6.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false, 1, 1));
		lblNewLabel_6.setText("\u5174\u8DA3\u7231\u597D\uFF1A");
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(composite_5, SWT.BORDER | SWT.V_SCROLL);
		GridData gd_scrolledComposite = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_scrolledComposite.heightHint = 151;
		gd_scrolledComposite.widthHint = 160;
		scrolledComposite.setLayoutData(gd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		textStdInterest = new Text(scrolledComposite, SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
		scrolledComposite.setContent(textStdInterest);
		scrolledComposite.setMinSize(textStdInterest.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		tabItemTch = new TabItem(tabFolder, SWT.NONE);
		tabItemTch.setText("\u6559\u5E08\u6CE8\u518C");
		
		Composite composite_7 = new Composite(tabFolder, SWT.NONE);
		tabItemTch.setControl(composite_7);
		composite_7.setLayout(new GridLayout(2, false));
		
		Composite composite_8 = new Composite(composite_7, SWT.NONE);
		composite_8.setLayout(new GridLayout(2, true));
		GridData gd_composite_8 = new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1);
		gd_composite_8.heightHint = 413;
		gd_composite_8.widthHint = 301;
		composite_8.setLayoutData(gd_composite_8);
		
		Label lblNewLabel_7 = new Label(composite_8, SWT.NONE);
		lblNewLabel_7.setText("\u5DE5\u53F7");
		
		textTchNum = new Text(composite_8, SWT.BORDER);
		textTchNum.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_8 = new Label(composite_8, SWT.NONE);
		lblNewLabel_8.setText("\u59D3\u540D");
		
		textTchName = new Text(composite_8, SWT.BORDER);
		textTchName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_9 = new Label(composite_8, SWT.NONE);
		lblNewLabel_9.setText("\u6027\u522B");
		
		Group group = new Group(composite_8, SWT.NONE);
		group.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_group = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_group.widthHint = 88;
		gd_group.heightHint = 26;
		group.setLayoutData(gd_group);
		
		Button btnRadioButtonM = new Button(group, SWT.RADIO);
		btnRadioButtonM.setText("\u7537");
		
		Button btnRadioButtonF = new Button(group, SWT.RADIO);
		btnRadioButtonF.setText("\u5973");
		
		Label lblNewLabel_10 = new Label(composite_8, SWT.NONE);
		lblNewLabel_10.setText("\u5E74\u9F84");
		
		textTchAge = new Text(composite_8, SWT.BORDER);
		textTchAge.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_11 = new Label(composite_8, SWT.NONE);
		lblNewLabel_11.setText("\u90E8\u95E8");
		
		comboTchDept = new Combo(composite_8, SWT.READ_ONLY);
		comboTchDept.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		if (departmentlist==null) {
			readDeptList();
			for (Department department:departmentlist) {
				comboTchDept.add(department.getName());
			}
		}
		
		Label lblNewLabel_12 = new Label(composite_8, SWT.NONE);
		lblNewLabel_12.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblNewLabel_12.setText("\u4F4F\u5740");
		
		ScrolledComposite scrolledComposite_1 = new ScrolledComposite(composite_8, SWT.BORDER | SWT.V_SCROLL);
		GridData gd_scrolledComposite_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_scrolledComposite_1.widthHint = 92;
		gd_scrolledComposite_1.heightHint = 81;
		scrolledComposite_1.setLayoutData(gd_scrolledComposite_1);
		scrolledComposite_1.setExpandHorizontal(true);
		scrolledComposite_1.setExpandVertical(true);
		
		textAreaTchAddr = new Text(scrolledComposite_1, SWT.BORDER | SWT.V_SCROLL);
		scrolledComposite_1.setContent(textAreaTchAddr);
		scrolledComposite_1.setMinSize(textAreaTchAddr.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		tchList=new LinkedList<Teacher>();
		Button btnNewButton_1 = new Button(composite_8, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					
					int tchNum=Integer.parseInt(textTchNum.getText().trim());
					for (Teacher tch:tchList) {
						if (tchNum==tch.getId()) {
							MessageDialog.openInformation(shell, "ѧ���ظ�", "��ѧ�Ž�ʦ�����Ѿ����ڣ�");
							return;
						}
					}
				    String tchName =textTchName.getText().trim();
				    updateDpart(comboTchDept);
				    Department department=depart;
				    String tchSex=btnRadioButtonM.getSelection()?"��":(btnRadioButtonF.getSelection()?"Ů":"");
				    int tchAge=Integer.parseInt(textTchAge.getText());
				    String tchAddr=textAreaTchAddr.getText().trim();
				    String tchPicImg=labelTchImg.getText()==null||labelTchImg.getText().equals("")?"":labelTchImg.getText();
				    String tchIntro=textAreaTchAddr.getText()==null||textAreaTchAddr.getText().equals("")?"":textAreaTchAddr.getText();
				    currTeacher=new Teacher(tchNum, tchName, tchSex, tchAge, department, tchAddr, tchPicImg, tchIntro);
				    preTI = tabFolder.getSelectionIndex();
				    labelScoresTitle.setText(currTeacher.getName()+"��ʦ ѡ��γ�");
				    comboScoresDept.setText(depart.getName());
				    clearLastClassList();
				    addCourseItem();
				    tabFolder.setSelection(tabItemCourse);
				} catch (NullPointerException ee) {
					MessageDialog.openInformation(shell, "���ݲ�����", "���ţ����������ţ�סַ�ͼ�鲻��Ϊ�գ�");
				}catch (NumberFormatException ee1) {
					MessageDialog.openInformation(shell, "���ݲ�׼ȷ", "���ţ�����ӦΪ������");
				}
			}

			
		});
		GridData gd_btnNewButton_1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton_1.widthHint = 70;
		btnNewButton_1.setLayoutData(gd_btnNewButton_1);
		btnNewButton_1.setText("\u8BFE\u7A0B\u9009\u62E9");
		new Label(composite_8, SWT.NONE);
		
		Composite composite_9 = new Composite(composite_7, SWT.NONE);
		composite_9.setLayout(new GridLayout(2, true));
		GridData gd_composite_9 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_9.heightHint = 377;
		gd_composite_9.widthHint = 334;
		composite_9.setLayoutData(gd_composite_9);
		
		Label lblNewLabel_13 = new Label(composite_9, SWT.NONE);
		lblNewLabel_13.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblNewLabel_13.setText("\u7167\u7247");
		
		Composite composite_10 = new Composite(composite_9, SWT.BORDER);
		composite_10.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite_10 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_composite_10.widthHint = 125;
		gd_composite_10.heightHint = 158;
		composite_10.setLayoutData(gd_composite_10);
		
		labelTchImg = new Label(composite_10, SWT.NONE);
		
		Label lblNewLabel_14 = new Label(composite_9, SWT.NONE);
		lblNewLabel_14.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblNewLabel_14.setText("\u7B80\u4ECB");
		
		ScrolledComposite scrolledComposite_2 = new ScrolledComposite(composite_9, SWT.BORDER | SWT.V_SCROLL);
		GridData gd_scrolledComposite_2 = new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1);
		gd_scrolledComposite_2.heightHint = 196;
		gd_scrolledComposite_2.widthHint = 107;
		scrolledComposite_2.setLayoutData(gd_scrolledComposite_2);
		scrolledComposite_2.setExpandHorizontal(true);
		scrolledComposite_2.setExpandVertical(true);
		
		textTchIntro = new Text(scrolledComposite_2, SWT.BORDER | SWT.V_SCROLL);
		scrolledComposite_2.setContent(textTchIntro);
		scrolledComposite_2.setMinSize(textTchIntro.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		tabItemCourse = new TabItem(tabFolder, SWT.NONE);
		tabItemCourse.setText("\u8BFE\u7A0B\u9009\u62E9");
		
		Composite composite_11 = new Composite(tabFolder, SWT.NONE);
		tabItemCourse.setControl(composite_11);
		composite_11.setLayout(new GridLayout(3, true));
		new Label(composite_11, SWT.NONE);
		
	    labelScoresTitle = new Label(composite_11, SWT.NONE);
		GridData gd_labelScoresTitle = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_labelScoresTitle.widthHint = 212;
		labelScoresTitle.setLayoutData(gd_labelScoresTitle);
		new Label(composite_11, SWT.NONE);
		
		Label lblNewLabel_16 = new Label(composite_11, SWT.NONE);
		lblNewLabel_16.setText("\u4E13\u4E1A");
		
		readDeptList();
		
	    comboScoresDept = new Combo(composite_11, SWT.READ_ONLY);
		comboScoresDept.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		for (Department depart:departmentlist) {
			comboScoresDept.add(depart.getName());
		}
		
	   
		
		new Label(composite_11, SWT.NONE);
		
		Label lblNewLabel_17 = new Label(composite_11, SWT.NONE);
		lblNewLabel_17.setText("\u516C\u5171\u57FA\u7840\u8BFE");
		
		Label lblNewLabel_18 = new Label(composite_11, SWT.NONE);
		lblNewLabel_18.setText("\u4E13\u4E1A\u57FA\u7840\u8BFE");
		
		Label lblNewLabel_19 = new Label(composite_11, SWT.NONE);
		lblNewLabel_19.setText("\u4E13\u4E1A\u9009\u4FEE\u8BFE");
		
		groupScoresCommonList = new Composite(composite_11, SWT.NONE);
		groupScoresCommonList.setLayout(new FillLayout(SWT.VERTICAL));
		GridData gd_groupScoresCommonList = new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1);
		gd_groupScoresCommonList.heightHint = 287;
		gd_groupScoresCommonList.widthHint = 208;
		groupScoresCommonList.setLayoutData(gd_groupScoresCommonList);
		
		ScrolledComposite scrolledComposite_3 = new ScrolledComposite(composite_11, SWT.BORDER | SWT.V_SCROLL);
		GridData gd_scrolledComposite_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_scrolledComposite_3.heightHint = 264;
		gd_scrolledComposite_3.widthHint = 139;
		scrolledComposite_3.setLayoutData(gd_scrolledComposite_3);
		scrolledComposite_3.setExpandHorizontal(true);
		scrolledComposite_3.setExpandVertical(true);
		
		groupScoresDeptOrienList = new Composite(scrolledComposite_3, SWT.NONE);
		groupScoresDeptOrienList.setLayout(new FillLayout(SWT.VERTICAL));
		scrolledComposite_3.setContent(groupScoresDeptOrienList);
		scrolledComposite_3.setMinSize(groupScoresDeptOrienList.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		groupScoresDeptBasesList = new Composite(composite_11, SWT.NONE);
		groupScoresDeptBasesList.setLayout(new FillLayout(SWT.VERTICAL));
		GridData gd_groupScoresDeptBasesList = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_groupScoresDeptBasesList.heightHint = 294;
		gd_groupScoresDeptBasesList.widthHint = 199;
		groupScoresDeptBasesList.setLayoutData(gd_groupScoresDeptBasesList);
		
		Button btnNext = new Button(composite_11, SWT.NONE);
		btnNext.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnNext.setText("\u4E0B\u4E00\u4E2A");
		
		btnNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (currStudent!=null||currTeacher!=null) {   //�жϵ�ǰ��ʦ����ѧ���Ƿ����
					addToList();      //���Ѿ�ע�����ʦ����ѧ����ӵ���Ӧ���б�
					tabFolder.setSelection(preTI);   //��ת����һ���û���ע��ҳ��
					initRegister();//��ʼ��ע�����
				}else {
					MessageDialog.openInformation(shell, "û������", "û����Ҫ���������");
					return;
				}
			}

			
		});
		
		btnScoresClose = new Button(composite_11, SWT.NONE);
		btnScoresClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (currStudent!=null||currTeacher!=null) {
					addToList();
				
				}
				
					try {
						FileOutputStream fos=preTI==0? new FileOutputStream("stdList.obj",true):preTI==1?new FileOutputStream("tchList.obj",true):null;
						ObjectOutputStream oos=new ObjectOutputStream(fos);
						if (preTI==0) {
							System.out.println("i am a student,i have run correctly!");
							oos.writeObject(stdList);
						}
						if (preTI==1) {
							System.out.println("i am a teacher,i have run correctly!");
							oos.writeObject(tchList);
						}
						oos.close();
						fos.close();
						User newUser=null;
						UserSet ust=new UserSet();
						if (preTI==0) {
							System.out.println("i am a student,i have run correctly!");
							for (Student std:stdList) {
								newUser=new User(""+std.getId(), "123", preTI);
								ust.addUser(newUser);
							}
						}
						if (preTI==1) {
							System.out.println("i am a teacher,i have run correctly!");
							for (Teacher tch:tchList) {
								newUser=new User(""+tch.getId(), "456", preTI);
								ust.addUser(newUser);
							}
						}
						shell.dispose();
						try {
							shell=new AdminscoreMana(null).getShell();
							shell.open();
						
						} catch (Exception e2) {
							// TODO: handle exception
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}catch (IOException e2) {
						e2.printStackTrace();
					}
				}
			
		});
		btnScoresClose.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnScoresClose.setText("\u4FDD\u5B58\u9000\u51FA");
		
		btnQuit = new Button(composite_11, SWT.NONE);
		btnQuit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		btnQuit.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnQuit.setText("\u4E0D\u4FDD\u5B58\u9000\u51FA");
		
	}
	void clearLastClassList() {
		/**  if (groupScoresCommonList.getChildren().equals(null)&&groupScoresDeptOrienList.getChildren().equals(null)&&groupScoresDeptBasesList.getChildren().equals(null)) {
			return;
		}else   */
			
			if(!groupScoresCommonList.getChildren().equals(null)) {		
			            Control[] child1=groupScoresCommonList.getChildren();
			               for (Control c1:child1) {
				                  c1.dispose();
					                     
			                                 	}
			                                }  
			                          
	      if(!groupScoresDeptBasesList.getChildren().equals(null)) {		
		                  Control[] child2=groupScoresDeptBasesList.getChildren();
			                  for (Control c2:child2) {
				                  c2.dispose();
				                  
				                             }
		                               	}
		                          	
            if(!groupScoresDeptOrienList.getChildren().equals(null)) {		
                            Control[] child3=groupScoresDeptOrienList.getChildren();
	                           for (Control c3:child3) {
		                            c3.dispose();
		                             
		                                         }
                                            }  

	}
		
	

	protected void initRegister() {	
	  if (preTI==0) {	
		textStdNum.setText("");
		textStdName.setText("");
		textStdGrade.setText("");
		textStdClass.setText("");
	  }else {
		textTchNum.setText("");
		textTchName.setText("");
		textTchAge.setText("");
		textTchIntro.setText("");
		textAreaTchAddr.setText("");
	    }
	}
	 void addCourseItem() {
		if (depart!=null) {  //��⵱ǰ��רҵ�Ƿ�Ϊ��
			LinkedList<Course> courseList=depart.getCoursesList();   //ʵ�����γ��б����õ���רҵ�Ŀγ��б�
			for (Course course:courseList) {    //������רҵ�Ŀγ��б������ɿ�ѡ��ĸ�ѡ��ť
				if (course.gettype().equals("����������")) {
					System.out.println("i am public class,i have run!");
					System.out.println("����רҵ��"+depart.getName().trim());					
					new Button(groupScoresCommonList,SWT.CHECK).setText(course.getname());
					groupScoresCommonList.layout();
					System.out.println("i am public class ,i have run too!");
				}else if (course.gettype().equals("רҵ������")) {
					new Button(groupScoresDeptBasesList, SWT.CHECK).setText(course.getname());
		            groupScoresDeptBasesList.layout();
				}else if (course.gettype().equals("רҵѡ�޿�")) {
					new Button(groupScoresDeptOrienList, SWT.CHECK).setText(course.getname());
					groupScoresDeptOrienList.layout();
				}
			}
		}
	}

	protected void updateDpart(Combo combo) {
		int selIndex=combo.getSelectionIndex();
		if (selIndex>-1) {
			String selText=combo.getItem(selIndex);
			for (int i = 0; i < departmentlist.size(); i++) {   //����רҵ�б�������ѡ���רҵ�������רҵ�ĺϷ���
				if (departmentlist.get(i).getName().equals(selText)) {
					depart=departmentlist.get(i);   //�õ�ѡ�е�רҵ������ֵ��Depart
					return;
				}
			}
		}
		
	}
	private void readDeptList() throws IOException{
		try {
			FileInputStream fis=new FileInputStream("deptList.obj");
			ObjectInputStream ois=new ObjectInputStream(fis);
			departmentlist=(LinkedList<Department>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void addToList() {  //�����������εĿγ���Ϣ���浽ע���ѧ��������ʦ
		Control[]childCommon=groupScoresCommonList.getChildren();
		for (Control btn:childCommon) {
			if (btn.toString().startsWith("Button")) {
				Button btnn=(Button) btn;
				if (btnn.getSelection()) {
					if (preTI==0) {
						currStudent.getCourseList().add(new Course(btnn.getText().trim(), "����������"));  //����ǰ�γ��б���ӵ���ע��ѧ��
					}else if (preTI==1) {
						currTeacher.getCourseList().add(new Course(btnn.getText().trim(), "����������"));  //����ǰ�γ��б���ӵ���ע����ʦ
					}
				}
			}
		}
		Control[]childDeptBase=groupScoresDeptOrienList.getChildren();
			for (Control btn:childDeptBase) { //��רҵ�����εĿγ���Ϣ���浽ע���ѧ��������ʦ
				if (btn.toString().startsWith("Button")) {
					Button btnn=(Button) btn;
					if (btnn.getSelection()) {
						if (preTI==0) {
							currStudent.getCourseList().add(new Course(btnn.getText().trim(), "רҵѡ�޿�"));//����ǰ�γ��б���ӵ���ע��ѧ��
						}else if (preTI==1) {
							currTeacher.getCourseList().add(new Course(btnn.getText().trim(), "רҵѡ�޿�"));//����ǰ�γ��б���ӵ���ע����ʦ
						}
					}
				}
			
			}
			Control[]childDeptOrien=groupScoresDeptBasesList.getChildren();
			for (Control btn:childDeptOrien) { //��רҵѡ�޿εĿγ���Ϣ���浽ע���ѧ��������ʦ
				if (btn.toString().startsWith("Button")) {
					Button btnn=(Button) btn;
					if (btnn.getSelection()) {
						if (preTI==0) {
							currStudent.getCourseList().add(new Course(btnn.getText().trim(), "רҵ������"));//����ǰ�γ��б���ӵ���ע��ѧ��
						}else if (preTI==1) {
							currTeacher.getCourseList().add(new Course(btnn.getText().trim(), "רҵ������"));//����ǰ�γ��б���ӵ���ע����ʦ
						}
					}
				}
			}
			//�жϵ�ǰ��ע���û�����ʦ����ѧ��
			if (preTI==0) {//����ǰ��ע���û�Ϊѧ��
				stdList.add(currStudent);  //����ǰѧ����ӵ�ѧ���б�
			    currStudent=null;   //��ǰ��ʦΪ��
			}else if (preTI==1) {//����ǰ��ע���û�Ϊ��ʦ
				tchList.add(currTeacher);  //����ǰ��ʦ��ӵ���ʦ�б�
				currTeacher=null;  //��ǰѧ��Ϊ��
				System.out.println("i have run!");
			}
	}

	public Shell getShell() {
		return shell;
	}
}
