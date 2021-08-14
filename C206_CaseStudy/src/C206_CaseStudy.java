import java.util.ArrayList;
import java.util.Random;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<CCA> ccaList = new ArrayList<CCA>();
		ArrayList<Student> registerList = new ArrayList<Student>();

		ccaList.add(new CCA("Lego Expert", "Designing and building using Lego", 25, "Thursday", "15:00 - 16:00",
				"Class room A", "Albert"));
		ccaList.add(new CCA("Jewellery Making", "Make a variety of jewellery items", 15, "Wednesday", "15:00 - 16:00",
				"Class room B", "Malvin"));

		studentList.add(new Student(1, "John", "P3", "C206", "Desmond"));
		studentList.add(new Student(2, "Sean", "P3", "C206", "Desmond"));

		registerList
				.add(new Student(1, "John", "P3", "C206", "Desmond", "Sally", "sally@email.com", 91234321, "ABCDEFGH"));

		int mainMenuOption = 0;
		while (mainMenuOption != 7) {
			mainMenu();
			mainMenuOption = Helper.readInt("Enter an option > ");

			if (mainMenuOption == 1) { ///////////////////////////// Option 1 Sean
				C206_CaseStudy.setHeader("Admin login");

				String adminUser = Helper.readString("Enter Username: > ");
				String adminPass = Helper.readString("Enter Password: > ");

				if (adminUser.equals("admin") && adminPass.equals("admin")) { // Sean
					int adminOption = 0;
					while (adminOption != 5) {
						C206_CaseStudy.setHeader("Admin menu");

						System.out.println("1. View all students");
						System.out.println("2. Add students");
						System.out.println("3. Delete student");
						System.out.println("4. Update students");
						System.out.println("5. Logout");

						adminOption = Helper.readInt("Enter option: > ");

						switch (adminOption) {
						case 1:
							// view all student
							System.out.println(adminViewStudent(studentList));
							break;
						case 2:
							// add student
							addStudent(studentList, adminAddStudent());
							break;
						case 3:
							// delete student
							adminDeleteStudent(studentList);
							break;
							
						case 4:
							//Update student
							updateStudentDatabase(studentList);
							break;
						default:
							if (adminOption != 5) {
								System.out.println("Invalid input");
							}

							break;
						}
					}

				} else {
					System.out.println("Invalid Username or Password");
				}

			} else if (mainMenuOption == 2) { ///////////////////////////// Option 2
				C206_CaseStudy.setHeader("Coordinator Login");

				String coordUser = Helper.readString("Enter Username: > ");
				String coordPass = Helper.readString("Enter Password: > ");

				if (coordUser.equals("coordinator") && coordPass.equals("coordinator")) {

					int coordOption = 0;
					while (coordOption != 3) {
						C206_CaseStudy.setHeader("Coordinator Menu");

						System.out.println("1. Manage CCAs");
						System.out.println("2. Manage Registration");
						System.out.println("3. Logout");

						coordOption = Helper.readInt("Enter option: > ");

						switch (coordOption) {
						case 1:
							// manage CCAs
							int coordOptionCCA = 0;
							while (coordOptionCCA != 7) {
								manageCCAMenu();

								coordOptionCCA = Helper.readInt("Enter option: > ");

								switch (coordOptionCCA) {
								case 1:
									// view all ccas
									C206_CaseStudy.viewAllCCA(ccaList);
									break;
								case 2:
									// View all CCA category

									break;
								case 3:
									// Add CCA details
									CCA cca = inputCCA();
									C206_CaseStudy.addCCA(ccaList, cca);
									break;
								case 4:
									// Delete CCA
									C206_CaseStudy.coordDeleteCCA(ccaList);
									break;
								case 5:
									// Add CCA category
									break;
								case 6:
									// Delete CCA category
									break;
								default:
									if (coordOptionCCA != 7) {
										System.out.println("Invalid input");
									}

									break;
								}
							}
							break;
						case 2:
							// manage registration
							int coordOptionReg = 0;
							while (coordOptionReg != 3) {
								manageRegistrationMenu();
								coordOptionReg = Helper.readInt("Enter option: > ");

								switch (coordOptionReg) {
								case 1:
									// view all registered user
									C206_CaseStudy.viewUsersRegister(registerList);
									break;
								case 2:
									// Update CCA register request
									
									break;
								default:

									break;
								}
							}
						default:
							
							break;
						}
					}

				} else {
					System.out.println("Invalid Username or Password");
				}

			} else if (mainMenuOption == 3) { ///////////////////////////// Option 3
				loginStudentParentMenu();
			} else if (mainMenuOption == 4) { ///////////////////////////// Option 4
				//int stuPrntOption = 0;
				//while (stuPrntOption != 3) { // xixin
				C206_CaseStudy.setHeader("Register for account");

					Student userRegister = userRegister(studentList);
					C206_CaseStudy.addUserList(registerList, userRegister);

				//}

			} else if (mainMenuOption == 5) { ///////////////////////////// Option 5
				C206_CaseStudy.viewAllCCA(ccaList);
			} else if (mainMenuOption == 6) { ///////////////////////////// Option 6
				// View all CCA category
			}
		}
	}

	////////// Main menu //////////
	public static void mainMenu() { // xixin

		C206_CaseStudy.setHeader("School CCA Registration System");

		System.out.println("1. Login as administrator");
		System.out.println("2. Login as coordinator");
		System.out.println("3. Login as student or parent");
		System.out.println("4. Registration to System");
		System.out.println("5. View all CCAs");
		System.out.println("6. View all CCA category");
		System.out.println("7. Quit");

	}

	public static void manageCCAMenu() { // xixin

		C206_CaseStudy.setHeader("Manage CCAs");

		System.out.println("1. View all CCAs");
		System.out.println("2. View all CCA category");
		System.out.println("3. Add CCA details");
		System.out.println("4. Delete CCA");
		System.out.println("5. Add CCA category");
		System.out.println("6. Delete CCA category");
		System.out.println("7. Quit");

	}

	public static void manageRegistrationMenu() { // xixin

		C206_CaseStudy.setHeader("Manage Registrations");

		System.out.println("1. View all Registrations");
		System.out.println("2. Change registration status");
		System.out.println("3. Quit");

	}

	

	public static void loginStudentParentMenu() { // Omar
		C206_CaseStudy.setHeader("School CCA Registration System");

		System.out.println("1. Register for CCA");
		System.out.println("2. View registered CCA");
		System.out.println("3. Drop CCA");
	}

	// ================================= Admin menu options
	// =================================
	////////// Admin add student method //////////
	public static Student adminAddStudent() { // Sean
		System.out.println("Enter the following");
		int studentID = Helper.readInt("Student ID: > ");
		String studentName = Helper.readString("Student Name: > ");
		String studentGrade = Helper.readString("Student Grade: > ");
		String studentClass = Helper.readString("Student Class: > ");
		String studentTeacher = Helper.readString("Student Teacher: > ");

		Student stud = new Student(studentID, studentName, studentGrade, studentClass, studentTeacher);
		return stud;
	}

	public static void addStudent(ArrayList<Student> studentList, Student stud) {

		studentList.add(stud);
		System.out.println("Student added successfully");
	}

	///////// Admin View all students /////////
	public static String adminViewStudent(ArrayList<Student> studentList) { // Sean
		C206_CaseStudy.setHeader("List of students in database");
		String display = "";
		if (!studentList.isEmpty()) {
			display += String.format("%-20s %-20s %-10s %-10s %-10s\n", "Student ID", "Student Name", "Grade", "Class",
					"Teacher");
			for (int i = 0; i < studentList.size(); i++) {

				display += String.format("%-20d %-20s %-10s %-10s %-10s\n", studentList.get(i).getId(),
						studentList.get(i).getStudentName(), studentList.get(i).getGrade(),
						studentList.get(i).getClassId(), studentList.get(i).getTeacherName());
			}
		} else {
			display += "Student list is empty";
		}
		return display;
	}
	
	//Update Student 
	public static void updateStudentDatabase(ArrayList<Student> studentList) { //Sean
		setHeader("Update student data");
		System.out.println(adminViewStudent(studentList));
		int studentID = Helper.readInt("Enter student ID to edit: > ");
		String studentGrade = Helper.readString("New Student Grade: > ");
		String studentClass = Helper.readString("New Student Class: > ");
		String studentTeacher = Helper.readString("New Student Teacher: > ");

		updateStudentDetails(studentList, studentID, studentGrade, studentClass, studentTeacher);
	}
	
	public static void updateStudentDetails(ArrayList<Student> studentList, int id, String studentGrade, String studentClass, String studentTeacher) {
		boolean studentFound = false;
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getId() == id) {
				studentList.get(i).setGrade(studentGrade);
				studentList.get(i).setClassId(studentClass);
				studentList.get(i).setTeacherName(studentTeacher);
				studentFound = true;
				System.out.println("Student ID "+id+" details edited");
				break;
			}
		}
		if(!studentFound) {
				System.out.println("No such student or invalid input");
		}
	}

	///////// Admin delete student /////////
	public static void adminDeleteStudent(ArrayList<Student> studentList) { // Sean
		System.out.println(adminViewStudent(studentList));
		System.out.println("---------Delete Student----------");
		int studentID = Helper.readInt("Student ID: > ");
		System.out.println(deleteStudent(studentList, studentID));
	}

	public static String deleteStudent(ArrayList<Student> studentList, int id) {
		boolean studentFound = false;
		String info = "";
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == id) {
				studentList.remove(i);
				info += "Removed student: " + id;
				studentFound = true;
				break;
			} 
		}
		if(!studentFound) {
			info = "Invalid student ID";
	}
		return info;
	}

	// ================================= Coordinator menu options
	// =================================
	//////// Coordinator View all CCAs /////////
	public static String retrieveAllCCA(ArrayList<CCA> ccaList) { // xixin
		String output = "";

		for (int i = 0; i < ccaList.size(); i++) {

			String title = ccaList.get(i).getTitle();
			String description = ccaList.get(i).getDescription();
			int classSize = ccaList.get(i).getClassSize();
			String ccaDay = ccaList.get(i).getCcaDay();
			String ccaTime = ccaList.get(i).getCcaTime();
			String venu = ccaList.get(i).getVenu();
			String instructorName = ccaList.get(i).getInstructorName();
			output += String.format("%-20s %-45s %-15s %-15s %-20s %-15s %-15s\n", title, description, classSize,
					ccaDay, ccaTime, venu, instructorName);
		}
		return output;
	}

	public static void viewAllCCA(ArrayList<CCA> ccaList) {
		C206_CaseStudy.setHeader("CCA LIST");
		String output = String.format("%-20s %-45s %-15s %-15s %-20s %-15s %-15s\n", "TITLE", "DESCRIPTION",
				"CLASS SIZE", "DAY", "TIME", "VENU", "INSTRUCTOR-IN-CHARGE");
		output += retrieveAllCCA(ccaList);
		System.out.println(output);
	}

	/**
	 * @param string
	 */
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	//////// Coordinator Add a CCA /////////
	public static CCA inputCCA() { // xixin
		String ccaTitle = Helper.readString("Enter title > ");
		String ccaDescrip = Helper.readString("Enter description > ");
		int ccaClassSize = Helper.readInt("Enter class size > ");
		String ccaDay = Helper.readString("Enter day > ");
		String ccaTime = Helper.readString("Enter time (hh:mm - hh:mm) > ");
		String ccaVenu = Helper.readString("Enter venu > ");
		String ccaInstructor = Helper.readString("Enter instructor-in-charge > ");

		CCA cca = new CCA(ccaTitle, ccaDescrip, ccaClassSize, ccaDay, ccaTime, ccaVenu, ccaInstructor);
		return cca;

	}

	public static void addCCA(ArrayList<CCA> ccaList, CCA cca) {

		ccaList.add(cca);
		System.out.println("CCA added!");
	}

	//////// Coordinator Delete a CCA /////////
	public static void coordDeleteCCA(ArrayList<CCA> ccaList) { // Sean
		System.out.println(retrieveAllCCA(ccaList));
		System.out.println("---------Delete CCA----------");
		String ccaTitle = Helper.readString("Enter CCA Title to delete: > ");
		System.out.println(deleteCCA(ccaList, ccaTitle));
	}

	public static String deleteCCA(ArrayList<CCA> ccaList, String title) {
		String displayMssg = "";
		for (int i = 0; i < ccaList.size(); i++) {
			if (ccaList.get(i).getTitle().equals(title)) {
				ccaList.remove(i);
				displayMssg += "Removed CCA: " + title;
				break;
			} else {
				displayMssg = "Invalid CCA title";
			}
		}
		return displayMssg;
	}
	// ================================= Student/Parent registration menu options
	// =================================
	//////// Parent register /////////

	public static Student userRegister(ArrayList<Student> studentList) { // bazlyn, xixin, Sean

		Student userReg = null;
		int id = Helper.readInt("Enter Student's ID > ");
		String studentName = Helper.readString("Enter Student's name > ");
		String studentGrade = Helper.readString("Enter Student's grade > ");
		String classId = Helper.readString("Enter Student's class ID > ");
		String teacherName = Helper.readString("Enter teacher's name > ");
		String uniqueId = C206_CaseStudy.ccaRegIdGenerator();
		boolean isInDatabase = checkStudentDatabase(studentList, id, studentName);
		char value = studentGrade.charAt(studentGrade.length() - 1);
		int a=Character.getNumericValue(value);
		if ((a <= 3) && (isInDatabase == true)) { // Student is <= P3 & in database
			String parentName = Helper.readString("Enter parent name > ");
			String email = Helper.readString("Enter your email > ");
			int number = Helper.readInt("Enter contact number > ");
			
			userReg = new Student(id, studentName, studentGrade, classId, teacherName, parentName, email, number, uniqueId);

		}else if((a >= 4) && isInDatabase == true){// Student is >= P4 & in database
			userReg = new Student(id, studentName, studentGrade, classId, teacherName, uniqueId);
		}
		else { // Student not in database
			System.out.println("Student not in database");
		}
		return userReg;
	}

	/* Check if student is in database*/
	public static boolean checkStudentDatabase(ArrayList<Student> studentList, int id, String name) { // Sean
		boolean isInDatabase = false;
		for(int i = 0; i < studentList.size();i++) {
			if(id == studentList.get(i).getId() && name.equals(studentList.get(i).getStudentName())) {
				isInDatabase = true;
				break;
				}
			else {
				isInDatabase = false;
			}
		}
		return isInDatabase;
	}
	
	public static void addUserList(ArrayList<Student> userList, Student userReg) { //Xi Xin, Sean

		if(userReg != null) {
			userList.add(userReg);
		System.out.println("Account registered successful!");
		}
		
	}

	//////// View registered parent /////////
	public static String retrieveAllUserRegistration(ArrayList<Student> parentList) { // xixin
		String output = "";

		for (int i = 0; i < parentList.size(); i++) {

			int id = parentList.get(i).getId();
			String studentName = parentList.get(i).getStudentName();
			String grade = parentList.get(i).getGrade();
			String classId = parentList.get(i).getClassId();
			String teacher = parentList.get(i).getTeacherName();
			String parentName = parentList.get(i).getParentName();
			String email = parentList.get(i).getEmail();
			int contactNo = parentList.get(i).getNumber();
			output += String.format("%-15s %-15s %-10s %-10s %-15s %-20s %-20s %-15s\n", id, studentName, grade,
					classId, teacher, parentName, email, contactNo);
		}
		return output;
	}

	public static void viewUsersRegister(ArrayList<Student> userList) {
		C206_CaseStudy.setHeader("REGISTERED PARENTS/STUDENT LIST");
		String output = String.format("%-15s %-15s %-10s %-10s %-15s %-20s %-20s %-15s\n", "Student ID", "Student Name",
				"Grade", "Class", "Teacher", "Parent Name", "Email", "Contact Number");
		output += retrieveAllUserRegistration(userList);
		System.out.println(output);
	}

//	//////// View registered student /////////
//	public static String retrieveAllStudentRegistration(ArrayList<Student> studentList) { // xixin
//		String output = "";
//
//		for (int i = 0; i < studentList.size(); i++) {
//
//			int id = studentList.get(i).getId();
//			String studentName = studentList.get(i).getStudentName();
//			String grade = studentList.get(i).getGrade();
//			String classId = studentList.get(i).getClassId();
//			String teacher = studentList.get(i).getTeacherName();
//			output += String.format("%-10s %-15s %-15s %-15s %-10s\n", id, studentName, grade, classId, teacher);
//		}
//		return output;
//	}
//
//	public static void viewStudentRegister(ArrayList<Student> studentList) {
//		C206_CaseStudy.setHeader("REGISTERED PARENTS/STUDENT LIST");
//		String output = String.format("%-10s %-15s %-15s %-15s %-10s\n", "Student ID", "Student Name", "Grade", "Class",
//				"Teacher");
//		output += retrieveAllStudentRegistration(studentList);
//		System.out.println(output);
//	}

	// Delete parent//
	public static String deleteParent(ArrayList<Student> parentList, int id) { // bazlyn
		String info = "";
		for (int i = 0; i < parentList.size(); i++) {
			if (parentList.get(i).getId() == id) {
				parentList.remove(i);
				info += "Removed parent: " + id;
				break;
			} else {
				info = "Invalid student ID";
			}
		}
		return info;

	}

	public static String ccaRegIdGenerator() { // xixin
		int uniqueId = 8;

		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";

		String uniqueid = upperCase + lowerCase + numbers;

		Random randomId = new Random();

		char[] uniqueIDReg = new char[uniqueId];

		String newUniqueId = "";

		for (int i = 0; i < uniqueId; i++) {

			uniqueIDReg[i] = uniqueid.charAt(randomId.nextInt(uniqueid.length()));
			newUniqueId += uniqueIDReg[i];

		}
		return newUniqueId;
	}

}
