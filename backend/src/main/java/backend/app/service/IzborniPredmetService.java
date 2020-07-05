package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.IzborniPredmet;
import backend.app.repository.IzborniPredmetRepository;


@Service 
public class IzborniPredmetService {

	@Autowired
	IzborniPredmetRepository izborniPredmetRepo;
	
	public Iterable<IzborniPredmet> getIzborniPredmet() {
		return izborniPredmetRepo.findAll();
	}
	
	public Optional<IzborniPredmet> getIzborniPredmetById(Long id) {
		return izborniPredmetRepo.findById(id);
	}
	
	public void addIzborniPredmet(IzborniPredmet izborniPredmet) {
		izborniPredmetRepo.save(izborniPredmet);
	}
	
	public void removeIzborniPredmet(Long id) {
		Optional<IzborniPredmet> ip = izborniPredmetRepo.findById(id);
		if(ip.isPresent()) {
			izborniPredmetRepo.delete(ip.get());
		}
	}
	public void updateIzborniPredmet(Long id, IzborniPredmet izborniPredmet) {
		Optional<IzborniPredmet> ip = izborniPredmetRepo.findById(id);
		if(ip.isPresent()) {
			izborniPredmet.setId(ip.get().getId());
			izborniPredmetRepo.save(izborniPredmet);
		}
	}

}