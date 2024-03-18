package az.developia.teacher.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import az.developia.teacher.Constants;
import az.developia.teacher.entity.GroupScheduleEntity;

public class GroupScheduleRepository {

	public static void add(GroupScheduleEntity teacher) {
		String query = "INSERT INTO group_schedules " + "(group_id,day,hour) values" + "('" + teacher.getGroupId()
				+ "','" + teacher.getDay() + "','" + teacher.getHour() + "');";

		try {
			Connection conn = DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
			Statement st = conn.createStatement();

			st.executeUpdate(query);

			st.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
