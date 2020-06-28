package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.Univerzitet;

@Repository
public interface UniverzitetRepository extends JpaRepository<Univerzitet, Long> {

}
