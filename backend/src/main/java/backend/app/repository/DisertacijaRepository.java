package backend.app.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.app.model.Disertacija;

@Repository
public interface DisertacijaRepository extends JpaRepository<Disertacija, Long> {
	
	@Query("SELECT dis.naslov, dis.datumAplikacije, dis.datumOdbrane, dis.fajl.url, "
			+ "dis.mentor.licniPodaci.ime, dis.mentor.licniPodaci.prezime, "
			+ "dis.studentNaGodini.godinaStudija.studijskiProgram.naziv "
			+ "FROM Disertacija dis WHERE dis.studentNaGodini.student.id = ?1") 
	ArrayList<Object> findByStudentNaGodiniStudentId(Long studentId);
	

}
