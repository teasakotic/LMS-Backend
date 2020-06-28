package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import backend.app.model.Administrator;
import backend.app.repository.AdministratorRepository;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepo;

    @Autowired
    private LoginService loginServ;
    
    @Autowired
    private RegistrovaniKorisnikService regServ;
    
    @Autowired
	private PasswordEncoder passwordEncoder;
    
    public AdministratorService() {
    }

    public Iterable<Administrator> getAdministrators() {
        return administratorRepo.findAll();
    }

    public Optional<Administrator> getAdministratorById(Long id) {
        return administratorRepo.findById(id);
    }
    
    public Optional<Administrator> getAdministratorByUsername(String username) {
        return administratorRepo.getByUsername(username);
    }

    public void addAdministrator(Administrator administrator) {
    	loginServ.addDozvola(administrator.getRegistrovaniKorisnik(), "ROLE_ADMINISTRATOR");
    	administrator.getRegistrovaniKorisnik().setLozinka(passwordEncoder.encode(administrator.getRegistrovaniKorisnik().getLozinka()));
        administratorRepo.save(administrator);
    }
    
    public void removeAdministrator(Long id) {
        Optional<Administrator> administrator = administratorRepo.findById(id);
        Administrator a = administrator.get();
        a.setObrisan(true);
        administratorRepo.save(a);
    }

    public void updateAdministrator(String username, Administrator administrator) {
        Optional<Administrator> Adm = administratorRepo.getByUsername(username);
        if(Adm.isPresent()) {
            administrator.setId(Adm.get().getId());
            administrator.getRegistrovaniKorisnik().setLozinka(passwordEncoder.encode(administrator.getRegistrovaniKorisnik().getLozinka()));
            regServ.updateRegistrovaniKorisnik(administrator.getRegistrovaniKorisnik().getId(), administrator.getRegistrovaniKorisnik());        
        }
    }

}
