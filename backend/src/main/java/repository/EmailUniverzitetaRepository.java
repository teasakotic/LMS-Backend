package repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.EmailUniverziteta;

@Repository
public interface EmailUniverzitetaRepository extends JpaRepository<EmailUniverziteta, Long> {
	ArrayList<EmailUniverziteta> findByUniverzitetIdEquals(Long id);
}
