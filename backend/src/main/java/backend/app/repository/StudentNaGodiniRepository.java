package backend.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.app.model.StudentNaGodini;

@Repository
public interface StudentNaGodiniRepository extends JpaRepository<StudentNaGodini, Long> {
	Optional<StudentNaGodini> findByGodinaStudijaIdAndStudentId(Long studentNaGodiniId, Long studentId);
	
	@Query("SELECT sy.id FROM StudentNaGodini sy JOIN sy.godinaStudija.realizacijaPredmeta sr "
			+ "WHERE  sr.id = ?1 "
			+ "AND sy.student.registrovaniKorisnik.username = ?2")
	Long getStudenNaGodiniByRealizacijaPredmetaAndStudent(Long realizacijaPredmetaId, String studentUsername);
}