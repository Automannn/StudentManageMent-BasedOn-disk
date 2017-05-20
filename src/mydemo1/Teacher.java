package mydemo1;

import java.io.Serializable;
import java.util.ArrayList;

public class Teacher implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String sex;
	private int age;
	private Department department;
	private String address;
	private String pic;
	private String intro;
	private ArrayList<Course>courseList=new ArrayList<Course>();
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public ArrayList<Course> getCourseList() {
		return courseList;
	}
	public Teacher(int id, String name, String tchSex, int age, Department department, String address, String pic,
			String intro) {
		super();
		this.id = id;
		this.name = name;
		this.sex = tchSex;
		this.age = age;
		this.department = department;
		this.address = address;
		this.pic = pic;
		this.intro = intro;
	}

}
