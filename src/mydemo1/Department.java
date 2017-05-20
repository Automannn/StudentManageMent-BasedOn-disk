package mydemo1;

import java.io.Serializable;
import java.util.LinkedList;

public class Department implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private LinkedList<Course> coursesList=new LinkedList<>();
	public String getName() {
		return name;
	}
	public LinkedList<Course> getCoursesList() {
		return coursesList;
	}
	public Department(String name) {
		super();
		this.name = name;
	}
	public void addCourse(Course course) {
		coursesList.add(course);
	}

}
