package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.EvaluacijaZnanjaIshod;
import backend.app.repository.EvaluacijaZnanjaIshodRepository;

@Service 
public class EvaluacijaZnanjaIshodService {

	@Autowired
	EvaluacijaZnanjaIshodRepository evaluacijaZnanjaIshodRepo;
	
	public Iterable<EvaluacijaZnanjaIshod> getEvaluacijaZnanjaIshod() {
		return evaluacijaZnanjaIshodRepo.findAll();
	}
	
	public Optional<EvaluacijaZnanjaIshod> getOne(Long id) {
		return evaluacijaZnanjaIshodRepo.findById(id);
	}
	
	public void addEvaluacijaZnanjaIshod(EvaluacijaZnanjaIshod evaluacijaZnanjaIshod) {
		evaluacijaZnanjaIshodRepo.save(evaluacijaZnanjaIshod);
	}
	
	public void removeEvaluacijaZnanjaIshod(Long id) {
		Optional<EvaluacijaZnanjaIshod> evl = evaluacijaZnanjaIshodRepo.findById(id);
		if(evl.isPresent()) {
			evaluacijaZnanjaIshodRepo.delete(evl.get());
		}
	}
	public void updateEvaluacijaZnanjaIshod(Long id, EvaluacijaZnanjaIshod evaluacijaZnanjaIshod) {
		Optional<EvaluacijaZnanjaIshod> evl = evaluacijaZnanjaIshodRepo.findById(id);
		if(evl.isPresent()) {
			evaluacijaZnanjaIshod.setId(evl.get().getId());
			evaluacijaZnanjaIshodRepo.save(evaluacijaZnanjaIshod);
		}
	}

}
