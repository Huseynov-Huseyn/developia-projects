package az.developia.teacher.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import az.developia.teacher.Constants;
import az.developia.teacher.entity.TeacherEntity;
import az.developia.teacher.entity.TeacherGroupEntity;
import az.developia.teacher.exception.OurRuntimeException;

public class TeacherGroupRepository {

	public void add(TeacherGroupEntity teacher) throws OurRuntimeException {

		// mysqle gonderilen kod hansi ki oraya yazilaraq datalari
		// daxil edeceyik
		String query = "INSERT INTO teacher_groups "+ "(name, teacher_id, register_date, payment_day) values " + "('"
				+ teacher.getName() + "','" + teacher.getTeacherId() + "','" + teacher.getRegisterDate() + "','"
				+ teacher.getPaymentDay() + "');";


		try {
			Connection conn = DriverManager.getConnection(Constants.url,Constants.username, Constants.password);
			Statement st = conn.createStatement();

			st.executeUpdate(query);

			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
