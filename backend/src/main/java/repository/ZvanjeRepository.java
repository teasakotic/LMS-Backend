package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Zvanje;

@Repository
public interface ZvanjeRepository extends JpaRepository<Zvanje, Long> {

}
