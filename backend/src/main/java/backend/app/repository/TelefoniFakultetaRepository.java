package backend.app.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.TelefoniFakulteta;

@Repository
public interface TelefoniFakultetaRepository extends JpaRepository<TelefoniFakulteta, Long> {
	ArrayList<TelefoniFakulteta> findByFakultetIdEquals(Long id);
}
