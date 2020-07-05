package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Preduslov;
import backend.app.repository.PreduslovRepository;



@Service 
public class PreduslovService {

	@Autowired
	PreduslovRepository preduslovRepo;
	
	public Iterable<Preduslov> getPreduslov() {
		return preduslovRepo.findAll();
	}
	
	public Optional<Preduslov> getPreduslovById(Long id) {
		return preduslovRepo.findById(id);
	}
	
	public void addPreduslov(Preduslov preduslov) {
		preduslovRepo.save(preduslov);
	}
	
	public void removePreduslov(Long id) {
		Optional<Preduslov> pred = preduslovRepo.findById(id);
		if(pred.isPresent()) {
			preduslovRepo.delete(pred.get());
		}
	}
	public void updatePreduslov(Long id, Preduslov preduslov) {
		Optional<Preduslov> pred = preduslovRepo.findById(id);
		if(pred.isPresent()) {
			preduslov.setId(pred.get().getId());
			preduslovRepo.save(preduslov);
		}
	}

}