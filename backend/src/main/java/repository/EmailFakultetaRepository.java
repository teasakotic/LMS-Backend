package repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.EmailFakulteta;

@Repository
public interface EmailFakultetaRepository extends JpaRepository<EmailFakulteta, Long> {
	ArrayList<EmailFakulteta> findByFakultetIdEquals(Long id);
}
