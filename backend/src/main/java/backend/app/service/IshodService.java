package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Ishod;
import backend.app.repository.IshodRepository;

@Service
public class IshodService {

    @Autowired
    private IshodRepository ishodRepo;

    public IshodService() {
    }

    public Iterable<Ishod> getIshod() {
        return ishodRepo.findAll();
    }
    
    public Iterable<Optional<Ishod>> getIshodByPredmetId(Long id) {
        return ishodRepo.findByPredmetId(id);
    }

    public Optional<Ishod> getIshodById(Long id) {
        return ishodRepo.findById(id);
    }

    public Ishod addIshod(Ishod ishod) {
        return ishodRepo.save(ishod);
    }

    public void removeIshod(Long id) {
        Optional<Ishod> ishod = ishodRepo.findById(id);
        Ishod i = ishod.get();
        i.setObrisan(true);
        ishodRepo.save(i);
    }

    public void updateIshod(Long id, Ishod ishod) {
        Optional<Ishod> Ish = ishodRepo.findById(id);
        if(Ish.isPresent()) {
        	ishod.setId(Ish.get().getId());
        	ishodRepo.save(ishod);
        }
    }

}
