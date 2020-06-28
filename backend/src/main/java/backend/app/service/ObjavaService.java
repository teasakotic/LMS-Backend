package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Objava;
import backend.app.repository.ObjavaRepository;

@Service 
public class ObjavaService {

	@Autowired
	ObjavaRepository objavaRepo;
	
	public Iterable<Objava> getObjava() {
		return objavaRepo.findAll();
	}
	
	public Optional<Objava> getOne(Long id) {
		return objavaRepo.findById(id);
	}
	
	public void addObjava(Objava objava) {
		objavaRepo.save(objava);
	}
	
	public void removeObjava(Long id) {
		Optional<Objava> objavaa= objavaRepo.findById(id);
		if(objavaa.isPresent()) {
			objavaRepo.delete(objavaa.get());
		}
	}
	
	public void updateObjava(Long id, Objava objava) {
		Optional<Objava> objavaa = objavaRepo.findById(id);
		if(objavaa.isPresent()) {
			objava.setId(objavaa.get().getId());
			objavaRepo.save(objava);
		}
	}

}
