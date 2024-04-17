package az.developia.springjava13.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

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

	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd")
//	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//	localdatetime olanda bele edirik
	private LocalDate birthday;
}