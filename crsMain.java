package crs;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class crsMain implements Serializable {
	
	public static void main (String [] args) throws IOException {
		User admin = new Admin("Carter", "Fodge", "Admin", "Admin001");
		Serialization.studentDeserialization();
		Serialization.courseDeserialization();
		courseList();
		LoginMain();

	}
	
	public static ArrayList<Course> courseArrayList = new ArrayList<Course>();
	
	public static ArrayList<Course> courseList() throws IOException{
		
		ArrayList<Course> courses = new ArrayList<Course>();
			
		try (BufferedReader br = new BufferedReader(new FileReader(new File("MyUniversityCourses.csv")))){
			String line;
			while ((line = br.readLine()) != null) {
					//Create array for each course, with course array item split by a comma
				String[] entries = line.split(",");
				
				Course courseEntries = new Course(entries[0],entries[1],Integer.parseInt(entries[2]),Integer.parseInt(entries[3]),
						null, entries[5],Integer.parseInt(entries[6]),entries[7]);
				
				courses.add(courseEntries);
			}
		} 
		catch(FileNotFoundException ex){
			ex.printStackTrace();
		}

		catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
		courseArrayList = courses;
		
		return courseArrayList;
	}
	
	
	public static void LoginMain() throws IOException{
		System.out.print("1. Admin\n" + "2. Student\n" + "3. Exit\n");
		
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		
		
		Scanner input2 = new Scanner(System.in);
		
		//Check if username/password are correct
		if (choice == 1) {  
			System.out.println("Username: ");
			String username = input2.nextLine();
			
			System.out.println("Password: ");
			String password = input2.nextLine();
			
			if (username.equals("Admin") && password.equals("Admin001")) {adminSelection();}
			
		}
		
		if (choice == 2) {
			
			Scanner firstTimeLog = new Scanner(System.in);
			Scanner choice2 = new Scanner(System.in);
			System.out.print("Enter your First Name: ");
			String firstName = firstTimeLog.nextLine();
			System.out.print("Enter your Last Name: ");
			String lastName = firstTimeLog.nextLine();
			
			//Let the user create a new username and password themselves
			//if (firstLog.equals("yes") || firstLog.equals("Yes")) {
				System.out.print("Username: ");
				String newUsername = firstTimeLog.nextLine();

				System.out.print("Password: ");
				String newPassword = firstTimeLog.nextLine();

				for (int i = 0; i<crsData.students.size(); i++) {
					Student studentIndex = crsData.students.get(i);
					//Find student object in ArrayList to add username/password to correct profile
					if (studentIndex.getFirstName().equals(firstName) && studentIndex.getLastName().equals(lastName)) {
						studentIndex.setUsername(newUsername);
						studentIndex.setPassword(newPassword);
						studentIndex.setFirstName(firstName);
						studentIndex.setLastName(lastName);
					}
				}
				
//				System.out.println("New username and password set.");
				studentSelection();
//			}
					
		}
		if (choice == 3) {
			Serialization.studentSerialization();
			Serialization.courseSerialization();
			System.exit(0);
		}
	}
	
	
	public static void adminSelection() throws IOException {
		System.out.print("\nCourse Management:\n"
				+ "1. Create a new course\n"
				+ "2. Delete a course\n"
				+ "3. Edit a course\n"
				+ "4. Display course info\n"
				+ "5. Register a student\n"
				+ "6. Exit\n\n");
		
		System.out.print("Reports:\n"
				+ "7. View all courses\n"
				+ "8. View all full courses\n"
				+ "9. Add full courses to file\n"
				+ "10. View students in a course\n"
				+ "11. View courses for a student\n"
				+ "12. Sort courses\n"
				+ "13. Exit\n");
		//Ask user to make selection
		Scanner input = new Scanner(System.in);
		System.out.println("Enter selection: ");
		int systemEntry = input.nextInt();
		
		//Call specified method from Admin class based on selection
		
			Scanner input2 = new Scanner(System.in);
			if (systemEntry == 1) Admin.createCourses();
			if (systemEntry == 2) Admin.deleteCourse();
			if (systemEntry == 3) Admin.editCourse();
			if (systemEntry == 4) Admin.displayInfo();
			if (systemEntry == 5) Admin.registerStudent();	
			if (systemEntry == 7) Admin.viewCourses();
			if (systemEntry == 8) Admin.viewFullCourses();
			if (systemEntry == 9) Admin.addCourseToFile();
			if (systemEntry == 10) Admin.studentNamesInCourse();
			if (systemEntry == 11) Admin.coursesPerStudent();
			if (systemEntry == 12) Admin.sortMostStudentsPerClass();
			if (systemEntry == 13 || systemEntry == 6) {
				LoginMain(); 
			}
		adminSelection();
	}
	
	public static void studentSelection() throws IOException {
		System.out.print("Course Management:\n"
				+ "1. View all courses\n"
				+ "2. View all available courses\n"
				+ "3. Register for a course\n"
				+ "4. Withdraw from a course\n"
				+ "5. Your courses\n"
				+ "6. Exit\n");
		//Ask user to make selection
		Scanner input = new Scanner(System.in);
		System.out.println("Enter selection: ");
		int systemEntry = input.nextInt();
		
		//Call specified method from Student class based on selection
		Scanner input2 = new Scanner(System.in);
		if (systemEntry == 1) Student.viewAllCourses();
		if (systemEntry == 2) Student.viewNotFullCourses();
		if (systemEntry == 3) Student.register();
		if (systemEntry == 4) Student.withdraw();
		if (systemEntry == 5) Student.viewYourCourses();
		if (systemEntry == 6) {
			LoginMain();
		}
		studentSelection();
	}
}

