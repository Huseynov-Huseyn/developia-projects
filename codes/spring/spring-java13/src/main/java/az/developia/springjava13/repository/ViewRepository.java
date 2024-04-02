package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.developia.springjava13.entity.DemoEntity;

//hansi classla isleyecek,primary key
@Repository
public interface ViewRepository extends JpaRepository<DemoEntity, Integer> {

}
