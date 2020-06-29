package backend.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import backend.app.model.StudijskiProgram;

@Repository
public interface StudijskiProgramRepository extends JpaRepository<StudijskiProgram, Long> {

}