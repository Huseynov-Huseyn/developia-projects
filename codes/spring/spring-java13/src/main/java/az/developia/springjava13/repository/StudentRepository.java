package az.developia.springjava13.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import az.developia.springjava13.entity.StudentEntity;

//hansi classla isleyecek,primary key
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	List<StudentEntity> findAllByTeacherId(Integer teacherId);

	@Query(value = "select * from students where name like %?1% and surname like %?2%", nativeQuery = true)
	List<StudentEntity> findAllSearch(String name, String surname);
}
