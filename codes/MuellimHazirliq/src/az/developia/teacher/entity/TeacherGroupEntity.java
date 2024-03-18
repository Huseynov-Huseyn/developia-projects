package az.developia.teacher.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class TeacherGroupEntity {

	private Integer id;
	private String name;
	private Integer teacherId;
	private LocalDateTime registerDate;
	private Integer paymentDay;

	public TeacherGroupEntity(Integer id, String name, Integer teacherId, LocalDateTime registerDate,
			Integer paymentDay) {
		super();
		this.id = id;
		this.name = name;
		this.teacherId = teacherId;
		this.registerDate = registerDate;
		this.paymentDay = paymentDay;
	}

	public TeacherGroupEntity() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public LocalDateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}

	public Integer getPaymentDay() {
		return paymentDay;
	}

	public void setPaymentDay(Integer paymentDay) {
		this.paymentDay = paymentDay;
	}

	@Override
	public String toString() {
		return "TeacherGroupEntity [id=" + id + ", name=" + name + ", teacherId=" + teacherId + ", registerDate="
				+ registerDate + ", paymentDay=" + paymentDay + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, paymentDay, registerDate, teacherId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherGroupEntity other = (TeacherGroupEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(paymentDay, other.paymentDay) && Objects.equals(registerDate, other.registerDate)
				&& Objects.equals(teacherId, other.teacherId);
	}

}
