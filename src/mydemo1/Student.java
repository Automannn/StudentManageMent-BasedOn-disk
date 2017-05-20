package mydemo1;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Department department;
	private int grade;
	private int cClass;
	private String pic;
	private String interested;
	private ArrayList<Course>courseList=new ArrayList<Course>();
	public Student(int id, String name, Department department, int grade, int cClass, String pic, String interested) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.grade = grade;
		this.cClass = cClass;
		this.pic = pic;
		this.interested = interested;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getcClass() {
		return cClass;
	}
	public void setcClass(int cClass) {
		this.cClass = cClass;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getInterested() {
		return interested;
	}
	public void setInterested(String interested) {
		this.interested = interested;
	}
	public ArrayList<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

}
