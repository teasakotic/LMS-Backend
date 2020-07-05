package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Autor;
import backend.app.repository.AutorRepository;


@Service 
public class AutorService {

	@Autowired
	AutorRepository autorRepo;
	
	public Iterable<Autor> getAutor() {
		return autorRepo.findAll();
	}
	
	public Optional<Autor> getAutorById(Long id) {
		return autorRepo.findById(id);
	}
	
	public void addAutor(Autor autor) {
		autorRepo.save(autor);
	}
	
	public void removeAutor(Long id) {
		Optional<Autor> aut = autorRepo.findById(id);
		if(aut.isPresent()) {
			autorRepo.delete(aut.get());
		}
	}
	public void updateAutor(Long id, Autor autor) {
		Optional<Autor> aut = autorRepo.findById(id);
		if(aut.isPresent()) {
			autor.setId(aut.get().getId());
			autorRepo.save(autor);
		}
	}

}