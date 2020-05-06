package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Objava;

@Repository
public interface ObjavaRepository extends JpaRepository<Objava, Long> {

}
