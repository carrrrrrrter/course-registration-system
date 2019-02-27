package crs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Serialization implements Serializable{
	public static void studentSerialization() {
		
		ArrayList<Student> serializedStudent = crsData.students;
		
			//Serialize
		try {
			FileOutputStream fos = new FileOutputStream("StudentList.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
				
			oos.writeObject(serializedStudent);
				
			oos.close();
			fos.close();
			System.out.println("Student Serialization Complete");
	
			}
		catch (IOException ioe) {ioe.printStackTrace();}
		
}

public static void studentDeserialization() {
	ArrayList<Student> deserialziedStudent = new ArrayList<Student>();
	try{
		  //FileInputSystem receives bytes from a file
	      FileInputStream fis = new FileInputStream("StudentList.ser");
	      
	      //ObjectInputStream does the deserialization-- it reconstructs the data into an object
	      ObjectInputStream ois = new ObjectInputStream(fis);
	      
	      //Cast as Student. readObject will take the object from ObjectInputStream
	      deserialziedStudent = (ArrayList<Student>)ois.readObject();
	      ois.close();
	      fis.close();
	    }
	catch(IOException ioe) {
	    ioe.printStackTrace();
	       return;
	    }
	 catch(ClassNotFoundException cnfe) {
	       cnfe.printStackTrace();
	       return;
	     }
	for (Student studentList : deserialziedStudent) {
		System.out.println(studentList);
	}
}

public static void courseSerialization() throws IOException {
	
	
	ArrayList<Course> serializedCourse = crsMain.courseArrayList;
	
	
	//Serialize
	try {
		FileOutputStream fos = new FileOutputStream("CourseList.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(serializedCourse);
		
		oos.close();
		fos.close();
		System.out.println("Course Serialization Complete");

	}
	catch (IOException ioe) {ioe.printStackTrace();}
	
}

public static void courseDeserialization() {
	ArrayList<Course> deserializedCourse = new ArrayList<Course>();
	try{
		  //FileInputSystem receives bytes from a file
	      FileInputStream fis = new FileInputStream("CourseList.ser");
	      
	      //ObjectInputStream does the deserialization-- it reconstructs the data into an object
	      ObjectInputStream ois = new ObjectInputStream(fis);
	      
	      //Cast as Student. readObject will take the object from ObjectInputStream
	      deserializedCourse = (ArrayList<Course>)ois.readObject();
	      ois.close();
	      fis.close();
	    }
	    catch(IOException ioe) {
	       ioe.printStackTrace();
	       return;
	    }
	 catch(ClassNotFoundException cnfe) {
	       cnfe.printStackTrace();
	       return;
	     }
	for (Course courseList : deserializedCourse) {
		System.out.println(courseList);
	}
	}
}



