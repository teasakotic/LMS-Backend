package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.NaucnaOblast;

@Repository
public interface NaucnaOblastRepository extends JpaRepository<NaucnaOblast, Long> {

}
