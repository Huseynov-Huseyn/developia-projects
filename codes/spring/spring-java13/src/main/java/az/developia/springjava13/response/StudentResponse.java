package az.developia.springjava13.response;

import java.util.List;

import az.developia.springjava13.component.Student;
import lombok.Data;

public class StudentResponse {
	private List<Student> students;
	private String username;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
