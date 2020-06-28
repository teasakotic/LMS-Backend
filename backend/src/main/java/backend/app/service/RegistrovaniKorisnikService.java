package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.RegistrovaniKorisnik;
import backend.app.repository.RegistrovaniKorisnikRepository;

@Service
public class RegistrovaniKorisnikService {

    @Autowired
    private RegistrovaniKorisnikRepository regKorisnikRepo;

    public RegistrovaniKorisnikService() {
    }

    public Iterable<RegistrovaniKorisnik> getRegistrovaniKorisnik() {
        return regKorisnikRepo.findAll();
    }

    public Optional<RegistrovaniKorisnik> getRegistrovaniKorisnikById(Long id) {
        return regKorisnikRepo.findById(id);
    }
    
    public Optional<RegistrovaniKorisnik> getRegistrovaniKorisnikByUserName(String username) {
        return regKorisnikRepo.findByUsername(username);
    }

    public void addRegistrovaniKorisnik(RegistrovaniKorisnik registrovaniKorisnik) {
        regKorisnikRepo.save(registrovaniKorisnik);
    }

    public void removeRegistrovaniKorisnik(Long id) {
        Optional<RegistrovaniKorisnik> registrovaniKorisnik = regKorisnikRepo.findById(id);
        regKorisnikRepo.delete(registrovaniKorisnik.get());
    }

    public void updateRegistrovaniKorisnik(Long id, RegistrovaniKorisnik registrovaniKorisnik) {
        Optional<RegistrovaniKorisnik> Acc = regKorisnikRepo.findById(id);
        if(Acc.isPresent()) {
        	registrovaniKorisnik.setId(Acc.get().getId());
            regKorisnikRepo.save(registrovaniKorisnik);
        }
    }

}
