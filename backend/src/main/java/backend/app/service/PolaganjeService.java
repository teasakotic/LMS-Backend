package backend.app.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.EvaluacijaZnanja;
import backend.app.model.Polaganje;
import backend.app.repository.EvaluacijaZnanjaRepository;
import backend.app.repository.PolaganjeRepository;
import backend.app.repository.StudentNaGodiniRepository;

@Service
public class PolaganjeService {

	@Autowired
	private PolaganjeRepository polaganjeRepo;

	@Autowired
	private EvaluacijaZnanjaRepository evaluacijaZnanjaRepo;

	@Autowired
	private StudentNaGodiniRepository syRepo;

	public ArrayList<Polaganje> getRegisterovaneEvaluacijeZnanjaByStudentId(Long studentId) {
		return polaganjeRepo.findRegisterovaneEvaluacijeZnanjaByStudentId(studentId);
	}

	public boolean registerEvaluacijaZnanja(Long evaluacijaZnanjaId, Long realizacijaPredmetaId, String studentUsername) {
		try {
			Long studentNaGodiniId = syRepo.getStudenNaGodiniByRealizacijaPredmetaAndStudent(realizacijaPredmetaId, studentUsername);
			EvaluacijaZnanja evaluacijaZnanja = evaluacijaZnanjaRepo.findById(evaluacijaZnanjaId).get();
			if (studentNaGodiniId != null && evaluacijaZnanja != null) {
				Polaganje er = new Polaganje();
				er.setEvaluacijaZnanja(evaluacijaZnanja);
				er.setNapomena("");
				er.setBodovi(null);
				er.setStudentNaGodini(syRepo.findById(studentNaGodiniId).get());
				polaganjeRepo.saveAndFlush(er);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void add(Polaganje er) {
		polaganjeRepo.save(er);
	}
	
	public Optional<Polaganje> findById(Long id) {
		return polaganjeRepo.findById(id);
	}

	public void updateById(Long id, Polaganje newPolaganje) {
		Optional<Polaganje> er = polaganjeRepo.findById(id);
		if(er.isPresent()) {
			newPolaganje.setId(er.get().getId());
			polaganjeRepo.save(newPolaganje);		
		}
	}

}
