package az.developia.teacher.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import az.developia.teacher.Constants;
import az.developia.teacher.entity.TeacherGroupEntity;
import az.developia.teacher.exception.OurRuntimeException;

public class TeacherGroupRepository {

	public void add(TeacherGroupEntity teacher) throws OurRuntimeException {

		// mysqle gonderilen kod hansi ki oraya yazilaraq datalari
		// daxil edeceyik
		String query = "INSERT INTO teacher_groups " + "(name,teacher_id,register_date,payment_day) values" + "('"
				+ teacher.getName() + "'," + teacher.getTeacherId() + ",'" + teacher.getRegisterDate() + "',"
				+ teacher.getPaymentDay() + ");";

		try {
			Connection conn = DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
			Statement st = conn.createStatement();

			st.executeUpdate(query);

			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public TeacherGroupEntity findById(Integer id) {

		TeacherGroupEntity entity = new TeacherGroupEntity();

		String query = " ";
		try {
			Connection conn = DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM teacher_groups where id=" + id + "");

			if (rs.next()) {
				entity.setId(rs.getInt("id"));
				entity.setName(rs.getString("name"));
				entity.setTeacherId(rs.getInt("teacher_id"));
				entity.setRegisterDate(rs.getTimestamp("register_date").toLocalDateTime());
				entity.setPaymentDay(rs.getInt("payment_day"));
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

	public void deleteById(Integer id) throws OurRuntimeException {

		String query = "delete from teacher_groups where teacher_id=" + id;
		try {
			Connection conn = DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
			Statement st = conn.createStatement();

			st.executeUpdate(query);
			conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<TeacherGroupEntity> findByAll(Integer id) throws OurRuntimeException {
		ArrayList<TeacherGroupEntity> entities = new ArrayList<TeacherGroupEntity>();

		String query = "SELECT * FROM teacher_groups where teacher_id=" + id;

		try {
			Connection conn = DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				TeacherGroupEntity entity = new TeacherGroupEntity();
				entity.setId(rs.getInt("id"));
				entity.setName(rs.getString("name"));
				entity.setTeacherId(rs.getInt("teacher_id"));
				entity.setRegisterDate(rs.getTimestamp("register_date").toLocalDateTime());
				entity.setPaymentDay(rs.getInt("payment_day"));
				entities.add(entity);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return entities;
	}
}
