package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.Drzava;

@Repository
public interface DrzavaRepository extends JpaRepository <Drzava, Long> {

}
