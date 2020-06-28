package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {

}
