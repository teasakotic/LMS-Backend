package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Fakultet;
import repository.FakultetRepository;

@Service 
public class FakultetService {

	@Autowired
	FakultetRepository fakultetRepo;
	
	public Iterable<Fakultet> getFakultet() {
		return fakultetRepo.findAll();
	}
	
	public Optional<Fakultet> getOne(Long id) {
		return fakultetRepo.findById(id);
	}
	
	public void addFakultet(Fakultet fakultet) {
		fakultetRepo.save(fakultet);
	}
	
	public void removeFakultet(Long id) {
		Optional<Fakultet> faks = fakultetRepo.findById(id);
		if(faks.isPresent()) {
			fakultetRepo.delete(faks.get());
		}
	}
}
