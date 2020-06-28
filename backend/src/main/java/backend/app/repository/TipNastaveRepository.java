package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.TipNastave;

@Repository
public interface TipNastaveRepository extends JpaRepository<TipNastave, Long> {

}
