package az.developia.teacher.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



import az.developia.teacher.entity.TeacherEntity;
import az.developia.teacher.exception.OurRuntimeException;

public class TeacherGroupRepository {

	public void add(TeacherEntity teacher) throws OurRuntimeException{
		
		if (teacher.getName().length()>50) {
			throw new OurRuntimeException("ad max 50 simvol ola biler");
		}
		
		if (teacher.getSurname().length()>50) {
			throw new OurRuntimeException("soyad max 50 simvol ola biler");
		}

		// mysqle gonderilen kod hansi ki oraya yazilaraq datalari
		// daxil edeceyik
		String query = "INSERT INTO teachers" 
		+ "(name,surname,phone,address,username,password) values" + "('"
				+ teacher.getName() + "','" + teacher.getSurname() + "','" + teacher.getPhone() + "','"
				+ teacher.getAddress() + "','" + teacher.getUsername() + "','" + teacher.getPassword() + "');";

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java13_teacher?useSSL=false", "root", "1234");
			Statement st = conn.createStatement();

			st.executeUpdate(query);

			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public boolean checkUsernameIfExists(String username){
		
		boolean exists=false;
		
		String query = " ";
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java13_teacher?useSSL=false", "root", "1234");
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT count(*) FROM teachers where username='"+username+"';");

			rs.next();
			exists = rs.getInt(1)==1?true:false;
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return exists;
	}
	
	
	public boolean checkUserIfExists(String username,String password){
		
		boolean exists=false;
		
		String query = " ";
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java13_teacher?useSSL=false", "root", "1234");
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT count(*) FROM teachers where username='"+username+"' and password='"+password+"';");

			rs.next();
			exists = rs.getInt(1)==1?true:false;
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return exists;
	}
}
