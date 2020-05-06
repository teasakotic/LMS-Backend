package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Uloga;

@Repository
public interface UlogaRepository extends JpaRepository<Uloga, Long> {

}
