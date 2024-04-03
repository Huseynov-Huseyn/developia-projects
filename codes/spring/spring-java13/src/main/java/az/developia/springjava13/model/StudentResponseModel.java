package az.developia.springjava13.model;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.Data;

@Data
@JsonFilter(value = "student")
//eger bu adi vermisikse restcontrollerda istifade ede bilerik idname get metodundaki student burani temsil edir
public class StudentResponseModel {

	private Integer id;
	private String name;
	private String surname;
	private String username;
	private Integer creatorId;
}