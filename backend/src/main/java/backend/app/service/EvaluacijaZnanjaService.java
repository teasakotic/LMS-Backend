package backend.app.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.EvaluacijaZnanja;
import backend.app.model.EvaluacijaZnanjaIshod;
import backend.app.model.TipEvaluacije;
import backend.app.repository.EvaluacijaZnanjaRepository;
import backend.app.repository.TipEvaluacijeRepository;
import backend.app.dto.EvaluacijaZnanjaDTO;

@Service
public class EvaluacijaZnanjaService {

	@Autowired
	private EvaluacijaZnanjaRepository evaluacijaZnanjaRepo;
	@Autowired
	private TipEvaluacijeRepository tipEvaluacijeRepo;
	@Autowired
	private EvaluacijaZnanjaIshodService evaluacijaZnanjaIshodService;


	public EvaluacijaZnanjaService() {
	}

	public Iterable<EvaluacijaZnanja> getEvaluacijaZnanja() {
		return evaluacijaZnanjaRepo.findAll();
	}

	public Optional<EvaluacijaZnanja> getEvaluacijaZnanjaById(Long id) {
		return evaluacijaZnanjaRepo.findById(id);
	}

	@Transactional
	public void addEvaluacijaZnanja(EvaluacijaZnanja evaluacijaZnanja) {
		EvaluacijaZnanja e = new EvaluacijaZnanja(evaluacijaZnanja.getVremePocetka(), evaluacijaZnanja.getVremeZavrsetka(), evaluacijaZnanja.getBodovi(), evaluacijaZnanja.getTrajanjeUMinutima(),
				evaluacijaZnanja.getRealizacijaPredmeta(), evaluacijaZnanja.getTipEvaluacije(), evaluacijaZnanja.getPolaganje(), evaluacijaZnanja.getSilabus());
		e.setSilabus(null);
		e.setId(evaluacijaZnanjaRepo.save(e).getId());
		for (EvaluacijaZnanjaIshod evaluacijaZnanjaIshod : evaluacijaZnanja.getSilabus()) {
			evaluacijaZnanjaIshod.setEvaluacijaZnanja(e);
			evaluacijaZnanjaIshodService.addEvaluacijaZnanjaIshod(evaluacijaZnanjaIshod);
		}
	}

	public void removeEvaluacijaZnanja(Long id) {
		Optional<EvaluacijaZnanja> evaluacijaZnanja = evaluacijaZnanjaRepo.findById(id);
		evaluacijaZnanjaRepo.delete(evaluacijaZnanja.get());
	}

	public void updateEvaluacijaZnanja(Long id, EvaluacijaZnanja evaluacijaZnanja) {
		Optional<EvaluacijaZnanja> e = evaluacijaZnanjaRepo.findById(id);
		if (e.isPresent()) {
			evaluacijaZnanja.setId(e.get().getId());
			evaluacijaZnanjaRepo.save(evaluacijaZnanja);
		}
	}

	public Iterable<TipEvaluacije> getTipEvaluacije() {
		return tipEvaluacijeRepo.findAll();
	}

	public ArrayList<EvaluacijaZnanjaDTO> getEvaluacijaZnanjaByStudent(Long studentId) {
	
		ArrayList<Object[]> fetched = evaluacijaZnanjaRepo.getEvaluacijaZnanjaByStudent(studentId);
		ArrayList<EvaluacijaZnanjaDTO> results = new ArrayList<EvaluacijaZnanjaDTO>();
		try {
			if (fetched != null && fetched.size() > 0) {
				for (int i = 0; i < fetched.size(); i++) {
					results.add(new EvaluacijaZnanjaDTO( (int) fetched.get(i)[0], (String) fetched.get(i)[1], (int) fetched.get(i)[2],
							(String) fetched.get(i)[3], (int) fetched.get(i)[4], (Date) fetched.get(i)[5],
							(int) fetched.get(i)[6]) );
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		

		return results;
	}


}
