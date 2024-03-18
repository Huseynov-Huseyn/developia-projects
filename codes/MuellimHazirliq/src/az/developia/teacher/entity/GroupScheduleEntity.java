package az.developia.teacher.entity;

import java.time.LocalTime;
import java.util.Objects;

public class GroupScheduleEntity {
	private Integer id;
	private Integer groupId;
	private Integer Day;
	private LocalTime hour;

	public GroupScheduleEntity(Integer id, Integer groupId, Integer day, LocalTime hour) {
		super();
		this.id = id;
		this.groupId = groupId;
		Day = day;
		this.hour = hour;
	}

	public GroupScheduleEntity() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getDay() {
		return Day;
	}

	public void setDay(Integer day) {
		Day = day;
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	@Override
	public String toString() {
		return "GroupScheduleEntity [id=" + id + ", groupId=" + groupId + ", Day=" + Day + ", hour=" + hour + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Day, groupId, hour, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupScheduleEntity other = (GroupScheduleEntity) obj;
		return Objects.equals(Day, other.Day) && Objects.equals(groupId, other.groupId)
				&& Objects.equals(hour, other.hour) && Objects.equals(id, other.id);
	}

}
