package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.ObjavaFajl;
import repository.ObjavaFajlRepository;;

@Service
public class ObjavaFajlService {

    @Autowired
    private ObjavaFajlRepository objavaFajlRepo;

    public ObjavaFajlService() {
    }

    public Iterable<ObjavaFajl> getObjavaFajl() {
        return objavaFajlRepo.findAll();
    }

    public Optional<ObjavaFajl> getObjavaFajlById(Long id) {
        return objavaFajlRepo.findById(id);
    }

    public void addObjavaFajl(ObjavaFajl objavaFajl) {
    	objavaFajlRepo.save(objavaFajl);
    }

    public void removeObjavaFajl(Long id) {
        Optional<ObjavaFajl> objavaFajl = objavaFajlRepo.findById(id);
        objavaFajlRepo.delete(objavaFajl.get());
    }

	public void updateObjavaFajl(Long id, ObjavaFajl objavaFajl) {
		Optional<ObjavaFajl> obj = objavaFajlRepo.findById(id);
		if(obj.isPresent()) {
			objavaFajl.setId(obj.get().getId());
			objavaFajlRepo.save(objavaFajl);
		}
	}

}
