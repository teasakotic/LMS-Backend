package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Tema;
import repository.TemaRepository;

@Service 
public class TemaService {

	@Autowired
	TemaRepository temaRepo;
	
	public Iterable<Tema> getTema() {
		return temaRepo.findAll();
	}
	
	public Optional<Tema> getOne(Long id) {
		return temaRepo.findById(id);
	}
	
	public void addTema(Tema tema) {
		temaRepo.save(tema);
	}
	
	public void removeTema(Long id) {
		Optional<Tema> tem = temaRepo.findById(id);
		if(tem.isPresent()) {
			temaRepo.delete(tem.get());
		}
	}
	
	public void updateTema(Long id, Tema tema) {
		Optional<Tema> tem = temaRepo.findById(id);
		if(tem.isPresent()) {
			tema.setId(tem.get().getId());
			temaRepo.save(tema);
		}
	}

}
