package mydemo1;

import java.io.Serializable;

public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String type;
	public Course(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	private float score;
	private int techerID=-1;
	public String  getname() {
		return name;
	}
	public void setname(String name) {
		this.name =name;
	}
   public String  gettype() {
	return type;		
	
}
   public void settype(String type) {
	this.type =type;
}
   public float getscore() {
	return score;
}
   public void setscore(float score) {
	this.score=score;
}
   public int gettecherID() {
	return techerID;
}
   public void settecherID(int teacherID) {
	this.techerID=teacherID;
}
}
