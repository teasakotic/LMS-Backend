package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.ObjavaFajl;

@Repository
public interface ObjavaFajlRepository extends JpaRepository<ObjavaFajl, Long> {

}
