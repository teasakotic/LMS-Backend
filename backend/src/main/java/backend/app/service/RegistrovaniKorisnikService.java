package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.RegistrovaniKorisnik;
import backend.app.repository.RegistrovaniKorisnikRepository;

@Service
public class RegistrovaniKorisnikService {

    @Autowired
    private RegistrovaniKorisnikRepository registrovaniKorisnikRepository;

    public RegistrovaniKorisnikService() {
    }

    public Iterable<RegistrovaniKorisnik> getRegistrovaniKorisnik() {
        return registrovaniKorisnikRepository.findAll();
    }

    public Optional<RegistrovaniKorisnik> getRegistrovaniKorisnikById(Long id) {
        return registrovaniKorisnikRepository.findById(id);
    }
    
    public Optional<RegistrovaniKorisnik> getRegistrovaniKorisnikByUsername(String username) {
        return registrovaniKorisnikRepository.findByUsername(username);
    }

    public void addRegistrovaniKorisnik(RegistrovaniKorisnik registrovaniKorisnik) {
    	registrovaniKorisnikRepository.save(registrovaniKorisnik);
    }

    public void removeRegistrovaniKorisnik(Long id) {
        Optional<RegistrovaniKorisnik> registrovaniKorisnik = registrovaniKorisnikRepository.findById(id);
        registrovaniKorisnikRepository.delete(registrovaniKorisnik.get());
    }

    public void updateRegistrovaniKorisnik(Long id, RegistrovaniKorisnik registrovaniKorisnik) {
        Optional<RegistrovaniKorisnik> Acc = registrovaniKorisnikRepository.findById(id);
        if(Acc.isPresent()) {
        	registrovaniKorisnik.setId(Acc.get().getId());
        	registrovaniKorisnikRepository.save(registrovaniKorisnik);
        }
    }

}
