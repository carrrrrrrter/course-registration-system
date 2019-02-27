package crs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


public class Admin extends User implements AdminInterface, java.io.Serializable {

	
	public Admin(String fn, String ln, String usn, String psw) {
		String firstName = fn;
		String lastName = ln;
		String username = usn;
		String password = psw;
	}
	
	//Instantiate course object from default constructor
	
	//WORKS
	public static String createCourses() throws IOException {
		
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		System.out.print("Course Name: ");
		String courseName = input.nextLine();
		
		System.out.print("Course ID: ");
		String courseID = input.nextLine();
		
		System.out.print("Max # of Students: ");
		int maxStudents = input2.nextInt();
		
		int currentStudents = 0;
				
		System.out.println("Course Instructor: ");
		String courseInstructor = input.nextLine();
		
		System.out.print("Section Number: ");
		int sectionNumber = input2.nextInt();
		
		System.out.print("Course Location: ");
		String courseLocation = input.nextLine();
		
		
		//Then add to .csv file
		Course newCourse = new Course (courseName,courseID,maxStudents,currentStudents,null,courseInstructor,sectionNumber,courseLocation);
		crsMain.courseArrayList.add(newCourse);
		return "Course added.";
	}
	
	//WORKS
	public static void deleteCourse() {
		Course course = new Course();
		//Ask user for courseID
		Scanner input = new Scanner(System.in);
		System.out.print("Enter course ID: ");
		String courseID = input.nextLine();
		//Remove index from ArrayList of courses
		
		for (int i = 0; i<crsMain.courseArrayList.size(); i++) {
			course = crsMain.courseArrayList.get(i);
			if (course.getCourseID().equals(courseID)) {
				crsMain.courseArrayList.remove(i);
			}
		}
	}
	
	//WORKS
	public static void editCourse() throws IOException {
		Course course = new Course();
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		System.out.print("Course ID: ");
		String courseID = input.nextLine();
		int courseIndex = 0;
		
		//Ask user what they want to edit
		System.out.print("What would you like to edit?\n");
		System.out.print("1. Max amount of students\n");
		System.out.print("2. Course Instructor\n");
		System.out.print("3. Section Number\n");
		System.out.print("4. Class location\n");
		int choice = input.nextInt();
		
		for (int i = 0; i<crsMain.courseArrayList.size(); i++) {
			course = crsMain.courseArrayList.get(i);
			courseIndex = crsMain.courseArrayList.indexOf(crsMain.courseArrayList.get(i));
			
			
				if (choice == 1 && courseID.equals(course.getCourseID())) {
					System.out.print("New max amount of students: ");
					int newMax = input2.nextInt();
					crsMain.courseArrayList.get(courseIndex);
					course.setMaxStudents(newMax);
					break;
				}
				if (choice == 2 && courseID.equals(course.getCourseID())) {
					System.out.println("New course instructor: ");
					String newInstructor = input2.nextLine();
					course.setCourseInstructor(newInstructor);
					break;
				}
				if (choice == 3 && courseID.equals(course.getCourseID())) {
					System.out.println("New section number: ");
					int newSection = input2.nextInt();
					course.setCourseSection(newSection);
					break;
				}
				if (choice == 4 && courseID.equals(course.getCourseID())) {
					System.out.println("New course location: ");
					String newLocation = input2.nextLine();
					course.setCourseLocation(newLocation);
					break;
				}
			
		}
		
		
		System.out.println(crsMain.courseArrayList.toString());		
	}

	//WORKS
	public static void displayInfo() throws IOException {
		Course course = new Course(); 
		Scanner input = new Scanner(System.in);
		//Ask user for Course ID
		System.out.print("Enter course ID: ");
		String courseID = input.nextLine();
		
		for (int i = 0; i<crsMain.courseArrayList.size(); i++) {
			course = crsMain.courseArrayList.get(i);
			if (course.getCourseID().equals(courseID)) {
				System.out.println(crsMain.courseArrayList.get(i));
			}
		}
	}
	
	//WORKS
	public static void registerStudent() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Student First Name: ");
		String firstName = input.nextLine();
		System.out.println("Student Last Name: ");
		String lastName = input.nextLine(); 
		String username = null;
		String password = null; 
		
		Student newStudent = new Student(firstName,lastName,username,password,crsData.courses);
		crsData.students.add(newStudent);
		//students.add(newStudent);
		System.out.println(crsData.students.toString());
	}
	
	//ArrayList of students
	//public static ArrayList<Student> students = new ArrayList<>();
	
	
	//WORKS
	public static void viewCourses() {

			System.out.println(crsMain.courseArrayList.toString());
		
	}

	public static String fullCourseID = null;
	public static String viewFullCourses() throws IOException {
		//If currentStudents == maxStudents
		//		display courseIDs
		Course course = new Course();
		for (int i = 0; i<crsMain.courseArrayList.size(); i++) {
			course = crsMain.courseArrayList.get(i);
			if (course.getEnrolledStudents() == course.getMaxStudents()) {
				String courseID = course.getCourseID();
				fullCourseID = courseID;
				System.out.println(courseID);
			}
		}
		return fullCourseID;
	}
	//WORKS
	public static void addCourseToFile() throws FileNotFoundException {
		//Create new file of full courses
		Course course = new Course();
		try (PrintWriter writer = new PrintWriter(new File("fullCourses.csv"))) {
			StringBuilder stringB = new StringBuilder();
			for (int i = 0; i<crsMain.courseArrayList.size(); i++) {
				course = crsMain.courseArrayList.get(i);
				if (course.getEnrolledStudents() == course.getMaxStudents()) {
					String courseID = course.getCourseID();
					stringB.append(courseID);
				}
			}
			
		}
	}
	//WORKS
	public static void studentNamesInCourse() {
		//Print out list of names (index 4 of course array list)
		//Ask user for courseID 
		Course course = new Course();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter course ID: ");
		String courseID = input.nextLine();
				//Remove index from ArrayList of courses
				
		for (int i = 0; i<crsMain.courseArrayList.size(); i++) {
			course = crsMain.courseArrayList.get(i);
			if (course.getCourseID().equals(courseID)) {
				System.out.println(course.getStudents().toString());
			}
		}
	}
	
	public static void coursesPerStudent() {
		Course course = new Course();
		//Search first name, last name
		Scanner input = new Scanner(System.in);
		System.out.println("Enter student first name: ");
		String firstName = input.nextLine();
		
		System.out.println("Enter student last name: ");
		String lastName = input.nextLine();
		String name = firstName = " " + lastName;
		Student testStudent = new Student(firstName, lastName, null, null, null);
		System.out.println("Their registered courses: ");
		
		for (int i = 0; i<crsMain.courseArrayList.size(); i++) {
			course = crsMain.courseArrayList.get(i);
			System.out.println(crsData.courses.toString());
		}
		
	}

	public static void sortMostStudentsPerClass() {
		Course course = new Course();
		ArrayList<Integer> sortedArrayList = new ArrayList<Integer>();
		for (int i = 0; i<crsMain.courseArrayList.size(); i++) {
			sortedArrayList.add(course.enrolledStudents);
			String courseID = course.getCourseID();
		}
		Collections.sort(sortedArrayList, Collections.reverseOrder());
		System.out.println(sortedArrayList.toString());
	}

	


}
