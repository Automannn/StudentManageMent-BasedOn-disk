package mydemo1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

public class UserSet implements Serializable {

	private HashSet<User>usersSet=null;
	public UserSet(){
		super();
		usersSet=new HashSet<User>();
		try {
			File file=new File("users.obj");
			if (!file.exists()) {
				file.createNewFile();
				usersSet.add(new User("admin","123456",2));
				saveUserSet();
			}
		    ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(new File("users.obj")));
			HashSet<User> readObject = (HashSet<User>) objectInputStream.readObject();
			usersSet=readObject;
			objectInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		if (usersSet==null||usersSet.size()==0) {
			usersSet.add(new User("admin", "123456", 2));
		}
	}
	public boolean isValid(User user) {
		boolean userValid=false;
		if (usersSet.contains(user)) {
			userValid=true;
		}
		return userValid;
	}
	public void saveUserSet() {
		try {
			FileOutputStream fileOutputStream=new FileOutputStream("users.obj");
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(usersSet);
			objectOutputStream.flush();
		    objectOutputStream.close();
		    fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
   public void addUser(User user) {
	if (user!=null&&!usersSet.contains(user)) {
		usersSet.add(user);
		saveUserSet();
		
		
	}
}
   public void modifyUser(User oldUser,User newUser) {
	usersSet.remove(oldUser);
	usersSet.add(newUser);
	saveUserSet();
}
   public void delUser(User user) {
	usersSet.remove(user);
	saveUserSet();
} 
}
