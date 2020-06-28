package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.LicniPodaci;
import backend.app.repository.LicniPodaciRepository;

@Service
public class LicniPodaciService {

    @Autowired
    private LicniPodaciRepository licniPodaciRepo;

    public LicniPodaciService() {
    }

    public Iterable<LicniPodaci> getLicniPodaci() {
        return licniPodaciRepo.findAll();
    }

    public Optional<LicniPodaci> getLicniPodaciById(Long id) {
        return licniPodaciRepo.findById(id);
    }
    
    public Optional<LicniPodaci> getLicniPodaciByUsername(String username) {
        return licniPodaciRepo.getByUsername("%/"+username+".%");
    }

    public void addLicniPodaci(LicniPodaci licniPodaci) {
    	licniPodaciRepo.save(licniPodaci);
    }

    public void removeLicniPodaci(Long id) {
        Optional<LicniPodaci> licniPodaci = licniPodaciRepo.findById(id);
        licniPodaciRepo.delete(licniPodaci.get());
    }

    public void updateLicniPodaci(Long id, LicniPodaci licniPodaci) {
        Optional<LicniPodaci> lic = licniPodaciRepo.findById(id);
        if(lic.isPresent()) {
        	licniPodaci.setId(lic.get().getId());
        	licniPodaciRepo.save(licniPodaci);
        }
    }

}
