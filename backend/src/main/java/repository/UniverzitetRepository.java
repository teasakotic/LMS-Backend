package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Univerzitet;

@Repository
public interface UniverzitetRepository extends JpaRepository<Univerzitet, Long> {

}
