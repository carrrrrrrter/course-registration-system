package crs;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Student extends User implements StudentInterface, java.io.Serializable {
	
	public static ArrayList<String> registeredCourses = new ArrayList<String>();
	public String firstName;
	public String lastName;
	public String username;
	public String password;
	
	//Define constructors
	public Student() {
		
	}
	
	//public static Course course = new Course();
	public static Student student = new Student();
	//public static crsData crsdata = new crsData();
	public Student (String fN, String lN, String usn, String psw, ArrayList<String> courses) {
		this.firstName = fN;
		this.lastName = lN;
		this.username = usn;
		this.password = psw;
		Student.registeredCourses = courses;
	}
	
	

	public static ArrayList<String> getRegisteredCourses() {
		return registeredCourses;
	}

	public static void setRegisteredCourses(ArrayList<String> registeredCourses) {
		Student.registeredCourses = registeredCourses;
	}
	@Override
	public String getFirstName() {
		return firstName;
	}
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString () {
		return this.firstName + " " + this.lastName;
	}

	
	//Student methods
	
	//WORKS
	public static void viewAllCourses() {

			System.out.println(crsMain.courseArrayList);
		
	}

	//WORKS
	public static String fullCourseID = null;
	public static void viewNotFullCourses() throws IOException {
		//In ArrayList of courses, if Max# == enrolled# return course info
		Course course = new Course();
		for (int i = 0; i<crsMain.courseArrayList.size(); i++) {
			course = crsMain.courseArrayList.get(i);
			if (course.getEnrolledStudents() != course.getMaxStudents()) {
				String courseID = course.getCourseID();
				fullCourseID = courseID;
				System.out.println(courseID);
			}
		}
	}

	//WORKS
	public static void register() {
		Course course = new Course();
		ArrayList<String> regCourse = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		//Enter courseID
		System.out.print("Enter courseID: ");
		String courseID = input.nextLine();
		//Add courseID to list of registered courses
		
		//Add name to registered students
		System.out.println("Verify full name: ");
		String firstName = input.nextLine();
		System.out.println("Verify last name: ");
		String lastName = input.nextLine();
		String name = firstName + " " + lastName;
				
		
		for (int i = 0; i<crsData.students.size(); i++) {
			Student student = crsData.students.get(i);
			if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
				
				for (int j = 0; j<crsMain.courseArrayList.size(); j++) {
					course = crsMain.courseArrayList.get(j);
					
					if (courseID.equals(course.getCourseID())) {
						course.addStudent(name);
						
					}
					if (course.getEnrolledStudents() == course.getMaxStudents()) {
						System.out.println("Course is full.");
						//break;
					}
				}
			}
			crsData.courses.add(courseID);
		}
		
		
		System.out.println(crsData.courses);

		
	}

	//WORKS
	public static void withdraw() {
		Course course = new Course();
		//Enter courseID
		Scanner input = new Scanner (System.in);
		System.out.print("Enter courseID: ");
		String courseID = input.nextLine();
		System.out.print("Verify first name: ");
		String firstName = input.nextLine();
		System.out.print("Verify last name: ");
		String lastName = input.nextLine();
		String name = firstName + " " + lastName;
		
		for (int i = 0; i<crsData.students.size(); i++) {
			Student student = crsData.students.get(i);
			if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
				
				for (int j = 0; j<crsMain.courseArrayList.size(); j++) {
					course = crsMain.courseArrayList.get(j);
					
					if (courseID.equals(course.getCourseID())) {
						course.removeStudent(name);
					}
				}
			}
			crsData.courses.remove(courseID);
		}
		System.out.println(crsData.courses.toString());
	}

	
	public static void viewYourCourses() {
		//Serialization.courseDeserialization();
		//Print out list of registered courses
		
		System.out.println(crsData.courses.toString());
		//if courseID is in csv file, print out course name also
	}
	
	//Storage of courses
	
		
	
	
	

}
