import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private CCA cca1;
	private CCA cca2;
	private Student stud1;
	private ArrayList<CCA> ccaList;
	private ArrayList<Student> studentList;
	private Student studEdit;

	@Before
	public void setUp() throws Exception {
		//xixin
		cca1 = new CCA("Lego Expert", "Designing and building using Lego", 25, 
				"Thursday", "15:00 - 16:00", "Class room A", "Albert");
		cca2 = new CCA("Jewellery Making", "Make a variety of jewellery items",15,
				"Wednesday","15:00 - 16:00", "Class room B", "Malvin");
		
		ccaList= new ArrayList<CCA>();
		
		stud1 = new Student(1,"John","P3","C206","Desmond");
		studentList= new ArrayList<Student>();
		
		studEdit = new Student(1,"John","P1","C209","Mike");
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	@Test
	public void addCCATest() { //xixin
		// boundary
		assertNotNull("Check if there is valid CCA arraylist to add to", ccaList);
		assertEquals("Check that CCA arraylist size is 0", 0, ccaList.size());
		
		// normal
		C206_CaseStudy.addCCA(ccaList, cca1);
		assertEquals("Check that CCA arraylist size is 1", 1, ccaList.size());
		assertSame("Check that CCA is added", cca1, ccaList.get(0));
		
		// normal
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertEquals("Check that Camcorder arraylist size is 2", 2, ccaList.size());
		assertSame("Check that Camcorder is added", cca2, ccaList.get(1));
	}
	@Test
	public void retrieveAllCCATest() { //xixin
		// boundary
		assertNotNull("Test if there is valid CCA arraylist to retrieve cca", ccaList);
		assertEquals("Check that CCA arraylist size is 0", 0, ccaList.size());
		
		// boundary
		String allCCA= C206_CaseStudy.retrieveAllCCA(ccaList);
		String testOutput = "";
		assertEquals("Check that ViewAllCCAlist", testOutput, allCCA);
		
		
		// normal
		C206_CaseStudy.addCCA(ccaList, cca1);
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertEquals("Test that CCA arraylist size is 2", 2, ccaList.size());
		
		// normal
		allCCA= C206_CaseStudy.retrieveAllCCA(ccaList);
		testOutput = String.format("%-20s %-45s %-15s %-15s %-20s %-15s %-15s\n", "Lego Expert", "Designing and building using Lego", 25, 
				"Thursday", "15:00 - 16:00", "Class room A", "Albert");
		testOutput += String.format("%-20s %-45s %-15s %-15s %-20s %-15s %-15s\n","Jewellery Making", "Make a variety of jewellery items",15,
				"Wednesday","15:00 - 16:00", "Class room B", "Malvin");
	
		assertEquals("Test that ViewAllCCAlist", testOutput, allCCA);
		
	}
	
	@Test
	public void deleteCCATest() { // xixin
		//boundary
		assertNotNull("test if there is valid CCA arraylist to delete from", ccaList);
		
		//normal
		C206_CaseStudy.addCCA(ccaList, cca1);
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertEquals("Test that CCA arraylist size is 2", 2, ccaList.size());
		
		//error
		C206_CaseStudy.deleteCCA(ccaList,"Jewellery Making");
		String deleteCCA= C206_CaseStudy.deleteCCA(ccaList,"Jewellery Making");
		String errorMsg = "Invalid CCA title";
		assertEquals("Test that error message invalid CCA title shows if no matching title to delete", errorMsg, deleteCCA);
				
		//normal
		C206_CaseStudy.deleteCCA(ccaList,"Lego Expert");
		assertEquals("Test that after deleting CCA, CCA arraylist is empty",0,ccaList.size());	
	    
		
		assertTrue(ccaList.isEmpty());	
	}
	
	
	@Test
	public void addStudentTest() {// Sean
		//boundary
		assertNotNull("Test if there is valid Student arraylist to add to", studentList);
		assertEquals("Check that student array list is empty", 0,studentList.size());

		//normal
		C206_CaseStudy.addStudent(studentList, stud1);
		assertEquals("Test after student added list has 1 input", 1,studentList.size());
		
		//normal
		assertSame("Check that correct input inserted",stud1, studentList.get(0));
	}
	
	@Test
	public void deleteStudentTest() {// Sean
		//boundary
		assertNotNull("Test if there is valid Student arraylist to delete", studentList);
		assertEquals("Check that student array list is empty", 0,studentList.size());

		//normal
		C206_CaseStudy.addStudent(studentList, stud1);
		assertEquals("Test after student added list has 1 input", 1,studentList.size());
		
		//error
		C206_CaseStudy.deleteStudent(studentList,2);
		String deleteStudent= C206_CaseStudy.deleteStudent(studentList,2);
		String errorMsg = "Invalid student ID";
		assertEquals("Test that error message invalid student id shows if no matching id to delete", errorMsg, deleteStudent);
		
		//normal
		C206_CaseStudy.deleteStudent(studentList,1);
		assertEquals("Test that after deleting student, student array list is empty",0,studentList.size());

	}
	
	@Test
	public void viewStudentTest() {// Sean
		//boundary
		assertNotNull("Test if there is valid Student arraylist to view", studentList);
		assertEquals("Check that student array list is empty", 0,studentList.size());

		//error
		String viewStudent = C206_CaseStudy.adminViewStudent(studentList);
		String result = "Student list is empty";
		assertEquals("Test that if student array list is empty show Student list is empty", viewStudent,result);
		
		//normal
		C206_CaseStudy.addStudent(studentList, stud1);
		assertEquals("Test after student added list has 1 input", 1,studentList.size());
		
		//normal
		viewStudent = C206_CaseStudy.adminViewStudent(studentList);
		result = String.format("%-20s %-20s %-10s %-10s %-10s\n", "Student ID", "Student Name", "Grade",
				"Class", "Teacher");
		result += String.format("%-20d %-20s %-10s %-10s %-10s\n", 1,"John", "P3","C206", "Desmond");
		assertEquals("Test that student inserted correctly",viewStudent,result);

	}
	
	@Test
	public void updateStudentDetailsTest() {// Sean
		assertNotNull("Test if there is valid Student arraylist to update", studentList);

		//normal
		C206_CaseStudy.addStudent(studentList, stud1);
		int studentID = 1;
		String studentGrade = "P1";
		String studentClass = "C209";
		String studentTeacher = "Mike";
		C206_CaseStudy.updateStudentDetails(studentList, studentID, studentGrade, studentClass, studentTeacher);
		
		assertSame("Test that student Grade updated", studentGrade, studentList.get(0).getGrade());
		assertSame("Test that student Class updated", studentClass, studentList.get(0).getClassId());
		assertSame("Test that student Teacher updated", studentTeacher, studentList.get(0).getTeacherName());
	}
	
	@After
	public void tearDown() throws Exception {
		cca1 = null;
		cca2 = null;
		ccaList = null;
	}


}
