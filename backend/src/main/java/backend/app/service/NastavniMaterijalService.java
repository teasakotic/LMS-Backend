package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.NastavniMaterijal;
import backend.app.repository.NastavniMaterijalRepository;

@Service
public class NastavniMaterijalService {
	
	@Autowired
    private NastavniMaterijalRepository nastavniMaterijalRepo;

    public NastavniMaterijalService() {
    }

    public Iterable<NastavniMaterijal> getNastavniMaterijal() {
        return nastavniMaterijalRepo.findAll();
    }
    
    public Iterable<Optional<NastavniMaterijal>> getNastavniMaterijalByPredmet(Long id) {
        return nastavniMaterijalRepo.getAllByPredmet(id);
    }

    public Optional<NastavniMaterijal> getNastavniMaterijalById(Long id) {
        return nastavniMaterijalRepo.findById(id);
    }

    public void addNastavniMaterijal(NastavniMaterijal nastavniMaterijal) {
    	nastavniMaterijalRepo.save(nastavniMaterijal);
    }

    public void removeNastavniMaterijal(Long id) {
        Optional<NastavniMaterijal> nastavniMaterijal = nastavniMaterijalRepo.findById(id);
        nastavniMaterijalRepo.delete(nastavniMaterijal.get());
    }

    public void updateNastavniMaterijal(Long id, NastavniMaterijal nastavniMaterijal) {
        Optional<NastavniMaterijal> Tea = nastavniMaterijalRepo.findById(id);
        if(Tea.isPresent()) {
        	nastavniMaterijal.setId(Tea.get().getId());
        	nastavniMaterijalRepo.save(nastavniMaterijal);
        }
    }

}

