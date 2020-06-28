package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.Zvanje;

@Repository
public interface ZvanjeRepository extends JpaRepository<Zvanje, Long> {

}
