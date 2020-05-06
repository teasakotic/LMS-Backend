package repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.TelefoniUniverziteta;

@Repository
public interface TelefoniUniverzitetaRepository extends JpaRepository<TelefoniUniverziteta, Long> {
	ArrayList<TelefoniUniverziteta> findByUniverzitetIdEquals(Long id);
}
