package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.developia.springjava13.component.Student;

//hansi classla isleyecek,primary key
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
