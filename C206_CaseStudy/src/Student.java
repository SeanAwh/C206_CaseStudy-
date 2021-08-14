// Student class Sean
public class Student {
	private int id;
	private String studentName;
	private String grade;
	private String classId;
	private String teacherName;
	private String parentName;
	private String email;
	private int number;
	private String uniqueId;
	
	////////// parent register constructor //////////
	public Student(int id, String studentName, String grade, String classId, String teacherName, String parentName,
			String email, int number, String uniqueId) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.grade = grade;
		this.classId = classId;
		this.teacherName = teacherName;
		this.parentName = parentName;
		this.email = email;
		this.number = number;;
	}

	////////// student register constructor //////////
	public Student(int id, String studentName, String grade, String classId, String teacherName, String uniqueId) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.grade = grade;
		this.classId = classId;
		this.teacherName = teacherName;
		this.uniqueId = uniqueId;
	}
	
	////////// add student constructor //////////
	public Student(int id, String studentName, String grade, String classId, String teacherName) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.grade = grade;
		this.classId = classId;
		this.teacherName = teacherName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
}
