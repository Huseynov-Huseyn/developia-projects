package az.developia.teacher.repository;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.text.html.parser.Entity;

import az.developia.teacher.Constants;
import az.developia.teacher.entity.StudentEntity;
import az.developia.teacher.exception.OurRuntimeException;

public class StudentRepository {
	public static void add(StudentEntity student) {
		String query = "INSERT INTO students " + "(name,surname,phone,birthday) values" + "('" + student.getName()
				+ "','" + student.getSurname() + "','" + student.getPhone() + "','" + student.getBirthday() + "');";

		try {
			Connection conn = DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
			Statement st = conn.createStatement();

			st.executeUpdate(query);

			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void deleteById(int id) {
		String query = "DELETE FROM students WHERE id= " + id;

		try {
			Connection conn = DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
			Statement st = conn.createStatement();

			st.executeUpdate(query);

			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public StudentEntity findById(int id) {
		StudentEntity entity = new StudentEntity();

		try {
			Connection conn = DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM students where id=" + id + "");

			if (rs.next()) {
				entity.setId(rs.getInt("id"));
				entity.setName(rs.getString("name"));
				entity.setSurname(rs.getString("surname"));
				entity.setPhone(rs.getString("phone"));
				entity.setBirthday(rs.getTimestamp("birthday").toLocalDateTime().toLocalDate());
			} else {

			}

			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (entity.getId() == null) {
			throw new OurRuntimeException("muellimin idsi tapilmadi, id= " + id);
		}

		return entity;
	}

	public ArrayList<StudentEntity> findAll() {
		ArrayList<StudentEntity> entities = new ArrayList<StudentEntity>();

		try {
			Connection conn = DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM students");

			while (rs.next()) {
				StudentEntity entity = new StudentEntity();
				entity.setId(rs.getInt("id"));
				entity.setName(rs.getString("name"));
				entity.setSurname(rs.getString("surname"));
				entity.setPhone(rs.getString("phone"));
				entity.setBirthday(rs.getTimestamp("birthday").toLocalDateTime().toLocalDate());
				entities.add(entity);
			}

			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return entities;
	}
}