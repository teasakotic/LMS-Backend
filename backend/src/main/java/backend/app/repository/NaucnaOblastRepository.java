package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.NaucnaOblast;

@Repository
public interface NaucnaOblastRepository extends JpaRepository<NaucnaOblast, Long> {

}
